package org.cybersoft.buoi23;

import org.cybersoft.buoi23.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(name = "product", urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet {
    private final ArrayList<Product> products = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", this.products);

        req.getRequestDispatcher("product.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName = req.getParameter("product-name");
        String productQuantity = req.getParameter("product-quantity");
        String productPrice = req.getParameter("product-price");

        Product product = new Product(
                productName,
                Integer.parseInt(productQuantity),
                Double.parseDouble(productPrice)
        );
        this.products.add(product);

        resp.sendRedirect(req.getContextPath() + "/product");
    }
}
