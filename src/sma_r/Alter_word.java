/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sma_r;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import org.gauner.jSpellCorrect.ToySpellingCorrector;
import sun.misc.IOUtils;


public class Alter_word {

    public Alter_word() {

    }
    ;
       public static final HashMap<String, Double> map_ascii_virg = new HashMap();

    static {
        map_ascii_virg.put("a", 116.296875);
        map_ascii_virg.put("b", 118.8359375);
        map_ascii_virg.put("c", 121.375);
        map_ascii_virg.put("d", 98.015625);
        map_ascii_virg.put("e", 100.65625);
        map_ascii_virg.put("f", 103.296875);
        map_ascii_virg.put("g", 105.9375);
        map_ascii_virg.put("h", 108.578125);
        map_ascii_virg.put("i", 111.21875);
        map_ascii_virg.put("j", 113.859375);
        map_ascii_virg.put("k", 116.3984375);
        map_ascii_virg.put("1", 118.9375);
        map_ascii_virg.put("m", 121.4765625);
        map_ascii_virg.put("n", 98.1171875);
        map_ascii_virg.put("o", 100.7578125);
        map_ascii_virg.put("p", 103.3984375);
        map_ascii_virg.put("q", 106.953125);
        map_ascii_virg.put("r", 108.6796875);
        map_ascii_virg.put("s", 111.3203125);
        map_ascii_virg.put("t", 113.9609375);
        map_ascii_virg.put("u", 116.5);
        map_ascii_virg.put("v", 119.0390625);
        map_ascii_virg.put("w", 121.578125);
        map_ascii_virg.put("x", 98.21875);
        map_ascii_virg.put("y", 100.859375);
        map_ascii_virg.put("z", 103.5);
    }
    public static final HashMap<Integer, String> map_ascii_int = new HashMap();

    static {
        map_ascii_int.put(97, "a");
        map_ascii_int.put(98, "b");
        map_ascii_int.put(99, "c");
        map_ascii_int.put(100, "d");
        map_ascii_int.put(101, "e");
        map_ascii_int.put(102, "f");
        map_ascii_int.put(103, "g");
        map_ascii_int.put(104, "h");
        map_ascii_int.put(105, "i");
        map_ascii_int.put(106, "j");
        map_ascii_int.put(107, "k");
        map_ascii_int.put(108, "l");
        map_ascii_int.put(109, "m");
        map_ascii_int.put(110, "n");
        map_ascii_int.put(111, "o");
        map_ascii_int.put(112, "p");
        map_ascii_int.put(113, "q");
        map_ascii_int.put(114, "r");
        map_ascii_int.put(115, "s");
        map_ascii_int.put(116, "t");
        map_ascii_int.put(117, "u");
        map_ascii_int.put(118, "v");
        map_ascii_int.put(119, "w");
        map_ascii_int.put(120, "x");
        map_ascii_int.put(121, "y");
        map_ascii_int.put(122, "z");
    }

    /* ALTERATION DES CHAINES DE CARACTERES*/
    //AltFunct1:
    public Double getValueFromKey(String s) {
        return (Double) (map_ascii_virg.get(s));
    }

    //AltFunct2:
    public String getValueFromKey(int i) {
        return map_ascii_int.get(i);
    }

    //AltFunct3:
    public Double string2double(String str) {

        Double l = getValueFromKey(str);

        return l;
    }

    //AltFunct4:
    public int Double2Int(Double d) {

        return d.intValue();
    }

    //AltFunct5:
    public String Int2String(int i) {

        String m = getValueFromKey(i);

        return m;
    }

    //AltFunct6:
    public void table(String st) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        String[][] myStringArray = new String[4][st.length()];
        char[] StringToCharArray = st.toCharArray();
        //Specify the file name and path here
        File file = new File("C://Users//unstople//Documents//NetBeansProjects//SMA_r//the-file-name1.txt");

        /* This logic is to create the file if the
    	 * file is not already present
         */
        //Here true is to append the content to file
        FileWriter fw = new FileWriter(file, true);
        //BufferedWriter writer give better performance
        BufferedWriter bw = new BufferedWriter(fw);
        ArrayList<String> corrs = new ArrayList<String>();
        ToySpellingCorrector sc = new ToySpellingCorrector();
        sc.trainFile("C:/Users/unstople/Desktop/words.txt");

        // Construire le tableau contenant les caractéristiques du mot a alterer pour toutes les lettres : S = 111,42 = 111 = O
        for (char i : StringToCharArray) {

            myStringArray[0][st.indexOf(i)] = Character.toString(i);
            myStringArray[1][st.indexOf(i)] = string2double(myStringArray[0][st.indexOf(i)]).toString();
            myStringArray[2][st.indexOf(i)] = Integer.toString(Double2Int(Double.parseDouble(myStringArray[1][st.indexOf(i)])));
            myStringArray[3][st.indexOf(i)] = Int2String(Integer.parseInt(myStringArray[2][st.indexOf(i)]));

        }
       
     
        //afficher un tableau pour sonia
        
       /* for (char i : StringToCharArray) {
            System.out.print(myStringArray[0][st.indexOf(i)] + "\t");
        }
        System.out.println("\n");
        for (char i : StringToCharArray) {
            System.out.print(myStringArray[1][st.indexOf(i)] + "\t");
        }
        System.out.println("\n");
        for (char i : StringToCharArray) {
            System.out.print(myStringArray[2][st.indexOf(i)] + "\t");
        }
        System.out.println("\n");
        for (char i : StringToCharArray) {
            System.out.print(myStringArray[3][st.indexOf(i)] + "\t");
        }
        
          /* for (char i : StringToCharArray) {
            System.out.println((myStringArray[0][st.indexOf(i)]));
        } */
        //Ecrire le mot initial dans le fichier 
       /* for (char i : StringToCharArray) {
            bw.write(myStringArray[0][st.indexOf(i)]);
        }
        bw.write("\t");*/
           
        //Ecrire le mot alterer  dans le fichier avant le spellchecker.
        for (char i : StringToCharArray) {

            //bw.write(myStringArray[3][st.indexOf(i)]);
            corrs.add(myStringArray[3][st.indexOf(i)]);

        }
         //Ecrire le mot alterer  dans le fichier avant le spellchecker.
        for (char i : StringToCharArray) {
            if(!bw.equals(myStringArray[1][st.indexOf(i)])){
            bw.write(myStringArray[1][st.indexOf(i)]+" ");
            
        }else{
            
            }
        }
        //Conversion du mot alterer avant le spellchecker en String pour le passer en paramètre dans le spellchecker sc.correct().
        String listString = String.join("", corrs);
        //System.out.println("Before Spell checker Corrector :\t" + listString);
        //System.out.println("After Spell checker Corrector :\t" + sc.correct(listString));
        //Ecriture du mot alterer apres le spellchecker dans le fichier .
        bw.write("\t");
        bw.write(sc.correct(listString));
        //System.out.println("Data successfully appended at the end of file");
        bw.newLine();
        //Closing BufferedWriter Stream
        bw.close();
    }

    
     public void demo_Alt_wd(String wd) throws IOException {
       String  file1 = "C://Users//unstople//Documents//NetBeansProjects//SMA_r//the-file-name1.txt";
       table(wd);
       stripDuplicatesFromFile(file1);
     

    }
    
    
    
    
    /* DEALTERATION DES CHAINES DE CARACTERES*/
    
    
    
    public  ArrayList<String> readfile(String word) throws FileNotFoundException, IOException {
        
        
        ArrayList<String> sin = new ArrayList<String>();
         int tokencount;
        FileReader fr = new FileReader("C://Users//unstople//Documents//NetBeansProjects//SMA_r//the-file-name1.txt");
        BufferedReader br = new BufferedReader(fr);
        String s;
        int linecount = 0;
        String line;
        String words[] = new String[500];
        while ((s = br.readLine())!= null) {
            linecount++;
            int indexfound = s.indexOf(word);
                       if (indexfound > -1) {                                              
               // System.out.println("\n");
 //System.out.println("Word was found at position::" +indexfound + "::on line"+linecount);
//System.out.println("\n ");
 line = s;
 //System.out.println(line);
                int idx = 0;
                StringTokenizer st = new StringTokenizer(line);
                tokencount = st.countTokens();
               // System.out.println("\n");
//System.out.println("Number of tokens found" +tokencount);
//System.out.println("\n ");                                             
 for (idx = 0; idx < tokencount-1; idx++) {
                    words[idx] = st.nextToken();
                    sin.add(words[idx]);
                    //System.out.println(words[idx]);
                }
            }     
        }    
        fr.close();
        
return (sin);
    }
  

    
    public String getKeyFromValueW(Double d) {
        String s = " ";
        for (Map.Entry<String, Double> entry : map_ascii_virg.entrySet()) {
            if (entry.getValue().equals(d)) {
                s = entry.getKey();
            }
        }
        return s;
    }

    
    
     public double[] arrList2ArrayDoube(ArrayList<String> st){
    
    
    double[] failsArray = new double[st.size()];
    for (int i = 0; i < st.size(); ++i) { //iterate over the elements of the list
    failsArray[i] = Double.parseDouble(st.get(i)); //store each element as a double in the array
}
    return failsArray;
    }
    
    
    
    
    public String decorr_All_doubles(ArrayList<String> sinn) {
        /*on converti le nombre n en un tableau de caractères contenant chaque chiffre du nombre par colonne*/
       // char[] stringToCharArray1 = n.toCharArray();
       double[] arr=arrList2ArrayDoube(sinn);
        ArrayList<String> corrs1 = new ArrayList<String>();
        String l = " ";
        int j;

        /*Dans la boucle*/
        for (double i : arr) {
            /*Pour chaque valeur du tableau , on fait son corespondant en se servant de AltFunct1 ( HASMAP) */
          //  j = Integer.parseInt(Character.toString(i));

           l = getKeyFromValueW(i);
            /*on ajoute chaque vleur corespondante au fur et a mesure dans une arayList*/
            corrs1.add(l);
        }
        /*Un fois le tableau de correspondant obtenu, on le concatene en une chaine de caractère String pour poursuivre l'altération*/
        String listString = String.join("", corrs1);
        return listString;

    }
    
   public String demo_DeAlt_wd(String wd) throws IOException {
       
       ArrayList<String> arrst= readfile(wd);
        
        String number4 = decorr_All_doubles(arrst);
       
        return (number4);

    }
 
   public void stripDuplicatesFromFile(String filename) throws FileNotFoundException, IOException {
    BufferedReader reader = new BufferedReader(new FileReader(filename));
    Set<String> lines = new HashSet<String>(10000); // maybe should be bigger
    String line;
    while ((line = reader.readLine()) != null) {
        lines.add(line);
    }
    reader.close();
    BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
    for (String unique : lines) {
        writer.write(unique);
        writer.newLine();
    }
    writer.close();
}
}
