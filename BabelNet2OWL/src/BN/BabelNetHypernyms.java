package BN;

import java.io.IOException;

import it.uniroma1.lcl.babelnet.BabelNet;
import it.uniroma1.lcl.babelnet.BabelSynset;
import it.uniroma1.lcl.babelnet.BabelSynsetID;
import it.uniroma1.lcl.jlt.util.Language;

public class BabelNetHypernyms {
    @SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
        BabelNet bn = BabelNet.getInstance();
        BabelSynset by = bn.getSynset(new BabelSynsetID("bn:00021464n"));
        for(String form : by.getOtherForms(Language.EN)) {
            System.out.println(by.getID()+"\t"+by.getMainSense(Language.EN).get().getFullLemma()+" - "
                + form);
        }
    }
}