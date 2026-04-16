package day8;

public class TVTest {
	public static void main(String[] args) {
		SaleTV tv1 = new SaleTV(300000, "SALETV-1", 40, 1);
		RentalTV tv2 = new RentalTV(100000, "RENTALTV-10", 42, 1);
		tv1.channelUp();
		tv1.channelUp();
		tv2.channelDown();
		tv2.channelDown();
		tv2.channelDown();
		printAll(tv1);
		printAll(tv2);
		printRentalTV(tv2);
	}
	static void printAll(TV tv) {
		System.out.println(tv.toString());
		if (tv instanceof SaleTV)
			((SaleTV) tv).play();
		else
			((RentalTV) tv).play();
		if (tv instanceof SaleTV)
			((SaleTV) tv).sale();
	}
	static void printRentalTV(Rentable tv) {
		tv.rent();
	}
}
