package BN;
import java.io.IOException;

import it.uniroma1.lcl.babelnet.BabelNet;
import it.uniroma1.lcl.babelnet.BabelSense;
import it.uniroma1.lcl.babelnet.BabelSynsetID;
import it.uniroma1.lcl.babelnet.data.BabelAudio;
import it.uniroma1.lcl.babelnet.data.BabelSensePhonetics;

public class BabelNetSense {
    public static void main(String[] args) throws IOException {
        BabelNet bn = BabelNet.getInstance();
        for (BabelSense sense : bn.getSynset(new BabelSynsetID("bn:00021464n")).getSenses()) {
            System.out.println("Sense: " + sense.getFullLemma()
                            + "\tLanguage: " + sense.getLanguage().toString()
                            + "\tSource: " + sense.getSource().toString());
            BabelSensePhonetics phonetic = sense.getPronunciations();
            for (BabelAudio audio : phonetic.getAudioItems()) {
                System.out.println("Audio URL " + audio.getValidatedUrl());
            }
        }
    }
}