public class SearchInRotatedArray {
    public static int searchLengthysolution(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            if (nums[l] <= nums[h]) {
                return checkInSortedArray(l, h, nums, target);
            }
            int mid = l + (h - l) / 2;
            if (nums[l] <= nums[mid]) {
                if (nums[l] == target)
                    return l;
                if (nums[mid] == target)
                    return mid;
                if (nums[l] < target && nums[mid] > target) {
                    return checkInSortedArray(l, mid, nums, target);
                } else {
                    l = mid + 1;
                }
            }
            if (nums[mid] <= nums[h]) {
                if (nums[h] == target)
                    return h;
                if (nums[mid] == target)
                    return mid;
                if (nums[mid] < target && nums[h] > target) {
                    return checkInSortedArray(mid, h, nums, target);
                } else {
                    h = mid - 1;
                }
            }

        }

        return -1;
    }

    public static int checkInSortedArray(int l, int h, int[] nums, int target) {
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return -1;
    }

//--------------------------------------------------------------//

    public static int searchOptimised(int[] nums, int target) {
        return m(nums, target, 0, nums.length - 1);
    }
    public static int m(int[] nums, int target, int l, int h) {
        if (l > h)
            return -1;
        if (nums[l] == target)
            return l;
        if (nums[h] == target)
            return h;
        if (l == h && nums[l] != target)
            return -1;
        int mid = l + (h - l) / 2;

        int left = m(nums, target, l, mid);
        int right = m(nums, target, mid + 1, h);
        if (left != -1 && right == -1)
            return left;
        if (right != -1 && left == -1)
            return right;
        return -1;

    }

    //=----------------------------------------------------------------------------------------//
     public static void main(String[] args) {
        int[] nums = { 3, 5, 1 };
        System.out.println(searchLengthysolution(nums, 3));
    }

}





