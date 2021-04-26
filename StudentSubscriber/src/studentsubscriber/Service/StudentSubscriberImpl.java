package studentsubscriber.Service;

import java.util.List;
import java.util.Scanner;

import studentpublisher.StudentPublisher;
import studentpublisher.Model.Student;
import studentsubscriber.Constants;
import studentsubscriber.StudentSubscriber;


public class StudentSubscriberImpl implements StudentSubscriber {
	
    
	
	public void platform(StudentPublisher studentpublisher) {
		
		while(true) {
			
			
			Scanner sc = new Scanner(System.in);
	
			welocmeprompt(); //prompt to start 
		
			System.out.print(" > ");
			String val = sc.next();
		
			if(val.equalsIgnoreCase(Constants.GET)) {    //Main method which displays in the console
			
				getStudents(studentpublisher);
			}
			else if(val.equalsIgnoreCase(Constants.ADD)) {
			
				addStudent(studentpublisher);
			
			
		   }else if(val.equalsIgnoreCase(Constants.ID)) {
			
			    getByID(studentpublisher);
			
	
		   }else if(val.equalsIgnoreCase(Constants.UPDATE)){
			
			   updateByID(studentpublisher);
			
		   }else if(val.equalsIgnoreCase(Constants.DELETE)){
			
			  
			   delete(studentpublisher);
		   }
		   else if(val.equalsIgnoreCase(Constants.EXIT)) {
			
			  return;
			
		  }else {
			
			System.out.println("Invalid input");
		  }
		
	  }
		
	
	}

	@Override
	public void getStudents(StudentPublisher studentpublisher) {         //All the student are showed
		
		List <Student> students = studentpublisher.getAllStudents(); //Calling from publisher
		
		if(!students.isEmpty()) {
		
		System.out.println("-------------------------------------------------");
		
		for(Student student : students) {
			
			System.out.println();
			
			System.out.print(student.getStudent_ID() + "           ");   //Display Data with getters
			System.out.println(student.getFname() +" "+ student.getLname());
			
		}
		System.out.println("-------------------------------------------------");
		System.out.println();
		}
		
		
		
		else {
			
			System.out.println("No students are available !!!");
		}
		
	}

	
	@Override
	public void welocmeprompt() {  //Welcome prompt
		
		
		System.out.println();
		System.out.println();
		System.out.println("Welcome !!!!");
		System.out.println("Student Portal provides you with following services");
		System.out.println("-----------------------------------------------------");
		System.out.println("Please follow the below commands........");
		System.out.println("Get all students       ->  'GET'");
		System.out.println("Find a student by ID   ->  'ID'");
		System.out.println("Add a new student      ->  'ADD'");
		System.out.println("Delete a student       ->  'DELETE' ");
		System.out.println("Update a new student   ->  'UPDATE'");
		System.out.println("Exit                   ->  'EXIT' ");
		System.out.println();
	
	
	}

	
	@Override
	public void addStudent(StudentPublisher studentpublisher) { //Add a student
		
		    Scanner sc = new Scanner(System.in);
		
		    int ID = 0;
		    String fname = null ,lname = null,contactNo, degree,City,year;
	 
	
		    System.out.print("Enter ID         : ");
			ID = sc.nextInt();
		
													//Inputs are taken 
			System.out.print("Enter fname      : ");
			sc.nextLine();
			fname = sc.nextLine();
			
			System.out.print("Enter lname      : ");
			lname = sc.nextLine();
			
			System.out.print("Enter Contact No : ");
			contactNo = sc.nextLine();
			
			System.out.print("Enter the degree : ");
			degree = sc.nextLine();
			
			System.out.print("Enter the City   : ");
			City = sc.nextLine();
			
			System.out.print("Enter the year   :");
			year = sc.nextLine();
		 

		
		   Student st = new Student(ID,fname,lname, contactNo, degree, City,year);  //Student object is build
		   studentpublisher.add(st);  //Using add method of publisher
		   System.out.println("Student Added Successful !!");
		   System.out.println();
		
	}

	@Override
	public void delete(StudentPublisher studentpublisher) {   //Delete a student
		 
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please enter the ID of student : ");  //Input ID of student
		int ID = sc.nextInt();
		
		studentpublisher.deleteByid(ID);
		System.out.println();
		
	}

	@Override
	public void getByID(StudentPublisher studentpublisher) {   //Get student Details with ID
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the ID  : " );
		int ID = sc.nextInt();
		studentpublisher.getByid(ID); //Calling publisher method
		System.out.println();
		System.out.println();
		
	}

	@Override
	public void updateByID(StudentPublisher studentpublisher) {  //Update a student
		

		Scanner sc = new Scanner(System.in);
		
	    System.out.print("Enter ID         : ");
		int ID = sc.nextInt();
		System.out.println();
		studentpublisher.getByid(ID);
		System.out.println();
		System.out.println();
		
		System.out.print("Enter fname      : ");
		sc.nextLine();
		String fname = sc.nextLine();
		
		System.out.println();
		
		System.out.print("Enter lname      : ");
		String lname = sc.nextLine();
		
		System.out.print("Enter Contact No : ");
		String contactNo = sc.nextLine();
		
		System.out.print("Enter the degree : ");
		String degree = sc.nextLine();
		
		System.out.print("Enter the City   : ");
		String City = sc.nextLine();
		
		System.out.print("Enter the year   : ");
		String year = sc.nextLine();
	 
		System.out.println();
	
		Student st = new Student(ID,fname,lname, contactNo, degree, City,year);
		studentpublisher.update(ID, st);
		System.out.println("Student Updated Successful !!");
		System.out.println();
		System.out.println();
	}

	
	
}
	
	


