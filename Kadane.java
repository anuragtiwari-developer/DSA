public class Kadane {
    public static void main(String[] args) {
        int[] arr = {1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
        System.out.println(maxSubArray1(arr));
    }
    // BRUTE FORCE - O(n^2) -> too slow for large input
    public static int maxSubArray(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            int currentSum = 0;
            for(int j=i; j<arr.length; j++){
                currentSum += arr[j];
                if(currentSum > maxSum){
                    maxSum = currentSum;
                }
            }
        }
        return maxSum;
    }
    // OPTIMISED APPROACH - O(n)
    //   1) Extend the current subarray
//          if(subarray + current) > current
//       2) Start fresh with a new subarray
//          if(subarray + current) < current
    public static int maxSubArray1(int[] arr){
        int currentSum = arr[0];
        int maxSum = arr[0];
        //traverse the array from the second element
        for(int i=1; i<arr.length; i++){
            //if currentSum is negative. reset to current element
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            // update maxSum if currentSum is greater
            maxSum = Math.max(maxSum,currentSum);
        }
        return maxSum;
    }
}
