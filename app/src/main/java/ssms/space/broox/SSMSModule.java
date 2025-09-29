package ssms.space.broox;

import bis.space.broox.core.CommandProcessor;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;

public class SSMSModule extends AbstractModule {
    @Override
    protected void configure() {
        MapBinder<String, CommandProcessor> mapBinder = MapBinder.newMapBinder(binder(),
                String.class,
                CommandProcessor.class);

        mapBinder.addBinding("login").to(LoginCP.class);
    }
}