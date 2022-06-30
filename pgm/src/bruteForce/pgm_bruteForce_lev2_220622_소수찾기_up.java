package bruteForce;

import java.util.HashSet;
import java.util.TreeSet;

public class pgm_bruteForce_lev2_220622_소수찾기_up {
	static TreeSet<Integer> ts = new TreeSet<>();

	public static void main(String[] args) {
		String numbers = "123";
		int answer = 0,check,i;
		func("",numbers);

		for(int num:ts){
			check=0;
			for(i=2;i<num;i++){
				if(num%i==0)
					break;
			}
			if(i==num)
				answer++;
		}
		System.out.println("answer = " + answer);
	}

	public static void func(String s, String number) {
		if (number.length() == 0) {
			if(!s.equals(""))
				ts.add(Integer.parseInt(s));
		} else {
			for (int i = 0; i < number.length(); i++)
				func(s + number.charAt(i), number.substring(0, i) + number.substring(i + 1, number.length()));
			for (int i = 0; i < number.length(); i++)
				func(s , number.substring(0, i) + number.substring(i + 1, number.length()));
		}
	}
}