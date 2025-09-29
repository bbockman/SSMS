package bis.space.broox.core;

import java.io.IOException;
import java.util.Map;

import com.google.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;

public class ControllerServlet extends HttpServlet {

    private static final String CONTENT_TYPE =	"text/html;charset=windows-1252";
    private static final Logger logger = LoggerFactory.getLogger(ControllerServlet.class);

    @Inject
    private Map<String, CommandProcessor> commands;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandCP, view;

        commandCP = request.getParameter("ParameterActionCommand");
        if (commandCP != null) {
            //	Added	security	to	avoid	mal	invocation	of	the	commands.
            try {
                CommandProcessor bisCommand = commands.get(commandCP);
                view = bisCommand.execute(request, response);
                if (view == null || view.trim().equalsIgnoreCase("")) {
                    view = "BisError"; //	Add	error	message	in	session	and	display	that	in	the	jsp.
                    logger.debug("A null value returned for view");
                }
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/BisHome.jsp?prmDynInclPage=" + view );
                requestDispatcher.forward(request, response);
            } catch (ClassNotFoundException | InstantiationException e) {
                logger.error(e.getMessage());
            } catch (Exception e) {
                logger.debug("Unplanned exception type in ControllerServlet");
                logger.error(e.getMessage());
            }
        } else {
            logger.error(MarkerFactory.getMarker("FATAL"), "Action command is null");
        }
    }
}

