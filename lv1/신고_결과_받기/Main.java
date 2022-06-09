package programmers.lv1.신고_결과_받기;

import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        Solution sol = new Solution();
        //테스트 케이스1
        int[] arr = sol.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2);
        System.out.println(Arrays.toString(arr));
        //테스트 케이스2
        int[] arr2 = sol.solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3);
        System.out.println(Arrays.toString(arr2));
    }
}

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        //유저가 신고한 유저가 밴될경우 메일 송신(리턴값)
        int[] answer = new int[id_list.length];

        //유저별 신고 당한 횟수
        int[] rep_user = new int[id_list.length];

        //유저별 신고 한 횟수(2중 배열)
        int[][] rep_num = new int[id_list.length][id_list.length];

        //리포트를 받아서 신고 알고리즘을 차례대로 계산
        for(String user : report){
            String[] str = user.split(" ");

            //누가 누구를 신고했고, 신고당했는지 알고리즘
            int n1 = Arrays.asList(id_list).indexOf(str[0]);//신고한사람(유저리스트의 순서)
            int n2 = Arrays.asList(id_list).indexOf(str[1]);//신고 당한사람(유저리스트의 순서)

            //자신이 자신을 신고하는 경우 제외
            if(n1 == n2) continue;

            //여러번 신고하는 것을 방지
            if(rep_num[n1][n2]==0){
                rep_num[n1][n2]++; //신고한 사람 , 신고당한사람
                rep_user[n2]++;
            }
        }

        //메일 횟수 계산 알고리즘
        for(int i = 0; i < rep_user.length; i++){
            //신고당한횟수가 k 번 이상일때
            if (rep_user[i]>=k){
                //유저별로 돌아가며 신고한사람을 탐색
                for(int j = 0; j < rep_num.length; j++){
                    //신고한기록이 있을시 
                    if(rep_num[j][i]==1){
                        //메일 보낼 횟수를 증가
                        answer[j]++;
                    }
                }
            }
        }
        return answer;
    }
}
