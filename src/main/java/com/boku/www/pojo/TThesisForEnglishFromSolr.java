package com.boku.www.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class TThesisForEnglishFromSolr {
    private String abstractId;

    private String journalId;

    private String pmid;

    private String issn;

    private String volume;

    private String issue;

    private Date medlineDate;

    private String medlineTa;

    private String medlinePage;

    private String elocationIdDoi;

    private String language;

    private String country;

    private String nlmUniqueId;

    private String isoAbbreviation;

    private String hadFreeFullText;

    private String hadFullText;

    private String keywords;
}