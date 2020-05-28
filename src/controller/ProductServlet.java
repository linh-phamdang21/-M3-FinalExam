package controller;

import dao.ProductDAOIpml;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    ProductDAOIpml productDAO = new ProductDAOIpml();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action){
            case "create":
                try {
                    insertProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "search":
                showSearchResult(request, response);
                break;
            case "edit":
                try {
                    updateProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "search":
                    showSearchForm(request, response);
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteProduct(request, response);
                    break;
                default:
                    listProduct(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Product> productList = productDAO.selectAllProducts();
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/listProduct.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/createProduct.jsp");
        dispatcher.forward(request, response);
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String color = request.getParameter("color");
        String des = request.getParameter("des");
        String category = request.getParameter("category");
        Product newProduct = new Product(name, price, quantity, color, category, des);
        productDAO.insertProduct(newProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/createProduct.jsp");
        dispatcher.forward(request, response);
    }

    protected void showSearchForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/searchProduct.jsp");
        dispatcher.forward(request, response);
    }

    protected void showSearchResult(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        int inputId = Integer.parseInt(request.getParameter("inputid"));
        Product product = productDAO.selectProduct(inputId);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/showSearchResult.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        productDAO.deleteProduct(id);

        List<Product> products = productDAO.selectAllProducts();
        request.setAttribute("productList", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/listProduct.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product existingProduct = productDAO.getProductById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/editProduct.jsp");
        request.setAttribute("product", existingProduct);
        dispatcher.forward(request, response);
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String color = request.getParameter("color");
        String des = request.getParameter("des");
        String category = request.getParameter("category");
        Product product = new Product(id, name, price, quantity, color, category, des);
        productDAO.updateProduct(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/editProduct.jsp");
        dispatcher.forward(request, response);
    }
}
