package Lv1;

import java.util.Arrays;

public class Lv1_report {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        Solution_Lv1_report s = new Solution_Lv1_report();
        s.solution(id_list, report, k);
    }
}
class Solution_Lv1_report {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        int[] id_list_count = new int[id_list.length];

        String[][] report_dev = new String[report.length][2];

        for(int i = 0; i < report.length; i++) {
            report_dev[i] = report[i].split(" ");
            // System.out.println(report_dev[0][0] + " " + report_dev[0][1]);
            for(int j=0; j < id_list_count.length; j++) {
                if(id_list[j].equals(report_dev[i][1])) {
                    id_list_count[j]++;
                }
            }
        }
        System.out.println(Arrays.toString(report_dev[0]));
        System.out.println(Arrays.toString(id_list_count));
        for(int i=0; i < id_list_count.length; i++) {
            if(id_list_count[i] >= k) {
                for(int j=0; j<report_dev.length; j++) {
                    if(report_dev[j][1].equals(id_list[i])) {
                        for(int m=0; m < id_list.length; m++) {
                            if(report_dev[j][0].equals(id_list[m])) {
                                answer[m]++;
                            }
                        }
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(answer));
        


        return answer;
    }
}