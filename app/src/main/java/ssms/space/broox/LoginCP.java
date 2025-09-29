package ssms.space.broox;

import bis.space.broox.core.CommandProcessor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginCP implements CommandProcessor {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // Implement login logic here
        return "Login successful";
    }
}
