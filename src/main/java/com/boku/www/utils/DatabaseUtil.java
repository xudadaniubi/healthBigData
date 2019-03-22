/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DatabaseUtil
 * Author:   dell
 * Date:     2019/3/22 10:18
 * Description: 备份数据库的工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.utils;

import java.io.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈备份数据库的工具类〉
 *
 * @author dell
 * @create 2019/3/22
 * @since 1.0.0
 */
public class DatabaseUtil {
	/**
	 * mysql的备份方法
	 *
	 * @param command  命令行
	 * @param savePath 备份路径
	 * @return
	 */
	public boolean backup(String command, String savePath ,String dirPath) {
		boolean flag;
		// 获得与当前应用程序关联的Runtime对象
		Runtime r = Runtime.getRuntime();
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			File f = new File(dirPath);
			if (!f.exists()) {
				File parent = new File(f.getParent());
				parent.mkdirs();
				System.out.println("**********创建文件路径**********" + f.getParent());
			}
			// 在单独的进程中执行指定的字符串命令
			Process p = r.exec(command);
			// 获得连接到进程正常输出的输入流，该输入流从该Process对象表示的进程的标准输出中获取数据
			InputStream is = p.getInputStream();
			// InputStreamReader是从字节流到字符流的桥梁：它读取字节，并使用指定的charset将其解码为字符
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			//BufferedReader从字符输入流读取文本，缓冲字符，提供字符，数组和行的高效读取
			br = new BufferedReader(isr);
			String s;
			StringBuffer sb = new StringBuffer("");
			// 组装字符串
			while ((s = br.readLine()) != null) {
				sb.append(s + System.lineSeparator());
			}
			s = sb.toString();
			// 创建文件输出流
			FileOutputStream fos = new FileOutputStream(savePath);
			// OutputStreamWriter是从字符流到字节流的桥梁，它使用指定的charset将写入的字符编码为字节
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			// BufferedWriter将文本写入字符输出流，缓冲字符，以提供单个字符，数组和字符串的高效写入
			bw = new BufferedWriter(osw);
			bw.write(s);
			bw.flush();
			flag = true;
		} catch (IOException e) {
			flag = false;
			e.printStackTrace();
		} finally {
			//由于输入输出流使用的是装饰器模式，所以在关闭流时只需要调用外层装饰类的close()方法即可，
			//它会自动调用内层流的close()方法
			try {
				if (null != bw) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				if (null != br) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	/**
	 * mysql的还原方法
	 *
	 * @param command  命令行
	 * @param savePath 还原路径
	 * @return
	 */
	public boolean recover(String command, String savePath) {
		boolean flag;
		Runtime r = Runtime.getRuntime();
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			Process p = r.exec(command);
			OutputStream os = p.getOutputStream();
			FileInputStream fis = new FileInputStream(savePath);
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);
			String s;
			StringBuffer sb = new StringBuffer("");
			while ((s = br.readLine()) != null) {
				sb.append(s + System.lineSeparator());
			}
			s = sb.toString();
			OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");
			bw = new BufferedWriter(osw);
			bw.write(s);
			bw.flush();
			flag = true;
		} catch (IOException e) {
			flag = false;
			e.printStackTrace();
		} finally {
			try {
				if (null != bw) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				if (null != br) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

}