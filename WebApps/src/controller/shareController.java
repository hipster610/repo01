package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import models.FileUploadService;
import models.shareDao;

@Controller
@RequestMapping("/share")
public class shareController {
	@Autowired
	ServletContext application;
	@Autowired
	shareDao sDao;
	@Autowired
	FileUploadService fs;
	
	@RequestMapping("/down")
	public ModelAndView downHandler(@RequestParam(name="num") int num) {
		sDao.increaseCount(num);
		Map map = sDao.readOne(num);
		
		ModelAndView mav = new ModelAndView("downView");
			mav.addObject("target", map);
		
		return mav;
	}
	
	@RequestMapping("/form")
	public ModelAndView formHandler(){
		return new ModelAndView("t_share");
	}
	@RequestMapping("/list")
	@ResponseBody
	public ModelAndView listHandler(HttpSession session){
		List<HashMap> list = sDao.readAll();
		ModelAndView mav = new ModelAndView();
			mav.setViewName("t_shareList");
			mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping("/proc")
	public ModelAndView procHandler(@RequestParam(name = "info") String info,
			@RequestParam(name = "item") MultipartFile file) throws Exception {
			ModelAndView mav = null;
			HashMap map = fs.execute(file);
				map.put("title", info);
				// map.putAll(map); 맵끼리 합체
				
			int rst = sDao.createOne(map);
			if(rst==1) {
				mav = new ModelAndView("/share/proc");
				mav.addObject("msg", "등록이 완료 되었습니다. 2초 뒤 화면이 전환됩니다.");
				System.out.println("등록 성공");	
				return mav;
			}else {
				mav = new ModelAndView("/share/proc");
				mav.addObject("msg", "등록이 실패하였습니다. 2초 뒤 화면이 전환됩니다.");
				System.out.println("등록 실패");
				return mav;	
			}
	}
	public void getApplicationObj(HttpSession session){
		ServletContext ctx = session.getServletContext();
	}
}
