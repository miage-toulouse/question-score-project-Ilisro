package miagem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionAChoixExclusifTest {

    private QuestionAChoixExclusif questionE;

    @Before
    public void setUp() throws Exception {
        //Given : une instance de question à choix exclusif
        questionE = new QuestionAChoixExclusif("Quel est la différence entre un pigeon ?", 2);
    }

    @Test
    public void testGetEnonce() {
        //When : on demande son énoncé à la question
        String res = questionE.getEnonce();
        //Then : l'énoncé retourné est l'énoncé fourni à la construction de la question
        assertEquals("Quel est la différence entre un pigeon ?", res);
    }

    @Test
    public void testGetScoreForIndiceBR() {
        //When : on demande l'indice de la réponse
        int indiceEtu = 2;
        //And : on demande le score de l'indice à la question
        float resScore = questionE.getScoreForIndice(indiceEtu);
        //Then : le score obtenu est 100
        assertEquals(100f, resScore, 0.01f);
    }

    @Test
    public void testGetScoreForIndiceMR() {
        //When : on demande l'indice de la réponse
        int indiceEtu = 1;
        //And : on demande le score de l'indice à la question
        float resScore = questionE.getScoreForIndice(indiceEtu);
        //Then : le score obtenu est 0
        assertEquals(0f, resScore, 0.01f);
    }
}