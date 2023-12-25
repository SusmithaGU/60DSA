public class SortColors {
    public void sortColors(int[] nums) {

        int red = 0;
        int white = 0;
        int blue = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                red++;
            if (nums[i] == 1)
                white++;
            if (nums[i] == 2)
                blue++;
        }
        int i = 0;
        while (red > 0) {
            nums[i] = 0;
            red--;
            i++;
        }
        while (white > 0) {
            nums[i] = 1;
            white--;
            i++;
        }
        while (blue > 0) {
            nums[i] = 2;
            blue--;
            i++;
        }

    }

    public void swap(int[] nums, int idx, int i) {
        int temp = nums[idx];
        nums[idx] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums={2,0,2,1,1,0};
        SortColors s=new SortColors();
        s.sortColors(nums);
        System.out.println("");
    }
}
