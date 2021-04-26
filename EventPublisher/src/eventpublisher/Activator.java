package eventpublisher;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import eventpublisher.Activator;
import eventpublisher.service.EventService;
import eventpublisher.service.EventServiceImpl;

public class Activator implements BundleActivator {

	private static BundleContext context;
	ServiceRegistration registration;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
        Hashtable<String, String> props = new Hashtable<String, String>();
        props.put("Language", "English");
		EventService eventService = new EventServiceImpl();
		registration = bundleContext.registerService(EventService.class.getName(), eventService, props );
		System.out.println("Event service started");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		registration.unregister();
		Activator.context = null;
		System.out.println("Event service stopped.");
	}

}
