package bruteForce;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class bruteForce_lev2_220622_2 {
	static String[] arr;
	static String[] result;
	static boolean[] visited;
	static Set<Integer> set = new HashSet<>();
	public static void main(String[] args) {
		String numbers = "110";
		arr = numbers.split("");
		result = new String[arr.length];
		visited = new boolean[arr.length];
		System.out.println("Arrays.toString(strArray) = " + Arrays.toString(arr));

		for (int i = 0; i < arr.length; i++) {
			dfs(0,i+1);
		}

		//소수
		for(Integer n : set){
			boolean flag = false;
			if(n==1 || n==0){
				return;
			}

			for (int i=2; i<n; i++) {
				if(n%i == 0) {
					set.remove(n);
					break;
				}
			}
		}

		System.out.println("*******set = " + set.size());
	}
	static void dfs(int depth, int size){

		if(depth == size){
			System.out.println("result = " + Arrays.toString(result));
			chk(result);
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if(!visited[i]){
				visited[i]=true;
				result[depth]=arr[i];
				dfs(depth+1,size);
				visited[i]=false;
			}
		}
	}

	private static void chk(String[] result) {
		String str = "";
		for (String s : result) {
			if (s == null) {
				break;
			}
			str += s;
		}

		int n = Integer.parseInt(str.substring(0,1));
		for (int i = 1; i < str.length(); i++) {
			n += Integer.parseInt(str.substring(i,i+1))*Math.pow(10,i);
		}
		System.out.println("n = " + n);

		set.add(n);

		return;
	}
}