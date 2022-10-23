package pl.limescode.app.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class DemoServlet implements Servlet {
    private static Logger logger = LoggerFactory.getLogger(DemoServlet.class);
    private transient ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        logger.info("Init in Demo Servlet");
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws
            ServletException, IOException {
        logger.info("New request for Demo Servlet");
        res.getWriter().println("<h1>Content of Demo Servlet</h1>");
    }

    @Override
    public String getServletInfo() {
        return "DemoServlet";
    }

    @Override
    public void destroy() {
        logger.info("Servlet {} destroyed", getServletInfo());
    }

}
