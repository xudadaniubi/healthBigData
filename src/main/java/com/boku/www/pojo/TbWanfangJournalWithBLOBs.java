package com.boku.www.pojo;

public class TbWanfangJournalWithBLOBs extends TbWanfangJournal {
    private String mainColumn;

    private String solicitNotice;

    private String subscribeNotice;

    private String summary;

    private String op;

    private String committee;

    private String perioDesc;

    private String winPrize;

    public String getMainColumn() {
        return mainColumn;
    }

    public void setMainColumn(String mainColumn) {
        this.mainColumn = mainColumn == null ? null : mainColumn.trim();
    }

    public String getSolicitNotice() {
        return solicitNotice;
    }

    public void setSolicitNotice(String solicitNotice) {
        this.solicitNotice = solicitNotice == null ? null : solicitNotice.trim();
    }

    public String getSubscribeNotice() {
        return subscribeNotice;
    }

    public void setSubscribeNotice(String subscribeNotice) {
        this.subscribeNotice = subscribeNotice == null ? null : subscribeNotice.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op == null ? null : op.trim();
    }

    public String getCommittee() {
        return committee;
    }

    public void setCommittee(String committee) {
        this.committee = committee == null ? null : committee.trim();
    }

    public String getPerioDesc() {
        return perioDesc;
    }

    public void setPerioDesc(String perioDesc) {
        this.perioDesc = perioDesc == null ? null : perioDesc.trim();
    }

    public String getWinPrize() {
        return winPrize;
    }

    public void setWinPrize(String winPrize) {
        this.winPrize = winPrize == null ? null : winPrize.trim();
    }
}