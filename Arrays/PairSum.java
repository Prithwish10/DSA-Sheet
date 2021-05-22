// Given two unsorted arrays of distinct elements, the task is to find all pairs from both arrays whose sum is equal to X.
// Examples: 
 

// Input :  arr1[] = {1 1 2 2 2 3}
//          arr2[] = {1 4 5 2 5 4}  
//          x = 7
//          Output: 8

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PairSum {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many numbers you want to insert in 1st and 2nd array :");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int ar[] = new int[n];
        int br[] = new int[m];
        System.out.println("Enter the numbers in 1st array :");
        for (int i = 0; i < n; i++)
            ar[i] = sc.nextInt();
        System.out.println("Enter the numbers in 2nd array :");
        for (int i = 0; i < m; i++)
            br[i] = sc.nextInt();
        System.out.println("Enter the total sum");
        int tot = sc.nextInt();
        System.out.println(count(ar, br, tot));
    }
    public static int count(int nums1[], int nums2[], int tot){

        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;
        
        for(int b : nums2){
            map.put(b, map.getOrDefault(b, 0) + 1);
        }

        for(int a : nums1){
            count += map.getOrDefault(tot - a, 0);
        }
        return count;
    }
}
