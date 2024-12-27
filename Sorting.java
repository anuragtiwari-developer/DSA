public class Sorting {
    //BUBBLE SORT
    public static void bubbleSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    // SELECTION SORT
    public static void selectionSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            int min_index = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[min_index]>arr[j]){
                    min_index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }
    }
    // INSERTION SORT
    public static void insertionSort(int[] arr){
        for(int i=1; i<arr.length; i++){
            int temp = arr[i];
            int j = i;
            while(j>0 && arr[j-1]>temp){
                arr[j] = arr[j-1];
                j = j - 1;
            }
            arr[j] = temp;
        }
    }
    // PRINT ARRAY F(x)
    public static void printArray(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
    // MAIN METHOD
    public static void main(String[] args) {
        int[] arr = {44,53,22,11,23,56,1,3,99};
        bubbleSort(arr);
        selectionSort(arr);
        insertionSort(arr);
        printArray(arr);
    }
}
