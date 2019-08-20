/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CountCompanyNetwork
 * Author:   dell
 * Date:     2019/7/17 17:55
 * Description: 单位合作关系网
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.utils;

import com.boku.www.pojo.TCountCompanyNetwork1;
import com.boku.www.pojo.TCountCompanyNetwork2;
import com.boku.www.pojo.TCountEnglishCompanyNetwork1;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 〈一句话功能简述〉<br> 
 * 〈单位合作关系网〉
 *
 * @author dell
 * @create 2019/7/17
 * @since 1.0.0
 */
@Data
public class CountCompanyNetwork {
	private List<TCountCompanyNetwork1> companyPostNum;
	private List<TCountEnglishCompanyNetwork1> englishCompanyPostNum;
	private List<String> allCompany;
	private Set set;

}