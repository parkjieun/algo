package dfsBfs;

import org.junit.Test;

import static org.junit.Assert.*;

public class pgm_dfsBfs_lev3_220729_단어변환Test {
    pgm_dfsBfs_lev3_220729_단어변환 p = new pgm_dfsBfs_lev3_220729_단어변환();

    @Test
    public void solution() {
        //assertEquals(4, p.solution("hit","cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        assertEquals(0, p.solution("coh","cog", new String[]{"cog"}));
    }

    @Test
    public void check(){
        assertEquals(false,p.check("hit","hoo"));
    }
}