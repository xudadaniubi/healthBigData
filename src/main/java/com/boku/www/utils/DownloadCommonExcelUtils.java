/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: DownloadExcelUtils
 * Author:   dell
 * Date:     2018/10/10 11:39
 * Description: excel文件下载工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.utils;

import com.boku.www.pojo.TBooks;
import com.boku.www.pojo.TProjectData;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈excel文件下载工具类〉
 *
 * @author dell
 * @create 2018/10/10
 * @since 1.0.0
 */
public class DownloadCommonExcelUtils {

	public static void downExcel(HttpServletRequest request, HttpServletResponse response, List list ,String[] str,String excelName)throws IOException {
		//根据前端传来的projectData作为条件来查询数据库里的数据
		//导出的Excel头部，这个要根据自己项目改一下
		String[] headers = str;

		List dataset = list;//查询出来的数据，根据自己项目改一下

		//下面的完全不动就行了（Excel数据中不包含图片）

		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet();
		// 设置表格默认列宽度为18个字节
		sheet.setDefaultColumnWidth((short) 18);
		//sheet.setColumnWidth(5,8000);//这里可以设置具体的列宽
		HSSFRow row = sheet.createRow(0);
		for (int i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell(i);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}
		//遍历集合数据，产生数据行
		Iterator it = dataset.iterator();
		int index = 0;
		while (it.hasNext()) {
			index++;
			row = sheet.createRow(index);
			Object t = it.next();
			//利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
			Field[] fields = t.getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				//获取文件名
				String fieldName = field.getName();
				String getMethodName = "get"
						+ fieldName.substring(0, 1).toUpperCase()
						+ fieldName.substring(1);
				//创建列
				HSSFCell cell = row.createCell(i);

				try {
					Class tCls = t.getClass();
					Method getMethod = tCls.getMethod(getMethodName,
							new Class[]{});
					Object value = getMethod.invoke(t, new Object[]{});
					if (getMethodName.equals("getId")) {
						cell.setCellValue(i+1);//如果是id列的话，直接将序号设置进去
					}
					String textValue = null;

					if(value != null){
						if (value instanceof Date) {
							Date date = (Date) value;
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							textValue = sdf.format(date);
						} else {
							//其它数据类型都当作字符串简单处理
							textValue = value.toString();
						}
						HSSFRichTextString richString = new HSSFRichTextString(textValue);
						HSSFFont font3 = workbook.createFont();
						font3.setColor(HSSFColor.BLUE.index);//定义Excel数据颜色
						richString.applyFont(font3);
						cell.setCellValue(richString);//将数据存入进去
					}
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//将表格输出到浏览器
		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition", "attachment;filename=excelName.xls");//默认Excel名称
		response.flushBuffer();
		workbook.write(response.getOutputStream());
	}
}