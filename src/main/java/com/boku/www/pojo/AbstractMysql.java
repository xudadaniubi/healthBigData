/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: AbstractMysql
 * Author:   dell
 * Date:     2019/7/11 14:09
 * Description: 将solr中集合字段装换成字符串，然后存入数据库中
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.pojo;

import lombok.Data;

import java.util.Date;


/**
 * 〈一句话功能简述〉<br> 
 * 〈将solr中集合字段装换成字符串，然后存入数据库中〉
 *
 * @author dell
 * @create 2019/7/11
 * @since 1.0.0
 */
@Data
public class AbstractMysql {
	//表唯一标识字段(PMID +Nlm+DOI)
	private String abstractId;
	//对应杂志唯一标识字段
	private String journalId;
	//杂志期刊名
	private String journalTitleMain;
	//pubmed唯一标识码
	private String pmid;
	//国际标准期刊编号
	private String issn;
	//卷
	private String volume;
	//期
	private String issue;
	//日期
	private Date medlineDate;
	//来源描述
	private String medlineTA;
	//摘要标题
	private String articleTitle;
	//页码
	private String medlinePage;
	//数字对象唯一标识符(作用等同于PMID)
	private String elocationIdDOI;
	//摘要内容
	private String abstractText;
	//摘要翻译内容
	private String translateTest;
	//作者
	private String abstractAuthors;
	//语言
	private String language;
	//文献出版类型
	private String publicationTypes;
	//国籍
	private String country;
	//国立医学图书馆唯一id
	private String nlmUniqueID;
	//国际标准化组织标题缩写
	private String isoAbbreviation;
	//主题词对应mesh中的ui，即mesh中的id
	private String meshHeadsUI;
	//英语主题词
	private String meshHeads;
	//限定词
	private String qualifier;
	//关键词
	private String keyWords;
	//有免费全文(此值需要管理员设置)
	private int hadFreeFullText;
	//有全文(根据originalURL是否存在，标记该字段1存在-1不存在)
	private int hadFullText;
	//原文路径
	private String originalURL;
	//作者字符串
	private String authorsStr;
	//单位字符串
	private String affiliationStr;
	//期刊收录单位
	private String journalIndexes;

	//统计文献所属医院名称
	private String tatisticsAbstractsBlongToHospitalName;
}