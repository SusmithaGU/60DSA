public class BinarySearch {
    static int looping(int[] nums,int target){
        int low=0, high=nums.length-1 ;
       
       while(low<=high){
           int mid=low+(high-low)/2;
           if(nums[mid]==target) return mid;
           else if(nums[mid]>target){
               high=mid-1;
           }
           else{
               low=mid+1;
           }
       }
       return -1;
    }

    static int recursivesolution(int[] nums,int target,int low,int high){
        if(low>high) return -1;
        int mid =(high-low) +low;
        if(nums[mid]==target) return mid;
        else if(nums[mid]> target){
            return recursivesolution(nums,target,0,mid-1);
        }
        else{
            return recursivesolution(nums,target,mid+1,high);
        }
    }

    public static void main(String[] args) {

        int[] nums={-1,0,3,5,9,12}; int target=9;
        System.out.println(looping(nums, target));
        System.out.println(recursivesolution(nums, target, 0, nums.length-1));
    }
}
