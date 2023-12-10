import java.util.Scanner;

public class SearchingSorting{
    static SortingPerformanceMonitor comparisonCounter = new SortingPerformanceMonitor();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    // --------------COMMAND LINE INTERFACE-----------------//

        while(true){
            System.out.println("\n");
            System.out.println("Menu of searching and sorting test bed." + "\n");
            System.out.println("1)   Linear Searching");
            System.out.println("2)   Binary Searching");
            System.out.println("3)   O(n^2) type of sorting");
            System.out.println("4)   O(n*log(n)) type of sorting");
            System.out.println("5)   Sorting performance" + "\n");
            System.out.println("q/Q) Quit" + "\n\n");

            System.out.print("Your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("In the list there are 0, ..., 9; which value would you like to search with linear search? ");
                    int num;
                    try {
                        num = Integer.parseInt(scanner.nextLine());
                    } catch (Exception e) {
                        continue;
                    }
                    boolean isThere = LinearSearch(num);
                    if(isThere){
                        System.out.println("\nFound");
                    }
                    else{
                        System.out.println("\nNot Found");
                    }
                    break;

                case "2":
                    System.out.print("In the list there are 0, ..., 9; which value would you like to search with linear search? ");
                    int numToBeSearched;
                    try {
                        numToBeSearched = Integer.parseInt(scanner.nextLine());
                    } catch (Exception e) {
                        continue;
                    }
                    boolean isPresent = BinarySearch(numToBeSearched);
                    if(isPresent){
                        System.out.println("\nFound");
                    } 
                    else{
                        System.out.println("\nNot Found");
                    }
                    break;

                case "3":
                    int originalArray[] = {-93, -36, 25, 44, -30, -21, 34, 56, 82, 64};
                    System.out.println("\n\nData set before insertion sorting:");
                    for(int i=0; i<originalArray.length; i++){
                        System.out.print(originalArray[i] + " ");
                    }
                    int sortedArray[] = insertionSort(originalArray);
                    System.out.println("\n\n\nData set after insertion sorting:");
                    for(int i=0; i<sortedArray.length; i++){
                        System.out.print(sortedArray[i] + " ");
                    }
                    System.out.println();                    
                    break;

                case "4":
                    int firstArray[] = {-7, 1, -81, -56, -91, 37, 41, 28, 34, -27};
                    System.out.println("\n\nData set before quicksort:");
                    for(int i=0; i<firstArray.length; i++){
                        System.out.print(firstArray[i] + " ");
                    }
                    int secondArray[] = quickSort(firstArray, 0, firstArray.length - 1);
                    System.out.println("\n\n\nData set after quicksort:");
                    for(int i=0; i<secondArray.length; i++){
                        System.out.print(secondArray[i] + " ");
                    }
                    System.out.println();
                    break;

                case "5":
                    sortingPerformance();
                break;

                case "q":
                case "Q":
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("\n\nInvalid Choice, try again.");
                    break;
            }       
        }
        
    }

    //--------------LINEAR SEARCH TIER 1-----------------// 
    
    public static boolean LinearSearch(int num){
        int numArray[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for(int i=0; i<numArray.length; i++)
        {
            if(numArray[i] == num)
            {
                return true;
            }
        }
        return false;
    }
    
    //--------------BINARY SEARCH TIER 2-----------------// 

    public static boolean BinarySearch(int target){
        int numArray[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int length_of_array = numArray.length;

        int low = 0;
        int high = length_of_array - 1;
        while(low <= high){

            int mid = low + (high - low)/2;

            if(numArray[mid] == target){
                return true;
            }
            else if(target > numArray[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return false;
    }

    //--------------INSERTION SORT TIER 3-----------------// 
    
    public static int[] insertionSort(int[] A){
        int n = A.length;
        for (int i=1; i<n; i++) {
            int key = A[i];
            int j = i-1;
            
            while (j >= 0 && A[j] > key) {
                A[j+1] = A[j];
                j--;
                comparisonCounter.incrementComparisonCount();
            }
            A[j+1] = key;
        }
        return A;
    }
    
    //--------------BUBBLE SORT-----------------// 

    public static int[] bubbleSort(int[] A){
        int n = A.length;
        int temp;
        
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n-i-1; j++){
                comparisonCounter.incrementComparisonCount();
                if(A[j] > A[j+1]){
                    temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
        return A;
    }

    // --------------QUICK SORT TIER 4-----------------//

    public static int pi(int[] arr, int l, int r){
        int temp;
        int pivot = arr[r];
        int i = l-1;

        for(int j=l; j<r; j++){
            comparisonCounter.incrementComparisonCount();
            if(arr[j] < pivot){
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[i+1];
        arr[i+1] = arr[r];
        arr[r] = temp;
        return i+1;
    }

    public static int[] quickSort(int[] A, int l, int r){
        if(l<r){
            int partitionIndex = pi(A, l, r);
            quickSort(A, l, partitionIndex-1);
            quickSort(A, partitionIndex+1, r);
        }
        return A;
    }

    // --------------MERGE SORT-----------------//    
    public static void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int n = array.length;
        int[] temp = new int[n];
        mergeSortHelper(array, temp, 0, n - 1);
    }

    private static void mergeSortHelper(int[] array, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSortHelper(array, temp, left, mid);
            mergeSortHelper(array, temp, mid + 1, right);
            merge(array, temp, left, mid, right);
        }
    }

    private static void merge(int[] array, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = array[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            comparisonCounter.incrementComparisonCount();
            if (temp[i] <= temp[j]) {
                array[k] = temp[i];
                i++;
            } else {
                array[k] = temp[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            array[k] = temp[i];
            i++;
            k++;
        }

        while (j <= right) {
            array[k] = temp[j];
            j++;
            k++;
        }
    }


    // --------------Generating Random Array-----------------//    

    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random()*10);
        }
        return array;
    }

    // --------------SORTING PERFORMANCE TIER 5-----------------//

    public static void sortingPerformance() {
        int n = 1000;
        int[] dataSetSizes = new int[10];
        long[] comparisonCounts1 = new long[10];
        long[] comparisonCounts2 = new long[10];
        long[] comparisonCounts3 = new long[10];
        long[] comparisonCounts4 = new long[10];
        long[] elapsedTimes1 = new long[10];
        long[] elapsedTimes2 = new long[10];
        long[] elapsedTimes3 = new long[10];
        long[] elapsedTimes4 = new long[10];
    
        for (int i = 1; i <= 10; i++) {
            dataSetSizes[i - 1] = n * i;
        }
        System.out.print("                                     ");
        for (int size : dataSetSizes) {
            System.out.print(size + "         ");
        }
        System.out.println("\n");

        // For bubble sort 
        for (int i = 1; i <= 10; i++) {
            int size = n * i;
            int[] arr = generateRandomArray(size);
    
            comparisonCounter.resetComparisonCount();
            long startTime = System.currentTimeMillis();
            bubbleSort(arr);
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
    
            comparisonCounts1[i - 1] = comparisonCounter.getComparisonCount();
            elapsedTimes1[i - 1] = elapsedTime;
        }
    
        // Comparison counts
        System.out.print("bubbleSort,random,comparisons        ");
        for (long count : comparisonCounts1) {
            System.out.print(count + "    ");
        }
        System.out.println("\n");
    
        // Elapsed times
        System.out.print("bubbleSort,random,ms                 ");
        for (long time : elapsedTimes1) {
            System.out.print(time + "          ");
        }
        System.out.println("\n");

        // For insertion sort
        for (int i = 1; i <= 10; i++) {
            int size = n * i;
            int[] arr = generateRandomArray(size);
    
            comparisonCounter.resetComparisonCount();
            long startTime = System.currentTimeMillis();
            insertionSort(arr);
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
    
            comparisonCounts2[i - 1] = comparisonCounter.getComparisonCount();
            elapsedTimes2[i - 1] = elapsedTime;
        }
    
        // Comparison counts
        System.out.print("insertionSort,random,comparisons     ");
        for (long count : comparisonCounts2) {
            System.out.print(count + "     ");
        }
        System.out.println("\n");
    
        // Elapsed times
        System.out.print("insertionSort,random,ms              ");
        for (long time : elapsedTimes2) {
            System.out.print(time + "           ");
        }
        System.out.println("\n"); 

        // For merge sort
        for (int i = 1; i <= 10; i++) {
            int size = n * i;
            int[] arr = generateRandomArray(size);
    
            comparisonCounter.resetComparisonCount();
            long startTime = System.currentTimeMillis();
            mergeSort(arr);
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
    
            comparisonCounts4[i - 1] = comparisonCounter.getComparisonCount();
            elapsedTimes4[i - 1] = elapsedTime;
        }
    
        // Comparison counts
        System.out.print("mergeSort,random,comparisons         ");
        for (long count : comparisonCounts4) {
            System.out.print(count + "        ");
        }
        System.out.println("\n");
    
        // Elapsed times
        System.out.print("mergeSort,random, ms                 ");
        for (long time : elapsedTimes4) {
            System.out.print(time + "           ");
        }
        System.out.println("\n");
         
        // For quick sort
        for (int i = 1; i <= 10; i++) {
            int size = n * i;
            int[] arr = generateRandomArray(size);
    
            comparisonCounter.resetComparisonCount();
            long startTime = System.currentTimeMillis();
            quickSort(arr, 0, arr.length - 1);
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
    
            comparisonCounts3[i - 1] = comparisonCounter.getComparisonCount();
            elapsedTimes3[i - 1] = elapsedTime;
        }
    
        // Comparison counts
        System.out.print("quickSort,random,comparisons         ");
        for (long count : comparisonCounts3) {
            System.out.print(count + "    ");
        }
        System.out.println("\n");
    
        // Elapsed times
        System.out.print("quickSort,random, ms                 ");
        for (long time : elapsedTimes3) {
            System.out.print(time + "           ");
        }
        System.out.println("\n"); 

    }
    
}

class SortingPerformanceMonitor {
    private long comparisonCount;

    public SortingPerformanceMonitor() {
        comparisonCount = 0;
    }

    public void incrementComparisonCount() {
        comparisonCount++;
    }

    public long getComparisonCount() {
        return comparisonCount;
    }

    public void resetComparisonCount() {
        comparisonCount = 0;
    }
}   