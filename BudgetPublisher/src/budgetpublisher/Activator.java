package budgetpublisher;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import budgetpublisher.service.BudgetService;
import budgetpublisher.service.BudgetServiceImpl;
import eventpublisher.service.EventService;

public class Activator implements BundleActivator {

	private static BundleContext context;
	ServiceRegistration registration;
	ServiceReference reference;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
        Hashtable<String, String> props = new Hashtable<String, String>();
        props.put("Title", "Cost");
		BudgetService budgetService = new BudgetServiceImpl();
		registration = bundleContext.registerService(BudgetService.class.getName(), budgetService, props );
		reference = bundleContext.getServiceReference(EventService.class.getName());
		EventService eventService = (EventService) bundleContext.getService(reference);
		System.out.println("Budget service started");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		registration.unregister();
		bundleContext.ungetService(reference);
		Activator.context = null;
		System.out.println("Budget service stopped.");
	}

}
