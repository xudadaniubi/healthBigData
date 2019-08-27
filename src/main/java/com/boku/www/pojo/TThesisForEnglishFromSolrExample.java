package com.boku.www.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TThesisForEnglishFromSolrExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TThesisForEnglishFromSolrExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andAbstractIdIsNull() {
            addCriterion("abstract_id is null");
            return (Criteria) this;
        }

        public Criteria andAbstractIdIsNotNull() {
            addCriterion("abstract_id is not null");
            return (Criteria) this;
        }

        public Criteria andAbstractIdEqualTo(String value) {
            addCriterion("abstract_id =", value, "abstractId");
            return (Criteria) this;
        }

        public Criteria andAbstractIdNotEqualTo(String value) {
            addCriterion("abstract_id <>", value, "abstractId");
            return (Criteria) this;
        }

        public Criteria andAbstractIdGreaterThan(String value) {
            addCriterion("abstract_id >", value, "abstractId");
            return (Criteria) this;
        }

        public Criteria andAbstractIdGreaterThanOrEqualTo(String value) {
            addCriterion("abstract_id >=", value, "abstractId");
            return (Criteria) this;
        }

        public Criteria andAbstractIdLessThan(String value) {
            addCriterion("abstract_id <", value, "abstractId");
            return (Criteria) this;
        }

        public Criteria andAbstractIdLessThanOrEqualTo(String value) {
            addCriterion("abstract_id <=", value, "abstractId");
            return (Criteria) this;
        }

        public Criteria andAbstractIdLike(String value) {
            addCriterion("abstract_id like", value, "abstractId");
            return (Criteria) this;
        }

        public Criteria andAbstractIdNotLike(String value) {
            addCriterion("abstract_id not like", value, "abstractId");
            return (Criteria) this;
        }

        public Criteria andAbstractIdIn(List<String> values) {
            addCriterion("abstract_id in", values, "abstractId");
            return (Criteria) this;
        }

        public Criteria andAbstractIdNotIn(List<String> values) {
            addCriterion("abstract_id not in", values, "abstractId");
            return (Criteria) this;
        }

        public Criteria andAbstractIdBetween(String value1, String value2) {
            addCriterion("abstract_id between", value1, value2, "abstractId");
            return (Criteria) this;
        }

        public Criteria andAbstractIdNotBetween(String value1, String value2) {
            addCriterion("abstract_id not between", value1, value2, "abstractId");
            return (Criteria) this;
        }

        public Criteria andJournalIdIsNull() {
            addCriterion("journal_id is null");
            return (Criteria) this;
        }

        public Criteria andJournalIdIsNotNull() {
            addCriterion("journal_id is not null");
            return (Criteria) this;
        }

        public Criteria andJournalIdEqualTo(String value) {
            addCriterion("journal_id =", value, "journalId");
            return (Criteria) this;
        }

        public Criteria andJournalIdNotEqualTo(String value) {
            addCriterion("journal_id <>", value, "journalId");
            return (Criteria) this;
        }

        public Criteria andJournalIdGreaterThan(String value) {
            addCriterion("journal_id >", value, "journalId");
            return (Criteria) this;
        }

        public Criteria andJournalIdGreaterThanOrEqualTo(String value) {
            addCriterion("journal_id >=", value, "journalId");
            return (Criteria) this;
        }

        public Criteria andJournalIdLessThan(String value) {
            addCriterion("journal_id <", value, "journalId");
            return (Criteria) this;
        }

        public Criteria andJournalIdLessThanOrEqualTo(String value) {
            addCriterion("journal_id <=", value, "journalId");
            return (Criteria) this;
        }

        public Criteria andJournalIdLike(String value) {
            addCriterion("journal_id like", value, "journalId");
            return (Criteria) this;
        }

        public Criteria andJournalIdNotLike(String value) {
            addCriterion("journal_id not like", value, "journalId");
            return (Criteria) this;
        }

        public Criteria andJournalIdIn(List<String> values) {
            addCriterion("journal_id in", values, "journalId");
            return (Criteria) this;
        }

        public Criteria andJournalIdNotIn(List<String> values) {
            addCriterion("journal_id not in", values, "journalId");
            return (Criteria) this;
        }

        public Criteria andJournalIdBetween(String value1, String value2) {
            addCriterion("journal_id between", value1, value2, "journalId");
            return (Criteria) this;
        }

        public Criteria andJournalIdNotBetween(String value1, String value2) {
            addCriterion("journal_id not between", value1, value2, "journalId");
            return (Criteria) this;
        }

        public Criteria andPmidIsNull() {
            addCriterion("pmid is null");
            return (Criteria) this;
        }

        public Criteria andPmidIsNotNull() {
            addCriterion("pmid is not null");
            return (Criteria) this;
        }

        public Criteria andPmidEqualTo(String value) {
            addCriterion("pmid =", value, "pmid");
            return (Criteria) this;
        }

        public Criteria andPmidNotEqualTo(String value) {
            addCriterion("pmid <>", value, "pmid");
            return (Criteria) this;
        }

        public Criteria andPmidGreaterThan(String value) {
            addCriterion("pmid >", value, "pmid");
            return (Criteria) this;
        }

        public Criteria andPmidGreaterThanOrEqualTo(String value) {
            addCriterion("pmid >=", value, "pmid");
            return (Criteria) this;
        }

        public Criteria andPmidLessThan(String value) {
            addCriterion("pmid <", value, "pmid");
            return (Criteria) this;
        }

        public Criteria andPmidLessThanOrEqualTo(String value) {
            addCriterion("pmid <=", value, "pmid");
            return (Criteria) this;
        }

        public Criteria andPmidLike(String value) {
            addCriterion("pmid like", value, "pmid");
            return (Criteria) this;
        }

        public Criteria andPmidNotLike(String value) {
            addCriterion("pmid not like", value, "pmid");
            return (Criteria) this;
        }

        public Criteria andPmidIn(List<String> values) {
            addCriterion("pmid in", values, "pmid");
            return (Criteria) this;
        }

        public Criteria andPmidNotIn(List<String> values) {
            addCriterion("pmid not in", values, "pmid");
            return (Criteria) this;
        }

        public Criteria andPmidBetween(String value1, String value2) {
            addCriterion("pmid between", value1, value2, "pmid");
            return (Criteria) this;
        }

        public Criteria andPmidNotBetween(String value1, String value2) {
            addCriterion("pmid not between", value1, value2, "pmid");
            return (Criteria) this;
        }

        public Criteria andIssnIsNull() {
            addCriterion("issn is null");
            return (Criteria) this;
        }

        public Criteria andIssnIsNotNull() {
            addCriterion("issn is not null");
            return (Criteria) this;
        }

        public Criteria andIssnEqualTo(String value) {
            addCriterion("issn =", value, "issn");
            return (Criteria) this;
        }

        public Criteria andIssnNotEqualTo(String value) {
            addCriterion("issn <>", value, "issn");
            return (Criteria) this;
        }

        public Criteria andIssnGreaterThan(String value) {
            addCriterion("issn >", value, "issn");
            return (Criteria) this;
        }

        public Criteria andIssnGreaterThanOrEqualTo(String value) {
            addCriterion("issn >=", value, "issn");
            return (Criteria) this;
        }

        public Criteria andIssnLessThan(String value) {
            addCriterion("issn <", value, "issn");
            return (Criteria) this;
        }

        public Criteria andIssnLessThanOrEqualTo(String value) {
            addCriterion("issn <=", value, "issn");
            return (Criteria) this;
        }

        public Criteria andIssnLike(String value) {
            addCriterion("issn like", value, "issn");
            return (Criteria) this;
        }

        public Criteria andIssnNotLike(String value) {
            addCriterion("issn not like", value, "issn");
            return (Criteria) this;
        }

        public Criteria andIssnIn(List<String> values) {
            addCriterion("issn in", values, "issn");
            return (Criteria) this;
        }

        public Criteria andIssnNotIn(List<String> values) {
            addCriterion("issn not in", values, "issn");
            return (Criteria) this;
        }

        public Criteria andIssnBetween(String value1, String value2) {
            addCriterion("issn between", value1, value2, "issn");
            return (Criteria) this;
        }

        public Criteria andIssnNotBetween(String value1, String value2) {
            addCriterion("issn not between", value1, value2, "issn");
            return (Criteria) this;
        }

        public Criteria andVolumeIsNull() {
            addCriterion("volume is null");
            return (Criteria) this;
        }

        public Criteria andVolumeIsNotNull() {
            addCriterion("volume is not null");
            return (Criteria) this;
        }

        public Criteria andVolumeEqualTo(String value) {
            addCriterion("volume =", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotEqualTo(String value) {
            addCriterion("volume <>", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeGreaterThan(String value) {
            addCriterion("volume >", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeGreaterThanOrEqualTo(String value) {
            addCriterion("volume >=", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeLessThan(String value) {
            addCriterion("volume <", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeLessThanOrEqualTo(String value) {
            addCriterion("volume <=", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeLike(String value) {
            addCriterion("volume like", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotLike(String value) {
            addCriterion("volume not like", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeIn(List<String> values) {
            addCriterion("volume in", values, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotIn(List<String> values) {
            addCriterion("volume not in", values, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeBetween(String value1, String value2) {
            addCriterion("volume between", value1, value2, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotBetween(String value1, String value2) {
            addCriterion("volume not between", value1, value2, "volume");
            return (Criteria) this;
        }

        public Criteria andIssueIsNull() {
            addCriterion("issue is null");
            return (Criteria) this;
        }

        public Criteria andIssueIsNotNull() {
            addCriterion("issue is not null");
            return (Criteria) this;
        }

        public Criteria andIssueEqualTo(String value) {
            addCriterion("issue =", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueNotEqualTo(String value) {
            addCriterion("issue <>", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueGreaterThan(String value) {
            addCriterion("issue >", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueGreaterThanOrEqualTo(String value) {
            addCriterion("issue >=", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueLessThan(String value) {
            addCriterion("issue <", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueLessThanOrEqualTo(String value) {
            addCriterion("issue <=", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueLike(String value) {
            addCriterion("issue like", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueNotLike(String value) {
            addCriterion("issue not like", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueIn(List<String> values) {
            addCriterion("issue in", values, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueNotIn(List<String> values) {
            addCriterion("issue not in", values, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueBetween(String value1, String value2) {
            addCriterion("issue between", value1, value2, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueNotBetween(String value1, String value2) {
            addCriterion("issue not between", value1, value2, "issue");
            return (Criteria) this;
        }

        public Criteria andMedlineDateIsNull() {
            addCriterion("medline_date is null");
            return (Criteria) this;
        }

        public Criteria andMedlineDateIsNotNull() {
            addCriterion("medline_date is not null");
            return (Criteria) this;
        }

        public Criteria andMedlineDateEqualTo(Date value) {
            addCriterionForJDBCDate("medline_date =", value, "medlineDate");
            return (Criteria) this;
        }

        public Criteria andMedlineDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("medline_date <>", value, "medlineDate");
            return (Criteria) this;
        }

        public Criteria andMedlineDateGreaterThan(Date value) {
            addCriterionForJDBCDate("medline_date >", value, "medlineDate");
            return (Criteria) this;
        }

        public Criteria andMedlineDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("medline_date >=", value, "medlineDate");
            return (Criteria) this;
        }

        public Criteria andMedlineDateLessThan(Date value) {
            addCriterionForJDBCDate("medline_date <", value, "medlineDate");
            return (Criteria) this;
        }

        public Criteria andMedlineDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("medline_date <=", value, "medlineDate");
            return (Criteria) this;
        }

        public Criteria andMedlineDateIn(List<Date> values) {
            addCriterionForJDBCDate("medline_date in", values, "medlineDate");
            return (Criteria) this;
        }

        public Criteria andMedlineDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("medline_date not in", values, "medlineDate");
            return (Criteria) this;
        }

        public Criteria andMedlineDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("medline_date between", value1, value2, "medlineDate");
            return (Criteria) this;
        }

        public Criteria andMedlineDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("medline_date not between", value1, value2, "medlineDate");
            return (Criteria) this;
        }

        public Criteria andMedlineTaIsNull() {
            addCriterion("medline_TA is null");
            return (Criteria) this;
        }

        public Criteria andMedlineTaIsNotNull() {
            addCriterion("medline_TA is not null");
            return (Criteria) this;
        }

        public Criteria andMedlineTaEqualTo(String value) {
            addCriterion("medline_TA =", value, "medlineTa");
            return (Criteria) this;
        }

        public Criteria andMedlineTaNotEqualTo(String value) {
            addCriterion("medline_TA <>", value, "medlineTa");
            return (Criteria) this;
        }

        public Criteria andMedlineTaGreaterThan(String value) {
            addCriterion("medline_TA >", value, "medlineTa");
            return (Criteria) this;
        }

        public Criteria andMedlineTaGreaterThanOrEqualTo(String value) {
            addCriterion("medline_TA >=", value, "medlineTa");
            return (Criteria) this;
        }

        public Criteria andMedlineTaLessThan(String value) {
            addCriterion("medline_TA <", value, "medlineTa");
            return (Criteria) this;
        }

        public Criteria andMedlineTaLessThanOrEqualTo(String value) {
            addCriterion("medline_TA <=", value, "medlineTa");
            return (Criteria) this;
        }

        public Criteria andMedlineTaLike(String value) {
            addCriterion("medline_TA like", value, "medlineTa");
            return (Criteria) this;
        }

        public Criteria andMedlineTaNotLike(String value) {
            addCriterion("medline_TA not like", value, "medlineTa");
            return (Criteria) this;
        }

        public Criteria andMedlineTaIn(List<String> values) {
            addCriterion("medline_TA in", values, "medlineTa");
            return (Criteria) this;
        }

        public Criteria andMedlineTaNotIn(List<String> values) {
            addCriterion("medline_TA not in", values, "medlineTa");
            return (Criteria) this;
        }

        public Criteria andMedlineTaBetween(String value1, String value2) {
            addCriterion("medline_TA between", value1, value2, "medlineTa");
            return (Criteria) this;
        }

        public Criteria andMedlineTaNotBetween(String value1, String value2) {
            addCriterion("medline_TA not between", value1, value2, "medlineTa");
            return (Criteria) this;
        }

        public Criteria andMedlinePageIsNull() {
            addCriterion("medline_page is null");
            return (Criteria) this;
        }

        public Criteria andMedlinePageIsNotNull() {
            addCriterion("medline_page is not null");
            return (Criteria) this;
        }

        public Criteria andMedlinePageEqualTo(String value) {
            addCriterion("medline_page =", value, "medlinePage");
            return (Criteria) this;
        }

        public Criteria andMedlinePageNotEqualTo(String value) {
            addCriterion("medline_page <>", value, "medlinePage");
            return (Criteria) this;
        }

        public Criteria andMedlinePageGreaterThan(String value) {
            addCriterion("medline_page >", value, "medlinePage");
            return (Criteria) this;
        }

        public Criteria andMedlinePageGreaterThanOrEqualTo(String value) {
            addCriterion("medline_page >=", value, "medlinePage");
            return (Criteria) this;
        }

        public Criteria andMedlinePageLessThan(String value) {
            addCriterion("medline_page <", value, "medlinePage");
            return (Criteria) this;
        }

        public Criteria andMedlinePageLessThanOrEqualTo(String value) {
            addCriterion("medline_page <=", value, "medlinePage");
            return (Criteria) this;
        }

        public Criteria andMedlinePageLike(String value) {
            addCriterion("medline_page like", value, "medlinePage");
            return (Criteria) this;
        }

        public Criteria andMedlinePageNotLike(String value) {
            addCriterion("medline_page not like", value, "medlinePage");
            return (Criteria) this;
        }

        public Criteria andMedlinePageIn(List<String> values) {
            addCriterion("medline_page in", values, "medlinePage");
            return (Criteria) this;
        }

        public Criteria andMedlinePageNotIn(List<String> values) {
            addCriterion("medline_page not in", values, "medlinePage");
            return (Criteria) this;
        }

        public Criteria andMedlinePageBetween(String value1, String value2) {
            addCriterion("medline_page between", value1, value2, "medlinePage");
            return (Criteria) this;
        }

        public Criteria andMedlinePageNotBetween(String value1, String value2) {
            addCriterion("medline_page not between", value1, value2, "medlinePage");
            return (Criteria) this;
        }

        public Criteria andElocationIdDoiIsNull() {
            addCriterion("elocation_id_DOI is null");
            return (Criteria) this;
        }

        public Criteria andElocationIdDoiIsNotNull() {
            addCriterion("elocation_id_DOI is not null");
            return (Criteria) this;
        }

        public Criteria andElocationIdDoiEqualTo(String value) {
            addCriterion("elocation_id_DOI =", value, "elocationIdDoi");
            return (Criteria) this;
        }

        public Criteria andElocationIdDoiNotEqualTo(String value) {
            addCriterion("elocation_id_DOI <>", value, "elocationIdDoi");
            return (Criteria) this;
        }

        public Criteria andElocationIdDoiGreaterThan(String value) {
            addCriterion("elocation_id_DOI >", value, "elocationIdDoi");
            return (Criteria) this;
        }

        public Criteria andElocationIdDoiGreaterThanOrEqualTo(String value) {
            addCriterion("elocation_id_DOI >=", value, "elocationIdDoi");
            return (Criteria) this;
        }

        public Criteria andElocationIdDoiLessThan(String value) {
            addCriterion("elocation_id_DOI <", value, "elocationIdDoi");
            return (Criteria) this;
        }

        public Criteria andElocationIdDoiLessThanOrEqualTo(String value) {
            addCriterion("elocation_id_DOI <=", value, "elocationIdDoi");
            return (Criteria) this;
        }

        public Criteria andElocationIdDoiLike(String value) {
            addCriterion("elocation_id_DOI like", value, "elocationIdDoi");
            return (Criteria) this;
        }

        public Criteria andElocationIdDoiNotLike(String value) {
            addCriterion("elocation_id_DOI not like", value, "elocationIdDoi");
            return (Criteria) this;
        }

        public Criteria andElocationIdDoiIn(List<String> values) {
            addCriterion("elocation_id_DOI in", values, "elocationIdDoi");
            return (Criteria) this;
        }

        public Criteria andElocationIdDoiNotIn(List<String> values) {
            addCriterion("elocation_id_DOI not in", values, "elocationIdDoi");
            return (Criteria) this;
        }

        public Criteria andElocationIdDoiBetween(String value1, String value2) {
            addCriterion("elocation_id_DOI between", value1, value2, "elocationIdDoi");
            return (Criteria) this;
        }

        public Criteria andElocationIdDoiNotBetween(String value1, String value2) {
            addCriterion("elocation_id_DOI not between", value1, value2, "elocationIdDoi");
            return (Criteria) this;
        }

        public Criteria andLanguageIsNull() {
            addCriterion("language is null");
            return (Criteria) this;
        }

        public Criteria andLanguageIsNotNull() {
            addCriterion("language is not null");
            return (Criteria) this;
        }

        public Criteria andLanguageEqualTo(String value) {
            addCriterion("language =", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotEqualTo(String value) {
            addCriterion("language <>", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageGreaterThan(String value) {
            addCriterion("language >", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageGreaterThanOrEqualTo(String value) {
            addCriterion("language >=", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLessThan(String value) {
            addCriterion("language <", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLessThanOrEqualTo(String value) {
            addCriterion("language <=", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLike(String value) {
            addCriterion("language like", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotLike(String value) {
            addCriterion("language not like", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageIn(List<String> values) {
            addCriterion("language in", values, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotIn(List<String> values) {
            addCriterion("language not in", values, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageBetween(String value1, String value2) {
            addCriterion("language between", value1, value2, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotBetween(String value1, String value2) {
            addCriterion("language not between", value1, value2, "language");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("country not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andNlmUniqueIdIsNull() {
            addCriterion("nlm_unique_ID is null");
            return (Criteria) this;
        }

        public Criteria andNlmUniqueIdIsNotNull() {
            addCriterion("nlm_unique_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNlmUniqueIdEqualTo(String value) {
            addCriterion("nlm_unique_ID =", value, "nlmUniqueId");
            return (Criteria) this;
        }

        public Criteria andNlmUniqueIdNotEqualTo(String value) {
            addCriterion("nlm_unique_ID <>", value, "nlmUniqueId");
            return (Criteria) this;
        }

        public Criteria andNlmUniqueIdGreaterThan(String value) {
            addCriterion("nlm_unique_ID >", value, "nlmUniqueId");
            return (Criteria) this;
        }

        public Criteria andNlmUniqueIdGreaterThanOrEqualTo(String value) {
            addCriterion("nlm_unique_ID >=", value, "nlmUniqueId");
            return (Criteria) this;
        }

        public Criteria andNlmUniqueIdLessThan(String value) {
            addCriterion("nlm_unique_ID <", value, "nlmUniqueId");
            return (Criteria) this;
        }

        public Criteria andNlmUniqueIdLessThanOrEqualTo(String value) {
            addCriterion("nlm_unique_ID <=", value, "nlmUniqueId");
            return (Criteria) this;
        }

        public Criteria andNlmUniqueIdLike(String value) {
            addCriterion("nlm_unique_ID like", value, "nlmUniqueId");
            return (Criteria) this;
        }

        public Criteria andNlmUniqueIdNotLike(String value) {
            addCriterion("nlm_unique_ID not like", value, "nlmUniqueId");
            return (Criteria) this;
        }

        public Criteria andNlmUniqueIdIn(List<String> values) {
            addCriterion("nlm_unique_ID in", values, "nlmUniqueId");
            return (Criteria) this;
        }

        public Criteria andNlmUniqueIdNotIn(List<String> values) {
            addCriterion("nlm_unique_ID not in", values, "nlmUniqueId");
            return (Criteria) this;
        }

        public Criteria andNlmUniqueIdBetween(String value1, String value2) {
            addCriterion("nlm_unique_ID between", value1, value2, "nlmUniqueId");
            return (Criteria) this;
        }

        public Criteria andNlmUniqueIdNotBetween(String value1, String value2) {
            addCriterion("nlm_unique_ID not between", value1, value2, "nlmUniqueId");
            return (Criteria) this;
        }

        public Criteria andIsoAbbreviationIsNull() {
            addCriterion("ISO_abbreviation is null");
            return (Criteria) this;
        }

        public Criteria andIsoAbbreviationIsNotNull() {
            addCriterion("ISO_abbreviation is not null");
            return (Criteria) this;
        }

        public Criteria andIsoAbbreviationEqualTo(String value) {
            addCriterion("ISO_abbreviation =", value, "isoAbbreviation");
            return (Criteria) this;
        }

        public Criteria andIsoAbbreviationNotEqualTo(String value) {
            addCriterion("ISO_abbreviation <>", value, "isoAbbreviation");
            return (Criteria) this;
        }

        public Criteria andIsoAbbreviationGreaterThan(String value) {
            addCriterion("ISO_abbreviation >", value, "isoAbbreviation");
            return (Criteria) this;
        }

        public Criteria andIsoAbbreviationGreaterThanOrEqualTo(String value) {
            addCriterion("ISO_abbreviation >=", value, "isoAbbreviation");
            return (Criteria) this;
        }

        public Criteria andIsoAbbreviationLessThan(String value) {
            addCriterion("ISO_abbreviation <", value, "isoAbbreviation");
            return (Criteria) this;
        }

        public Criteria andIsoAbbreviationLessThanOrEqualTo(String value) {
            addCriterion("ISO_abbreviation <=", value, "isoAbbreviation");
            return (Criteria) this;
        }

        public Criteria andIsoAbbreviationLike(String value) {
            addCriterion("ISO_abbreviation like", value, "isoAbbreviation");
            return (Criteria) this;
        }

        public Criteria andIsoAbbreviationNotLike(String value) {
            addCriterion("ISO_abbreviation not like", value, "isoAbbreviation");
            return (Criteria) this;
        }

        public Criteria andIsoAbbreviationIn(List<String> values) {
            addCriterion("ISO_abbreviation in", values, "isoAbbreviation");
            return (Criteria) this;
        }

        public Criteria andIsoAbbreviationNotIn(List<String> values) {
            addCriterion("ISO_abbreviation not in", values, "isoAbbreviation");
            return (Criteria) this;
        }

        public Criteria andIsoAbbreviationBetween(String value1, String value2) {
            addCriterion("ISO_abbreviation between", value1, value2, "isoAbbreviation");
            return (Criteria) this;
        }

        public Criteria andIsoAbbreviationNotBetween(String value1, String value2) {
            addCriterion("ISO_abbreviation not between", value1, value2, "isoAbbreviation");
            return (Criteria) this;
        }

        public Criteria andHadFreeFullTextIsNull() {
            addCriterion("had_free_full_text is null");
            return (Criteria) this;
        }

        public Criteria andHadFreeFullTextIsNotNull() {
            addCriterion("had_free_full_text is not null");
            return (Criteria) this;
        }

        public Criteria andHadFreeFullTextEqualTo(String value) {
            addCriterion("had_free_full_text =", value, "hadFreeFullText");
            return (Criteria) this;
        }

        public Criteria andHadFreeFullTextNotEqualTo(String value) {
            addCriterion("had_free_full_text <>", value, "hadFreeFullText");
            return (Criteria) this;
        }

        public Criteria andHadFreeFullTextGreaterThan(String value) {
            addCriterion("had_free_full_text >", value, "hadFreeFullText");
            return (Criteria) this;
        }

        public Criteria andHadFreeFullTextGreaterThanOrEqualTo(String value) {
            addCriterion("had_free_full_text >=", value, "hadFreeFullText");
            return (Criteria) this;
        }

        public Criteria andHadFreeFullTextLessThan(String value) {
            addCriterion("had_free_full_text <", value, "hadFreeFullText");
            return (Criteria) this;
        }

        public Criteria andHadFreeFullTextLessThanOrEqualTo(String value) {
            addCriterion("had_free_full_text <=", value, "hadFreeFullText");
            return (Criteria) this;
        }

        public Criteria andHadFreeFullTextLike(String value) {
            addCriterion("had_free_full_text like", value, "hadFreeFullText");
            return (Criteria) this;
        }

        public Criteria andHadFreeFullTextNotLike(String value) {
            addCriterion("had_free_full_text not like", value, "hadFreeFullText");
            return (Criteria) this;
        }

        public Criteria andHadFreeFullTextIn(List<String> values) {
            addCriterion("had_free_full_text in", values, "hadFreeFullText");
            return (Criteria) this;
        }

        public Criteria andHadFreeFullTextNotIn(List<String> values) {
            addCriterion("had_free_full_text not in", values, "hadFreeFullText");
            return (Criteria) this;
        }

        public Criteria andHadFreeFullTextBetween(String value1, String value2) {
            addCriterion("had_free_full_text between", value1, value2, "hadFreeFullText");
            return (Criteria) this;
        }

        public Criteria andHadFreeFullTextNotBetween(String value1, String value2) {
            addCriterion("had_free_full_text not between", value1, value2, "hadFreeFullText");
            return (Criteria) this;
        }

        public Criteria andHadFullTextIsNull() {
            addCriterion("had_full_text is null");
            return (Criteria) this;
        }

        public Criteria andHadFullTextIsNotNull() {
            addCriterion("had_full_text is not null");
            return (Criteria) this;
        }

        public Criteria andHadFullTextEqualTo(String value) {
            addCriterion("had_full_text =", value, "hadFullText");
            return (Criteria) this;
        }

        public Criteria andHadFullTextNotEqualTo(String value) {
            addCriterion("had_full_text <>", value, "hadFullText");
            return (Criteria) this;
        }

        public Criteria andHadFullTextGreaterThan(String value) {
            addCriterion("had_full_text >", value, "hadFullText");
            return (Criteria) this;
        }

        public Criteria andHadFullTextGreaterThanOrEqualTo(String value) {
            addCriterion("had_full_text >=", value, "hadFullText");
            return (Criteria) this;
        }

        public Criteria andHadFullTextLessThan(String value) {
            addCriterion("had_full_text <", value, "hadFullText");
            return (Criteria) this;
        }

        public Criteria andHadFullTextLessThanOrEqualTo(String value) {
            addCriterion("had_full_text <=", value, "hadFullText");
            return (Criteria) this;
        }

        public Criteria andHadFullTextLike(String value) {
            addCriterion("had_full_text like", value, "hadFullText");
            return (Criteria) this;
        }

        public Criteria andHadFullTextNotLike(String value) {
            addCriterion("had_full_text not like", value, "hadFullText");
            return (Criteria) this;
        }

        public Criteria andHadFullTextIn(List<String> values) {
            addCriterion("had_full_text in", values, "hadFullText");
            return (Criteria) this;
        }

        public Criteria andHadFullTextNotIn(List<String> values) {
            addCriterion("had_full_text not in", values, "hadFullText");
            return (Criteria) this;
        }

        public Criteria andHadFullTextBetween(String value1, String value2) {
            addCriterion("had_full_text between", value1, value2, "hadFullText");
            return (Criteria) this;
        }

        public Criteria andHadFullTextNotBetween(String value1, String value2) {
            addCriterion("had_full_text not between", value1, value2, "hadFullText");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNotNull() {
            addCriterion("key_words is not null");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}