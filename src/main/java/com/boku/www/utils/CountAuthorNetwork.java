/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CountAuthorNetwork
 * Author:   dell
 * Date:     2019/7/17 9:53
 * Description: 统计作者合作关系网
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.utils;

import com.boku.www.pojo.TCountAuthorNetwork1;
import com.boku.www.pojo.TCountAuthorNetwork2;
import com.boku.www.pojo.TCountCompanyNetwork1;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 〈一句话功能简述〉<br> 
 * 〈统计作者合作关系网〉
 *
 * @author dell
 * @create 2019/7/17
 * @since 1.0.0
 */
@Data
public class CountAuthorNetwork {

	/*private Map<String,List<TCountAuthorNetwork1>> firstMap;

	private Map<Integer, List<TCountAuthorNetwork2>> secondMap;*/

	private List<TCountAuthorNetwork1> authorPostNum;
	private List<String> allAuthor;
	private Set set;


}