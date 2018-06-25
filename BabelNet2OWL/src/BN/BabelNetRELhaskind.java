package BN;

/************************************************************************
 * Directora del TFM: Ana Mar�a Garc�a Serrano
 * Alumno: Francisco Jos� Pa�os Merino
 * Email: fpanos3@alumno.uned.es
 * Centro Asociado: Zamora
 * Trabajo Fin de M�ster
 * Enriqueciemiento Sem�ntico de Ontolog�as de Dominio
 * Experimentaci�n en una Ontolog�a Inform�tica
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

//Clase para obtenci�n de 
public class BabelNetRELhaskind {


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
	            		
	            		//Relaci�n IS A
	            		System.out.println("RELACION 1 - HAS KIND " );
	            		for(BabelSynsetRelation edge : by.getOutgoingEdges(BabelPointer.WIKIDATA_HYPONYM)) 
            			{			
	            			System.out.println(by.getID() + "\t" 
	            					+ by.getMainSense(Language.EN).get().getFullLemma() + "\t"
            						+ "hasKind" + "\t"
            						//+ edge.getPointer() + "\t"
            						+ edge.getBabelSynsetIDTarget() + "\t"
            						//El synset bn:04642370n no tiene Lema, est� en cir�lico y se rompe el listado
            						+ edge.getBabelSynsetIDTarget().toSynset().getMainSense(Language.EN).get().getFullLemma() + "\t");	
            			}
	            	}
	        	}
		}
//Fin de la Clase
}