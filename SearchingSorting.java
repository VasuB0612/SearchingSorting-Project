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
    
    //--------------LINEAR SEARCH-----------------// 

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

}

            