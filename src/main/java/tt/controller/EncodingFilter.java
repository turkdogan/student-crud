package tt.controller;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/xhtml+xml");
        chain.doFilter(request, response);
    }

    public void destroy() {}  
}
