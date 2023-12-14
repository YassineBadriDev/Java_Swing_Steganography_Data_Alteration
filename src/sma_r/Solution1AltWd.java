/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sma_r;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author unstople
 */
public class Solution1AltWd {
    
     //AltFunct1:
    public String circ_shif_tonce(String s) {
        return s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
    }

    //AltFunct2:
    public String circ_shift_all(String input) {
        ArrayList<String> si = new ArrayList<String>();
        for (int i = 0; i < input.length() - 1; i++) {
            input = circ_shif_tonce(input);
            si.add(input);
        }
        Random r = new Random();
        int valeur = 0 + r.nextInt(input.length() - 1);
        return si.get(valeur);
    }
}
