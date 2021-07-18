package bruteForce;

import java.util.*;

public class bruteForce_lev1_210717_up {
	public static void main(String[] args) {

		int[] answers= {1,3,2,4,2};
		int[] case1 = { 1, 2, 3, 4, 5 };
		int[] case2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] case3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		int[] cnt = new int[3]; // 각 학생이 맞은 갯수 배열

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == case1[i % 5])
				cnt[0]++;
			if (answers[i] == case2[i % 8])
				cnt[1]++;
			if (answers[i] == case3[i % 10])
				cnt[2]++;
		}

		List<Integer> list = new ArrayList<>();

		// 가장 큰값 찾기
		int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));

		// 가장 큰 값을 가진 사람 찾기
		if (cnt[0] == max) list.add(1);
		if (cnt[1] == max) list.add(2);
		if (cnt[2] == max) list.add(3);

		int[] answer = new int[list.size()];

		// 정답에 담기
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		// 동일정답시, 오름차순
		Arrays.sort(answer);
		
		System.out.println(Arrays.toString(answer));
	}
}
