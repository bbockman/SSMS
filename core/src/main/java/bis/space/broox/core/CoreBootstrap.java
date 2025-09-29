package bis.space.broox.core;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.http.HttpServlet;

public abstract class CoreBootstrap implements ServletContextListener {

    private Injector injector;

    // app must provide its module
    protected abstract Module getAppModule();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        injector = Guice.createInjector(getAppModule());
        sce.getServletContext().setAttribute("guice-injector", injector); // store it here
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        injector = null;
    }

    public Injector getInjector() {
        return injector;
    }

    private void injectServlets(ServletContext context) {
        context.getServletRegistrations().forEach((name, reg) -> {
            try {
                Class<?> clazz = Class.forName(reg.getClassName());
                if (HttpServlet.class.isAssignableFrom(clazz)) {
                    HttpServlet servlet = context.createServlet((Class<? extends HttpServlet>) clazz);
                    injector.injectMembers(servlet);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
