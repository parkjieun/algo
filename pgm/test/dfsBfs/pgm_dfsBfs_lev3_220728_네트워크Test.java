package dfsBfs;

import org.junit.Test;

import static org.junit.Assert.*;

public class pgm_dfsBfs_lev3_220728_네트워크Test {
    pgm_dfsBfs_lev3_220728_네트워크 t = new pgm_dfsBfs_lev3_220728_네트워크();

    @Test
    public void solution() {
        //assertEquals(1,t.solution(1,new int[][]{{1, 0, 0, 1},{0, 1, 1, 0},{0, 1, 1, 0},{1, 1, 0, 1}}));
        assertEquals(2,t.solution(3,new int[][]{{1 , 1, 0},{1, 1, 0},{0, 0, 1}}));
        //int[][] computers = {{1,1,0,1,0,0,0},{1,1,0,0,0,0,0},{0,0,1,0,0,1,0},{1,0,0,1,1,0,0},{0,0,0,1,1,0,0},{0,0,1,0,0,1,0},{0,0,0,0,0,0,1}}; //0부터 n-1인 정수로 표현
        //int[][] computers = {{1 , 1, 0},{1, 1, 1},{0, 1, 1}};
    }
}