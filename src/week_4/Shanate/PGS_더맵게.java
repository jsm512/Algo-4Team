package week_4.Shanate;

import java.util.PriorityQueue;
/*
1, 2 ,3 ,9, 10, 12
7
1 + 2*2 = 5 => 3, 5, 9, 10, 12
3 + 5*2 = 13 => 9, 10, 12, 13
*/


public class PGS_더맵게 {
    static int solution(int[] scoville, int K) {
        int answer = 0;
        int count = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int numbers : scoville) {
            pq.offer(numbers); // 1, 2, 3, 9, 10, 12
        }
        while(pq.peek()<K && pq.size() > 1){ // 단독 pq.peek()<=K 조건을 사용했을 경우, 원소가 하나 남았을 때 두 개를 뽑으려 하기에 nullpointer가
                            // 발생하기 때문에 추가로 사이즈를 알 수 있도록 조건 추가 설정 필요

            int a = pq.poll();
            int b = pq.poll() * 2;
            pq.offer(a + b);
            count++;
        }
        if(pq.peek()<K){
            return -1;
        }

        return count;
    }

    public static void main(String[] args) throws Exception {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(solution(scoville, K));
    }
}
