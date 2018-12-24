package com.boku.www.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TProjectDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TProjectDataExample() {
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

        public Criteria andManagementCompanyIsNull() {
            addCriterion("management_company is null");
            return (Criteria) this;
        }

        public Criteria andManagementCompanyIsNotNull() {
            addCriterion("management_company is not null");
            return (Criteria) this;
        }

        public Criteria andManagementCompanyEqualTo(String value) {
            addCriterion("management_company =", value, "managementCompany");
            return (Criteria) this;
        }

        public Criteria andManagementCompanyNotEqualTo(String value) {
            addCriterion("management_company <>", value, "managementCompany");
            return (Criteria) this;
        }

        public Criteria andManagementCompanyGreaterThan(String value) {
            addCriterion("management_company >", value, "managementCompany");
            return (Criteria) this;
        }

        public Criteria andManagementCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("management_company >=", value, "managementCompany");
            return (Criteria) this;
        }

        public Criteria andManagementCompanyLessThan(String value) {
            addCriterion("management_company <", value, "managementCompany");
            return (Criteria) this;
        }

        public Criteria andManagementCompanyLessThanOrEqualTo(String value) {
            addCriterion("management_company <=", value, "managementCompany");
            return (Criteria) this;
        }

        public Criteria andManagementCompanyLike(String value) {
            addCriterion("management_company like", value, "managementCompany");
            return (Criteria) this;
        }

        public Criteria andManagementCompanyNotLike(String value) {
            addCriterion("management_company not like", value, "managementCompany");
            return (Criteria) this;
        }

        public Criteria andManagementCompanyIn(List<String> values) {
            addCriterion("management_company in", values, "managementCompany");
            return (Criteria) this;
        }

        public Criteria andManagementCompanyNotIn(List<String> values) {
            addCriterion("management_company not in", values, "managementCompany");
            return (Criteria) this;
        }

        public Criteria andManagementCompanyBetween(String value1, String value2) {
            addCriterion("management_company between", value1, value2, "managementCompany");
            return (Criteria) this;
        }

        public Criteria andManagementCompanyNotBetween(String value1, String value2) {
            addCriterion("management_company not between", value1, value2, "managementCompany");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryGradeIsNull() {
            addCriterion("project_category_grade is null");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryGradeIsNotNull() {
            addCriterion("project_category_grade is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryGradeEqualTo(String value) {
            addCriterion("project_category_grade =", value, "projectCategoryGrade");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryGradeNotEqualTo(String value) {
            addCriterion("project_category_grade <>", value, "projectCategoryGrade");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryGradeGreaterThan(String value) {
            addCriterion("project_category_grade >", value, "projectCategoryGrade");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryGradeGreaterThanOrEqualTo(String value) {
            addCriterion("project_category_grade >=", value, "projectCategoryGrade");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryGradeLessThan(String value) {
            addCriterion("project_category_grade <", value, "projectCategoryGrade");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryGradeLessThanOrEqualTo(String value) {
            addCriterion("project_category_grade <=", value, "projectCategoryGrade");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryGradeLike(String value) {
            addCriterion("project_category_grade like", value, "projectCategoryGrade");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryGradeNotLike(String value) {
            addCriterion("project_category_grade not like", value, "projectCategoryGrade");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryGradeIn(List<String> values) {
            addCriterion("project_category_grade in", values, "projectCategoryGrade");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryGradeNotIn(List<String> values) {
            addCriterion("project_category_grade not in", values, "projectCategoryGrade");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryGradeBetween(String value1, String value2) {
            addCriterion("project_category_grade between", value1, value2, "projectCategoryGrade");
            return (Criteria) this;
        }

        public Criteria andProjectCategoryGradeNotBetween(String value1, String value2) {
            addCriterion("project_category_grade not between", value1, value2, "projectCategoryGrade");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNull() {
            addCriterion("subject is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNotNull() {
            addCriterion("subject is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectEqualTo(String value) {
            addCriterion("subject =", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotEqualTo(String value) {
            addCriterion("subject <>", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThan(String value) {
            addCriterion("subject >", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("subject >=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThan(String value) {
            addCriterion("subject <", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThanOrEqualTo(String value) {
            addCriterion("subject <=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLike(String value) {
            addCriterion("subject like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotLike(String value) {
            addCriterion("subject not like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectIn(List<String> values) {
            addCriterion("subject in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotIn(List<String> values) {
            addCriterion("subject not in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectBetween(String value1, String value2) {
            addCriterion("subject between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotBetween(String value1, String value2) {
            addCriterion("subject not between", value1, value2, "subject");
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

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectKidcatIsNull() {
            addCriterion("project_kidcat is null");
            return (Criteria) this;
        }

        public Criteria andProjectKidcatIsNotNull() {
            addCriterion("project_kidcat is not null");
            return (Criteria) this;
        }

        public Criteria andProjectKidcatEqualTo(String value) {
            addCriterion("project_kidcat =", value, "projectKidcat");
            return (Criteria) this;
        }

        public Criteria andProjectKidcatNotEqualTo(String value) {
            addCriterion("project_kidcat <>", value, "projectKidcat");
            return (Criteria) this;
        }

        public Criteria andProjectKidcatGreaterThan(String value) {
            addCriterion("project_kidcat >", value, "projectKidcat");
            return (Criteria) this;
        }

        public Criteria andProjectKidcatGreaterThanOrEqualTo(String value) {
            addCriterion("project_kidcat >=", value, "projectKidcat");
            return (Criteria) this;
        }

        public Criteria andProjectKidcatLessThan(String value) {
            addCriterion("project_kidcat <", value, "projectKidcat");
            return (Criteria) this;
        }

        public Criteria andProjectKidcatLessThanOrEqualTo(String value) {
            addCriterion("project_kidcat <=", value, "projectKidcat");
            return (Criteria) this;
        }

        public Criteria andProjectKidcatLike(String value) {
            addCriterion("project_kidcat like", value, "projectKidcat");
            return (Criteria) this;
        }

        public Criteria andProjectKidcatNotLike(String value) {
            addCriterion("project_kidcat not like", value, "projectKidcat");
            return (Criteria) this;
        }

        public Criteria andProjectKidcatIn(List<String> values) {
            addCriterion("project_kidcat in", values, "projectKidcat");
            return (Criteria) this;
        }

        public Criteria andProjectKidcatNotIn(List<String> values) {
            addCriterion("project_kidcat not in", values, "projectKidcat");
            return (Criteria) this;
        }

        public Criteria andProjectKidcatBetween(String value1, String value2) {
            addCriterion("project_kidcat between", value1, value2, "projectKidcat");
            return (Criteria) this;
        }

        public Criteria andProjectKidcatNotBetween(String value1, String value2) {
            addCriterion("project_kidcat not between", value1, value2, "projectKidcat");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andSubject1IdIsNull() {
            addCriterion("subject1_id is null");
            return (Criteria) this;
        }

        public Criteria andSubject1IdIsNotNull() {
            addCriterion("subject1_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubject1IdEqualTo(String value) {
            addCriterion("subject1_id =", value, "subject1Id");
            return (Criteria) this;
        }

        public Criteria andSubject1IdNotEqualTo(String value) {
            addCriterion("subject1_id <>", value, "subject1Id");
            return (Criteria) this;
        }

        public Criteria andSubject1IdGreaterThan(String value) {
            addCriterion("subject1_id >", value, "subject1Id");
            return (Criteria) this;
        }

        public Criteria andSubject1IdGreaterThanOrEqualTo(String value) {
            addCriterion("subject1_id >=", value, "subject1Id");
            return (Criteria) this;
        }

        public Criteria andSubject1IdLessThan(String value) {
            addCriterion("subject1_id <", value, "subject1Id");
            return (Criteria) this;
        }

        public Criteria andSubject1IdLessThanOrEqualTo(String value) {
            addCriterion("subject1_id <=", value, "subject1Id");
            return (Criteria) this;
        }

        public Criteria andSubject1IdLike(String value) {
            addCriterion("subject1_id like", value, "subject1Id");
            return (Criteria) this;
        }

        public Criteria andSubject1IdNotLike(String value) {
            addCriterion("subject1_id not like", value, "subject1Id");
            return (Criteria) this;
        }

        public Criteria andSubject1IdIn(List<String> values) {
            addCriterion("subject1_id in", values, "subject1Id");
            return (Criteria) this;
        }

        public Criteria andSubject1IdNotIn(List<String> values) {
            addCriterion("subject1_id not in", values, "subject1Id");
            return (Criteria) this;
        }

        public Criteria andSubject1IdBetween(String value1, String value2) {
            addCriterion("subject1_id between", value1, value2, "subject1Id");
            return (Criteria) this;
        }

        public Criteria andSubject1IdNotBetween(String value1, String value2) {
            addCriterion("subject1_id not between", value1, value2, "subject1Id");
            return (Criteria) this;
        }

        public Criteria andSubject2IdIsNull() {
            addCriterion("subject2_id is null");
            return (Criteria) this;
        }

        public Criteria andSubject2IdIsNotNull() {
            addCriterion("subject2_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubject2IdEqualTo(String value) {
            addCriterion("subject2_id =", value, "subject2Id");
            return (Criteria) this;
        }

        public Criteria andSubject2IdNotEqualTo(String value) {
            addCriterion("subject2_id <>", value, "subject2Id");
            return (Criteria) this;
        }

        public Criteria andSubject2IdGreaterThan(String value) {
            addCriterion("subject2_id >", value, "subject2Id");
            return (Criteria) this;
        }

        public Criteria andSubject2IdGreaterThanOrEqualTo(String value) {
            addCriterion("subject2_id >=", value, "subject2Id");
            return (Criteria) this;
        }

        public Criteria andSubject2IdLessThan(String value) {
            addCriterion("subject2_id <", value, "subject2Id");
            return (Criteria) this;
        }

        public Criteria andSubject2IdLessThanOrEqualTo(String value) {
            addCriterion("subject2_id <=", value, "subject2Id");
            return (Criteria) this;
        }

        public Criteria andSubject2IdLike(String value) {
            addCriterion("subject2_id like", value, "subject2Id");
            return (Criteria) this;
        }

        public Criteria andSubject2IdNotLike(String value) {
            addCriterion("subject2_id not like", value, "subject2Id");
            return (Criteria) this;
        }

        public Criteria andSubject2IdIn(List<String> values) {
            addCriterion("subject2_id in", values, "subject2Id");
            return (Criteria) this;
        }

        public Criteria andSubject2IdNotIn(List<String> values) {
            addCriterion("subject2_id not in", values, "subject2Id");
            return (Criteria) this;
        }

        public Criteria andSubject2IdBetween(String value1, String value2) {
            addCriterion("subject2_id between", value1, value2, "subject2Id");
            return (Criteria) this;
        }

        public Criteria andSubject2IdNotBetween(String value1, String value2) {
            addCriterion("subject2_id not between", value1, value2, "subject2Id");
            return (Criteria) this;
        }

        public Criteria andSubject3IdIsNull() {
            addCriterion("subject3_id is null");
            return (Criteria) this;
        }

        public Criteria andSubject3IdIsNotNull() {
            addCriterion("subject3_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubject3IdEqualTo(String value) {
            addCriterion("subject3_id =", value, "subject3Id");
            return (Criteria) this;
        }

        public Criteria andSubject3IdNotEqualTo(String value) {
            addCriterion("subject3_id <>", value, "subject3Id");
            return (Criteria) this;
        }

        public Criteria andSubject3IdGreaterThan(String value) {
            addCriterion("subject3_id >", value, "subject3Id");
            return (Criteria) this;
        }

        public Criteria andSubject3IdGreaterThanOrEqualTo(String value) {
            addCriterion("subject3_id >=", value, "subject3Id");
            return (Criteria) this;
        }

        public Criteria andSubject3IdLessThan(String value) {
            addCriterion("subject3_id <", value, "subject3Id");
            return (Criteria) this;
        }

        public Criteria andSubject3IdLessThanOrEqualTo(String value) {
            addCriterion("subject3_id <=", value, "subject3Id");
            return (Criteria) this;
        }

        public Criteria andSubject3IdLike(String value) {
            addCriterion("subject3_id like", value, "subject3Id");
            return (Criteria) this;
        }

        public Criteria andSubject3IdNotLike(String value) {
            addCriterion("subject3_id not like", value, "subject3Id");
            return (Criteria) this;
        }

        public Criteria andSubject3IdIn(List<String> values) {
            addCriterion("subject3_id in", values, "subject3Id");
            return (Criteria) this;
        }

        public Criteria andSubject3IdNotIn(List<String> values) {
            addCriterion("subject3_id not in", values, "subject3Id");
            return (Criteria) this;
        }

        public Criteria andSubject3IdBetween(String value1, String value2) {
            addCriterion("subject3_id between", value1, value2, "subject3Id");
            return (Criteria) this;
        }

        public Criteria andSubject3IdNotBetween(String value1, String value2) {
            addCriterion("subject3_id not between", value1, value2, "subject3Id");
            return (Criteria) this;
        }

        public Criteria andProjectSatrtTimeIsNull() {
            addCriterion("project_satrt_time is null");
            return (Criteria) this;
        }

        public Criteria andProjectSatrtTimeIsNotNull() {
            addCriterion("project_satrt_time is not null");
            return (Criteria) this;
        }

        public Criteria andProjectSatrtTimeEqualTo(Date value) {
            addCriterionForJDBCDate("project_satrt_time =", value, "projectSatrtTime");
            return (Criteria) this;
        }

        public Criteria andProjectSatrtTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("project_satrt_time <>", value, "projectSatrtTime");
            return (Criteria) this;
        }

        public Criteria andProjectSatrtTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("project_satrt_time >", value, "projectSatrtTime");
            return (Criteria) this;
        }

        public Criteria andProjectSatrtTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("project_satrt_time >=", value, "projectSatrtTime");
            return (Criteria) this;
        }

        public Criteria andProjectSatrtTimeLessThan(Date value) {
            addCriterionForJDBCDate("project_satrt_time <", value, "projectSatrtTime");
            return (Criteria) this;
        }

        public Criteria andProjectSatrtTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("project_satrt_time <=", value, "projectSatrtTime");
            return (Criteria) this;
        }

        public Criteria andProjectSatrtTimeIn(List<Date> values) {
            addCriterionForJDBCDate("project_satrt_time in", values, "projectSatrtTime");
            return (Criteria) this;
        }

        public Criteria andProjectSatrtTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("project_satrt_time not in", values, "projectSatrtTime");
            return (Criteria) this;
        }

        public Criteria andProjectSatrtTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("project_satrt_time between", value1, value2, "projectSatrtTime");
            return (Criteria) this;
        }

        public Criteria andProjectSatrtTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("project_satrt_time not between", value1, value2, "projectSatrtTime");
            return (Criteria) this;
        }

        public Criteria andProjectEndTimeIsNull() {
            addCriterion("project_end_time is null");
            return (Criteria) this;
        }

        public Criteria andProjectEndTimeIsNotNull() {
            addCriterion("project_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andProjectEndTimeEqualTo(Date value) {
            addCriterionForJDBCDate("project_end_time =", value, "projectEndTime");
            return (Criteria) this;
        }

        public Criteria andProjectEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("project_end_time <>", value, "projectEndTime");
            return (Criteria) this;
        }

        public Criteria andProjectEndTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("project_end_time >", value, "projectEndTime");
            return (Criteria) this;
        }

        public Criteria andProjectEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("project_end_time >=", value, "projectEndTime");
            return (Criteria) this;
        }

        public Criteria andProjectEndTimeLessThan(Date value) {
            addCriterionForJDBCDate("project_end_time <", value, "projectEndTime");
            return (Criteria) this;
        }

        public Criteria andProjectEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("project_end_time <=", value, "projectEndTime");
            return (Criteria) this;
        }

        public Criteria andProjectEndTimeIn(List<Date> values) {
            addCriterionForJDBCDate("project_end_time in", values, "projectEndTime");
            return (Criteria) this;
        }

        public Criteria andProjectEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("project_end_time not in", values, "projectEndTime");
            return (Criteria) this;
        }

        public Criteria andProjectEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("project_end_time between", value1, value2, "projectEndTime");
            return (Criteria) this;
        }

        public Criteria andProjectEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("project_end_time not between", value1, value2, "projectEndTime");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andOrganizerIsNull() {
            addCriterion("organizer is null");
            return (Criteria) this;
        }

        public Criteria andOrganizerIsNotNull() {
            addCriterion("organizer is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizerEqualTo(String value) {
            addCriterion("organizer =", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerNotEqualTo(String value) {
            addCriterion("organizer <>", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerGreaterThan(String value) {
            addCriterion("organizer >", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerGreaterThanOrEqualTo(String value) {
            addCriterion("organizer >=", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerLessThan(String value) {
            addCriterion("organizer <", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerLessThanOrEqualTo(String value) {
            addCriterion("organizer <=", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerLike(String value) {
            addCriterion("organizer like", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerNotLike(String value) {
            addCriterion("organizer not like", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerIn(List<String> values) {
            addCriterion("organizer in", values, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerNotIn(List<String> values) {
            addCriterion("organizer not in", values, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerBetween(String value1, String value2) {
            addCriterion("organizer between", value1, value2, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerNotBetween(String value1, String value2) {
            addCriterion("organizer not between", value1, value2, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerCompanyIsNull() {
            addCriterion("organizer_company is null");
            return (Criteria) this;
        }

        public Criteria andOrganizerCompanyIsNotNull() {
            addCriterion("organizer_company is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizerCompanyEqualTo(String value) {
            addCriterion("organizer_company =", value, "organizerCompany");
            return (Criteria) this;
        }

        public Criteria andOrganizerCompanyNotEqualTo(String value) {
            addCriterion("organizer_company <>", value, "organizerCompany");
            return (Criteria) this;
        }

        public Criteria andOrganizerCompanyGreaterThan(String value) {
            addCriterion("organizer_company >", value, "organizerCompany");
            return (Criteria) this;
        }

        public Criteria andOrganizerCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("organizer_company >=", value, "organizerCompany");
            return (Criteria) this;
        }

        public Criteria andOrganizerCompanyLessThan(String value) {
            addCriterion("organizer_company <", value, "organizerCompany");
            return (Criteria) this;
        }

        public Criteria andOrganizerCompanyLessThanOrEqualTo(String value) {
            addCriterion("organizer_company <=", value, "organizerCompany");
            return (Criteria) this;
        }

        public Criteria andOrganizerCompanyLike(String value) {
            addCriterion("organizer_company like", value, "organizerCompany");
            return (Criteria) this;
        }

        public Criteria andOrganizerCompanyNotLike(String value) {
            addCriterion("organizer_company not like", value, "organizerCompany");
            return (Criteria) this;
        }

        public Criteria andOrganizerCompanyIn(List<String> values) {
            addCriterion("organizer_company in", values, "organizerCompany");
            return (Criteria) this;
        }

        public Criteria andOrganizerCompanyNotIn(List<String> values) {
            addCriterion("organizer_company not in", values, "organizerCompany");
            return (Criteria) this;
        }

        public Criteria andOrganizerCompanyBetween(String value1, String value2) {
            addCriterion("organizer_company between", value1, value2, "organizerCompany");
            return (Criteria) this;
        }

        public Criteria andOrganizerCompanyNotBetween(String value1, String value2) {
            addCriterion("organizer_company not between", value1, value2, "organizerCompany");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderIsNull() {
            addCriterion("project_leader is null");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderIsNotNull() {
            addCriterion("project_leader is not null");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderEqualTo(String value) {
            addCriterion("project_leader =", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNotEqualTo(String value) {
            addCriterion("project_leader <>", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderGreaterThan(String value) {
            addCriterion("project_leader >", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("project_leader >=", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderLessThan(String value) {
            addCriterion("project_leader <", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderLessThanOrEqualTo(String value) {
            addCriterion("project_leader <=", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderLike(String value) {
            addCriterion("project_leader like", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNotLike(String value) {
            addCriterion("project_leader not like", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderIn(List<String> values) {
            addCriterion("project_leader in", values, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNotIn(List<String> values) {
            addCriterion("project_leader not in", values, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderBetween(String value1, String value2) {
            addCriterion("project_leader between", value1, value2, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNotBetween(String value1, String value2) {
            addCriterion("project_leader not between", value1, value2, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andTeamMembersIsNull() {
            addCriterion("team_members is null");
            return (Criteria) this;
        }

        public Criteria andTeamMembersIsNotNull() {
            addCriterion("team_members is not null");
            return (Criteria) this;
        }

        public Criteria andTeamMembersEqualTo(String value) {
            addCriterion("team_members =", value, "teamMembers");
            return (Criteria) this;
        }

        public Criteria andTeamMembersNotEqualTo(String value) {
            addCriterion("team_members <>", value, "teamMembers");
            return (Criteria) this;
        }

        public Criteria andTeamMembersGreaterThan(String value) {
            addCriterion("team_members >", value, "teamMembers");
            return (Criteria) this;
        }

        public Criteria andTeamMembersGreaterThanOrEqualTo(String value) {
            addCriterion("team_members >=", value, "teamMembers");
            return (Criteria) this;
        }

        public Criteria andTeamMembersLessThan(String value) {
            addCriterion("team_members <", value, "teamMembers");
            return (Criteria) this;
        }

        public Criteria andTeamMembersLessThanOrEqualTo(String value) {
            addCriterion("team_members <=", value, "teamMembers");
            return (Criteria) this;
        }

        public Criteria andTeamMembersLike(String value) {
            addCriterion("team_members like", value, "teamMembers");
            return (Criteria) this;
        }

        public Criteria andTeamMembersNotLike(String value) {
            addCriterion("team_members not like", value, "teamMembers");
            return (Criteria) this;
        }

        public Criteria andTeamMembersIn(List<String> values) {
            addCriterion("team_members in", values, "teamMembers");
            return (Criteria) this;
        }

        public Criteria andTeamMembersNotIn(List<String> values) {
            addCriterion("team_members not in", values, "teamMembers");
            return (Criteria) this;
        }

        public Criteria andTeamMembersBetween(String value1, String value2) {
            addCriterion("team_members between", value1, value2, "teamMembers");
            return (Criteria) this;
        }

        public Criteria andTeamMembersNotBetween(String value1, String value2) {
            addCriterion("team_members not between", value1, value2, "teamMembers");
            return (Criteria) this;
        }

        public Criteria andPrizeCategoryGradeIsNull() {
            addCriterion("prize_category_grade is null");
            return (Criteria) this;
        }

        public Criteria andPrizeCategoryGradeIsNotNull() {
            addCriterion("prize_category_grade is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeCategoryGradeEqualTo(String value) {
            addCriterion("prize_category_grade =", value, "prizeCategoryGrade");
            return (Criteria) this;
        }

        public Criteria andPrizeCategoryGradeNotEqualTo(String value) {
            addCriterion("prize_category_grade <>", value, "prizeCategoryGrade");
            return (Criteria) this;
        }

        public Criteria andPrizeCategoryGradeGreaterThan(String value) {
            addCriterion("prize_category_grade >", value, "prizeCategoryGrade");
            return (Criteria) this;
        }

        public Criteria andPrizeCategoryGradeGreaterThanOrEqualTo(String value) {
            addCriterion("prize_category_grade >=", value, "prizeCategoryGrade");
            return (Criteria) this;
        }

        public Criteria andPrizeCategoryGradeLessThan(String value) {
            addCriterion("prize_category_grade <", value, "prizeCategoryGrade");
            return (Criteria) this;
        }

        public Criteria andPrizeCategoryGradeLessThanOrEqualTo(String value) {
            addCriterion("prize_category_grade <=", value, "prizeCategoryGrade");
            return (Criteria) this;
        }

        public Criteria andPrizeCategoryGradeLike(String value) {
            addCriterion("prize_category_grade like", value, "prizeCategoryGrade");
            return (Criteria) this;
        }

        public Criteria andPrizeCategoryGradeNotLike(String value) {
            addCriterion("prize_category_grade not like", value, "prizeCategoryGrade");
            return (Criteria) this;
        }

        public Criteria andPrizeCategoryGradeIn(List<String> values) {
            addCriterion("prize_category_grade in", values, "prizeCategoryGrade");
            return (Criteria) this;
        }

        public Criteria andPrizeCategoryGradeNotIn(List<String> values) {
            addCriterion("prize_category_grade not in", values, "prizeCategoryGrade");
            return (Criteria) this;
        }

        public Criteria andPrizeCategoryGradeBetween(String value1, String value2) {
            addCriterion("prize_category_grade between", value1, value2, "prizeCategoryGrade");
            return (Criteria) this;
        }

        public Criteria andPrizeCategoryGradeNotBetween(String value1, String value2) {
            addCriterion("prize_category_grade not between", value1, value2, "prizeCategoryGrade");
            return (Criteria) this;
        }

        public Criteria andPrizeCategoryIsNull() {
            addCriterion("prize_category is null");
            return (Criteria) this;
        }

        public Criteria andPrizeCategoryIsNotNull() {
            addCriterion("prize_category is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeCategoryEqualTo(String value) {
            addCriterion("prize_category =", value, "prizeCategory");
            return (Criteria) this;
        }

        public Criteria andPrizeCategoryNotEqualTo(String value) {
            addCriterion("prize_category <>", value, "prizeCategory");
            return (Criteria) this;
        }

        public Criteria andPrizeCategoryGreaterThan(String value) {
            addCriterion("prize_category >", value, "prizeCategory");
            return (Criteria) this;
        }

        public Criteria andPrizeCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("prize_category >=", value, "prizeCategory");
            return (Criteria) this;
        }

        public Criteria andPrizeCategoryLessThan(String value) {
            addCriterion("prize_category <", value, "prizeCategory");
            return (Criteria) this;
        }

        public Criteria andPrizeCategoryLessThanOrEqualTo(String value) {
            addCriterion("prize_category <=", value, "prizeCategory");
            return (Criteria) this;
        }

        public Criteria andPrizeCategoryLike(String value) {
            addCriterion("prize_category like", value, "prizeCategory");
            return (Criteria) this;
        }

        public Criteria andPrizeCategoryNotLike(String value) {
            addCriterion("prize_category not like", value, "prizeCategory");
            return (Criteria) this;
        }

        public Criteria andPrizeCategoryIn(List<String> values) {
            addCriterion("prize_category in", values, "prizeCategory");
            return (Criteria) this;
        }

        public Criteria andPrizeCategoryNotIn(List<String> values) {
            addCriterion("prize_category not in", values, "prizeCategory");
            return (Criteria) this;
        }

        public Criteria andPrizeCategoryBetween(String value1, String value2) {
            addCriterion("prize_category between", value1, value2, "prizeCategory");
            return (Criteria) this;
        }

        public Criteria andPrizeCategoryNotBetween(String value1, String value2) {
            addCriterion("prize_category not between", value1, value2, "prizeCategory");
            return (Criteria) this;
        }

        public Criteria andPrizeNameIsNull() {
            addCriterion("prize_name is null");
            return (Criteria) this;
        }

        public Criteria andPrizeNameIsNotNull() {
            addCriterion("prize_name is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeNameEqualTo(String value) {
            addCriterion("prize_name =", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameNotEqualTo(String value) {
            addCriterion("prize_name <>", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameGreaterThan(String value) {
            addCriterion("prize_name >", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameGreaterThanOrEqualTo(String value) {
            addCriterion("prize_name >=", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameLessThan(String value) {
            addCriterion("prize_name <", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameLessThanOrEqualTo(String value) {
            addCriterion("prize_name <=", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameLike(String value) {
            addCriterion("prize_name like", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameNotLike(String value) {
            addCriterion("prize_name not like", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameIn(List<String> values) {
            addCriterion("prize_name in", values, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameNotIn(List<String> values) {
            addCriterion("prize_name not in", values, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameBetween(String value1, String value2) {
            addCriterion("prize_name between", value1, value2, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameNotBetween(String value1, String value2) {
            addCriterion("prize_name not between", value1, value2, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeTimeIsNull() {
            addCriterion("prize_time is null");
            return (Criteria) this;
        }

        public Criteria andPrizeTimeIsNotNull() {
            addCriterion("prize_time is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeTimeEqualTo(Date value) {
            addCriterionForJDBCDate("prize_time =", value, "prizeTime");
            return (Criteria) this;
        }

        public Criteria andPrizeTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("prize_time <>", value, "prizeTime");
            return (Criteria) this;
        }

        public Criteria andPrizeTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("prize_time >", value, "prizeTime");
            return (Criteria) this;
        }

        public Criteria andPrizeTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("prize_time >=", value, "prizeTime");
            return (Criteria) this;
        }

        public Criteria andPrizeTimeLessThan(Date value) {
            addCriterionForJDBCDate("prize_time <", value, "prizeTime");
            return (Criteria) this;
        }

        public Criteria andPrizeTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("prize_time <=", value, "prizeTime");
            return (Criteria) this;
        }

        public Criteria andPrizeTimeIn(List<Date> values) {
            addCriterionForJDBCDate("prize_time in", values, "prizeTime");
            return (Criteria) this;
        }

        public Criteria andPrizeTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("prize_time not in", values, "prizeTime");
            return (Criteria) this;
        }

        public Criteria andPrizeTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("prize_time between", value1, value2, "prizeTime");
            return (Criteria) this;
        }

        public Criteria andPrizeTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("prize_time not between", value1, value2, "prizeTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andConfirmPrizeStatusIsNull() {
            addCriterion("confirm_prize_status is null");
            return (Criteria) this;
        }

        public Criteria andConfirmPrizeStatusIsNotNull() {
            addCriterion("confirm_prize_status is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmPrizeStatusEqualTo(String value) {
            addCriterion("confirm_prize_status =", value, "confirmPrizeStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmPrizeStatusNotEqualTo(String value) {
            addCriterion("confirm_prize_status <>", value, "confirmPrizeStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmPrizeStatusGreaterThan(String value) {
            addCriterion("confirm_prize_status >", value, "confirmPrizeStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmPrizeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("confirm_prize_status >=", value, "confirmPrizeStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmPrizeStatusLessThan(String value) {
            addCriterion("confirm_prize_status <", value, "confirmPrizeStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmPrizeStatusLessThanOrEqualTo(String value) {
            addCriterion("confirm_prize_status <=", value, "confirmPrizeStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmPrizeStatusLike(String value) {
            addCriterion("confirm_prize_status like", value, "confirmPrizeStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmPrizeStatusNotLike(String value) {
            addCriterion("confirm_prize_status not like", value, "confirmPrizeStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmPrizeStatusIn(List<String> values) {
            addCriterion("confirm_prize_status in", values, "confirmPrizeStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmPrizeStatusNotIn(List<String> values) {
            addCriterion("confirm_prize_status not in", values, "confirmPrizeStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmPrizeStatusBetween(String value1, String value2) {
            addCriterion("confirm_prize_status between", value1, value2, "confirmPrizeStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmPrizeStatusNotBetween(String value1, String value2) {
            addCriterion("confirm_prize_status not between", value1, value2, "confirmPrizeStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmProjectStatusIsNull() {
            addCriterion("confirm_project_status is null");
            return (Criteria) this;
        }

        public Criteria andConfirmProjectStatusIsNotNull() {
            addCriterion("confirm_project_status is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmProjectStatusEqualTo(String value) {
            addCriterion("confirm_project_status =", value, "confirmProjectStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmProjectStatusNotEqualTo(String value) {
            addCriterion("confirm_project_status <>", value, "confirmProjectStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmProjectStatusGreaterThan(String value) {
            addCriterion("confirm_project_status >", value, "confirmProjectStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmProjectStatusGreaterThanOrEqualTo(String value) {
            addCriterion("confirm_project_status >=", value, "confirmProjectStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmProjectStatusLessThan(String value) {
            addCriterion("confirm_project_status <", value, "confirmProjectStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmProjectStatusLessThanOrEqualTo(String value) {
            addCriterion("confirm_project_status <=", value, "confirmProjectStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmProjectStatusLike(String value) {
            addCriterion("confirm_project_status like", value, "confirmProjectStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmProjectStatusNotLike(String value) {
            addCriterion("confirm_project_status not like", value, "confirmProjectStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmProjectStatusIn(List<String> values) {
            addCriterion("confirm_project_status in", values, "confirmProjectStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmProjectStatusNotIn(List<String> values) {
            addCriterion("confirm_project_status not in", values, "confirmProjectStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmProjectStatusBetween(String value1, String value2) {
            addCriterion("confirm_project_status between", value1, value2, "confirmProjectStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmProjectStatusNotBetween(String value1, String value2) {
            addCriterion("confirm_project_status not between", value1, value2, "confirmProjectStatus");
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