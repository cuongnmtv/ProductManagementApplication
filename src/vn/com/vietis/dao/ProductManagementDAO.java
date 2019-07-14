package vn.com.vietis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.net.aso.p;
import vn.com.vietis.pojo.Product;
import vn.com.vietis.util.DBUtil;

public class ProductManagementDAO {

	public static List<Product> getAllProducts() {
		List<Product> productList = new ArrayList<Product>();
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from product");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setProductId(rs.getString("PROD_ID"));
				p.setProductCategory(rs.getString("PROD_CATEGORY"));
				p.setProductName(rs.getString("PROD_NAME"));
				p.setProductPrice(rs.getInt("PROD_PRICE"));
				productList.add(p);
			}
			DBUtil.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}

	public static int addProduct(Product product) {
		int status = 0;
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "insert into product values (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getProductCategory());
			ps.setInt(4, product.getProductPrice());
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static Product getProductById(String productId) {
		Product p = null;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from product where PROD_ID = ?");
			ps.setString(1, productId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p = new Product();
				p.setProductCategory(rs.getString("PROD_CATEGORY"));
				p.setProductId(rs.getString("PROD_ID"));
				p.setProductPrice(rs.getInt("PROD_PRICE"));
				p.setProductName(rs.getString("PROD_NAMe"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	public static int updateProduct(Product product) {
		int status = 0;
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "update product set PROD_NAME = ?, PROD_CATEGORY = ?, PROD_PRICE = ? where PROD_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getProductCategory());
			ps.setInt(3, product.getProductPrice());
			ps.setString(4, product.getProductId());
			status = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static int deleteProduct(String productId) {
		int status = 0;
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "delete from product where PROD_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, productId);
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
