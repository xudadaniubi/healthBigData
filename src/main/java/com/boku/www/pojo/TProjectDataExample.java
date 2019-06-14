package com.boku.www.pojo;

import java.util.ArrayList;
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

		public Criteria andProjectCategoryIsNull() {
			addCriterion("project_category is null");
			return (Criteria) this;
		}

		public Criteria andProjectCategoryIsNotNull() {
			addCriterion("project_category is not null");
			return (Criteria) this;
		}

		public Criteria andProjectCategoryEqualTo(String value) {
			addCriterion("project_category =", value, "projectCategory");
			return (Criteria) this;
		}

		public Criteria andProjectCategoryNotEqualTo(String value) {
			addCriterion("project_category <>", value, "projectCategory");
			return (Criteria) this;
		}

		public Criteria andProjectCategoryGreaterThan(String value) {
			addCriterion("project_category >", value, "projectCategory");
			return (Criteria) this;
		}

		public Criteria andProjectCategoryGreaterThanOrEqualTo(String value) {
			addCriterion("project_category >=", value, "projectCategory");
			return (Criteria) this;
		}

		public Criteria andProjectCategoryLessThan(String value) {
			addCriterion("project_category <", value, "projectCategory");
			return (Criteria) this;
		}

		public Criteria andProjectCategoryLessThanOrEqualTo(String value) {
			addCriterion("project_category <=", value, "projectCategory");
			return (Criteria) this;
		}

		public Criteria andProjectCategoryLike(String value) {
			addCriterion("project_category like", value, "projectCategory");
			return (Criteria) this;
		}

		public Criteria andProjectCategoryNotLike(String value) {
			addCriterion("project_category not like", value, "projectCategory");
			return (Criteria) this;
		}

		public Criteria andProjectCategoryIn(List<String> values) {
			addCriterion("project_category in", values, "projectCategory");
			return (Criteria) this;
		}

		public Criteria andProjectCategoryNotIn(List<String> values) {
			addCriterion("project_category not in", values, "projectCategory");
			return (Criteria) this;
		}

		public Criteria andProjectCategoryBetween(String value1, String value2) {
			addCriterion("project_category between", value1, value2, "projectCategory");
			return (Criteria) this;
		}

		public Criteria andProjectCategoryNotBetween(String value1, String value2) {
			addCriterion("project_category not between", value1, value2, "projectCategory");
			return (Criteria) this;
		}

		public Criteria andSubjectName1IsNull() {
			addCriterion("subject_name1 is null");
			return (Criteria) this;
		}

		public Criteria andSubjectName1IsNotNull() {
			addCriterion("subject_name1 is not null");
			return (Criteria) this;
		}

		public Criteria andSubjectName1EqualTo(String value) {
			addCriterion("subject_name1 =", value, "subjectName1");
			return (Criteria) this;
		}

		public Criteria andSubjectName1NotEqualTo(String value) {
			addCriterion("subject_name1 <>", value, "subjectName1");
			return (Criteria) this;
		}

		public Criteria andSubjectName1GreaterThan(String value) {
			addCriterion("subject_name1 >", value, "subjectName1");
			return (Criteria) this;
		}

		public Criteria andSubjectName1GreaterThanOrEqualTo(String value) {
			addCriterion("subject_name1 >=", value, "subjectName1");
			return (Criteria) this;
		}

		public Criteria andSubjectName1LessThan(String value) {
			addCriterion("subject_name1 <", value, "subjectName1");
			return (Criteria) this;
		}

		public Criteria andSubjectName1LessThanOrEqualTo(String value) {
			addCriterion("subject_name1 <=", value, "subjectName1");
			return (Criteria) this;
		}

		public Criteria andSubjectName1Like(String value) {
			addCriterion("subject_name1 like", value, "subjectName1");
			return (Criteria) this;
		}

		public Criteria andSubjectName1NotLike(String value) {
			addCriterion("subject_name1 not like", value, "subjectName1");
			return (Criteria) this;
		}

		public Criteria andSubjectName1In(List<String> values) {
			addCriterion("subject_name1 in", values, "subjectName1");
			return (Criteria) this;
		}

		public Criteria andSubjectName1NotIn(List<String> values) {
			addCriterion("subject_name1 not in", values, "subjectName1");
			return (Criteria) this;
		}

		public Criteria andSubjectName1Between(String value1, String value2) {
			addCriterion("subject_name1 between", value1, value2, "subjectName1");
			return (Criteria) this;
		}

		public Criteria andSubjectName1NotBetween(String value1, String value2) {
			addCriterion("subject_name1 not between", value1, value2, "subjectName1");
			return (Criteria) this;
		}

		public Criteria andSubjectName2IsNull() {
			addCriterion("subject_name2 is null");
			return (Criteria) this;
		}

		public Criteria andSubjectName2IsNotNull() {
			addCriterion("subject_name2 is not null");
			return (Criteria) this;
		}

		public Criteria andSubjectName2EqualTo(String value) {
			addCriterion("subject_name2 =", value, "subjectName2");
			return (Criteria) this;
		}

		public Criteria andSubjectName2NotEqualTo(String value) {
			addCriterion("subject_name2 <>", value, "subjectName2");
			return (Criteria) this;
		}

		public Criteria andSubjectName2GreaterThan(String value) {
			addCriterion("subject_name2 >", value, "subjectName2");
			return (Criteria) this;
		}

		public Criteria andSubjectName2GreaterThanOrEqualTo(String value) {
			addCriterion("subject_name2 >=", value, "subjectName2");
			return (Criteria) this;
		}

		public Criteria andSubjectName2LessThan(String value) {
			addCriterion("subject_name2 <", value, "subjectName2");
			return (Criteria) this;
		}

		public Criteria andSubjectName2LessThanOrEqualTo(String value) {
			addCriterion("subject_name2 <=", value, "subjectName2");
			return (Criteria) this;
		}

		public Criteria andSubjectName2Like(String value) {
			addCriterion("subject_name2 like", value, "subjectName2");
			return (Criteria) this;
		}

		public Criteria andSubjectName2NotLike(String value) {
			addCriterion("subject_name2 not like", value, "subjectName2");
			return (Criteria) this;
		}

		public Criteria andSubjectName2In(List<String> values) {
			addCriterion("subject_name2 in", values, "subjectName2");
			return (Criteria) this;
		}

		public Criteria andSubjectName2NotIn(List<String> values) {
			addCriterion("subject_name2 not in", values, "subjectName2");
			return (Criteria) this;
		}

		public Criteria andSubjectName2Between(String value1, String value2) {
			addCriterion("subject_name2 between", value1, value2, "subjectName2");
			return (Criteria) this;
		}

		public Criteria andSubjectName2NotBetween(String value1, String value2) {
			addCriterion("subject_name2 not between", value1, value2, "subjectName2");
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

		public Criteria andProjectStartTimeIsNull() {
			addCriterion("project_start_time is null");
			return (Criteria) this;
		}

		public Criteria andProjectStartTimeIsNotNull() {
			addCriterion("project_start_time is not null");
			return (Criteria) this;
		}

		public Criteria andProjectStartTimeEqualTo(String value) {
			addCriterion("project_start_time =", value, "projectStartTime");
			return (Criteria) this;
		}

		public Criteria andProjectStartTimeNotEqualTo(String value) {
			addCriterion("project_start_time <>", value, "projectStartTime");
			return (Criteria) this;
		}

		public Criteria andProjectStartTimeGreaterThan(String value) {
			addCriterion("project_start_time >", value, "projectStartTime");
			return (Criteria) this;
		}

		public Criteria andProjectStartTimeGreaterThanOrEqualTo(String value) {
			addCriterion("project_start_time >=", value, "projectStartTime");
			return (Criteria) this;
		}

		public Criteria andProjectStartTimeLessThan(String value) {
			addCriterion("project_start_time <", value, "projectStartTime");
			return (Criteria) this;
		}

		public Criteria andProjectStartTimeLessThanOrEqualTo(String value) {
			addCriterion("project_start_time <=", value, "projectStartTime");
			return (Criteria) this;
		}

		public Criteria andProjectStartTimeLike(String value) {
			addCriterion("project_start_time like", value, "projectStartTime");
			return (Criteria) this;
		}

		public Criteria andProjectStartTimeNotLike(String value) {
			addCriterion("project_start_time not like", value, "projectStartTime");
			return (Criteria) this;
		}

		public Criteria andProjectStartTimeIn(List<String> values) {
			addCriterion("project_start_time in", values, "projectStartTime");
			return (Criteria) this;
		}

		public Criteria andProjectStartTimeNotIn(List<String> values) {
			addCriterion("project_start_time not in", values, "projectStartTime");
			return (Criteria) this;
		}

		public Criteria andProjectStartTimeBetween(String value1, String value2) {
			addCriterion("project_start_time between", value1, value2, "projectStartTime");
			return (Criteria) this;
		}

		public Criteria andProjectStartTimeNotBetween(String value1, String value2) {
			addCriterion("project_start_time not between", value1, value2, "projectStartTime");
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

		public Criteria andProjectEndTimeEqualTo(String value) {
			addCriterion("project_end_time =", value, "projectEndTime");
			return (Criteria) this;
		}

		public Criteria andProjectEndTimeNotEqualTo(String value) {
			addCriterion("project_end_time <>", value, "projectEndTime");
			return (Criteria) this;
		}

		public Criteria andProjectEndTimeGreaterThan(String value) {
			addCriterion("project_end_time >", value, "projectEndTime");
			return (Criteria) this;
		}

		public Criteria andProjectEndTimeGreaterThanOrEqualTo(String value) {
			addCriterion("project_end_time >=", value, "projectEndTime");
			return (Criteria) this;
		}

		public Criteria andProjectEndTimeLessThan(String value) {
			addCriterion("project_end_time <", value, "projectEndTime");
			return (Criteria) this;
		}

		public Criteria andProjectEndTimeLessThanOrEqualTo(String value) {
			addCriterion("project_end_time <=", value, "projectEndTime");
			return (Criteria) this;
		}

		public Criteria andProjectEndTimeLike(String value) {
			addCriterion("project_end_time like", value, "projectEndTime");
			return (Criteria) this;
		}

		public Criteria andProjectEndTimeNotLike(String value) {
			addCriterion("project_end_time not like", value, "projectEndTime");
			return (Criteria) this;
		}

		public Criteria andProjectEndTimeIn(List<String> values) {
			addCriterion("project_end_time in", values, "projectEndTime");
			return (Criteria) this;
		}

		public Criteria andProjectEndTimeNotIn(List<String> values) {
			addCriterion("project_end_time not in", values, "projectEndTime");
			return (Criteria) this;
		}

		public Criteria andProjectEndTimeBetween(String value1, String value2) {
			addCriterion("project_end_time between", value1, value2, "projectEndTime");
			return (Criteria) this;
		}

		public Criteria andProjectEndTimeNotBetween(String value1, String value2) {
			addCriterion("project_end_time not between", value1, value2, "projectEndTime");
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

		public Criteria andOtherOrganizerCompanyIsNull() {
			addCriterion("other_organizer_company is null");
			return (Criteria) this;
		}

		public Criteria andOtherOrganizerCompanyIsNotNull() {
			addCriterion("other_organizer_company is not null");
			return (Criteria) this;
		}

		public Criteria andOtherOrganizerCompanyEqualTo(String value) {
			addCriterion("other_organizer_company =", value, "otherOrganizerCompany");
			return (Criteria) this;
		}

		public Criteria andOtherOrganizerCompanyNotEqualTo(String value) {
			addCriterion("other_organizer_company <>", value, "otherOrganizerCompany");
			return (Criteria) this;
		}

		public Criteria andOtherOrganizerCompanyGreaterThan(String value) {
			addCriterion("other_organizer_company >", value, "otherOrganizerCompany");
			return (Criteria) this;
		}

		public Criteria andOtherOrganizerCompanyGreaterThanOrEqualTo(String value) {
			addCriterion("other_organizer_company >=", value, "otherOrganizerCompany");
			return (Criteria) this;
		}

		public Criteria andOtherOrganizerCompanyLessThan(String value) {
			addCriterion("other_organizer_company <", value, "otherOrganizerCompany");
			return (Criteria) this;
		}

		public Criteria andOtherOrganizerCompanyLessThanOrEqualTo(String value) {
			addCriterion("other_organizer_company <=", value, "otherOrganizerCompany");
			return (Criteria) this;
		}

		public Criteria andOtherOrganizerCompanyLike(String value) {
			addCriterion("other_organizer_company like", value, "otherOrganizerCompany");
			return (Criteria) this;
		}

		public Criteria andOtherOrganizerCompanyNotLike(String value) {
			addCriterion("other_organizer_company not like", value, "otherOrganizerCompany");
			return (Criteria) this;
		}

		public Criteria andOtherOrganizerCompanyIn(List<String> values) {
			addCriterion("other_organizer_company in", values, "otherOrganizerCompany");
			return (Criteria) this;
		}

		public Criteria andOtherOrganizerCompanyNotIn(List<String> values) {
			addCriterion("other_organizer_company not in", values, "otherOrganizerCompany");
			return (Criteria) this;
		}

		public Criteria andOtherOrganizerCompanyBetween(String value1, String value2) {
			addCriterion("other_organizer_company between", value1, value2, "otherOrganizerCompany");
			return (Criteria) this;
		}

		public Criteria andOtherOrganizerCompanyNotBetween(String value1, String value2) {
			addCriterion("other_organizer_company not between", value1, value2, "otherOrganizerCompany");
			return (Criteria) this;
		}

		public Criteria andFirstOrganizerCompanyIsNull() {
			addCriterion("first_organizer_company is null");
			return (Criteria) this;
		}

		public Criteria andFirstOrganizerCompanyIsNotNull() {
			addCriterion("first_organizer_company is not null");
			return (Criteria) this;
		}

		public Criteria andFirstOrganizerCompanyEqualTo(String value) {
			addCriterion("first_organizer_company =", value, "firstOrganizerCompany");
			return (Criteria) this;
		}

		public Criteria andFirstOrganizerCompanyNotEqualTo(String value) {
			addCriterion("first_organizer_company <>", value, "firstOrganizerCompany");
			return (Criteria) this;
		}

		public Criteria andFirstOrganizerCompanyGreaterThan(String value) {
			addCriterion("first_organizer_company >", value, "firstOrganizerCompany");
			return (Criteria) this;
		}

		public Criteria andFirstOrganizerCompanyGreaterThanOrEqualTo(String value) {
			addCriterion("first_organizer_company >=", value, "firstOrganizerCompany");
			return (Criteria) this;
		}

		public Criteria andFirstOrganizerCompanyLessThan(String value) {
			addCriterion("first_organizer_company <", value, "firstOrganizerCompany");
			return (Criteria) this;
		}

		public Criteria andFirstOrganizerCompanyLessThanOrEqualTo(String value) {
			addCriterion("first_organizer_company <=", value, "firstOrganizerCompany");
			return (Criteria) this;
		}

		public Criteria andFirstOrganizerCompanyLike(String value) {
			addCriterion("first_organizer_company like", value, "firstOrganizerCompany");
			return (Criteria) this;
		}

		public Criteria andFirstOrganizerCompanyNotLike(String value) {
			addCriterion("first_organizer_company not like", value, "firstOrganizerCompany");
			return (Criteria) this;
		}

		public Criteria andFirstOrganizerCompanyIn(List<String> values) {
			addCriterion("first_organizer_company in", values, "firstOrganizerCompany");
			return (Criteria) this;
		}

		public Criteria andFirstOrganizerCompanyNotIn(List<String> values) {
			addCriterion("first_organizer_company not in", values, "firstOrganizerCompany");
			return (Criteria) this;
		}

		public Criteria andFirstOrganizerCompanyBetween(String value1, String value2) {
			addCriterion("first_organizer_company between", value1, value2, "firstOrganizerCompany");
			return (Criteria) this;
		}

		public Criteria andFirstOrganizerCompanyNotBetween(String value1, String value2) {
			addCriterion("first_organizer_company not between", value1, value2, "firstOrganizerCompany");
			return (Criteria) this;
		}

		public Criteria andOrganizerCompanyIdIsNull() {
			addCriterion("organizer_company_id is null");
			return (Criteria) this;
		}

		public Criteria andOrganizerCompanyIdIsNotNull() {
			addCriterion("organizer_company_id is not null");
			return (Criteria) this;
		}

		public Criteria andOrganizerCompanyIdEqualTo(String value) {
			addCriterion("organizer_company_id =", value, "organizerCompanyId");
			return (Criteria) this;
		}

		public Criteria andOrganizerCompanyIdNotEqualTo(String value) {
			addCriterion("organizer_company_id <>", value, "organizerCompanyId");
			return (Criteria) this;
		}

		public Criteria andOrganizerCompanyIdGreaterThan(String value) {
			addCriterion("organizer_company_id >", value, "organizerCompanyId");
			return (Criteria) this;
		}

		public Criteria andOrganizerCompanyIdGreaterThanOrEqualTo(String value) {
			addCriterion("organizer_company_id >=", value, "organizerCompanyId");
			return (Criteria) this;
		}

		public Criteria andOrganizerCompanyIdLessThan(String value) {
			addCriterion("organizer_company_id <", value, "organizerCompanyId");
			return (Criteria) this;
		}

		public Criteria andOrganizerCompanyIdLessThanOrEqualTo(String value) {
			addCriterion("organizer_company_id <=", value, "organizerCompanyId");
			return (Criteria) this;
		}

		public Criteria andOrganizerCompanyIdLike(String value) {
			addCriterion("organizer_company_id like", value, "organizerCompanyId");
			return (Criteria) this;
		}

		public Criteria andOrganizerCompanyIdNotLike(String value) {
			addCriterion("organizer_company_id not like", value, "organizerCompanyId");
			return (Criteria) this;
		}

		public Criteria andOrganizerCompanyIdIn(List<String> values) {
			addCriterion("organizer_company_id in", values, "organizerCompanyId");
			return (Criteria) this;
		}

		public Criteria andOrganizerCompanyIdNotIn(List<String> values) {
			addCriterion("organizer_company_id not in", values, "organizerCompanyId");
			return (Criteria) this;
		}

		public Criteria andOrganizerCompanyIdBetween(String value1, String value2) {
			addCriterion("organizer_company_id between", value1, value2, "organizerCompanyId");
			return (Criteria) this;
		}

		public Criteria andOrganizerCompanyIdNotBetween(String value1, String value2) {
			addCriterion("organizer_company_id not between", value1, value2, "organizerCompanyId");
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

		public Criteria andConfirmStatusIsNull() {
			addCriterion("confirm_status is null");
			return (Criteria) this;
		}

		public Criteria andConfirmStatusIsNotNull() {
			addCriterion("confirm_status is not null");
			return (Criteria) this;
		}

		public Criteria andConfirmStatusEqualTo(String value) {
			addCriterion("confirm_status =", value, "confirmStatus");
			return (Criteria) this;
		}

		public Criteria andConfirmStatusNotEqualTo(String value) {
			addCriterion("confirm_status <>", value, "confirmStatus");
			return (Criteria) this;
		}

		public Criteria andConfirmStatusGreaterThan(String value) {
			addCriterion("confirm_status >", value, "confirmStatus");
			return (Criteria) this;
		}

		public Criteria andConfirmStatusGreaterThanOrEqualTo(String value) {
			addCriterion("confirm_status >=", value, "confirmStatus");
			return (Criteria) this;
		}

		public Criteria andConfirmStatusLessThan(String value) {
			addCriterion("confirm_status <", value, "confirmStatus");
			return (Criteria) this;
		}

		public Criteria andConfirmStatusLessThanOrEqualTo(String value) {
			addCriterion("confirm_status <=", value, "confirmStatus");
			return (Criteria) this;
		}

		public Criteria andConfirmStatusLike(String value) {
			addCriterion("confirm_status like", value, "confirmStatus");
			return (Criteria) this;
		}

		public Criteria andConfirmStatusNotLike(String value) {
			addCriterion("confirm_status not like", value, "confirmStatus");
			return (Criteria) this;
		}

		public Criteria andConfirmStatusIn(List<String> values) {
			addCriterion("confirm_status in", values, "confirmStatus");
			return (Criteria) this;
		}

		public Criteria andConfirmStatusNotIn(List<String> values) {
			addCriterion("confirm_status not in", values, "confirmStatus");
			return (Criteria) this;
		}

		public Criteria andConfirmStatusBetween(String value1, String value2) {
			addCriterion("confirm_status between", value1, value2, "confirmStatus");
			return (Criteria) this;
		}

		public Criteria andConfirmStatusNotBetween(String value1, String value2) {
			addCriterion("confirm_status not between", value1, value2, "confirmStatus");
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