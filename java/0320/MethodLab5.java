package day5;

public class MethodLab5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums1 = maxNumArray(new int[]{10, 20, 30});
		int nums2 = maxNumArray(new int[]{100, 500, 300, 200, 400});
		int nums3 = maxNumArray(new int[]{1, 10, 3, 4, 5, 8, 7, 6, 9, 2});
		int[] nums = new int[] {nums1, nums2, nums3};
		
		for (int i = 0; i < nums.length; i++) {
			System.out.printf("가장 큰 값은 %d 입니다.\n", nums[i]);
		}
	}
	
	static int maxNumArray(int[] ary) {
		int max = 0;
		for (int i = 0; i < ary.length; i++) {
			if (ary[i] > max)
				max = ary[i];
		}
		return max;
	}
}
