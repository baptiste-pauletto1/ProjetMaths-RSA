import fr.univ_amu.iut.GroupeurDegroupeur;

import java.util.ArrayList;

public class TestGroupeur {
    public static void main(String[] args) {
        GroupeurDegroupeur groupeur = new GroupeurDegroupeur();
        ArrayList<String> listeString = new ArrayList<String>();
        listeString.add("012");
        listeString.add("068");
        listeString.add("122");
        listeString.add("089");
        listeString.add("344");
        listeString.add("342");
        listeString.add("920");
        listeString.add("920");
        listeString.add("920");
        System.out.println(listeString);
        ArrayList<String> listeDechiffree = groupeur.grouperChaineAscii(listeString);
        System.out.println(listeDechiffree);
        System.out.println(groupeur.decouperChaineEn3(listeDechiffree, listeString.size()));

    }
}
