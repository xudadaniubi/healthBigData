/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Relation
 * Author:   dell
 * Date:     2019/8/5 15:18
 * Description: 关系
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.utils;

import lombok.Data;

/**
 * 〈一句话功能简述〉<br> 
 * 〈关系〉
 *
 * @author dell
 * @create 2019/8/5
 * @since 1.0.0
 */
@Data
public class Relation {
	private String target;
	private String source;
	private Integer cooperationNum;
}