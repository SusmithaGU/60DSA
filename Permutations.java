import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        int l = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
      
        for (int i = 0; i < l; i++) {
            ArrayList<Integer> temp=new ArrayList<>();
            temp.add(nums[i]);
            boolean[] visited=new boolean[l];
            visited[i]=true;
            permUtil(nums, visited,temp,ans);
        }
        return ans;
    }

    public void permUtil(int[] nums,boolean[] visited,ArrayList<Integer> temp,List<List<Integer>> ans){
        if(temp.size()==nums.length) {
            ans.add(new ArrayList<>(temp));
        }

        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                temp.add(nums[i]);
                visited[i]=true;
                permUtil(nums, visited, temp, ans);
                visited[i]=false;
                temp.remove(temp.size()-1);
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };

        Permutations p=new Permutations();
        List<List<Integer>> a =p.permute(nums);
        System.out.println("completed");
    }
}
