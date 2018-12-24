package com.boku.www.pojo;

import java.util.ArrayList;
import java.util.List;

public class TPatentExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public TPatentExample() {
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

		public Criteria andFirstInventoIsNull() {
			addCriterion("first_invento is null");
			return (Criteria) this;
		}

		public Criteria andFirstInventoIsNotNull() {
			addCriterion("first_invento is not null");
			return (Criteria) this;
		}

		public Criteria andFirstInventoEqualTo(String value) {
			addCriterion("first_invento =", value, "firstInvento");
			return (Criteria) this;
		}

		public Criteria andFirstInventoNotEqualTo(String value) {
			addCriterion("first_invento <>", value, "firstInvento");
			return (Criteria) this;
		}

		public Criteria andFirstInventoGreaterThan(String value) {
			addCriterion("first_invento >", value, "firstInvento");
			return (Criteria) this;
		}

		public Criteria andFirstInventoGreaterThanOrEqualTo(String value) {
			addCriterion("first_invento >=", value, "firstInvento");
			return (Criteria) this;
		}

		public Criteria andFirstInventoLessThan(String value) {
			addCriterion("first_invento <", value, "firstInvento");
			return (Criteria) this;
		}

		public Criteria andFirstInventoLessThanOrEqualTo(String value) {
			addCriterion("first_invento <=", value, "firstInvento");
			return (Criteria) this;
		}

		public Criteria andFirstInventoLike(String value) {
			addCriterion("first_invento like", value, "firstInvento");
			return (Criteria) this;
		}

		public Criteria andFirstInventoNotLike(String value) {
			addCriterion("first_invento not like", value, "firstInvento");
			return (Criteria) this;
		}

		public Criteria andFirstInventoIn(List<String> values) {
			addCriterion("first_invento in", values, "firstInvento");
			return (Criteria) this;
		}

		public Criteria andFirstInventoNotIn(List<String> values) {
			addCriterion("first_invento not in", values, "firstInvento");
			return (Criteria) this;
		}

		public Criteria andFirstInventoBetween(String value1, String value2) {
			addCriterion("first_invento between", value1, value2, "firstInvento");
			return (Criteria) this;
		}

		public Criteria andFirstInventoNotBetween(String value1, String value2) {
			addCriterion("first_invento not between", value1, value2, "firstInvento");
			return (Criteria) this;
		}

		public Criteria andOtherInventorsIsNull() {
			addCriterion("other_inventors is null");
			return (Criteria) this;
		}

		public Criteria andOtherInventorsIsNotNull() {
			addCriterion("other_inventors is not null");
			return (Criteria) this;
		}

		public Criteria andOtherInventorsEqualTo(String value) {
			addCriterion("other_inventors =", value, "otherInventors");
			return (Criteria) this;
		}

		public Criteria andOtherInventorsNotEqualTo(String value) {
			addCriterion("other_inventors <>", value, "otherInventors");
			return (Criteria) this;
		}

		public Criteria andOtherInventorsGreaterThan(String value) {
			addCriterion("other_inventors >", value, "otherInventors");
			return (Criteria) this;
		}

		public Criteria andOtherInventorsGreaterThanOrEqualTo(String value) {
			addCriterion("other_inventors >=", value, "otherInventors");
			return (Criteria) this;
		}

		public Criteria andOtherInventorsLessThan(String value) {
			addCriterion("other_inventors <", value, "otherInventors");
			return (Criteria) this;
		}

		public Criteria andOtherInventorsLessThanOrEqualTo(String value) {
			addCriterion("other_inventors <=", value, "otherInventors");
			return (Criteria) this;
		}

		public Criteria andOtherInventorsLike(String value) {
			addCriterion("other_inventors like", value, "otherInventors");
			return (Criteria) this;
		}

		public Criteria andOtherInventorsNotLike(String value) {
			addCriterion("other_inventors not like", value, "otherInventors");
			return (Criteria) this;
		}

		public Criteria andOtherInventorsIn(List<String> values) {
			addCriterion("other_inventors in", values, "otherInventors");
			return (Criteria) this;
		}

		public Criteria andOtherInventorsNotIn(List<String> values) {
			addCriterion("other_inventors not in", values, "otherInventors");
			return (Criteria) this;
		}

		public Criteria andOtherInventorsBetween(String value1, String value2) {
			addCriterion("other_inventors between", value1, value2, "otherInventors");
			return (Criteria) this;
		}

		public Criteria andOtherInventorsNotBetween(String value1, String value2) {
			addCriterion("other_inventors not between", value1, value2, "otherInventors");
			return (Criteria) this;
		}

		public Criteria andFirstInventoCompanyIsNull() {
			addCriterion("first_invento_company is null");
			return (Criteria) this;
		}

		public Criteria andFirstInventoCompanyIsNotNull() {
			addCriterion("first_invento_company is not null");
			return (Criteria) this;
		}

		public Criteria andFirstInventoCompanyEqualTo(String value) {
			addCriterion("first_invento_company =", value, "firstInventoCompany");
			return (Criteria) this;
		}

		public Criteria andFirstInventoCompanyNotEqualTo(String value) {
			addCriterion("first_invento_company <>", value, "firstInventoCompany");
			return (Criteria) this;
		}

		public Criteria andFirstInventoCompanyGreaterThan(String value) {
			addCriterion("first_invento_company >", value, "firstInventoCompany");
			return (Criteria) this;
		}

		public Criteria andFirstInventoCompanyGreaterThanOrEqualTo(String value) {
			addCriterion("first_invento_company >=", value, "firstInventoCompany");
			return (Criteria) this;
		}

		public Criteria andFirstInventoCompanyLessThan(String value) {
			addCriterion("first_invento_company <", value, "firstInventoCompany");
			return (Criteria) this;
		}

		public Criteria andFirstInventoCompanyLessThanOrEqualTo(String value) {
			addCriterion("first_invento_company <=", value, "firstInventoCompany");
			return (Criteria) this;
		}

		public Criteria andFirstInventoCompanyLike(String value) {
			addCriterion("first_invento_company like", value, "firstInventoCompany");
			return (Criteria) this;
		}

		public Criteria andFirstInventoCompanyNotLike(String value) {
			addCriterion("first_invento_company not like", value, "firstInventoCompany");
			return (Criteria) this;
		}

		public Criteria andFirstInventoCompanyIn(List<String> values) {
			addCriterion("first_invento_company in", values, "firstInventoCompany");
			return (Criteria) this;
		}

		public Criteria andFirstInventoCompanyNotIn(List<String> values) {
			addCriterion("first_invento_company not in", values, "firstInventoCompany");
			return (Criteria) this;
		}

		public Criteria andFirstInventoCompanyBetween(String value1, String value2) {
			addCriterion("first_invento_company between", value1, value2, "firstInventoCompany");
			return (Criteria) this;
		}

		public Criteria andFirstInventoCompanyNotBetween(String value1, String value2) {
			addCriterion("first_invento_company not between", value1, value2, "firstInventoCompany");
			return (Criteria) this;
		}

		public Criteria andPatentNameIsNull() {
			addCriterion("patent_name is null");
			return (Criteria) this;
		}

		public Criteria andPatentNameIsNotNull() {
			addCriterion("patent_name is not null");
			return (Criteria) this;
		}

		public Criteria andPatentNameEqualTo(String value) {
			addCriterion("patent_name =", value, "patentName");
			return (Criteria) this;
		}

		public Criteria andPatentNameNotEqualTo(String value) {
			addCriterion("patent_name <>", value, "patentName");
			return (Criteria) this;
		}

		public Criteria andPatentNameGreaterThan(String value) {
			addCriterion("patent_name >", value, "patentName");
			return (Criteria) this;
		}

		public Criteria andPatentNameGreaterThanOrEqualTo(String value) {
			addCriterion("patent_name >=", value, "patentName");
			return (Criteria) this;
		}

		public Criteria andPatentNameLessThan(String value) {
			addCriterion("patent_name <", value, "patentName");
			return (Criteria) this;
		}

		public Criteria andPatentNameLessThanOrEqualTo(String value) {
			addCriterion("patent_name <=", value, "patentName");
			return (Criteria) this;
		}

		public Criteria andPatentNameLike(String value) {
			addCriterion("patent_name like", value, "patentName");
			return (Criteria) this;
		}

		public Criteria andPatentNameNotLike(String value) {
			addCriterion("patent_name not like", value, "patentName");
			return (Criteria) this;
		}

		public Criteria andPatentNameIn(List<String> values) {
			addCriterion("patent_name in", values, "patentName");
			return (Criteria) this;
		}

		public Criteria andPatentNameNotIn(List<String> values) {
			addCriterion("patent_name not in", values, "patentName");
			return (Criteria) this;
		}

		public Criteria andPatentNameBetween(String value1, String value2) {
			addCriterion("patent_name between", value1, value2, "patentName");
			return (Criteria) this;
		}

		public Criteria andPatentNameNotBetween(String value1, String value2) {
			addCriterion("patent_name not between", value1, value2, "patentName");
			return (Criteria) this;
		}

		public Criteria andPatenteeIsNull() {
			addCriterion("patentee is null");
			return (Criteria) this;
		}

		public Criteria andPatenteeIsNotNull() {
			addCriterion("patentee is not null");
			return (Criteria) this;
		}

		public Criteria andPatenteeEqualTo(String value) {
			addCriterion("patentee =", value, "patentee");
			return (Criteria) this;
		}

		public Criteria andPatenteeNotEqualTo(String value) {
			addCriterion("patentee <>", value, "patentee");
			return (Criteria) this;
		}

		public Criteria andPatenteeGreaterThan(String value) {
			addCriterion("patentee >", value, "patentee");
			return (Criteria) this;
		}

		public Criteria andPatenteeGreaterThanOrEqualTo(String value) {
			addCriterion("patentee >=", value, "patentee");
			return (Criteria) this;
		}

		public Criteria andPatenteeLessThan(String value) {
			addCriterion("patentee <", value, "patentee");
			return (Criteria) this;
		}

		public Criteria andPatenteeLessThanOrEqualTo(String value) {
			addCriterion("patentee <=", value, "patentee");
			return (Criteria) this;
		}

		public Criteria andPatenteeLike(String value) {
			addCriterion("patentee like", value, "patentee");
			return (Criteria) this;
		}

		public Criteria andPatenteeNotLike(String value) {
			addCriterion("patentee not like", value, "patentee");
			return (Criteria) this;
		}

		public Criteria andPatenteeIn(List<String> values) {
			addCriterion("patentee in", values, "patentee");
			return (Criteria) this;
		}

		public Criteria andPatenteeNotIn(List<String> values) {
			addCriterion("patentee not in", values, "patentee");
			return (Criteria) this;
		}

		public Criteria andPatenteeBetween(String value1, String value2) {
			addCriterion("patentee between", value1, value2, "patentee");
			return (Criteria) this;
		}

		public Criteria andPatenteeNotBetween(String value1, String value2) {
			addCriterion("patentee not between", value1, value2, "patentee");
			return (Criteria) this;
		}

		public Criteria andPatentApplicationDateIsNull() {
			addCriterion("patent_application_date is null");
			return (Criteria) this;
		}

		public Criteria andPatentApplicationDateIsNotNull() {
			addCriterion("patent_application_date is not null");
			return (Criteria) this;
		}

		public Criteria andPatentApplicationDateEqualTo(String value) {
			addCriterion("patent_application_date =", value, "patentApplicationDate");
			return (Criteria) this;
		}

		public Criteria andPatentApplicationDateNotEqualTo(String value) {
			addCriterion("patent_application_date <>", value, "patentApplicationDate");
			return (Criteria) this;
		}

		public Criteria andPatentApplicationDateGreaterThan(String value) {
			addCriterion("patent_application_date >", value, "patentApplicationDate");
			return (Criteria) this;
		}

		public Criteria andPatentApplicationDateGreaterThanOrEqualTo(String value) {
			addCriterion("patent_application_date >=", value, "patentApplicationDate");
			return (Criteria) this;
		}

		public Criteria andPatentApplicationDateLessThan(String value) {
			addCriterion("patent_application_date <", value, "patentApplicationDate");
			return (Criteria) this;
		}

		public Criteria andPatentApplicationDateLessThanOrEqualTo(String value) {
			addCriterion("patent_application_date <=", value, "patentApplicationDate");
			return (Criteria) this;
		}

		public Criteria andPatentApplicationDateLike(String value) {
			addCriterion("patent_application_date like", value, "patentApplicationDate");
			return (Criteria) this;
		}

		public Criteria andPatentApplicationDateNotLike(String value) {
			addCriterion("patent_application_date not like", value, "patentApplicationDate");
			return (Criteria) this;
		}

		public Criteria andPatentApplicationDateIn(List<String> values) {
			addCriterion("patent_application_date in", values, "patentApplicationDate");
			return (Criteria) this;
		}

		public Criteria andPatentApplicationDateNotIn(List<String> values) {
			addCriterion("patent_application_date not in", values, "patentApplicationDate");
			return (Criteria) this;
		}

		public Criteria andPatentApplicationDateBetween(String value1, String value2) {
			addCriterion("patent_application_date between", value1, value2, "patentApplicationDate");
			return (Criteria) this;
		}

		public Criteria andPatentApplicationDateNotBetween(String value1, String value2) {
			addCriterion("patent_application_date not between", value1, value2, "patentApplicationDate");
			return (Criteria) this;
		}

		public Criteria andAuthorizedAnnouncementDateIsNull() {
			addCriterion("authorized_announcement_date is null");
			return (Criteria) this;
		}

		public Criteria andAuthorizedAnnouncementDateIsNotNull() {
			addCriterion("authorized_announcement_date is not null");
			return (Criteria) this;
		}

		public Criteria andAuthorizedAnnouncementDateEqualTo(String value) {
			addCriterion("authorized_announcement_date =", value, "authorizedAnnouncementDate");
			return (Criteria) this;
		}

		public Criteria andAuthorizedAnnouncementDateNotEqualTo(String value) {
			addCriterion("authorized_announcement_date <>", value, "authorizedAnnouncementDate");
			return (Criteria) this;
		}

		public Criteria andAuthorizedAnnouncementDateGreaterThan(String value) {
			addCriterion("authorized_announcement_date >", value, "authorizedAnnouncementDate");
			return (Criteria) this;
		}

		public Criteria andAuthorizedAnnouncementDateGreaterThanOrEqualTo(String value) {
			addCriterion("authorized_announcement_date >=", value, "authorizedAnnouncementDate");
			return (Criteria) this;
		}

		public Criteria andAuthorizedAnnouncementDateLessThan(String value) {
			addCriterion("authorized_announcement_date <", value, "authorizedAnnouncementDate");
			return (Criteria) this;
		}

		public Criteria andAuthorizedAnnouncementDateLessThanOrEqualTo(String value) {
			addCriterion("authorized_announcement_date <=", value, "authorizedAnnouncementDate");
			return (Criteria) this;
		}

		public Criteria andAuthorizedAnnouncementDateLike(String value) {
			addCriterion("authorized_announcement_date like", value, "authorizedAnnouncementDate");
			return (Criteria) this;
		}

		public Criteria andAuthorizedAnnouncementDateNotLike(String value) {
			addCriterion("authorized_announcement_date not like", value, "authorizedAnnouncementDate");
			return (Criteria) this;
		}

		public Criteria andAuthorizedAnnouncementDateIn(List<String> values) {
			addCriterion("authorized_announcement_date in", values, "authorizedAnnouncementDate");
			return (Criteria) this;
		}

		public Criteria andAuthorizedAnnouncementDateNotIn(List<String> values) {
			addCriterion("authorized_announcement_date not in", values, "authorizedAnnouncementDate");
			return (Criteria) this;
		}

		public Criteria andAuthorizedAnnouncementDateBetween(String value1, String value2) {
			addCriterion("authorized_announcement_date between", value1, value2, "authorizedAnnouncementDate");
			return (Criteria) this;
		}

		public Criteria andAuthorizedAnnouncementDateNotBetween(String value1, String value2) {
			addCriterion("authorized_announcement_date not between", value1, value2, "authorizedAnnouncementDate");
			return (Criteria) this;
		}

		public Criteria andPatentCategoryIsNull() {
			addCriterion("patent_category is null");
			return (Criteria) this;
		}

		public Criteria andPatentCategoryIsNotNull() {
			addCriterion("patent_category is not null");
			return (Criteria) this;
		}

		public Criteria andPatentCategoryEqualTo(String value) {
			addCriterion("patent_category =", value, "patentCategory");
			return (Criteria) this;
		}

		public Criteria andPatentCategoryNotEqualTo(String value) {
			addCriterion("patent_category <>", value, "patentCategory");
			return (Criteria) this;
		}

		public Criteria andPatentCategoryGreaterThan(String value) {
			addCriterion("patent_category >", value, "patentCategory");
			return (Criteria) this;
		}

		public Criteria andPatentCategoryGreaterThanOrEqualTo(String value) {
			addCriterion("patent_category >=", value, "patentCategory");
			return (Criteria) this;
		}

		public Criteria andPatentCategoryLessThan(String value) {
			addCriterion("patent_category <", value, "patentCategory");
			return (Criteria) this;
		}

		public Criteria andPatentCategoryLessThanOrEqualTo(String value) {
			addCriterion("patent_category <=", value, "patentCategory");
			return (Criteria) this;
		}

		public Criteria andPatentCategoryLike(String value) {
			addCriterion("patent_category like", value, "patentCategory");
			return (Criteria) this;
		}

		public Criteria andPatentCategoryNotLike(String value) {
			addCriterion("patent_category not like", value, "patentCategory");
			return (Criteria) this;
		}

		public Criteria andPatentCategoryIn(List<String> values) {
			addCriterion("patent_category in", values, "patentCategory");
			return (Criteria) this;
		}

		public Criteria andPatentCategoryNotIn(List<String> values) {
			addCriterion("patent_category not in", values, "patentCategory");
			return (Criteria) this;
		}

		public Criteria andPatentCategoryBetween(String value1, String value2) {
			addCriterion("patent_category between", value1, value2, "patentCategory");
			return (Criteria) this;
		}

		public Criteria andPatentCategoryNotBetween(String value1, String value2) {
			addCriterion("patent_category not between", value1, value2, "patentCategory");
			return (Criteria) this;
		}

		public Criteria andCertificateNumIsNull() {
			addCriterion("certificate_num is null");
			return (Criteria) this;
		}

		public Criteria andCertificateNumIsNotNull() {
			addCriterion("certificate_num is not null");
			return (Criteria) this;
		}

		public Criteria andCertificateNumEqualTo(String value) {
			addCriterion("certificate_num =", value, "certificateNum");
			return (Criteria) this;
		}

		public Criteria andCertificateNumNotEqualTo(String value) {
			addCriterion("certificate_num <>", value, "certificateNum");
			return (Criteria) this;
		}

		public Criteria andCertificateNumGreaterThan(String value) {
			addCriterion("certificate_num >", value, "certificateNum");
			return (Criteria) this;
		}

		public Criteria andCertificateNumGreaterThanOrEqualTo(String value) {
			addCriterion("certificate_num >=", value, "certificateNum");
			return (Criteria) this;
		}

		public Criteria andCertificateNumLessThan(String value) {
			addCriterion("certificate_num <", value, "certificateNum");
			return (Criteria) this;
		}

		public Criteria andCertificateNumLessThanOrEqualTo(String value) {
			addCriterion("certificate_num <=", value, "certificateNum");
			return (Criteria) this;
		}

		public Criteria andCertificateNumLike(String value) {
			addCriterion("certificate_num like", value, "certificateNum");
			return (Criteria) this;
		}

		public Criteria andCertificateNumNotLike(String value) {
			addCriterion("certificate_num not like", value, "certificateNum");
			return (Criteria) this;
		}

		public Criteria andCertificateNumIn(List<String> values) {
			addCriterion("certificate_num in", values, "certificateNum");
			return (Criteria) this;
		}

		public Criteria andCertificateNumNotIn(List<String> values) {
			addCriterion("certificate_num not in", values, "certificateNum");
			return (Criteria) this;
		}

		public Criteria andCertificateNumBetween(String value1, String value2) {
			addCriterion("certificate_num between", value1, value2, "certificateNum");
			return (Criteria) this;
		}

		public Criteria andCertificateNumNotBetween(String value1, String value2) {
			addCriterion("certificate_num not between", value1, value2, "certificateNum");
			return (Criteria) this;
		}

		public Criteria andPatentNumIsNull() {
			addCriterion("patent_num is null");
			return (Criteria) this;
		}

		public Criteria andPatentNumIsNotNull() {
			addCriterion("patent_num is not null");
			return (Criteria) this;
		}

		public Criteria andPatentNumEqualTo(String value) {
			addCriterion("patent_num =", value, "patentNum");
			return (Criteria) this;
		}

		public Criteria andPatentNumNotEqualTo(String value) {
			addCriterion("patent_num <>", value, "patentNum");
			return (Criteria) this;
		}

		public Criteria andPatentNumGreaterThan(String value) {
			addCriterion("patent_num >", value, "patentNum");
			return (Criteria) this;
		}

		public Criteria andPatentNumGreaterThanOrEqualTo(String value) {
			addCriterion("patent_num >=", value, "patentNum");
			return (Criteria) this;
		}

		public Criteria andPatentNumLessThan(String value) {
			addCriterion("patent_num <", value, "patentNum");
			return (Criteria) this;
		}

		public Criteria andPatentNumLessThanOrEqualTo(String value) {
			addCriterion("patent_num <=", value, "patentNum");
			return (Criteria) this;
		}

		public Criteria andPatentNumLike(String value) {
			addCriterion("patent_num like", value, "patentNum");
			return (Criteria) this;
		}

		public Criteria andPatentNumNotLike(String value) {
			addCriterion("patent_num not like", value, "patentNum");
			return (Criteria) this;
		}

		public Criteria andPatentNumIn(List<String> values) {
			addCriterion("patent_num in", values, "patentNum");
			return (Criteria) this;
		}

		public Criteria andPatentNumNotIn(List<String> values) {
			addCriterion("patent_num not in", values, "patentNum");
			return (Criteria) this;
		}

		public Criteria andPatentNumBetween(String value1, String value2) {
			addCriterion("patent_num between", value1, value2, "patentNum");
			return (Criteria) this;
		}

		public Criteria andPatentNumNotBetween(String value1, String value2) {
			addCriterion("patent_num not between", value1, value2, "patentNum");
			return (Criteria) this;
		}

		public Criteria andPatentAgencyNameIsNull() {
			addCriterion("patent_agency_name is null");
			return (Criteria) this;
		}

		public Criteria andPatentAgencyNameIsNotNull() {
			addCriterion("patent_agency_name is not null");
			return (Criteria) this;
		}

		public Criteria andPatentAgencyNameEqualTo(String value) {
			addCriterion("patent_agency_name =", value, "patentAgencyName");
			return (Criteria) this;
		}

		public Criteria andPatentAgencyNameNotEqualTo(String value) {
			addCriterion("patent_agency_name <>", value, "patentAgencyName");
			return (Criteria) this;
		}

		public Criteria andPatentAgencyNameGreaterThan(String value) {
			addCriterion("patent_agency_name >", value, "patentAgencyName");
			return (Criteria) this;
		}

		public Criteria andPatentAgencyNameGreaterThanOrEqualTo(String value) {
			addCriterion("patent_agency_name >=", value, "patentAgencyName");
			return (Criteria) this;
		}

		public Criteria andPatentAgencyNameLessThan(String value) {
			addCriterion("patent_agency_name <", value, "patentAgencyName");
			return (Criteria) this;
		}

		public Criteria andPatentAgencyNameLessThanOrEqualTo(String value) {
			addCriterion("patent_agency_name <=", value, "patentAgencyName");
			return (Criteria) this;
		}

		public Criteria andPatentAgencyNameLike(String value) {
			addCriterion("patent_agency_name like", value, "patentAgencyName");
			return (Criteria) this;
		}

		public Criteria andPatentAgencyNameNotLike(String value) {
			addCriterion("patent_agency_name not like", value, "patentAgencyName");
			return (Criteria) this;
		}

		public Criteria andPatentAgencyNameIn(List<String> values) {
			addCriterion("patent_agency_name in", values, "patentAgencyName");
			return (Criteria) this;
		}

		public Criteria andPatentAgencyNameNotIn(List<String> values) {
			addCriterion("patent_agency_name not in", values, "patentAgencyName");
			return (Criteria) this;
		}

		public Criteria andPatentAgencyNameBetween(String value1, String value2) {
			addCriterion("patent_agency_name between", value1, value2, "patentAgencyName");
			return (Criteria) this;
		}

		public Criteria andPatentAgencyNameNotBetween(String value1, String value2) {
			addCriterion("patent_agency_name not between", value1, value2, "patentAgencyName");
			return (Criteria) this;
		}

		public Criteria andRegistTimeIsNull() {
			addCriterion("regist_time is null");
			return (Criteria) this;
		}

		public Criteria andRegistTimeIsNotNull() {
			addCriterion("regist_time is not null");
			return (Criteria) this;
		}

		public Criteria andRegistTimeEqualTo(String value) {
			addCriterion("regist_time =", value, "registTime");
			return (Criteria) this;
		}

		public Criteria andRegistTimeNotEqualTo(String value) {
			addCriterion("regist_time <>", value, "registTime");
			return (Criteria) this;
		}

		public Criteria andRegistTimeGreaterThan(String value) {
			addCriterion("regist_time >", value, "registTime");
			return (Criteria) this;
		}

		public Criteria andRegistTimeGreaterThanOrEqualTo(String value) {
			addCriterion("regist_time >=", value, "registTime");
			return (Criteria) this;
		}

		public Criteria andRegistTimeLessThan(String value) {
			addCriterion("regist_time <", value, "registTime");
			return (Criteria) this;
		}

		public Criteria andRegistTimeLessThanOrEqualTo(String value) {
			addCriterion("regist_time <=", value, "registTime");
			return (Criteria) this;
		}

		public Criteria andRegistTimeLike(String value) {
			addCriterion("regist_time like", value, "registTime");
			return (Criteria) this;
		}

		public Criteria andRegistTimeNotLike(String value) {
			addCriterion("regist_time not like", value, "registTime");
			return (Criteria) this;
		}

		public Criteria andRegistTimeIn(List<String> values) {
			addCriterion("regist_time in", values, "registTime");
			return (Criteria) this;
		}

		public Criteria andRegistTimeNotIn(List<String> values) {
			addCriterion("regist_time not in", values, "registTime");
			return (Criteria) this;
		}

		public Criteria andRegistTimeBetween(String value1, String value2) {
			addCriterion("regist_time between", value1, value2, "registTime");
			return (Criteria) this;
		}

		public Criteria andRegistTimeNotBetween(String value1, String value2) {
			addCriterion("regist_time not between", value1, value2, "registTime");
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