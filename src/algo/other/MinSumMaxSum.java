package algo.other;

import java.util.Scanner;

public class MinSumMaxSum {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        int min = Integer.MAX_VALUE;
        int max = 0;
        long minSum=0;
        long maxSum=0;
        for(int arr_i=0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
            if(min>arr[arr_i]){
                if(min!=Integer.MAX_VALUE){
                    maxSum+=min;
                }
                min = arr[arr_i];
            }else{
                maxSum+=arr[arr_i];
            }
            
            if(max<arr[arr_i]){
                minSum+=max;
                max=arr[arr_i];
            }else{
                minSum += arr[arr_i];
            }
        }
        
        System.out.println(minSum + " " + maxSum);
    }

}
