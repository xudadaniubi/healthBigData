package com.boku.www.pojo;

import java.util.ArrayList;
import java.util.List;

public class RoleMenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoleMenuExample() {
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

        public Criteria andRoleMenuIdIsNull() {
            addCriterion("role_menu_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleMenuIdIsNotNull() {
            addCriterion("role_menu_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleMenuIdEqualTo(String value) {
            addCriterion("role_menu_id =", value, "roleMenuId");
            return (Criteria) this;
        }

        public Criteria andRoleMenuIdNotEqualTo(String value) {
            addCriterion("role_menu_id <>", value, "roleMenuId");
            return (Criteria) this;
        }

        public Criteria andRoleMenuIdGreaterThan(String value) {
            addCriterion("role_menu_id >", value, "roleMenuId");
            return (Criteria) this;
        }

        public Criteria andRoleMenuIdGreaterThanOrEqualTo(String value) {
            addCriterion("role_menu_id >=", value, "roleMenuId");
            return (Criteria) this;
        }

        public Criteria andRoleMenuIdLessThan(String value) {
            addCriterion("role_menu_id <", value, "roleMenuId");
            return (Criteria) this;
        }

        public Criteria andRoleMenuIdLessThanOrEqualTo(String value) {
            addCriterion("role_menu_id <=", value, "roleMenuId");
            return (Criteria) this;
        }

        public Criteria andRoleMenuIdLike(String value) {
            addCriterion("role_menu_id like", value, "roleMenuId");
            return (Criteria) this;
        }

        public Criteria andRoleMenuIdNotLike(String value) {
            addCriterion("role_menu_id not like", value, "roleMenuId");
            return (Criteria) this;
        }

        public Criteria andRoleMenuIdIn(List<String> values) {
            addCriterion("role_menu_id in", values, "roleMenuId");
            return (Criteria) this;
        }

        public Criteria andRoleMenuIdNotIn(List<String> values) {
            addCriterion("role_menu_id not in", values, "roleMenuId");
            return (Criteria) this;
        }

        public Criteria andRoleMenuIdBetween(String value1, String value2) {
            addCriterion("role_menu_id between", value1, value2, "roleMenuId");
            return (Criteria) this;
        }

        public Criteria andRoleMenuIdNotBetween(String value1, String value2) {
            addCriterion("role_menu_id not between", value1, value2, "roleMenuId");
            return (Criteria) this;
        }

        public Criteria andRoleMenuRoleidIsNull() {
            addCriterion("role_menu_roleId is null");
            return (Criteria) this;
        }

        public Criteria andRoleMenuRoleidIsNotNull() {
            addCriterion("role_menu_roleId is not null");
            return (Criteria) this;
        }

        public Criteria andRoleMenuRoleidEqualTo(String value) {
            addCriterion("role_menu_roleId =", value, "roleMenuRoleid");
            return (Criteria) this;
        }

        public Criteria andRoleMenuRoleidNotEqualTo(String value) {
            addCriterion("role_menu_roleId <>", value, "roleMenuRoleid");
            return (Criteria) this;
        }

        public Criteria andRoleMenuRoleidGreaterThan(String value) {
            addCriterion("role_menu_roleId >", value, "roleMenuRoleid");
            return (Criteria) this;
        }

        public Criteria andRoleMenuRoleidGreaterThanOrEqualTo(String value) {
            addCriterion("role_menu_roleId >=", value, "roleMenuRoleid");
            return (Criteria) this;
        }

        public Criteria andRoleMenuRoleidLessThan(String value) {
            addCriterion("role_menu_roleId <", value, "roleMenuRoleid");
            return (Criteria) this;
        }

        public Criteria andRoleMenuRoleidLessThanOrEqualTo(String value) {
            addCriterion("role_menu_roleId <=", value, "roleMenuRoleid");
            return (Criteria) this;
        }

        public Criteria andRoleMenuRoleidLike(String value) {
            addCriterion("role_menu_roleId like", value, "roleMenuRoleid");
            return (Criteria) this;
        }

        public Criteria andRoleMenuRoleidNotLike(String value) {
            addCriterion("role_menu_roleId not like", value, "roleMenuRoleid");
            return (Criteria) this;
        }

        public Criteria andRoleMenuRoleidIn(List<String> values) {
            addCriterion("role_menu_roleId in", values, "roleMenuRoleid");
            return (Criteria) this;
        }

        public Criteria andRoleMenuRoleidNotIn(List<String> values) {
            addCriterion("role_menu_roleId not in", values, "roleMenuRoleid");
            return (Criteria) this;
        }

        public Criteria andRoleMenuRoleidBetween(String value1, String value2) {
            addCriterion("role_menu_roleId between", value1, value2, "roleMenuRoleid");
            return (Criteria) this;
        }

        public Criteria andRoleMenuRoleidNotBetween(String value1, String value2) {
            addCriterion("role_menu_roleId not between", value1, value2, "roleMenuRoleid");
            return (Criteria) this;
        }

        public Criteria andRoleMenuMenuidIsNull() {
            addCriterion("role_menu_menuId is null");
            return (Criteria) this;
        }

        public Criteria andRoleMenuMenuidIsNotNull() {
            addCriterion("role_menu_menuId is not null");
            return (Criteria) this;
        }

        public Criteria andRoleMenuMenuidEqualTo(String value) {
            addCriterion("role_menu_menuId =", value, "roleMenuMenuid");
            return (Criteria) this;
        }

        public Criteria andRoleMenuMenuidNotEqualTo(String value) {
            addCriterion("role_menu_menuId <>", value, "roleMenuMenuid");
            return (Criteria) this;
        }

        public Criteria andRoleMenuMenuidGreaterThan(String value) {
            addCriterion("role_menu_menuId >", value, "roleMenuMenuid");
            return (Criteria) this;
        }

        public Criteria andRoleMenuMenuidGreaterThanOrEqualTo(String value) {
            addCriterion("role_menu_menuId >=", value, "roleMenuMenuid");
            return (Criteria) this;
        }

        public Criteria andRoleMenuMenuidLessThan(String value) {
            addCriterion("role_menu_menuId <", value, "roleMenuMenuid");
            return (Criteria) this;
        }

        public Criteria andRoleMenuMenuidLessThanOrEqualTo(String value) {
            addCriterion("role_menu_menuId <=", value, "roleMenuMenuid");
            return (Criteria) this;
        }

        public Criteria andRoleMenuMenuidLike(String value) {
            addCriterion("role_menu_menuId like", value, "roleMenuMenuid");
            return (Criteria) this;
        }

        public Criteria andRoleMenuMenuidNotLike(String value) {
            addCriterion("role_menu_menuId not like", value, "roleMenuMenuid");
            return (Criteria) this;
        }

        public Criteria andRoleMenuMenuidIn(List<String> values) {
            addCriterion("role_menu_menuId in", values, "roleMenuMenuid");
            return (Criteria) this;
        }

        public Criteria andRoleMenuMenuidNotIn(List<String> values) {
            addCriterion("role_menu_menuId not in", values, "roleMenuMenuid");
            return (Criteria) this;
        }

        public Criteria andRoleMenuMenuidBetween(String value1, String value2) {
            addCriterion("role_menu_menuId between", value1, value2, "roleMenuMenuid");
            return (Criteria) this;
        }

        public Criteria andRoleMenuMenuidNotBetween(String value1, String value2) {
            addCriterion("role_menu_menuId not between", value1, value2, "roleMenuMenuid");
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