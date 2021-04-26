package teacherpublisher.service;

import java.util.List;

import teacherpublisher.model.Teacher;

public interface TeacherPublish {
	
	public String addTeacher(String id, String name, String gender, String age, String language, String subject);

	public List<Teacher> getAllTeachers();
	
	public Teacher getTeacher(String id);
	
	public void deleteTeacher(String id);
	
	public void updateTeacher(String id, Teacher teacher);
		
}
