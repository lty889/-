package com.shop.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;

public class UploadUtil {
	// ���ȶ���һЩ����
	//Ĭ�ϴ洢λ��
	private String path = "upload";
	// �ϴ�����ĸ�ʽ
	private String allowed = "jpg,png,gif,bmp";
	// �ļ��ܴ�С
	private int totalmax = 10 * 1024 * 1024;
	// �����ļ���С
	private int singlesize = 5 * 1024 * 1024;

	public UploadUtil(String path, String allowed, int totalmax, int singlesize) {
		super();
		this.path = path;
		this.allowed = allowed;
		this.totalmax = totalmax;
		this.singlesize = singlesize;
	}

	public UploadUtil() {
		super();
	}

	// �ϴ��ļ�
	public List<String> uploadFiles(PageContext pageContext) {
		List<String> list = new ArrayList<String>();

		try {
			SmartUpload su = new SmartUpload();
			// ��ʼ��
			su.initialize(pageContext);
			// �����ϴ����ļ���ʽ
			su.setAllowedFilesList(allowed);
			// ���ñ��뼯
			su.setCharset("utf-8");
			// �����ܴ�С
			su.setTotalMaxFileSize(totalmax);
			// ���õ����ļ���С
			su.setMaxFileSize(singlesize);

			// ��ʼ�ϴ�
			su.upload();

			// �õ��ϴ����ļ�
			if (su.getFiles() != null && su.getFiles().getCount() > 0) {
				// ���ļ�
				Files fs = su.getFiles();
				// ѭ��
				for (int i = 0, len = fs.getCount(); i < len; ++i) {
					String fname = "";
					File f = fs.getFile(i);

					// �ļ����������
					fname = path + "/" + new Date().getTime() + new Random().nextInt(100000) + "." + f.getFileExt();
					// �ϴ�
					f.saveAs(fname, SmartUpload.SAVE_VIRTUAL);
					list.add(fname);
					//System.out.println(fname);
				}
			}
		} catch (Exception e) {
			//e.printStackTrace();
			return null;
		}
		return list;
	}

}
