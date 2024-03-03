package buitienanh.edu.vn.dao;

import java.util.List;

import buitienanh.edu.vn.entity.Product;

public interface ProductDao {

	public List<Product> getallproduct();
	public Product getProductById(String id);
	public boolean insertProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(String id);
}
