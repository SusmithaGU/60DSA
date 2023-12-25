import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        util(nums, new ArrayList<Integer>(), ans, 0);
        return ans;
    }

    public void util(int[] nums, List<Integer> temp, List<List<Integer>> ans, int i) {

        if (i == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        // take
        temp.add(nums[i]);
        util(nums, temp, ans, i + 1);

        temp.remove(temp.size() - 1);
        // do not take
        util(nums, temp, ans, i + 1);

    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        Subsets s=new Subsets();
        s.subsets(nums);
        System.out.println("");
    }
}
