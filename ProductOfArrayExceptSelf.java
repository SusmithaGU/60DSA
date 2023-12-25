public class ProductOfArrayExceptSelf {
    public static int[] solution(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int i;
        result[0] = 1;
        for (i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (i = n - 1; i >= 0; i--) {
            result[i] = right * result[i];
            right = right * nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        solution(nums);
        System.out.println("finished");
    }
}
