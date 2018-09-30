package com.boku.www.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TThesisExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TThesisExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andDoiIsNull() {
            addCriterion("DOI is null");
            return (Criteria) this;
        }

        public Criteria andDoiIsNotNull() {
            addCriterion("DOI is not null");
            return (Criteria) this;
        }

        public Criteria andDoiEqualTo(String value) {
            addCriterion("DOI =", value, "doi");
            return (Criteria) this;
        }

        public Criteria andDoiNotEqualTo(String value) {
            addCriterion("DOI <>", value, "doi");
            return (Criteria) this;
        }

        public Criteria andDoiGreaterThan(String value) {
            addCriterion("DOI >", value, "doi");
            return (Criteria) this;
        }

        public Criteria andDoiGreaterThanOrEqualTo(String value) {
            addCriterion("DOI >=", value, "doi");
            return (Criteria) this;
        }

        public Criteria andDoiLessThan(String value) {
            addCriterion("DOI <", value, "doi");
            return (Criteria) this;
        }

        public Criteria andDoiLessThanOrEqualTo(String value) {
            addCriterion("DOI <=", value, "doi");
            return (Criteria) this;
        }

        public Criteria andDoiLike(String value) {
            addCriterion("DOI like", value, "doi");
            return (Criteria) this;
        }

        public Criteria andDoiNotLike(String value) {
            addCriterion("DOI not like", value, "doi");
            return (Criteria) this;
        }

        public Criteria andDoiIn(List<String> values) {
            addCriterion("DOI in", values, "doi");
            return (Criteria) this;
        }

        public Criteria andDoiNotIn(List<String> values) {
            addCriterion("DOI not in", values, "doi");
            return (Criteria) this;
        }

        public Criteria andDoiBetween(String value1, String value2) {
            addCriterion("DOI between", value1, value2, "doi");
            return (Criteria) this;
        }

        public Criteria andDoiNotBetween(String value1, String value2) {
            addCriterion("DOI not between", value1, value2, "doi");
            return (Criteria) this;
        }

        public Criteria andLiteratureResourcesIsNull() {
            addCriterion("literature_resources is null");
            return (Criteria) this;
        }

        public Criteria andLiteratureResourcesIsNotNull() {
            addCriterion("literature_resources is not null");
            return (Criteria) this;
        }

        public Criteria andLiteratureResourcesEqualTo(String value) {
            addCriterion("literature_resources =", value, "literatureResources");
            return (Criteria) this;
        }

        public Criteria andLiteratureResourcesNotEqualTo(String value) {
            addCriterion("literature_resources <>", value, "literatureResources");
            return (Criteria) this;
        }

        public Criteria andLiteratureResourcesGreaterThan(String value) {
            addCriterion("literature_resources >", value, "literatureResources");
            return (Criteria) this;
        }

        public Criteria andLiteratureResourcesGreaterThanOrEqualTo(String value) {
            addCriterion("literature_resources >=", value, "literatureResources");
            return (Criteria) this;
        }

        public Criteria andLiteratureResourcesLessThan(String value) {
            addCriterion("literature_resources <", value, "literatureResources");
            return (Criteria) this;
        }

        public Criteria andLiteratureResourcesLessThanOrEqualTo(String value) {
            addCriterion("literature_resources <=", value, "literatureResources");
            return (Criteria) this;
        }

        public Criteria andLiteratureResourcesLike(String value) {
            addCriterion("literature_resources like", value, "literatureResources");
            return (Criteria) this;
        }

        public Criteria andLiteratureResourcesNotLike(String value) {
            addCriterion("literature_resources not like", value, "literatureResources");
            return (Criteria) this;
        }

        public Criteria andLiteratureResourcesIn(List<String> values) {
            addCriterion("literature_resources in", values, "literatureResources");
            return (Criteria) this;
        }

        public Criteria andLiteratureResourcesNotIn(List<String> values) {
            addCriterion("literature_resources not in", values, "literatureResources");
            return (Criteria) this;
        }

        public Criteria andLiteratureResourcesBetween(String value1, String value2) {
            addCriterion("literature_resources between", value1, value2, "literatureResources");
            return (Criteria) this;
        }

        public Criteria andLiteratureResourcesNotBetween(String value1, String value2) {
            addCriterion("literature_resources not between", value1, value2, "literatureResources");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Date value) {
            addCriterionForJDBCDate("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Date value) {
            addCriterionForJDBCDate("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Date value) {
            addCriterionForJDBCDate("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Date value) {
            addCriterionForJDBCDate("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Date> values) {
            addCriterionForJDBCDate("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Date> values) {
            addCriterionForJDBCDate("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andRollIsNull() {
            addCriterion("roll is null");
            return (Criteria) this;
        }

        public Criteria andRollIsNotNull() {
            addCriterion("roll is not null");
            return (Criteria) this;
        }

        public Criteria andRollEqualTo(String value) {
            addCriterion("roll =", value, "roll");
            return (Criteria) this;
        }

        public Criteria andRollNotEqualTo(String value) {
            addCriterion("roll <>", value, "roll");
            return (Criteria) this;
        }

        public Criteria andRollGreaterThan(String value) {
            addCriterion("roll >", value, "roll");
            return (Criteria) this;
        }

        public Criteria andRollGreaterThanOrEqualTo(String value) {
            addCriterion("roll >=", value, "roll");
            return (Criteria) this;
        }

        public Criteria andRollLessThan(String value) {
            addCriterion("roll <", value, "roll");
            return (Criteria) this;
        }

        public Criteria andRollLessThanOrEqualTo(String value) {
            addCriterion("roll <=", value, "roll");
            return (Criteria) this;
        }

        public Criteria andRollLike(String value) {
            addCriterion("roll like", value, "roll");
            return (Criteria) this;
        }

        public Criteria andRollNotLike(String value) {
            addCriterion("roll not like", value, "roll");
            return (Criteria) this;
        }

        public Criteria andRollIn(List<String> values) {
            addCriterion("roll in", values, "roll");
            return (Criteria) this;
        }

        public Criteria andRollNotIn(List<String> values) {
            addCriterion("roll not in", values, "roll");
            return (Criteria) this;
        }

        public Criteria andRollBetween(String value1, String value2) {
            addCriterion("roll between", value1, value2, "roll");
            return (Criteria) this;
        }

        public Criteria andRollNotBetween(String value1, String value2) {
            addCriterion("roll not between", value1, value2, "roll");
            return (Criteria) this;
        }

        public Criteria andJournalIsNull() {
            addCriterion("journal is null");
            return (Criteria) this;
        }

        public Criteria andJournalIsNotNull() {
            addCriterion("journal is not null");
            return (Criteria) this;
        }

        public Criteria andJournalEqualTo(String value) {
            addCriterion("journal =", value, "journal");
            return (Criteria) this;
        }

        public Criteria andJournalNotEqualTo(String value) {
            addCriterion("journal <>", value, "journal");
            return (Criteria) this;
        }

        public Criteria andJournalGreaterThan(String value) {
            addCriterion("journal >", value, "journal");
            return (Criteria) this;
        }

        public Criteria andJournalGreaterThanOrEqualTo(String value) {
            addCriterion("journal >=", value, "journal");
            return (Criteria) this;
        }

        public Criteria andJournalLessThan(String value) {
            addCriterion("journal <", value, "journal");
            return (Criteria) this;
        }

        public Criteria andJournalLessThanOrEqualTo(String value) {
            addCriterion("journal <=", value, "journal");
            return (Criteria) this;
        }

        public Criteria andJournalLike(String value) {
            addCriterion("journal like", value, "journal");
            return (Criteria) this;
        }

        public Criteria andJournalNotLike(String value) {
            addCriterion("journal not like", value, "journal");
            return (Criteria) this;
        }

        public Criteria andJournalIn(List<String> values) {
            addCriterion("journal in", values, "journal");
            return (Criteria) this;
        }

        public Criteria andJournalNotIn(List<String> values) {
            addCriterion("journal not in", values, "journal");
            return (Criteria) this;
        }

        public Criteria andJournalBetween(String value1, String value2) {
            addCriterion("journal between", value1, value2, "journal");
            return (Criteria) this;
        }

        public Criteria andJournalNotBetween(String value1, String value2) {
            addCriterion("journal not between", value1, value2, "journal");
            return (Criteria) this;
        }

        public Criteria andIssnIsNull() {
            addCriterion("ISSN is null");
            return (Criteria) this;
        }

        public Criteria andIssnIsNotNull() {
            addCriterion("ISSN is not null");
            return (Criteria) this;
        }

        public Criteria andIssnEqualTo(String value) {
            addCriterion("ISSN =", value, "issn");
            return (Criteria) this;
        }

        public Criteria andIssnNotEqualTo(String value) {
            addCriterion("ISSN <>", value, "issn");
            return (Criteria) this;
        }

        public Criteria andIssnGreaterThan(String value) {
            addCriterion("ISSN >", value, "issn");
            return (Criteria) this;
        }

        public Criteria andIssnGreaterThanOrEqualTo(String value) {
            addCriterion("ISSN >=", value, "issn");
            return (Criteria) this;
        }

        public Criteria andIssnLessThan(String value) {
            addCriterion("ISSN <", value, "issn");
            return (Criteria) this;
        }

        public Criteria andIssnLessThanOrEqualTo(String value) {
            addCriterion("ISSN <=", value, "issn");
            return (Criteria) this;
        }

        public Criteria andIssnLike(String value) {
            addCriterion("ISSN like", value, "issn");
            return (Criteria) this;
        }

        public Criteria andIssnNotLike(String value) {
            addCriterion("ISSN not like", value, "issn");
            return (Criteria) this;
        }

        public Criteria andIssnIn(List<String> values) {
            addCriterion("ISSN in", values, "issn");
            return (Criteria) this;
        }

        public Criteria andIssnNotIn(List<String> values) {
            addCriterion("ISSN not in", values, "issn");
            return (Criteria) this;
        }

        public Criteria andIssnBetween(String value1, String value2) {
            addCriterion("ISSN between", value1, value2, "issn");
            return (Criteria) this;
        }

        public Criteria andIssnNotBetween(String value1, String value2) {
            addCriterion("ISSN not between", value1, value2, "issn");
            return (Criteria) this;
        }

        public Criteria andPageIsNull() {
            addCriterion("page is null");
            return (Criteria) this;
        }

        public Criteria andPageIsNotNull() {
            addCriterion("page is not null");
            return (Criteria) this;
        }

        public Criteria andPageEqualTo(String value) {
            addCriterion("page =", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageNotEqualTo(String value) {
            addCriterion("page <>", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageGreaterThan(String value) {
            addCriterion("page >", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageGreaterThanOrEqualTo(String value) {
            addCriterion("page >=", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageLessThan(String value) {
            addCriterion("page <", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageLessThanOrEqualTo(String value) {
            addCriterion("page <=", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageLike(String value) {
            addCriterion("page like", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageNotLike(String value) {
            addCriterion("page not like", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageIn(List<String> values) {
            addCriterion("page in", values, "page");
            return (Criteria) this;
        }

        public Criteria andPageNotIn(List<String> values) {
            addCriterion("page not in", values, "page");
            return (Criteria) this;
        }

        public Criteria andPageBetween(String value1, String value2) {
            addCriterion("page between", value1, value2, "page");
            return (Criteria) this;
        }

        public Criteria andPageNotBetween(String value1, String value2) {
            addCriterion("page not between", value1, value2, "page");
            return (Criteria) this;
        }

        public Criteria andOrganizationIsNull() {
            addCriterion("organization is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationIsNotNull() {
            addCriterion("organization is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationEqualTo(String value) {
            addCriterion("organization =", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationNotEqualTo(String value) {
            addCriterion("organization <>", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationGreaterThan(String value) {
            addCriterion("organization >", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationGreaterThanOrEqualTo(String value) {
            addCriterion("organization >=", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationLessThan(String value) {
            addCriterion("organization <", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationLessThanOrEqualTo(String value) {
            addCriterion("organization <=", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationLike(String value) {
            addCriterion("organization like", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationNotLike(String value) {
            addCriterion("organization not like", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationIn(List<String> values) {
            addCriterion("organization in", values, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationNotIn(List<String> values) {
            addCriterion("organization not in", values, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationBetween(String value1, String value2) {
            addCriterion("organization between", value1, value2, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationNotBetween(String value1, String value2) {
            addCriterion("organization not between", value1, value2, "organization");
            return (Criteria) this;
        }

        public Criteria andResultIdIsNull() {
            addCriterion("result_id is null");
            return (Criteria) this;
        }

        public Criteria andResultIdIsNotNull() {
            addCriterion("result_id is not null");
            return (Criteria) this;
        }

        public Criteria andResultIdEqualTo(String value) {
            addCriterion("result_id =", value, "resultId");
            return (Criteria) this;
        }

        public Criteria andResultIdNotEqualTo(String value) {
            addCriterion("result_id <>", value, "resultId");
            return (Criteria) this;
        }

        public Criteria andResultIdGreaterThan(String value) {
            addCriterion("result_id >", value, "resultId");
            return (Criteria) this;
        }

        public Criteria andResultIdGreaterThanOrEqualTo(String value) {
            addCriterion("result_id >=", value, "resultId");
            return (Criteria) this;
        }

        public Criteria andResultIdLessThan(String value) {
            addCriterion("result_id <", value, "resultId");
            return (Criteria) this;
        }

        public Criteria andResultIdLessThanOrEqualTo(String value) {
            addCriterion("result_id <=", value, "resultId");
            return (Criteria) this;
        }

        public Criteria andResultIdLike(String value) {
            addCriterion("result_id like", value, "resultId");
            return (Criteria) this;
        }

        public Criteria andResultIdNotLike(String value) {
            addCriterion("result_id not like", value, "resultId");
            return (Criteria) this;
        }

        public Criteria andResultIdIn(List<String> values) {
            addCriterion("result_id in", values, "resultId");
            return (Criteria) this;
        }

        public Criteria andResultIdNotIn(List<String> values) {
            addCriterion("result_id not in", values, "resultId");
            return (Criteria) this;
        }

        public Criteria andResultIdBetween(String value1, String value2) {
            addCriterion("result_id between", value1, value2, "resultId");
            return (Criteria) this;
        }

        public Criteria andResultIdNotBetween(String value1, String value2) {
            addCriterion("result_id not between", value1, value2, "resultId");
            return (Criteria) this;
        }

        public Criteria andProjectNumIsNull() {
            addCriterion("project_num is null");
            return (Criteria) this;
        }

        public Criteria andProjectNumIsNotNull() {
            addCriterion("project_num is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNumEqualTo(String value) {
            addCriterion("project_num =", value, "projectNum");
            return (Criteria) this;
        }

        public Criteria andProjectNumNotEqualTo(String value) {
            addCriterion("project_num <>", value, "projectNum");
            return (Criteria) this;
        }

        public Criteria andProjectNumGreaterThan(String value) {
            addCriterion("project_num >", value, "projectNum");
            return (Criteria) this;
        }

        public Criteria andProjectNumGreaterThanOrEqualTo(String value) {
            addCriterion("project_num >=", value, "projectNum");
            return (Criteria) this;
        }

        public Criteria andProjectNumLessThan(String value) {
            addCriterion("project_num <", value, "projectNum");
            return (Criteria) this;
        }

        public Criteria andProjectNumLessThanOrEqualTo(String value) {
            addCriterion("project_num <=", value, "projectNum");
            return (Criteria) this;
        }

        public Criteria andProjectNumLike(String value) {
            addCriterion("project_num like", value, "projectNum");
            return (Criteria) this;
        }

        public Criteria andProjectNumNotLike(String value) {
            addCriterion("project_num not like", value, "projectNum");
            return (Criteria) this;
        }

        public Criteria andProjectNumIn(List<String> values) {
            addCriterion("project_num in", values, "projectNum");
            return (Criteria) this;
        }

        public Criteria andProjectNumNotIn(List<String> values) {
            addCriterion("project_num not in", values, "projectNum");
            return (Criteria) this;
        }

        public Criteria andProjectNumBetween(String value1, String value2) {
            addCriterion("project_num between", value1, value2, "projectNum");
            return (Criteria) this;
        }

        public Criteria andProjectNumNotBetween(String value1, String value2) {
            addCriterion("project_num not between", value1, value2, "projectNum");
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