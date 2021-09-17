package cubes.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
public class Location {
	
	@Id
	@Column
	private int id;
	@Column
	private String address;
	@Column
	private String phone1;
	@Column
	private String phone2;
	@Column
	private String email;
	@Column(name = "work_hour")
	private String workHour;
	@Column
	private String closed;
	@Column
	private String image;
	@Column
	private String latitude;
	@Column
	private String lognitude;
	
	public Location() {
		
	}

	public Location(String address, String phone1, String phone2, String email, String workHour, String closed,
			String image) {
		super();
		this.address = address;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.email = email;
		this.workHour = workHour;
		this.closed = closed;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWorkHour() {
		return workHour;
	}

	public void setWorkHour(String workHour) {
		this.workHour = workHour;
	}

	public String getClosed() {
		return closed;
	}

	public void setClosed(String closed) {
		this.closed = closed;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLognitude() {
		return lognitude;
	}

	public void setLognitude(String lognitude) {
		this.lognitude = lognitude;
	}

	@Override
	public String toString() {
		
		return address + "-" + id;
	}
	
	
	

}
