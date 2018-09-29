package com.user.controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.dao.ProductDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import com.user.model.Product;

@WebServlet("/welcome")
public class WelcomeServlet  extends HttpServlet {

    private ProductDAO dao;
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public void init() throws ServletException {
        dao = new ProductDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.sendRedirect("WEB-INF/Welcome.jsp");
        List<Product> ps = dao.getAllProducts();
        for (Product p : ps){
            System.out.println(p.getName());
        }

        req.setAttribute("products", dao.getAllProducts());
        RequestDispatcher view = req.getRequestDispatcher("Welcome.jsp");
        view.forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//		https://my-json-server.typicode.com/iVanea/phones/db
        String jsonString = request.getParameter("product");
        Product product = mapper.readValue(jsonString, Product.class);
        product.setId(dao.genId());
        dao.addProduct(product);

        PrintWriter out =response.getWriter();
        try{
            out.print(mapper.writeValueAsString(product));
        }catch (JsonGenerationException e) {
            e.printStackTrace();
        }

    }
}
