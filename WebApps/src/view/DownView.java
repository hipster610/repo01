package view;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

@Component
public class DownView extends AbstractView {
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map map = (Map)model.get("target");
		System.out.println(map);
		response.setHeader("Content-Disposition", "attachment;filename=\""+map.get("FILENAME")+"\""); 	// 응답을 할 때 헤더를 설정 
		
		OutputStream os = response.getOutputStream();	 	// 내보낼 통로를 여는 역할
		String address =(String)map.get("FILEADDRESS");	 	// 실제 파일 경로 값 
		InputStream is = new FileInputStream(new File(address));  // 파일을 가져와서 인풋스트림으로 읽어옴
		
		FileCopyUtils.copy(is, os);		// 인풋스트림한 파일을 아웃풋 스트림하는 복사개념
	}
}
