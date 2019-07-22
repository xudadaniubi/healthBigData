package com.boku.www.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbWanfangJournalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbWanfangJournalExample() {
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

        public Criteria andPerioTitleIsNull() {
            addCriterion("perio_title is null");
            return (Criteria) this;
        }

        public Criteria andPerioTitleIsNotNull() {
            addCriterion("perio_title is not null");
            return (Criteria) this;
        }

        public Criteria andPerioTitleEqualTo(String value) {
            addCriterion("perio_title =", value, "perioTitle");
            return (Criteria) this;
        }

        public Criteria andPerioTitleNotEqualTo(String value) {
            addCriterion("perio_title <>", value, "perioTitle");
            return (Criteria) this;
        }

        public Criteria andPerioTitleGreaterThan(String value) {
            addCriterion("perio_title >", value, "perioTitle");
            return (Criteria) this;
        }

        public Criteria andPerioTitleGreaterThanOrEqualTo(String value) {
            addCriterion("perio_title >=", value, "perioTitle");
            return (Criteria) this;
        }

        public Criteria andPerioTitleLessThan(String value) {
            addCriterion("perio_title <", value, "perioTitle");
            return (Criteria) this;
        }

        public Criteria andPerioTitleLessThanOrEqualTo(String value) {
            addCriterion("perio_title <=", value, "perioTitle");
            return (Criteria) this;
        }

        public Criteria andPerioTitleLike(String value) {
            addCriterion("perio_title like", value, "perioTitle");
            return (Criteria) this;
        }

        public Criteria andPerioTitleNotLike(String value) {
            addCriterion("perio_title not like", value, "perioTitle");
            return (Criteria) this;
        }

        public Criteria andPerioTitleIn(List<String> values) {
            addCriterion("perio_title in", values, "perioTitle");
            return (Criteria) this;
        }

        public Criteria andPerioTitleNotIn(List<String> values) {
            addCriterion("perio_title not in", values, "perioTitle");
            return (Criteria) this;
        }

        public Criteria andPerioTitleBetween(String value1, String value2) {
            addCriterion("perio_title between", value1, value2, "perioTitle");
            return (Criteria) this;
        }

        public Criteria andPerioTitleNotBetween(String value1, String value2) {
            addCriterion("perio_title not between", value1, value2, "perioTitle");
            return (Criteria) this;
        }

        public Criteria andFormerNameIsNull() {
            addCriterion("former_name is null");
            return (Criteria) this;
        }

        public Criteria andFormerNameIsNotNull() {
            addCriterion("former_name is not null");
            return (Criteria) this;
        }

        public Criteria andFormerNameEqualTo(String value) {
            addCriterion("former_name =", value, "formerName");
            return (Criteria) this;
        }

        public Criteria andFormerNameNotEqualTo(String value) {
            addCriterion("former_name <>", value, "formerName");
            return (Criteria) this;
        }

        public Criteria andFormerNameGreaterThan(String value) {
            addCriterion("former_name >", value, "formerName");
            return (Criteria) this;
        }

        public Criteria andFormerNameGreaterThanOrEqualTo(String value) {
            addCriterion("former_name >=", value, "formerName");
            return (Criteria) this;
        }

        public Criteria andFormerNameLessThan(String value) {
            addCriterion("former_name <", value, "formerName");
            return (Criteria) this;
        }

        public Criteria andFormerNameLessThanOrEqualTo(String value) {
            addCriterion("former_name <=", value, "formerName");
            return (Criteria) this;
        }

        public Criteria andFormerNameLike(String value) {
            addCriterion("former_name like", value, "formerName");
            return (Criteria) this;
        }

        public Criteria andFormerNameNotLike(String value) {
            addCriterion("former_name not like", value, "formerName");
            return (Criteria) this;
        }

        public Criteria andFormerNameIn(List<String> values) {
            addCriterion("former_name in", values, "formerName");
            return (Criteria) this;
        }

        public Criteria andFormerNameNotIn(List<String> values) {
            addCriterion("former_name not in", values, "formerName");
            return (Criteria) this;
        }

        public Criteria andFormerNameBetween(String value1, String value2) {
            addCriterion("former_name between", value1, value2, "formerName");
            return (Criteria) this;
        }

        public Criteria andFormerNameNotBetween(String value1, String value2) {
            addCriterion("former_name not between", value1, value2, "formerName");
            return (Criteria) this;
        }

        public Criteria andPinyinTitleIsNull() {
            addCriterion("pinyin_title is null");
            return (Criteria) this;
        }

        public Criteria andPinyinTitleIsNotNull() {
            addCriterion("pinyin_title is not null");
            return (Criteria) this;
        }

        public Criteria andPinyinTitleEqualTo(String value) {
            addCriterion("pinyin_title =", value, "pinyinTitle");
            return (Criteria) this;
        }

        public Criteria andPinyinTitleNotEqualTo(String value) {
            addCriterion("pinyin_title <>", value, "pinyinTitle");
            return (Criteria) this;
        }

        public Criteria andPinyinTitleGreaterThan(String value) {
            addCriterion("pinyin_title >", value, "pinyinTitle");
            return (Criteria) this;
        }

        public Criteria andPinyinTitleGreaterThanOrEqualTo(String value) {
            addCriterion("pinyin_title >=", value, "pinyinTitle");
            return (Criteria) this;
        }

        public Criteria andPinyinTitleLessThan(String value) {
            addCriterion("pinyin_title <", value, "pinyinTitle");
            return (Criteria) this;
        }

        public Criteria andPinyinTitleLessThanOrEqualTo(String value) {
            addCriterion("pinyin_title <=", value, "pinyinTitle");
            return (Criteria) this;
        }

        public Criteria andPinyinTitleLike(String value) {
            addCriterion("pinyin_title like", value, "pinyinTitle");
            return (Criteria) this;
        }

        public Criteria andPinyinTitleNotLike(String value) {
            addCriterion("pinyin_title not like", value, "pinyinTitle");
            return (Criteria) this;
        }

        public Criteria andPinyinTitleIn(List<String> values) {
            addCriterion("pinyin_title in", values, "pinyinTitle");
            return (Criteria) this;
        }

        public Criteria andPinyinTitleNotIn(List<String> values) {
            addCriterion("pinyin_title not in", values, "pinyinTitle");
            return (Criteria) this;
        }

        public Criteria andPinyinTitleBetween(String value1, String value2) {
            addCriterion("pinyin_title between", value1, value2, "pinyinTitle");
            return (Criteria) this;
        }

        public Criteria andPinyinTitleNotBetween(String value1, String value2) {
            addCriterion("pinyin_title not between", value1, value2, "pinyinTitle");
            return (Criteria) this;
        }

        public Criteria andTransTitleIsNull() {
            addCriterion("trans_title is null");
            return (Criteria) this;
        }

        public Criteria andTransTitleIsNotNull() {
            addCriterion("trans_title is not null");
            return (Criteria) this;
        }

        public Criteria andTransTitleEqualTo(String value) {
            addCriterion("trans_title =", value, "transTitle");
            return (Criteria) this;
        }

        public Criteria andTransTitleNotEqualTo(String value) {
            addCriterion("trans_title <>", value, "transTitle");
            return (Criteria) this;
        }

        public Criteria andTransTitleGreaterThan(String value) {
            addCriterion("trans_title >", value, "transTitle");
            return (Criteria) this;
        }

        public Criteria andTransTitleGreaterThanOrEqualTo(String value) {
            addCriterion("trans_title >=", value, "transTitle");
            return (Criteria) this;
        }

        public Criteria andTransTitleLessThan(String value) {
            addCriterion("trans_title <", value, "transTitle");
            return (Criteria) this;
        }

        public Criteria andTransTitleLessThanOrEqualTo(String value) {
            addCriterion("trans_title <=", value, "transTitle");
            return (Criteria) this;
        }

        public Criteria andTransTitleLike(String value) {
            addCriterion("trans_title like", value, "transTitle");
            return (Criteria) this;
        }

        public Criteria andTransTitleNotLike(String value) {
            addCriterion("trans_title not like", value, "transTitle");
            return (Criteria) this;
        }

        public Criteria andTransTitleIn(List<String> values) {
            addCriterion("trans_title in", values, "transTitle");
            return (Criteria) this;
        }

        public Criteria andTransTitleNotIn(List<String> values) {
            addCriterion("trans_title not in", values, "transTitle");
            return (Criteria) this;
        }

        public Criteria andTransTitleBetween(String value1, String value2) {
            addCriterion("trans_title between", value1, value2, "transTitle");
            return (Criteria) this;
        }

        public Criteria andTransTitleNotBetween(String value1, String value2) {
            addCriterion("trans_title not between", value1, value2, "transTitle");
            return (Criteria) this;
        }

        public Criteria andProprieterIsNull() {
            addCriterion("proprieter is null");
            return (Criteria) this;
        }

        public Criteria andProprieterIsNotNull() {
            addCriterion("proprieter is not null");
            return (Criteria) this;
        }

        public Criteria andProprieterEqualTo(String value) {
            addCriterion("proprieter =", value, "proprieter");
            return (Criteria) this;
        }

        public Criteria andProprieterNotEqualTo(String value) {
            addCriterion("proprieter <>", value, "proprieter");
            return (Criteria) this;
        }

        public Criteria andProprieterGreaterThan(String value) {
            addCriterion("proprieter >", value, "proprieter");
            return (Criteria) this;
        }

        public Criteria andProprieterGreaterThanOrEqualTo(String value) {
            addCriterion("proprieter >=", value, "proprieter");
            return (Criteria) this;
        }

        public Criteria andProprieterLessThan(String value) {
            addCriterion("proprieter <", value, "proprieter");
            return (Criteria) this;
        }

        public Criteria andProprieterLessThanOrEqualTo(String value) {
            addCriterion("proprieter <=", value, "proprieter");
            return (Criteria) this;
        }

        public Criteria andProprieterLike(String value) {
            addCriterion("proprieter like", value, "proprieter");
            return (Criteria) this;
        }

        public Criteria andProprieterNotLike(String value) {
            addCriterion("proprieter not like", value, "proprieter");
            return (Criteria) this;
        }

        public Criteria andProprieterIn(List<String> values) {
            addCriterion("proprieter in", values, "proprieter");
            return (Criteria) this;
        }

        public Criteria andProprieterNotIn(List<String> values) {
            addCriterion("proprieter not in", values, "proprieter");
            return (Criteria) this;
        }

        public Criteria andProprieterBetween(String value1, String value2) {
            addCriterion("proprieter between", value1, value2, "proprieter");
            return (Criteria) this;
        }

        public Criteria andProprieterNotBetween(String value1, String value2) {
            addCriterion("proprieter not between", value1, value2, "proprieter");
            return (Criteria) this;
        }

        public Criteria andAvgPerioDownIsNull() {
            addCriterion("avg_perio_down is null");
            return (Criteria) this;
        }

        public Criteria andAvgPerioDownIsNotNull() {
            addCriterion("avg_perio_down is not null");
            return (Criteria) this;
        }

        public Criteria andAvgPerioDownEqualTo(Double value) {
            addCriterion("avg_perio_down =", value, "avgPerioDown");
            return (Criteria) this;
        }

        public Criteria andAvgPerioDownNotEqualTo(Double value) {
            addCriterion("avg_perio_down <>", value, "avgPerioDown");
            return (Criteria) this;
        }

        public Criteria andAvgPerioDownGreaterThan(Double value) {
            addCriterion("avg_perio_down >", value, "avgPerioDown");
            return (Criteria) this;
        }

        public Criteria andAvgPerioDownGreaterThanOrEqualTo(Double value) {
            addCriterion("avg_perio_down >=", value, "avgPerioDown");
            return (Criteria) this;
        }

        public Criteria andAvgPerioDownLessThan(Double value) {
            addCriterion("avg_perio_down <", value, "avgPerioDown");
            return (Criteria) this;
        }

        public Criteria andAvgPerioDownLessThanOrEqualTo(Double value) {
            addCriterion("avg_perio_down <=", value, "avgPerioDown");
            return (Criteria) this;
        }

        public Criteria andAvgPerioDownIn(List<Double> values) {
            addCriterion("avg_perio_down in", values, "avgPerioDown");
            return (Criteria) this;
        }

        public Criteria andAvgPerioDownNotIn(List<Double> values) {
            addCriterion("avg_perio_down not in", values, "avgPerioDown");
            return (Criteria) this;
        }

        public Criteria andAvgPerioDownBetween(Double value1, Double value2) {
            addCriterion("avg_perio_down between", value1, value2, "avgPerioDown");
            return (Criteria) this;
        }

        public Criteria andAvgPerioDownNotBetween(Double value1, Double value2) {
            addCriterion("avg_perio_down not between", value1, value2, "avgPerioDown");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNull() {
            addCriterion("keywords is null");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNotNull() {
            addCriterion("keywords is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordsEqualTo(String value) {
            addCriterion("keywords =", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotEqualTo(String value) {
            addCriterion("keywords <>", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThan(String value) {
            addCriterion("keywords >", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("keywords >=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThan(String value) {
            addCriterion("keywords <", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThanOrEqualTo(String value) {
            addCriterion("keywords <=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLike(String value) {
            addCriterion("keywords like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotLike(String value) {
            addCriterion("keywords not like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsIn(List<String> values) {
            addCriterion("keywords in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotIn(List<String> values) {
            addCriterion("keywords not in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsBetween(String value1, String value2) {
            addCriterion("keywords between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotBetween(String value1, String value2) {
            addCriterion("keywords not between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andPerioIdIsNull() {
            addCriterion("perio_id is null");
            return (Criteria) this;
        }

        public Criteria andPerioIdIsNotNull() {
            addCriterion("perio_id is not null");
            return (Criteria) this;
        }

        public Criteria andPerioIdEqualTo(String value) {
            addCriterion("perio_id =", value, "perioId");
            return (Criteria) this;
        }

        public Criteria andPerioIdNotEqualTo(String value) {
            addCriterion("perio_id <>", value, "perioId");
            return (Criteria) this;
        }

        public Criteria andPerioIdGreaterThan(String value) {
            addCriterion("perio_id >", value, "perioId");
            return (Criteria) this;
        }

        public Criteria andPerioIdGreaterThanOrEqualTo(String value) {
            addCriterion("perio_id >=", value, "perioId");
            return (Criteria) this;
        }

        public Criteria andPerioIdLessThan(String value) {
            addCriterion("perio_id <", value, "perioId");
            return (Criteria) this;
        }

        public Criteria andPerioIdLessThanOrEqualTo(String value) {
            addCriterion("perio_id <=", value, "perioId");
            return (Criteria) this;
        }

        public Criteria andPerioIdLike(String value) {
            addCriterion("perio_id like", value, "perioId");
            return (Criteria) this;
        }

        public Criteria andPerioIdNotLike(String value) {
            addCriterion("perio_id not like", value, "perioId");
            return (Criteria) this;
        }

        public Criteria andPerioIdIn(List<String> values) {
            addCriterion("perio_id in", values, "perioId");
            return (Criteria) this;
        }

        public Criteria andPerioIdNotIn(List<String> values) {
            addCriterion("perio_id not in", values, "perioId");
            return (Criteria) this;
        }

        public Criteria andPerioIdBetween(String value1, String value2) {
            addCriterion("perio_id between", value1, value2, "perioId");
            return (Criteria) this;
        }

        public Criteria andPerioIdNotBetween(String value1, String value2) {
            addCriterion("perio_id not between", value1, value2, "perioId");
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

        public Criteria andMajorEditorIsNull() {
            addCriterion("major_editor is null");
            return (Criteria) this;
        }

        public Criteria andMajorEditorIsNotNull() {
            addCriterion("major_editor is not null");
            return (Criteria) this;
        }

        public Criteria andMajorEditorEqualTo(String value) {
            addCriterion("major_editor =", value, "majorEditor");
            return (Criteria) this;
        }

        public Criteria andMajorEditorNotEqualTo(String value) {
            addCriterion("major_editor <>", value, "majorEditor");
            return (Criteria) this;
        }

        public Criteria andMajorEditorGreaterThan(String value) {
            addCriterion("major_editor >", value, "majorEditor");
            return (Criteria) this;
        }

        public Criteria andMajorEditorGreaterThanOrEqualTo(String value) {
            addCriterion("major_editor >=", value, "majorEditor");
            return (Criteria) this;
        }

        public Criteria andMajorEditorLessThan(String value) {
            addCriterion("major_editor <", value, "majorEditor");
            return (Criteria) this;
        }

        public Criteria andMajorEditorLessThanOrEqualTo(String value) {
            addCriterion("major_editor <=", value, "majorEditor");
            return (Criteria) this;
        }

        public Criteria andMajorEditorLike(String value) {
            addCriterion("major_editor like", value, "majorEditor");
            return (Criteria) this;
        }

        public Criteria andMajorEditorNotLike(String value) {
            addCriterion("major_editor not like", value, "majorEditor");
            return (Criteria) this;
        }

        public Criteria andMajorEditorIn(List<String> values) {
            addCriterion("major_editor in", values, "majorEditor");
            return (Criteria) this;
        }

        public Criteria andMajorEditorNotIn(List<String> values) {
            addCriterion("major_editor not in", values, "majorEditor");
            return (Criteria) this;
        }

        public Criteria andMajorEditorBetween(String value1, String value2) {
            addCriterion("major_editor between", value1, value2, "majorEditor");
            return (Criteria) this;
        }

        public Criteria andMajorEditorNotBetween(String value1, String value2) {
            addCriterion("major_editor not between", value1, value2, "majorEditor");
            return (Criteria) this;
        }

        public Criteria andClassTypeIsNull() {
            addCriterion("class_type is null");
            return (Criteria) this;
        }

        public Criteria andClassTypeIsNotNull() {
            addCriterion("class_type is not null");
            return (Criteria) this;
        }

        public Criteria andClassTypeEqualTo(String value) {
            addCriterion("class_type =", value, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeNotEqualTo(String value) {
            addCriterion("class_type <>", value, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeGreaterThan(String value) {
            addCriterion("class_type >", value, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeGreaterThanOrEqualTo(String value) {
            addCriterion("class_type >=", value, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeLessThan(String value) {
            addCriterion("class_type <", value, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeLessThanOrEqualTo(String value) {
            addCriterion("class_type <=", value, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeLike(String value) {
            addCriterion("class_type like", value, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeNotLike(String value) {
            addCriterion("class_type not like", value, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeIn(List<String> values) {
            addCriterion("class_type in", values, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeNotIn(List<String> values) {
            addCriterion("class_type not in", values, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeBetween(String value1, String value2) {
            addCriterion("class_type between", value1, value2, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeNotBetween(String value1, String value2) {
            addCriterion("class_type not between", value1, value2, "classType");
            return (Criteria) this;
        }

        public Criteria andStartYear02IsNull() {
            addCriterion("start_year02 is null");
            return (Criteria) this;
        }

        public Criteria andStartYear02IsNotNull() {
            addCriterion("start_year02 is not null");
            return (Criteria) this;
        }

        public Criteria andStartYear02EqualTo(Long value) {
            addCriterion("start_year02 =", value, "startYear02");
            return (Criteria) this;
        }

        public Criteria andStartYear02NotEqualTo(Long value) {
            addCriterion("start_year02 <>", value, "startYear02");
            return (Criteria) this;
        }

        public Criteria andStartYear02GreaterThan(Long value) {
            addCriterion("start_year02 >", value, "startYear02");
            return (Criteria) this;
        }

        public Criteria andStartYear02GreaterThanOrEqualTo(Long value) {
            addCriterion("start_year02 >=", value, "startYear02");
            return (Criteria) this;
        }

        public Criteria andStartYear02LessThan(Long value) {
            addCriterion("start_year02 <", value, "startYear02");
            return (Criteria) this;
        }

        public Criteria andStartYear02LessThanOrEqualTo(Long value) {
            addCriterion("start_year02 <=", value, "startYear02");
            return (Criteria) this;
        }

        public Criteria andStartYear02In(List<Long> values) {
            addCriterion("start_year02 in", values, "startYear02");
            return (Criteria) this;
        }

        public Criteria andStartYear02NotIn(List<Long> values) {
            addCriterion("start_year02 not in", values, "startYear02");
            return (Criteria) this;
        }

        public Criteria andStartYear02Between(Long value1, Long value2) {
            addCriterion("start_year02 between", value1, value2, "startYear02");
            return (Criteria) this;
        }

        public Criteria andStartYear02NotBetween(Long value1, Long value2) {
            addCriterion("start_year02 not between", value1, value2, "startYear02");
            return (Criteria) this;
        }

        public Criteria andPerioFormatIsNull() {
            addCriterion("perio_format is null");
            return (Criteria) this;
        }

        public Criteria andPerioFormatIsNotNull() {
            addCriterion("perio_format is not null");
            return (Criteria) this;
        }

        public Criteria andPerioFormatEqualTo(String value) {
            addCriterion("perio_format =", value, "perioFormat");
            return (Criteria) this;
        }

        public Criteria andPerioFormatNotEqualTo(String value) {
            addCriterion("perio_format <>", value, "perioFormat");
            return (Criteria) this;
        }

        public Criteria andPerioFormatGreaterThan(String value) {
            addCriterion("perio_format >", value, "perioFormat");
            return (Criteria) this;
        }

        public Criteria andPerioFormatGreaterThanOrEqualTo(String value) {
            addCriterion("perio_format >=", value, "perioFormat");
            return (Criteria) this;
        }

        public Criteria andPerioFormatLessThan(String value) {
            addCriterion("perio_format <", value, "perioFormat");
            return (Criteria) this;
        }

        public Criteria andPerioFormatLessThanOrEqualTo(String value) {
            addCriterion("perio_format <=", value, "perioFormat");
            return (Criteria) this;
        }

        public Criteria andPerioFormatLike(String value) {
            addCriterion("perio_format like", value, "perioFormat");
            return (Criteria) this;
        }

        public Criteria andPerioFormatNotLike(String value) {
            addCriterion("perio_format not like", value, "perioFormat");
            return (Criteria) this;
        }

        public Criteria andPerioFormatIn(List<String> values) {
            addCriterion("perio_format in", values, "perioFormat");
            return (Criteria) this;
        }

        public Criteria andPerioFormatNotIn(List<String> values) {
            addCriterion("perio_format not in", values, "perioFormat");
            return (Criteria) this;
        }

        public Criteria andPerioFormatBetween(String value1, String value2) {
            addCriterion("perio_format between", value1, value2, "perioFormat");
            return (Criteria) this;
        }

        public Criteria andPerioFormatNotBetween(String value1, String value2) {
            addCriterion("perio_format not between", value1, value2, "perioFormat");
            return (Criteria) this;
        }

        public Criteria andIssuePostcodeIsNull() {
            addCriterion("issue_postcode is null");
            return (Criteria) this;
        }

        public Criteria andIssuePostcodeIsNotNull() {
            addCriterion("issue_postcode is not null");
            return (Criteria) this;
        }

        public Criteria andIssuePostcodeEqualTo(String value) {
            addCriterion("issue_postcode =", value, "issuePostcode");
            return (Criteria) this;
        }

        public Criteria andIssuePostcodeNotEqualTo(String value) {
            addCriterion("issue_postcode <>", value, "issuePostcode");
            return (Criteria) this;
        }

        public Criteria andIssuePostcodeGreaterThan(String value) {
            addCriterion("issue_postcode >", value, "issuePostcode");
            return (Criteria) this;
        }

        public Criteria andIssuePostcodeGreaterThanOrEqualTo(String value) {
            addCriterion("issue_postcode >=", value, "issuePostcode");
            return (Criteria) this;
        }

        public Criteria andIssuePostcodeLessThan(String value) {
            addCriterion("issue_postcode <", value, "issuePostcode");
            return (Criteria) this;
        }

        public Criteria andIssuePostcodeLessThanOrEqualTo(String value) {
            addCriterion("issue_postcode <=", value, "issuePostcode");
            return (Criteria) this;
        }

        public Criteria andIssuePostcodeLike(String value) {
            addCriterion("issue_postcode like", value, "issuePostcode");
            return (Criteria) this;
        }

        public Criteria andIssuePostcodeNotLike(String value) {
            addCriterion("issue_postcode not like", value, "issuePostcode");
            return (Criteria) this;
        }

        public Criteria andIssuePostcodeIn(List<String> values) {
            addCriterion("issue_postcode in", values, "issuePostcode");
            return (Criteria) this;
        }

        public Criteria andIssuePostcodeNotIn(List<String> values) {
            addCriterion("issue_postcode not in", values, "issuePostcode");
            return (Criteria) this;
        }

        public Criteria andIssuePostcodeBetween(String value1, String value2) {
            addCriterion("issue_postcode between", value1, value2, "issuePostcode");
            return (Criteria) this;
        }

        public Criteria andIssuePostcodeNotBetween(String value1, String value2) {
            addCriterion("issue_postcode not between", value1, value2, "issuePostcode");
            return (Criteria) this;
        }

        public Criteria andFaxIsNull() {
            addCriterion("fax is null");
            return (Criteria) this;
        }

        public Criteria andFaxIsNotNull() {
            addCriterion("fax is not null");
            return (Criteria) this;
        }

        public Criteria andFaxEqualTo(String value) {
            addCriterion("fax =", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotEqualTo(String value) {
            addCriterion("fax <>", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThan(String value) {
            addCriterion("fax >", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThanOrEqualTo(String value) {
            addCriterion("fax >=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThan(String value) {
            addCriterion("fax <", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThanOrEqualTo(String value) {
            addCriterion("fax <=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLike(String value) {
            addCriterion("fax like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotLike(String value) {
            addCriterion("fax not like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxIn(List<String> values) {
            addCriterion("fax in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotIn(List<String> values) {
            addCriterion("fax not in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxBetween(String value1, String value2) {
            addCriterion("fax between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotBetween(String value1, String value2) {
            addCriterion("fax not between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andShareNumIsNull() {
            addCriterion("share_num is null");
            return (Criteria) this;
        }

        public Criteria andShareNumIsNotNull() {
            addCriterion("share_num is not null");
            return (Criteria) this;
        }

        public Criteria andShareNumEqualTo(Integer value) {
            addCriterion("share_num =", value, "shareNum");
            return (Criteria) this;
        }

        public Criteria andShareNumNotEqualTo(Integer value) {
            addCriterion("share_num <>", value, "shareNum");
            return (Criteria) this;
        }

        public Criteria andShareNumGreaterThan(Integer value) {
            addCriterion("share_num >", value, "shareNum");
            return (Criteria) this;
        }

        public Criteria andShareNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("share_num >=", value, "shareNum");
            return (Criteria) this;
        }

        public Criteria andShareNumLessThan(Integer value) {
            addCriterion("share_num <", value, "shareNum");
            return (Criteria) this;
        }

        public Criteria andShareNumLessThanOrEqualTo(Integer value) {
            addCriterion("share_num <=", value, "shareNum");
            return (Criteria) this;
        }

        public Criteria andShareNumIn(List<Integer> values) {
            addCriterion("share_num in", values, "shareNum");
            return (Criteria) this;
        }

        public Criteria andShareNumNotIn(List<Integer> values) {
            addCriterion("share_num not in", values, "shareNum");
            return (Criteria) this;
        }

        public Criteria andShareNumBetween(Integer value1, Integer value2) {
            addCriterion("share_num between", value1, value2, "shareNum");
            return (Criteria) this;
        }

        public Criteria andShareNumNotBetween(Integer value1, Integer value2) {
            addCriterion("share_num not between", value1, value2, "shareNum");
            return (Criteria) this;
        }

        public Criteria andClasscodeLevelIsNull() {
            addCriterion("classcode_level is null");
            return (Criteria) this;
        }

        public Criteria andClasscodeLevelIsNotNull() {
            addCriterion("classcode_level is not null");
            return (Criteria) this;
        }

        public Criteria andClasscodeLevelEqualTo(String value) {
            addCriterion("classcode_level =", value, "classcodeLevel");
            return (Criteria) this;
        }

        public Criteria andClasscodeLevelNotEqualTo(String value) {
            addCriterion("classcode_level <>", value, "classcodeLevel");
            return (Criteria) this;
        }

        public Criteria andClasscodeLevelGreaterThan(String value) {
            addCriterion("classcode_level >", value, "classcodeLevel");
            return (Criteria) this;
        }

        public Criteria andClasscodeLevelGreaterThanOrEqualTo(String value) {
            addCriterion("classcode_level >=", value, "classcodeLevel");
            return (Criteria) this;
        }

        public Criteria andClasscodeLevelLessThan(String value) {
            addCriterion("classcode_level <", value, "classcodeLevel");
            return (Criteria) this;
        }

        public Criteria andClasscodeLevelLessThanOrEqualTo(String value) {
            addCriterion("classcode_level <=", value, "classcodeLevel");
            return (Criteria) this;
        }

        public Criteria andClasscodeLevelLike(String value) {
            addCriterion("classcode_level like", value, "classcodeLevel");
            return (Criteria) this;
        }

        public Criteria andClasscodeLevelNotLike(String value) {
            addCriterion("classcode_level not like", value, "classcodeLevel");
            return (Criteria) this;
        }

        public Criteria andClasscodeLevelIn(List<String> values) {
            addCriterion("classcode_level in", values, "classcodeLevel");
            return (Criteria) this;
        }

        public Criteria andClasscodeLevelNotIn(List<String> values) {
            addCriterion("classcode_level not in", values, "classcodeLevel");
            return (Criteria) this;
        }

        public Criteria andClasscodeLevelBetween(String value1, String value2) {
            addCriterion("classcode_level between", value1, value2, "classcodeLevel");
            return (Criteria) this;
        }

        public Criteria andClasscodeLevelNotBetween(String value1, String value2) {
            addCriterion("classcode_level not between", value1, value2, "classcodeLevel");
            return (Criteria) this;
        }

        public Criteria andPublishCycleIsNull() {
            addCriterion("publish_cycle is null");
            return (Criteria) this;
        }

        public Criteria andPublishCycleIsNotNull() {
            addCriterion("publish_cycle is not null");
            return (Criteria) this;
        }

        public Criteria andPublishCycleEqualTo(String value) {
            addCriterion("publish_cycle =", value, "publishCycle");
            return (Criteria) this;
        }

        public Criteria andPublishCycleNotEqualTo(String value) {
            addCriterion("publish_cycle <>", value, "publishCycle");
            return (Criteria) this;
        }

        public Criteria andPublishCycleGreaterThan(String value) {
            addCriterion("publish_cycle >", value, "publishCycle");
            return (Criteria) this;
        }

        public Criteria andPublishCycleGreaterThanOrEqualTo(String value) {
            addCriterion("publish_cycle >=", value, "publishCycle");
            return (Criteria) this;
        }

        public Criteria andPublishCycleLessThan(String value) {
            addCriterion("publish_cycle <", value, "publishCycle");
            return (Criteria) this;
        }

        public Criteria andPublishCycleLessThanOrEqualTo(String value) {
            addCriterion("publish_cycle <=", value, "publishCycle");
            return (Criteria) this;
        }

        public Criteria andPublishCycleLike(String value) {
            addCriterion("publish_cycle like", value, "publishCycle");
            return (Criteria) this;
        }

        public Criteria andPublishCycleNotLike(String value) {
            addCriterion("publish_cycle not like", value, "publishCycle");
            return (Criteria) this;
        }

        public Criteria andPublishCycleIn(List<String> values) {
            addCriterion("publish_cycle in", values, "publishCycle");
            return (Criteria) this;
        }

        public Criteria andPublishCycleNotIn(List<String> values) {
            addCriterion("publish_cycle not in", values, "publishCycle");
            return (Criteria) this;
        }

        public Criteria andPublishCycleBetween(String value1, String value2) {
            addCriterion("publish_cycle between", value1, value2, "publishCycle");
            return (Criteria) this;
        }

        public Criteria andPublishCycleNotBetween(String value1, String value2) {
            addCriterion("publish_cycle not between", value1, value2, "publishCycle");
            return (Criteria) this;
        }

        public Criteria andAvgArticleDownIsNull() {
            addCriterion("avg_article_down is null");
            return (Criteria) this;
        }

        public Criteria andAvgArticleDownIsNotNull() {
            addCriterion("avg_article_down is not null");
            return (Criteria) this;
        }

        public Criteria andAvgArticleDownEqualTo(String value) {
            addCriterion("avg_article_down =", value, "avgArticleDown");
            return (Criteria) this;
        }

        public Criteria andAvgArticleDownNotEqualTo(String value) {
            addCriterion("avg_article_down <>", value, "avgArticleDown");
            return (Criteria) this;
        }

        public Criteria andAvgArticleDownGreaterThan(String value) {
            addCriterion("avg_article_down >", value, "avgArticleDown");
            return (Criteria) this;
        }

        public Criteria andAvgArticleDownGreaterThanOrEqualTo(String value) {
            addCriterion("avg_article_down >=", value, "avgArticleDown");
            return (Criteria) this;
        }

        public Criteria andAvgArticleDownLessThan(String value) {
            addCriterion("avg_article_down <", value, "avgArticleDown");
            return (Criteria) this;
        }

        public Criteria andAvgArticleDownLessThanOrEqualTo(String value) {
            addCriterion("avg_article_down <=", value, "avgArticleDown");
            return (Criteria) this;
        }

        public Criteria andAvgArticleDownLike(String value) {
            addCriterion("avg_article_down like", value, "avgArticleDown");
            return (Criteria) this;
        }

        public Criteria andAvgArticleDownNotLike(String value) {
            addCriterion("avg_article_down not like", value, "avgArticleDown");
            return (Criteria) this;
        }

        public Criteria andAvgArticleDownIn(List<String> values) {
            addCriterion("avg_article_down in", values, "avgArticleDown");
            return (Criteria) this;
        }

        public Criteria andAvgArticleDownNotIn(List<String> values) {
            addCriterion("avg_article_down not in", values, "avgArticleDown");
            return (Criteria) this;
        }

        public Criteria andAvgArticleDownBetween(String value1, String value2) {
            addCriterion("avg_article_down between", value1, value2, "avgArticleDown");
            return (Criteria) this;
        }

        public Criteria andAvgArticleDownNotBetween(String value1, String value2) {
            addCriterion("avg_article_down not between", value1, value2, "avgArticleDown");
            return (Criteria) this;
        }

        public Criteria andHostunitNameIsNull() {
            addCriterion("hostunit_name is null");
            return (Criteria) this;
        }

        public Criteria andHostunitNameIsNotNull() {
            addCriterion("hostunit_name is not null");
            return (Criteria) this;
        }

        public Criteria andHostunitNameEqualTo(String value) {
            addCriterion("hostunit_name =", value, "hostunitName");
            return (Criteria) this;
        }

        public Criteria andHostunitNameNotEqualTo(String value) {
            addCriterion("hostunit_name <>", value, "hostunitName");
            return (Criteria) this;
        }

        public Criteria andHostunitNameGreaterThan(String value) {
            addCriterion("hostunit_name >", value, "hostunitName");
            return (Criteria) this;
        }

        public Criteria andHostunitNameGreaterThanOrEqualTo(String value) {
            addCriterion("hostunit_name >=", value, "hostunitName");
            return (Criteria) this;
        }

        public Criteria andHostunitNameLessThan(String value) {
            addCriterion("hostunit_name <", value, "hostunitName");
            return (Criteria) this;
        }

        public Criteria andHostunitNameLessThanOrEqualTo(String value) {
            addCriterion("hostunit_name <=", value, "hostunitName");
            return (Criteria) this;
        }

        public Criteria andHostunitNameLike(String value) {
            addCriterion("hostunit_name like", value, "hostunitName");
            return (Criteria) this;
        }

        public Criteria andHostunitNameNotLike(String value) {
            addCriterion("hostunit_name not like", value, "hostunitName");
            return (Criteria) this;
        }

        public Criteria andHostunitNameIn(List<String> values) {
            addCriterion("hostunit_name in", values, "hostunitName");
            return (Criteria) this;
        }

        public Criteria andHostunitNameNotIn(List<String> values) {
            addCriterion("hostunit_name not in", values, "hostunitName");
            return (Criteria) this;
        }

        public Criteria andHostunitNameBetween(String value1, String value2) {
            addCriterion("hostunit_name between", value1, value2, "hostunitName");
            return (Criteria) this;
        }

        public Criteria andHostunitNameNotBetween(String value1, String value2) {
            addCriterion("hostunit_name not between", value1, value2, "hostunitName");
            return (Criteria) this;
        }

        public Criteria andDirectorIsNull() {
            addCriterion("director is null");
            return (Criteria) this;
        }

        public Criteria andDirectorIsNotNull() {
            addCriterion("director is not null");
            return (Criteria) this;
        }

        public Criteria andDirectorEqualTo(String value) {
            addCriterion("director =", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorNotEqualTo(String value) {
            addCriterion("director <>", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorGreaterThan(String value) {
            addCriterion("director >", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorGreaterThanOrEqualTo(String value) {
            addCriterion("director >=", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorLessThan(String value) {
            addCriterion("director <", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorLessThanOrEqualTo(String value) {
            addCriterion("director <=", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorLike(String value) {
            addCriterion("director like", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorNotLike(String value) {
            addCriterion("director not like", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorIn(List<String> values) {
            addCriterion("director in", values, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorNotIn(List<String> values) {
            addCriterion("director not in", values, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorBetween(String value1, String value2) {
            addCriterion("director between", value1, value2, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorNotBetween(String value1, String value2) {
            addCriterion("director not between", value1, value2, "director");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNull() {
            addCriterion("postcode is null");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNotNull() {
            addCriterion("postcode is not null");
            return (Criteria) this;
        }

        public Criteria andPostcodeEqualTo(String value) {
            addCriterion("postcode =", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotEqualTo(String value) {
            addCriterion("postcode <>", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThan(String value) {
            addCriterion("postcode >", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThanOrEqualTo(String value) {
            addCriterion("postcode >=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThan(String value) {
            addCriterion("postcode <", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThanOrEqualTo(String value) {
            addCriterion("postcode <=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLike(String value) {
            addCriterion("postcode like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotLike(String value) {
            addCriterion("postcode not like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeIn(List<String> values) {
            addCriterion("postcode in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotIn(List<String> values) {
            addCriterion("postcode not in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeBetween(String value1, String value2) {
            addCriterion("postcode between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotBetween(String value1, String value2) {
            addCriterion("postcode not between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andCiteNumIsNull() {
            addCriterion("cite_num is null");
            return (Criteria) this;
        }

        public Criteria andCiteNumIsNotNull() {
            addCriterion("cite_num is not null");
            return (Criteria) this;
        }

        public Criteria andCiteNumEqualTo(Integer value) {
            addCriterion("cite_num =", value, "citeNum");
            return (Criteria) this;
        }

        public Criteria andCiteNumNotEqualTo(Integer value) {
            addCriterion("cite_num <>", value, "citeNum");
            return (Criteria) this;
        }

        public Criteria andCiteNumGreaterThan(Integer value) {
            addCriterion("cite_num >", value, "citeNum");
            return (Criteria) this;
        }

        public Criteria andCiteNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("cite_num >=", value, "citeNum");
            return (Criteria) this;
        }

        public Criteria andCiteNumLessThan(Integer value) {
            addCriterion("cite_num <", value, "citeNum");
            return (Criteria) this;
        }

        public Criteria andCiteNumLessThanOrEqualTo(Integer value) {
            addCriterion("cite_num <=", value, "citeNum");
            return (Criteria) this;
        }

        public Criteria andCiteNumIn(List<Integer> values) {
            addCriterion("cite_num in", values, "citeNum");
            return (Criteria) this;
        }

        public Criteria andCiteNumNotIn(List<Integer> values) {
            addCriterion("cite_num not in", values, "citeNum");
            return (Criteria) this;
        }

        public Criteria andCiteNumBetween(Integer value1, Integer value2) {
            addCriterion("cite_num between", value1, value2, "citeNum");
            return (Criteria) this;
        }

        public Criteria andCiteNumNotBetween(Integer value1, Integer value2) {
            addCriterion("cite_num not between", value1, value2, "citeNum");
            return (Criteria) this;
        }

        public Criteria andCountryCodeIsNull() {
            addCriterion("country_code is null");
            return (Criteria) this;
        }

        public Criteria andCountryCodeIsNotNull() {
            addCriterion("country_code is not null");
            return (Criteria) this;
        }

        public Criteria andCountryCodeEqualTo(String value) {
            addCriterion("country_code =", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeNotEqualTo(String value) {
            addCriterion("country_code <>", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeGreaterThan(String value) {
            addCriterion("country_code >", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("country_code >=", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeLessThan(String value) {
            addCriterion("country_code <", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeLessThanOrEqualTo(String value) {
            addCriterion("country_code <=", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeLike(String value) {
            addCriterion("country_code like", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeNotLike(String value) {
            addCriterion("country_code not like", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeIn(List<String> values) {
            addCriterion("country_code in", values, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeNotIn(List<String> values) {
            addCriterion("country_code not in", values, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeBetween(String value1, String value2) {
            addCriterion("country_code between", value1, value2, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeNotBetween(String value1, String value2) {
            addCriterion("country_code not between", value1, value2, "countryCode");
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

        public Criteria andDataStateIsNull() {
            addCriterion("data_state is null");
            return (Criteria) this;
        }

        public Criteria andDataStateIsNotNull() {
            addCriterion("data_state is not null");
            return (Criteria) this;
        }

        public Criteria andDataStateEqualTo(String value) {
            addCriterion("data_state =", value, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateNotEqualTo(String value) {
            addCriterion("data_state <>", value, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateGreaterThan(String value) {
            addCriterion("data_state >", value, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateGreaterThanOrEqualTo(String value) {
            addCriterion("data_state >=", value, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateLessThan(String value) {
            addCriterion("data_state <", value, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateLessThanOrEqualTo(String value) {
            addCriterion("data_state <=", value, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateLike(String value) {
            addCriterion("data_state like", value, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateNotLike(String value) {
            addCriterion("data_state not like", value, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateIn(List<String> values) {
            addCriterion("data_state in", values, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateNotIn(List<String> values) {
            addCriterion("data_state not in", values, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateBetween(String value1, String value2) {
            addCriterion("data_state between", value1, value2, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateNotBetween(String value1, String value2) {
            addCriterion("data_state not between", value1, value2, "dataState");
            return (Criteria) this;
        }

        public Criteria andEfNameIsNull() {
            addCriterion("ef_name is null");
            return (Criteria) this;
        }

        public Criteria andEfNameIsNotNull() {
            addCriterion("ef_name is not null");
            return (Criteria) this;
        }

        public Criteria andEfNameEqualTo(String value) {
            addCriterion("ef_name =", value, "efName");
            return (Criteria) this;
        }

        public Criteria andEfNameNotEqualTo(String value) {
            addCriterion("ef_name <>", value, "efName");
            return (Criteria) this;
        }

        public Criteria andEfNameGreaterThan(String value) {
            addCriterion("ef_name >", value, "efName");
            return (Criteria) this;
        }

        public Criteria andEfNameGreaterThanOrEqualTo(String value) {
            addCriterion("ef_name >=", value, "efName");
            return (Criteria) this;
        }

        public Criteria andEfNameLessThan(String value) {
            addCriterion("ef_name <", value, "efName");
            return (Criteria) this;
        }

        public Criteria andEfNameLessThanOrEqualTo(String value) {
            addCriterion("ef_name <=", value, "efName");
            return (Criteria) this;
        }

        public Criteria andEfNameLike(String value) {
            addCriterion("ef_name like", value, "efName");
            return (Criteria) this;
        }

        public Criteria andEfNameNotLike(String value) {
            addCriterion("ef_name not like", value, "efName");
            return (Criteria) this;
        }

        public Criteria andEfNameIn(List<String> values) {
            addCriterion("ef_name in", values, "efName");
            return (Criteria) this;
        }

        public Criteria andEfNameNotIn(List<String> values) {
            addCriterion("ef_name not in", values, "efName");
            return (Criteria) this;
        }

        public Criteria andEfNameBetween(String value1, String value2) {
            addCriterion("ef_name between", value1, value2, "efName");
            return (Criteria) this;
        }

        public Criteria andEfNameNotBetween(String value1, String value2) {
            addCriterion("ef_name not between", value1, value2, "efName");
            return (Criteria) this;
        }

        public Criteria andReleaseCycleIsNull() {
            addCriterion("release_cycle is null");
            return (Criteria) this;
        }

        public Criteria andReleaseCycleIsNotNull() {
            addCriterion("release_cycle is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseCycleEqualTo(String value) {
            addCriterion("release_cycle =", value, "releaseCycle");
            return (Criteria) this;
        }

        public Criteria andReleaseCycleNotEqualTo(String value) {
            addCriterion("release_cycle <>", value, "releaseCycle");
            return (Criteria) this;
        }

        public Criteria andReleaseCycleGreaterThan(String value) {
            addCriterion("release_cycle >", value, "releaseCycle");
            return (Criteria) this;
        }

        public Criteria andReleaseCycleGreaterThanOrEqualTo(String value) {
            addCriterion("release_cycle >=", value, "releaseCycle");
            return (Criteria) this;
        }

        public Criteria andReleaseCycleLessThan(String value) {
            addCriterion("release_cycle <", value, "releaseCycle");
            return (Criteria) this;
        }

        public Criteria andReleaseCycleLessThanOrEqualTo(String value) {
            addCriterion("release_cycle <=", value, "releaseCycle");
            return (Criteria) this;
        }

        public Criteria andReleaseCycleLike(String value) {
            addCriterion("release_cycle like", value, "releaseCycle");
            return (Criteria) this;
        }

        public Criteria andReleaseCycleNotLike(String value) {
            addCriterion("release_cycle not like", value, "releaseCycle");
            return (Criteria) this;
        }

        public Criteria andReleaseCycleIn(List<String> values) {
            addCriterion("release_cycle in", values, "releaseCycle");
            return (Criteria) this;
        }

        public Criteria andReleaseCycleNotIn(List<String> values) {
            addCriterion("release_cycle not in", values, "releaseCycle");
            return (Criteria) this;
        }

        public Criteria andReleaseCycleBetween(String value1, String value2) {
            addCriterion("release_cycle between", value1, value2, "releaseCycle");
            return (Criteria) this;
        }

        public Criteria andReleaseCycleNotBetween(String value1, String value2) {
            addCriterion("release_cycle not between", value1, value2, "releaseCycle");
            return (Criteria) this;
        }

        public Criteria andEndIssueIsNull() {
            addCriterion("end_issue is null");
            return (Criteria) this;
        }

        public Criteria andEndIssueIsNotNull() {
            addCriterion("end_issue is not null");
            return (Criteria) this;
        }

        public Criteria andEndIssueEqualTo(String value) {
            addCriterion("end_issue =", value, "endIssue");
            return (Criteria) this;
        }

        public Criteria andEndIssueNotEqualTo(String value) {
            addCriterion("end_issue <>", value, "endIssue");
            return (Criteria) this;
        }

        public Criteria andEndIssueGreaterThan(String value) {
            addCriterion("end_issue >", value, "endIssue");
            return (Criteria) this;
        }

        public Criteria andEndIssueGreaterThanOrEqualTo(String value) {
            addCriterion("end_issue >=", value, "endIssue");
            return (Criteria) this;
        }

        public Criteria andEndIssueLessThan(String value) {
            addCriterion("end_issue <", value, "endIssue");
            return (Criteria) this;
        }

        public Criteria andEndIssueLessThanOrEqualTo(String value) {
            addCriterion("end_issue <=", value, "endIssue");
            return (Criteria) this;
        }

        public Criteria andEndIssueLike(String value) {
            addCriterion("end_issue like", value, "endIssue");
            return (Criteria) this;
        }

        public Criteria andEndIssueNotLike(String value) {
            addCriterion("end_issue not like", value, "endIssue");
            return (Criteria) this;
        }

        public Criteria andEndIssueIn(List<String> values) {
            addCriterion("end_issue in", values, "endIssue");
            return (Criteria) this;
        }

        public Criteria andEndIssueNotIn(List<String> values) {
            addCriterion("end_issue not in", values, "endIssue");
            return (Criteria) this;
        }

        public Criteria andEndIssueBetween(String value1, String value2) {
            addCriterion("end_issue between", value1, value2, "endIssue");
            return (Criteria) this;
        }

        public Criteria andEndIssueNotBetween(String value1, String value2) {
            addCriterion("end_issue not between", value1, value2, "endIssue");
            return (Criteria) this;
        }

        public Criteria andStartYearIsNull() {
            addCriterion("start_year is null");
            return (Criteria) this;
        }

        public Criteria andStartYearIsNotNull() {
            addCriterion("start_year is not null");
            return (Criteria) this;
        }

        public Criteria andStartYearEqualTo(String value) {
            addCriterion("start_year =", value, "startYear");
            return (Criteria) this;
        }

        public Criteria andStartYearNotEqualTo(String value) {
            addCriterion("start_year <>", value, "startYear");
            return (Criteria) this;
        }

        public Criteria andStartYearGreaterThan(String value) {
            addCriterion("start_year >", value, "startYear");
            return (Criteria) this;
        }

        public Criteria andStartYearGreaterThanOrEqualTo(String value) {
            addCriterion("start_year >=", value, "startYear");
            return (Criteria) this;
        }

        public Criteria andStartYearLessThan(String value) {
            addCriterion("start_year <", value, "startYear");
            return (Criteria) this;
        }

        public Criteria andStartYearLessThanOrEqualTo(String value) {
            addCriterion("start_year <=", value, "startYear");
            return (Criteria) this;
        }

        public Criteria andStartYearLike(String value) {
            addCriterion("start_year like", value, "startYear");
            return (Criteria) this;
        }

        public Criteria andStartYearNotLike(String value) {
            addCriterion("start_year not like", value, "startYear");
            return (Criteria) this;
        }

        public Criteria andStartYearIn(List<String> values) {
            addCriterion("start_year in", values, "startYear");
            return (Criteria) this;
        }

        public Criteria andStartYearNotIn(List<String> values) {
            addCriterion("start_year not in", values, "startYear");
            return (Criteria) this;
        }

        public Criteria andStartYearBetween(String value1, String value2) {
            addCriterion("start_year between", value1, value2, "startYear");
            return (Criteria) this;
        }

        public Criteria andStartYearNotBetween(String value1, String value2) {
            addCriterion("start_year not between", value1, value2, "startYear");
            return (Criteria) this;
        }

        public Criteria andEndYearIsNull() {
            addCriterion("end_year is null");
            return (Criteria) this;
        }

        public Criteria andEndYearIsNotNull() {
            addCriterion("end_year is not null");
            return (Criteria) this;
        }

        public Criteria andEndYearEqualTo(Long value) {
            addCriterion("end_year =", value, "endYear");
            return (Criteria) this;
        }

        public Criteria andEndYearNotEqualTo(Long value) {
            addCriterion("end_year <>", value, "endYear");
            return (Criteria) this;
        }

        public Criteria andEndYearGreaterThan(Long value) {
            addCriterion("end_year >", value, "endYear");
            return (Criteria) this;
        }

        public Criteria andEndYearGreaterThanOrEqualTo(Long value) {
            addCriterion("end_year >=", value, "endYear");
            return (Criteria) this;
        }

        public Criteria andEndYearLessThan(Long value) {
            addCriterion("end_year <", value, "endYear");
            return (Criteria) this;
        }

        public Criteria andEndYearLessThanOrEqualTo(Long value) {
            addCriterion("end_year <=", value, "endYear");
            return (Criteria) this;
        }

        public Criteria andEndYearIn(List<Long> values) {
            addCriterion("end_year in", values, "endYear");
            return (Criteria) this;
        }

        public Criteria andEndYearNotIn(List<Long> values) {
            addCriterion("end_year not in", values, "endYear");
            return (Criteria) this;
        }

        public Criteria andEndYearBetween(Long value1, Long value2) {
            addCriterion("end_year between", value1, value2, "endYear");
            return (Criteria) this;
        }

        public Criteria andEndYearNotBetween(Long value1, Long value2) {
            addCriterion("end_year not between", value1, value2, "endYear");
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

        public Criteria andTagNumIsNull() {
            addCriterion("tag_num is null");
            return (Criteria) this;
        }

        public Criteria andTagNumIsNotNull() {
            addCriterion("tag_num is not null");
            return (Criteria) this;
        }

        public Criteria andTagNumEqualTo(Integer value) {
            addCriterion("tag_num =", value, "tagNum");
            return (Criteria) this;
        }

        public Criteria andTagNumNotEqualTo(Integer value) {
            addCriterion("tag_num <>", value, "tagNum");
            return (Criteria) this;
        }

        public Criteria andTagNumGreaterThan(Integer value) {
            addCriterion("tag_num >", value, "tagNum");
            return (Criteria) this;
        }

        public Criteria andTagNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("tag_num >=", value, "tagNum");
            return (Criteria) this;
        }

        public Criteria andTagNumLessThan(Integer value) {
            addCriterion("tag_num <", value, "tagNum");
            return (Criteria) this;
        }

        public Criteria andTagNumLessThanOrEqualTo(Integer value) {
            addCriterion("tag_num <=", value, "tagNum");
            return (Criteria) this;
        }

        public Criteria andTagNumIn(List<Integer> values) {
            addCriterion("tag_num in", values, "tagNum");
            return (Criteria) this;
        }

        public Criteria andTagNumNotIn(List<Integer> values) {
            addCriterion("tag_num not in", values, "tagNum");
            return (Criteria) this;
        }

        public Criteria andTagNumBetween(Integer value1, Integer value2) {
            addCriterion("tag_num between", value1, value2, "tagNum");
            return (Criteria) this;
        }

        public Criteria andTagNumNotBetween(Integer value1, Integer value2) {
            addCriterion("tag_num not between", value1, value2, "tagNum");
            return (Criteria) this;
        }

        public Criteria andHostunitAreaIsNull() {
            addCriterion("hostunit_area is null");
            return (Criteria) this;
        }

        public Criteria andHostunitAreaIsNotNull() {
            addCriterion("hostunit_area is not null");
            return (Criteria) this;
        }

        public Criteria andHostunitAreaEqualTo(String value) {
            addCriterion("hostunit_area =", value, "hostunitArea");
            return (Criteria) this;
        }

        public Criteria andHostunitAreaNotEqualTo(String value) {
            addCriterion("hostunit_area <>", value, "hostunitArea");
            return (Criteria) this;
        }

        public Criteria andHostunitAreaGreaterThan(String value) {
            addCriterion("hostunit_area >", value, "hostunitArea");
            return (Criteria) this;
        }

        public Criteria andHostunitAreaGreaterThanOrEqualTo(String value) {
            addCriterion("hostunit_area >=", value, "hostunitArea");
            return (Criteria) this;
        }

        public Criteria andHostunitAreaLessThan(String value) {
            addCriterion("hostunit_area <", value, "hostunitArea");
            return (Criteria) this;
        }

        public Criteria andHostunitAreaLessThanOrEqualTo(String value) {
            addCriterion("hostunit_area <=", value, "hostunitArea");
            return (Criteria) this;
        }

        public Criteria andHostunitAreaLike(String value) {
            addCriterion("hostunit_area like", value, "hostunitArea");
            return (Criteria) this;
        }

        public Criteria andHostunitAreaNotLike(String value) {
            addCriterion("hostunit_area not like", value, "hostunitArea");
            return (Criteria) this;
        }

        public Criteria andHostunitAreaIn(List<String> values) {
            addCriterion("hostunit_area in", values, "hostunitArea");
            return (Criteria) this;
        }

        public Criteria andHostunitAreaNotIn(List<String> values) {
            addCriterion("hostunit_area not in", values, "hostunitArea");
            return (Criteria) this;
        }

        public Criteria andHostunitAreaBetween(String value1, String value2) {
            addCriterion("hostunit_area between", value1, value2, "hostunitArea");
            return (Criteria) this;
        }

        public Criteria andHostunitAreaNotBetween(String value1, String value2) {
            addCriterion("hostunit_area not between", value1, value2, "hostunitArea");
            return (Criteria) this;
        }

        public Criteria andThirdpartyLinksNumIsNull() {
            addCriterion("thirdparty_links_num is null");
            return (Criteria) this;
        }

        public Criteria andThirdpartyLinksNumIsNotNull() {
            addCriterion("thirdparty_links_num is not null");
            return (Criteria) this;
        }

        public Criteria andThirdpartyLinksNumEqualTo(Integer value) {
            addCriterion("thirdparty_links_num =", value, "thirdpartyLinksNum");
            return (Criteria) this;
        }

        public Criteria andThirdpartyLinksNumNotEqualTo(Integer value) {
            addCriterion("thirdparty_links_num <>", value, "thirdpartyLinksNum");
            return (Criteria) this;
        }

        public Criteria andThirdpartyLinksNumGreaterThan(Integer value) {
            addCriterion("thirdparty_links_num >", value, "thirdpartyLinksNum");
            return (Criteria) this;
        }

        public Criteria andThirdpartyLinksNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("thirdparty_links_num >=", value, "thirdpartyLinksNum");
            return (Criteria) this;
        }

        public Criteria andThirdpartyLinksNumLessThan(Integer value) {
            addCriterion("thirdparty_links_num <", value, "thirdpartyLinksNum");
            return (Criteria) this;
        }

        public Criteria andThirdpartyLinksNumLessThanOrEqualTo(Integer value) {
            addCriterion("thirdparty_links_num <=", value, "thirdpartyLinksNum");
            return (Criteria) this;
        }

        public Criteria andThirdpartyLinksNumIn(List<Integer> values) {
            addCriterion("thirdparty_links_num in", values, "thirdpartyLinksNum");
            return (Criteria) this;
        }

        public Criteria andThirdpartyLinksNumNotIn(List<Integer> values) {
            addCriterion("thirdparty_links_num not in", values, "thirdpartyLinksNum");
            return (Criteria) this;
        }

        public Criteria andThirdpartyLinksNumBetween(Integer value1, Integer value2) {
            addCriterion("thirdparty_links_num between", value1, value2, "thirdpartyLinksNum");
            return (Criteria) this;
        }

        public Criteria andThirdpartyLinksNumNotBetween(Integer value1, Integer value2) {
            addCriterion("thirdparty_links_num not between", value1, value2, "thirdpartyLinksNum");
            return (Criteria) this;
        }

        public Criteria andImportNumIsNull() {
            addCriterion("import_num is null");
            return (Criteria) this;
        }

        public Criteria andImportNumIsNotNull() {
            addCriterion("import_num is not null");
            return (Criteria) this;
        }

        public Criteria andImportNumEqualTo(Integer value) {
            addCriterion("import_num =", value, "importNum");
            return (Criteria) this;
        }

        public Criteria andImportNumNotEqualTo(Integer value) {
            addCriterion("import_num <>", value, "importNum");
            return (Criteria) this;
        }

        public Criteria andImportNumGreaterThan(Integer value) {
            addCriterion("import_num >", value, "importNum");
            return (Criteria) this;
        }

        public Criteria andImportNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("import_num >=", value, "importNum");
            return (Criteria) this;
        }

        public Criteria andImportNumLessThan(Integer value) {
            addCriterion("import_num <", value, "importNum");
            return (Criteria) this;
        }

        public Criteria andImportNumLessThanOrEqualTo(Integer value) {
            addCriterion("import_num <=", value, "importNum");
            return (Criteria) this;
        }

        public Criteria andImportNumIn(List<Integer> values) {
            addCriterion("import_num in", values, "importNum");
            return (Criteria) this;
        }

        public Criteria andImportNumNotIn(List<Integer> values) {
            addCriterion("import_num not in", values, "importNum");
            return (Criteria) this;
        }

        public Criteria andImportNumBetween(Integer value1, Integer value2) {
            addCriterion("import_num between", value1, value2, "importNum");
            return (Criteria) this;
        }

        public Criteria andImportNumNotBetween(Integer value1, Integer value2) {
            addCriterion("import_num not between", value1, value2, "importNum");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andSourceDbIsNull() {
            addCriterion("source_db is null");
            return (Criteria) this;
        }

        public Criteria andSourceDbIsNotNull() {
            addCriterion("source_db is not null");
            return (Criteria) this;
        }

        public Criteria andSourceDbEqualTo(String value) {
            addCriterion("source_db =", value, "sourceDb");
            return (Criteria) this;
        }

        public Criteria andSourceDbNotEqualTo(String value) {
            addCriterion("source_db <>", value, "sourceDb");
            return (Criteria) this;
        }

        public Criteria andSourceDbGreaterThan(String value) {
            addCriterion("source_db >", value, "sourceDb");
            return (Criteria) this;
        }

        public Criteria andSourceDbGreaterThanOrEqualTo(String value) {
            addCriterion("source_db >=", value, "sourceDb");
            return (Criteria) this;
        }

        public Criteria andSourceDbLessThan(String value) {
            addCriterion("source_db <", value, "sourceDb");
            return (Criteria) this;
        }

        public Criteria andSourceDbLessThanOrEqualTo(String value) {
            addCriterion("source_db <=", value, "sourceDb");
            return (Criteria) this;
        }

        public Criteria andSourceDbLike(String value) {
            addCriterion("source_db like", value, "sourceDb");
            return (Criteria) this;
        }

        public Criteria andSourceDbNotLike(String value) {
            addCriterion("source_db not like", value, "sourceDb");
            return (Criteria) this;
        }

        public Criteria andSourceDbIn(List<String> values) {
            addCriterion("source_db in", values, "sourceDb");
            return (Criteria) this;
        }

        public Criteria andSourceDbNotIn(List<String> values) {
            addCriterion("source_db not in", values, "sourceDb");
            return (Criteria) this;
        }

        public Criteria andSourceDbBetween(String value1, String value2) {
            addCriterion("source_db between", value1, value2, "sourceDb");
            return (Criteria) this;
        }

        public Criteria andSourceDbNotBetween(String value1, String value2) {
            addCriterion("source_db not between", value1, value2, "sourceDb");
            return (Criteria) this;
        }

        public Criteria andCnIsNull() {
            addCriterion("cn is null");
            return (Criteria) this;
        }

        public Criteria andCnIsNotNull() {
            addCriterion("cn is not null");
            return (Criteria) this;
        }

        public Criteria andCnEqualTo(String value) {
            addCriterion("cn =", value, "cn");
            return (Criteria) this;
        }

        public Criteria andCnNotEqualTo(String value) {
            addCriterion("cn <>", value, "cn");
            return (Criteria) this;
        }

        public Criteria andCnGreaterThan(String value) {
            addCriterion("cn >", value, "cn");
            return (Criteria) this;
        }

        public Criteria andCnGreaterThanOrEqualTo(String value) {
            addCriterion("cn >=", value, "cn");
            return (Criteria) this;
        }

        public Criteria andCnLessThan(String value) {
            addCriterion("cn <", value, "cn");
            return (Criteria) this;
        }

        public Criteria andCnLessThanOrEqualTo(String value) {
            addCriterion("cn <=", value, "cn");
            return (Criteria) this;
        }

        public Criteria andCnLike(String value) {
            addCriterion("cn like", value, "cn");
            return (Criteria) this;
        }

        public Criteria andCnNotLike(String value) {
            addCriterion("cn not like", value, "cn");
            return (Criteria) this;
        }

        public Criteria andCnIn(List<String> values) {
            addCriterion("cn in", values, "cn");
            return (Criteria) this;
        }

        public Criteria andCnNotIn(List<String> values) {
            addCriterion("cn not in", values, "cn");
            return (Criteria) this;
        }

        public Criteria andCnBetween(String value1, String value2) {
            addCriterion("cn between", value1, value2, "cn");
            return (Criteria) this;
        }

        public Criteria andCnNotBetween(String value1, String value2) {
            addCriterion("cn not between", value1, value2, "cn");
            return (Criteria) this;
        }

        public Criteria andCollectionNumIsNull() {
            addCriterion("collection_num is null");
            return (Criteria) this;
        }

        public Criteria andCollectionNumIsNotNull() {
            addCriterion("collection_num is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionNumEqualTo(Integer value) {
            addCriterion("collection_num =", value, "collectionNum");
            return (Criteria) this;
        }

        public Criteria andCollectionNumNotEqualTo(Integer value) {
            addCriterion("collection_num <>", value, "collectionNum");
            return (Criteria) this;
        }

        public Criteria andCollectionNumGreaterThan(Integer value) {
            addCriterion("collection_num >", value, "collectionNum");
            return (Criteria) this;
        }

        public Criteria andCollectionNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("collection_num >=", value, "collectionNum");
            return (Criteria) this;
        }

        public Criteria andCollectionNumLessThan(Integer value) {
            addCriterion("collection_num <", value, "collectionNum");
            return (Criteria) this;
        }

        public Criteria andCollectionNumLessThanOrEqualTo(Integer value) {
            addCriterion("collection_num <=", value, "collectionNum");
            return (Criteria) this;
        }

        public Criteria andCollectionNumIn(List<Integer> values) {
            addCriterion("collection_num in", values, "collectionNum");
            return (Criteria) this;
        }

        public Criteria andCollectionNumNotIn(List<Integer> values) {
            addCriterion("collection_num not in", values, "collectionNum");
            return (Criteria) this;
        }

        public Criteria andCollectionNumBetween(Integer value1, Integer value2) {
            addCriterion("collection_num between", value1, value2, "collectionNum");
            return (Criteria) this;
        }

        public Criteria andCollectionNumNotBetween(Integer value1, Integer value2) {
            addCriterion("collection_num not between", value1, value2, "collectionNum");
            return (Criteria) this;
        }

        public Criteria andDepNameIsNull() {
            addCriterion("dep_name is null");
            return (Criteria) this;
        }

        public Criteria andDepNameIsNotNull() {
            addCriterion("dep_name is not null");
            return (Criteria) this;
        }

        public Criteria andDepNameEqualTo(String value) {
            addCriterion("dep_name =", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotEqualTo(String value) {
            addCriterion("dep_name <>", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameGreaterThan(String value) {
            addCriterion("dep_name >", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameGreaterThanOrEqualTo(String value) {
            addCriterion("dep_name >=", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameLessThan(String value) {
            addCriterion("dep_name <", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameLessThanOrEqualTo(String value) {
            addCriterion("dep_name <=", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameLike(String value) {
            addCriterion("dep_name like", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotLike(String value) {
            addCriterion("dep_name not like", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameIn(List<String> values) {
            addCriterion("dep_name in", values, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotIn(List<String> values) {
            addCriterion("dep_name not in", values, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameBetween(String value1, String value2) {
            addCriterion("dep_name between", value1, value2, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotBetween(String value1, String value2) {
            addCriterion("dep_name not between", value1, value2, "depName");
            return (Criteria) this;
        }

        public Criteria andDownloadNumIsNull() {
            addCriterion("download_num is null");
            return (Criteria) this;
        }

        public Criteria andDownloadNumIsNotNull() {
            addCriterion("download_num is not null");
            return (Criteria) this;
        }

        public Criteria andDownloadNumEqualTo(String value) {
            addCriterion("download_num =", value, "downloadNum");
            return (Criteria) this;
        }

        public Criteria andDownloadNumNotEqualTo(String value) {
            addCriterion("download_num <>", value, "downloadNum");
            return (Criteria) this;
        }

        public Criteria andDownloadNumGreaterThan(String value) {
            addCriterion("download_num >", value, "downloadNum");
            return (Criteria) this;
        }

        public Criteria andDownloadNumGreaterThanOrEqualTo(String value) {
            addCriterion("download_num >=", value, "downloadNum");
            return (Criteria) this;
        }

        public Criteria andDownloadNumLessThan(String value) {
            addCriterion("download_num <", value, "downloadNum");
            return (Criteria) this;
        }

        public Criteria andDownloadNumLessThanOrEqualTo(String value) {
            addCriterion("download_num <=", value, "downloadNum");
            return (Criteria) this;
        }

        public Criteria andDownloadNumLike(String value) {
            addCriterion("download_num like", value, "downloadNum");
            return (Criteria) this;
        }

        public Criteria andDownloadNumNotLike(String value) {
            addCriterion("download_num not like", value, "downloadNum");
            return (Criteria) this;
        }

        public Criteria andDownloadNumIn(List<String> values) {
            addCriterion("download_num in", values, "downloadNum");
            return (Criteria) this;
        }

        public Criteria andDownloadNumNotIn(List<String> values) {
            addCriterion("download_num not in", values, "downloadNum");
            return (Criteria) this;
        }

        public Criteria andDownloadNumBetween(String value1, String value2) {
            addCriterion("download_num between", value1, value2, "downloadNum");
            return (Criteria) this;
        }

        public Criteria andDownloadNumNotBetween(String value1, String value2) {
            addCriterion("download_num not between", value1, value2, "downloadNum");
            return (Criteria) this;
        }

        public Criteria andFirstPublishIsNull() {
            addCriterion("first_publish is null");
            return (Criteria) this;
        }

        public Criteria andFirstPublishIsNotNull() {
            addCriterion("first_publish is not null");
            return (Criteria) this;
        }

        public Criteria andFirstPublishEqualTo(String value) {
            addCriterion("first_publish =", value, "firstPublish");
            return (Criteria) this;
        }

        public Criteria andFirstPublishNotEqualTo(String value) {
            addCriterion("first_publish <>", value, "firstPublish");
            return (Criteria) this;
        }

        public Criteria andFirstPublishGreaterThan(String value) {
            addCriterion("first_publish >", value, "firstPublish");
            return (Criteria) this;
        }

        public Criteria andFirstPublishGreaterThanOrEqualTo(String value) {
            addCriterion("first_publish >=", value, "firstPublish");
            return (Criteria) this;
        }

        public Criteria andFirstPublishLessThan(String value) {
            addCriterion("first_publish <", value, "firstPublish");
            return (Criteria) this;
        }

        public Criteria andFirstPublishLessThanOrEqualTo(String value) {
            addCriterion("first_publish <=", value, "firstPublish");
            return (Criteria) this;
        }

        public Criteria andFirstPublishLike(String value) {
            addCriterion("first_publish like", value, "firstPublish");
            return (Criteria) this;
        }

        public Criteria andFirstPublishNotLike(String value) {
            addCriterion("first_publish not like", value, "firstPublish");
            return (Criteria) this;
        }

        public Criteria andFirstPublishIn(List<String> values) {
            addCriterion("first_publish in", values, "firstPublish");
            return (Criteria) this;
        }

        public Criteria andFirstPublishNotIn(List<String> values) {
            addCriterion("first_publish not in", values, "firstPublish");
            return (Criteria) this;
        }

        public Criteria andFirstPublishBetween(String value1, String value2) {
            addCriterion("first_publish between", value1, value2, "firstPublish");
            return (Criteria) this;
        }

        public Criteria andFirstPublishNotBetween(String value1, String value2) {
            addCriterion("first_publish not between", value1, value2, "firstPublish");
            return (Criteria) this;
        }

        public Criteria andAffectoiIsNull() {
            addCriterion("affectoi is null");
            return (Criteria) this;
        }

        public Criteria andAffectoiIsNotNull() {
            addCriterion("affectoi is not null");
            return (Criteria) this;
        }

        public Criteria andAffectoiEqualTo(Double value) {
            addCriterion("affectoi =", value, "affectoi");
            return (Criteria) this;
        }

        public Criteria andAffectoiNotEqualTo(Double value) {
            addCriterion("affectoi <>", value, "affectoi");
            return (Criteria) this;
        }

        public Criteria andAffectoiGreaterThan(Double value) {
            addCriterion("affectoi >", value, "affectoi");
            return (Criteria) this;
        }

        public Criteria andAffectoiGreaterThanOrEqualTo(Double value) {
            addCriterion("affectoi >=", value, "affectoi");
            return (Criteria) this;
        }

        public Criteria andAffectoiLessThan(Double value) {
            addCriterion("affectoi <", value, "affectoi");
            return (Criteria) this;
        }

        public Criteria andAffectoiLessThanOrEqualTo(Double value) {
            addCriterion("affectoi <=", value, "affectoi");
            return (Criteria) this;
        }

        public Criteria andAffectoiIn(List<Double> values) {
            addCriterion("affectoi in", values, "affectoi");
            return (Criteria) this;
        }

        public Criteria andAffectoiNotIn(List<Double> values) {
            addCriterion("affectoi not in", values, "affectoi");
            return (Criteria) this;
        }

        public Criteria andAffectoiBetween(Double value1, Double value2) {
            addCriterion("affectoi between", value1, value2, "affectoi");
            return (Criteria) this;
        }

        public Criteria andAffectoiNotBetween(Double value1, Double value2) {
            addCriterion("affectoi not between", value1, value2, "affectoi");
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

        public Criteria andArticleNumIsNull() {
            addCriterion("article_num is null");
            return (Criteria) this;
        }

        public Criteria andArticleNumIsNotNull() {
            addCriterion("article_num is not null");
            return (Criteria) this;
        }

        public Criteria andArticleNumEqualTo(Integer value) {
            addCriterion("article_num =", value, "articleNum");
            return (Criteria) this;
        }

        public Criteria andArticleNumNotEqualTo(Integer value) {
            addCriterion("article_num <>", value, "articleNum");
            return (Criteria) this;
        }

        public Criteria andArticleNumGreaterThan(Integer value) {
            addCriterion("article_num >", value, "articleNum");
            return (Criteria) this;
        }

        public Criteria andArticleNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_num >=", value, "articleNum");
            return (Criteria) this;
        }

        public Criteria andArticleNumLessThan(Integer value) {
            addCriterion("article_num <", value, "articleNum");
            return (Criteria) this;
        }

        public Criteria andArticleNumLessThanOrEqualTo(Integer value) {
            addCriterion("article_num <=", value, "articleNum");
            return (Criteria) this;
        }

        public Criteria andArticleNumIn(List<Integer> values) {
            addCriterion("article_num in", values, "articleNum");
            return (Criteria) this;
        }

        public Criteria andArticleNumNotIn(List<Integer> values) {
            addCriterion("article_num not in", values, "articleNum");
            return (Criteria) this;
        }

        public Criteria andArticleNumBetween(Integer value1, Integer value2) {
            addCriterion("article_num between", value1, value2, "articleNum");
            return (Criteria) this;
        }

        public Criteria andArticleNumNotBetween(Integer value1, Integer value2) {
            addCriterion("article_num not between", value1, value2, "articleNum");
            return (Criteria) this;
        }

        public Criteria andFulltextReadingNumIsNull() {
            addCriterion("fulltext_reading_num is null");
            return (Criteria) this;
        }

        public Criteria andFulltextReadingNumIsNotNull() {
            addCriterion("fulltext_reading_num is not null");
            return (Criteria) this;
        }

        public Criteria andFulltextReadingNumEqualTo(Integer value) {
            addCriterion("fulltext_reading_num =", value, "fulltextReadingNum");
            return (Criteria) this;
        }

        public Criteria andFulltextReadingNumNotEqualTo(Integer value) {
            addCriterion("fulltext_reading_num <>", value, "fulltextReadingNum");
            return (Criteria) this;
        }

        public Criteria andFulltextReadingNumGreaterThan(Integer value) {
            addCriterion("fulltext_reading_num >", value, "fulltextReadingNum");
            return (Criteria) this;
        }

        public Criteria andFulltextReadingNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("fulltext_reading_num >=", value, "fulltextReadingNum");
            return (Criteria) this;
        }

        public Criteria andFulltextReadingNumLessThan(Integer value) {
            addCriterion("fulltext_reading_num <", value, "fulltextReadingNum");
            return (Criteria) this;
        }

        public Criteria andFulltextReadingNumLessThanOrEqualTo(Integer value) {
            addCriterion("fulltext_reading_num <=", value, "fulltextReadingNum");
            return (Criteria) this;
        }

        public Criteria andFulltextReadingNumIn(List<Integer> values) {
            addCriterion("fulltext_reading_num in", values, "fulltextReadingNum");
            return (Criteria) this;
        }

        public Criteria andFulltextReadingNumNotIn(List<Integer> values) {
            addCriterion("fulltext_reading_num not in", values, "fulltextReadingNum");
            return (Criteria) this;
        }

        public Criteria andFulltextReadingNumBetween(Integer value1, Integer value2) {
            addCriterion("fulltext_reading_num between", value1, value2, "fulltextReadingNum");
            return (Criteria) this;
        }

        public Criteria andFulltextReadingNumNotBetween(Integer value1, Integer value2) {
            addCriterion("fulltext_reading_num not between", value1, value2, "fulltextReadingNum");
            return (Criteria) this;
        }

        public Criteria andNoteNumIsNull() {
            addCriterion("note_num is null");
            return (Criteria) this;
        }

        public Criteria andNoteNumIsNotNull() {
            addCriterion("note_num is not null");
            return (Criteria) this;
        }

        public Criteria andNoteNumEqualTo(Integer value) {
            addCriterion("note_num =", value, "noteNum");
            return (Criteria) this;
        }

        public Criteria andNoteNumNotEqualTo(Integer value) {
            addCriterion("note_num <>", value, "noteNum");
            return (Criteria) this;
        }

        public Criteria andNoteNumGreaterThan(Integer value) {
            addCriterion("note_num >", value, "noteNum");
            return (Criteria) this;
        }

        public Criteria andNoteNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("note_num >=", value, "noteNum");
            return (Criteria) this;
        }

        public Criteria andNoteNumLessThan(Integer value) {
            addCriterion("note_num <", value, "noteNum");
            return (Criteria) this;
        }

        public Criteria andNoteNumLessThanOrEqualTo(Integer value) {
            addCriterion("note_num <=", value, "noteNum");
            return (Criteria) this;
        }

        public Criteria andNoteNumIn(List<Integer> values) {
            addCriterion("note_num in", values, "noteNum");
            return (Criteria) this;
        }

        public Criteria andNoteNumNotIn(List<Integer> values) {
            addCriterion("note_num not in", values, "noteNum");
            return (Criteria) this;
        }

        public Criteria andNoteNumBetween(Integer value1, Integer value2) {
            addCriterion("note_num between", value1, value2, "noteNum");
            return (Criteria) this;
        }

        public Criteria andNoteNumNotBetween(Integer value1, Integer value2) {
            addCriterion("note_num not between", value1, value2, "noteNum");
            return (Criteria) this;
        }

        public Criteria andClassCodeIsNull() {
            addCriterion("class_code is null");
            return (Criteria) this;
        }

        public Criteria andClassCodeIsNotNull() {
            addCriterion("class_code is not null");
            return (Criteria) this;
        }

        public Criteria andClassCodeEqualTo(String value) {
            addCriterion("class_code =", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeNotEqualTo(String value) {
            addCriterion("class_code <>", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeGreaterThan(String value) {
            addCriterion("class_code >", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeGreaterThanOrEqualTo(String value) {
            addCriterion("class_code >=", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeLessThan(String value) {
            addCriterion("class_code <", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeLessThanOrEqualTo(String value) {
            addCriterion("class_code <=", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeLike(String value) {
            addCriterion("class_code like", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeNotLike(String value) {
            addCriterion("class_code not like", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeIn(List<String> values) {
            addCriterion("class_code in", values, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeNotIn(List<String> values) {
            addCriterion("class_code not in", values, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeBetween(String value1, String value2) {
            addCriterion("class_code between", value1, value2, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeNotBetween(String value1, String value2) {
            addCriterion("class_code not between", value1, value2, "classCode");
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