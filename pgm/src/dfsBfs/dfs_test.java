package dfsBfs;

import java.util.Arrays;

public class dfs_test {
	static int [] arr;
	static int [] result; //결과저장배열
	static boolean [] visited; //방문여부체크
	public static void main(String[] args) {
		arr = new int[]{1, 2,  3};
		result = new int[arr.length];
		visited = new boolean[arr.length];

		for (int i = 0; i < arr.length; i++) {
			dfs(0, i+1);
		}

	}
	static void dfs(int depth, int r){	//depth 탐색인덱스		r 뽑고자하는 순열개수
		//종료
		if(depth == r){
			System.out.println("result = " + Arrays.toString(result));
			return;
		}

		for (int i = 0; i <arr.length ; i++) {
			if(!visited[i]){
				visited[i]=true;
				result[depth] = arr[i];
				dfs(depth+1,r);
				visited[i]=false;
			}
		}

	}
}