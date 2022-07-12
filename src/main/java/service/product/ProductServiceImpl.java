package service.product;

import database.DB;
import entity.Product;
import entity.Publisher;
import org.apache.tomcat.util.codec.binary.Base64;
import payload.ProductResponse;

import javax.swing.plaf.PanelUI;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private static final String GET_ALL_PRODUCTS = "SELECT product.id, titles, textdata, description, sourcelinkto, photofile,created_at, category.name\n" +
            "\tFROM public.product inner join category on product.category_id=category.id";
    private static final String GET_PRODUCT_LATEST_ONE = "SELECT id, titles, textdata, description, sourcelinkto, photofile, created_at, updated_at, category_id\n" +
            "\tFROM public.product where created_at=(select max(created_at) from public.product)";
    private static final String GET_CATEGORY_NAME = "SELECT name\tFROM public.product inner join category on category.id=product.category_id\n" +
            "where product.category_id=?";
    private static final String PRODUCT_ID = "SELECT titles, textdata, description, \"sourcelinkto\", photofile, created_at, updated_at, category_id\n" +
            "\tFROM public.product where id=?";
    private static final String GET_PRODUCTS_BY_TITLE = "SELECT id, titles, textdata, description, \"sourcelinkto\", photofile, created_at, updated_at, category_id\n" +
            "\tFROM public.product where titles like '%?%'";
    private static final String LAST_PRODUCTS = "SELECT id, titles FROM public.product order by created_at desc limit 6 ";
    private static final String GET_PUBLISHER_BY_PRODUCT_ID = "SELECT publisher.id, " +
            "nameof, address, publisher.description, phonenumber, email, password\n" +
            "\tFROM public.publisher inner join product on" +
            " product.publisher_id=publisher.id where product.id=?";
    private static final String GET_PUBLISHER_BY_ID="SELECT id, nameof, address, description, phonenumber, email, password, created_at, updated_at\n" +
            "\tFROM public.publisher where id=?";


    public ResultSet getresultSet(String query) throws SQLException {
        Connection connection = DB.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();
        return rs;
    }

    public PreparedStatement getstatement(String query) throws SQLException {
        Connection connection = DB.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement;
    }

    public Product getProduct(ResultSet resultSet) throws SQLException, UnsupportedEncodingException {
        Product product = null;
        Long id = resultSet.getLong("id");
        String titles = resultSet.getString("titles");
        String description = resultSet.getString("description");
        String sourcelinkTo = resultSet.getString("sourcelinkto");
        String photofile = new String(Base64.encodeBase64(resultSet.getBytes("photofile")), "UTF-8");
        Date created_at = resultSet.getTimestamp("created_at");
        Date updated_at = resultSet.getDate("updated_at");
        product = new Product(id, titles, description, sourcelinkTo, photofile, created_at, updated_at);
        return product;
    }

    @Override
    public Product getOneProduct() {
        List<Product> productList = new ArrayList<>();
        try {
            ResultSet resultSet = getresultSet(GET_PRODUCT_LATEST_ONE);
            while (resultSet.next()) {
                productList.add(getProduct(resultSet));
            }
        } catch (SQLException | UnsupportedEncodingException exception) {
            DB.printSQLException((SQLException) exception);
        }
        return productList.get(0);
    }

    @Override
    public List<ProductResponse> getAllProduct() {
        List<ProductResponse> productResponses = new ArrayList<>();
        try {
            ResultSet rs = getresultSet(GET_ALL_PRODUCTS);
            while (rs.next()) {
                long id = rs.getLong("id");
                String titles = rs.getString("titles");
                String description = rs.getString("description");
                String sourcelinkTo = rs.getString("sourcelinkto");
                String photofile = new String(Base64.encodeBase64(rs.getBytes("photofile")), "UTF-8");
                String name = rs.getString("name");
                Date created_at = rs.getTimestamp("created_at");
                productResponses.add(new ProductResponse(id, titles, description,
                        sourcelinkTo, photofile, name, created_at));
            }
        } catch (SQLException | UnsupportedEncodingException exception) {
            DB.printSQLException((SQLException) exception);
        }
        return productResponses;
    }

    @Override
    public Product getProductByID(long id) {
        Product product = new Product();
        try (PreparedStatement preparedStatement = getstatement(PRODUCT_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                product.setTitles(resultSet.getString("titles"));
                product.setTextData(resultSet.getString("textData"));
                product.setDescription(resultSet.getString("description"));
                product.setSourcelinkTo(resultSet.getString("sourcelinkto"));
                product.setPhotofile(new String(Base64.encodeBase64(resultSet.getBytes("photofile")), "UTF-8"));
                product.setCreated_at(resultSet.getDate("created_at"));
                product.setUpdated_at(resultSet.getDate("updated_at"));
            }
        } catch (SQLException | UnsupportedEncodingException exception) {
            DB.printSQLException((SQLException) exception);
        }
        return product;
    }

    @Override
    public List<Product> getProductByTitleandCategory(String simplest,int category_id) {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = getstatement("SELECT product.id, titles, textdata," +
                    " description, sourcelinkto, photofile, created_at, updated_at, category.name\n" +
                    "\tFROM public.product inner join category on" +
                    " category.id=product.category_id where titles like '%"+simplest+"%' and category_id="+category_id+"");

            ResultSet set = preparedStatement.executeQuery();
            while (set.next()) {
                products.add(getProduct(set));
            }
        } catch (SQLException | UnsupportedEncodingException exception) {
            DB.printSQLException((SQLException) exception);
        }
        return products;
    }
    @Override
    public List<Product> getProductByTitles(String simplest)
    {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = getstatement("SELECT product.id, titles, textdata," +
                    " description, sourcelinkto, photofile, created_at, updated_at, category.name\n" +
                    "\tFROM public.product inner join category on" +
                    " category.id=product.category_id where titles like '%"+simplest+"%'");

            ResultSet set = preparedStatement.executeQuery();
            while (set.next()) {
                products.add(getProduct(set));
            }
        } catch (SQLException | UnsupportedEncodingException exception) {
            DB.printSQLException((SQLException) exception);
        }
        return products;
    }

    @Override
    public List<Product> showLastsixProduct() {
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = getstatement(LAST_PRODUCTS);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next())
            {
                long id=resultSet.getLong("id");
                String titless=resultSet.getString("titles");
                productList.add(new Product(id,titless));
            }
        }
        catch(SQLException exception){
            DB.printSQLException(exception);
        }
        return productList;
    }

}
