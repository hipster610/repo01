package controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import models.MemberDao;

@Controller
@RequestMapping("/memberInfo")
public class memberInfoController {
	@Autowired
	MemberDao mDao;
	
	@RequestMapping("/info")
	public ModelAndView writeHandler(){
		List<HashMap> ageList = mDao.ageGroup();
		List<HashMap> genderList = mDao.genderGroup();
		List<HashMap> ageLogin = mDao.ageLogin();
		List<HashMap> genderLogin = mDao.genderLogin();
		
		ModelAndView mav = new ModelAndView("t_memberInfo");
			mav.addObject("ageList", ageList);
			mav.addObject("genderList", genderList);
			mav.addObject("ageLogin", ageLogin);
			mav.addObject("genderLogin", genderLogin);
		return mav;
	}
}
