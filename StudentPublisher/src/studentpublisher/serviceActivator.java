package studentpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import studentpublisher.Service.StudentPublisherImpl;



public class serviceActivator implements BundleActivator {

    ServiceRegistration<?> publishServiceRegistration;
	
	ServiceReference<?> serviceReference;
	
	@Override
	public void start(BundleContext context) throws Exception {
	
		System.out.println("Student Publisher Started !!!");
		StudentPublisher publisherService = new StudentPublisherImpl();
		publishServiceRegistration = context.registerService(StudentPublisher.class.getName(), publisherService, null);
		
	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
	
		System.out.println("Publisher Stop");
		publishServiceRegistration.unregister();
		
	}

}
