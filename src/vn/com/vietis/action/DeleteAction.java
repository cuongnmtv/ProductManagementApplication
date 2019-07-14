package vn.com.vietis.action;

import com.opensymphony.xwork2.ActionSupport;

import vn.com.vietis.dao.ProductManagementDAO;

public class DeleteAction extends ActionSupport {

	private String productId;

	public String execute() {
		String statusCode = "error";
		int recordDeleted = ProductManagementDAO.deleteProduct(productId);
		if (recordDeleted == 1) {
			statusCode = "success";
		}
		return statusCode;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

}
