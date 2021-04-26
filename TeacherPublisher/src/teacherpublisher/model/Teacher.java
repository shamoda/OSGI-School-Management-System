package teacherpublisher.model;

public class Teacher {

	private String id;
	private String name;
	private String gender;
	private String age;
	private String language;
	private String subject;
//	private double salary;
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Teacher(String id, String name, String gender, String age, String language, String subject) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.language = language;
		this.subject = subject;
//		this.salary = salary; 
	}

//	public Double getSalary() {
//		return salary;
//	}
//
//	public void setSalary(Double salary) {
//		this.salary = salary;
//	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}


	
	
}
