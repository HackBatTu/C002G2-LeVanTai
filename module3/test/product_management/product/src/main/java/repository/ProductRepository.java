package repository;

import model.Category;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{
    private DBConnect dbConnect = new DBConnect();
    private static  final String SELECT_ALL_PRODUCT = " select product.* , category.category_name from product " +
            " join category on category.category_id = product.category_id where product.status = 0;";
    private static  final String SELECT_ALL_CATEGORY = " select * from category where status = 0;";
    private static  final String INSERT_INTO = " insert into product(product_id,product_name,price,quality,color,product.category_id) value (?,?,?,?,?,?)";
    private static  final String UPDATE = " update product set product_name=?,price=?,quality=?,color=?,product.category_id=? where product_id=?;";
    private static final String SELECT_BY_ID = " select * from product where product_id = ? ;";
    private static final String DELETE_PRODUCT = " update product set status = 1 where product_id=?;";
    private static  final String SEARCH_BY_NAME = " select product.* , category.category_name from product " +
            " join category on category.category_id = product.category_id " +
            " where product.product_name like ?;";


    @Override
    public List<Product> getAllProduct() {
        Connection connection = dbConnect.getConnection();
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
               int id = resultSet.getInt("product_id");
               String name= resultSet.getString("product_name");
               double price = resultSet.getDouble("price");
               int quality = resultSet.getInt("quality");
               String color = resultSet.getString("color");
               int category = resultSet.getInt("category_id");
               String categoryName = resultSet.getString("category_name");
               productList.add(new Product(id,name,price,quality,color,new Category(category,categoryName)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Category> getAllCategory() {
        Connection connection = dbConnect.getConnection();
        List<Category> categoryList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("category_id");
                String name= resultSet.getString("category_name");
                categoryList.add(new Category(id,name));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    @Override
    public void insert(Product product) {
        Connection connection = dbConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setInt(1,product.getId());
            preparedStatement.setString(2,product.getName());
            preparedStatement.setDouble(3,product.getPrice());
            preparedStatement.setInt(4,product.getQuality());
            preparedStatement.setString(5,product.getColor());
            preparedStatement.setInt(6,product.getCategory().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProduct(Product product) {
        Connection connection = dbConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setInt(3,product.getQuality());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setInt(5,product.getCategory().getId());
            preparedStatement.setInt(6,product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product findById(int idEdit) {
        Product product = null;
        Connection connection = dbConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, idEdit);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("product_id");
                String name = resultSet.getString("product_name");
                double price = resultSet.getDouble("price");
                int quality = resultSet.getInt("quality");
                String color = resultSet.getString("color");
                int category = resultSet.getInt("category_id");
                product =new Product(id, name, price,quality,color,new Category(category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void delete(int id) {
        Connection connection = dbConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Product> searchByName(String name) {
        Connection connection = dbConnect.getConnection();
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME);
            preparedStatement.setString(1,"%" + name +"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("product_id");
                String names = resultSet.getString("product_name");
                double price = resultSet.getDouble("price");
                int quality = resultSet.getInt("quality");
                String color = resultSet.getString("color");
                int category = resultSet.getInt("category_id");
                productList.add(new Product(id, names, price,quality,color,new Category(category)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
