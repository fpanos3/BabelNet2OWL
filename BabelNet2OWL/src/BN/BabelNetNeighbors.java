package BN;

import java.io.IOException;

import it.uniroma1.lcl.babelnet.BabelNet;
import it.uniroma1.lcl.babelnet.BabelSynset;
import it.uniroma1.lcl.babelnet.BabelSynsetID;
import it.uniroma1.lcl.babelnet.BabelSynsetRelation;
import it.uniroma1.lcl.babelnet.data.BabelPointer;
import it.uniroma1.lcl.jlt.util.Language;

public class BabelNetNeighbors {
    public static void main(String[] args) throws IOException {
        BabelNet bn = BabelNet.getInstance();
        BabelSynset by = bn.getSynset(new BabelSynsetID("bn:00021464n"));
        for(BabelSynsetRelation edge : by.getOutgoingEdges(BabelPointer.ANY_HYPERNYM)) {
            System.out.println(by.getID()+"\t"+by.getMainSense(Language.EN).get().getFullLemma()+" - "
                + edge.getPointer()+" - "
                + edge.getBabelSynsetIDTarget());
        }
    }
}