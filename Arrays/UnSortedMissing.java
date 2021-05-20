// Given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in list. One of the integers is missing in the list. Write an efficient code to find the missing integer. 
// Examples: 

// Input : arr[] = [2, 3, 7, 4, 6, 8, 1]
// Output : 5

// Input : arr[] = [6, 8, 9, 1, 2, 3, 4, 5]
// Output : 7

import java.util.Scanner;

public class UnSortedMissing {
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
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public static int findMissingNumber(int ar[], int n){

        if(ar == null || n == 0)
            return -1;
        int array_elements = 0;
        int nNaturalNumbers = 0;

        for(int i = 0; i < n; i++){
            array_elements = array_elements ^ ar[i];
            nNaturalNumbers = nNaturalNumbers ^ (i + 1);
        }
        nNaturalNumbers = nNaturalNumbers ^ (n+1);
        return array_elements ^ nNaturalNumbers;
    }
}
