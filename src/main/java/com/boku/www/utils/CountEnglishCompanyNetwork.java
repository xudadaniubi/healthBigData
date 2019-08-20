/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CountEnglishCompanyNetwork
 * Author:   dell
 * Date:     2019/8/17 10:23
 * Description: 外文单位合作关系网
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.utils;

import com.boku.www.pojo.TCountEnglishCompanyNetwork1;
import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * 〈一句话功能简述〉<br> 
 * 〈外文单位合作关系网〉
 *
 * @author dell
 * @create 2019/8/17
 * @since 1.0.0
 */
@Data
public class CountEnglishCompanyNetwork {
	private List<TCountEnglishCompanyNetwork1> companyPostNum;
	private List<String> allCompany;
	private Set set;
}