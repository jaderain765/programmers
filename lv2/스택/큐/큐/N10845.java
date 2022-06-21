package lv2.스택.큐.큐;

import java.util.*;

class N10845{
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int back = -1;
        for(int i = 0; i < num; i++){
            String str = sc.next();
            if(str.equals("push")){
                int n1 = sc.nextInt();
                queue.add(n1);
                back = n1;
            }else if(str.equals("pop")){
                if(!queue.isEmpty()){
                    int n = queue.poll();
                    System.out.println(n);
                }else{
                    System.out.println(-1);
                }
            }else if(str.equals("size")){
                System.out.println(queue.size());
            }else if(str.equals("empty")){
                if(queue.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }else if(str.equals("front")){
                if(queue.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(queue.peek());
                }
            }else if(str.equals("back")){
                if(queue.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(back);
                }
            }
        }
        sc.close();
    }
}