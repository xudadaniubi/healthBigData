package com.boku.www.pojo;

import java.util.ArrayList;
import java.util.List;

public class TAreaAndCompanyExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public TAreaAndCompanyExample() {
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

		public Criteria andCityIsNull() {
			addCriterion("city is null");
			return (Criteria) this;
		}

		public Criteria andCityIsNotNull() {
			addCriterion("city is not null");
			return (Criteria) this;
		}

		public Criteria andCityEqualTo(String value) {
			addCriterion("city =", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityNotEqualTo(String value) {
			addCriterion("city <>", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityGreaterThan(String value) {
			addCriterion("city >", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityGreaterThanOrEqualTo(String value) {
			addCriterion("city >=", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityLessThan(String value) {
			addCriterion("city <", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityLessThanOrEqualTo(String value) {
			addCriterion("city <=", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityLike(String value) {
			addCriterion("city like", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityNotLike(String value) {
			addCriterion("city not like", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityIn(List<String> values) {
			addCriterion("city in", values, "city");
			return (Criteria) this;
		}

		public Criteria andCityNotIn(List<String> values) {
			addCriterion("city not in", values, "city");
			return (Criteria) this;
		}

		public Criteria andCityBetween(String value1, String value2) {
			addCriterion("city between", value1, value2, "city");
			return (Criteria) this;
		}

		public Criteria andCityNotBetween(String value1, String value2) {
			addCriterion("city not between", value1, value2, "city");
			return (Criteria) this;
		}

		public Criteria andDistrictIsNull() {
			addCriterion("district is null");
			return (Criteria) this;
		}

		public Criteria andDistrictIsNotNull() {
			addCriterion("district is not null");
			return (Criteria) this;
		}

		public Criteria andDistrictEqualTo(String value) {
			addCriterion("district =", value, "district");
			return (Criteria) this;
		}

		public Criteria andDistrictNotEqualTo(String value) {
			addCriterion("district <>", value, "district");
			return (Criteria) this;
		}

		public Criteria andDistrictGreaterThan(String value) {
			addCriterion("district >", value, "district");
			return (Criteria) this;
		}

		public Criteria andDistrictGreaterThanOrEqualTo(String value) {
			addCriterion("district >=", value, "district");
			return (Criteria) this;
		}

		public Criteria andDistrictLessThan(String value) {
			addCriterion("district <", value, "district");
			return (Criteria) this;
		}

		public Criteria andDistrictLessThanOrEqualTo(String value) {
			addCriterion("district <=", value, "district");
			return (Criteria) this;
		}

		public Criteria andDistrictLike(String value) {
			addCriterion("district like", value, "district");
			return (Criteria) this;
		}

		public Criteria andDistrictNotLike(String value) {
			addCriterion("district not like", value, "district");
			return (Criteria) this;
		}

		public Criteria andDistrictIn(List<String> values) {
			addCriterion("district in", values, "district");
			return (Criteria) this;
		}

		public Criteria andDistrictNotIn(List<String> values) {
			addCriterion("district not in", values, "district");
			return (Criteria) this;
		}

		public Criteria andDistrictBetween(String value1, String value2) {
			addCriterion("district between", value1, value2, "district");
			return (Criteria) this;
		}

		public Criteria andDistrictNotBetween(String value1, String value2) {
			addCriterion("district not between", value1, value2, "district");
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

		public Criteria andCompanyIdIsNull() {
			addCriterion("company_id is null");
			return (Criteria) this;
		}

		public Criteria andCompanyIdIsNotNull() {
			addCriterion("company_id is not null");
			return (Criteria) this;
		}

		public Criteria andCompanyIdEqualTo(String value) {
			addCriterion("company_id =", value, "companyId");
			return (Criteria) this;
		}

		public Criteria andCompanyIdNotEqualTo(String value) {
			addCriterion("company_id <>", value, "companyId");
			return (Criteria) this;
		}

		public Criteria andCompanyIdGreaterThan(String value) {
			addCriterion("company_id >", value, "companyId");
			return (Criteria) this;
		}

		public Criteria andCompanyIdGreaterThanOrEqualTo(String value) {
			addCriterion("company_id >=", value, "companyId");
			return (Criteria) this;
		}

		public Criteria andCompanyIdLessThan(String value) {
			addCriterion("company_id <", value, "companyId");
			return (Criteria) this;
		}

		public Criteria andCompanyIdLessThanOrEqualTo(String value) {
			addCriterion("company_id <=", value, "companyId");
			return (Criteria) this;
		}

		public Criteria andCompanyIdLike(String value) {
			addCriterion("company_id like", value, "companyId");
			return (Criteria) this;
		}

		public Criteria andCompanyIdNotLike(String value) {
			addCriterion("company_id not like", value, "companyId");
			return (Criteria) this;
		}

		public Criteria andCompanyIdIn(List<String> values) {
			addCriterion("company_id in", values, "companyId");
			return (Criteria) this;
		}

		public Criteria andCompanyIdNotIn(List<String> values) {
			addCriterion("company_id not in", values, "companyId");
			return (Criteria) this;
		}

		public Criteria andCompanyIdBetween(String value1, String value2) {
			addCriterion("company_id between", value1, value2, "companyId");
			return (Criteria) this;
		}

		public Criteria andCompanyIdNotBetween(String value1, String value2) {
			addCriterion("company_id not between", value1, value2, "companyId");
			return (Criteria) this;
		}

		public Criteria andThesisForChineseNumIsNull() {
			addCriterion("thesis_for_chinese_num is null");
			return (Criteria) this;
		}

		public Criteria andThesisForChineseNumIsNotNull() {
			addCriterion("thesis_for_chinese_num is not null");
			return (Criteria) this;
		}

		public Criteria andThesisForChineseNumEqualTo(Integer value) {
			addCriterion("thesis_for_chinese_num =", value, "thesisForChineseNum");
			return (Criteria) this;
		}

		public Criteria andThesisForChineseNumNotEqualTo(Integer value) {
			addCriterion("thesis_for_chinese_num <>", value, "thesisForChineseNum");
			return (Criteria) this;
		}

		public Criteria andThesisForChineseNumGreaterThan(Integer value) {
			addCriterion("thesis_for_chinese_num >", value, "thesisForChineseNum");
			return (Criteria) this;
		}

		public Criteria andThesisForChineseNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("thesis_for_chinese_num >=", value, "thesisForChineseNum");
			return (Criteria) this;
		}

		public Criteria andThesisForChineseNumLessThan(Integer value) {
			addCriterion("thesis_for_chinese_num <", value, "thesisForChineseNum");
			return (Criteria) this;
		}

		public Criteria andThesisForChineseNumLessThanOrEqualTo(Integer value) {
			addCriterion("thesis_for_chinese_num <=", value, "thesisForChineseNum");
			return (Criteria) this;
		}

		public Criteria andThesisForChineseNumIn(List<Integer> values) {
			addCriterion("thesis_for_chinese_num in", values, "thesisForChineseNum");
			return (Criteria) this;
		}

		public Criteria andThesisForChineseNumNotIn(List<Integer> values) {
			addCriterion("thesis_for_chinese_num not in", values, "thesisForChineseNum");
			return (Criteria) this;
		}

		public Criteria andThesisForChineseNumBetween(Integer value1, Integer value2) {
			addCriterion("thesis_for_chinese_num between", value1, value2, "thesisForChineseNum");
			return (Criteria) this;
		}

		public Criteria andThesisForChineseNumNotBetween(Integer value1, Integer value2) {
			addCriterion("thesis_for_chinese_num not between", value1, value2, "thesisForChineseNum");
			return (Criteria) this;
		}

		public Criteria andThesisForEnglishNumIsNull() {
			addCriterion("thesis_for_english_num is null");
			return (Criteria) this;
		}

		public Criteria andThesisForEnglishNumIsNotNull() {
			addCriterion("thesis_for_english_num is not null");
			return (Criteria) this;
		}

		public Criteria andThesisForEnglishNumEqualTo(Integer value) {
			addCriterion("thesis_for_english_num =", value, "thesisForEnglishNum");
			return (Criteria) this;
		}

		public Criteria andThesisForEnglishNumNotEqualTo(Integer value) {
			addCriterion("thesis_for_english_num <>", value, "thesisForEnglishNum");
			return (Criteria) this;
		}

		public Criteria andThesisForEnglishNumGreaterThan(Integer value) {
			addCriterion("thesis_for_english_num >", value, "thesisForEnglishNum");
			return (Criteria) this;
		}

		public Criteria andThesisForEnglishNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("thesis_for_english_num >=", value, "thesisForEnglishNum");
			return (Criteria) this;
		}

		public Criteria andThesisForEnglishNumLessThan(Integer value) {
			addCriterion("thesis_for_english_num <", value, "thesisForEnglishNum");
			return (Criteria) this;
		}

		public Criteria andThesisForEnglishNumLessThanOrEqualTo(Integer value) {
			addCriterion("thesis_for_english_num <=", value, "thesisForEnglishNum");
			return (Criteria) this;
		}

		public Criteria andThesisForEnglishNumIn(List<Integer> values) {
			addCriterion("thesis_for_english_num in", values, "thesisForEnglishNum");
			return (Criteria) this;
		}

		public Criteria andThesisForEnglishNumNotIn(List<Integer> values) {
			addCriterion("thesis_for_english_num not in", values, "thesisForEnglishNum");
			return (Criteria) this;
		}

		public Criteria andThesisForEnglishNumBetween(Integer value1, Integer value2) {
			addCriterion("thesis_for_english_num between", value1, value2, "thesisForEnglishNum");
			return (Criteria) this;
		}

		public Criteria andThesisForEnglishNumNotBetween(Integer value1, Integer value2) {
			addCriterion("thesis_for_english_num not between", value1, value2, "thesisForEnglishNum");
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