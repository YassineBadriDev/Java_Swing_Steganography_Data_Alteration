/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sma_r;

import com.sun.xml.internal.ws.util.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import static jdk.nashorn.internal.objects.NativeArray.map;
import static jdk.nashorn.internal.objects.NativeDebug.map;

/**
 *
 * @author unstople
 */
public class Alter_number {
    //*** cette classe nous permet de faire l alteration et la desalteration des nombres ***//   

    /*la structure de donnees Hashmap ( dictionnaire) contient la correspondance entre les chiffres.cette correspondance est base sur 
    la table ASCCI ,la table SSCE ,une fonction de chiffrement et une autre pour le dechiffrement.*/
    public static final HashMap<String, Integer> map_num = new HashMap();

    static {
        map_num.put("0", 8);
        map_num.put("1", 9);
        map_num.put("2", 0);
        map_num.put("3", 1);
        map_num.put("4", 2);
        map_num.put("5", 3);
        map_num.put("6", 4);
        map_num.put("7", 5);
        map_num.put("8", 6);
        map_num.put("9", 7);
    }

    public void Alter_number() {
        //constructeur
    }

    /* ALTERATION DES NOMBRES*/
    //AltFunct1 : (pour obtenir le chiffre altere correspondant )obtenir le chiffre de depart a partir du chiffre altere 
    public int getValueFromKey(String s) {
        return (int) (map_num.get(s));
    }

    /*AltFunct2 : Pour obtenir la correspondance d'un nombre de plusieurs chffre a partir de la HASHMAP*/
 /* La fonction reçoit un nombre de plusieurs chiffres en paramètre : n */
    public int corr_All_Figures(String n) {
        /*on converti le nombre n en un tableau de caractères contenant chaque chiffre du nombre par colonne*/
        char[] stringToCharArray = n.toCharArray();
        ArrayList<String> corrs = new ArrayList<String>();
        int l;

        /*Dans la boucle*/
        for (char i : stringToCharArray) {
            /*Pour chaque valeur du tableau , on fait son corespondant en se servant de AltFunct1 ( HASMAP) */
            l = getValueFromKey(Character.toString(i));
            /*on ajoute chaque vleur corespondante au fur et a mesure dans une arayList*/
            corrs.add(Integer.toString(l));
        }
        /*Un fois le tableau de correspondant obtenu, on le concatene en une chaine de caractère String pour poursuivre l'altération*/
        String listString = String.join("", corrs);
        return Integer.parseInt(listString);
    }

    //AltFunct3 : Cette fonction divise un nombre selon qu'il est pair ou impair 
    public int div_num(int num) {

        int newnum = 0;

        if ((num % 2) == 0) {
            newnum = num / 2;
        } else {
            newnum = (num + 1) / 2;
        }
        return newnum;

    }

    //AltFunct4 :tranformer un nombre en tableau de chiffres entiers
    public int[] intoarray(int l) {
        String k = Integer.toString(l);
        int[] inttab = new int[k.length()];
        for (int i = 0; i < k.length(); i++) {
            inttab[i] = k.charAt(i) - '0';

        }
        return inttab;

    }

    //AltFunct5 :Decouper un tableau 2 par 2   
    //AltFunct5 :Decouper un tableau 2 par 2   
    public ArrayList<String> splitandjoin2by2(int[] tab) {
        ArrayList<String> recept = new ArrayList<String>();

        /*si la taille du tableau est paire*/
        if (tab.length % 2 == 0) {

            for (int i = 0; i < tab.length; i = i + 2) {
                /* Si  colonnes successives du tableau contiennent des 0, ajouter l'array list des strings "00" */
                if (tab[i] == 0 && tab[i + 1] == 0) {
                    String with3digits = String.format("%02d", tab[i]);
                    recept.add(with3digits);

                } else {
                    String joinval = String.valueOf(tab[i]) + String.valueOf(tab[i + 1]);
                    recept.add(joinval);

                }
            }
        } else {
            for (int i = 0; i < tab.length - 1; i = i + 2) {

                if (tab[i] == 0 && tab[i + 1] == 0) {
                    String with3digits = String.format("%02d", tab[i]);
                    recept.add(with3digits);

                } else {

                     String joinval = String.valueOf(tab[i]) + String.valueOf(tab[i + 1]);
                    recept.add(joinval);
                }
            }
            recept.add(Integer.toString(tab[tab.length - 1]));
        }
       
        return recept;
    }

    //AltFunct6 :Convertir une arrayListString  en Array de string 
    public String[] convertStrings(List<String> arrayList) {
        Object[] objectList = arrayList.toArray();
        String[] stringArray =  Arrays.copyOf(objectList,objectList.length,String[].class);
        return stringArray;
    }

    //AltFunct7 :Inverse d'une chaine de caractère
    public String reverse(String S) {

        String reverse = new StringBuffer(S).reverse().toString();
        return reverse;
    }

    //AltFunct8:inverser les chaines d'un tableau 
    public String[] reversetab(String[] tab) {
        String[] tab2 = new String[tab.length];

        for (int i = 0; i < tab.length; i++) {

            tab2[i] = reverse(tab[i]);

        }
        return tab2;
    }

    //AltFunct9 : Transformer un tableau de chaine de caractère en chaine de caractère
    public int arraystring2string(String[] tab) {

        StringBuffer result = new StringBuffer();
        for (int i = 0; i < tab.length; i++) {
            result.append(tab[i]);
            //result.append( optional separator );
        }
        String mynewstring = result.toString();
        int finalInt = Integer.parseInt(mynewstring);
        return finalInt;
        
    }

    //AltFunct10 :
    public int permut(int nu) {

        String [] s2 = convertStrings(splitandjoin2by2(intoarray(nu)));

        return arraystring2string(reversetab(s2));
    }

    /**
     * //AltFunct11 :****demo_Alteration***
     */
    public int demo_Alt(int number) {

        int number2 = corr_All_Figures(Integer.toString(number));
        int number3 = div_num(number2);
        int number4 = permut(number3);
        return (number4);

    }

    /* DESALTERATION DES NOMBRES*/
    
    //deAltFunct1 : operation inverse de AltFunct1
    public String getKeyFromValue(int m) {
        String s = " ";
        for (Entry<String, Integer> entry : map_num.entrySet()) {

            if (entry.getValue().equals(m)) {
                s = entry.getKey();
            }
        }
        return s;
    }

    //deAltFunct2 : operation inverse de AltFunct2
    public String decorr_All_Figures(String n) {
        /*on converti le nombre n en un tableau de caractères contenant chaque chiffre du nombre par colonne*/
        char[] stringToCharArray1 = n.toCharArray();
        ArrayList<String> corrs1 = new ArrayList<String>();
        String l = " ";
        int j;

        /*Dans la boucle*/
        for (char i : stringToCharArray1) {
            /*Pour chaque valeur du tableau , on fait son corespondant en se servant de AltFunct1 ( HASMAP) */
            j = Integer.parseInt(Character.toString(i));

            l = getKeyFromValue(j);
            /*on ajoute chaque vleur corespondante au fur et a mesure dans une arayList*/
            corrs1.add(l);
        }
        /*Un fois le tableau de correspondant obtenu, on le concatene en une chaine de caractère String pour poursuivre l'altération*/
        String listString = String.join("", corrs1);
        return listString;

    }

    //deAltFunct3 : operation inverse de AltFunc3 
    public int div_num_inv(int num) {

        int newnum = 0;

        if ((num % 2) == 0) {
            newnum = num * 2;
        } else {
            newnum = (num * 2) - 1;
        }
        return newnum;

    }

    /**
     * //deAltFunct4 :****demo_deAlteration***
     */
    public int demo_DeAlt(int number) {
        int number2 = permut(number);
        int number3 = div_num_inv(number2);
        String number4 = decorr_All_Figures(Integer.toString(number3));

        return (Integer.parseInt(number4));

    }
}
