// Given two sorted arrays, we need to merge them in O((n+m)*log(n+m)) time with O(1) extra space into a sorted array, when n is the size of the first array, and m is the size of the second array.

// Example:  

// Input: ar1[] = {10};
//        ar2[] = {2, 3};
// Output: ar1[] = {2}
//         ar2[] = {3, 10}  

// Input: ar1[] = {1, 5, 9, 10, 15, 20};
//        ar2[] = {2, 3, 8, 13};
// Output: ar1[] = {1, 2, 3, 5, 8, 9}
//         ar2[] = {10, 13, 15, 20}

import java.util.Scanner;

public class MergeTwoSortedArray {
    public static void main(String args[]) {
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
        // merge(ar, br, n, m);
        mergeGap(ar, br, n, m);
        printnArrays(ar, br);
    }

    // Time Complexity : O(n * m)
    // Space Complexity : O(1)
    public static void merge(int ar[], int br[], int n, int m) {

        int i = 0, j = 0;

        while (i < n) {

            // Check if ar[i] > ar[j]
            // If true swap
            if (ar[i] > br[j]) {
                // SWAP
                int temp = ar[i];
                ar[i] = br[j];
                br[j] = temp;

                temp = br[j];
                int k = j + 1;
                boolean flag = true;

                while (k < m) {
                    if (br[k] < temp) {
                        br[k - 1] = br[k];
                        k++;
                        flag = true;
                    } else {
                        flag = false;
                        br[k - 1] = temp;
                        break;
                    }
                }
                if (flag)
                    br[k - 1] = temp;
            } else
                i++;
        }
    }

    // GAP ALGORITHM
    // Time Complexity: (n + m)log(n + m)
    // Space Complexity: O(1)
    public static void mergeGap(int ar[], int br[], int n, int m) {

        int i = 0, j = 0, gap = (n + m);

        for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {

            for (i = 0; i + gap < n; i++) {
                if (ar[i] > ar[i + gap]) {
                    int temp = ar[i];
                    ar[i] = ar[i + gap];
                    ar[i + gap] = temp;
                    // ar[i] += ar[i + gap] - (ar[i + gap] = ar[i]);
                }
            }
            for (j = (gap > n) ? (gap - n) : 0; i < n && j < m; i++, j++) {
                if (ar[i] > br[j]) {
                    int temp = ar[i];
                    ar[i] = br[j];
                    br[j] = temp;
                    // ar[i] += br[j] - (br[j] = ar[i]);
                }
            }
            if (j < m) {
                for (j = 0; j + gap < m; j++) {
                    if (br[j] > br[j + gap]) {
                        int temp = br[j];
                        br[j] = br[j + gap];
                        br[j + gap] = temp;
                        // br[j] += br[j+gap] - (br[j + gap] = br[j]);
                    }
                }
            }
        }
    }

    public static int nextGap(int gap) {
        if (gap <= 1)
            return 0;
        return (gap / 2 + gap % 2);
    }

    public static void printnArrays(int ar[], int br[]) {
        for (int a : ar)
            System.out.print(a + " ");
        System.out.println();
        for (int b : br)
            System.out.print(b + " ");
    }
}
