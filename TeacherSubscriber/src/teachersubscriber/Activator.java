package teachersubscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import teacherpublisher.service.TeacherPublish;
import teachersubscriber.service.TeacherSubscriber;
import teachersubscriber.service.TeacherSubscriberImpl;

public class Activator implements BundleActivator {

	private static BundleContext context;
	ServiceReference reference;
	Scanner sc = new Scanner(System.in);

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Teacher subscriber started.");
		reference = bundleContext.getServiceReference(TeacherPublish.class.getName());
		TeacherPublish teacherService = (TeacherPublish) bundleContext.getService(reference);
		
		TeacherSubscriber subscriberService = new TeacherSubscriberImpl();
		subscriberService.getService(teacherService);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Teacher subscriber stopped");
		bundleContext.ungetService(reference);
		Activator.context = null;
	}

}
