package com.boku.www.pojo;

import java.util.ArrayList;
import java.util.List;

public class TMenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMenuExample() {
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

        public Criteria andMenuIdIsNull() {
            addCriterion("menu_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuIdIsNotNull() {
            addCriterion("menu_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIdEqualTo(String value) {
            addCriterion("menu_id =", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotEqualTo(String value) {
            addCriterion("menu_id <>", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThan(String value) {
            addCriterion("menu_id >", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThanOrEqualTo(String value) {
            addCriterion("menu_id >=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThan(String value) {
            addCriterion("menu_id <", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThanOrEqualTo(String value) {
            addCriterion("menu_id <=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLike(String value) {
            addCriterion("menu_id like", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotLike(String value) {
            addCriterion("menu_id not like", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdIn(List<String> values) {
            addCriterion("menu_id in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotIn(List<String> values) {
            addCriterion("menu_id not in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdBetween(String value1, String value2) {
            addCriterion("menu_id between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotBetween(String value1, String value2) {
            addCriterion("menu_id not between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNull() {
            addCriterion("menu_name is null");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNotNull() {
            addCriterion("menu_name is not null");
            return (Criteria) this;
        }

        public Criteria andMenuNameEqualTo(String value) {
            addCriterion("menu_name =", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotEqualTo(String value) {
            addCriterion("menu_name <>", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThan(String value) {
            addCriterion("menu_name >", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThanOrEqualTo(String value) {
            addCriterion("menu_name >=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThan(String value) {
            addCriterion("menu_name <", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThanOrEqualTo(String value) {
            addCriterion("menu_name <=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLike(String value) {
            addCriterion("menu_name like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotLike(String value) {
            addCriterion("menu_name not like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameIn(List<String> values) {
            addCriterion("menu_name in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotIn(List<String> values) {
            addCriterion("menu_name not in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameBetween(String value1, String value2) {
            addCriterion("menu_name between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotBetween(String value1, String value2) {
            addCriterion("menu_name not between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuPageIsNull() {
            addCriterion("menu_page is null");
            return (Criteria) this;
        }

        public Criteria andMenuPageIsNotNull() {
            addCriterion("menu_page is not null");
            return (Criteria) this;
        }

        public Criteria andMenuPageEqualTo(String value) {
            addCriterion("menu_page =", value, "menuPage");
            return (Criteria) this;
        }

        public Criteria andMenuPageNotEqualTo(String value) {
            addCriterion("menu_page <>", value, "menuPage");
            return (Criteria) this;
        }

        public Criteria andMenuPageGreaterThan(String value) {
            addCriterion("menu_page >", value, "menuPage");
            return (Criteria) this;
        }

        public Criteria andMenuPageGreaterThanOrEqualTo(String value) {
            addCriterion("menu_page >=", value, "menuPage");
            return (Criteria) this;
        }

        public Criteria andMenuPageLessThan(String value) {
            addCriterion("menu_page <", value, "menuPage");
            return (Criteria) this;
        }

        public Criteria andMenuPageLessThanOrEqualTo(String value) {
            addCriterion("menu_page <=", value, "menuPage");
            return (Criteria) this;
        }

        public Criteria andMenuPageLike(String value) {
            addCriterion("menu_page like", value, "menuPage");
            return (Criteria) this;
        }

        public Criteria andMenuPageNotLike(String value) {
            addCriterion("menu_page not like", value, "menuPage");
            return (Criteria) this;
        }

        public Criteria andMenuPageIn(List<String> values) {
            addCriterion("menu_page in", values, "menuPage");
            return (Criteria) this;
        }

        public Criteria andMenuPageNotIn(List<String> values) {
            addCriterion("menu_page not in", values, "menuPage");
            return (Criteria) this;
        }

        public Criteria andMenuPageBetween(String value1, String value2) {
            addCriterion("menu_page between", value1, value2, "menuPage");
            return (Criteria) this;
        }

        public Criteria andMenuPageNotBetween(String value1, String value2) {
            addCriterion("menu_page not between", value1, value2, "menuPage");
            return (Criteria) this;
        }

        public Criteria andMenuPriorityIsNull() {
            addCriterion("menu_priority is null");
            return (Criteria) this;
        }

        public Criteria andMenuPriorityIsNotNull() {
            addCriterion("menu_priority is not null");
            return (Criteria) this;
        }

        public Criteria andMenuPriorityEqualTo(String value) {
            addCriterion("menu_priority =", value, "menuPriority");
            return (Criteria) this;
        }

        public Criteria andMenuPriorityNotEqualTo(String value) {
            addCriterion("menu_priority <>", value, "menuPriority");
            return (Criteria) this;
        }

        public Criteria andMenuPriorityGreaterThan(String value) {
            addCriterion("menu_priority >", value, "menuPriority");
            return (Criteria) this;
        }

        public Criteria andMenuPriorityGreaterThanOrEqualTo(String value) {
            addCriterion("menu_priority >=", value, "menuPriority");
            return (Criteria) this;
        }

        public Criteria andMenuPriorityLessThan(String value) {
            addCriterion("menu_priority <", value, "menuPriority");
            return (Criteria) this;
        }

        public Criteria andMenuPriorityLessThanOrEqualTo(String value) {
            addCriterion("menu_priority <=", value, "menuPriority");
            return (Criteria) this;
        }

        public Criteria andMenuPriorityLike(String value) {
            addCriterion("menu_priority like", value, "menuPriority");
            return (Criteria) this;
        }

        public Criteria andMenuPriorityNotLike(String value) {
            addCriterion("menu_priority not like", value, "menuPriority");
            return (Criteria) this;
        }

        public Criteria andMenuPriorityIn(List<String> values) {
            addCriterion("menu_priority in", values, "menuPriority");
            return (Criteria) this;
        }

        public Criteria andMenuPriorityNotIn(List<String> values) {
            addCriterion("menu_priority not in", values, "menuPriority");
            return (Criteria) this;
        }

        public Criteria andMenuPriorityBetween(String value1, String value2) {
            addCriterion("menu_priority between", value1, value2, "menuPriority");
            return (Criteria) this;
        }

        public Criteria andMenuPriorityNotBetween(String value1, String value2) {
            addCriterion("menu_priority not between", value1, value2, "menuPriority");
            return (Criteria) this;
        }

        public Criteria andMenuDescriptionIsNull() {
            addCriterion("menu_description is null");
            return (Criteria) this;
        }

        public Criteria andMenuDescriptionIsNotNull() {
            addCriterion("menu_description is not null");
            return (Criteria) this;
        }

        public Criteria andMenuDescriptionEqualTo(String value) {
            addCriterion("menu_description =", value, "menuDescription");
            return (Criteria) this;
        }

        public Criteria andMenuDescriptionNotEqualTo(String value) {
            addCriterion("menu_description <>", value, "menuDescription");
            return (Criteria) this;
        }

        public Criteria andMenuDescriptionGreaterThan(String value) {
            addCriterion("menu_description >", value, "menuDescription");
            return (Criteria) this;
        }

        public Criteria andMenuDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("menu_description >=", value, "menuDescription");
            return (Criteria) this;
        }

        public Criteria andMenuDescriptionLessThan(String value) {
            addCriterion("menu_description <", value, "menuDescription");
            return (Criteria) this;
        }

        public Criteria andMenuDescriptionLessThanOrEqualTo(String value) {
            addCriterion("menu_description <=", value, "menuDescription");
            return (Criteria) this;
        }

        public Criteria andMenuDescriptionLike(String value) {
            addCriterion("menu_description like", value, "menuDescription");
            return (Criteria) this;
        }

        public Criteria andMenuDescriptionNotLike(String value) {
            addCriterion("menu_description not like", value, "menuDescription");
            return (Criteria) this;
        }

        public Criteria andMenuDescriptionIn(List<String> values) {
            addCriterion("menu_description in", values, "menuDescription");
            return (Criteria) this;
        }

        public Criteria andMenuDescriptionNotIn(List<String> values) {
            addCriterion("menu_description not in", values, "menuDescription");
            return (Criteria) this;
        }

        public Criteria andMenuDescriptionBetween(String value1, String value2) {
            addCriterion("menu_description between", value1, value2, "menuDescription");
            return (Criteria) this;
        }

        public Criteria andMenuDescriptionNotBetween(String value1, String value2) {
            addCriterion("menu_description not between", value1, value2, "menuDescription");
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