package collection;

import java.util.*;

public class Product {
		private String productID;
	    private String productName;
	    private int productPrice;

	    public Product(String productID, String productName, int productPrice) {
	        this.productID = productID;
	        this.productName = productName;
	        this.productPrice = productPrice;
	    }

	    public String getProductID() {
	        return productID;
	    }

	    public String getProductName() {
	        return productName;
	    }

	    public int getProductPrice() {
	        return productPrice;
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(productID);
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) 
	        	return true;
	        if (obj == null || getClass() != obj.getClass()) 
	        	return false;
	        Product product = (Product) obj;
	        return Objects.equals(productID, product.productID);
	    }
}
