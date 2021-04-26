package teacherpublisher;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import teacherpublisher.service.TeacherPublish;
import teacherpublisher.service.TeacherPublishImpl;

public class Activator implements BundleActivator {

	private static BundleContext context;
	ServiceRegistration registration;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
        Hashtable<String, String> props = new Hashtable<String, String>();
        props.put("Teacher", "Name");
		TeacherPublish teacherService = new TeacherPublishImpl();
		registration = bundleContext.registerService(TeacherPublish.class.getName(), teacherService, props );
		System.out.println("Teacher service started");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		registration.unregister();
		Activator.context = null;
		System.out.println("Teacher service stopped.");
	}

}
