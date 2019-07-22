package com.boku.www.pojo;

import lombok.Data;

@Data
public class TbCnkiJournal {
    private Integer id;

    private String journalId;

    private String title;

    private String ttitle;

    private String hostUnit;

    private String issn;

    private String publicationCycle;

    private String sourceDatabase;

    private String cn;

    private String placeOfPublication;

    private String language;

    private String bookSize;

    private String postIssueNum;

    private String time;

    private String cdtitle;

    private String specialName;

    private String literaturePublishedNum;

    private String totalDownloads;

    private String totalCitations;

    private String currentState;

    private String combinedImpactFactor;

    private String compoundImpactFactor;

    private String specialNameNum;

    private String corePerio;

    private String subarea;

    private Integer hasForeignKey;

    private String formerTitle;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJournalId() {
        return journalId;
    }

    public void setJournalId(String journalId) {
        this.journalId = journalId == null ? null : journalId.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getTtitle() {
        return ttitle;
    }

    public void setTtitle(String ttitle) {
        this.ttitle = ttitle == null ? null : ttitle.trim();
    }

    public String getHostUnit() {
        return hostUnit;
    }

    public void setHostUnit(String hostUnit) {
        this.hostUnit = hostUnit == null ? null : hostUnit.trim();
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn == null ? null : issn.trim();
    }

    public String getPublicationCycle() {
        return publicationCycle;
    }

    public void setPublicationCycle(String publicationCycle) {
        this.publicationCycle = publicationCycle == null ? null : publicationCycle.trim();
    }

    public String getSourceDatabase() {
        return sourceDatabase;
    }

    public void setSourceDatabase(String sourceDatabase) {
        this.sourceDatabase = sourceDatabase == null ? null : sourceDatabase.trim();
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn == null ? null : cn.trim();
    }

    public String getPlaceOfPublication() {
        return placeOfPublication;
    }

    public void setPlaceOfPublication(String placeOfPublication) {
        this.placeOfPublication = placeOfPublication == null ? null : placeOfPublication.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getBookSize() {
        return bookSize;
    }

    public void setBookSize(String bookSize) {
        this.bookSize = bookSize == null ? null : bookSize.trim();
    }

    public String getPostIssueNum() {
        return postIssueNum;
    }

    public void setPostIssueNum(String postIssueNum) {
        this.postIssueNum = postIssueNum == null ? null : postIssueNum.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getCdtitle() {
        return cdtitle;
    }

    public void setCdtitle(String cdtitle) {
        this.cdtitle = cdtitle == null ? null : cdtitle.trim();
    }

    public String getSpecialName() {
        return specialName;
    }

    public void setSpecialName(String specialName) {
        this.specialName = specialName == null ? null : specialName.trim();
    }

    public String getLiteraturePublishedNum() {
        return literaturePublishedNum;
    }

    public void setLiteraturePublishedNum(String literaturePublishedNum) {
        this.literaturePublishedNum = literaturePublishedNum == null ? null : literaturePublishedNum.trim();
    }

    public String getTotalDownloads() {
        return totalDownloads;
    }

    public void setTotalDownloads(String totalDownloads) {
        this.totalDownloads = totalDownloads == null ? null : totalDownloads.trim();
    }

    public String getTotalCitations() {
        return totalCitations;
    }

    public void setTotalCitations(String totalCitations) {
        this.totalCitations = totalCitations == null ? null : totalCitations.trim();
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState == null ? null : currentState.trim();
    }

    public String getCombinedImpactFactor() {
        return combinedImpactFactor;
    }

    public void setCombinedImpactFactor(String combinedImpactFactor) {
        this.combinedImpactFactor = combinedImpactFactor == null ? null : combinedImpactFactor.trim();
    }

    public String getCompoundImpactFactor() {
        return compoundImpactFactor;
    }

    public void setCompoundImpactFactor(String compoundImpactFactor) {
        this.compoundImpactFactor = compoundImpactFactor == null ? null : compoundImpactFactor.trim();
    }

    public String getSpecialNameNum() {
        return specialNameNum;
    }

    public void setSpecialNameNum(String specialNameNum) {
        this.specialNameNum = specialNameNum == null ? null : specialNameNum.trim();
    }

    public String getCorePerio() {
        return corePerio;
    }

    public void setCorePerio(String corePerio) {
        this.corePerio = corePerio == null ? null : corePerio.trim();
    }

    public String getSubarea() {
        return subarea;
    }

    public void setSubarea(String subarea) {
        this.subarea = subarea == null ? null : subarea.trim();
    }

    public Integer getHasForeignKey() {
        return hasForeignKey;
    }

    public void setHasForeignKey(Integer hasForeignKey) {
        this.hasForeignKey = hasForeignKey;
    }

    public String getFormerTitle() {
        return formerTitle;
    }

    public void setFormerTitle(String formerTitle) {
        this.formerTitle = formerTitle == null ? null : formerTitle.trim();
    }
}