package dfsBfs;

import java.util.LinkedList;
import java.util.Queue;

public class pgm_dfsBfs_lev3_220729_단어변환 {
    static int answer=60;

    public int solution(String begin, String target, String[] words) {
        for (int i = 0; i < words.length; i++) {
            //begin에서 word 값이 한개만 변하는 지 체크
            if(check(begin,words[i])){
                bfs(words, words[i], target, i);
            }
        }

        return answer==60?0:answer;
    }


    private void bfs(String[] words, String begin, String target, int startIdx) {
        // 선언
        boolean[] visited = new boolean[words.length];
        Queue<Object[]> q = new LinkedList<>(); //word, 단계
        //q 담고 방문체크
        q.offer(new Object[]{begin,1});
        visited[startIdx] = true;

        //while q 없을떄 까지
        while (!q.isEmpty()){
            //1.q값 빼기
            Object[] cur = q.poll();
            String word = (String)cur[0];
            int step = (int)cur[1];

            //2. target 값인지 체크
            if(word.equals(target)){
                //2-1. target 값 이면, 최소값인지 확인 후 값에 저장
               answer = Math.min(answer,step);
            }

            //2-2. target 값 아니면, 한개만 변하는지 체크 + 방문체크
            for (int i = 0; i < words.length; i++) {
                if(!visited[i] && check(word,target)){
                    //2-2-1. true이면 q에 word값 넣기, 단계+1
                    q.offer(new Object[]{words[i],step+1});
                    visited[i] = true;
                }
            }
        }
    }

    //한개만 변하는지 체크함수
    protected boolean check(String begin, String word) {
        int diff = 0;

        for (int i = 0; i < begin.length(); i++) {
            if(diff > 1) {
                return false;
            }
            if(begin.charAt(i)!=word.charAt(i)){
                diff++;
            }
        }
        return diff < 2;
    }
}

/*
두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.

1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
2. words에 있는 단어로만 변환할 수 있습니다.
예를 들어 begin이 "hit", target가 "cog", words가 ["hot","dot","dog","lot","log","cog"]라면 "hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.

두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.

제한사항
각 단어는 알파벳 소문자로만 이루어져 있습니다.
각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
begin과 target은 같지 않습니다.
변환할 수 없는 경우에는 0를 return 합니다.

입출력 예
begin	target	words	                                    return
"hit"	"cog"	["hot", "dot", "dog", "lot", "log", "cog"]	4
"hit"	"cog"	["hot", "dot", "dog", "lot", "log"]     	0
입출력 예 설명
예제 #1
문제에 나온 예와 같습니다.

예제 #2
target인 "cog"는 words 안에 없기 때문에 변환할 수 없습니다.
 */