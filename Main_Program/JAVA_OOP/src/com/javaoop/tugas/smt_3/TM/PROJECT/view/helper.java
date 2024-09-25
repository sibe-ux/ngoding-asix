/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaoop.tugas.smt_3.TM.PROJECT.view;

import java.util.ArrayList;

/**
 *
 * @author Istiyadi
 */
public class helper {
    
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    public static void displayTabel(ArrayList lstField, ArrayList lstBrg)
    {

        System.out.println("-------------------------------------");
        for (int a = 0; a < lstBrg.size(); a++) {
            if (a == 0) {
                for (int b = 0; b < lstField.size(); b++) {
                    System.out.print(lstField.get(b) + "\t");
                }
                System.out.println("\n-------------------------------------");
            }

            System.out.print(lstBrg.get(a) + "\t");

            if ((a + 1) % lstField.size() == 0) {
                System.out.println("");
            }
        }
        System.out.println("-------------------------------------");
    }
    
}
