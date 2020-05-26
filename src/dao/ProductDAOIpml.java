package dao;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOIpml implements IProductDAO{

    private static final String jdbcURL = "jdbc:mysql://localhost:3306/m3_finalexam";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "admin123";

    private static final String SELECT_USER_BY_ID = "select * from Product where id = ?";
    private static final String SELECT_ALL_PRODUCTS = "select * from Product";
    private static final String INSERT_PRODUCT_SQL = "insert into Product(name, price, quantity, color, category, description) values (?,?,?,?,?,?)";
    private static final String DELETE_PRODUCT_SQL = "delete from Product where id = ?;";
    private static final String UPDATE_USERS_SQL = "update Product set name = ?, price= ?, quantity =?, color = ?, category=?, des =?  where id = ?;";
    boolean rowDeleted;
    boolean rowUpdated;

    protected Connection getConnectDB() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Product> selectAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            Connection conn = getConnectDB();
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_PRODUCTS);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String category = rs.getString("category");
                String des = rs.getString("des");
                products.add(new Product(id, name, price, quantity, color, category, des));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void insertProduct(Product product) throws SQLException {
        try {
            //Product newProduct = new Product(name, price, quantity, color, category);
            Connection conn = getConnectDB();
            PreparedStatement preparedStatement = conn.prepareStatement(INSERT_PRODUCT_SQL);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getCategory());
            preparedStatement.setString(6, product.getDes());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product selectProduct(int inputid) {
        Product product = null;
        try {
            Connection conn = getConnectDB();
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, inputid);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String category = rs.getString("category");
                String des = rs.getString("des");
                product = new Product(id, name, price, quantity, color, category, des);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        try {
            Connection conn = getConnectDB();
            PreparedStatement preparedStatement = conn.prepareStatement(DELETE_PRODUCT_SQL);
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        try {
            Connection conn = getConnectDB();
            PreparedStatement preparedStatement = conn.prepareStatement(INSERT_PRODUCT_SQL);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getCategory());
            preparedStatement.setString(6, product.getDes());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public Product getProductById(int inputid) {
        Product product = null;
        String query = "{call get_user_by_id(?)}";
        try {
            Connection connection = getConnectDB();
            PreparedStatement ps = connection.prepareStatement(SELECT_USER_BY_ID);
            ps.setInt(1,inputid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String category = rs.getString("category");
                String des = rs.getString("des");
                product = new Product(id, name, price, quantity, color, category, des);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return product;
    }
}
