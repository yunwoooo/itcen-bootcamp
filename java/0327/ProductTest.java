package collection;
import java.util.HashSet;

public class ProductTest {
	public static void main(String[] args) {
        HashSet<Product> productSet = new HashSet<>();

        Product[] products = new Product[4];
        products[0] = new Product("p100", "TV", 20000);
        products[1] = new Product("p200", "Computer", 10000);
        products[2] =  new Product("p100", "MP3", 700);
        products[3] = new Product("p300", "Audio", 1000);

        for (Product p : products) {
            boolean isAdded = productSet.add(p);
            
            if (isAdded) {
                System.out.println("성공적으로 저장되었습니다.");
            } else {
                System.out.println("동일한 ID의 제품이 이미 저장되어 있습니다.");
            }
        }

        System.out.println(); 
        System.out.println("제품 ID  \t  제품명  \t  가격");
        System.out.println("----------------------------------------");
        
        for (Product p : productSet) {
            System.out.printf("%-10s\t%-10s\t%,10d%n", p.getProductID(), p.getProductName(), p.getProductPrice());
        }
	}
}
