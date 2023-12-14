package sma_r;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.gauner.jSpellCorrect.ToySpellingCorrector;
import sma_r.Alter_number;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package sma_r;

/**
 *
 * @author unstople
 */
public class Alter_test{
    
    public  Alter_test(){

        try {
            test_alterw();
        } catch (IOException ex) {
            Logger.getLogger(Alter_test.class.getName()).log(Level.SEVERE, null, ex);
        }

}
  public void test_alter(){
      
Alter_number A = new Alter_number();
/*Pour eviter la redondance des chiffres , remplacer la division par 2 par une autre opération qui pourrais faire varier les chiffres du resultat*/
/*Critiques: Redondance des chiffres dans la bd à cause de la division par 2
             Travailler avec les floats
*/
System.out.println(A.demo_Alt(0));
System.out.println(A.demo_Alt(1));
System.out.println(A.demo_Alt(2));
System.out.println(A.demo_Alt(3));
System.out.println(A.demo_Alt(4));
System.out.println(A.demo_Alt(5));
System.out.println(A.demo_Alt(6));
System.out.println(A.demo_Alt(7));
System.out.println(A.demo_Alt(8));
System.out.println(A.demo_Alt(9));
System.out.println(A.demo_Alt(10));
System.out.println(A.demo_Alt(546465100));
System.out.println(A.demo_Alt(000451005));
System.out.println(A.demo_Alt(780425150));
System.out.println(A.demo_Alt(0451207));
System.out.println(A.demo_Alt(045210));

  }
  
public void test_dealter(){
      
Alter_number A = new Alter_number();
System.out.println(A.demo_Alt(546465100));
System.out.println(546465100);
System.out.println(A.demo_DeAlt(611212994));

  }


/* public void test_alterwsol1(){
      
Alter_word A = new Alter_word();
ToySpellingCorrector sc = new ToySpellingCorrector();
sc.trainFile("C:/Users/unstople/Desktop/words.txt");
System.out.println("After Spell checker Corrector :\t \t"+sc.correct("bn"));
  }*/
  
 public void test_alterw() throws UnsupportedEncodingException, IOException{
      
Alter_word A = new Alter_word();

//A.table("sara");
//A.table("sonia");
//A.table("yassine");
//A.table("nobody");
//System.out.println(sCurrentLine);
//double [] arrD=A.arrList2ArrayDoube(A.readfile("boot"));

//System.out.println(A.decorr_All_doubles(A.readfile("boot")));
A.demo_Alt_wd("soniahhhjhj");
//A.stripDuplicatesFromFile(file1);
    }

		
       
  

 
public void test_dealterw(){
      
Alter_word A = new Alter_word();

  }

  public static void main(String[] args) {
        
        new Alter_test();
       
        
}
}
