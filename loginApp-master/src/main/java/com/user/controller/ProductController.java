package com.user.controller;

import com.user.dao.ProductDAO;
import com.user.model.Product;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ProductController
 */
@WebServlet({ "/product", "" })
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductDAO dao;
	ObjectMapper mapper = new ObjectMapper();

	@Override
	public void init() throws ServletException {
		dao = new ProductDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("products", dao.getAllProducts());
		RequestDispatcher view = request.getRequestDispatcher("Welcome.jsp");
		view.forward(request, response);
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
