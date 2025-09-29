package bis.space.broox.core;

import java.io.IOException;
import java.util.Map;

import com.google.inject.Inject;
import com.google.inject.Injector;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControllerServlet extends HttpServlet {

    private static final String CONTENT_TYPE =	"text/html;charset=windows-1252";
    private static final Logger logger = LoggerFactory.getLogger(ControllerServlet.class);

    @Inject
    private Map<String, CommandProcessor> commands;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        // Get injector from context
        Injector injector = (Injector) config.getServletContext().getAttribute("guice-injector");

        // Retrieve the Map<String, CommandProcessor>
        if (injector != null) {
            commands = injector.getInstance(
                    com.google.inject.Key.get(
                            new com.google.inject.TypeLiteral<Map<String, CommandProcessor>>() {}
                    )
            );
        }
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=windows-1252");

        String commandCP = request.getParameter("ParameterActionCommand");

        if (commandCP == null) {
            response.getWriter().println("No ParameterActionCommand provided");
            return;
        }

        if (commands == null) {
            response.getWriter().println("Commands map not injected!");
            return;
        }

        CommandProcessor cp = commands.get(commandCP);
        if (cp == null) {
            response.getWriter().println("Unknown command: " + commandCP);
            return;
        }

        try {
            String view = cp.execute(request, response);

            if (view == null || view.trim().isEmpty()) {
                view = "BisError";
            }

            // Forward to JSP if it exists, else fallback to plain text
            if (getServletContext().getResource("/BisHome.jsp") != null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/BisHome.jsp?prmDynInclPage=" + view);
                dispatcher.forward(request, response);
            } else {
                response.getWriter().println("Executed command: " + commandCP + ", view=" + view);
            }

        } catch (Exception e) {
            response.getWriter().println("Error executing command: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

