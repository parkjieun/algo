package bruteForce;

import java.util.*;

public class bruteForce_lev1_210716 {
	public static void main(String[] args) {

		int[] answers= {1,3,2,4,2};
		int[] case1 = { 1, 2, 3, 4, 5 };
		int[] case2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] case3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		Integer[] cnt = new Integer[3]; // 각 학생이 맞은 갯수 배열
		Arrays.fill(cnt, 0); // 0초기화

		for (int i = 0; i < answers.length; i++) {
			// 0번문제 = case[0]
			// 1번문제 = case[1]
			// 2번문제 = case[2]
			// 3번문제 = case[3]
			// 4번문제 = case[4]
			// 5번문제 = case[0] = 5-5*(5 / 5)
			// 6번문제 = case[1] = 6-5*(6 / 5)
			// ......
			// 10번문제 = case[0] = 10-5*(10 / 5)

			if (answers[i] == case1[i - 5 * (i / 5)])
				cnt[0]++;
			if (answers[i] == case2[i - 8 * (i / 8)])
				cnt[1]++;
			if (answers[i] == case3[i - 10 * (i / 10)])
				cnt[2]++;
		}

		int max = 0;
		List<Integer> list = new ArrayList<>();

		// Collections.reverseOrder()의 경우 ,int[] 배열 을 정렬 할 수 업습니다.
		// for문으로 역순 넣기
		// Integer_arr[i] = Integer.valueOf(origin_arr[i]);

		// Arrays.sort(cnt, Collections.reverseOrder());
		// max = cnt[0];

		// 가장 큰값 찾기
		for (int i : cnt) {
			if (max < i)
				max = i;
		}

		// 가장 큰 값을 가진 사람 찾기
		for (int i = 0; i < 3; i++) {
			if (cnt[i] == max)
				list.add(i);
		}

		// 오름차순
		// Collections.sort(list, Collections.reverseOrder());

		int[] answer = new int[list.size()];

		// 정답에 담기
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i) + 1;
		}

		// 동일정답시, 오름차순
		Arrays.sort(answer);
		
		System.out.println(Arrays.toString(answer));
	}
}
