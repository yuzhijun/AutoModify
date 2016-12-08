package com.lenovo.automodify.utils;

import com.lenovo.automodify.BaseMain;


/**
 * 配置工程中各文件路径的常量类
 * @author yuzhijun
 * **/
public class ProjectPathTree {
	//工程的基地址
	public static final String BaseProjectPath = BaseMain.mConfigModel.getProjectPath() + "\\" + BaseMain.mConfigModel.getProjectName();
	
	//工程的app路径
	public static final String AppPath = BaseProjectPath + "\\app";
	
	//工程的lib目录
	public static final String LibPath = AppPath + "\\libs";
	
//	//工程中aar包基路径
//	public static final String BaseAARPath = LibPath + "\\"+BaseMain.mConfigModel.getAARName().substring(0, BaseMain.mConfigModel.getAARName().indexOf("."));
//	
//	
//	//工程中aar包备份路径
//	public static final String AppPath = BaseProjectPath + "\\app";
	
	
	//工程的main路径
	public static final String MainPath = AppPath + "\\src\\main";
	
	//工程中代码路径上一级
	public static final String SrcPath = MainPath + "\\java\\com\\lenovohit";
	
	//工程包中res包路径
	public static final String ResPath = MainPath + "\\res";
	
	//工程包中assets包路径
	public static final String AssetsPath = MainPath + "\\assets";
	
	//工程包中raw包路径
	public static final String RawPath = ResPath + "\\raw";
	
	//工程包中values包路径
	public static final String ValuesPath = ResPath + "\\values";
	
	//工程包中图片包路径
	public static final String DrawablePath01 = ResPath + "\\mipmap-hdpi";
	public static final String DrawbalePath02 = ResPath + "\\mipmap-mdpi";
	public static final String DrawbalePath03 = ResPath + "\\mipmap-xhdpi";
	public static final String DrawbalePath04 = ResPath + "\\mipmap-xxhdpi";
	public static final String DrawbalePath05 = ResPath + "\\mipmap-xxxhdpi";
}
