package studentpublisher.Model;

public class Student {

	private int student_ID;
	private String fname;
	private String lname;
	private String contact_no;
	private String degree;
	private String City;
	private String year;
	
	


	public Student(int student_ID, String fname, String lname, String contact_no, String degree, String city,
			String year) {
		super();
		this.student_ID = student_ID;
		this.fname = fname;
		this.lname = lname;
		this.contact_no = contact_no;
		this.degree = degree;
		City = city;
		this.year = year;
	}


	public int getStudent_ID() {
		return student_ID;
	}


	public void setStudent_ID(int student_ID) {
		this.student_ID = student_ID;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getContact_no() {
		return contact_no;
	}


	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}


	public String getDegree() {
		return degree;
	}


	public void setDegree(String degree) {
		this.degree = degree;
	}


	public String getCity() {
		return City;
	}


	public void setCity(String city) {
		City = city;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}
	
	
	
	
}
