package come.comenie.guava.EventBus;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by 波 on 2017/1/13.
 */
public class EventBusUtilTest {

    private static final String EVENT = "Hello";
    private static final String BUS_IDENTIFIER = "test-bus";

    private EventBus bus;

    @Before
    public void  setUp(){
        this.bus = new EventBus(BUS_IDENTIFIER);
    }

    @Test
    public void testBasicCatcherDistribution() {
        StringCatcher catcher = new StringCatcher();
        bus.register(catcher);
        bus.post(EVENT);

        List<String> events = catcher.getEvents();
        assertEquals("Only one event should be delivered.", 1, events.size());
        assertEquals("Correct string should be delivered.", EVENT, events.get(0));
    }

    @Test
    public void testPolymorphicDistributiion(){
        StringCatcher stringCatcher = new StringCatcher();

        final List<Object> objectEvents = Lists.newArrayList();
        Object objCatcher = new Object() {
            @SuppressWarnings("unused")
            @Subscribe
            public void eat(Object food) {
                objectEvents.add(food);
            }
        };

        final List<Comparable<?>> compEvents = Lists.newArrayList();
        Object compCatcher = new Object() {
            @SuppressWarnings("unused")
            @Subscribe public void eat(Comparable<?> food) {
                compEvents.add(food);
            }
        };
        bus.register(stringCatcher);
        bus.register(objCatcher);
        bus.register(compCatcher);

        Object objEvent = new Object();
        Object compEvent = new Integer(6);

        bus.post(EVENT);
        bus.post(objEvent);
        bus.post(compEvent);

        // Check the StringCatcher...
        List<String> stringEvents = stringCatcher.getEvents();
        assertEquals("Only one String should be delivered.",
                1, stringEvents.size());
        assertEquals("Correct string should be delivered.",
                EVENT, stringEvents.get(0));

        // Check the Catcher<Object>...
        assertEquals("Three Objects should be delivered.",
                3, objectEvents.size());
        assertEquals("String fixture must be first object delivered.",
                EVENT, objectEvents.get(0));
        assertEquals("Object fixture must be second object delivered.",
                objEvent, objectEvents.get(1));
        assertEquals("Comparable fixture must be thirdobject delivered.",
                compEvent, objectEvents.get(2));

        // Check the Catcher<Comparable<?>>...
        assertEquals("Two Comparable<?>s should be delivered.",
                2, compEvents.size());
        assertEquals("String fixture must be first comparable delivered.",
                EVENT, compEvents.get(0));
        assertEquals("Comparable fixture must be second comparable delivered.",
                compEvent, compEvents.get(1));
    }

    @Test
    public void testSubscriberThrowsException() throws Exception{
        final RecordingSubscriberExceptionHandler handler =
                new RecordingSubscriberExceptionHandler();
        final EventBus eventBus = new EventBus(handler);
        final RuntimeException exception =
                new RuntimeException("but culottes have a tendancy to ride up!");
        final Object subscriber = new Object() {
            @Subscribe
            public void throwExceptionOn(String message) {
                throw exception;
            }
        };
        eventBus.register(subscriber);
        eventBus.post(EVENT);

        assertEquals("Cause should be available.",
                exception, handler.exception);
        assertEquals("EventBus should be available.",
                eventBus, handler.context.getEventBus());
        assertEquals("Event should be available.",
                EVENT,
                handler.context.getEvent());
        assertEquals("Subscriber should be available.",
                subscriber, handler.context.getSubscriber());
        assertEquals("Method should be available.",
                subscriber.getClass().getMethod("throwExceptionOn", String.class),
                handler.context.getSubscriberMethod());
    }


    @Test
    public void testSubscriberThrowsExceptionHandlerThrowsException() throws  Exception{
        final EventBus eventBus = new EventBus(new SubscriberExceptionHandler() {
            public void handleException(Throwable exception,
                                        SubscriberExceptionContext context) {
                throw new RuntimeException();
            }
        });
        final Object subscriber = new Object() {
            @Subscribe
            public void throwExceptionOn(String message) {
                throw new RuntimeException();
            }
        };
        eventBus.register(subscriber);
        try {
            eventBus.post(EVENT);
        } catch (RuntimeException e) {
            fail("Exception should not be thrown.");
        }
    }


    @Test
    public void testDeadEventForwarding() {
        GhostCatcher catcher = new GhostCatcher();
        bus.register(catcher);

        // A String -- an event for which noone has registered.
        bus.post(EVENT);

        List<DeadEvent> events = catcher.getEvents();
        assertEquals("One dead event should be delivered.", 1, events.size());
        assertEquals("The dead event should wrap the original event.",
                EVENT, events.get(0).getEvent());
    }

    @Test
    public void testDeadEventPosting() {
        GhostCatcher catcher = new GhostCatcher();
        bus.register(catcher);

        bus.post(new DeadEvent(this, EVENT));

        List<DeadEvent> events = catcher.getEvents();
        assertEquals("The explicit DeadEvent should be delivered.",
                1, events.size());
        assertEquals("The dead event must not be re-wrapped.",
                EVENT, events.get(0).getEvent());
    }

    @Test
    public void testUnregister() {
        StringCatcher catcher1 = new StringCatcher();
        StringCatcher catcher2 = new StringCatcher();
        try {
            bus.unregister(catcher1);
            fail("Attempting to unregister an unregistered object succeeded");
        } catch (IllegalArgumentException expected) {
            // OK.
        }

        bus.register(catcher1);
        bus.post(EVENT);
        bus.register(catcher2);
        bus.post(EVENT);

        List<String> expectedEvents = Lists.newArrayList();
        expectedEvents.add(EVENT);
        expectedEvents.add(EVENT);

        assertEquals("Two correct events should be delivered.",
                expectedEvents, catcher1.getEvents());

        assertEquals("One correct event should be delivered.",
                Lists.newArrayList(EVENT), catcher2.getEvents());

        bus.unregister(catcher1);
        bus.post(EVENT);

        assertEquals("Shouldn't catch any more events when unregistered.",
                expectedEvents, catcher1.getEvents());
        assertEquals("Two correct events should be delivered.",
                expectedEvents, catcher2.getEvents());

        try {
            bus.unregister(catcher1);
            fail("Attempting to unregister an unregistered object succeeded");
        } catch (IllegalArgumentException expected) {
            // OK.
        }

        bus.unregister(catcher2);
        bus.post(EVENT);
        assertEquals("Shouldn't catch any more events when unregistered.",
                expectedEvents, catcher1.getEvents());
        assertEquals("Shouldn't catch any more events when unregistered.",
                expectedEvents, catcher2.getEvents());
    }

    @Test
    public void testRegisterThreadSafety() throws Exception {
        List<StringCatcher> catchers = Lists.newCopyOnWriteArrayList();
        List<Future<?>> futures = Lists.newArrayList();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        int numberOfCatchers = 10000;
        for (int i = 0; i < numberOfCatchers; i++) {
            futures.add(executor.submit(new Registrator(bus, catchers)));
        }
        for (int i = 0; i < numberOfCatchers; i++) {
            futures.get(i).get();
        }
        assertEquals("Unexpected number of catchers in the list",
                numberOfCatchers, catchers.size());
        bus.post(EVENT);
        List<String> expectedEvents = ImmutableList.of(EVENT);
        for (StringCatcher catcher : catchers) {
            assertEquals("One of the registered catchers did not receive an event.",
                    expectedEvents, catcher.getEvents());
        }
    }

    @Test
    public void testRegistrationWithBridgeMethod() {
        final AtomicInteger calls = new AtomicInteger();
        bus.register(new Callback<String>() {
            @Subscribe
            public void call(String s) {
                calls.incrementAndGet();
            }
        });

        bus.post("hello");

        assertEquals(1, calls.get());
    }

    /**
     * Records thrown exception information.
     */
    private static final class RecordingSubscriberExceptionHandler
            implements SubscriberExceptionHandler {

        public SubscriberExceptionContext context;
        public Throwable exception;

        public void handleException(Throwable exception,
                                    SubscriberExceptionContext context) {
            this.exception = exception;
            this.context = context;
        }
    }
    public static class GhostCatcher {
        private List<DeadEvent> events = Lists.newArrayList();

        @Subscribe
        public void ohNoesIHaveDied(DeadEvent event) {
            events.add(event);
        }

        public List<DeadEvent> getEvents() {
            return events;
        }
    }

    private static class Registrator implements Runnable {
        private final EventBus bus;
        private final List<StringCatcher> catchers;

        Registrator(EventBus bus, List<StringCatcher> catchers) {
            this.bus = bus;
            this.catchers = catchers;
        }

        public void run() {
            StringCatcher catcher = new StringCatcher();
            bus.register(catcher);
            catchers.add(catcher);
        }
    }


    private interface Callback<T> {
        void call(T t);
    }
}