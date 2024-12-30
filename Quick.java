import java.util.Arrays;
// Arrays.sort() is basically a quick sort
public class Quick {
    static void sort(int[] nums, int low, int high){
        // start and end is for swapping
        // low and high for recursion calls
         if(low >= high){
             return;
         }
         int s = low;
         int e = high;
         int m = s + (e-s)/2;
         int pivot = nums[m];

         while(s<=e){
             // also a reason why if its already sorted it will not swap
             while(nums[s] < pivot){
                 s++;
             }
             while(nums[e] > pivot) {
                 e--;
             }

             if(s<=e){
                 int temp = nums[s];
                 nums[s] = nums[e];
                 nums[e] = temp;
                 s++;
                 e--;
             }
         }
         // now my pivot is at correct index, please sort two halfs
         sort(nums,low,e);
         sort(nums,s,high);
    }

    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        sort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}