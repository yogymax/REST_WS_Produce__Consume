package com.scp.service;

import java.util.ArrayList;
import java.util.List;

import com.scp.bean.Product;
import com.scp.dao.ProductDAO;
import com.scp.dao.ProductDAOImpl;
import com.scp.entities.ProductEntity;

public class ProductServiceImpl implements ProductService {

	ProductDAO productDao = new ProductDAOImpl();
	
	
	@Override
	public Product addProduct(Product product) {
		return processEntityToBean(productDao.addProduct(processBeanToEntity(product))); 
	}

	private Product processEntityToBean(ProductEntity entity) {
		return new Product(entity.getProductId(), entity.getProductName(), 
				entity.getProductPrice(), entity.getProductCategory());
	}

	private List<Product> processEntityToBean(List<ProductEntity> entities) {
		List<Product> products = new ArrayList<>();
		for (ProductEntity entity : entities) {
			products.add(new Product(entity.getProductId(), entity.getProductName(), 
					entity.getProductPrice(), entity.getProductCategory()));
		}
		return products;
	}

	
	@Override
	public Product getProduct(int productId) {
		return processEntityToBean(productDao.getProduct(productId));
	}

	@Override
	public int deleteProduct(int productId) {
		return productDao.deleteProduct(productId);
	}

	@Override
	public Product updateProduct(Product product) {
		return processEntityToBean(productDao.updateProduct(processBeanToEntity(product)));
	}

	@Override
	public List<Product> getAllProducts() {
		return processEntityToBean(productDao.getAllProducts());
	}

	private ProductEntity processBeanToEntity(Product entity){
		return new ProductEntity(entity.getProductId(), entity.getProductName(), 
				entity.getProductPrice(), entity.getProductCategory());
	}
	
	
}
