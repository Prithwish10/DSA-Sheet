// Given an unsorted array of size n. Array elements are in the range from 1 to n. One number from set {1, 2, …n} is missing and one number occurs twice in the array. Find these two numbers.

// Examples: 

//  Input: arr[] = {3, 1, 3}
// Output: Missing = 2, Repeating = 3
// Explanation: In the array, 
// 2 is missing and 3 occurs twice 

// Input: arr[] = {4, 3, 6, 2, 1, 1}
// Output: Missing = 5, Repeating = 1

import java.util.Scanner;

class RepeatingAndMissingNumber {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many numbers you want to insert :");
        int n = sc.nextInt();
        int ar[] = new int[n];
        System.out.println("Enter the numbers :");
        for(int i = 0; i < n; i++)
            ar[i] = sc.nextInt();
        int result[] = findTwoElement(ar, n);
        System.out.println("Repesting -> "+ result[0]+"\n"+ "Missing -> "+ result[1]);
    }
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static int[] findTwoElement(int arr[], int n) {
        int count[] = new int[n + 1];
        int missing = 0;
        int repeating = 0;
        for(int i = 0; i < n; i++){
            count[arr[i]] ++;
        }
        for(int i = 1; i < count.length; i++){
            if(count[i] == 0)
                missing = i;
            if(count[i] > 1)
                repeating = i;
        }
        return new int[]{repeating, missing};
    }
}