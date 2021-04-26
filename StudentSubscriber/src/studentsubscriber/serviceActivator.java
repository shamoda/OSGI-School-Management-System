package studentsubscriber;



import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import studentpublisher.StudentPublisher;
import studentpublisher.Service.StudentPublisherImpl;
import studentsubscriber.Service.StudentSubscriberImpl;



public class serviceActivator implements BundleActivator {

	private static BundleContext context;
	ServiceReference servicReference;
	

	public void start(BundleContext context) throws Exception {
		System.out.println(" Student Consumer Started !!!");
		
		servicReference = context.getServiceReference(StudentPublisher.class.getName());
		StudentPublisher studentPublisher = (StudentPublisherImpl) context.getService(servicReference);
		
	
		StudentSubscriber studentSubscriber = new StudentSubscriberImpl();
		studentSubscriber.platform(studentPublisher);
		stop(context);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Thank you for using our Student Portal!!");
		System.out.println("Have a nice day");
		context.ungetService(servicReference);
	}

	
}


