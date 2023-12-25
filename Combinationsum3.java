import java.util.ArrayList;
import java.util.List;


/*
 * Find all valid combinations of k numbers that sum up to n such that the 
 * following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. 
The list must not contain the same combination twice, and the combinations may be returned in any order.

Example:
Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
 */

public class Combinationsum3 {
	// basic solution
	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> ans = new ArrayList<>();
		combination(ans, new ArrayList<Integer>(), k, 1, n);
		return ans;
	}

	private static void combination(List<List<Integer>> ans, List<Integer> comb, int k, int start, int n) {
		if (comb.size() == k && n == 0) {
			List<Integer> li = new ArrayList<Integer>(comb);
			ans.add(li);
			return;
		}
		for (int i = start; i <= 9; i++) {
			comb.add(i);
			combination(ans, comb, k, i + 1, n - i);
			comb.remove(comb.size() - 1);
		}
	}

	// optimal solution
	public static List<List<Integer>> comb(int k, int n) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		optimalUtil(0, k, n, arr, ans, temp);
		return ans;
	}

	private static void optimalUtil(int idx, int reqSize, int target, int[] arr, List<List<Integer>> ans,
			List<Integer> temp) {
		if (idx == arr.length) {
			if (temp.size() == reqSize && target == 0) {
				ans.add(new ArrayList<>(temp));
			}
			return; // return if we have used all no.s and avoid more recursions
			// when the target goes to negative number or is still positive
			// which happens when the size of elements in temp is more than
			// required size or when the combination of no.s in the temp don't sum up to
			// target
		}

		temp.add(arr[idx]);
		// take the element at idx index
		optimalUtil(idx + 1, reqSize, target - arr[idx], arr, ans, temp);
		temp.remove(temp.size() - 1);
		// don't take the element at idx index
		optimalUtil(idx + 1, reqSize, target, arr, ans, temp);
	}

	public static void main(String[] args) {
		List<List<Integer>> a = comb(3, 9);
		System.out.println("");
	}
}
