package com.lenovo.automodify.utils;

import com.lenovo.automodify.BaseMain;


/**
 * 配置工程中各文件路径的常量类
 * @author yuzhijun
 * **/
public class ProjectPathTree {
	//工程的基地址
	public static final String BaseProjectPath = BaseMain.mConfigModel.getProjectPath() + "\\" + BaseMain.mConfigModel.getProjectName();
	
	//工程的lib目录
	public static final String LibPath = BaseProjectPath + "\\app\\libs";
	
	//工程中aar包基路径
	public static final String BaseAARPath = LibPath + "\\"+BaseMain.mConfigModel.getAARName().substring(0, BaseMain.mConfigModel.getAARName().indexOf("."));
	
	
	//工程中aar包备份路径
	public static final String AppPath = BaseProjectPath + "\\app";
	
	//工程中aar包中assets包路径
	public static final String AssetsPath = LibPath + "\\assets";
	
	//工程中aar包中res包路径
	public static final String ResPath = LibPath + "\\res";
	
	//工程中aar包中raw包路径
	public static final String RawPath = ResPath + "\\raw";
	
	//工程中aar包中values包路径
	public static final String ValuesPath = ResPath + "\\values";
	
	//工程中aar包中图片包路径
	public static final String DrawablePath01 = ResPath + "\\mipmap-hdpi-v4";
	public static final String DrawbalePath02 = ResPath + "\\mipmap-mdpi-v4";
	public static final String DrawbalePath03 = ResPath + "\\mipmap-xhdpi-v4";
	public static final String DrawbalePath04 = ResPath + "\\mipmap-xxhdpi-v4";
	public static final String DrawbalePath05 = ResPath + "\\mipmap-xxxhdpi-v4";
}
