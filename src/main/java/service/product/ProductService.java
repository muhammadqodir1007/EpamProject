package service.product;

import entity.PeopleBean;
import entity.ProductBean;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    int addNews(ProductBean productBean) throws SQLException;
    List<ProductBean> getAll() throws SQLException;
    ProductBean getOne(int id) throws SQLException;
    int delete(int id) throws SQLException;
    int edit(int id);




}
