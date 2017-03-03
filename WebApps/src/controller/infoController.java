package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import models.FileUploadService;
import models.infoDao;
import models.shareDao;

@Controller
@RequestMapping("/info")
public class infoController {
	@Autowired
	ServletContext application;
	@Autowired
	infoDao iDao;
	@Autowired
	FileUploadService fs;
	
	@RequestMapping("/info")
	public ModelAndView infoHandler(HttpSession session){
		String id = (String)session.getAttribute("auth_id"); 
		List<HashMap> val = iDao.readOne(id);
		
		ModelAndView mav = new ModelAndView();
			mav.setViewName("t_info");
			mav.addObject(val);
		
		return mav;
	}
	@RequestMapping("/infoAjax")
	@ResponseBody
	public ModelAndView infoAjaxHandler(@RequestParam HashMap map, HttpSession session){
		int rst = iDao.updateOne(map);
		ModelAndView mav = new ModelAndView();
		if(rst==1) {
			mav = new ModelAndView("/info/infoAjax");
			mav.addObject("msg", "수정이 완료 되었습니다. 2초 뒤 화면이 전환됩니다.");
			System.out.println("수정 성공");	
			return mav;
		}else {
			mav = new ModelAndView("/info/infoAjax");
			mav.addObject("msg", "수정이 실패하였습니다. 2초 뒤 화면이 전환됩니다.");
			System.out.println("수정 실패");
			return mav;	
		}
	}
}
