/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Count
 * Author:   dell
 * Date:     2018/12/12 16:59
 * Description: 统计地区中专利、项目、论文的数量
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.utils;

import lombok.Data;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈统计地区中专利、项目、论文的数量〉
 *
 * @author dell
 * @create 2018/12/12
 * @since 1.0.0
 */
@Data
public class Count {
	private String area;
	private Integer count;
	private List countList;
	private String organizer;
	private String year;
}