package com.boku.www.pojo;

import java.util.ArrayList;
import java.util.List;

public class TUserRoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TUserRoleExample() {
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

        public Criteria andUserRoleIdIsNull() {
            addCriterion("user_role_id is null");
            return (Criteria) this;
        }

        public Criteria andUserRoleIdIsNotNull() {
            addCriterion("user_role_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserRoleIdEqualTo(String value) {
            addCriterion("user_role_id =", value, "userRoleId");
            return (Criteria) this;
        }

        public Criteria andUserRoleIdNotEqualTo(String value) {
            addCriterion("user_role_id <>", value, "userRoleId");
            return (Criteria) this;
        }

        public Criteria andUserRoleIdGreaterThan(String value) {
            addCriterion("user_role_id >", value, "userRoleId");
            return (Criteria) this;
        }

        public Criteria andUserRoleIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_role_id >=", value, "userRoleId");
            return (Criteria) this;
        }

        public Criteria andUserRoleIdLessThan(String value) {
            addCriterion("user_role_id <", value, "userRoleId");
            return (Criteria) this;
        }

        public Criteria andUserRoleIdLessThanOrEqualTo(String value) {
            addCriterion("user_role_id <=", value, "userRoleId");
            return (Criteria) this;
        }

        public Criteria andUserRoleIdLike(String value) {
            addCriterion("user_role_id like", value, "userRoleId");
            return (Criteria) this;
        }

        public Criteria andUserRoleIdNotLike(String value) {
            addCriterion("user_role_id not like", value, "userRoleId");
            return (Criteria) this;
        }

        public Criteria andUserRoleIdIn(List<String> values) {
            addCriterion("user_role_id in", values, "userRoleId");
            return (Criteria) this;
        }

        public Criteria andUserRoleIdNotIn(List<String> values) {
            addCriterion("user_role_id not in", values, "userRoleId");
            return (Criteria) this;
        }

        public Criteria andUserRoleIdBetween(String value1, String value2) {
            addCriterion("user_role_id between", value1, value2, "userRoleId");
            return (Criteria) this;
        }

        public Criteria andUserRoleIdNotBetween(String value1, String value2) {
            addCriterion("user_role_id not between", value1, value2, "userRoleId");
            return (Criteria) this;
        }

        public Criteria andUserRoleUseridIsNull() {
            addCriterion("user_role_userId is null");
            return (Criteria) this;
        }

        public Criteria andUserRoleUseridIsNotNull() {
            addCriterion("user_role_userId is not null");
            return (Criteria) this;
        }

        public Criteria andUserRoleUseridEqualTo(String value) {
            addCriterion("user_role_userId =", value, "userRoleUserid");
            return (Criteria) this;
        }

        public Criteria andUserRoleUseridNotEqualTo(String value) {
            addCriterion("user_role_userId <>", value, "userRoleUserid");
            return (Criteria) this;
        }

        public Criteria andUserRoleUseridGreaterThan(String value) {
            addCriterion("user_role_userId >", value, "userRoleUserid");
            return (Criteria) this;
        }

        public Criteria andUserRoleUseridGreaterThanOrEqualTo(String value) {
            addCriterion("user_role_userId >=", value, "userRoleUserid");
            return (Criteria) this;
        }

        public Criteria andUserRoleUseridLessThan(String value) {
            addCriterion("user_role_userId <", value, "userRoleUserid");
            return (Criteria) this;
        }

        public Criteria andUserRoleUseridLessThanOrEqualTo(String value) {
            addCriterion("user_role_userId <=", value, "userRoleUserid");
            return (Criteria) this;
        }

        public Criteria andUserRoleUseridLike(String value) {
            addCriterion("user_role_userId like", value, "userRoleUserid");
            return (Criteria) this;
        }

        public Criteria andUserRoleUseridNotLike(String value) {
            addCriterion("user_role_userId not like", value, "userRoleUserid");
            return (Criteria) this;
        }

        public Criteria andUserRoleUseridIn(List<String> values) {
            addCriterion("user_role_userId in", values, "userRoleUserid");
            return (Criteria) this;
        }

        public Criteria andUserRoleUseridNotIn(List<String> values) {
            addCriterion("user_role_userId not in", values, "userRoleUserid");
            return (Criteria) this;
        }

        public Criteria andUserRoleUseridBetween(String value1, String value2) {
            addCriterion("user_role_userId between", value1, value2, "userRoleUserid");
            return (Criteria) this;
        }

        public Criteria andUserRoleUseridNotBetween(String value1, String value2) {
            addCriterion("user_role_userId not between", value1, value2, "userRoleUserid");
            return (Criteria) this;
        }

        public Criteria andUserRoleRoleidIsNull() {
            addCriterion("user_role_roleId is null");
            return (Criteria) this;
        }

        public Criteria andUserRoleRoleidIsNotNull() {
            addCriterion("user_role_roleId is not null");
            return (Criteria) this;
        }

        public Criteria andUserRoleRoleidEqualTo(String value) {
            addCriterion("user_role_roleId =", value, "userRoleRoleid");
            return (Criteria) this;
        }

        public Criteria andUserRoleRoleidNotEqualTo(String value) {
            addCriterion("user_role_roleId <>", value, "userRoleRoleid");
            return (Criteria) this;
        }

        public Criteria andUserRoleRoleidGreaterThan(String value) {
            addCriterion("user_role_roleId >", value, "userRoleRoleid");
            return (Criteria) this;
        }

        public Criteria andUserRoleRoleidGreaterThanOrEqualTo(String value) {
            addCriterion("user_role_roleId >=", value, "userRoleRoleid");
            return (Criteria) this;
        }

        public Criteria andUserRoleRoleidLessThan(String value) {
            addCriterion("user_role_roleId <", value, "userRoleRoleid");
            return (Criteria) this;
        }

        public Criteria andUserRoleRoleidLessThanOrEqualTo(String value) {
            addCriterion("user_role_roleId <=", value, "userRoleRoleid");
            return (Criteria) this;
        }

        public Criteria andUserRoleRoleidLike(String value) {
            addCriterion("user_role_roleId like", value, "userRoleRoleid");
            return (Criteria) this;
        }

        public Criteria andUserRoleRoleidNotLike(String value) {
            addCriterion("user_role_roleId not like", value, "userRoleRoleid");
            return (Criteria) this;
        }

        public Criteria andUserRoleRoleidIn(List<String> values) {
            addCriterion("user_role_roleId in", values, "userRoleRoleid");
            return (Criteria) this;
        }

        public Criteria andUserRoleRoleidNotIn(List<String> values) {
            addCriterion("user_role_roleId not in", values, "userRoleRoleid");
            return (Criteria) this;
        }

        public Criteria andUserRoleRoleidBetween(String value1, String value2) {
            addCriterion("user_role_roleId between", value1, value2, "userRoleRoleid");
            return (Criteria) this;
        }

        public Criteria andUserRoleRoleidNotBetween(String value1, String value2) {
            addCriterion("user_role_roleId not between", value1, value2, "userRoleRoleid");
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