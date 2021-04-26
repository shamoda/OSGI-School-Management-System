package studentresultsubscriber;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import studentresult.StudentResult;
import studentresult.Service.StudentResultImpl;
import studentresultsubscriber.Service.StudentResultsubImpl;


public class Activator implements BundleActivator {
	
	private static BundleContext context;
	ServiceReference servicReference;
	

	public void start(BundleContext context) throws Exception {
		System.out.println(" Result Consumer Started !!!");
		
		servicReference = context.getServiceReference(StudentResult.class.getName());
		StudentResult studentresult = (StudentResultImpl) context.getService(servicReference);
		
	
		StudentResultSubscriber studentSubscriber = new StudentResultsubImpl();
		studentSubscriber.platform(studentresult);
		stop(context);
	}

	@Override
	public void stop(BundleContext context) throws Exception { 
		System.out.println("Thank you for using our Examination Portal!!");
		System.out.println("Have a nice day");
		context.ungetService(servicReference);
	}
}
