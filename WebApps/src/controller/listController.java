package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import models.listDao;

@Controller
@RequestMapping("/board")
public class listController {
	List<Map> li;
	
	@Autowired
	listDao lDao;
	
	@PostConstruct
	public void init(){
		li = new ArrayList<>();
	}
	
	@RequestMapping("/list")
	public ModelAndView listHandler(HttpSession session, HttpServletRequest req){
		List<HashMap> list = lDao.readAll();

		int cnt = lDao.getArticlesCount();
		int size = cnt % 5 == 0 ? cnt / 5 : cnt / 5 + 1; 
		 
		String pStr = req.getParameter("page") == null ? "1" : req.getParameter("page");
		int start = (Integer.parseInt(pStr) -1 ) *5 +1; 
		int end = Integer.parseInt(pStr) *5;
		HashMap map = new HashMap();
			map.put("start", start);
			map.put("end", end);;
			
		List<HashMap> lists = lDao.getSelectPage(map);
		
		ModelAndView mav = new ModelAndView();
			mav.setViewName("t_boardList");
			mav.addObject("cnt", cnt);
			mav.addObject("size", size);
			mav.addObject("page", pStr);
			mav.addObject("all", lists);
			
		return mav;
	}
	@RequestMapping("/write")
	public ModelAndView writeHandler(){
		ModelAndView mav = new ModelAndView();
			mav.setViewName("t_write");
		return mav;
	}
	@RequestMapping("/writeAjax")
	@ResponseBody
	public ModelAndView submitHandler(@RequestParam HashMap map, HttpSession session) {
		ModelAndView mav = null;	
		int rst = lDao.createOne(map);
		System.out.println(rst);
		if(rst==1) {
			mav = new ModelAndView("/board/writeAjax");
			mav.addObject("msg", "등록이 완료 되었습니다. 2초 뒤 화면이 전환됩니다.");
			System.out.println("등록 성공");	
			return mav;
		}else {
			mav = new ModelAndView("/board/writeAjax");
			mav.addObject("msg", "등록이 실패하였습니다. 2초 뒤 화면이 전환됩니다.");
			System.out.println("등록 실패");
			return mav;	
		}
	}
	@RequestMapping("selectList")
	@ResponseBody
	public ModelAndView selectHandler(@RequestParam(name="num") int num){
		List<HashMap> list = lDao.getSelectFreeBoard(num);
		System.out.println(list.toString());
		ModelAndView mav = new ModelAndView();	
			mav.setViewName("t_selectList");
			mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping("updateAjax")
	public ModelAndView updateHandler(@RequestParam HashMap map, HttpSession session){
		int rst = lDao.update(map);
		ModelAndView mav = new ModelAndView();
		if(rst==1) {
			mav = new ModelAndView("/board/updateAjax");
			mav.addObject("msg", "수정이 완료 되었습니다. 2초 뒤 화면이 전환됩니다.");
			System.out.println("수정 성공");	
			return mav;
		}else {
			mav = new ModelAndView("/board/updateAjax");
			mav.addObject("msg", "수정이 실패하였습니다. 2초 뒤 화면이 전환됩니다.");
			System.out.println("수정 실패");
			return mav;	
		}
	}
}
