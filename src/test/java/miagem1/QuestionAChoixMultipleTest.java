package miagem1;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class QuestionAChoixMultipleTest {

    private QuestionAChoixMultiple questionM;

    @Before
    public void setUp() throws Exception {
        //Given : une instance de question à choix exclusif
        ArrayList<Integer> bonnesReponses = new ArrayList<Integer>();
        bonnesReponses.add(2);
        bonnesReponses.add(3);
        questionM = new QuestionAChoixMultiple("Quel est la différence entre un canard ?", bonnesReponses);
    }

    @Test
    public void testGetEnonce() {
        //When : on demande son énoncé à la question
        String res = questionM.getEnonce();
        //Then : l'énoncé retourné est l'énoncé fourni à la construction de la question
        assertEquals("Quel est la différence entre un canard ?", res);
    }

    @Test
    public void testGetScoreForIndiceBonnesRéponses() {
        //When : on demande l'indice de la réponse
        int indiceEtu = 2;
        //And : on demande le score de l'indice à la question
        float resScore = questionM.getScoreForIndice(indiceEtu);

        //Then : le score obtenu est 100
        assertEquals(50f, resScore, 0.01f);
    }

    @Test
    public void testGetScoreForIndiceMauvaiseReponses() {
        //When : on demande l'indice de la réponse
        int indiceEtu = 1;
        //And : on demande le score de l'indice à la question
        float resScore = questionM.getScoreForIndice(indiceEtu);
        //Then : le score obtenu est 0
        assertEquals(0f, resScore, 0.01f);
    }

}