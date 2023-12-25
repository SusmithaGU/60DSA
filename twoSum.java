import java.util.*;

public class twoSum {
    static int[] efficientapproach(int[] nums,int target){
      HashMap<Integer,Integer> map=new HashMap<>();
      for(int i=0;i<nums.length;i++){
        map.put(nums[i],i);
      }

      for(int j=0;j<nums.length;j++){
       int pair=target-nums[j];
        if(map.containsKey(pair)&& map.get(pair)!=j){
            return new int[]{j,map.get(pair)};
        }
      }

      return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums={2,7,11,15};
        int target=9;
        int[] ans=efficientapproach(nums, target);

        for(int i:ans){
          System.out.println(i);
        }
    }
}
