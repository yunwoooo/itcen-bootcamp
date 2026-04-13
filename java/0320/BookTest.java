package day5;

class Book {
	String title;
	String author;
	int price;
	
	Book() {
		title = "자바의 정석";
		author = "남궁성";
		price = 36000;
	}
	Book(String title, String author, int price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	String getBookInfo() {
		return title + "\t" + author + "\t" + price + "원";
	}
}

public class BookTest {

	public static void main(String[] args) {
		Book book1 = new Book();
		Book book2 = new Book("햄닛", "매기 오패럴", 16500);
		Book book3 = new Book("내 강아지의 사생활", "엘리슨 프렌드", 27000);
		Book book4 = new Book("불안", "알랭 드 보통", 16200);
		Book book5 = new Book("우리가 사랑한 도시", "김지윤, 전은환", 15750);
		System.out.println(book1.getBookInfo());
		System.out.println(book2.getBookInfo());
		System.out.println(book3.getBookInfo());
		System.out.println(book4.getBookInfo());
		System.out.println(book5.getBookInfo());
	}

}
