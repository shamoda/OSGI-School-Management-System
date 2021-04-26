package studentpublisher.Service;

import java.util.ArrayList;
import java.util.List;

import studentpublisher.StudentPublisher;
import studentpublisher.Model.Student;

public class StudentPublisherImpl implements StudentPublisher {

		
	public ArrayList<Student> stu = new ArrayList<Student>();   //returns an arraylist with all the Student data
	    
	
		@Override
		public List<Student> getAllStudents() {
			
			
			return stu;
			
		}


		@Override
		public void add(Student st) {  //add a particular student
			
			String fname =  st.getFname();
			String lname = st.getLname();
			int id = st.getStudent_ID();
			String contactNo = st.getContact_no();
			String degree = st.getDegree();
			String City = st.getCity();
			String Year = st.getYear();
			
			Student student = new Student(id,fname,lname,contactNo,degree,City,Year); //Student object
			
			stu.add(student); //Add to arraylist
		
		}


		@Override
		public void getByid(int id) {    //Get student details by ID
			
			
			for(Student st : stu ) { //Traversing through the arraylist 
				
				int ID = st.getStudent_ID();
				
				if(ID == id) {
					
					System.out.println("-----------Student Details-----------------");     //Getters are used to get all the data
					System.out.println();
					System.out.println("Student Name : "+ st.getFname() +" "+ st.getLname());
					System.out.println("City         : "+ st.getCity());
					System.out.println("Degree       : "+ st.getYear());
					System.out.println("Contact No   : "+ st.getContact_no());
					
					return; //Termination
				}

			
			}
			System.out.println("Sorry student is not found !!!!"); 
			return;
		
		}


		@Override
		public void deleteByid(int id) {             //Delete a student by ID
		
				for(Student st : stu ) {  //
				
					int ID = st.getStudent_ID();  //IDs are assigned through the arrauList
				
					if(ID == id) { // 2 ID s are compared
						
						int index = stu.indexOf(st);
						stu.remove(index);
						System.out.println("Student was deleted successfully !!!");
					
						return;
				}

			
			}
			  System.out.println("Sorry student is not found !!!!");
			  return;
		
		}

			
		@Override
		public void update(int id,Student student) {   //update a student, Student ID is taken as a input
		
				for(Student st : stu ) {
				
					int ID = st.getStudent_ID();
				
					if(ID == id) {
							
						int index = stu.indexOf(st);  //Finding the index of the entry
						stu.remove(index);
						
						stu.add(student);
						
						return;
				}

			
			}
			  System.out.println("Sorry student is not found !!!!");
			  return;
		
		}
			
		}
		
		 
		


