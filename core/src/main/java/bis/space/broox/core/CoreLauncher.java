package bis.space.broox.core;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.servlets.DefaultServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class CoreLauncher {
    static Logger logger = LoggerFactory.getLogger(CoreLauncher.class);

    public static void start(Module serverModule) {
        String webapp = "app/src/main/webapp";
        String contextPath = "";
        int port = 8080;

        Injector injector = Guice.createInjector(serverModule);

        var controllerServlet = injector.getInstance(ControllerServlet.class);

        Tomcat tomcat = new Tomcat();
        File baseDir = new File(System.getProperty("java.io.tmpdir"));
        tomcat.setBaseDir(baseDir.getAbsolutePath());
        logger.info("Setting Tomcat base dir to {}", baseDir.getAbsolutePath());

        Connector conn = new Connector();
        conn.setPort(port);
        tomcat.setConnector(conn);
        logger.info("Setting Tomcat port to {}", port);

        // Set up context root from app/src/main/webapp
        File ctxRoot = new File(webapp).getAbsoluteFile();
        Context context = tomcat.addContext(contextPath, ctxRoot.getAbsolutePath());
        logger.info("Setting Tomcat context root to {}", ctxRoot.getAbsolutePath());

        // Register Tomcat's DefaultServlet for static content
        context.addServletContainerInitializer((c, ctx) -> {
            ctx.addServlet("default", new DefaultServlet())
                    .addMapping("/");
        }, null);

        context.addServletContainerInitializer((c, ctx) -> {
            ctx.addServlet("hello", new HelloServlet())
                    .addMapping("/hello");
        }, null);

        context.addServletContainerInitializer((c, ctx) -> {
            ctx.addServlet("command", controllerServlet)
                    .addMapping("/command/*");
        }, null);
        logger.info("Servlets registered: DefaultServlet (/), HelloServlet (/hello), ControllerServlet (/command/*)");

        try {
            tomcat.start();
            logger.info("Tomcat started on http://localhost:{}/ (static files) and /hello (servlet)", port);
            tomcat.getServer().await();
        } catch (Exception e) {
            logger.error("Error starting Tomcat", e);
        }
    }
}
