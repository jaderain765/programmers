package 프로그래머스.lv1.키패드_누르기;

class 키패드_누르기{
    public static void main(String[] args) {
        Solution sol = new Solution();
        String arr = sol.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
        System.out.println(arr);
    }
}


class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[] L_pad = new int[]{1,4,7,'*'};
        int[] M_pad = new int[]{2,5,8,0};
        int[] R_pad = new int[]{3,6,9,'#'};
        int[] finger_position = new int[]{3,3};
        int count = 0;

        for (int i=0; i < numbers.length; i++){
            //왼손을 욺직일때
            if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7){
                for(int j = 0; j < L_pad.length; j++){
                    if(L_pad[j] == numbers[i]){
                        finger_position[0]=j;
                        break;
                    }
                }
                answer += "L";
                System.out.printf("%d번째 : %3d %3d\n", count++, finger_position[0], finger_position[1]); //
                continue;
            }
            //오른손을 욺직일때
            if(numbers[i]==3 || numbers[i]==6 || numbers[i]==9){
                for(int j = 0; j < R_pad.length; j++){
                    if(R_pad[j] == numbers[i]){
                        finger_position[1]=j;
                        break;
                    }
                }
                answer += "R";
                System.out.printf("%d번째 : %3d %3d\n", count++, finger_position[0], finger_position[1]); //%%%%
                continue;
            }
            //손가락의 위치와 손잡이의 좌우에 따라 누르는 알고리즘
            if(numbers[i]==2 || numbers[i]==5 || numbers[i]==8 || numbers[i]==0){
                for(int j = 0; j < M_pad.length; j++){
                    //눌러야하는 버튼의 위치
                    if(M_pad[j] == numbers[i]){
                        //어떤 손가락이 눌러야 하느지 알려주는 알고리즘
                        //각 손가락별 눌러야하는 번튼간의 거리
                        int l = ((finger_position[0]-M_pad[j] >= 0)? finger_position[0]-M_pad[j] : M_pad[j]-finger_position[0]);
                        int r = ((finger_position[1]-M_pad[j] >= 0)? finger_position[1]-M_pad[j] : M_pad[j]-finger_position[1]);
                        if(l > r){//왼손가락거리 > 오른손가락거리
                            finger_position[1]=j;
                            answer += "R";
                            System.out.printf("%d번째 : %3d %3d\n", count++, finger_position[0], finger_position[1]); //%%%%
                            break;
                        }
                        else if(r > l){//오른손가락거리 > 왼손가락거리
                            finger_position[0]=j;
                            answer += "L";
                            System.out.printf("%d번째 : %3d %3d\n", count++, finger_position[0], finger_position[1]); //%%%%
                            break;
                        }else{//자주쓰는 손으로 누르기
                            if(hand.equals("left")){
                                finger_position[0]=j;
                                answer += "L";
                                System.out.printf("%d번째 : %3d %3d\n", count++, finger_position[0], finger_position[1]); //%%%%
                                break;
                            }
                            finger_position[1]=j;
                            answer += "R";
                            System.out.printf("%d번째 : %3d %3d\n", count++, finger_position[0], finger_position[1]); //%%%%
                            break;
                        }
                    }
                }
            }
        }
        return answer;
    }
}