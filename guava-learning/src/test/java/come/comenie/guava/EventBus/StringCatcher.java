package come.comenie.guava.EventBus;

import com.google.common.collect.Lists;
import com.google.common.eventbus.Subscribe;

import com.sun.istack.internal.Nullable;

import junit.framework.Assert;

import java.util.List;

/**
 * Created by 波 on 2017/1/13.
 */
public class StringCatcher {
    private List<String> events = Lists.newArrayList();
    @Subscribe
    public void  handle(String string){
        System.out.println("recv event:--->" + string);
        events.add(string);
    }

    public void methodWithoutAnnotation(@Nullable String string) {
        Assert.fail("Event bus must not call methods without @Subscribe!");
    }

    public List<String> getEvents() {
        return events;
    }
}
