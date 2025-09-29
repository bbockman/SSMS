package bis.space.broox.core;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface CommandProcessor {
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
