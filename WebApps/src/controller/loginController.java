package controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import models.MemberDao;

@Controller
@RequestMapping("/login")
public class loginController {
	@Autowired
	MemberDao mDao;
	
	@RequestMapping("/login")
	public ModelAndView loginHandle(){
		ModelAndView mav = new ModelAndView();
			mav.setViewName("t_login");
			mav.addObject("title", "login");
			mav.addObject("main", "login");
		return mav;
	}
	@RequestMapping("/idchecker")
	public ModelAndView idCheckerHandle(@RequestParam Map map, HttpSession session, @RequestParam(name="keep", defaultValue="off") String val, HttpServletResponse resp){
		ModelAndView mav = new ModelAndView();
		System.out.println(map.toString());
		boolean b = mDao.checkMember(map);
		System.out.println(b);
		if (b) {
			String id = (String)map.get("id");
			int r = mDao.addLogin(id);
			System.out.println(r);
			
			session.setAttribute("auth_id", map.get("id"));
			session.setAttribute("auth", "yes");
			if (val.equals("on")) {
				Cookie c = new Cookie("save", (String)map.get("id")); // 밸류에는 계정정보가 있어야 함.
				c.setMaxAge(60 * 60 * 24 * 7);
				c.setPath("/");
				resp.addCookie(c);
			}
			mav.setViewName("redirect:/");
		}else {
			mav.setViewName("redirect:/login/login");
		}
		return mav;
	}
	@RequestMapping("/logout")
	public ModelAndView logoutHandler(HttpSession session, HttpServletResponse resp){
		ModelAndView mav = new ModelAndView();
		
		session.removeAttribute("auth_id");
		session.removeAttribute("auth");
		
		Cookie c = new Cookie("save", "bomb");
			c.setPath("/");
			c.setMaxAge(0);
		resp.addCookie(c);
		
		mav = new ModelAndView("/login/logout");
		mav.addObject("msg", "로그아웃 되었습니다. 2초 뒤 화면이 전환됩니다.");
		System.out.println("등록 성공");
		
		return mav;
	}
}
