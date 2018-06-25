package BN;

/************************************************************************
 * Directora del TFM: Ana María García Serrano
 * Alumno: Francisco José Paños Merino
 * Email: fpanos3@alumno.uned.es
 * Centro Asociado: Zamora
 * Trabajo Fin de Máster
 * Enriqueciemiento Semántico de Ontologías de Dominio
 * Experimentación en una Ontología Informática
 * Curso 2017 - 2018
 ************************************************************************/

//Imports
import it.uniroma1.lcl.babelnet.BabelNet;
import it.uniroma1.lcl.babelnet.BabelNetQuery;
import it.uniroma1.lcl.babelnet.BabelSynset;
import it.uniroma1.lcl.babelnet.BabelSynsetID;
import it.uniroma1.lcl.babelnet.BabelSynsetRelation;
import it.uniroma1.lcl.babelnet.data.BabelPointer;
import it.uniroma1.lcl.jlt.util.Language;

import java.io.IOException;
import java.util.Arrays;

//Clase para obtención de 
public class BabelNetRELisa {


	    @SuppressWarnings("deprecation")
		public static void main(String[] args) throws IOException 
		{
	    	BabelNet bn = BabelNet.getInstance();
			BabelNetQuery query = new BabelNetQuery.Builder("computer")
				.from(Language.EN)
				.to(Arrays.asList(Language.IT, Language.FR))
				.build();
			
			//Bucle para los terminos iniciales, solo CONCEPTOS
	        for (BabelSynset synset : bn.getSynsets(query)) 
	        	{
	            //System.out.print("Synset ID: " + synset.getID());
	            //System.out.println("Synset ID: " + synset.getCategories().toString());
	            if(synset.getSynsetType().toString() == "Concept")
	            	{
	            		//System.out.println("Synset ID: " + synset.getSynsetType());
	            		BabelSynset by = bn.getSynset(new BabelSynsetID(synset.getID().toString()));
	            		
	            		//Relación IS A
	            		System.out.println("RELACION 1 - IS A " );
	            		for(BabelSynsetRelation edge : by.getOutgoingEdges(BabelPointer.ANY_HYPERNYM)) 
            			{			
	            			System.out.println(by.getID() + "\t" 
	            					+ by.getMainSense(Language.EN).get().getFullLemma() + "\t"
            						+ "isA" + "\t"
            						//+ edge.getPointer() + "\t"
            						+ edge.getBabelSynsetIDTarget() + "\t"
            						+ edge.getBabelSynsetIDTarget().toSynset().getMainSense(Language.EN).get().getFullLemma() + "\t");	
            			}
	            	}
	        	}
		}
//Fin de la Clase
}