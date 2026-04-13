package day6;

class Product {
	String name;
	int balance;
	int price;
	
	Product() {
		this("듀크인형", 5, 10000);
	}
	Product(String name, int balance, int price) {
		this.name = name;
		this.balance = balance;
		this.price = price;
	}
	String getName() {
		return name;
	}
	int getBalance() {
		return balance;
	}
	int getPrice() {
		return price;
	}
	
}


public class ProductTest {
	
	public static void main(String[] args) {

		Product[] products = new Product[5];
		products[0] = new Product();
		products[1] = new Product("인형", 4, 1000);
		products[2] = new Product("사탕", 6, 300);
		products[3] = new Product("껌", 12, 1000);
		products[4] = new Product("텀블러", 1, 10000);
		String result;
		
		for (int i = 0; i < products.length; i++) {
			result = String.format("%,d", products[i].price);
			System.out.printf("%s\t%d\t%s원\n", products[i].name, products[i].balance, result);
		}
	}
}
