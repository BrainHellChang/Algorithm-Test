package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ex3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String[] NArr = new String[N];
		ArrayList<String> resArr = new ArrayList<String>();
		
		// 생산공정 입력
		for(int i=0; i<N; i++) {
			String str = sc.next();
			str = str.toUpperCase();
			NArr[i] = str;
		}
		
		
		// 조건 입력
		int K = sc.nextInt();
		String[] KArr = new String[K];
		for(int i=0; i<K; i++) {
			String str = sc.next();
			str = str.toUpperCase();
			KArr[i] = str;
		}


		
		for(int i=0; i<K; i++) {
			// 조건 글자 길이
			int conLength = KArr[i].length();
			
			for(int j=0; j<N; j++) {
				String subStr = NArr[j].substring(0,conLength);
				
				if(subStr.equals(KArr[i])) {
					resArr.add(NArr[j]);
				}
				
			}
		}
		
		// 일치하는 것 중에 가장 길이가 긴 친구 출력해보기
		int max_length = 0;
		int index = 0;
		int count = 0;
		for(int i=0; i<resArr.size(); i++) {
			if(resArr.get(i).length() >=max_length) {
				max_length = i;
				index = max_length;
			}
			System.out.println("max : " + max_length);
		}
		System.out.println();
		System.out.println(resArr.toString());
		System.out.println("index : " + index);
		System.out.println("입력 : " + Arrays.toString(NArr));
		System.out.println("조건 : " + Arrays.toString(KArr));
		System.out.println("결과 : " + resArr.get(index));
		
/*

6
ABCD
AC
ABC
ABD
AC
ABC
3
AB
A
BC


 */
		
		
		
		
		
		
		
		
		
		
	}
}
