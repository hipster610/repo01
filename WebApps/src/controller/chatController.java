package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/chat")
public class chatController {
	List<Map> li;
	@PostConstruct
	public void init(){
		li = new ArrayList<>();
	}
	@RequestMapping("/open")
	public ModelAndView openHandler() {
		ModelAndView mav = new ModelAndView("chat/main");
		return mav;
	}
	@RequestMapping("/chatAjax")
	@ResponseBody
	public String chatHandler(@RequestParam(name="msg") String msg, HttpSession session) {
		Map map = new HashMap();
			map.put("id", session.getAttribute("auth_id"));
			map.put("msg", msg);
		li.add(map);
		return "true";
	}
	@RequestMapping("/logAjax")
	@ResponseBody
	public List logHandler(){
		return li;
	}
}



