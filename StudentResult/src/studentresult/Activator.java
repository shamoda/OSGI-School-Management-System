package studentresult;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import studentresult.Service.StudentResultImpl;



public class Activator implements BundleActivator {

	  ServiceRegistration<?> publishServiceRegistration;
		
		ServiceReference<?> serviceReference;
		
		@Override
		public void start(BundleContext context) throws Exception {
		
			System.out.println(" Publisher Started !!!");
			StudentResult publisherService = new StudentResultImpl();
			publishServiceRegistration = context.registerService(StudentResult.class.getName(), publisherService, null);
			
		}

		@Override
		public void stop(BundleContext arg0) throws Exception {
		
			System.out.println("Publisher Stop");
			publishServiceRegistration.unregister();
			
		}

}
