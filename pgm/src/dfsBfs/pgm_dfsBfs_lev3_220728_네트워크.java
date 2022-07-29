package dfsBfs;

import java.util.LinkedList;
import java.util.Queue;

//computers = {{1, 0, 0, 1},{0, 1, 1, 0},{0, 1, 1, 0},{1, 1, 0, 1}}; 테스트 케이스
public class pgm_dfsBfs_lev3_220728_네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
           //1.방문체크
            if(!visited[i]){
                //2. 관련노드 탐색
                //dfs(visited, computers,i,n);
                bfs(visited,computers,i,n);
                //3. 네트워크 카운트
                answer++;
            }
        }
        return answer;
    }

    private void bfs(boolean[] visited, int[][] computers, int i, int n) {
        Queue<Integer> q = new LinkedList();
        q.offer(i);
        visited[i] = true;

        while (!q.isEmpty()){
            int node = q.poll();

            for (int j = 0; j < n; j++) {
                if(!visited[j] && computers[node][j] == 1){
                    q.offer(j);
                    visited[j] = true;
                }
            }
        }

    }

    private void dfs(boolean[] visited, int[][] computers, int i, int len) {
        visited[i] = true;

        for (int j = 0; j < len; j++) {
            if(!visited[j] && computers[i][j] == 1){
                dfs(visited, computers, j, len);
            }
        }
    }
}

/*
문제 설명
네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다.
예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고, 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다.
따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.

컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.

제한사항
컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다.
각 컴퓨터는 0부터 n-1인 정수로 표현합니다.
i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
computer[i][i]는 항상 1입니다.

입출력 예
n	computers	return
3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1

입출력 예 설명
 */