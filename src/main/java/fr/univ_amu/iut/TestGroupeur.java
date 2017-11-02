import fr.univ_amu.iut.GroupeurDegroupeur;

import java.util.ArrayList;

public class TestGroupeur {
    public static void main(String[] args) {
        GroupeurDegroupeur groupeur = new GroupeurDegroupeur();
        ArrayList<String> listeString = new ArrayList<String>();
        listeString.add("12");
        listeString.add("68");
        listeString.add("122");
        listeString.add("89");
        listeString.add("344");
        listeString.add("342");
        listeString.add("920");
        listeString.add("920");
        listeString.add("920");
        listeString.add("12");
        listeString.add("12");
        listeString.add("12");
        listeString.add("12");

        System.out.println(listeString);
        ArrayList<String> listeDechiffree = GroupeurDegroupeur.grouperChaineAscii(listeString);
        System.out.println(listeDechiffree);
        System.out.println(GroupeurDegroupeur.decouperChaineEn3(listeDechiffree));
    }
}
