package studentresult.Service;

import studentresult.StudentResult;
import studentresult.Data.ResultData;
import static studentresult.Constants.AF;
import static studentresult.Constants.DS;
import static studentresult.Constants.SA;
import static studentresult.Constants.SEPQM;

import java.util.ArrayList;
import java.util.HashMap;
import studentpublisher.StudentPublisher;
import studentpublisher.Service.StudentPublisherImpl;

public class StudentResultImpl implements StudentResult,ResultData {

	
	@Override
	public void addMarks(String subject ,String grade, int ID ) {
		
	
		
		if(subject.equalsIgnoreCase(AF)) {              //add marks method, based on the subject Grades are put into hashmap
			
			AF_g.put(ID,grade);
			
		}else if(subject.equalsIgnoreCase(SA)) {
			
			SA_g.put(ID,grade);
			
		}else if(subject.equalsIgnoreCase(SEPQM)) {
			
			SEPQM_g.put(ID,grade);
			
		}else if(subject.equalsIgnoreCase(DS)) {
			
			DS_g.put(ID,grade);
			
		}else {
			
			System.out.println("Please enter a subject");
		}
				
	}
	
	
	public void getMarks(String subject) {   //get all marks, taking the subject as a input
		
		

		if(subject.equalsIgnoreCase(AF)) {
			
			getMarkslist(AF_g);
			
		}else if(subject.equalsIgnoreCase(SA)) {
			
			getMarkslist(SA_g);
		}else if(subject.equalsIgnoreCase(SEPQM)) {
			
			getMarkslist(SEPQM_g);
			
		}else if(subject.equalsIgnoreCase(DS)) {
			
			getMarkslist(DS_g);
			
		}else {
			
			System.out.println("Please enter a subject");
		}
				

}


	@Override
	public void getMarkslist(HashMap<Integer, String> hashMap) { //Hashmap is the parameter, this method is called from the getMarks() method
		
		System.out.println("Student ID       Grade");
		for (int i : hashMap.keySet()) {
				 
			System.out.println(i +" : "+ hashMap.get(i));
		}

 }
	
	@Override
	public void getMarksData(HashMap<Integer, String> hashMap,String subject,int ID) {
		
		System.out.println("");
		for (int i : hashMap.keySet()) {
			
			if(ID == i) {
				 
				System.out.println(subject +": " + hashMap.get(i));
			}else {
			
				System.out.println(subject +"  Not Available" );
			
		  }
		}
		
 }


	@Override
	public void generateReport(int id) {  //generating an individual report
		
		
		System.out.println("..............................................");
		System.out.println();
		
		System.out.println("Student ID   :"+id);
	    StudentPublisher studentpublisher = new StudentPublisherImpl();
	    studentpublisher.getByid(id);
	
		 //All hashmap are used here to get a combined report or data
		
		getMarksData(AF_g, "AF" ,id );
		getMarksData(SA_g, "SA" ,id );
		getMarksData(SEPQM_g, "SEPQM" ,id );
		getMarksData(DS_g, "DS" ,id );
		System.out.println();
		
		String AF = getGrade(AF_g,id);
		String SA = getGrade(SA_g,id);        //Calling getGrade() method
		String SEPQM = getGrade(SEPQM_g,id);
		String DS = getGrade(DS_g,id);
		
		ArrayList<String> arr = new ArrayList<String>();  //Assigning the grades to an arraylsit
		
		arr.add(AF);
		arr.add(SA);     
		arr.add(SEPQM);
		arr.add(DS);
		
		System.out.println("Average GPA : "+calcavg(arr));   //Calculates the average GPA by calling the calcaavg()
		System.out.println();
		
		
		System.out.println("..............................................");
		
	}


	

	@Override
	public void deletemark(String subject,int id) {
		//Delete a mark based on the subject and ID
	if(subject.equalsIgnoreCase(AF)) {
			
			AF_g.remove(id);  //remove from hashMap
			
		}else if(subject.equalsIgnoreCase(SA)) {
			
			SA_g.remove(id);
			
		}else if(subject.equalsIgnoreCase(SEPQM)) {
			
			SEPQM_g.remove(id);
			
		}else if(subject.equalsIgnoreCase(DS)) {
			
			DS_g.remove(id);
			
		}else {
			
			System.out.println("ID is not avialable");
		}
				
		
	}


	@Override
	public void updatemark(String subject, int id, String grade) {
		// Update a mark based on the subject and ID
		if(subject.equalsIgnoreCase(AF)) {
			
			AF_g.remove(id);  //remove first
			AF_g.put(id, grade); // then add the updated values to the hashMap
			
		}else if(subject.equalsIgnoreCase(SA)) {
			
			SA_g.remove(id);
			SA_g.put(id, grade);
			
		}else if(subject.equalsIgnoreCase(SEPQM)) {
			
			SEPQM_g.remove(id);
			SEPQM_g.put(id, grade);
			
		}else if(subject.equalsIgnoreCase(DS)) {
			
			DS_g.remove(id);
			DS_g.put(id, grade);
			
		}else {
			
			System.out.println("ID is not avialable");
		}
		
	}


	@Override
	public double calcavg(ArrayList<String> arr) {
		
		double total = 0;
		
		for(int i =0 ; i < 4 ; i++) {      //Looping through the array
			
			String grade = arr.get(i);
			
			
			switch (grade) {
			
			  case "A":
				  total += 4.0;     //Assigning GPA values to each grade
				  break;
			  case "B":
				  total += 3.0;
				  break;
			  case "C":
				  total += 2.0;
				  break;
			  case "S":
				  total += 1.0;
				  break;
			  default:
				  total += 0.0;
			}
			
		}
		return (total/4.0);   //Divide the total by 4(No of subjects)
	}


	@Override
	public String getGrade(HashMap<Integer, String> hashMap, int ID) { //Returns each Grade of that subject related to the ID
		
		System.out.println("");
		for (int i : hashMap.keySet()) {
			
			if(ID == i) {
				 
				return hashMap.get(i);
			}
		}
		return "F";
		
	}

		
}
	



