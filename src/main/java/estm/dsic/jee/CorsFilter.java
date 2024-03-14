package estm.dsic.jee;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebFilter("/*")
public class CorsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
                System.out.println("CorsFilter is active!");
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Allow requests from any origin
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        // Allow specific methods
        httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        // Allow specific headers
        httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        // Allow credentials
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");

        // Continue the filter chain
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
    }
}
