package minh.training.springhibernate.screenmodels;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import minh.training.springhibernate.annotations.Phone;

@Entity
public class CustomerDetailData implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	@Length(max = 255)
	@NotNull
	@NotBlank
	private String name;
	@NotNull
	private Date dateOfBirth;
	@Length(max = 15)
	@NotNull
	@NotBlank
	@Phone
	private String phone;
	@Email
	@NotNull
	@NotBlank
	private String email;
	@NotNull
	private Boolean gender;
	@NotNull
	@NotBlank
	@Length(max = 4000)
	private String addressLine;
	@NotNull
	@NotBlank
	private String title;

	public CustomerDetailData() {
	}

	public CustomerDetailData(Integer id, String name, Date dateOfBirth, String phone, String email, Boolean gender,
			String addressLine, String tittle) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.addressLine = addressLine;
		this.title = tittle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String tittle) {
		this.title = tittle;
	}
}
