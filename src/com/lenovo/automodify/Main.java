package com.lenovo.automodify;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.lenovo.automodify.parser.XmlParser;
import com.lenovo.automodify.utils.ContextReplace;
import com.lenovo.automodify.utils.FileHandler;
import com.lenovo.automodify.utils.ProjectPathTree;


public class Main extends BaseMain{

	public static void main(String[] args) {
		System.out.println("��̎��ɹ�");
//		//0.�ȶ�ȡ�����ļ������ؽ�������Ϣ
//		mConfigModel = XmlParser.readXMLFile();
//		if (mConfigModel == null) {
//			System.out.println("�����ļ���ȡʧ��!");
//			return;
//		}
//		
////		//1.�滻assets���е�config.properties�ļ�
//		FileHandler.copyFileIfExist("src\\com\\lenovohit\\automodify\\parser\\config.properties", ProjectPathTree.AssetsPath +"\\config.properties");
////		//2.��������ɫ
//		XmlParser.parserColorXml();
////		//3.������Ӧ���г��ϵ�����
//		XmlParser.parserAppName();
////		//4.����ͼƬ��
//		try {
//			FileHandler.copyDirectiory(mConfigModel.getSourcePath(), ProjectPathTree.DrawablePath01);
//			FileHandler.copyFileIfExist(mConfigModel.getSourcePath()+"\\ic_launcher.png", ProjectPathTree.DrawbalePath02+"\\ic_launcher.png");
//			FileHandler.copyFileIfExist(mConfigModel.getSourcePath()+"\\ic_launcher.png", ProjectPathTree.DrawbalePath03+"\\ic_launcher.png");
//			FileHandler.copyFileIfExist(mConfigModel.getSourcePath()+"\\ic_launcher.png", ProjectPathTree.DrawbalePath04+"\\ic_launcher.png");
//			FileHandler.copyFileIfExist(mConfigModel.getSourcePath()+"\\ic_launcher.png", ProjectPathTree.DrawbalePath05+"\\ic_launcher.png");
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("�����ļ�ʧ��,�ļ�δ�ҵ�");
//			return;
//		}
//		//5.�޸�AndroidManifest.xml�ļ��еİ���
//		 //�޸�AndroidManifest.xml�ļ���baidu APIKEY
//		XmlParser.parserAndroidManifest();
//		//6.�޸�build.gradle�ļ��İ���
//		//7.�滻*.java�ļ�������Ϊcom.lenovohit.hospitals.R��R�ļ�Ϊ�µİ���.R
//		//8.�滻�汾��
//		ArrayList<File> gradle_modifyFile = new ArrayList<>();
//		ArrayList<File> r_modifyFile = new ArrayList<>();
//		ArrayList<File> versoin_modifyFile = new ArrayList<>();
//		try {
//			ContextReplace.findFiles(ProjectPathTree.AppPath, "build.gradle", gradle_modifyFile, "com.lenovohit.hospitals", mConfigModel.getPackageName());
//			ContextReplace.findFiles(ProjectPathTree.MainPath+"\\java\\com", "*.java", r_modifyFile, "com.lenovohit.hospitals", mConfigModel.getPackageName()+".R");
//			ContextReplace.findFiles(ProjectPathTree.AppPath, "build.gradle", versoin_modifyFile, "100",mConfigModel.getVersionCode());
//		} catch (IOException e) {
//			e.printStackTrace();
//			return;
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//			return;
//		}
	}
}
