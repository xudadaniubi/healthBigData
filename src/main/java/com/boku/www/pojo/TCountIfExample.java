package com.boku.www.pojo;

import java.util.ArrayList;
import java.util.List;

public class TCountIfExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TCountIfExample() {
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

        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andAvgIfIsNull() {
            addCriterion("avg_if is null");
            return (Criteria) this;
        }

        public Criteria andAvgIfIsNotNull() {
            addCriterion("avg_if is not null");
            return (Criteria) this;
        }

        public Criteria andAvgIfEqualTo(Double value) {
            addCriterion("avg_if =", value, "avgIf");
            return (Criteria) this;
        }

        public Criteria andAvgIfNotEqualTo(Double value) {
            addCriterion("avg_if <>", value, "avgIf");
            return (Criteria) this;
        }

        public Criteria andAvgIfGreaterThan(Double value) {
            addCriterion("avg_if >", value, "avgIf");
            return (Criteria) this;
        }

        public Criteria andAvgIfGreaterThanOrEqualTo(Double value) {
            addCriterion("avg_if >=", value, "avgIf");
            return (Criteria) this;
        }

        public Criteria andAvgIfLessThan(Double value) {
            addCriterion("avg_if <", value, "avgIf");
            return (Criteria) this;
        }

        public Criteria andAvgIfLessThanOrEqualTo(Double value) {
            addCriterion("avg_if <=", value, "avgIf");
            return (Criteria) this;
        }

        public Criteria andAvgIfIn(List<Double> values) {
            addCriterion("avg_if in", values, "avgIf");
            return (Criteria) this;
        }

        public Criteria andAvgIfNotIn(List<Double> values) {
            addCriterion("avg_if not in", values, "avgIf");
            return (Criteria) this;
        }

        public Criteria andAvgIfBetween(Double value1, Double value2) {
            addCriterion("avg_if between", value1, value2, "avgIf");
            return (Criteria) this;
        }

        public Criteria andAvgIfNotBetween(Double value1, Double value2) {
            addCriterion("avg_if not between", value1, value2, "avgIf");
            return (Criteria) this;
        }

        public Criteria andSumIfIsNull() {
            addCriterion("sum_if is null");
            return (Criteria) this;
        }

        public Criteria andSumIfIsNotNull() {
            addCriterion("sum_if is not null");
            return (Criteria) this;
        }

        public Criteria andSumIfEqualTo(Double value) {
            addCriterion("sum_if =", value, "sumIf");
            return (Criteria) this;
        }

        public Criteria andSumIfNotEqualTo(Double value) {
            addCriterion("sum_if <>", value, "sumIf");
            return (Criteria) this;
        }

        public Criteria andSumIfGreaterThan(Double value) {
            addCriterion("sum_if >", value, "sumIf");
            return (Criteria) this;
        }

        public Criteria andSumIfGreaterThanOrEqualTo(Double value) {
            addCriterion("sum_if >=", value, "sumIf");
            return (Criteria) this;
        }

        public Criteria andSumIfLessThan(Double value) {
            addCriterion("sum_if <", value, "sumIf");
            return (Criteria) this;
        }

        public Criteria andSumIfLessThanOrEqualTo(Double value) {
            addCriterion("sum_if <=", value, "sumIf");
            return (Criteria) this;
        }

        public Criteria andSumIfIn(List<Double> values) {
            addCriterion("sum_if in", values, "sumIf");
            return (Criteria) this;
        }

        public Criteria andSumIfNotIn(List<Double> values) {
            addCriterion("sum_if not in", values, "sumIf");
            return (Criteria) this;
        }

        public Criteria andSumIfBetween(Double value1, Double value2) {
            addCriterion("sum_if between", value1, value2, "sumIf");
            return (Criteria) this;
        }

        public Criteria andSumIfNotBetween(Double value1, Double value2) {
            addCriterion("sum_if not between", value1, value2, "sumIf");
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