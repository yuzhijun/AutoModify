package com.lenovo.automodify.utils;

import com.lenovo.automodify.BaseMain;


/**
 * ���ù����и��ļ�·���ĳ�����
 * @author yuzhijun
 * **/
public class ProjectPathTree {
	//���̵Ļ���ַ
	public static final String BaseProjectPath = BaseMain.mConfigModel.getProjectPath() + "\\" + BaseMain.mConfigModel.getProjectName();
	
	//���̵�app·��
	public static final String AppPath = BaseProjectPath + "\\app";
	
	//���̵�libĿ¼
	public static final String LibPath = AppPath + "\\libs";
	
//	//������aar����·��
//	public static final String BaseAARPath = LibPath + "\\"+BaseMain.mConfigModel.getAARName().substring(0, BaseMain.mConfigModel.getAARName().indexOf("."));
//	
//	
//	//������aar������·��
//	public static final String AppPath = BaseProjectPath + "\\app";
	
	
	//���̵�main·��
	public static final String MainPath = AppPath + "\\src\\main";
	
	//�����д���·����һ��
	public static final String SrcPath = MainPath + "\\java\\com\\lenovohit";
	
	//���̰���res��·��
	public static final String ResPath = MainPath + "\\res";
	
	//���̰���assets��·��
	public static final String AssetsPath = MainPath + "\\assets";
	
	//���̰���raw��·��
	public static final String RawPath = ResPath + "\\raw";
	
	//���̰���values��·��
	public static final String ValuesPath = ResPath + "\\values";
	
	//���̰���ͼƬ��·��
	public static final String DrawablePath01 = ResPath + "\\mipmap-hdpi";
	public static final String DrawbalePath02 = ResPath + "\\mipmap-mdpi";
	public static final String DrawbalePath03 = ResPath + "\\mipmap-xhdpi";
	public static final String DrawbalePath04 = ResPath + "\\mipmap-xxhdpi";
	public static final String DrawbalePath05 = ResPath + "\\mipmap-xxxhdpi";
}
