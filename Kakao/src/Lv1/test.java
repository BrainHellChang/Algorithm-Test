package Lv1;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		int n = 4;
		int num = 28;
		int num_div = num;
		
		int[] arr = new int[5];
		
		while(n>=0) {
			System.out.print(num_div);
			arr[n] = num_div%2;
		    if(num_div/2 == 0 && num_div%2 == 0) {
		    	arr[n] = 0;
		    } else if(num_div/2 == 0 && num_div%2 == 1) {
		    	arr[n] = 1;
		    	num_div = 0;
		    }
		    num_div /= 2;
		    n--;
		  
		}
		System.out.println(Arrays.toString(arr));

	}

}
