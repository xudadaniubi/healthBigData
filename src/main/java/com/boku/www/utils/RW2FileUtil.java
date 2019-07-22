/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RW2FileUtil
 * Author:   dell
 * Date:     2019/2/25 7:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.utils;



import java.io.*;
import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author dell
 * @create 2019/2/25
 * @since 1.0.0
 */
public class RW2FileUtil {
	public RW2FileUtil() {
	}


	public static void writeHashMap2File(HashMap hashMap, String fileName) {
		if (hashMap != null) {
			BufferedWriter out = null;
			try {
				File f = new File(fileName);
				if (!f.exists()) {
					File parent = new File(f.getParent());
					parent.mkdirs();
					System.out.println("**********创建文件路径**********" + f.getParent());
				}
				//加入编码字符集
				out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "gbk"));
				out.write(hashMap.toString());
			} catch (Exception var7) {
				var7.printStackTrace();
			} finally{
				if(null!=out){
					try {
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				System.out.println("记录完成");
			}
		}

	}
}
