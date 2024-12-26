import java.util.*;
public class TwoSum {
        public static void main(String[] args){
            int[] arr = {3,5,3,1,2,7};
            int target = 5;
            int[] arr1 = {3,5,3,1,2,7,9};
            int target1 = 3;
        }

        boolean twoSum(int arr[], int target) {
            // code here
            Set<Integer> set = new HashSet<>();
            for(int i=0; i<arr.length; i++){
                int diff = target-arr[i];
                if(set.contains(diff)){
                    return true;
                }else{
                    set.add(arr[i]);
                }
            }
            return false;boolean twoSum(int arr1[], int target1) {
                    // code here
                    Arrays.sort(arr);
                    int i=0;
                    int j=arr.length-1;

                    while(i<j){
                        int sum = arr[i] + arr[j];
                        if(sum == target){
                            return true;
                        }
                        else if(sum<target){
                            i++;
                        } else {
                            j--;
                        }
                    }
                    return false;
            }
    }
}
