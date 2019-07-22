package com.boku.www.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbCnkiJournalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbCnkiJournalExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andTtitleIsNull() {
            addCriterion("tTitle is null");
            return (Criteria) this;
        }

        public Criteria andTtitleIsNotNull() {
            addCriterion("tTitle is not null");
            return (Criteria) this;
        }

        public Criteria andTtitleEqualTo(String value) {
            addCriterion("tTitle =", value, "ttitle");
            return (Criteria) this;
        }

        public Criteria andTtitleNotEqualTo(String value) {
            addCriterion("tTitle <>", value, "ttitle");
            return (Criteria) this;
        }

        public Criteria andTtitleGreaterThan(String value) {
            addCriterion("tTitle >", value, "ttitle");
            return (Criteria) this;
        }

        public Criteria andTtitleGreaterThanOrEqualTo(String value) {
            addCriterion("tTitle >=", value, "ttitle");
            return (Criteria) this;
        }

        public Criteria andTtitleLessThan(String value) {
            addCriterion("tTitle <", value, "ttitle");
            return (Criteria) this;
        }

        public Criteria andTtitleLessThanOrEqualTo(String value) {
            addCriterion("tTitle <=", value, "ttitle");
            return (Criteria) this;
        }

        public Criteria andTtitleLike(String value) {
            addCriterion("tTitle like", value, "ttitle");
            return (Criteria) this;
        }

        public Criteria andTtitleNotLike(String value) {
            addCriterion("tTitle not like", value, "ttitle");
            return (Criteria) this;
        }

        public Criteria andTtitleIn(List<String> values) {
            addCriterion("tTitle in", values, "ttitle");
            return (Criteria) this;
        }

        public Criteria andTtitleNotIn(List<String> values) {
            addCriterion("tTitle not in", values, "ttitle");
            return (Criteria) this;
        }

        public Criteria andTtitleBetween(String value1, String value2) {
            addCriterion("tTitle between", value1, value2, "ttitle");
            return (Criteria) this;
        }

        public Criteria andTtitleNotBetween(String value1, String value2) {
            addCriterion("tTitle not between", value1, value2, "ttitle");
            return (Criteria) this;
        }

        public Criteria andHostUnitIsNull() {
            addCriterion("host_unit is null");
            return (Criteria) this;
        }

        public Criteria andHostUnitIsNotNull() {
            addCriterion("host_unit is not null");
            return (Criteria) this;
        }

        public Criteria andHostUnitEqualTo(String value) {
            addCriterion("host_unit =", value, "hostUnit");
            return (Criteria) this;
        }

        public Criteria andHostUnitNotEqualTo(String value) {
            addCriterion("host_unit <>", value, "hostUnit");
            return (Criteria) this;
        }

        public Criteria andHostUnitGreaterThan(String value) {
            addCriterion("host_unit >", value, "hostUnit");
            return (Criteria) this;
        }

        public Criteria andHostUnitGreaterThanOrEqualTo(String value) {
            addCriterion("host_unit >=", value, "hostUnit");
            return (Criteria) this;
        }

        public Criteria andHostUnitLessThan(String value) {
            addCriterion("host_unit <", value, "hostUnit");
            return (Criteria) this;
        }

        public Criteria andHostUnitLessThanOrEqualTo(String value) {
            addCriterion("host_unit <=", value, "hostUnit");
            return (Criteria) this;
        }

        public Criteria andHostUnitLike(String value) {
            addCriterion("host_unit like", value, "hostUnit");
            return (Criteria) this;
        }

        public Criteria andHostUnitNotLike(String value) {
            addCriterion("host_unit not like", value, "hostUnit");
            return (Criteria) this;
        }

        public Criteria andHostUnitIn(List<String> values) {
            addCriterion("host_unit in", values, "hostUnit");
            return (Criteria) this;
        }

        public Criteria andHostUnitNotIn(List<String> values) {
            addCriterion("host_unit not in", values, "hostUnit");
            return (Criteria) this;
        }

        public Criteria andHostUnitBetween(String value1, String value2) {
            addCriterion("host_unit between", value1, value2, "hostUnit");
            return (Criteria) this;
        }

        public Criteria andHostUnitNotBetween(String value1, String value2) {
            addCriterion("host_unit not between", value1, value2, "hostUnit");
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

        public Criteria andPublicationCycleIsNull() {
            addCriterion("publication_cycle is null");
            return (Criteria) this;
        }

        public Criteria andPublicationCycleIsNotNull() {
            addCriterion("publication_cycle is not null");
            return (Criteria) this;
        }

        public Criteria andPublicationCycleEqualTo(String value) {
            addCriterion("publication_cycle =", value, "publicationCycle");
            return (Criteria) this;
        }

        public Criteria andPublicationCycleNotEqualTo(String value) {
            addCriterion("publication_cycle <>", value, "publicationCycle");
            return (Criteria) this;
        }

        public Criteria andPublicationCycleGreaterThan(String value) {
            addCriterion("publication_cycle >", value, "publicationCycle");
            return (Criteria) this;
        }

        public Criteria andPublicationCycleGreaterThanOrEqualTo(String value) {
            addCriterion("publication_cycle >=", value, "publicationCycle");
            return (Criteria) this;
        }

        public Criteria andPublicationCycleLessThan(String value) {
            addCriterion("publication_cycle <", value, "publicationCycle");
            return (Criteria) this;
        }

        public Criteria andPublicationCycleLessThanOrEqualTo(String value) {
            addCriterion("publication_cycle <=", value, "publicationCycle");
            return (Criteria) this;
        }

        public Criteria andPublicationCycleLike(String value) {
            addCriterion("publication_cycle like", value, "publicationCycle");
            return (Criteria) this;
        }

        public Criteria andPublicationCycleNotLike(String value) {
            addCriterion("publication_cycle not like", value, "publicationCycle");
            return (Criteria) this;
        }

        public Criteria andPublicationCycleIn(List<String> values) {
            addCriterion("publication_cycle in", values, "publicationCycle");
            return (Criteria) this;
        }

        public Criteria andPublicationCycleNotIn(List<String> values) {
            addCriterion("publication_cycle not in", values, "publicationCycle");
            return (Criteria) this;
        }

        public Criteria andPublicationCycleBetween(String value1, String value2) {
            addCriterion("publication_cycle between", value1, value2, "publicationCycle");
            return (Criteria) this;
        }

        public Criteria andPublicationCycleNotBetween(String value1, String value2) {
            addCriterion("publication_cycle not between", value1, value2, "publicationCycle");
            return (Criteria) this;
        }

        public Criteria andSourceDatabaseIsNull() {
            addCriterion("source_database is null");
            return (Criteria) this;
        }

        public Criteria andSourceDatabaseIsNotNull() {
            addCriterion("source_database is not null");
            return (Criteria) this;
        }

        public Criteria andSourceDatabaseEqualTo(String value) {
            addCriterion("source_database =", value, "sourceDatabase");
            return (Criteria) this;
        }

        public Criteria andSourceDatabaseNotEqualTo(String value) {
            addCriterion("source_database <>", value, "sourceDatabase");
            return (Criteria) this;
        }

        public Criteria andSourceDatabaseGreaterThan(String value) {
            addCriterion("source_database >", value, "sourceDatabase");
            return (Criteria) this;
        }

        public Criteria andSourceDatabaseGreaterThanOrEqualTo(String value) {
            addCriterion("source_database >=", value, "sourceDatabase");
            return (Criteria) this;
        }

        public Criteria andSourceDatabaseLessThan(String value) {
            addCriterion("source_database <", value, "sourceDatabase");
            return (Criteria) this;
        }

        public Criteria andSourceDatabaseLessThanOrEqualTo(String value) {
            addCriterion("source_database <=", value, "sourceDatabase");
            return (Criteria) this;
        }

        public Criteria andSourceDatabaseLike(String value) {
            addCriterion("source_database like", value, "sourceDatabase");
            return (Criteria) this;
        }

        public Criteria andSourceDatabaseNotLike(String value) {
            addCriterion("source_database not like", value, "sourceDatabase");
            return (Criteria) this;
        }

        public Criteria andSourceDatabaseIn(List<String> values) {
            addCriterion("source_database in", values, "sourceDatabase");
            return (Criteria) this;
        }

        public Criteria andSourceDatabaseNotIn(List<String> values) {
            addCriterion("source_database not in", values, "sourceDatabase");
            return (Criteria) this;
        }

        public Criteria andSourceDatabaseBetween(String value1, String value2) {
            addCriterion("source_database between", value1, value2, "sourceDatabase");
            return (Criteria) this;
        }

        public Criteria andSourceDatabaseNotBetween(String value1, String value2) {
            addCriterion("source_database not between", value1, value2, "sourceDatabase");
            return (Criteria) this;
        }

        public Criteria andCnIsNull() {
            addCriterion("CN is null");
            return (Criteria) this;
        }

        public Criteria andCnIsNotNull() {
            addCriterion("CN is not null");
            return (Criteria) this;
        }

        public Criteria andCnEqualTo(String value) {
            addCriterion("CN =", value, "cn");
            return (Criteria) this;
        }

        public Criteria andCnNotEqualTo(String value) {
            addCriterion("CN <>", value, "cn");
            return (Criteria) this;
        }

        public Criteria andCnGreaterThan(String value) {
            addCriterion("CN >", value, "cn");
            return (Criteria) this;
        }

        public Criteria andCnGreaterThanOrEqualTo(String value) {
            addCriterion("CN >=", value, "cn");
            return (Criteria) this;
        }

        public Criteria andCnLessThan(String value) {
            addCriterion("CN <", value, "cn");
            return (Criteria) this;
        }

        public Criteria andCnLessThanOrEqualTo(String value) {
            addCriterion("CN <=", value, "cn");
            return (Criteria) this;
        }

        public Criteria andCnLike(String value) {
            addCriterion("CN like", value, "cn");
            return (Criteria) this;
        }

        public Criteria andCnNotLike(String value) {
            addCriterion("CN not like", value, "cn");
            return (Criteria) this;
        }

        public Criteria andCnIn(List<String> values) {
            addCriterion("CN in", values, "cn");
            return (Criteria) this;
        }

        public Criteria andCnNotIn(List<String> values) {
            addCriterion("CN not in", values, "cn");
            return (Criteria) this;
        }

        public Criteria andCnBetween(String value1, String value2) {
            addCriterion("CN between", value1, value2, "cn");
            return (Criteria) this;
        }

        public Criteria andCnNotBetween(String value1, String value2) {
            addCriterion("CN not between", value1, value2, "cn");
            return (Criteria) this;
        }

        public Criteria andPlaceOfPublicationIsNull() {
            addCriterion("place_of_publication is null");
            return (Criteria) this;
        }

        public Criteria andPlaceOfPublicationIsNotNull() {
            addCriterion("place_of_publication is not null");
            return (Criteria) this;
        }

        public Criteria andPlaceOfPublicationEqualTo(String value) {
            addCriterion("place_of_publication =", value, "placeOfPublication");
            return (Criteria) this;
        }

        public Criteria andPlaceOfPublicationNotEqualTo(String value) {
            addCriterion("place_of_publication <>", value, "placeOfPublication");
            return (Criteria) this;
        }

        public Criteria andPlaceOfPublicationGreaterThan(String value) {
            addCriterion("place_of_publication >", value, "placeOfPublication");
            return (Criteria) this;
        }

        public Criteria andPlaceOfPublicationGreaterThanOrEqualTo(String value) {
            addCriterion("place_of_publication >=", value, "placeOfPublication");
            return (Criteria) this;
        }

        public Criteria andPlaceOfPublicationLessThan(String value) {
            addCriterion("place_of_publication <", value, "placeOfPublication");
            return (Criteria) this;
        }

        public Criteria andPlaceOfPublicationLessThanOrEqualTo(String value) {
            addCriterion("place_of_publication <=", value, "placeOfPublication");
            return (Criteria) this;
        }

        public Criteria andPlaceOfPublicationLike(String value) {
            addCriterion("place_of_publication like", value, "placeOfPublication");
            return (Criteria) this;
        }

        public Criteria andPlaceOfPublicationNotLike(String value) {
            addCriterion("place_of_publication not like", value, "placeOfPublication");
            return (Criteria) this;
        }

        public Criteria andPlaceOfPublicationIn(List<String> values) {
            addCriterion("place_of_publication in", values, "placeOfPublication");
            return (Criteria) this;
        }

        public Criteria andPlaceOfPublicationNotIn(List<String> values) {
            addCriterion("place_of_publication not in", values, "placeOfPublication");
            return (Criteria) this;
        }

        public Criteria andPlaceOfPublicationBetween(String value1, String value2) {
            addCriterion("place_of_publication between", value1, value2, "placeOfPublication");
            return (Criteria) this;
        }

        public Criteria andPlaceOfPublicationNotBetween(String value1, String value2) {
            addCriterion("place_of_publication not between", value1, value2, "placeOfPublication");
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

        public Criteria andBookSizeIsNull() {
            addCriterion("book_size is null");
            return (Criteria) this;
        }

        public Criteria andBookSizeIsNotNull() {
            addCriterion("book_size is not null");
            return (Criteria) this;
        }

        public Criteria andBookSizeEqualTo(String value) {
            addCriterion("book_size =", value, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeNotEqualTo(String value) {
            addCriterion("book_size <>", value, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeGreaterThan(String value) {
            addCriterion("book_size >", value, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeGreaterThanOrEqualTo(String value) {
            addCriterion("book_size >=", value, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeLessThan(String value) {
            addCriterion("book_size <", value, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeLessThanOrEqualTo(String value) {
            addCriterion("book_size <=", value, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeLike(String value) {
            addCriterion("book_size like", value, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeNotLike(String value) {
            addCriterion("book_size not like", value, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeIn(List<String> values) {
            addCriterion("book_size in", values, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeNotIn(List<String> values) {
            addCriterion("book_size not in", values, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeBetween(String value1, String value2) {
            addCriterion("book_size between", value1, value2, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeNotBetween(String value1, String value2) {
            addCriterion("book_size not between", value1, value2, "bookSize");
            return (Criteria) this;
        }

        public Criteria andPostIssueNumIsNull() {
            addCriterion("post_issue_num is null");
            return (Criteria) this;
        }

        public Criteria andPostIssueNumIsNotNull() {
            addCriterion("post_issue_num is not null");
            return (Criteria) this;
        }

        public Criteria andPostIssueNumEqualTo(String value) {
            addCriterion("post_issue_num =", value, "postIssueNum");
            return (Criteria) this;
        }

        public Criteria andPostIssueNumNotEqualTo(String value) {
            addCriterion("post_issue_num <>", value, "postIssueNum");
            return (Criteria) this;
        }

        public Criteria andPostIssueNumGreaterThan(String value) {
            addCriterion("post_issue_num >", value, "postIssueNum");
            return (Criteria) this;
        }

        public Criteria andPostIssueNumGreaterThanOrEqualTo(String value) {
            addCriterion("post_issue_num >=", value, "postIssueNum");
            return (Criteria) this;
        }

        public Criteria andPostIssueNumLessThan(String value) {
            addCriterion("post_issue_num <", value, "postIssueNum");
            return (Criteria) this;
        }

        public Criteria andPostIssueNumLessThanOrEqualTo(String value) {
            addCriterion("post_issue_num <=", value, "postIssueNum");
            return (Criteria) this;
        }

        public Criteria andPostIssueNumLike(String value) {
            addCriterion("post_issue_num like", value, "postIssueNum");
            return (Criteria) this;
        }

        public Criteria andPostIssueNumNotLike(String value) {
            addCriterion("post_issue_num not like", value, "postIssueNum");
            return (Criteria) this;
        }

        public Criteria andPostIssueNumIn(List<String> values) {
            addCriterion("post_issue_num in", values, "postIssueNum");
            return (Criteria) this;
        }

        public Criteria andPostIssueNumNotIn(List<String> values) {
            addCriterion("post_issue_num not in", values, "postIssueNum");
            return (Criteria) this;
        }

        public Criteria andPostIssueNumBetween(String value1, String value2) {
            addCriterion("post_issue_num between", value1, value2, "postIssueNum");
            return (Criteria) this;
        }

        public Criteria andPostIssueNumNotBetween(String value1, String value2) {
            addCriterion("post_issue_num not between", value1, value2, "postIssueNum");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(String value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(String value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(String value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(String value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(String value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(String value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLike(String value) {
            addCriterion("time like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotLike(String value) {
            addCriterion("time not like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<String> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<String> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(String value1, String value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(String value1, String value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andCdtitleIsNull() {
            addCriterion("CDTitle is null");
            return (Criteria) this;
        }

        public Criteria andCdtitleIsNotNull() {
            addCriterion("CDTitle is not null");
            return (Criteria) this;
        }

        public Criteria andCdtitleEqualTo(String value) {
            addCriterion("CDTitle =", value, "cdtitle");
            return (Criteria) this;
        }

        public Criteria andCdtitleNotEqualTo(String value) {
            addCriterion("CDTitle <>", value, "cdtitle");
            return (Criteria) this;
        }

        public Criteria andCdtitleGreaterThan(String value) {
            addCriterion("CDTitle >", value, "cdtitle");
            return (Criteria) this;
        }

        public Criteria andCdtitleGreaterThanOrEqualTo(String value) {
            addCriterion("CDTitle >=", value, "cdtitle");
            return (Criteria) this;
        }

        public Criteria andCdtitleLessThan(String value) {
            addCriterion("CDTitle <", value, "cdtitle");
            return (Criteria) this;
        }

        public Criteria andCdtitleLessThanOrEqualTo(String value) {
            addCriterion("CDTitle <=", value, "cdtitle");
            return (Criteria) this;
        }

        public Criteria andCdtitleLike(String value) {
            addCriterion("CDTitle like", value, "cdtitle");
            return (Criteria) this;
        }

        public Criteria andCdtitleNotLike(String value) {
            addCriterion("CDTitle not like", value, "cdtitle");
            return (Criteria) this;
        }

        public Criteria andCdtitleIn(List<String> values) {
            addCriterion("CDTitle in", values, "cdtitle");
            return (Criteria) this;
        }

        public Criteria andCdtitleNotIn(List<String> values) {
            addCriterion("CDTitle not in", values, "cdtitle");
            return (Criteria) this;
        }

        public Criteria andCdtitleBetween(String value1, String value2) {
            addCriterion("CDTitle between", value1, value2, "cdtitle");
            return (Criteria) this;
        }

        public Criteria andCdtitleNotBetween(String value1, String value2) {
            addCriterion("CDTitle not between", value1, value2, "cdtitle");
            return (Criteria) this;
        }

        public Criteria andSpecialNameIsNull() {
            addCriterion("special_name is null");
            return (Criteria) this;
        }

        public Criteria andSpecialNameIsNotNull() {
            addCriterion("special_name is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialNameEqualTo(String value) {
            addCriterion("special_name =", value, "specialName");
            return (Criteria) this;
        }

        public Criteria andSpecialNameNotEqualTo(String value) {
            addCriterion("special_name <>", value, "specialName");
            return (Criteria) this;
        }

        public Criteria andSpecialNameGreaterThan(String value) {
            addCriterion("special_name >", value, "specialName");
            return (Criteria) this;
        }

        public Criteria andSpecialNameGreaterThanOrEqualTo(String value) {
            addCriterion("special_name >=", value, "specialName");
            return (Criteria) this;
        }

        public Criteria andSpecialNameLessThan(String value) {
            addCriterion("special_name <", value, "specialName");
            return (Criteria) this;
        }

        public Criteria andSpecialNameLessThanOrEqualTo(String value) {
            addCriterion("special_name <=", value, "specialName");
            return (Criteria) this;
        }

        public Criteria andSpecialNameLike(String value) {
            addCriterion("special_name like", value, "specialName");
            return (Criteria) this;
        }

        public Criteria andSpecialNameNotLike(String value) {
            addCriterion("special_name not like", value, "specialName");
            return (Criteria) this;
        }

        public Criteria andSpecialNameIn(List<String> values) {
            addCriterion("special_name in", values, "specialName");
            return (Criteria) this;
        }

        public Criteria andSpecialNameNotIn(List<String> values) {
            addCriterion("special_name not in", values, "specialName");
            return (Criteria) this;
        }

        public Criteria andSpecialNameBetween(String value1, String value2) {
            addCriterion("special_name between", value1, value2, "specialName");
            return (Criteria) this;
        }

        public Criteria andSpecialNameNotBetween(String value1, String value2) {
            addCriterion("special_name not between", value1, value2, "specialName");
            return (Criteria) this;
        }

        public Criteria andLiteraturePublishedNumIsNull() {
            addCriterion("literature_published_num is null");
            return (Criteria) this;
        }

        public Criteria andLiteraturePublishedNumIsNotNull() {
            addCriterion("literature_published_num is not null");
            return (Criteria) this;
        }

        public Criteria andLiteraturePublishedNumEqualTo(String value) {
            addCriterion("literature_published_num =", value, "literaturePublishedNum");
            return (Criteria) this;
        }

        public Criteria andLiteraturePublishedNumNotEqualTo(String value) {
            addCriterion("literature_published_num <>", value, "literaturePublishedNum");
            return (Criteria) this;
        }

        public Criteria andLiteraturePublishedNumGreaterThan(String value) {
            addCriterion("literature_published_num >", value, "literaturePublishedNum");
            return (Criteria) this;
        }

        public Criteria andLiteraturePublishedNumGreaterThanOrEqualTo(String value) {
            addCriterion("literature_published_num >=", value, "literaturePublishedNum");
            return (Criteria) this;
        }

        public Criteria andLiteraturePublishedNumLessThan(String value) {
            addCriterion("literature_published_num <", value, "literaturePublishedNum");
            return (Criteria) this;
        }

        public Criteria andLiteraturePublishedNumLessThanOrEqualTo(String value) {
            addCriterion("literature_published_num <=", value, "literaturePublishedNum");
            return (Criteria) this;
        }

        public Criteria andLiteraturePublishedNumLike(String value) {
            addCriterion("literature_published_num like", value, "literaturePublishedNum");
            return (Criteria) this;
        }

        public Criteria andLiteraturePublishedNumNotLike(String value) {
            addCriterion("literature_published_num not like", value, "literaturePublishedNum");
            return (Criteria) this;
        }

        public Criteria andLiteraturePublishedNumIn(List<String> values) {
            addCriterion("literature_published_num in", values, "literaturePublishedNum");
            return (Criteria) this;
        }

        public Criteria andLiteraturePublishedNumNotIn(List<String> values) {
            addCriterion("literature_published_num not in", values, "literaturePublishedNum");
            return (Criteria) this;
        }

        public Criteria andLiteraturePublishedNumBetween(String value1, String value2) {
            addCriterion("literature_published_num between", value1, value2, "literaturePublishedNum");
            return (Criteria) this;
        }

        public Criteria andLiteraturePublishedNumNotBetween(String value1, String value2) {
            addCriterion("literature_published_num not between", value1, value2, "literaturePublishedNum");
            return (Criteria) this;
        }

        public Criteria andTotalDownloadsIsNull() {
            addCriterion("total_downloads is null");
            return (Criteria) this;
        }

        public Criteria andTotalDownloadsIsNotNull() {
            addCriterion("total_downloads is not null");
            return (Criteria) this;
        }

        public Criteria andTotalDownloadsEqualTo(String value) {
            addCriterion("total_downloads =", value, "totalDownloads");
            return (Criteria) this;
        }

        public Criteria andTotalDownloadsNotEqualTo(String value) {
            addCriterion("total_downloads <>", value, "totalDownloads");
            return (Criteria) this;
        }

        public Criteria andTotalDownloadsGreaterThan(String value) {
            addCriterion("total_downloads >", value, "totalDownloads");
            return (Criteria) this;
        }

        public Criteria andTotalDownloadsGreaterThanOrEqualTo(String value) {
            addCriterion("total_downloads >=", value, "totalDownloads");
            return (Criteria) this;
        }

        public Criteria andTotalDownloadsLessThan(String value) {
            addCriterion("total_downloads <", value, "totalDownloads");
            return (Criteria) this;
        }

        public Criteria andTotalDownloadsLessThanOrEqualTo(String value) {
            addCriterion("total_downloads <=", value, "totalDownloads");
            return (Criteria) this;
        }

        public Criteria andTotalDownloadsLike(String value) {
            addCriterion("total_downloads like", value, "totalDownloads");
            return (Criteria) this;
        }

        public Criteria andTotalDownloadsNotLike(String value) {
            addCriterion("total_downloads not like", value, "totalDownloads");
            return (Criteria) this;
        }

        public Criteria andTotalDownloadsIn(List<String> values) {
            addCriterion("total_downloads in", values, "totalDownloads");
            return (Criteria) this;
        }

        public Criteria andTotalDownloadsNotIn(List<String> values) {
            addCriterion("total_downloads not in", values, "totalDownloads");
            return (Criteria) this;
        }

        public Criteria andTotalDownloadsBetween(String value1, String value2) {
            addCriterion("total_downloads between", value1, value2, "totalDownloads");
            return (Criteria) this;
        }

        public Criteria andTotalDownloadsNotBetween(String value1, String value2) {
            addCriterion("total_downloads not between", value1, value2, "totalDownloads");
            return (Criteria) this;
        }

        public Criteria andTotalCitationsIsNull() {
            addCriterion("total_citations is null");
            return (Criteria) this;
        }

        public Criteria andTotalCitationsIsNotNull() {
            addCriterion("total_citations is not null");
            return (Criteria) this;
        }

        public Criteria andTotalCitationsEqualTo(String value) {
            addCriterion("total_citations =", value, "totalCitations");
            return (Criteria) this;
        }

        public Criteria andTotalCitationsNotEqualTo(String value) {
            addCriterion("total_citations <>", value, "totalCitations");
            return (Criteria) this;
        }

        public Criteria andTotalCitationsGreaterThan(String value) {
            addCriterion("total_citations >", value, "totalCitations");
            return (Criteria) this;
        }

        public Criteria andTotalCitationsGreaterThanOrEqualTo(String value) {
            addCriterion("total_citations >=", value, "totalCitations");
            return (Criteria) this;
        }

        public Criteria andTotalCitationsLessThan(String value) {
            addCriterion("total_citations <", value, "totalCitations");
            return (Criteria) this;
        }

        public Criteria andTotalCitationsLessThanOrEqualTo(String value) {
            addCriterion("total_citations <=", value, "totalCitations");
            return (Criteria) this;
        }

        public Criteria andTotalCitationsLike(String value) {
            addCriterion("total_citations like", value, "totalCitations");
            return (Criteria) this;
        }

        public Criteria andTotalCitationsNotLike(String value) {
            addCriterion("total_citations not like", value, "totalCitations");
            return (Criteria) this;
        }

        public Criteria andTotalCitationsIn(List<String> values) {
            addCriterion("total_citations in", values, "totalCitations");
            return (Criteria) this;
        }

        public Criteria andTotalCitationsNotIn(List<String> values) {
            addCriterion("total_citations not in", values, "totalCitations");
            return (Criteria) this;
        }

        public Criteria andTotalCitationsBetween(String value1, String value2) {
            addCriterion("total_citations between", value1, value2, "totalCitations");
            return (Criteria) this;
        }

        public Criteria andTotalCitationsNotBetween(String value1, String value2) {
            addCriterion("total_citations not between", value1, value2, "totalCitations");
            return (Criteria) this;
        }

        public Criteria andCurrentStateIsNull() {
            addCriterion("current_state is null");
            return (Criteria) this;
        }

        public Criteria andCurrentStateIsNotNull() {
            addCriterion("current_state is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentStateEqualTo(String value) {
            addCriterion("current_state =", value, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateNotEqualTo(String value) {
            addCriterion("current_state <>", value, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateGreaterThan(String value) {
            addCriterion("current_state >", value, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateGreaterThanOrEqualTo(String value) {
            addCriterion("current_state >=", value, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateLessThan(String value) {
            addCriterion("current_state <", value, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateLessThanOrEqualTo(String value) {
            addCriterion("current_state <=", value, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateLike(String value) {
            addCriterion("current_state like", value, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateNotLike(String value) {
            addCriterion("current_state not like", value, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateIn(List<String> values) {
            addCriterion("current_state in", values, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateNotIn(List<String> values) {
            addCriterion("current_state not in", values, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateBetween(String value1, String value2) {
            addCriterion("current_state between", value1, value2, "currentState");
            return (Criteria) this;
        }

        public Criteria andCurrentStateNotBetween(String value1, String value2) {
            addCriterion("current_state not between", value1, value2, "currentState");
            return (Criteria) this;
        }

        public Criteria andCombinedImpactFactorIsNull() {
            addCriterion("combined_impact_factor is null");
            return (Criteria) this;
        }

        public Criteria andCombinedImpactFactorIsNotNull() {
            addCriterion("combined_impact_factor is not null");
            return (Criteria) this;
        }

        public Criteria andCombinedImpactFactorEqualTo(String value) {
            addCriterion("combined_impact_factor =", value, "combinedImpactFactor");
            return (Criteria) this;
        }

        public Criteria andCombinedImpactFactorNotEqualTo(String value) {
            addCriterion("combined_impact_factor <>", value, "combinedImpactFactor");
            return (Criteria) this;
        }

        public Criteria andCombinedImpactFactorGreaterThan(String value) {
            addCriterion("combined_impact_factor >", value, "combinedImpactFactor");
            return (Criteria) this;
        }

        public Criteria andCombinedImpactFactorGreaterThanOrEqualTo(String value) {
            addCriterion("combined_impact_factor >=", value, "combinedImpactFactor");
            return (Criteria) this;
        }

        public Criteria andCombinedImpactFactorLessThan(String value) {
            addCriterion("combined_impact_factor <", value, "combinedImpactFactor");
            return (Criteria) this;
        }

        public Criteria andCombinedImpactFactorLessThanOrEqualTo(String value) {
            addCriterion("combined_impact_factor <=", value, "combinedImpactFactor");
            return (Criteria) this;
        }

        public Criteria andCombinedImpactFactorLike(String value) {
            addCriterion("combined_impact_factor like", value, "combinedImpactFactor");
            return (Criteria) this;
        }

        public Criteria andCombinedImpactFactorNotLike(String value) {
            addCriterion("combined_impact_factor not like", value, "combinedImpactFactor");
            return (Criteria) this;
        }

        public Criteria andCombinedImpactFactorIn(List<String> values) {
            addCriterion("combined_impact_factor in", values, "combinedImpactFactor");
            return (Criteria) this;
        }

        public Criteria andCombinedImpactFactorNotIn(List<String> values) {
            addCriterion("combined_impact_factor not in", values, "combinedImpactFactor");
            return (Criteria) this;
        }

        public Criteria andCombinedImpactFactorBetween(String value1, String value2) {
            addCriterion("combined_impact_factor between", value1, value2, "combinedImpactFactor");
            return (Criteria) this;
        }

        public Criteria andCombinedImpactFactorNotBetween(String value1, String value2) {
            addCriterion("combined_impact_factor not between", value1, value2, "combinedImpactFactor");
            return (Criteria) this;
        }

        public Criteria andCompoundImpactFactorIsNull() {
            addCriterion("compound_impact_factor is null");
            return (Criteria) this;
        }

        public Criteria andCompoundImpactFactorIsNotNull() {
            addCriterion("compound_impact_factor is not null");
            return (Criteria) this;
        }

        public Criteria andCompoundImpactFactorEqualTo(String value) {
            addCriterion("compound_impact_factor =", value, "compoundImpactFactor");
            return (Criteria) this;
        }

        public Criteria andCompoundImpactFactorNotEqualTo(String value) {
            addCriterion("compound_impact_factor <>", value, "compoundImpactFactor");
            return (Criteria) this;
        }

        public Criteria andCompoundImpactFactorGreaterThan(String value) {
            addCriterion("compound_impact_factor >", value, "compoundImpactFactor");
            return (Criteria) this;
        }

        public Criteria andCompoundImpactFactorGreaterThanOrEqualTo(String value) {
            addCriterion("compound_impact_factor >=", value, "compoundImpactFactor");
            return (Criteria) this;
        }

        public Criteria andCompoundImpactFactorLessThan(String value) {
            addCriterion("compound_impact_factor <", value, "compoundImpactFactor");
            return (Criteria) this;
        }

        public Criteria andCompoundImpactFactorLessThanOrEqualTo(String value) {
            addCriterion("compound_impact_factor <=", value, "compoundImpactFactor");
            return (Criteria) this;
        }

        public Criteria andCompoundImpactFactorLike(String value) {
            addCriterion("compound_impact_factor like", value, "compoundImpactFactor");
            return (Criteria) this;
        }

        public Criteria andCompoundImpactFactorNotLike(String value) {
            addCriterion("compound_impact_factor not like", value, "compoundImpactFactor");
            return (Criteria) this;
        }

        public Criteria andCompoundImpactFactorIn(List<String> values) {
            addCriterion("compound_impact_factor in", values, "compoundImpactFactor");
            return (Criteria) this;
        }

        public Criteria andCompoundImpactFactorNotIn(List<String> values) {
            addCriterion("compound_impact_factor not in", values, "compoundImpactFactor");
            return (Criteria) this;
        }

        public Criteria andCompoundImpactFactorBetween(String value1, String value2) {
            addCriterion("compound_impact_factor between", value1, value2, "compoundImpactFactor");
            return (Criteria) this;
        }

        public Criteria andCompoundImpactFactorNotBetween(String value1, String value2) {
            addCriterion("compound_impact_factor not between", value1, value2, "compoundImpactFactor");
            return (Criteria) this;
        }

        public Criteria andSpecialNameNumIsNull() {
            addCriterion("special_name_num is null");
            return (Criteria) this;
        }

        public Criteria andSpecialNameNumIsNotNull() {
            addCriterion("special_name_num is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialNameNumEqualTo(String value) {
            addCriterion("special_name_num =", value, "specialNameNum");
            return (Criteria) this;
        }

        public Criteria andSpecialNameNumNotEqualTo(String value) {
            addCriterion("special_name_num <>", value, "specialNameNum");
            return (Criteria) this;
        }

        public Criteria andSpecialNameNumGreaterThan(String value) {
            addCriterion("special_name_num >", value, "specialNameNum");
            return (Criteria) this;
        }

        public Criteria andSpecialNameNumGreaterThanOrEqualTo(String value) {
            addCriterion("special_name_num >=", value, "specialNameNum");
            return (Criteria) this;
        }

        public Criteria andSpecialNameNumLessThan(String value) {
            addCriterion("special_name_num <", value, "specialNameNum");
            return (Criteria) this;
        }

        public Criteria andSpecialNameNumLessThanOrEqualTo(String value) {
            addCriterion("special_name_num <=", value, "specialNameNum");
            return (Criteria) this;
        }

        public Criteria andSpecialNameNumLike(String value) {
            addCriterion("special_name_num like", value, "specialNameNum");
            return (Criteria) this;
        }

        public Criteria andSpecialNameNumNotLike(String value) {
            addCriterion("special_name_num not like", value, "specialNameNum");
            return (Criteria) this;
        }

        public Criteria andSpecialNameNumIn(List<String> values) {
            addCriterion("special_name_num in", values, "specialNameNum");
            return (Criteria) this;
        }

        public Criteria andSpecialNameNumNotIn(List<String> values) {
            addCriterion("special_name_num not in", values, "specialNameNum");
            return (Criteria) this;
        }

        public Criteria andSpecialNameNumBetween(String value1, String value2) {
            addCriterion("special_name_num between", value1, value2, "specialNameNum");
            return (Criteria) this;
        }

        public Criteria andSpecialNameNumNotBetween(String value1, String value2) {
            addCriterion("special_name_num not between", value1, value2, "specialNameNum");
            return (Criteria) this;
        }

        public Criteria andCorePerioIsNull() {
            addCriterion("core_perio is null");
            return (Criteria) this;
        }

        public Criteria andCorePerioIsNotNull() {
            addCriterion("core_perio is not null");
            return (Criteria) this;
        }

        public Criteria andCorePerioEqualTo(String value) {
            addCriterion("core_perio =", value, "corePerio");
            return (Criteria) this;
        }

        public Criteria andCorePerioNotEqualTo(String value) {
            addCriterion("core_perio <>", value, "corePerio");
            return (Criteria) this;
        }

        public Criteria andCorePerioGreaterThan(String value) {
            addCriterion("core_perio >", value, "corePerio");
            return (Criteria) this;
        }

        public Criteria andCorePerioGreaterThanOrEqualTo(String value) {
            addCriterion("core_perio >=", value, "corePerio");
            return (Criteria) this;
        }

        public Criteria andCorePerioLessThan(String value) {
            addCriterion("core_perio <", value, "corePerio");
            return (Criteria) this;
        }

        public Criteria andCorePerioLessThanOrEqualTo(String value) {
            addCriterion("core_perio <=", value, "corePerio");
            return (Criteria) this;
        }

        public Criteria andCorePerioLike(String value) {
            addCriterion("core_perio like", value, "corePerio");
            return (Criteria) this;
        }

        public Criteria andCorePerioNotLike(String value) {
            addCriterion("core_perio not like", value, "corePerio");
            return (Criteria) this;
        }

        public Criteria andCorePerioIn(List<String> values) {
            addCriterion("core_perio in", values, "corePerio");
            return (Criteria) this;
        }

        public Criteria andCorePerioNotIn(List<String> values) {
            addCriterion("core_perio not in", values, "corePerio");
            return (Criteria) this;
        }

        public Criteria andCorePerioBetween(String value1, String value2) {
            addCriterion("core_perio between", value1, value2, "corePerio");
            return (Criteria) this;
        }

        public Criteria andCorePerioNotBetween(String value1, String value2) {
            addCriterion("core_perio not between", value1, value2, "corePerio");
            return (Criteria) this;
        }

        public Criteria andSubareaIsNull() {
            addCriterion("subarea is null");
            return (Criteria) this;
        }

        public Criteria andSubareaIsNotNull() {
            addCriterion("subarea is not null");
            return (Criteria) this;
        }

        public Criteria andSubareaEqualTo(String value) {
            addCriterion("subarea =", value, "subarea");
            return (Criteria) this;
        }

        public Criteria andSubareaNotEqualTo(String value) {
            addCriterion("subarea <>", value, "subarea");
            return (Criteria) this;
        }

        public Criteria andSubareaGreaterThan(String value) {
            addCriterion("subarea >", value, "subarea");
            return (Criteria) this;
        }

        public Criteria andSubareaGreaterThanOrEqualTo(String value) {
            addCriterion("subarea >=", value, "subarea");
            return (Criteria) this;
        }

        public Criteria andSubareaLessThan(String value) {
            addCriterion("subarea <", value, "subarea");
            return (Criteria) this;
        }

        public Criteria andSubareaLessThanOrEqualTo(String value) {
            addCriterion("subarea <=", value, "subarea");
            return (Criteria) this;
        }

        public Criteria andSubareaLike(String value) {
            addCriterion("subarea like", value, "subarea");
            return (Criteria) this;
        }

        public Criteria andSubareaNotLike(String value) {
            addCriterion("subarea not like", value, "subarea");
            return (Criteria) this;
        }

        public Criteria andSubareaIn(List<String> values) {
            addCriterion("subarea in", values, "subarea");
            return (Criteria) this;
        }

        public Criteria andSubareaNotIn(List<String> values) {
            addCriterion("subarea not in", values, "subarea");
            return (Criteria) this;
        }

        public Criteria andSubareaBetween(String value1, String value2) {
            addCriterion("subarea between", value1, value2, "subarea");
            return (Criteria) this;
        }

        public Criteria andSubareaNotBetween(String value1, String value2) {
            addCriterion("subarea not between", value1, value2, "subarea");
            return (Criteria) this;
        }

        public Criteria andHasForeignKeyIsNull() {
            addCriterion("has_foreign_key is null");
            return (Criteria) this;
        }

        public Criteria andHasForeignKeyIsNotNull() {
            addCriterion("has_foreign_key is not null");
            return (Criteria) this;
        }

        public Criteria andHasForeignKeyEqualTo(Integer value) {
            addCriterion("has_foreign_key =", value, "hasForeignKey");
            return (Criteria) this;
        }

        public Criteria andHasForeignKeyNotEqualTo(Integer value) {
            addCriterion("has_foreign_key <>", value, "hasForeignKey");
            return (Criteria) this;
        }

        public Criteria andHasForeignKeyGreaterThan(Integer value) {
            addCriterion("has_foreign_key >", value, "hasForeignKey");
            return (Criteria) this;
        }

        public Criteria andHasForeignKeyGreaterThanOrEqualTo(Integer value) {
            addCriterion("has_foreign_key >=", value, "hasForeignKey");
            return (Criteria) this;
        }

        public Criteria andHasForeignKeyLessThan(Integer value) {
            addCriterion("has_foreign_key <", value, "hasForeignKey");
            return (Criteria) this;
        }

        public Criteria andHasForeignKeyLessThanOrEqualTo(Integer value) {
            addCriterion("has_foreign_key <=", value, "hasForeignKey");
            return (Criteria) this;
        }

        public Criteria andHasForeignKeyIn(List<Integer> values) {
            addCriterion("has_foreign_key in", values, "hasForeignKey");
            return (Criteria) this;
        }

        public Criteria andHasForeignKeyNotIn(List<Integer> values) {
            addCriterion("has_foreign_key not in", values, "hasForeignKey");
            return (Criteria) this;
        }

        public Criteria andHasForeignKeyBetween(Integer value1, Integer value2) {
            addCriterion("has_foreign_key between", value1, value2, "hasForeignKey");
            return (Criteria) this;
        }

        public Criteria andHasForeignKeyNotBetween(Integer value1, Integer value2) {
            addCriterion("has_foreign_key not between", value1, value2, "hasForeignKey");
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