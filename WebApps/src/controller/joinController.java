package controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import models.MemberDao;

@Controller
@RequestMapping("/join")
public class joinController {
	@Autowired
	MemberDao mDao;
	
	@RequestMapping("/step01")
	public ModelAndView step1Handle(){
		ModelAndView mav = new ModelAndView();
			mav.setViewName("t_join01");
		return mav;
	}
	@RequestMapping(value="/step02", method=RequestMethod.POST)
	public ModelAndView step2Handle(HttpServletRequest req, HttpSession session){
	
		String id = (String)req.getParameter("id");
		String pass = (String)req.getParameter("pass");

		System.out.println(id);
		System.out.println(pass);
		
		session.setAttribute("id", id);
		session.setAttribute("pass", pass);		

		ModelAndView mav = new ModelAndView();
			mav.setViewName("t_join02");
		return mav;
	}
	@RequestMapping(value="/check", method=RequestMethod.POST)
	public ModelAndView insertHandle(HttpServletRequest req, HttpSession session){
		String id = (String)session.getAttribute("id");
		String pass = (String)session.getAttribute("pass");
		String name = (String)req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String gender = (String)req.getParameter("gender");
		String email = (String)req.getParameter("email");
		 
		System.out.println(id);
		System.out.println(pass);
		System.out.println(name);
		System.out.println(age);
		System.out.println(gender);
		System.out.println(email);
		
		HashMap<String, Object> map = new HashMap<>();	
			map.put("ID", id);
			map.put("PASS", pass);
			map.put("NAME", name);
			map.put("AGE", age);
			map.put("GENDER", gender);
			map.put("EMAIL", email);
			
		ModelAndView mav = null;
		int rst = mDao.addMember(map);
		
		if(rst==1) {
			mav = new ModelAndView("/join/check");
			mav.addObject("msg", "����� �Ϸ� �Ǿ����ϴ�. 2�� �� ȭ���� ��ȯ�˴ϴ�.");
			System.out.println("��� ����");	
			return mav;
			
		}else {
			mav = new ModelAndView("/join/check");
			mav.addObject("msg", "����� �����Ͽ����ϴ�. 2�� �� ȭ���� ��ȯ�˴ϴ�.");
			System.out.println("��� ����");
			return mav;
			
		}
	}
	@RequestMapping("/checkAjax")
	@ResponseBody	// ���ϵǴ� �� ���� SpringDispatcher���� ���̸����� �������� �ʰ�,
							// �ٷ� �������� ����Ѵ�.
							// �ѱ� ��� X
							// ��� Converter�� ����ϸ� �ѱ���µ� �����ϰ�, ��Ÿ ����� ȿ���� �� ���� �ִ�.
	public String cAjaxHandler(@RequestParam(name="id") String id) {
		ModelAndView mav = new ModelAndView("t_join02");
		// boolean rst = mdao.useAvailableCheck(id);
		boolean rst = true;	// false;
		// 'YYYYY' or 'NNNNN'  �̷� ���ڸ� ������ָ� �ȴ�.
		if(rst) 
			return "YYYYY";
		else
			return "NNNNN";
	}
}
