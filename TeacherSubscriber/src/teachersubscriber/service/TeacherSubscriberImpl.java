package teachersubscriber.service;

import java.util.List;
import java.util.Scanner;

import teacherpublisher.model.Teacher;
import teacherpublisher.service.TeacherPublish;
import static teachersubscriber.constant.Constant.*;

public class TeacherSubscriberImpl implements TeacherSubscriber{

	String input;
	String id;
	String name;
	String gender;
	String age;
	String language;
	String subject;
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void getService(TeacherPublish teacherpublish) {
		System.out.println();
		System.out.println("========== Welcome to Teachers Management Portal. ==========");
		System.out.println("============================================================");
		System.out.println();
		System.out.println("Please select the service you want.");
		System.out.println();
		
		while(true) {
			input = getInput();
			
			if(input.equalsIgnoreCase(EXIT)) {
				return;
			}
	
			else if(input.equalsIgnoreCase(ADD)) {
				addRecord(teacherpublish);
			}
			
			else if(input.equalsIgnoreCase(ALL)) {
				getAllRecords(teacherpublish);
			}
			
			else if(input.equalsIgnoreCase(DETAILS)) {
				getRecord(teacherpublish);
			}
			
			else if(input.equalsIgnoreCase(DELETE)) {
				deleteRecord(teacherpublish);
				
			}
			
			else if(input.equalsIgnoreCase(UPDATE)) {
				updateRecorde(teacherpublish);
			}
			else {
				System.out.println("Invalid Service.");
			}
			
			System.out.println("Do you want to continue?(yes/no): ");
			String end = sc.nextLine();
			if(end.equalsIgnoreCase("no")) {
				return;
			}
			else if(!end.equalsIgnoreCase("yes")) {
				System.out.println("Invalid command. Please try again.");
			}
		}
	}
	
	
	public String getInput() {
		System.out.println("add     \t- Add a new Teacher");
		System.out.println("all     \t- view all Teacher's ID and Name");
		System.out.println("details \t- View details about relavent Teacher");
		System.out.println("delete  \t- Delete Teacher");
		System.out.println("update  \t- Update Teacher's details");
		System.out.println("exit    \t- exit");
		System.out.println();
		System.out.print(">> ");
		String input = sc.nextLine();
		System.out.println();
		return input;
	}
	
	public void addRecord(TeacherPublish teacherpublish) {
		System.out.println("Enter Teacher's ID: ");
		id = sc.nextLine();
		System.out.println("Enter Teacher's Name: ");
		name = sc.nextLine();
		System.out.println("Enter Teacher's Gender: ");
		gender = sc.nextLine();
		System.out.println("Enter Teacher's Age: ");
		age = sc.nextLine();
		System.out.println("Enter Teacher's Language: ");
		language = sc.nextLine();
		System.out.println("Enter Teacher's Subject: ");
		subject = sc.nextLine();
		System.out.println();
		
		String temp = teacherpublish.addTeacher(id, name, gender, age, language, subject);
		System.out.println(temp);
		System.out.println();
	}

	public void getRecord(TeacherPublish teacherpublish) {
		String tecID;
		System.out.println("Enter Teacher ID: ");
		tecID = sc.nextLine();
		
		Teacher teacher = teacherpublish.getTeacher(tecID);
		if(teacher != null) {
			System.out.println();
			System.out.println("ID: " + teacher.getId());
			System.out.println("Name: " + teacher.getName());
			System.out.println("Gender: " + teacher.getGender());
			System.out.println("Age: " + teacher.getAge());
			System.out.println("Language: " + teacher.getLanguage());
			System.out.println("Subject: " + teacher.getSubject());
			System.out.println();
		}
		else {
			System.out.println("There is no such record with ID: " + tecID);
		}
	}
	
	public void getAllRecords(TeacherPublish teacherpublish) {
		List<Teacher> teachers = teacherpublish.getAllTeachers();
		
		System.out.println("===== Display Teacher ID and Name ======");
		System.out.println();
		
		System.out.println("ID   \t  Full Name");
		for(Teacher teacher : teachers) {
			
			
			System.out.print(teacher.getId());
			System.out.print("\t"+ teacher.getName());
			
			System.out.println();
			
		}
		System.out.println();
	}
	
	public void deleteRecord(TeacherPublish teacherpublish) {
		String delID;
		
		System.out.println("Enter Teacher ID: ");
		delID = sc.nextLine();
		teacherpublish.deleteTeacher(delID);
		
	}
	
	public void updateRecorde(TeacherPublish teacherpublish) {
		String upd;
		
		System.out.println("Enter Teacher ID: ");
		upd = sc.nextLine();
		
		Teacher teacher = teacherpublish.getTeacher(upd);
		if(teacher != null)  {
			System.out.println();
			System.out.println("ID: "+ teacher.getId());
			System.out.println("Name: "+teacher.getName());
			System.out.println("Gender: "+teacher.getGender());
			System.out.println("Age: "+teacher.getAge());
			System.out.println("Language: "+teacher.getLanguage());
			System.out.println("Subject: "+teacher.getSubject());
			
			System.out.println();
			System.out.println();
			
			System.out.println("Enter Teacher's Name: ");
			name = sc.nextLine();
			System.out.println("Enter Teacher's Gender: ");
			gender = sc.nextLine();
			System.out.println("Enter Teacher's Age: ");
			age = sc.nextLine();
			System.out.println("Enter Teacher's Language: ");
			language = sc.nextLine();
			System.out.println("Enter Teacher's Subject: ");
			subject = sc.nextLine();
			
			System.out.println();
			Teacher tempTeacher = new Teacher(upd, name, gender, age, language, subject);
			teacherpublish.updateTeacher(upd, tempTeacher);
			System.out.println();
		}
		else {
			System.out.println("There is no such record with ID: " + upd);
		}
	}
	
}
