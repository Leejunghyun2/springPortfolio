package com.LJH.springPortfolio._common;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.tika.Tika;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class MultipartUpload {
	String attachPath = Constants.ATTACH_PATH;
	int maxUpload = Constants.MAX_UPLOAD;

	/*
	 * server.xml <Context docBase="C:\LJH\attach" path="/springStudy/attach"
	 * reloadable="true"/>
	 */

	private int createDirectory(String uploadPath) {
		File isDir = new File(uploadPath);
		if (!isDir.isDirectory()) {
			isDir.mkdirs(); // s붙이면 다른하부에 없는폴더들도 다 만들어줌
		}
		int result = 0;
		if (isDir.exists()) {
			result++;
		}
		return result;
	}

	public void attachDownload(
			HttpServletResponse response,
			String originalName,
			String saveName,
			String savePath
		) {
		
		try {
			String uploadPath = attachPath + savePath + "/" + saveName;
			
			File file = new File(uploadPath);
        	response.setHeader("Content-Disposition", "attachment;filename=" + originalName);
        	
        	FileInputStream fileInputStream = new FileInputStream(uploadPath);
        	OutputStream out = response.getOutputStream();
        	response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(originalName, "utf-8"));

        	int read = 0;
            byte[] buffer = new byte[1024];
            while ((read = fileInputStream.read(buffer)) != -1) {
            	out.write(buffer, 0, read);
            }
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("download error...");
		}
	}


	private String attachFileReName(String originalFileName, byte[] fileData, String uploadPath) {
		System.out.println(originalFileName);
		String ext = "";
		String newFileName = "";
		File f1 = null;
		if(!originalFileName.equals("")) {
		ext = originalFileName.substring(originalFileName.lastIndexOf(".")).toLowerCase();

		UUID uuid = UUID.randomUUID();

		newFileName = uuid.toString() + ext;
		f1 = new File(uploadPath, newFileName);
		}

		try {
			// 임시 디렉토리에 저장된 업로드된 파일을 지정된 디렉토리에 복사
			// FileCopyUtils.copy(바이트배열, 파일객체);
			if(f1 != null) {
			   FileCopyUtils.copy(fileData, f1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newFileName;
	}

	public List<String> attachProc(List<MultipartFile> multiFileList, String savePath) {
		String uploadPath = attachPath + savePath; // /springStudy/member
		int createDirResult = createDirectory(uploadPath);
		if (createDirResult <= 0) {
			System.out.println("디렉토리 생성 실패");
		}
		List<String> list = new ArrayList<>();

		for (int i = 0; i < multiFileList.size(); i++) {
			MultipartFile file = multiFileList.get(i);

			String originalFileName = "";
			String newFileName = "";
			long fileSize = 0;
			String contentType = "";
			String mimeType = "";
			try {
				originalFileName = file.getOriginalFilename();
				newFileName = attachFileReName(originalFileName, file.getBytes(), uploadPath);
				fileSize = file.getSize();
				contentType = file.getContentType();

				InputStream inputStream;
				inputStream = file.getInputStream();
				Tika tika = new Tika();
				mimeType = tika.detect(inputStream);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (contentType.equals(mimeType)) {
				String msg = "";
				msg += originalFileName + ",";
				msg += newFileName + ",";
				msg += fileSize + ",";
				msg += contentType + ",";
				msg += mimeType;
				if(!newFileName.equals("")) {
					list.add(msg);
				}else {
					list.add("-");
				}
			} else {
				File f1 = new File("C:/LJH/attach/springPortfolio/product/" + newFileName);
				f1.delete();
				list.add("-");
			}

		}

		return list;
	}
	
	public String attachUpdateProc(MultipartFile multiFile, String savePath) {
		String uploadPath = attachPath + savePath; // /springStudy/member
		int createDirResult = createDirectory(uploadPath);
		if (createDirResult <= 0) {
			System.out.println("디렉토리 생성 실패");
		}
			String name = "";
			MultipartFile file = multiFile;

			String originalFileName = "";
			String newFileName = "";
			long fileSize = 0;
			String contentType = "";
			String mimeType = "";
			try {
				originalFileName = file.getOriginalFilename();
				newFileName = attachFileReName(originalFileName, file.getBytes(), uploadPath);
				fileSize = file.getSize();
				contentType = file.getContentType();

				InputStream inputStream;
				inputStream = file.getInputStream();
				Tika tika = new Tika();
				mimeType = tika.detect(inputStream);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (contentType.equals(mimeType)) {
				String msg = "";
				msg += originalFileName + ",";
				msg += newFileName + ",";
				msg += fileSize + ",";
				msg += contentType + ",";
				msg += mimeType;
				if(!newFileName.equals("")) {
					name = msg;
				}else {
					name = "-";
				}
			} else {
				File f1 = new File("C:/LJH/attach/springPortfolio/product/" + newFileName);
				f1.delete();
				name = "-";
			}

		

		return name;
	}
	
	
	
	
}
