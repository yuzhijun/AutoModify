package com.lenovo.automodify.parser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.lenovo.automodify.BaseMain;
import com.lenovo.automodify.utils.ProjectPathTree;



/*
 * @author yuzhijun
 * ����xml��
 * 1.��config.xml�е���Ϣ������model��
 * **/
public class XmlParser {

	public static ConfigModel readXMLFile() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		ConfigModel info = null;
		try {
	        //�ȴ���DocumentBuilderFactory��ʵ��
	        Document doc = dbf.newDocumentBuilder().parse("src\\com\\lenovo\\automodify\\parser\\config.xml");
			// ���濪ʼ��ȡ
			Element root = doc.getDocumentElement(); // ��ȡ��Ԫ��
			NodeList configInfo = root.getElementsByTagName("info");
			info = new ConfigModel();
			for (int i = 0; i < configInfo.getLength(); i++) {
				Element ss = (Element) configInfo.item(i);
				//���Ԫ�غܶ����ʹ�÷����ȡ����
				 info.setSourcePath(getValueByKey(ss, "SourcePath"));
				 info.setProjectPath(getValueByKey(ss, "ProjectPath"));
				 info.setProjectName(getValueByKey(ss, "ProjectName"));
				 info.setAARName(getValueByKey(ss, "AARName"));
				 info.setAppThemeColor(getValueByKey(ss, "AppThemeColor"));
				 info.setBtnLoginNormalColor(getValueByKey(ss, "BtnLoginNormalColor"));
				 info.setBtnLoginPressColor(getValueByKey(ss, "BtnLoginPressColor"));
				 info.setBtnCompleteNormalColor(getValueByKey(ss, "BtnCompleteNormalColor"));
				 info.setBtnCompletePressColor(getValueByKey(ss, "BtnCompletePressColor"));
				 info.setBtnNormalColor(getValueByKey(ss, "BtnNormalColor"));
				 info.setBtnPressColor(getValueByKey(ss, "BtnPressColor"));
				 info.setAppName(getValueByKey(ss, "AppName"));
				 info.setBDMapKey(getValueByKey(ss, "BDMapKey"));
				 info.setPackageName(getValueByKey(ss, "PackageName"));
				 info.setVersionCode(getValueByKey(ss, "VersionCode"));
//				 info.setS_isIOC(getValueByKey(ss,"s_isIOC"));
//				 info.setIsSJYY(setStringToBoolean(getValueByKey(ss,"isSJYY")));
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			info = null;
		} catch (SAXException e) {
			e.printStackTrace();
			info = null;
		} catch (IOException e) {
			e.printStackTrace();
			info = null;
		}
		return info;
	}
	
	public static String parserColorXml(){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			 //�ȴ���DocumentBuilderFactory��ʵ��
	        Document doc = dbf.newDocumentBuilder().parse(ProjectPathTree.ValuesPath + "\\colors.xml");
	    	// ���濪ʼ��ȡ
			Element root = doc.getDocumentElement(); // ��ȡ��Ԫ��
			NodeList configInfo = root.getElementsByTagName("color");
			for (int i = 0; i < configInfo.getLength(); i++) {
				Element ss = (Element) configInfo.item(i);
				if (ss.getAttribute("name").equals("app_theme_colors")) {
					ss.getFirstChild().setTextContent(BaseMain.mConfigModel.getAppThemeColor());
				}else if(ss.getAttribute("name").equals("btn_logout_normal_colors")){
					ss.getFirstChild().setTextContent(BaseMain.mConfigModel.getBtnLoginNormalColor());
				}else if(ss.getAttribute("name").equals("btn_logout_press_colors")){
					ss.getFirstChild().setTextContent(BaseMain.mConfigModel.getBtnLoginPressColor());
				}else if(ss.getAttribute("name").equals("btn_complete_normal_colors")){
					ss.getFirstChild().setTextContent(BaseMain.mConfigModel.getBtnCompleteNormalColor());
				}else if(ss.getAttribute("name").equals("btn_complete_press_colors")){
					ss.getFirstChild().setTextContent(BaseMain.mConfigModel.getBtnCompletePressColor());
				}else if(ss.getAttribute("name").equals("btn_colors_normal")){
					ss.getFirstChild().setTextContent(BaseMain.mConfigModel.getBtnNormalColor());
				}else if(ss.getAttribute("name").equals("btn_colors_press")){
					ss.getFirstChild().setTextContent(BaseMain.mConfigModel.getBtnPressColor());
				}
			}
			
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.setParameter("version","1.0");
			transformer.setParameter("encoding","utf-8");
			DOMSource xmlSource = new DOMSource(doc);
			StreamResult outputTarget = new StreamResult(new File(ProjectPathTree.ValuesPath + "\\colors.xml"));
			transformer.transform(xmlSource,outputTarget);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static String parserAppName(){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			 //�ȴ���DocumentBuilderFactory��ʵ��
	        Document doc = dbf.newDocumentBuilder().parse(ProjectPathTree.ValuesPath + "\\strings.xml");
	    	// ���濪ʼ��ȡ
			Element root = doc.getDocumentElement(); // ��ȡ��Ԫ��
			NodeList configInfo = root.getElementsByTagName("string");
			for (int i = 0; i < configInfo.getLength(); i++) {
				Element ss = (Element) configInfo.item(i);
				if (ss.getAttribute("name").equals("app_name")) {
					ss.getFirstChild().setTextContent(BaseMain.mConfigModel.getAppName());
				}
			}
			
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.setParameter("version","1.0");
			transformer.setParameter("encoding","utf-8");
			DOMSource xmlSource = new DOMSource(doc);
			StreamResult outputTarget = new StreamResult(new File(ProjectPathTree.ValuesPath + "\\strings.xml"));
			transformer.transform(xmlSource,outputTarget);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void parserAndroidManifest(){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			 //�ȴ���DocumentBuilderFactory��ʵ��
	        Document doc = dbf.newDocumentBuilder().parse(ProjectPathTree.MainPath + "\\AndroidManifest.xml");
	    	// ���濪ʼ��ȡ
			Element root = doc.getDocumentElement(); // ��ȡ��Ԫ��
			root.setAttribute("package", BaseMain.mConfigModel.getPackageName());
			
			NodeList nodeList = root.getElementsByTagName("meta-data");
			Element ss = (Element) nodeList.item(0);
			ss.setAttribute("android:value", "la95E1NT1HQ1Xrpz5ZbtoEvqBBrjcKG66");
			
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.setParameter("version","1.0");
			transformer.setParameter("encoding","utf-8");
			DOMSource xmlSource = new DOMSource(doc);
			StreamResult outputTarget = new StreamResult(new File(ProjectPathTree.MainPath + "\\AndroidManifest.xml"));
			transformer.transform(xmlSource,outputTarget);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return;
	}
	
	
	public static String getValueByKey(Element ss,String key) {
		NodeList names = ss.getElementsByTagName(key);
		Element e = (Element) names.item(0);
		Node t = e.getFirstChild();
		return t.getNodeValue();
	}
	
	
	public static Boolean setStringToBoolean(String value){
		return Boolean.valueOf(value);
	}
}
