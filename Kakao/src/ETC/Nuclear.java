package ETC;

import java.util.Scanner;

/* 원전 문제
 * 가로 N 세로 M 크기의 원전이있다.
 * 각 숫자는 원전의 양이다
 * 연결되어있는 원전은 (0이상의 숫자들) 한번의 시추로 모두 획득 가능하다.
 * 총 몇번의 시추작업이 있어야하는지와 한번의 시추로 얻을수 있는 원전의양중 가장 큰값을 출력하는 프로그램을 작성하라
 * 
 * 첫번째 줄에는 테스트케이스 갯수(T)를 입력받는다.
 * 두번째 줄에는 원전의 가로세로 N,M을 입력 받는다.
 * 다음은 각각 원전의 양을 한칸씩 띄워 입력받는다.
 * 
 *  예)
 *  -입력
 *  2
 *  2 3
 *  1 0 0
 *  2 0 9
 *  4 6
 *  0 0 0 0 0 1
 *  0 2 0 0 8 2
 *  1 3 0 2 0 0
 *  0 2 3 1 0 9
 *  
 *  -출력
 *  #1 2 9
 *  #2 3 14
 * */

public class Nuclear {
    static int sum = 0;

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int T = sc.nextInt(); // 테스트 케이스
      int count = 0;
      int max_sum = 0;
      for (int p = 0; p < T; p++) {
         int N = sc.nextInt();
         int M = sc.nextInt();

         // 입력
         int[][] arr = new int[N][M];
         for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
               arr[i][j] = sc.nextInt();
            }
         }
         
         // 찾기
         for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
               if (arr[i][j] != 0) {
                  sum += arr[i][j];
                  arr[i][j] = 0;
                  search(arr, i, j);
                  count++;
                  if (max_sum < sum) {
                     max_sum = sum;
                  }
                  sum = 0;
               }

            }
         }
         
         // 출력
         System.out.println("max_sum = " + max_sum);
         System.out.println("count = " + count);
         
         // 초기화
         count = 0;
      }

      sc.close();
   }
   
   public static int[][] search(int[][] arr, int i, int j) {
      // 오른쪽 탐색
      if (j + 1 < arr[i].length && arr[i][j + 1] != 0) {
         sum += arr[i][j + 1];
         arr[i][j + 1] = 0;
         arr = search(arr, i, j + 1);
      } 
      
      // 아래 탐색
      if (i + 1 < arr.length && arr[i + 1][j] != 0) {
         sum += arr[i + 1][j];
         arr[i + 1][j] = 0;
         arr = search(arr, i + 1, j);
      } 
      
      // 왼쪽 탐색
      if (j - 1 >= 0 && arr[i][j - 1] != 0) {
         sum += arr[i][j - 1];
         arr[i][j - 1] = 0;
         arr = search(arr, i, j - 1);
      }
      
      // 위쪽 탐색
      if (i - 1 >= 0 && arr[i - 1][j] != 0) {
         sum += arr[i - 1][j];
         arr[i - 1][j] = 0;
         arr = search(arr, i - 1, j);
      }

      return arr;
   }

}
