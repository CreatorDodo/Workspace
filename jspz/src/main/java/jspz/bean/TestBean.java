package jspz.bean;

public class TestBean {
	private String country;
	private String city;
	private String name;
	
	public TestBean() {
	}

	public TestBean(String country, String city, String name) {
		this.country = country;
		this.city = city;
		this.name = name;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return country + " | " + city + " | " + name;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}







