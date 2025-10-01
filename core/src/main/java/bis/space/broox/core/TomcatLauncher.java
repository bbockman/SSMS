package bis.space.broox.core;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.servlets.DefaultServlet;

import java.io.File;

public class TomcatLauncher {
    public static void main(String[] args) {
        try {
            Tomcat tomcat = new Tomcat();
            tomcat.setBaseDir("tomcat"); // Set Tomcat's base directory
            Connector conn = new Connector();
            conn.setPort(8080);
            tomcat.setConnector(conn);

            // Set up context root from app/src/main/webapp
            File ctxRoot = new File(args[0]).getAbsoluteFile();
            Context context = tomcat.addContext("", ctxRoot.getAbsolutePath());

            // Register Tomcat's DefaultServlet for static content
            context.addServletContainerInitializer((c, ctx) -> {
                ctx.addServlet("default", new DefaultServlet())
                        .addMapping("/");
            }, null);

            context.addServletContainerInitializer((c, ctx) -> {
                ctx.addServlet("command", new HelloServlet())
                        .addMapping("/command/*");
            }, null);

            tomcat.start();
            System.out.println("Tomcat started on http://localhost:8080/ (static files) and /hello (servlet)");
            tomcat.getServer().await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
