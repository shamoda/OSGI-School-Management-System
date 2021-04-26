package teacherpublisher.service;

import java.util.ArrayList;
import java.util.List;

import teacherpublisher.model.Teacher;

public class TeacherPublishImpl implements TeacherPublish{

	public List<Teacher> teachers = new ArrayList<Teacher>();

	@Override
	public String addTeacher(String id, String name, String gender, String age, String language, String subject) {
		Teacher teacher = new Teacher(id, name, gender, age, language, subject);
		teachers.add(teacher);
		return "New Teacher " +  teacher.getName() + " added succesfully";
	}

	@Override
	public List<Teacher> getAllTeachers() {
		return teachers;
	}

	@Override
	public Teacher getTeacher(String id) {
		Teacher teacher = null;
			for(Teacher tempTeacher : teachers) {
				if(tempTeacher.getId().equalsIgnoreCase(id)) {
					teacher = tempTeacher;
				}
			}
		return teacher;
	}

	@Override
	public void deleteTeacher(String id) {
		
		for(Teacher teacher : teachers) {
			if(teacher.getId().equalsIgnoreCase(id)) {
				
				int index = teachers.indexOf(teacher);
				teachers.remove(index);
				System.out.println("Delete Teacher ID " + id + " successfully.");
				return;
				
			}
		}
		System.out.println("Teacher is NOT found.");
		return;
	}
	
	

	@Override
	public void updateTeacher(String id, Teacher teacher) {
		for(Teacher tempTeacher : teachers) {
			if(tempTeacher.getId().equalsIgnoreCase(id)){
				teachers.remove(tempTeacher);
				teachers.add(teacher);
				return;
			}
		}
		System.out.println("Sorry teacher is NOT found");
		return;
	}

}

