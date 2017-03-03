package controller;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/share1")
public class examShareController {

	@RequestMapping("/form1")
	public ModelAndView formHandler() {

		return new ModelAndView("/share/form");
	}

	@Autowired
	ServletContext application; // 어플리케이션 쓰는 
	
	@RequestMapping("/proc1")
	public ModelAndView procHandler(@RequestParam(name = "info") String info,
			@RequestParam(name = "item") MultipartFile file) throws Exception {
		
		// 컨트롤러쪽에서 해당 파람을 MultipartFile 객체로 받아내면 된다.
		// 만약,  MultipartFile로 요구한 파람이 type="file"이 아니면 에러가 발생
		// Map 으로 받을시, 파일 제외한 나머지 파람이 Map에 설정됨.

		// 업로드 처리는 별개다.
		// 일단 분석해서 얻어낼수 있는 정보들은 아래와 같다.
		boolean empty = file.isEmpty();	// 파일 있냐 없냐..
		System.out.println("isEmpty == " +empty);
		String name = file.getName();	// 파라미터명 확인 (X)
		System.out.println("getName == " +name);
		long size = file.getSize();		// 파일크기..(바이트)
		System.out.println("getSize == " +size);
		String orgName = file.getOriginalFilename();	// 실제 파일이름..
		System.out.println("getOriginalFilename == " +orgName);
		String content = file.getContentType();	// 파일 포맷
		System.out.println("getContentType == " +content);
		
		// sysout.. 출력을 진행해보시고, 어떤건지.. 확인.
		// 업로드를 하고 싶은 곳에 파일아웃을 시키면 된다.
		// 서버측 플젝 웹컨텐츠 아래로 업로드 처리를 진행하게 되니까
		String path = application.getRealPath("/share");	// 업로드하고 싶은 실 경로를 구하고
		File dir = new File(path);
		if(dir.exists())		// 경로는 없다면 Exception 발생하니까
			dir.mkdirs();	// 디렉토리 생성하고
		
		// 옮겨둘 파일에 아웃을 만들고 read(),, write() 작업
		long time = System.currentTimeMillis();
		File dest = new File(path, time+orgName);		// 있다면 겹침. 중복을 피하는 건 요령껏
			// 만약에 원본이름이 다시 사용되어야 된다고 생각하면, 따로 저장을 해둘 것
		file.transferTo(dest); 	// 원리는 같다 복제 원리임  속도가 훨씬 빠름
		// InputStream is = file.getInputStream();
		
		// Thread.sleep(5000);
		return new ModelAndView("");
	}
	public void getApplicationObj(HttpSession session){
		ServletContext ctx = session.getServletContext();
	}
}
