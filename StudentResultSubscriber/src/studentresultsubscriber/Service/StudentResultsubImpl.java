package studentresultsubscriber.Service;

import java.util.Scanner;

import studentresult.StudentResult;
import studentresultsubscriber.Constants;
import studentresultsubscriber.StudentResultSubscriber;

public class StudentResultsubImpl implements StudentResultSubscriber{

	@Override
	public void platform(StudentResult studentPublisher) {
		//Platform the main method which get displayed in the console
		
		while(true) {
			Scanner sc = new Scanner(System.in);   
			
			welocmeprompt();
			String val = sc.next();
		
			if(val.equalsIgnoreCase(Constants.ADD)) {  //Conditions are checked according to the constants
				
				addMark(studentPublisher);
			
				
			}else if(val.equalsIgnoreCase(Constants.GET)) {
				
				
				getResults(studentPublisher);
				
			}else if(val.equalsIgnoreCase(Constants.R)) {
				
				 generateReport(studentPublisher);
				
			}else if(val.equalsIgnoreCase(Constants.DELETE)) {
				
				deleteMark(studentPublisher);
				
			}else if(val.equalsIgnoreCase(Constants.UPDATE)) {
				
				updateMark(studentPublisher);
				
			}else if(val.equalsIgnoreCase(Constants.EXIT)) {
				
				return;
				
			}else {
				
				System.out.println("Invalid Input");
			}
					
	}

}

	@Override
	public void getResults(StudentResult studentPublisher) {   //Get Results or Grades of each subject
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Subjects ->   'DS' , 'AF', 'SEPQM' ,'SA'");
		System.out.println();
		System.out.print("Enter the Subject : ");
		String Sub = sc.next();
		
		studentPublisher.getMarks(Sub);
		
	}

	@Override
	public void welocmeprompt() {   //prompt or the welcome message which shows when the start occurs
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Examination Portal provides you with following services");
		System.out.println("-----------------------------------------------------");
		System.out.println("");
		
		System.out.println("Use Following commonds ");
		System.out.println("To Add a grade of Student            ->  'ADD'");
		System.out.println("Update a grade of a Student          ->  'UPDATE");
		System.out.println("Delete a grade of a student          -> 'DELETE");
		System.out.println("Generate a Report                    -> R");
		System.out.println("Exit                                 -> 'EXIT'");
		System.out.println();
		System.out.print(" > ");
		
	}

	@Override
	public void addMark(StudentResult studentPublisher) {  //add new marks of students 
		
		String in;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Subjects   ->     'DS' , 'AF', 'SEPQM' ,'SA'"); //gets the input ,
		System.out.println();
		System.out.print("Enter the Subject : ");
		String Sub = sc.next();
		

		do{	 //do-while loop continues until the input becomes different from Y
                
			System.out.print("Enter the Student ID : ");
			int ID = sc.nextInt();
		
		       
		      
		    
			System.out.print("Enter the Grade : ");
			String grade = sc.next();
			studentPublisher.addMarks(Sub, grade, ID);
			
			System.out.println("Do you wish to enter a another grade ?  Y | N :");
			in = sc.next();
			
			
			
			
		}while(in.equals("Y" ) || in.equals("y"));
		
		
	}

	@Override
	public void deleteMark(StudentResult studentPublisher) {  //Delete the marks of student
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the Student ID : ");  //prompt
		int ID = sc.nextInt();
		System.out.print("Enter the Subject :");
		String subject = sc.next();
		
		studentPublisher.deletemark(subject, ID);  //calling delete method in studentResult publisher
		System.out.println("Grade was deleted successfully!!");  
		System.out.println();
	}

	@Override
	public void updateMark(StudentResult studentPublisher) {
		
                                                   //Taking inputs to the update method
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the Student ID : ");
		int ID = sc.nextInt();
		System.out.print("Enter the Subject    :");
		String subject = sc.nextLine();
		
		System.out.print("Enter the Grade      :");
		String grade = sc.nextLine();
		
		studentPublisher.updatemark(subject,ID, grade);
		System.out.println("Grade was updated successfully!!");
		System.out.println();
	}

	@Override
	public void generateReport(StudentResult studentPublisher) {
		                                                      //Calling publisher method generate Report
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the ID : ");
		int id = sc.nextInt();
		
		studentPublisher.generateReport(id);
		
		
	}
	
}
