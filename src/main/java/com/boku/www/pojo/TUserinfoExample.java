package com.boku.www.pojo;

import java.util.ArrayList;
import java.util.List;

public class TUserinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TUserinfoExample() {
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

        public Criteria andUserinfoIdIsNull() {
            addCriterion("userInfo_id is null");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdIsNotNull() {
            addCriterion("userInfo_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdEqualTo(String value) {
            addCriterion("userInfo_id =", value, "userinfoId");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdNotEqualTo(String value) {
            addCriterion("userInfo_id <>", value, "userinfoId");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdGreaterThan(String value) {
            addCriterion("userInfo_id >", value, "userinfoId");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdGreaterThanOrEqualTo(String value) {
            addCriterion("userInfo_id >=", value, "userinfoId");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdLessThan(String value) {
            addCriterion("userInfo_id <", value, "userinfoId");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdLessThanOrEqualTo(String value) {
            addCriterion("userInfo_id <=", value, "userinfoId");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdLike(String value) {
            addCriterion("userInfo_id like", value, "userinfoId");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdNotLike(String value) {
            addCriterion("userInfo_id not like", value, "userinfoId");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdIn(List<String> values) {
            addCriterion("userInfo_id in", values, "userinfoId");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdNotIn(List<String> values) {
            addCriterion("userInfo_id not in", values, "userinfoId");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdBetween(String value1, String value2) {
            addCriterion("userInfo_id between", value1, value2, "userinfoId");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdNotBetween(String value1, String value2) {
            addCriterion("userInfo_id not between", value1, value2, "userinfoId");
            return (Criteria) this;
        }

        public Criteria andUserinfoPicIsNull() {
            addCriterion("userInfo_pic is null");
            return (Criteria) this;
        }

        public Criteria andUserinfoPicIsNotNull() {
            addCriterion("userInfo_pic is not null");
            return (Criteria) this;
        }

        public Criteria andUserinfoPicEqualTo(String value) {
            addCriterion("userInfo_pic =", value, "userinfoPic");
            return (Criteria) this;
        }

        public Criteria andUserinfoPicNotEqualTo(String value) {
            addCriterion("userInfo_pic <>", value, "userinfoPic");
            return (Criteria) this;
        }

        public Criteria andUserinfoPicGreaterThan(String value) {
            addCriterion("userInfo_pic >", value, "userinfoPic");
            return (Criteria) this;
        }

        public Criteria andUserinfoPicGreaterThanOrEqualTo(String value) {
            addCriterion("userInfo_pic >=", value, "userinfoPic");
            return (Criteria) this;
        }

        public Criteria andUserinfoPicLessThan(String value) {
            addCriterion("userInfo_pic <", value, "userinfoPic");
            return (Criteria) this;
        }

        public Criteria andUserinfoPicLessThanOrEqualTo(String value) {
            addCriterion("userInfo_pic <=", value, "userinfoPic");
            return (Criteria) this;
        }

        public Criteria andUserinfoPicLike(String value) {
            addCriterion("userInfo_pic like", value, "userinfoPic");
            return (Criteria) this;
        }

        public Criteria andUserinfoPicNotLike(String value) {
            addCriterion("userInfo_pic not like", value, "userinfoPic");
            return (Criteria) this;
        }

        public Criteria andUserinfoPicIn(List<String> values) {
            addCriterion("userInfo_pic in", values, "userinfoPic");
            return (Criteria) this;
        }

        public Criteria andUserinfoPicNotIn(List<String> values) {
            addCriterion("userInfo_pic not in", values, "userinfoPic");
            return (Criteria) this;
        }

        public Criteria andUserinfoPicBetween(String value1, String value2) {
            addCriterion("userInfo_pic between", value1, value2, "userinfoPic");
            return (Criteria) this;
        }

        public Criteria andUserinfoPicNotBetween(String value1, String value2) {
            addCriterion("userInfo_pic not between", value1, value2, "userinfoPic");
            return (Criteria) this;
        }

        public Criteria andUserinfoCompanyIsNull() {
            addCriterion("userInfo_company is null");
            return (Criteria) this;
        }

        public Criteria andUserinfoCompanyIsNotNull() {
            addCriterion("userInfo_company is not null");
            return (Criteria) this;
        }

        public Criteria andUserinfoCompanyEqualTo(String value) {
            addCriterion("userInfo_company =", value, "userinfoCompany");
            return (Criteria) this;
        }

        public Criteria andUserinfoCompanyNotEqualTo(String value) {
            addCriterion("userInfo_company <>", value, "userinfoCompany");
            return (Criteria) this;
        }

        public Criteria andUserinfoCompanyGreaterThan(String value) {
            addCriterion("userInfo_company >", value, "userinfoCompany");
            return (Criteria) this;
        }

        public Criteria andUserinfoCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("userInfo_company >=", value, "userinfoCompany");
            return (Criteria) this;
        }

        public Criteria andUserinfoCompanyLessThan(String value) {
            addCriterion("userInfo_company <", value, "userinfoCompany");
            return (Criteria) this;
        }

        public Criteria andUserinfoCompanyLessThanOrEqualTo(String value) {
            addCriterion("userInfo_company <=", value, "userinfoCompany");
            return (Criteria) this;
        }

        public Criteria andUserinfoCompanyLike(String value) {
            addCriterion("userInfo_company like", value, "userinfoCompany");
            return (Criteria) this;
        }

        public Criteria andUserinfoCompanyNotLike(String value) {
            addCriterion("userInfo_company not like", value, "userinfoCompany");
            return (Criteria) this;
        }

        public Criteria andUserinfoCompanyIn(List<String> values) {
            addCriterion("userInfo_company in", values, "userinfoCompany");
            return (Criteria) this;
        }

        public Criteria andUserinfoCompanyNotIn(List<String> values) {
            addCriterion("userInfo_company not in", values, "userinfoCompany");
            return (Criteria) this;
        }

        public Criteria andUserinfoCompanyBetween(String value1, String value2) {
            addCriterion("userInfo_company between", value1, value2, "userinfoCompany");
            return (Criteria) this;
        }

        public Criteria andUserinfoCompanyNotBetween(String value1, String value2) {
            addCriterion("userInfo_company not between", value1, value2, "userinfoCompany");
            return (Criteria) this;
        }

        public Criteria andUserinfoPositionNameIsNull() {
            addCriterion("userInfo_position_name is null");
            return (Criteria) this;
        }

        public Criteria andUserinfoPositionNameIsNotNull() {
            addCriterion("userInfo_position_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserinfoPositionNameEqualTo(String value) {
            addCriterion("userInfo_position_name =", value, "userinfoPositionName");
            return (Criteria) this;
        }

        public Criteria andUserinfoPositionNameNotEqualTo(String value) {
            addCriterion("userInfo_position_name <>", value, "userinfoPositionName");
            return (Criteria) this;
        }

        public Criteria andUserinfoPositionNameGreaterThan(String value) {
            addCriterion("userInfo_position_name >", value, "userinfoPositionName");
            return (Criteria) this;
        }

        public Criteria andUserinfoPositionNameGreaterThanOrEqualTo(String value) {
            addCriterion("userInfo_position_name >=", value, "userinfoPositionName");
            return (Criteria) this;
        }

        public Criteria andUserinfoPositionNameLessThan(String value) {
            addCriterion("userInfo_position_name <", value, "userinfoPositionName");
            return (Criteria) this;
        }

        public Criteria andUserinfoPositionNameLessThanOrEqualTo(String value) {
            addCriterion("userInfo_position_name <=", value, "userinfoPositionName");
            return (Criteria) this;
        }

        public Criteria andUserinfoPositionNameLike(String value) {
            addCriterion("userInfo_position_name like", value, "userinfoPositionName");
            return (Criteria) this;
        }

        public Criteria andUserinfoPositionNameNotLike(String value) {
            addCriterion("userInfo_position_name not like", value, "userinfoPositionName");
            return (Criteria) this;
        }

        public Criteria andUserinfoPositionNameIn(List<String> values) {
            addCriterion("userInfo_position_name in", values, "userinfoPositionName");
            return (Criteria) this;
        }

        public Criteria andUserinfoPositionNameNotIn(List<String> values) {
            addCriterion("userInfo_position_name not in", values, "userinfoPositionName");
            return (Criteria) this;
        }

        public Criteria andUserinfoPositionNameBetween(String value1, String value2) {
            addCriterion("userInfo_position_name between", value1, value2, "userinfoPositionName");
            return (Criteria) this;
        }

        public Criteria andUserinfoPositionNameNotBetween(String value1, String value2) {
            addCriterion("userInfo_position_name not between", value1, value2, "userinfoPositionName");
            return (Criteria) this;
        }

        public Criteria andUserinfoDepartmentIsNull() {
            addCriterion("userInfo_department is null");
            return (Criteria) this;
        }

        public Criteria andUserinfoDepartmentIsNotNull() {
            addCriterion("userInfo_department is not null");
            return (Criteria) this;
        }

        public Criteria andUserinfoDepartmentEqualTo(String value) {
            addCriterion("userInfo_department =", value, "userinfoDepartment");
            return (Criteria) this;
        }

        public Criteria andUserinfoDepartmentNotEqualTo(String value) {
            addCriterion("userInfo_department <>", value, "userinfoDepartment");
            return (Criteria) this;
        }

        public Criteria andUserinfoDepartmentGreaterThan(String value) {
            addCriterion("userInfo_department >", value, "userinfoDepartment");
            return (Criteria) this;
        }

        public Criteria andUserinfoDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("userInfo_department >=", value, "userinfoDepartment");
            return (Criteria) this;
        }

        public Criteria andUserinfoDepartmentLessThan(String value) {
            addCriterion("userInfo_department <", value, "userinfoDepartment");
            return (Criteria) this;
        }

        public Criteria andUserinfoDepartmentLessThanOrEqualTo(String value) {
            addCriterion("userInfo_department <=", value, "userinfoDepartment");
            return (Criteria) this;
        }

        public Criteria andUserinfoDepartmentLike(String value) {
            addCriterion("userInfo_department like", value, "userinfoDepartment");
            return (Criteria) this;
        }

        public Criteria andUserinfoDepartmentNotLike(String value) {
            addCriterion("userInfo_department not like", value, "userinfoDepartment");
            return (Criteria) this;
        }

        public Criteria andUserinfoDepartmentIn(List<String> values) {
            addCriterion("userInfo_department in", values, "userinfoDepartment");
            return (Criteria) this;
        }

        public Criteria andUserinfoDepartmentNotIn(List<String> values) {
            addCriterion("userInfo_department not in", values, "userinfoDepartment");
            return (Criteria) this;
        }

        public Criteria andUserinfoDepartmentBetween(String value1, String value2) {
            addCriterion("userInfo_department between", value1, value2, "userinfoDepartment");
            return (Criteria) this;
        }

        public Criteria andUserinfoDepartmentNotBetween(String value1, String value2) {
            addCriterion("userInfo_department not between", value1, value2, "userinfoDepartment");
            return (Criteria) this;
        }

        public Criteria andUserinfoIsStaffDoctorIsNull() {
            addCriterion("userInfo_is_staff_doctor is null");
            return (Criteria) this;
        }

        public Criteria andUserinfoIsStaffDoctorIsNotNull() {
            addCriterion("userInfo_is_staff_doctor is not null");
            return (Criteria) this;
        }

        public Criteria andUserinfoIsStaffDoctorEqualTo(String value) {
            addCriterion("userInfo_is_staff_doctor =", value, "userinfoIsStaffDoctor");
            return (Criteria) this;
        }

        public Criteria andUserinfoIsStaffDoctorNotEqualTo(String value) {
            addCriterion("userInfo_is_staff_doctor <>", value, "userinfoIsStaffDoctor");
            return (Criteria) this;
        }

        public Criteria andUserinfoIsStaffDoctorGreaterThan(String value) {
            addCriterion("userInfo_is_staff_doctor >", value, "userinfoIsStaffDoctor");
            return (Criteria) this;
        }

        public Criteria andUserinfoIsStaffDoctorGreaterThanOrEqualTo(String value) {
            addCriterion("userInfo_is_staff_doctor >=", value, "userinfoIsStaffDoctor");
            return (Criteria) this;
        }

        public Criteria andUserinfoIsStaffDoctorLessThan(String value) {
            addCriterion("userInfo_is_staff_doctor <", value, "userinfoIsStaffDoctor");
            return (Criteria) this;
        }

        public Criteria andUserinfoIsStaffDoctorLessThanOrEqualTo(String value) {
            addCriterion("userInfo_is_staff_doctor <=", value, "userinfoIsStaffDoctor");
            return (Criteria) this;
        }

        public Criteria andUserinfoIsStaffDoctorLike(String value) {
            addCriterion("userInfo_is_staff_doctor like", value, "userinfoIsStaffDoctor");
            return (Criteria) this;
        }

        public Criteria andUserinfoIsStaffDoctorNotLike(String value) {
            addCriterion("userInfo_is_staff_doctor not like", value, "userinfoIsStaffDoctor");
            return (Criteria) this;
        }

        public Criteria andUserinfoIsStaffDoctorIn(List<String> values) {
            addCriterion("userInfo_is_staff_doctor in", values, "userinfoIsStaffDoctor");
            return (Criteria) this;
        }

        public Criteria andUserinfoIsStaffDoctorNotIn(List<String> values) {
            addCriterion("userInfo_is_staff_doctor not in", values, "userinfoIsStaffDoctor");
            return (Criteria) this;
        }

        public Criteria andUserinfoIsStaffDoctorBetween(String value1, String value2) {
            addCriterion("userInfo_is_staff_doctor between", value1, value2, "userinfoIsStaffDoctor");
            return (Criteria) this;
        }

        public Criteria andUserinfoIsStaffDoctorNotBetween(String value1, String value2) {
            addCriterion("userInfo_is_staff_doctor not between", value1, value2, "userinfoIsStaffDoctor");
            return (Criteria) this;
        }

        public Criteria andUserinfoSubjectIsNull() {
            addCriterion("userInfo_subject is null");
            return (Criteria) this;
        }

        public Criteria andUserinfoSubjectIsNotNull() {
            addCriterion("userInfo_subject is not null");
            return (Criteria) this;
        }

        public Criteria andUserinfoSubjectEqualTo(String value) {
            addCriterion("userInfo_subject =", value, "userinfoSubject");
            return (Criteria) this;
        }

        public Criteria andUserinfoSubjectNotEqualTo(String value) {
            addCriterion("userInfo_subject <>", value, "userinfoSubject");
            return (Criteria) this;
        }

        public Criteria andUserinfoSubjectGreaterThan(String value) {
            addCriterion("userInfo_subject >", value, "userinfoSubject");
            return (Criteria) this;
        }

        public Criteria andUserinfoSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("userInfo_subject >=", value, "userinfoSubject");
            return (Criteria) this;
        }

        public Criteria andUserinfoSubjectLessThan(String value) {
            addCriterion("userInfo_subject <", value, "userinfoSubject");
            return (Criteria) this;
        }

        public Criteria andUserinfoSubjectLessThanOrEqualTo(String value) {
            addCriterion("userInfo_subject <=", value, "userinfoSubject");
            return (Criteria) this;
        }

        public Criteria andUserinfoSubjectLike(String value) {
            addCriterion("userInfo_subject like", value, "userinfoSubject");
            return (Criteria) this;
        }

        public Criteria andUserinfoSubjectNotLike(String value) {
            addCriterion("userInfo_subject not like", value, "userinfoSubject");
            return (Criteria) this;
        }

        public Criteria andUserinfoSubjectIn(List<String> values) {
            addCriterion("userInfo_subject in", values, "userinfoSubject");
            return (Criteria) this;
        }

        public Criteria andUserinfoSubjectNotIn(List<String> values) {
            addCriterion("userInfo_subject not in", values, "userinfoSubject");
            return (Criteria) this;
        }

        public Criteria andUserinfoSubjectBetween(String value1, String value2) {
            addCriterion("userInfo_subject between", value1, value2, "userinfoSubject");
            return (Criteria) this;
        }

        public Criteria andUserinfoSubjectNotBetween(String value1, String value2) {
            addCriterion("userInfo_subject not between", value1, value2, "userinfoSubject");
            return (Criteria) this;
        }

        public Criteria andUserinfoDoctorNumIsNull() {
            addCriterion("userInfo_doctor_num is null");
            return (Criteria) this;
        }

        public Criteria andUserinfoDoctorNumIsNotNull() {
            addCriterion("userInfo_doctor_num is not null");
            return (Criteria) this;
        }

        public Criteria andUserinfoDoctorNumEqualTo(String value) {
            addCriterion("userInfo_doctor_num =", value, "userinfoDoctorNum");
            return (Criteria) this;
        }

        public Criteria andUserinfoDoctorNumNotEqualTo(String value) {
            addCriterion("userInfo_doctor_num <>", value, "userinfoDoctorNum");
            return (Criteria) this;
        }

        public Criteria andUserinfoDoctorNumGreaterThan(String value) {
            addCriterion("userInfo_doctor_num >", value, "userinfoDoctorNum");
            return (Criteria) this;
        }

        public Criteria andUserinfoDoctorNumGreaterThanOrEqualTo(String value) {
            addCriterion("userInfo_doctor_num >=", value, "userinfoDoctorNum");
            return (Criteria) this;
        }

        public Criteria andUserinfoDoctorNumLessThan(String value) {
            addCriterion("userInfo_doctor_num <", value, "userinfoDoctorNum");
            return (Criteria) this;
        }

        public Criteria andUserinfoDoctorNumLessThanOrEqualTo(String value) {
            addCriterion("userInfo_doctor_num <=", value, "userinfoDoctorNum");
            return (Criteria) this;
        }

        public Criteria andUserinfoDoctorNumLike(String value) {
            addCriterion("userInfo_doctor_num like", value, "userinfoDoctorNum");
            return (Criteria) this;
        }

        public Criteria andUserinfoDoctorNumNotLike(String value) {
            addCriterion("userInfo_doctor_num not like", value, "userinfoDoctorNum");
            return (Criteria) this;
        }

        public Criteria andUserinfoDoctorNumIn(List<String> values) {
            addCriterion("userInfo_doctor_num in", values, "userinfoDoctorNum");
            return (Criteria) this;
        }

        public Criteria andUserinfoDoctorNumNotIn(List<String> values) {
            addCriterion("userInfo_doctor_num not in", values, "userinfoDoctorNum");
            return (Criteria) this;
        }

        public Criteria andUserinfoDoctorNumBetween(String value1, String value2) {
            addCriterion("userInfo_doctor_num between", value1, value2, "userinfoDoctorNum");
            return (Criteria) this;
        }

        public Criteria andUserinfoDoctorNumNotBetween(String value1, String value2) {
            addCriterion("userInfo_doctor_num not between", value1, value2, "userinfoDoctorNum");
            return (Criteria) this;
        }

        public Criteria andUserinfoJobidsIsNull() {
            addCriterion("userInfo_jobIds is null");
            return (Criteria) this;
        }

        public Criteria andUserinfoJobidsIsNotNull() {
            addCriterion("userInfo_jobIds is not null");
            return (Criteria) this;
        }

        public Criteria andUserinfoJobidsEqualTo(String value) {
            addCriterion("userInfo_jobIds =", value, "userinfoJobids");
            return (Criteria) this;
        }

        public Criteria andUserinfoJobidsNotEqualTo(String value) {
            addCriterion("userInfo_jobIds <>", value, "userinfoJobids");
            return (Criteria) this;
        }

        public Criteria andUserinfoJobidsGreaterThan(String value) {
            addCriterion("userInfo_jobIds >", value, "userinfoJobids");
            return (Criteria) this;
        }

        public Criteria andUserinfoJobidsGreaterThanOrEqualTo(String value) {
            addCriterion("userInfo_jobIds >=", value, "userinfoJobids");
            return (Criteria) this;
        }

        public Criteria andUserinfoJobidsLessThan(String value) {
            addCriterion("userInfo_jobIds <", value, "userinfoJobids");
            return (Criteria) this;
        }

        public Criteria andUserinfoJobidsLessThanOrEqualTo(String value) {
            addCriterion("userInfo_jobIds <=", value, "userinfoJobids");
            return (Criteria) this;
        }

        public Criteria andUserinfoJobidsLike(String value) {
            addCriterion("userInfo_jobIds like", value, "userinfoJobids");
            return (Criteria) this;
        }

        public Criteria andUserinfoJobidsNotLike(String value) {
            addCriterion("userInfo_jobIds not like", value, "userinfoJobids");
            return (Criteria) this;
        }

        public Criteria andUserinfoJobidsIn(List<String> values) {
            addCriterion("userInfo_jobIds in", values, "userinfoJobids");
            return (Criteria) this;
        }

        public Criteria andUserinfoJobidsNotIn(List<String> values) {
            addCriterion("userInfo_jobIds not in", values, "userinfoJobids");
            return (Criteria) this;
        }

        public Criteria andUserinfoJobidsBetween(String value1, String value2) {
            addCriterion("userInfo_jobIds between", value1, value2, "userinfoJobids");
            return (Criteria) this;
        }

        public Criteria andUserinfoJobidsNotBetween(String value1, String value2) {
            addCriterion("userInfo_jobIds not between", value1, value2, "userinfoJobids");
            return (Criteria) this;
        }

        public Criteria andUserinfoStudyidsIsNull() {
            addCriterion("userInfo_studyIds is null");
            return (Criteria) this;
        }

        public Criteria andUserinfoStudyidsIsNotNull() {
            addCriterion("userInfo_studyIds is not null");
            return (Criteria) this;
        }

        public Criteria andUserinfoStudyidsEqualTo(String value) {
            addCriterion("userInfo_studyIds =", value, "userinfoStudyids");
            return (Criteria) this;
        }

        public Criteria andUserinfoStudyidsNotEqualTo(String value) {
            addCriterion("userInfo_studyIds <>", value, "userinfoStudyids");
            return (Criteria) this;
        }

        public Criteria andUserinfoStudyidsGreaterThan(String value) {
            addCriterion("userInfo_studyIds >", value, "userinfoStudyids");
            return (Criteria) this;
        }

        public Criteria andUserinfoStudyidsGreaterThanOrEqualTo(String value) {
            addCriterion("userInfo_studyIds >=", value, "userinfoStudyids");
            return (Criteria) this;
        }

        public Criteria andUserinfoStudyidsLessThan(String value) {
            addCriterion("userInfo_studyIds <", value, "userinfoStudyids");
            return (Criteria) this;
        }

        public Criteria andUserinfoStudyidsLessThanOrEqualTo(String value) {
            addCriterion("userInfo_studyIds <=", value, "userinfoStudyids");
            return (Criteria) this;
        }

        public Criteria andUserinfoStudyidsLike(String value) {
            addCriterion("userInfo_studyIds like", value, "userinfoStudyids");
            return (Criteria) this;
        }

        public Criteria andUserinfoStudyidsNotLike(String value) {
            addCriterion("userInfo_studyIds not like", value, "userinfoStudyids");
            return (Criteria) this;
        }

        public Criteria andUserinfoStudyidsIn(List<String> values) {
            addCriterion("userInfo_studyIds in", values, "userinfoStudyids");
            return (Criteria) this;
        }

        public Criteria andUserinfoStudyidsNotIn(List<String> values) {
            addCriterion("userInfo_studyIds not in", values, "userinfoStudyids");
            return (Criteria) this;
        }

        public Criteria andUserinfoStudyidsBetween(String value1, String value2) {
            addCriterion("userInfo_studyIds between", value1, value2, "userinfoStudyids");
            return (Criteria) this;
        }

        public Criteria andUserinfoStudyidsNotBetween(String value1, String value2) {
            addCriterion("userInfo_studyIds not between", value1, value2, "userinfoStudyids");
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