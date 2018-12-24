/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ParseExcel
 * Author:   dell
 * Date:     2018/10/8 15:14
 * Description: 加载解析Excel
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.utils;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈加载解析Excel〉
 *
 * @author dell
 * @create 2018/10/8
 * @since 1.0.0
 */
public class ParseExcelUtils {
	public static Sheet parseExcel(File file, String fileName){
		InputStream input = null;
		Workbook workBook = null;
		Sheet sheet = null;
		if(fileName!=null&&fileName.length()>4){
			if (fileName.endsWith("xlsx") || fileName.endsWith("xls")) {// 2003后缀或2007后缀
				try {
					input = new FileInputStream(file);
				} catch (FileNotFoundException e) {
					System.out.println("未找到指定的文件！");
					e.printStackTrace();
				} catch (Exception e) {
					System.out.println("读取Excel文件发生异常！");
					e.printStackTrace();
				}
				if(!input.markSupported()){
					input = new PushbackInputStream(input,8);
				}
				try{
					if(POIFSFileSystem.hasPOIFSHeader(input) || POIXMLDocument.hasOOXMLHeader(input)){
						workBook = WorkbookFactory.create(input);
					}else{
						System.out.println("非法的输入流：当前输入流非OLE2流或OOXML流！");
					}
				} catch(IOException e){
					System.out.println("创建表格工作簿对象发生IO异常！原因："+e.getMessage());
					e.printStackTrace();
				} catch(InvalidFormatException e){
					//Your InputStream was neither an OLE2 stream, nor an OOXML stream.
					System.out.println("非法的输入流：当前输入流非OLE2流或OOXML流！");
					e.printStackTrace();
				}
				try{
					if(workBook!=null){
						int numberSheet = workBook.getNumberOfSheets();
						if(numberSheet>0){
							sheet = workBook.getSheetAt(0);//获取第一个工作簿(Sheet)的内容【注意根据实际需要进行修改】
						}else{
							System.out.println("目标表格工作簿(Sheet)数目为0！");
						}
					}
					input.close();
				}catch(IOException e){
					System.out.println("关闭输入流异常！"+e.getMessage());
					e.printStackTrace();
				}
			}else{
				System.out.println("非法的Excel文件后缀！");
			}
		}else{
			System.out.println("非法的文件路径!");
		}
		return sheet;
	}
}