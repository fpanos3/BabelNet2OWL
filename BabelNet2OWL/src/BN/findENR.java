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
public class findENR {
	    @SuppressWarnings("deprecation")
		public static void main(String[] args) throws IOException 
		{
	    	BabelNet bn = BabelNet.getInstance();
			BabelNetQuery query = new BabelNetQuery.Builder("computer")
				.from(Language.EN)
				.to(Language.EN)
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
	            		//System.out.println("RELACION 1 - IS A " );
	            		int counter1 = by.getOutgoingEdges(BabelPointer.WIKIDATA_HYPONYM).size();
	            		for(BabelSynsetRelation edge : by.getOutgoingEdges(BabelPointer.ANY_HYPERNYM)) 
            			{	
	            			if(counter1 != 9999){
	           					System.out.println(//"1: " + counter1 + "-" + 
	           						by.getID() + "\t" 
	           						+ by.getMainSense(Language.EN).get().getFullLemma() + "\t"
            						+ "isA" + "\t"
            						//+ edge.getPointer() + "\t"
            						+ edge.getBabelSynsetIDTarget() + "\t"
            						+ edge.getBabelSynsetIDTarget().toSynset().getMainSense(Language.EN).get().getFullLemma().toString() + "\t");
	            				counter1++;
	            			}	
            			}
	            		
	            		//Relación PART OF
	            		//System.out.println("RELACION 2 - PART OF " );
	            		int counter2 = by.getOutgoingEdges(BabelPointer.WIKIDATA_HYPONYM).size();
	            		for(BabelSynsetRelation edge : by.getOutgoingEdges(BabelPointer.HOLONYM_PART)) 
            			{	
	            			if(counter2 != 9999){
	            			System.out.println(//"2: " + counter2 + "-" + 
	            					by.getID() + "\t" 
	           						+ by.getMainSense(Language.EN).get().getFullLemma() + "\t"
            						+ "partOf" + "\t"
            						//+ edge.getPointer() + "\t"
            						+ edge.getBabelSynsetIDTarget() + "\t"
            						+ edge.getBabelSynsetIDTarget().toSynset().getMainSense(Language.EN).get().getFullLemma() + "\t");
	            			counter2++;
	            			}
            			}	
	            		
	            		//Relación HAS PART
	            		//System.out.println("RELACION 3 - HAS PART " );
	            		int counter3 = by.getOutgoingEdges(BabelPointer.WIKIDATA_HYPONYM).size();
	            		for(BabelSynsetRelation edge : by.getOutgoingEdges(BabelPointer.ANY_HOLONYM)) 
            			{	
	            			if(counter3 != 9999){
	            			System.out.println(//"3: " + counter3 + "-" + 
	            					by.getID() + "\t" 
	           						+ by.getMainSense(Language.EN).get().getFullLemma() + "\t"
            						+ "hasPart" + "\t"
            						//+ edge.getPointer() + "\t"
            						+ edge.getBabelSynsetIDTarget() + "\t"
            						+ edge.getBabelSynsetIDTarget().toSynset().getMainSense(Language.EN).get().getFullLemma() + "\t");
	            			counter3++;
	            			}
	            			
            			}
	            		
	            		//Relación HAS KIND
	            		//System.out.println("RELACION 4 - HAS KIND " );
	            		//System.out.println("ELE: " + by.getOutgoingEdges(BabelPointer.WIKIDATA_HYPONYM).size());
	            		int counter4 = by.getOutgoingEdges(BabelPointer.WIKIDATA_HYPONYM).size();
	            		for(BabelSynsetRelation edge : by.getOutgoingEdges(BabelPointer.WIKIDATA_HYPONYM)) 
	            			{
	            			if(counter4 != 89){
	            				System.out.println(//"4: " + counter4 + "-" + 
	            						by.getID() + "\t" 
	            						+ by.getMainSense(Language.EN).get().getFullLemma() + "\t"
	            						+ "hasKind" + "\t"
	            						//+ edge.getPointer() + "\t"
	            						+ edge.getBabelSynsetIDTarget() + "\t"
	            						+ edge.getBabelSynsetIDTarget().toBabelSynset().getMainSense(Language.EN).get().getFullLemma() + "\t");
	            				counter4++;
	            			}
	            		}
	            			
	            		
	            		//Relación HAS INSTANCE
	            		//System.out.println("RELACION 5 - HAS INSTANCE " );
	            		//System.out.println("ELE: " + by.getOutgoingEdges(BabelPointer.WIKIDATA_HYPONYM).size());
	            		int counter5 = by.getOutgoingEdges(BabelPointer.WIKIDATA_HYPONYM).size();
		            	{
		            		for(BabelSynsetRelation edge : by.getOutgoingEdges(BabelPointer.WIKIDATA_HYPONYM_INSTANCE)) 
	            				{	
		            			if(counter5 != 75){
		            				System.out.println(//"5: " + counter5 + "-" + 
		            					by.getID() + "\t" 
		            					+ by.getMainSense(Language.EN).get().getFullLemma() + "\t"
		            					+ "hasInstance" + "\t"
		            					//+ edge.getPointer() + "\t"
		            					+ edge.getBabelSynsetIDTarget() + "\t"
		            					+ edge.getBabelSynsetIDTarget().toSynset().getMainSense(Language.EN).get().getFullLemma() + "\t");
		            				counter5++;
		            			}
	            				}	
		            	}	
	            		
	            				//System.out.println("Synset ID: " + synset.isKeyConcept());
	            				//System.out.println("Synset ID: " + synset.toString());
	            				//System.out.println("Synset ID: " + synset.getOutgoingEdges());	            
	            	}

	        	}
		}
	    //Fin de la Clase
}