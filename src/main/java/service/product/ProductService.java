package service.product;

import entity.Product;
import payload.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProduct();
    Product getProductByID(long id);
    List<Product> getProductByTitleandCategory(String sampletitle,int category_id);
    List<Product> getProductByTitles(String sampletitle);
    Product getOneProduct();
    List<Product> showLastsixProduct();
}
