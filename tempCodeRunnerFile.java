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
