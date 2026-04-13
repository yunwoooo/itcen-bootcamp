package day5;

public class MethodLab7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("호출1 : " + addEven(10, 2, 5, 13, 7));
		System.out.println("호출2 : " + addEven(11, 22, 33, 44, 55, 66));
		System.out.println("호출3 : " + addEven());
		System.out.println("호출4 : " + addEven(100, 101, 103));
	}
	
	static int addEven(int... nums) {
		int sum = 0;
		if (nums.length == 0) {
			return -1;
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] % 2 == 0) {
					sum += nums[i];
				}
			}
			return sum;
		}
	}
}
