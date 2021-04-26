package studentpublisher;

import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

import studentpublisher.Model.Student;

public interface StudentPublisher { //Service class defines all the methods
	
	
	public List <Student> getAllStudents();
	
	public void add(Student st); 

	public void getByid(int id);
	
	public void deleteByid(int id);
	
	public void update(int id, Student student);
	
	
}
