package minh.training.springhibernate.screenmodels;

import java.util.Date;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

public class CustomerSearchData implements java.io.Serializable  {
	private static final long serialVersionUID = 1L;
	@Length(max = 255)
	private String name;
	private Date dateOfBirth;
	@Length(max = 255)
	private String phone;
	@Email
	private String email;
	private Boolean gender;

	public CustomerSearchData() {
	}

	public CustomerSearchData(String name, Date dateOfBirth, String phone, String email, Boolean gender) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}
}
