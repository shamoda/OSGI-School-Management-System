package eventsubscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import budgetpublisher.service.BudgetService;
import eventpublisher.service.EventService;
import eventsubscriber.Activator;
import eventsubscriber.service.EventSubscriberService;
import eventsubscriber.service.EventSubscriberServiceImpl;
import eventsubscriber.service.ManageEvents;
import eventsubscriber.service.ManageEventsImpl;

public class Activator implements BundleActivator {

	private static BundleContext context;
	ServiceReference reference1;
	ServiceReference reference2;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Events subscriber started.");

		reference1 = bundleContext.getServiceReference(EventService.class.getName());
		EventService eventService = (EventService) bundleContext.getService(reference1);
		reference2 = bundleContext.getServiceReference(BudgetService.class.getName());
		BudgetService budgetService = (BudgetService) bundleContext.getService(reference2);
		
		EventSubscriberService subscriberService = new EventSubscriberServiceImpl();
		subscriberService.clientService(eventService, budgetService);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Events subscriber stopped.");
		bundleContext.ungetService(reference1);
		bundleContext.ungetService(reference2);
		Activator.context = null;
	}

}
