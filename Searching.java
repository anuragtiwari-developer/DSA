import java.util.Arrays;
public class Searching {
    // LINEAR SEARCH - TC-O(n)
    public static int linearSearch(int[] arr,int target){
        int l = arr.length;
        for(int i=0; i<l; i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }
    // BINARY SEARCH - TC-O(logn)
    // array should be sorted to implement B.S.
    public static int binarySearch(int[] arr, int target){
        Arrays.sort(arr); // function to sort the Array
        int left = 0;
        int right = arr.length-1;

        while(left<right){
            int mid = left + (right-left)/2;
            if(arr[mid] == target){
                return mid;
            }
            if(arr[mid]<target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {4,7,2,3,9,11,12,14,67,88};
        int target = 67;
        int ans1 = linearSearch(arr,target);
        int ans2 = binarySearch(arr,target);
        System.out.println(ans1);
        System.out.println(ans2);
    }
}
