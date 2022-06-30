package dfsBfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class dfs_test2 {
	static HashSet<String> set = new HashSet<>();

	public static void main(String[] args) {
		String numbers = "123";

		dfs(0,"",numbers);

		System.out.println("*******set = " + set.size());
	}

	static void dfs(int flag, String s, String numbers){
		if(numbers.length()==0){
			System.out.println(flag+"s = " + s);
			set.add(s);
		}else{
			for (int i = 0; i < numbers.length(); i++) {
				dfs(i,s+numbers.charAt(i), numbers.substring(0, i) + numbers.substring(i + 1, numbers.length()));
			}
			for (int i = 0; i < numbers.length(); i++) {
				dfs(i,s,numbers.substring(0, i) + numbers.substring(i + 1, numbers.length()));
			}
		}
	}
}