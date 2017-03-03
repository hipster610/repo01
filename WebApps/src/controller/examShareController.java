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
	ServletContext application; // ���ø����̼� ���� 
	
	@RequestMapping("/proc1")
	public ModelAndView procHandler(@RequestParam(name = "info") String info,
			@RequestParam(name = "item") MultipartFile file) throws Exception {
		
		// ��Ʈ�ѷ��ʿ��� �ش� �Ķ��� MultipartFile ��ü�� �޾Ƴ��� �ȴ�.
		// ����,  MultipartFile�� �䱸�� �Ķ��� type="file"�� �ƴϸ� ������ �߻�
		// Map ���� ������, ���� ������ ������ �Ķ��� Map�� ������.

		// ���ε� ó���� ������.
		// �ϴ� �м��ؼ� ���� �ִ� �������� �Ʒ��� ����.
		boolean empty = file.isEmpty();	// ���� �ֳ� ����..
		System.out.println("isEmpty == " +empty);
		String name = file.getName();	// �Ķ���͸� Ȯ�� (X)
		System.out.println("getName == " +name);
		long size = file.getSize();		// ����ũ��..(����Ʈ)
		System.out.println("getSize == " +size);
		String orgName = file.getOriginalFilename();	// ���� �����̸�..
		System.out.println("getOriginalFilename == " +orgName);
		String content = file.getContentType();	// ���� ����
		System.out.println("getContentType == " +content);
		
		// sysout.. ����� �����غ��ð�, �����.. Ȯ��.
		// ���ε带 �ϰ� ���� ���� ���Ͼƿ��� ��Ű�� �ȴ�.
		// ������ ���� �������� �Ʒ��� ���ε� ó���� �����ϰ� �Ǵϱ�
		String path = application.getRealPath("/share");	// ���ε��ϰ� ���� �� ��θ� ���ϰ�
		File dir = new File(path);
		if(dir.exists())		// ��δ� ���ٸ� Exception �߻��ϴϱ�
			dir.mkdirs();	// ���丮 �����ϰ�
		
		// �Űܵ� ���Ͽ� �ƿ��� ����� read(),, write() �۾�
		long time = System.currentTimeMillis();
		File dest = new File(path, time+orgName);		// �ִٸ� ��ħ. �ߺ��� ���ϴ� �� ��ɲ�
			// ���࿡ �����̸��� �ٽ� ���Ǿ�� �ȴٰ� �����ϸ�, ���� ������ �ص� ��
		file.transferTo(dest); 	// ������ ���� ���� ������  �ӵ��� �ξ� ����
		// InputStream is = file.getInputStream();
		
		// Thread.sleep(5000);
		return new ModelAndView("");
	}
	public void getApplicationObj(HttpSession session){
		ServletContext ctx = session.getServletContext();
	}
}
