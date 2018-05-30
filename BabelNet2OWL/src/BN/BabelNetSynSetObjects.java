package BN;
	import it.uniroma1.lcl.babelnet.BabelNet;
import it.uniroma1.lcl.babelnet.BabelNetQuery;
import it.uniroma1.lcl.babelnet.BabelSynset;
import it.uniroma1.lcl.jlt.util.Language;

import java.io.IOException;
import java.util.Arrays;

public class BabelNetSynSetObjects {


	    public static void main(String[] args) throws IOException {
	    	BabelNet bn = BabelNet.getInstance();
			BabelNetQuery query = new BabelNetQuery.Builder("computer")
				.from(Language.EN)
				.to(Arrays.asList(Language.IT, Language.FR))
				.build();
	        for (BabelSynset synset : bn.getSynsets(query)) {
	            System.out.println("Synset ID: " + synset.getID());
	        }

	    }
	}
