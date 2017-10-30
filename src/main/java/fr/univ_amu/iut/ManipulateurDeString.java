package fr.univ_amu.iut;

import java.util.ArrayList;

/**
 * Created by p16005334 on 20/10/17.
 */
public  class ManipulateurDeString {


    public static ArrayList<Integer> decouperString(String string)
    {
        ArrayList<Integer> chaineEnAscii = new ArrayList<Integer>();
        for (int i = 0; i<string.length();i++ ) {
            chaineEnAscii.add((int)string.charAt(i));
        }
        return chaineEnAscii;
    }

    public static String reformerString(ArrayList<Integer> chaineDecodee){
        String Message = new String();
        for(Integer i : chaineDecodee){
            Message += (char) (i.intValue());
        }
        return Message;
    }
}
