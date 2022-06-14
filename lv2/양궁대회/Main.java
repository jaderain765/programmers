package lv2.양궁대회;

class Solution {
    public int[] solution(int n, int[] info) {
        int[] answer = {};
        
        //각 점수의 위치에 꽂은 횟수
        int[] ryan_info = new int[11];
        
        int apeach = 0, ryan = 0, back_ryan = -1;
        
        //가장 많은 화살을 소모해버린 케이스를 채크 후 다음케이스에서 제외하며 다른점수를 얻는다.
        boolean[] arrow = new boolean[11];
        
        boolean win = false;
        
        while(true){
            int num = n;
            //화살사용 내역을 저장 {사용위치, 사용량}
            int[] max_arrow = new int[]{0,0};
            ryan_info = new int[11];
            //어피치 점수
            apeach = 0;
            //라이언 점수
            ryan = 0;
            for(int i = 0; i < info.length; i++){
                //저번 케이스에서 화살을 너무 많이 쓴케이스는 다음케이스에서 제외된다.
                if(arrow[i] == true) continue;
                
                //화살을 전부 소모해야 한다 i가 마지막일경우에 남은 화살을 추가해준다.
                if(i == info.length-1) ryan_info[i] += num;
                
                //점수를 가져가기에 화살이 모자란 경우
                if(num - (info[i] + 1) < 0){
                    apeach += (10-i);
                    continue;
                }
                
                //화살이 모자라지 않은경우, 점수를 더하고 배열에 추가한다.
                ryan_info[i] = (info[i] + 1);
                num -= (info[i] + 1);
                ryan += (10-i);
                
                //화살 사용량이 최대 갯수일때 저장해두고 다음케이스에서 제외하며 점수를 벌어본다.
                if((info[i] + 1) >= max_arrow[1]){
                    max_arrow[0] = i;
                    max_arrow[1] = (info[i] + 1);
                }
            }
            //그전시도의 라이언 점수보다 작다면 브레이크
            if(ryan < back_ryan) break;
            
            //라이언의 점수가 전의 점수보다크거나 같다면 배열과 점수를 저장
            back_ryan = ryan;
            answer = ryan_info;
            
            //가장 화살을 많이 소모한 케이스를 제외한다.
            arrow[max_arrow[0]] = true;
            
            // System.out.println(Arrays.toString(info));
            // System.out.println(Arrays.toString(ryan_info));
            if(ryan > apeach) win = true;
            else win = false;
        }
        
        if(win == false) return new int[]{-1};
        
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(0, new int[]{}));
    }
}
