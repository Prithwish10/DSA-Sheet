import java.util.Scanner;

class Sort {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many numbers you want to insert :");
        int n = sc.nextInt();
        int ar[] = new int[n];
        System.out.println("Enter the numbers :");
        for(int i = 0; i < n; i++)
            ar[i] = sc.nextInt();
        int result[] = sort(ar, n);

        for(int i : result)
            System.out.print(i+" ");
    }
    public static int[] sort(int ar[], int n){

        if(ar == null)
            return null;
        int low = 0;
        int mid = 0;
        int heigh = ar.length - 1;

        while(mid <= heigh){
            if(ar[mid] == 0){
                int temp = ar[low];
                ar[low] = ar[mid];
                ar[mid] = temp;
                low ++;
                mid ++;
            }
            else if(ar[mid] == 1){
                mid ++;
            }
            else{
                int temp = ar[heigh];
                ar[heigh] = ar[mid];
                ar[mid] = temp;
                heigh --;
            }
        }
        return ar;
    }
}