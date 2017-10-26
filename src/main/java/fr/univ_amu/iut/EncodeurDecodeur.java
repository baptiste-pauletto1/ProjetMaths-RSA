package fr.univ_amu.iut;


import java.util.ArrayList;
import java.lang.Math;

/**
 * Created by p16005334 on 20/10/17.
 */
public class EncodeurDecodeur{

    public EncodeurDecodeur(){}

    public Integer coder (Integer a, Integer e, Integer n){
        double M1;
        M1 = Math.pow(a,e) % n;
        return (int) M1;
    }

    public ArrayList<Integer> decoder (ArrayList<Integer> listeCodee){
        int d = 0;
        int n = 7;
        ArrayList<Integer> listeDecodee = new ArrayList<Integer>();
        for(Integer i : listeCodee){
            listeDecodee.add(coder(listeCodee.get(i),d, n));
        }
        return listeDecodee;
    }
}