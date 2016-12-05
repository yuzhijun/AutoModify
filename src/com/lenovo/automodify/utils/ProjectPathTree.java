package com.lenovo.automodify.utils;

import com.lenovo.automodify.BaseMain;


/**
 * ���ù����и��ļ�·���ĳ�����
 * @author yuzhijun
 * **/
public class ProjectPathTree {
	//���̵Ļ���ַ
	public static final String BaseProjectPath = BaseMain.mConfigModel.getProjectPath() + "\\" + BaseMain.mConfigModel.getProjectName();
	
	//���̵�libĿ¼
	public static final String LibPath = BaseProjectPath + "\\app\\libs";
	
	//������aar����·��
	public static final String BaseAARPath = LibPath + "\\"+BaseMain.mConfigModel.getAARName().substring(0, BaseMain.mConfigModel.getAARName().indexOf("."));
	
	
	//������aar������·��
	public static final String AppPath = BaseProjectPath + "\\app";
	
	//������aar����assets��·��
	public static final String AssetsPath = LibPath + "\\assets";
	
	//������aar����res��·��
	public static final String ResPath = LibPath + "\\res";
	
	//������aar����raw��·��
	public static final String RawPath = ResPath + "\\raw";
	
	//������aar����values��·��
	public static final String ValuesPath = ResPath + "\\values";
	
	//������aar����ͼƬ��·��
	public static final String DrawablePath01 = ResPath + "\\mipmap-hdpi-v4";
	public static final String DrawbalePath02 = ResPath + "\\mipmap-mdpi-v4";
	public static final String DrawbalePath03 = ResPath + "\\mipmap-xhdpi-v4";
	public static final String DrawbalePath04 = ResPath + "\\mipmap-xxhdpi-v4";
	public static final String DrawbalePath05 = ResPath + "\\mipmap-xxxhdpi-v4";
}
