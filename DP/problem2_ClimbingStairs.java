package DP;
import java.util.*;
public class problem2_ClimbingStairs{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of steps: ");
        int n = sc.nextInt();

        if(n==1){
            System.out.println(1);
            return;
        }

        if(n==2){
            System.out.println(2);
            return;
        }

        int prev2= 1;
        int prev1= 2;
        int current = 0;

        for(int i=3; i<=n; i++){
            current= prev1+prev2;

            prev2 = prev1;
            prev1 = current;
        }
        System.out.println(current);
    }
}