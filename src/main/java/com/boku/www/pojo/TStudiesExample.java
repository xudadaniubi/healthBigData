package com.boku.www.pojo;

import java.util.ArrayList;
import java.util.List;

public class TStudiesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TStudiesExample() {
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

        public Criteria andStudyIdIsNull() {
            addCriterion("study_id is null");
            return (Criteria) this;
        }

        public Criteria andStudyIdIsNotNull() {
            addCriterion("study_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudyIdEqualTo(String value) {
            addCriterion("study_id =", value, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdNotEqualTo(String value) {
            addCriterion("study_id <>", value, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdGreaterThan(String value) {
            addCriterion("study_id >", value, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdGreaterThanOrEqualTo(String value) {
            addCriterion("study_id >=", value, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdLessThan(String value) {
            addCriterion("study_id <", value, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdLessThanOrEqualTo(String value) {
            addCriterion("study_id <=", value, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdLike(String value) {
            addCriterion("study_id like", value, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdNotLike(String value) {
            addCriterion("study_id not like", value, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdIn(List<String> values) {
            addCriterion("study_id in", values, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdNotIn(List<String> values) {
            addCriterion("study_id not in", values, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdBetween(String value1, String value2) {
            addCriterion("study_id between", value1, value2, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdNotBetween(String value1, String value2) {
            addCriterion("study_id not between", value1, value2, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyStartTimeIsNull() {
            addCriterion("study_start_time is null");
            return (Criteria) this;
        }

        public Criteria andStudyStartTimeIsNotNull() {
            addCriterion("study_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStudyStartTimeEqualTo(String value) {
            addCriterion("study_start_time =", value, "studyStartTime");
            return (Criteria) this;
        }

        public Criteria andStudyStartTimeNotEqualTo(String value) {
            addCriterion("study_start_time <>", value, "studyStartTime");
            return (Criteria) this;
        }

        public Criteria andStudyStartTimeGreaterThan(String value) {
            addCriterion("study_start_time >", value, "studyStartTime");
            return (Criteria) this;
        }

        public Criteria andStudyStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("study_start_time >=", value, "studyStartTime");
            return (Criteria) this;
        }

        public Criteria andStudyStartTimeLessThan(String value) {
            addCriterion("study_start_time <", value, "studyStartTime");
            return (Criteria) this;
        }

        public Criteria andStudyStartTimeLessThanOrEqualTo(String value) {
            addCriterion("study_start_time <=", value, "studyStartTime");
            return (Criteria) this;
        }

        public Criteria andStudyStartTimeLike(String value) {
            addCriterion("study_start_time like", value, "studyStartTime");
            return (Criteria) this;
        }

        public Criteria andStudyStartTimeNotLike(String value) {
            addCriterion("study_start_time not like", value, "studyStartTime");
            return (Criteria) this;
        }

        public Criteria andStudyStartTimeIn(List<String> values) {
            addCriterion("study_start_time in", values, "studyStartTime");
            return (Criteria) this;
        }

        public Criteria andStudyStartTimeNotIn(List<String> values) {
            addCriterion("study_start_time not in", values, "studyStartTime");
            return (Criteria) this;
        }

        public Criteria andStudyStartTimeBetween(String value1, String value2) {
            addCriterion("study_start_time between", value1, value2, "studyStartTime");
            return (Criteria) this;
        }

        public Criteria andStudyStartTimeNotBetween(String value1, String value2) {
            addCriterion("study_start_time not between", value1, value2, "studyStartTime");
            return (Criteria) this;
        }

        public Criteria andStudyOffTimeIsNull() {
            addCriterion("study_off_time is null");
            return (Criteria) this;
        }

        public Criteria andStudyOffTimeIsNotNull() {
            addCriterion("study_off_time is not null");
            return (Criteria) this;
        }

        public Criteria andStudyOffTimeEqualTo(String value) {
            addCriterion("study_off_time =", value, "studyOffTime");
            return (Criteria) this;
        }

        public Criteria andStudyOffTimeNotEqualTo(String value) {
            addCriterion("study_off_time <>", value, "studyOffTime");
            return (Criteria) this;
        }

        public Criteria andStudyOffTimeGreaterThan(String value) {
            addCriterion("study_off_time >", value, "studyOffTime");
            return (Criteria) this;
        }

        public Criteria andStudyOffTimeGreaterThanOrEqualTo(String value) {
            addCriterion("study_off_time >=", value, "studyOffTime");
            return (Criteria) this;
        }

        public Criteria andStudyOffTimeLessThan(String value) {
            addCriterion("study_off_time <", value, "studyOffTime");
            return (Criteria) this;
        }

        public Criteria andStudyOffTimeLessThanOrEqualTo(String value) {
            addCriterion("study_off_time <=", value, "studyOffTime");
            return (Criteria) this;
        }

        public Criteria andStudyOffTimeLike(String value) {
            addCriterion("study_off_time like", value, "studyOffTime");
            return (Criteria) this;
        }

        public Criteria andStudyOffTimeNotLike(String value) {
            addCriterion("study_off_time not like", value, "studyOffTime");
            return (Criteria) this;
        }

        public Criteria andStudyOffTimeIn(List<String> values) {
            addCriterion("study_off_time in", values, "studyOffTime");
            return (Criteria) this;
        }

        public Criteria andStudyOffTimeNotIn(List<String> values) {
            addCriterion("study_off_time not in", values, "studyOffTime");
            return (Criteria) this;
        }

        public Criteria andStudyOffTimeBetween(String value1, String value2) {
            addCriterion("study_off_time between", value1, value2, "studyOffTime");
            return (Criteria) this;
        }

        public Criteria andStudyOffTimeNotBetween(String value1, String value2) {
            addCriterion("study_off_time not between", value1, value2, "studyOffTime");
            return (Criteria) this;
        }

        public Criteria andStudyGraduateShoolIsNull() {
            addCriterion("study_graduate_shool is null");
            return (Criteria) this;
        }

        public Criteria andStudyGraduateShoolIsNotNull() {
            addCriterion("study_graduate_shool is not null");
            return (Criteria) this;
        }

        public Criteria andStudyGraduateShoolEqualTo(String value) {
            addCriterion("study_graduate_shool =", value, "studyGraduateShool");
            return (Criteria) this;
        }

        public Criteria andStudyGraduateShoolNotEqualTo(String value) {
            addCriterion("study_graduate_shool <>", value, "studyGraduateShool");
            return (Criteria) this;
        }

        public Criteria andStudyGraduateShoolGreaterThan(String value) {
            addCriterion("study_graduate_shool >", value, "studyGraduateShool");
            return (Criteria) this;
        }

        public Criteria andStudyGraduateShoolGreaterThanOrEqualTo(String value) {
            addCriterion("study_graduate_shool >=", value, "studyGraduateShool");
            return (Criteria) this;
        }

        public Criteria andStudyGraduateShoolLessThan(String value) {
            addCriterion("study_graduate_shool <", value, "studyGraduateShool");
            return (Criteria) this;
        }

        public Criteria andStudyGraduateShoolLessThanOrEqualTo(String value) {
            addCriterion("study_graduate_shool <=", value, "studyGraduateShool");
            return (Criteria) this;
        }

        public Criteria andStudyGraduateShoolLike(String value) {
            addCriterion("study_graduate_shool like", value, "studyGraduateShool");
            return (Criteria) this;
        }

        public Criteria andStudyGraduateShoolNotLike(String value) {
            addCriterion("study_graduate_shool not like", value, "studyGraduateShool");
            return (Criteria) this;
        }

        public Criteria andStudyGraduateShoolIn(List<String> values) {
            addCriterion("study_graduate_shool in", values, "studyGraduateShool");
            return (Criteria) this;
        }

        public Criteria andStudyGraduateShoolNotIn(List<String> values) {
            addCriterion("study_graduate_shool not in", values, "studyGraduateShool");
            return (Criteria) this;
        }

        public Criteria andStudyGraduateShoolBetween(String value1, String value2) {
            addCriterion("study_graduate_shool between", value1, value2, "studyGraduateShool");
            return (Criteria) this;
        }

        public Criteria andStudyGraduateShoolNotBetween(String value1, String value2) {
            addCriterion("study_graduate_shool not between", value1, value2, "studyGraduateShool");
            return (Criteria) this;
        }

        public Criteria andStudyProfessionalIsNull() {
            addCriterion("study_professional is null");
            return (Criteria) this;
        }

        public Criteria andStudyProfessionalIsNotNull() {
            addCriterion("study_professional is not null");
            return (Criteria) this;
        }

        public Criteria andStudyProfessionalEqualTo(String value) {
            addCriterion("study_professional =", value, "studyProfessional");
            return (Criteria) this;
        }

        public Criteria andStudyProfessionalNotEqualTo(String value) {
            addCriterion("study_professional <>", value, "studyProfessional");
            return (Criteria) this;
        }

        public Criteria andStudyProfessionalGreaterThan(String value) {
            addCriterion("study_professional >", value, "studyProfessional");
            return (Criteria) this;
        }

        public Criteria andStudyProfessionalGreaterThanOrEqualTo(String value) {
            addCriterion("study_professional >=", value, "studyProfessional");
            return (Criteria) this;
        }

        public Criteria andStudyProfessionalLessThan(String value) {
            addCriterion("study_professional <", value, "studyProfessional");
            return (Criteria) this;
        }

        public Criteria andStudyProfessionalLessThanOrEqualTo(String value) {
            addCriterion("study_professional <=", value, "studyProfessional");
            return (Criteria) this;
        }

        public Criteria andStudyProfessionalLike(String value) {
            addCriterion("study_professional like", value, "studyProfessional");
            return (Criteria) this;
        }

        public Criteria andStudyProfessionalNotLike(String value) {
            addCriterion("study_professional not like", value, "studyProfessional");
            return (Criteria) this;
        }

        public Criteria andStudyProfessionalIn(List<String> values) {
            addCriterion("study_professional in", values, "studyProfessional");
            return (Criteria) this;
        }

        public Criteria andStudyProfessionalNotIn(List<String> values) {
            addCriterion("study_professional not in", values, "studyProfessional");
            return (Criteria) this;
        }

        public Criteria andStudyProfessionalBetween(String value1, String value2) {
            addCriterion("study_professional between", value1, value2, "studyProfessional");
            return (Criteria) this;
        }

        public Criteria andStudyProfessionalNotBetween(String value1, String value2) {
            addCriterion("study_professional not between", value1, value2, "studyProfessional");
            return (Criteria) this;
        }

        public Criteria andStudyUseridIsNull() {
            addCriterion("study__userId is null");
            return (Criteria) this;
        }

        public Criteria andStudyUseridIsNotNull() {
            addCriterion("study__userId is not null");
            return (Criteria) this;
        }

        public Criteria andStudyUseridEqualTo(String value) {
            addCriterion("study__userId =", value, "studyUserid");
            return (Criteria) this;
        }

        public Criteria andStudyUseridNotEqualTo(String value) {
            addCriterion("study__userId <>", value, "studyUserid");
            return (Criteria) this;
        }

        public Criteria andStudyUseridGreaterThan(String value) {
            addCriterion("study__userId >", value, "studyUserid");
            return (Criteria) this;
        }

        public Criteria andStudyUseridGreaterThanOrEqualTo(String value) {
            addCriterion("study__userId >=", value, "studyUserid");
            return (Criteria) this;
        }

        public Criteria andStudyUseridLessThan(String value) {
            addCriterion("study__userId <", value, "studyUserid");
            return (Criteria) this;
        }

        public Criteria andStudyUseridLessThanOrEqualTo(String value) {
            addCriterion("study__userId <=", value, "studyUserid");
            return (Criteria) this;
        }

        public Criteria andStudyUseridLike(String value) {
            addCriterion("study__userId like", value, "studyUserid");
            return (Criteria) this;
        }

        public Criteria andStudyUseridNotLike(String value) {
            addCriterion("study__userId not like", value, "studyUserid");
            return (Criteria) this;
        }

        public Criteria andStudyUseridIn(List<String> values) {
            addCriterion("study__userId in", values, "studyUserid");
            return (Criteria) this;
        }

        public Criteria andStudyUseridNotIn(List<String> values) {
            addCriterion("study__userId not in", values, "studyUserid");
            return (Criteria) this;
        }

        public Criteria andStudyUseridBetween(String value1, String value2) {
            addCriterion("study__userId between", value1, value2, "studyUserid");
            return (Criteria) this;
        }

        public Criteria andStudyUseridNotBetween(String value1, String value2) {
            addCriterion("study__userId not between", value1, value2, "studyUserid");
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