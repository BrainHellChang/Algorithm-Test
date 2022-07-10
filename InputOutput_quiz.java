package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 차 수
		int n = sc.nextInt();
		int sum = 0;
		
		int[] vArr = new int[n];
		int[] wArr = new int[n];
		
		
		// 입력
		for(int i = 0; i < n; i++) {
			int v = sc.nextInt();
			int w = sc.nextInt();
			vArr[i] = v;
			wArr[i] = w;
		}
		
//		System.out.println(Arrays.toString(vArr));
//		System.out.println(Arrays.toString(wArr));
		
		
		
		for(int i = 0; i<n; i++) {
			int max_num = 0;
			int max = 0;
			// 속도가 같은 친구 index 필터링하고 내구도 비교
			for(int j=0; j<n; j++) {
				if(vArr[i] == vArr[j]) {
					
					if(max <= wArr[j]  && vArr[j] != 0) {
						max_num = j+1;
						max = wArr[j];
						
					}
					if(i != j) {
						vArr[j] = 0;
					}
				}
				System.out.println(j + "번째 max_num : "+max_num);
				
			}
			System.out.println(Arrays.toString(vArr));
			sum += max_num;
			System.out.println(max_num);
			
			
		}
		System.out.println(sum);
		

/*
5
1 50
5 10
3 20
3 15
3 25  

7
1 10
2 25
3 25
3 30
3 35
2 30
2 50

 */

		
		
		
		
	}
}
