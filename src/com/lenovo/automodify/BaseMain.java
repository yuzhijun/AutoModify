package com.lenovo.automodify;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.lenovo.automodify.parser.ConfigModel;
import com.lenovo.automodify.utils.ContextReplace;
import com.lenovo.automodify.utils.FileHandler;
import com.lenovo.automodify.utils.ProjectPathTree;


public class BaseMain {
	public static ConfigModel mConfigModel;
	
	/**
	 * ����DocumentBuilder
	 */
	public DocumentBuilder getDocumentBuilder() throws ParserConfigurationException{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setIgnoringElementContentWhitespace(true);
		return dbf.newDocumentBuilder();
	}
	
	/**
	 * ����Document
	 */
	public Document getDocument(String path) throws FileNotFoundException, SAXException, IOException, ParserConfigurationException{
		return getDocumentBuilder().parse(getInputStream(path));
	}
	
	/**
	 * ����InputStream
	 */
	public InputStream getInputStream(String path) throws FileNotFoundException{
		return new FileInputStream(getFile(path));
	}
	
	/**
	 * ����File
	 */
	public File getFile(String path){
		return new File(path);
	}
	
	/**
	 * ����getStreamResult
	 */
	public StreamResult getStreamResult(String path){
		return new StreamResult(getFile(path));
	}
	
	/**
	 * ����Source
	 */
	public Source getSource(String path){
		try {
		    Document xmldoc = getDocument(path);
			return new DOMSource(xmldoc);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ����Source
	 */
	public Source getSource(Document document){
		try {
			return new DOMSource(document);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Element getElement(String path) throws FileNotFoundException, SAXException, IOException, ParserConfigurationException{
		Document xmldoc = getDocument(path);
		return xmldoc.getDocumentElement();
	}
	
    //����ָ���ڵ�
	public static Node selectSingleNode(String express, Element source) {
		Node result = null;
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		try {
			result = (Node) xpath.evaluate(express, source, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * �޸�һ���ļ�
	 */
	public Boolean setModifyAllFileeBySuffix(String filePath,String suffix,String subStr,String modifyStr){
		List<File> resultList = new ArrayList<File>();
		try {
			ContextReplace.findFiles(filePath, suffix, resultList, subStr,modifyStr);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * �޸�һ���ļ�
	 */
	public Boolean setModifyFileByFilePath(String filePath,String... strs){
		try {
			String content = ContextReplace.read(getFile(filePath));
			int count = strs.length;
			if (count == 2) {
				content = content.replaceAll(strs[0], strs[1]);
				ContextReplace.write(content, getFile(filePath));
			}else{
				for (int i = 0; i < strs.length; i=i+2) {
					content = content.replaceAll(strs[i], strs[i+1]);
				}
				ContextReplace.write(content, getFile(filePath));
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * �����ļ�
	 */
	public Boolean setCopyFile(String fileName,String filePath){
		try {
			FileHandler.copyFileIfExist(mConfigModel.getSourcePath() + "\\" + fileName, filePath + "\\" + fileName);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * ɾ��ָ���ļ���
	 */
	public Boolean setDelFolder(String filePath){
		try {
			return FileHandler.deleteDirectory(filePath);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * ��ȡ��Ŀ������ַ
	 */
	public static String getProjectPathAll(){
		return ProjectPathTree.BaseProjectPath;
	}
}
