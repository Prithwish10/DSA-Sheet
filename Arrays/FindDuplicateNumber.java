import java.util.Scanner;

class FindDuplicateNumber {
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many numbers you want to insert :");
        int n = sc.nextInt();
        int ar[] = new int[n];
        System.out.println("Enter the numbers :");
        for(int i = 0; i < n; i++)
            ar[i] = sc.nextInt();
        System.out.println(findDuplicate(ar));
    }
    public static int findDuplicate(int[] nums) {
        
        if(nums == null || nums.length == 0)
            return -1;
        
        for(int i = 0; i < nums.length; i++){
            
            // Check if the (nums[i] - 1)th pos is < or >= 0
            
            if(nums[Math.abs(nums[i]) - 1] >= 0)
                // If (nums[i] - 1)th pos is >= 0 that means it is not visited previously
                //So we mark this position as visited
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            
            else
                // If (nums[i] - 1)th pos is < 0 that means this pos is already visited, 
                //then return nums[i] becz this is the element which is repeated
                return Math.abs(nums[i]);
        }
        return -1;
    }
}