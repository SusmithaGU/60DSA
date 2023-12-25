import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of candidate numbers (candidates) and a target number (target), 
find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

Note that there are two 1's in the input and it is not a repetition 
*/

public class CombinationSum2 {
    static List<List<Integer>> ans = new ArrayList<>();
    static ArrayList<Integer> temp = new ArrayList<Integer>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        util(candidates, target, 0);
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
            if (i > idx && nums[i] == nums[i - 1]) //To check there are no duplicates which generate
                continue;                          //same list or list with same numbers 
            if (nums[i] <= target) {
                temp.add(nums[i]);
                util(nums, target - nums[i], i + 1);//passing in next i to not use same no again
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 10, 1, 2, 7, 6, 1, 5 };  
        List<List<Integer>> a =combinationSum(nums, 8);
        System.out.println("completed");
    }
}
