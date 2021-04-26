package studentsubscriber;

import studentpublisher.StudentPublisher;


public interface StudentSubscriber {
	
	public void platform(StudentPublisher studentpublisher);
	
	public void getStudents(StudentPublisher studentpublisher);
	
	public void welocmeprompt();
	
	public void addStudent(StudentPublisher studentpublisher);
	
	public void delete(StudentPublisher studentpublisher);
	
	public void getByID(StudentPublisher studentpublisher);
	
	public void updateByID(StudentPublisher studentpublisher);
	
	

}
