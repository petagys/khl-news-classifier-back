package KHLNews.corsFilter;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
class CORSFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
            HttpServletResponse response = (HttpServletResponse) res;
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS");
            response.setHeader("Access-Control-Allow-Headers", "Origin,Accept"
            + "X-Requested-With, Content-Type, Access-Control-Request-Method,Access-Control-Request-Headers");
        if(((HttpServletRequest) req).getMethod().equalsIgnoreCase("Options")){
            response.setStatus(200);
        }else{
            chain.doFilter(req, res);
        }
    }
    @Override
    public void destroy(){}

//    @Override
//    public void init(FilterConfig config) throws ServletException{}
}
