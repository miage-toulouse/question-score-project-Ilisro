package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ScoreCalculateurTest {

    private ScoreCalculateur scoreCalculateur;
    private QuestionAChoixMultiple questionAChoixMultiple;

    @Before
    public void setUp() throws Exception {
        //Given : une instance de question à choix multiple
        scoreCalculateur = new ScoreCalculateur();
        questionAChoixMultiple = new QuestionAChoixMultiple("q1",new ArrayList<Integer>(Arrays.asList(2,3,5)));
    }

    @Test
    public void testCalculeScoreMauvaisesReponses() {
        //WHEN
        ArrayList<Integer> indicesEtu = new ArrayList<>(Arrays.asList(1,4));
        //THEN
        float resScore = scoreCalculateur.calculeScore(indicesEtu, questionAChoixMultiple);
        assertEquals(0f, resScore, 0.01f);
    }

    @Test
    public void testCalculeScore2BonnesReponses() {
        //WHEN
        ArrayList<Integer> indicesEtu = new ArrayList<>(Arrays.asList(2,3));
        //THEN
        float resScore = scoreCalculateur.calculeScore(indicesEtu, questionAChoixMultiple);
        float res2BonnesReponses = 2*100/3f;
        assertEquals(res2BonnesReponses, resScore, 0.01f);
    }

    @Test
    public void testCalculeScore3BonnesReponses() {
        //WHEN
        ArrayList<Integer> indicesEtu = new ArrayList<>(Arrays.asList(2,3, 5));
        //THEN
        float resScore = scoreCalculateur.calculeScore(indicesEtu, questionAChoixMultiple);
        assertEquals(100f, resScore, 0.01f);
    }
}