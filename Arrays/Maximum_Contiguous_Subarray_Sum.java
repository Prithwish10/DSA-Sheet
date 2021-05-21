import java.util.Scanner;

public class Maximum_Contiguous_Subarray_Sum {
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many numbers you want to insert :");
        int n = sc.nextInt();
        int ar[] = new int[n];
        System.out.println("Enter the numbers :");
        for(int i = 0; i < n; i++)
            ar[i] = sc.nextInt();
        System.out.println(maxSubarraySum(ar, n));
    }
    public static int maxSubarraySum(int arr[], int n){
        
        int global_max = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i = 0; i < n; i++){
            
            sum += arr[i];
            
            if(sum > global_max){
                global_max = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return global_max;
    }
}
