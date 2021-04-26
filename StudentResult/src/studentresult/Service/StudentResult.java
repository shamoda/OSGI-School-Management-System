package studentresult;

import java.util.ArrayList;
import java.util.HashMap;

import studentresult.Models.Result;


public interface StudentResult { //Service class ,defines all the methods
	
	public void addMarks(String subject, String grade ,int ID);
	
	public void getMarks(String subject);
	
	public void getMarkslist(HashMap<Integer, String> hashMap);
	
	public String getGrade(HashMap<Integer, String> hashMap, int ID);

	public void generateReport(int id);

	void getMarksData(HashMap<Integer, String> hashMap , String Subject,int ID);
	
	public double calcavg(ArrayList<String> arr);

	
	public void deletemark(String subject,int id);
	
	public void updatemark(String subject,int id,String grade);
}
