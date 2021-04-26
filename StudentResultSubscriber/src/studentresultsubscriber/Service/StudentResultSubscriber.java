package studentresultsubscriber;

import studentresult.StudentResult;

public interface StudentResultSubscriber {

	public void platform(StudentResult studentPublisher);
	
	public void getResults(StudentResult studentPublisher);
	
	public void welocmeprompt();
	
	public void addMark(StudentResult studentPublisher);
	
	public void deleteMark(StudentResult studentPublisher);
	
	public void updateMark(StudentResult studentPublisher);
	
	public void generateReport(StudentResult studentPublisher);

}
