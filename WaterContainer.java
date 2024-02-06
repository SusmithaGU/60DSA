public class WaterContainer {
 
        public static int maxArea(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int maxWater = Integer.MIN_VALUE;
    
            while (left < right) {
                int lowHeight = Math.min(height[left], height[right]);
                int curWater = (right - left) * lowHeight;
                if (curWater > maxWater) {
                    maxWater = curWater;
                }
                while (left < right && height[left] <= lowHeight) {
                    left++;
                } 
                while (left < right && height[right] <= lowHeight) {
                    right--;
                }
            }
    
            return maxWater;
        }

        public static void main(String[] args) {
            int[] height={1,2,1}; //ans=2
            System.out.println(maxArea(height));
        }
    }

