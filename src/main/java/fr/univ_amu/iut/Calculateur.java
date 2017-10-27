package fr.univ_amu.iut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.sqrt;

/**
 * Created by p16005334 on 20/10/17.
 */
public class Calculateur {

    private int p;
    private int q;
    private int n;
    private int phin;
    private int e;
    private int d;

    public Calculateur() {
        System.out.printf("Calculateur créé." + "\n");
        calculersValeurs();
    }

    private void calculersValeurs () {
        rentrer_pEtq();
        calculer_n();
        calculer_phin();
        calculer_e();
        System.out.println("Clé publique (" + e + ',' + n + ')');
        calculer_d();
        System.out.println("Clé privée (" + d + ',' + n + ')');
    }

    private int menu(String string) {
        String choix = " ";
        System.out.println(string);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            choix = in.readLine();
        } catch (IOException e) {
            System.out.println("Problème de saisie");
        }
        return Integer.parseInt(choix);
    }

    private boolean testPrimalite (int valeur) {
        if (valeur == 2)
            return true;
        if (valeur % 2 == 0 || valeur == 0 || valeur == 1)
            return false;
        for(int i = 3; i < (int) sqrt(valeur); i+= 2)
            if (valeur % i == 0)
                return false;
        return true;
    }

    private int PGCD(int a, int b){
        if (a<b){
            int u = 0;
            u = a;
            a = b;
            b = u;
        }
        int c = 1;
        while (c!=0){
            c = a%b;
            a = b;
            b = c;
        }
        return a;
    }

    private int inverseModulaire () {
        int r = e;
        int d = 1;
        int v = 0;
        int r0 = phin;
        int d0 = 0;
        int v0 = 1;

        while(r0 != 0) {
            int q =  (r/ r0);
            int rs = r;
            int ds = d;
            int vs = v;

            r = r0;
            d = d0;
            v = v0;
            r0 = rs-q*r0;
            d0 = ds - q* d0;
            v0 = vs - q * v0;
        }
        return d;
    }

    private void rentrer_pEtq () {
        int p = menu("Veuillez insérer p, nombre premier");
        while (!testPrimalite(p)) {
            System.out.println("Il n'est pas premier. Exemple de nombres premiers : 2, 3, 5, 7, 11, 13, 17, 23, 31...");
            p = menu("Veuillez insérer p, nombre premier");
        }
        this.p = p;

        int q = menu("Veuillez insérer q, nombre premier");
        while (!testPrimalite(q)) {
            System.out.println("Il n'est pas premier. Exemple de nombres premiers : 2, 3, 5, 7, 11, 13, 17, 23, 31...");
            q = menu("Veuillez insérer q, nombre premier");
        }
        this.q = q;
    }

    private void calculer_n () {
        n = p * q;
    }

    private void calculer_phin () {
        phin = (p-1) * (q-1);
    }

    private void calculer_e () {
        int borneInf;
        int e;
        if (q > p)
            borneInf = q + 1;
        else
            borneInf = p + 1;
        e = borneInf + 1;

        while (PGCD(e, phin) != 1)
            e += 1;
        this.e = e;
    }

    private void calculer_d () {
        int d = inverseModulaire();
        if (d < 0)
            d += phin;
        this.d = d;
    }

    public int getP() {
        return p;
    }

    public int getQ() {
        return q;
    }

    public int getN() {
        return n;
    }

    public int getPhin() {
        return phin;
    }

    public int getE() {
        return e;
    }

    public int getD() {
        return d;
    }

}
