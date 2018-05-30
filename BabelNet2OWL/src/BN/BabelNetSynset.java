package BN;
import it.uniroma1.lcl.babelnet.BabelNet;
import it.uniroma1.lcl.babelnet.BabelSynset;
import it.uniroma1.lcl.jlt.util.Language;
import java.io.IOException;

public class BabelNetSynset {
    public static void main(String[] args) throws IOException {
        BabelNet bn = BabelNet.getInstance();
        for (BabelSynset synset : bn.getSynsets("home", Language.EN)) {
            System.out.println("Synset ID: " + synset.getID());
        }
    }
}