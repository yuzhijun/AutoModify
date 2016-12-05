package com.lenovo.automodify.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;
/**
 * @author yuzhijun
 * */
public class ContextReplace {
	/**
	 * ���Ҳ��滻
	 * 
	 * @param baseDirName
	 *            ԭ�ļ�·��
	 * @param targetFileName
	 *            ��Ҫ�����滻�ļ��Ĺؼ��ʣ���.jsp
	 * @param fileList
	 *            ���ҵ��ļ���
	 * @param startStr
	 *            �ļ�����Ҫ�滻���ַ���
	 * @param endStr
	 *            �滻����ַ���
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void findFiles(String baseDirName, String targetFileName,
			List<File> fileList, String startStr, String endStr)
			throws IOException, InterruptedException {
		String tempName = null;
		File baseDir = new File(baseDirName);
		if (!baseDir.exists() || !baseDir.isDirectory()) {
			System.out.println("·��:"+ baseDirName +" δ�ҵ��ļ�");
		} else {
			String[] filelist = baseDir.list();
			for (int i = 0; i < filelist.length; i++) {
				if (filelist[i].indexOf("svn") == -1) {//����SVN�ļ���
					File readfile = new File(baseDirName + "\\" + filelist[i]);
					if (!readfile.isDirectory()) {
						tempName = readfile.getName();
						if (ContextReplace.wildcardMatch(targetFileName, tempName)) {
							File src = new File(readfile.getAbsoluteFile().toString());
							String cont = ContextReplace.read(src);
							Long fileDate = readfile.lastModified();
							if (cont.indexOf(startStr) > -1) {//�ҵ����ݲ��޸�
								fileList.add(readfile.getAbsoluteFile());
								cont = cont.replaceAll(startStr, endStr);
								ContextReplace.write(cont, src);
								readfile.setLastModified(fileDate);
							}
						}
					} else {
						findFiles(baseDirName + "\\" + filelist[i], targetFileName,
								fileList, startStr, endStr);
					}
				}
			}
		}
		if (fileList.size() > 0) {
			System.out.println("·��=" + baseDirName + ", ����[" + fileList.size() + "]���ļ����޸�");
		}
	}

	public static boolean createAndDeleteFile(String filePath)
			throws IOException {
		boolean result = false;
		File file = new File(filePath);
		if (file.exists()) {
			file.delete();
			result = true;
		} else {
			file.createNewFile();
			result = true;
		}
		return result;
	}

	private static boolean wildcardMatch(String pattern, String str) {
		int patternLength = pattern.length();
		int strLength = str.length();
		int strIndex = 0;
		char ch;
		for (int patternIndex = 0; patternIndex < patternLength; patternIndex++) {
			ch = pattern.charAt(patternIndex);
			if (ch == '*') {
				while (strIndex < strLength) {
					if (wildcardMatch(pattern.substring(patternIndex + 1),
							str.substring(strIndex))) {
						return true;
					}
					strIndex++;
				}
			} else if (ch == '?') {
				strIndex++;
				if (strIndex > strLength) {
					return false;
				}
			} else {
				if ((strIndex >= strLength) || (ch != str.charAt(strIndex))) {
					return false;
				}
				strIndex++;
			}
		}
		return (strIndex == strLength);
	}

	/**
	 * ��ָ��·���µ��ļ�
	 * @author LinHao 439224@qq.com
	 * @version ����ʱ�䣺 2015-10-10 ����11:05:44
	 */
	public static String read(File src) {
		StringBuffer res = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(src),"UTF-8"));  
			while ((line = reader.readLine()) != null) {
				res.append(line + "\r\n");
			}

			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res.toString();
	}

	// ת���ļ���ʽ
	public static boolean write(String cont, File dist) {
		//System.out.println(cont);
		try {
			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(dist), "UTF-8");
			System.out.println("�޸��ļ�= " + dist);
			writer.write(cont);
			writer.flush();
			writer.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void readFile(String path, String path2, String format)
			throws IOException {
		String str = "";
		FileInputStream fs = null;
		FileWriter fw = null;
		PrintWriter out = null;
		BufferedReader in = null;
		File f = new File(path);
		if (f.exists()) {
			try {
				fs = new FileInputStream(f);
				fw = new FileWriter(path2);
				out = new PrintWriter(fw);
				in = new BufferedReader(new InputStreamReader(fs, format));

				while (true) {
					str = in.readLine();
					if (str == null) {
						break;
					}
					out.write(str);
					out.println();
					out.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				in.close();
				fs.close();
				fw.close();
				out.close();
			}
		}
	}

}
