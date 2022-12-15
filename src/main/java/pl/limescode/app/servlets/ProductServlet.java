package pl.limescode.app.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.limescode.app.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(ProductServlet.class);

    private List<Product> products = new ArrayList<>();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.printf("<html><body>");
        out.printf("<h1>Products </h1>");
        out.printf("<table border=\"1\" cellpadding=\"10\">");
        out.printf("<tr><th>Id</th><th>Title</th><th>Cost</th></tr>");
        for (Product p : products) {
            out.printf("" +
                    "<tr><td>" + p.getId() +
                    "</td><td>" + p.getTitle() +
                    "</td><td>" + p.getCost() +
                    "</td></tr>");
        }
        out.printf("</table>");
        out.printf("</body></html>");
        out.close();
    }

    @Override
    public void init() throws ServletException {
        for (int i = 1; i <= 10; i++) {
            products.add(new Product(i, "Product " + i, BigDecimal.valueOf(i * 10)));
        }
        logger.debug("Initialized ProductServlet");
    }
}
