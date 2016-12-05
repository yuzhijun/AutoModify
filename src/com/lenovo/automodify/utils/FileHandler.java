package com.lenovo.automodify.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author yuzhijun
 * */
public class FileHandler {

	/**
	 * �����ļ�
	 * */
	public static void copyFile(File sourceFile, File destFile)
			throws Exception {

		BufferedInputStream inBuff = null;
		BufferedOutputStream outBuff = null;
		try {
			// �½��ļ����������������л���
			inBuff = new BufferedInputStream(new FileInputStream(sourceFile));
			// �½��ļ���������������л���
			outBuff = new BufferedOutputStream(new FileOutputStream(destFile));
			// ��������
			byte[] b = new byte[1024 * 5];
			int len;
			while ((len = inBuff.read(b)) != -1) {
				outBuff.write(b, 0, len);
			}
			// ˢ�´˻���������
			outBuff.flush();
		} finally {
			// �ر���
			if (inBuff != null)
				inBuff.close();
			if (outBuff != null)
				outBuff.close();
		}
	}

	/**
	 * �����ļ���
	 * */
	public static void copyDirectiory(String sourceDir, String targetDir)
			throws Exception {
		// �½�Ŀ��Ŀ¼
		(new File(targetDir)).mkdirs();
		// ��ȡԴ�ļ��е�ǰ�µ��ļ���Ŀ¼
		File[] file = (new File(sourceDir)).listFiles();
		for (int i = 0; i < file.length; i++) {
			if (file[i].isFile()) {
				// Դ�ļ�
				File sourceFile = file[i];
				// Ŀ���ļ�
				File targetFile = new File(
						new File(targetDir).getAbsolutePath() + File.separator
								+ file[i].getName());
				copyFile(sourceFile, targetFile);
			}
			if (file[i].isDirectory()) {
				// ׼�����Ƶ�Դ�ļ���
				String dir1 = sourceDir + "/" + file[i].getName();
				// ׼�����Ƶ�Ŀ���ļ���
				String dir2 = targetDir + "/" + file[i].getName();
				copyDirectiory(dir1, dir2);
			}
		}
	}

	/**
	 * ɾ��ָ���ļ����µ������ļ�
	 * */
	public static void del(String filepath) throws IOException {
		File f = new File(filepath);// �����ļ�·��
		if (f.exists() && f.isDirectory()) {// �ж����ļ�����Ŀ¼
			if (f.listFiles().length == 0) {// ��Ŀ¼��û���ļ���ֱ��ɾ��
				f.delete();
			} else {// ��������ļ��Ž����飬���ж��Ƿ����¼�Ŀ¼
				File delFile[] = f.listFiles();
				int i = f.listFiles().length;
				for (int j = 0; j < i; j++) {
					if (delFile[j].isDirectory()) {
						del(delFile[j].getAbsolutePath());// �ݹ����del������ȡ����Ŀ¼·��
					}
					delFile[j].delete();// ɾ���ļ�
				}
			}
		}
	}

	/**
	 * ɾ��Ŀ¼���ļ��У��Լ�Ŀ¼�µ��ļ�
	 * 
	 * @param sPath
	 *            ��ɾ��Ŀ¼���ļ�·��
	 * @return Ŀ¼ɾ���ɹ�����true�����򷵻�false
	 */
	public static boolean deleteDirectory(String sPath) {
		// ���sPath�����ļ��ָ�����β���Զ�����ļ��ָ���
		if (!sPath.endsWith(File.separator)) {
			sPath = sPath + File.separator;
		}
		File dirFile = new File(sPath);
		// ���dir��Ӧ���ļ������ڣ����߲���һ��Ŀ¼�����˳�
		if (!dirFile.exists() || !dirFile.isDirectory()) {
			return false;
		}
		Boolean flag = true;
		// ɾ���ļ����µ������ļ�(������Ŀ¼)
		File[] files = dirFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			// ɾ�����ļ�
			if (files[i].isFile()) {
//				if (!files[i].getName().equals(BaseMain.mConfigModel.getAARName())) {
					flag = deleteFile(files[i].getAbsolutePath());
					if (!flag)
						break;
//				}
			} // ɾ����Ŀ¼
			else {
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag)
					break;
			}
		}
		if (!flag)
			return false;
		// ɾ����ǰĿ¼
		if (dirFile.delete()) {
			System.out.println("ɾ���ļ���= " + sPath);
			return true;
		} else {
			return false;
		}
	}
	
	/** 
	 * ɾ�������ļ� 
	 * @param   sPath    ��ɾ���ļ����ļ��� 
	 * @return �����ļ�ɾ���ɹ�����true�����򷵻�false 
	 */  
	public static boolean deleteFile(String sPath) {  
	    Boolean flag = false;  
	    File file = new File(sPath);  
	    // ·��Ϊ�ļ��Ҳ�Ϊ�������ɾ��  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    }  
	    return flag;  
	}  

	/**
	 * ɾ��ָ�����ļ�
	 * */
	public static void delFile(String fileName) {
		File file = new File(fileName);
		if (file.exists() && file.isFile()) {
			 file.delete();
		}
	}

	/**
	 * �����ļ�������ǰ���ж��ļ��Ƿ���ڣ�������ɾ����
	 * */
	public static void copyFileIfExist(String sourceDir, String destDir) {
		File sfile = new File(sourceDir);
		File dFile = new File(destDir);
		if (sfile.getName().equals(dFile.getName())) {
			FileHandler.delFile(destDir);
			try {
				FileHandler.copyFile(sfile, dFile);
				System.out.println("�滻�ļ�= " + destDir);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				FileHandler.copyFile(sfile, dFile);
				System.out.println("�滻�ļ�= " + destDir);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
