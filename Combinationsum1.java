import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of distinct integers candidates and a target integer target, 
return a list of all unique combinations of candidates where the chosen numbers sum to target. 
You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. 
Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations 
that sum up to target is less than 150 combinations for the given input.

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]] 
*/

public class Combinationsum1 {
    static List<List<Integer>> ans = new ArrayList<>();
    static ArrayList<Integer> temp = new ArrayList<Integer>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        utilOptimal(candidates, target, 0);
        return ans;
    }

    // 2ms solution
    public static void util(int[] nums, int target, int idx) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        int i;
        for (i = idx; i < nums.length; i++) {
            if (nums[i] <= target) {
                temp.add(nums[i]);
                util(nums, target - nums[i], i);
                temp.remove(temp.size() - 1);
            }
        }
    }

    // 1ms solution
    public static void utilOptimal(int[] nums, int target, int i) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (i == nums.length)
            return;

        if (nums[i] <= target) {
            temp.add(nums[i]);
            // take the number
            util(nums, target - nums[i], i);
            temp.remove(temp.size() - 1);
        }
        // don't take the number and move on
        utilOptimal(nums, target, i + 1);
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 6, 7 };
        List<List<Integer>> a = combinationSum(nums, 7);
        System.out.println("completed");
    }
}
