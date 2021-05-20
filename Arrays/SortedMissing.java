// Given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in list. One of the integers is missing in the list. Write an efficient code to find the missing integer. 
// Examples: 

// Input : arr[] = [1, 2, 3, 4, 6, 7, 8]
// Output : 5

// Input : arr[] = [1, 2, 3, 4, 5, 6, 8, 9]
// Output : 7
/*
    EXPLANATION :
    - If the ar[middle] = middle + 1, then all the elements <= mid are in correct sequence and the missing no. must be to the right of mid so make low = middle + 1
    - Else 
        - Store ar[middle] becz it can also be the missing number
        - And make heigh = middle - 1, to search in the left sub array
*/

import java.util.Scanner;

class SortedMissing {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many numbers you want to insert :");
        int n = sc.nextInt();
        int ar[] = new int[n];
        System.out.println("Enter the numbers :");
        for(int i = 0; i < n; i++)
            ar[i] = sc.nextInt();

        int result = findMissingNumber(ar, n);
        System.out.println(result);
    }
    
    //Time Complexity: O(log N)
    //Space Complexity: O(1)
    public static int findMissingNumber(int ar[], int n){

        int low = 0;
        int heigh = ar.length - 1;
        int missing = -1;

        while(low <= heigh){
            int mid = low + (heigh - low) / 2;

            if(ar[mid] == mid + 1)
                low = mid + 1;
            else{
                missing = mid;
                heigh = mid - 1;
            }
        }
        return missing + 1;
    }
}