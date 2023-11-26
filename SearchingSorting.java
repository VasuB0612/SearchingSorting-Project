import java.util.Scanner;

public class SearchingSorting{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    // --------------COMMAND LINE INTERFACE-----------------//

        while(true){
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
                        System.out.println("\nFound\n");
                    }
                    else{
                        System.out.println("\nNot Found\n");
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
                        System.out.println("\nFound\n");
                    } 
                    else{
                        System.out.println("\nNot Found\n");
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
                    System.out.println("\n\n");                    
                    break;
            }
        }
        
    }

    //--------------LINEAR SEARCH-----------------// 
    
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
    
    //--------------BINARY SEARCH-----------------// 

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

    //--------------INSERTION SORT-----------------// 

    public static int[] insertionSort(int[] A){
        int n = A.length;
        for (int i=1; i<n; i++) {
            int key = A[i];
            int j = i-1;
            
            while (j >= 0 && A[j] > key) {
                A[j+1] = A[j];
                j--;
            }
            A[j+1] = key;
        }
        return A;
    }
}

            