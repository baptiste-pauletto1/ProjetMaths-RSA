package fr.univ_amu.iut;


import java.math.BigInteger;
import java.util.ArrayList;
import java.lang.Math;

/**
 * Created by p16005334 on 20/10/17.
 */
public class EncodeurDecodeur{

    public EncodeurDecodeur(){}

    public int coder (int a, int e, int n){
        BigInteger M = BigInteger.valueOf(a);
        BigInteger N = BigInteger.valueOf(n);
        M = M.pow(e);
        M = M.mod(N);
        int m = M.intValue();
        return m;
    }

    public ArrayList<Integer> decoder (ArrayList<Integer> listeCodee, int d, int n){
        ArrayList<Integer> listeDecodee = new ArrayList<Integer>();
        for (int i = 0; i < listeCodee.size(); i++) {
            listeDecodee.add(coder(listeCodee.get(i),d,n));
        }
        return listeDecodee;
    }
}