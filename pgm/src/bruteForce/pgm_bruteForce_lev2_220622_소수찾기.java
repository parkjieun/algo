package bruteForce;

import java.util.*;

public class pgm_bruteForce_lev2_220622_소수찾기 {
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

		System.out.println("set = " + set.size());
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

		boolean flag = false;
		if(n==1 || n==0){
			return;
		}

		for (int i = 2; i < n; i++) {
			if(n%i == 0) {
				flag = true;
				break;
			}
		}

		if(!flag){
			set.add(n);
		}
		return;
	}
}
/*
소수
1 2 3 5 7 11 13 17 19 .. = 1* n
4= 2*2
6= 2*3
8=2*4 ...

한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

제한사항
numbers는 길이 1 이상 7 이하인 문자열입니다.
numbers는 0~9까지 숫자만으로 이루어져 있습니다.
"013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.

numbers	return
"17"	3
"011"	2

입출력 예 설명
예제 #1
[1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.

예제 #2
[0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.

* 11과 011은 같은 숫자로 취급합니다.
 */