package lv2.스택.큐.기능개발;

import java.util.*;

class Main{
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(new int[]{}, new int[]{});
    }
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        progresses = new int[]{93,30,55};
        speeds = new int[]{1,30,5};
        
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < progresses.length; i++){
            queue.offer((int)(Math.ceil((100.0-progresses[i])/speeds[i])));
        }

        System.out.println(queue);

        List<Integer> answer = new ArrayList<Integer>();

        while(!queue.isEmpty()){
            int day = queue.poll();
            int count = 1;

            //큐에서 뺄게 있어야하며, day의 값이 큐에서 뺄값보다 커야한다.
            while(!queue.isEmpty() && day >= queue.peek()){
                count++;
                queue.poll();
            }
            answer.add(count);
        }

        System.out.println(answer);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}