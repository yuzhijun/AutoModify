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
		System.out.println("批處理成功");
//		//0.先读取配置文件，加载进基础信息
//		mConfigModel = XmlParser.readXMLFile();
//		if (mConfigModel == null) {
//			System.out.println("配置文件获取失败!");
//			return;
//		}
//		
////		//1.替换assets包中的config.properties文件
//		FileHandler.copyFileIfExist("src\\com\\lenovohit\\automodify\\parser\\config.properties", ProjectPathTree.AssetsPath +"\\config.properties");
////		//2.更换主题色
//		XmlParser.parserColorXml();
////		//3.更换在应用市场上的名字
//		XmlParser.parserAppName();
////		//4.更换图片包
//		try {
//			FileHandler.copyDirectiory(mConfigModel.getSourcePath(), ProjectPathTree.DrawablePath01);
//			FileHandler.copyFileIfExist(mConfigModel.getSourcePath()+"\\ic_launcher.png", ProjectPathTree.DrawbalePath02+"\\ic_launcher.png");
//			FileHandler.copyFileIfExist(mConfigModel.getSourcePath()+"\\ic_launcher.png", ProjectPathTree.DrawbalePath03+"\\ic_launcher.png");
//			FileHandler.copyFileIfExist(mConfigModel.getSourcePath()+"\\ic_launcher.png", ProjectPathTree.DrawbalePath04+"\\ic_launcher.png");
//			FileHandler.copyFileIfExist(mConfigModel.getSourcePath()+"\\ic_launcher.png", ProjectPathTree.DrawbalePath05+"\\ic_launcher.png");
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("复制文件失败,文件未找到");
//			return;
//		}
//		//5.修改AndroidManifest.xml文件中的包名
//		 //修改AndroidManifest.xml文件中baidu APIKEY
//		XmlParser.parserAndroidManifest();
//		//6.修改build.gradle文件的包名
//		//7.替换*.java文件中名称为com.lenovohit.hospitals.R的R文件为新的包名.R
//		//8.替换版本号
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
