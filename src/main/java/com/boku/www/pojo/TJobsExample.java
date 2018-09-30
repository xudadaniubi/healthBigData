package com.boku.www.pojo;

import java.util.ArrayList;
import java.util.List;

public class TJobsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TJobsExample() {
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

        public Criteria andJobsIdIsNull() {
            addCriterion("jobs_id is null");
            return (Criteria) this;
        }

        public Criteria andJobsIdIsNotNull() {
            addCriterion("jobs_id is not null");
            return (Criteria) this;
        }

        public Criteria andJobsIdEqualTo(String value) {
            addCriterion("jobs_id =", value, "jobsId");
            return (Criteria) this;
        }

        public Criteria andJobsIdNotEqualTo(String value) {
            addCriterion("jobs_id <>", value, "jobsId");
            return (Criteria) this;
        }

        public Criteria andJobsIdGreaterThan(String value) {
            addCriterion("jobs_id >", value, "jobsId");
            return (Criteria) this;
        }

        public Criteria andJobsIdGreaterThanOrEqualTo(String value) {
            addCriterion("jobs_id >=", value, "jobsId");
            return (Criteria) this;
        }

        public Criteria andJobsIdLessThan(String value) {
            addCriterion("jobs_id <", value, "jobsId");
            return (Criteria) this;
        }

        public Criteria andJobsIdLessThanOrEqualTo(String value) {
            addCriterion("jobs_id <=", value, "jobsId");
            return (Criteria) this;
        }

        public Criteria andJobsIdLike(String value) {
            addCriterion("jobs_id like", value, "jobsId");
            return (Criteria) this;
        }

        public Criteria andJobsIdNotLike(String value) {
            addCriterion("jobs_id not like", value, "jobsId");
            return (Criteria) this;
        }

        public Criteria andJobsIdIn(List<String> values) {
            addCriterion("jobs_id in", values, "jobsId");
            return (Criteria) this;
        }

        public Criteria andJobsIdNotIn(List<String> values) {
            addCriterion("jobs_id not in", values, "jobsId");
            return (Criteria) this;
        }

        public Criteria andJobsIdBetween(String value1, String value2) {
            addCriterion("jobs_id between", value1, value2, "jobsId");
            return (Criteria) this;
        }

        public Criteria andJobsIdNotBetween(String value1, String value2) {
            addCriterion("jobs_id not between", value1, value2, "jobsId");
            return (Criteria) this;
        }

        public Criteria andJobsStartTimeIsNull() {
            addCriterion("jobs_start_time is null");
            return (Criteria) this;
        }

        public Criteria andJobsStartTimeIsNotNull() {
            addCriterion("jobs_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andJobsStartTimeEqualTo(String value) {
            addCriterion("jobs_start_time =", value, "jobsStartTime");
            return (Criteria) this;
        }

        public Criteria andJobsStartTimeNotEqualTo(String value) {
            addCriterion("jobs_start_time <>", value, "jobsStartTime");
            return (Criteria) this;
        }

        public Criteria andJobsStartTimeGreaterThan(String value) {
            addCriterion("jobs_start_time >", value, "jobsStartTime");
            return (Criteria) this;
        }

        public Criteria andJobsStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("jobs_start_time >=", value, "jobsStartTime");
            return (Criteria) this;
        }

        public Criteria andJobsStartTimeLessThan(String value) {
            addCriterion("jobs_start_time <", value, "jobsStartTime");
            return (Criteria) this;
        }

        public Criteria andJobsStartTimeLessThanOrEqualTo(String value) {
            addCriterion("jobs_start_time <=", value, "jobsStartTime");
            return (Criteria) this;
        }

        public Criteria andJobsStartTimeLike(String value) {
            addCriterion("jobs_start_time like", value, "jobsStartTime");
            return (Criteria) this;
        }

        public Criteria andJobsStartTimeNotLike(String value) {
            addCriterion("jobs_start_time not like", value, "jobsStartTime");
            return (Criteria) this;
        }

        public Criteria andJobsStartTimeIn(List<String> values) {
            addCriterion("jobs_start_time in", values, "jobsStartTime");
            return (Criteria) this;
        }

        public Criteria andJobsStartTimeNotIn(List<String> values) {
            addCriterion("jobs_start_time not in", values, "jobsStartTime");
            return (Criteria) this;
        }

        public Criteria andJobsStartTimeBetween(String value1, String value2) {
            addCriterion("jobs_start_time between", value1, value2, "jobsStartTime");
            return (Criteria) this;
        }

        public Criteria andJobsStartTimeNotBetween(String value1, String value2) {
            addCriterion("jobs_start_time not between", value1, value2, "jobsStartTime");
            return (Criteria) this;
        }

        public Criteria andJobsOffTimeIsNull() {
            addCriterion("jobs_off_time is null");
            return (Criteria) this;
        }

        public Criteria andJobsOffTimeIsNotNull() {
            addCriterion("jobs_off_time is not null");
            return (Criteria) this;
        }

        public Criteria andJobsOffTimeEqualTo(String value) {
            addCriterion("jobs_off_time =", value, "jobsOffTime");
            return (Criteria) this;
        }

        public Criteria andJobsOffTimeNotEqualTo(String value) {
            addCriterion("jobs_off_time <>", value, "jobsOffTime");
            return (Criteria) this;
        }

        public Criteria andJobsOffTimeGreaterThan(String value) {
            addCriterion("jobs_off_time >", value, "jobsOffTime");
            return (Criteria) this;
        }

        public Criteria andJobsOffTimeGreaterThanOrEqualTo(String value) {
            addCriterion("jobs_off_time >=", value, "jobsOffTime");
            return (Criteria) this;
        }

        public Criteria andJobsOffTimeLessThan(String value) {
            addCriterion("jobs_off_time <", value, "jobsOffTime");
            return (Criteria) this;
        }

        public Criteria andJobsOffTimeLessThanOrEqualTo(String value) {
            addCriterion("jobs_off_time <=", value, "jobsOffTime");
            return (Criteria) this;
        }

        public Criteria andJobsOffTimeLike(String value) {
            addCriterion("jobs_off_time like", value, "jobsOffTime");
            return (Criteria) this;
        }

        public Criteria andJobsOffTimeNotLike(String value) {
            addCriterion("jobs_off_time not like", value, "jobsOffTime");
            return (Criteria) this;
        }

        public Criteria andJobsOffTimeIn(List<String> values) {
            addCriterion("jobs_off_time in", values, "jobsOffTime");
            return (Criteria) this;
        }

        public Criteria andJobsOffTimeNotIn(List<String> values) {
            addCriterion("jobs_off_time not in", values, "jobsOffTime");
            return (Criteria) this;
        }

        public Criteria andJobsOffTimeBetween(String value1, String value2) {
            addCriterion("jobs_off_time between", value1, value2, "jobsOffTime");
            return (Criteria) this;
        }

        public Criteria andJobsOffTimeNotBetween(String value1, String value2) {
            addCriterion("jobs_off_time not between", value1, value2, "jobsOffTime");
            return (Criteria) this;
        }

        public Criteria andJobsCompanyIsNull() {
            addCriterion("jobs_company is null");
            return (Criteria) this;
        }

        public Criteria andJobsCompanyIsNotNull() {
            addCriterion("jobs_company is not null");
            return (Criteria) this;
        }

        public Criteria andJobsCompanyEqualTo(String value) {
            addCriterion("jobs_company =", value, "jobsCompany");
            return (Criteria) this;
        }

        public Criteria andJobsCompanyNotEqualTo(String value) {
            addCriterion("jobs_company <>", value, "jobsCompany");
            return (Criteria) this;
        }

        public Criteria andJobsCompanyGreaterThan(String value) {
            addCriterion("jobs_company >", value, "jobsCompany");
            return (Criteria) this;
        }

        public Criteria andJobsCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("jobs_company >=", value, "jobsCompany");
            return (Criteria) this;
        }

        public Criteria andJobsCompanyLessThan(String value) {
            addCriterion("jobs_company <", value, "jobsCompany");
            return (Criteria) this;
        }

        public Criteria andJobsCompanyLessThanOrEqualTo(String value) {
            addCriterion("jobs_company <=", value, "jobsCompany");
            return (Criteria) this;
        }

        public Criteria andJobsCompanyLike(String value) {
            addCriterion("jobs_company like", value, "jobsCompany");
            return (Criteria) this;
        }

        public Criteria andJobsCompanyNotLike(String value) {
            addCriterion("jobs_company not like", value, "jobsCompany");
            return (Criteria) this;
        }

        public Criteria andJobsCompanyIn(List<String> values) {
            addCriterion("jobs_company in", values, "jobsCompany");
            return (Criteria) this;
        }

        public Criteria andJobsCompanyNotIn(List<String> values) {
            addCriterion("jobs_company not in", values, "jobsCompany");
            return (Criteria) this;
        }

        public Criteria andJobsCompanyBetween(String value1, String value2) {
            addCriterion("jobs_company between", value1, value2, "jobsCompany");
            return (Criteria) this;
        }

        public Criteria andJobsCompanyNotBetween(String value1, String value2) {
            addCriterion("jobs_company not between", value1, value2, "jobsCompany");
            return (Criteria) this;
        }

        public Criteria andJobsPositionNameIsNull() {
            addCriterion("jobs_position_name is null");
            return (Criteria) this;
        }

        public Criteria andJobsPositionNameIsNotNull() {
            addCriterion("jobs_position_name is not null");
            return (Criteria) this;
        }

        public Criteria andJobsPositionNameEqualTo(String value) {
            addCriterion("jobs_position_name =", value, "jobsPositionName");
            return (Criteria) this;
        }

        public Criteria andJobsPositionNameNotEqualTo(String value) {
            addCriterion("jobs_position_name <>", value, "jobsPositionName");
            return (Criteria) this;
        }

        public Criteria andJobsPositionNameGreaterThan(String value) {
            addCriterion("jobs_position_name >", value, "jobsPositionName");
            return (Criteria) this;
        }

        public Criteria andJobsPositionNameGreaterThanOrEqualTo(String value) {
            addCriterion("jobs_position_name >=", value, "jobsPositionName");
            return (Criteria) this;
        }

        public Criteria andJobsPositionNameLessThan(String value) {
            addCriterion("jobs_position_name <", value, "jobsPositionName");
            return (Criteria) this;
        }

        public Criteria andJobsPositionNameLessThanOrEqualTo(String value) {
            addCriterion("jobs_position_name <=", value, "jobsPositionName");
            return (Criteria) this;
        }

        public Criteria andJobsPositionNameLike(String value) {
            addCriterion("jobs_position_name like", value, "jobsPositionName");
            return (Criteria) this;
        }

        public Criteria andJobsPositionNameNotLike(String value) {
            addCriterion("jobs_position_name not like", value, "jobsPositionName");
            return (Criteria) this;
        }

        public Criteria andJobsPositionNameIn(List<String> values) {
            addCriterion("jobs_position_name in", values, "jobsPositionName");
            return (Criteria) this;
        }

        public Criteria andJobsPositionNameNotIn(List<String> values) {
            addCriterion("jobs_position_name not in", values, "jobsPositionName");
            return (Criteria) this;
        }

        public Criteria andJobsPositionNameBetween(String value1, String value2) {
            addCriterion("jobs_position_name between", value1, value2, "jobsPositionName");
            return (Criteria) this;
        }

        public Criteria andJobsPositionNameNotBetween(String value1, String value2) {
            addCriterion("jobs_position_name not between", value1, value2, "jobsPositionName");
            return (Criteria) this;
        }

        public Criteria andJobsDescriptionIsNull() {
            addCriterion("jobs_description is null");
            return (Criteria) this;
        }

        public Criteria andJobsDescriptionIsNotNull() {
            addCriterion("jobs_description is not null");
            return (Criteria) this;
        }

        public Criteria andJobsDescriptionEqualTo(String value) {
            addCriterion("jobs_description =", value, "jobsDescription");
            return (Criteria) this;
        }

        public Criteria andJobsDescriptionNotEqualTo(String value) {
            addCriterion("jobs_description <>", value, "jobsDescription");
            return (Criteria) this;
        }

        public Criteria andJobsDescriptionGreaterThan(String value) {
            addCriterion("jobs_description >", value, "jobsDescription");
            return (Criteria) this;
        }

        public Criteria andJobsDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("jobs_description >=", value, "jobsDescription");
            return (Criteria) this;
        }

        public Criteria andJobsDescriptionLessThan(String value) {
            addCriterion("jobs_description <", value, "jobsDescription");
            return (Criteria) this;
        }

        public Criteria andJobsDescriptionLessThanOrEqualTo(String value) {
            addCriterion("jobs_description <=", value, "jobsDescription");
            return (Criteria) this;
        }

        public Criteria andJobsDescriptionLike(String value) {
            addCriterion("jobs_description like", value, "jobsDescription");
            return (Criteria) this;
        }

        public Criteria andJobsDescriptionNotLike(String value) {
            addCriterion("jobs_description not like", value, "jobsDescription");
            return (Criteria) this;
        }

        public Criteria andJobsDescriptionIn(List<String> values) {
            addCriterion("jobs_description in", values, "jobsDescription");
            return (Criteria) this;
        }

        public Criteria andJobsDescriptionNotIn(List<String> values) {
            addCriterion("jobs_description not in", values, "jobsDescription");
            return (Criteria) this;
        }

        public Criteria andJobsDescriptionBetween(String value1, String value2) {
            addCriterion("jobs_description between", value1, value2, "jobsDescription");
            return (Criteria) this;
        }

        public Criteria andJobsDescriptionNotBetween(String value1, String value2) {
            addCriterion("jobs_description not between", value1, value2, "jobsDescription");
            return (Criteria) this;
        }

        public Criteria andJobsUseridIsNull() {
            addCriterion("jobs_userId is null");
            return (Criteria) this;
        }

        public Criteria andJobsUseridIsNotNull() {
            addCriterion("jobs_userId is not null");
            return (Criteria) this;
        }

        public Criteria andJobsUseridEqualTo(String value) {
            addCriterion("jobs_userId =", value, "jobsUserid");
            return (Criteria) this;
        }

        public Criteria andJobsUseridNotEqualTo(String value) {
            addCriterion("jobs_userId <>", value, "jobsUserid");
            return (Criteria) this;
        }

        public Criteria andJobsUseridGreaterThan(String value) {
            addCriterion("jobs_userId >", value, "jobsUserid");
            return (Criteria) this;
        }

        public Criteria andJobsUseridGreaterThanOrEqualTo(String value) {
            addCriterion("jobs_userId >=", value, "jobsUserid");
            return (Criteria) this;
        }

        public Criteria andJobsUseridLessThan(String value) {
            addCriterion("jobs_userId <", value, "jobsUserid");
            return (Criteria) this;
        }

        public Criteria andJobsUseridLessThanOrEqualTo(String value) {
            addCriterion("jobs_userId <=", value, "jobsUserid");
            return (Criteria) this;
        }

        public Criteria andJobsUseridLike(String value) {
            addCriterion("jobs_userId like", value, "jobsUserid");
            return (Criteria) this;
        }

        public Criteria andJobsUseridNotLike(String value) {
            addCriterion("jobs_userId not like", value, "jobsUserid");
            return (Criteria) this;
        }

        public Criteria andJobsUseridIn(List<String> values) {
            addCriterion("jobs_userId in", values, "jobsUserid");
            return (Criteria) this;
        }

        public Criteria andJobsUseridNotIn(List<String> values) {
            addCriterion("jobs_userId not in", values, "jobsUserid");
            return (Criteria) this;
        }

        public Criteria andJobsUseridBetween(String value1, String value2) {
            addCriterion("jobs_userId between", value1, value2, "jobsUserid");
            return (Criteria) this;
        }

        public Criteria andJobsUseridNotBetween(String value1, String value2) {
            addCriterion("jobs_userId not between", value1, value2, "jobsUserid");
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