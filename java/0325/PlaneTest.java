package work;

public class PlaneTest {
	public static void main(String[] args) {
		Plane[] planes = new Plane[2];
		planes[0] = new Airplane("L747", 1000);
		planes[1] = new Cargoplane("C40", 1000);
		printInfo(planes);
		System.out.println("[100 운항]");
		planes[0].flight(100);
		planes[1].flight(100);
		printInfo(planes);
		System.out.println("[200 주유]");
		planes[0].refuel(200);
		planes[1].refuel(200);
		printInfo(planes);
	}
	public static void printInfo(Plane[] list) {
		System.out.println("Plane  \t  fuelSize");
		System.out.println("--------------------------------");
		for (int i = 0; i < list.length; i ++)
			System.out.printf("%s  \t  %s\n", list[i].getPlaneName(), list[i].getFuelSize());
		System.out.println();
	}
}
