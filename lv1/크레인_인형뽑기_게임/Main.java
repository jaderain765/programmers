package programmers.lv1.크레인_인형뽑기_게임;

class 크레인_인형뽑기_게임{
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[]{1,5,3,5,1,2,1,4}));
    }
}

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        String str = "";
        
        //크래인 작동 횟수만큼 동작
        for(int i = 0; i < moves.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[j][moves[i]-1]==0) continue; // 행을 한칸씩 내려가며 열값을 조회
                //마지막 값이 넣을 값과 같을 때
                if (str.length()>0 && str.charAt(str.length()-1)==(board[j][moves[i]-1])+48){
                    str = str.substring(0,str.length()-1);
                    board[j][moves[i]-1] = 0;
                    answer+=2;
                    // System.out.println(str);
                    // arr_print(i, board);
                    break;
                }
                str += board[j][moves[i]-1];
                board[j][moves[i]-1] = 0;
                // System.out.println(str);
                // arr_print(i, board);
                break;
            }
        }
        //배열에 있는 moves
        // System.out.println(str);

        return answer;
    }
    static void arr_print(int n, int[][] board){
        System.out.println(n + "번째 출력");
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j]+" ");    
            }
            System.out.println();
        }
    }
}