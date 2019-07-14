package vn.com.vietis.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import vn.com.vietis.dao.ProductManagementDAO;
import vn.com.vietis.pojo.Product;

public class WelcomeAction extends ActionSupport {

	private List<Product> products;

	public void initProducts() {
		products = ProductManagementDAO.getAllProducts();
		System.out.println(products.size());
	}

	public String execute() {
		initProducts();
		return "success";
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
