/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CleanSpecialSymbol
 * Author:   dell
 * Date:     2019/5/13 8:00
 * Description: 清理特殊符号
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 〈一句话功能简述〉<br> 
 * 〈清理特殊符号〉
 *
 * @author dell
 * @create 2019/5/13
 * @since 1.0.0
 */
public class CleanSpecialSymbolUtil {
	/**
	 * 清理特殊符号
	 * @param str
	 */
	public static String cleanSpecialSymbol(String str,String regEx) {
		//去空格
		//去特殊符号
		//带有特殊符号字符串示例
		//str = "我  的 名 字（测试）*%#$@!0～10-.、SCN1Ap130mRNAWarthin’s11β-~～—-《》60Co-γ60～6^";

		//String regEx="[\\n`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？0-9]";
		//regEx="[\\n`~!@#$%^&*()+=|{}':;'\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？0-9]";

		//可以在中括号内加上任何想要替换的字符
		//这里是将特殊字符换为aa字符串,""代表直接去掉
		String aa = "";

		Pattern p = Pattern.compile(regEx);
		if(StringUtils.isNotBlank(str)){
			//这里把想要替换的字符串传进来
			Matcher m = p.matcher(str);
			//将替换后的字符串存在变量newString中
			String newString = m.replaceAll(aa).trim();
			return newString;
		}
		return null;
	}
}