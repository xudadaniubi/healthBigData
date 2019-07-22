package com.boku.www.pojo;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;

@Data
public class TbCnkiDocumentCommonWithBLOBs extends TbCnkiDocumentCommon {
	@Field("author")
	private String author;
	@Field("address")
	private String address;
	@Field("abstracts")
	private String abstracts;
	@Field("keyword")
	private String keyword;
	@Field("ref")
	private String ref;
	@Field("fund")
	private String fund;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts == null ? null : abstracts.trim();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref == null ? null : ref.trim();
    }

    public String getFund() {
        return fund;
    }

    public void setFund(String fund) {
        this.fund = fund == null ? null : fund.trim();
    }
}