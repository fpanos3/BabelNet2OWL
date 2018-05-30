package BN;
import java.io.IOException;

import it.uniroma1.lcl.babelnet.BabelNet;
import it.uniroma1.lcl.babelnet.BabelSense;
import it.uniroma1.lcl.babelnet.BabelSynset;
import it.uniroma1.lcl.babelnet.BabelSynsetID;
import it.uniroma1.lcl.babelnet.data.BabelSenseSource;

public class BabelNetSenseWikidataAll {
    public static void main(String[] args) throws IOException {
       BabelNet bn = BabelNet.getInstance();
       BabelSynset by = bn.getSynset(new BabelSynsetID("bn:00021464n"));
       for (BabelSense sense : by.getSenses(BabelSenseSource.WIKIDATA)) {
           String sensekey = sense.getSensekey();
           System.out.println(sense.getFullLemma() + "\t" + sense.getLanguage() + "\t" + sensekey);
       }
   }
}