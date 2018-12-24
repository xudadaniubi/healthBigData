package com.boku.www.pojo;

public class TAreaAndCompany {
    private Integer id;

    private String city;

    private String district;

    private String company;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

	@Override
	public String toString() {
		return "TAreaAndCompany{" +
				"id=" + id +
				", city='" + city + '\'' +
				", district='" + district + '\'' +
				", company='" + company + '\'' +
				", status='" + status + '\'' +
				'}';
	}
}