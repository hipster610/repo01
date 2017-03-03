package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class mainController {
	@RequestMapping("")
	public ModelAndView mainHandle(){
		ModelAndView mav = new ModelAndView();
			mav.setViewName("t_index");
		return mav;
	}
}
