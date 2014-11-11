/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birthdayparadox;

import java.util.HashSet;

/**
 *
 * @author yifeij
 */
public class BirthdayParadox {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        for (int k = 2; k < 50; k++) {
            int count = 0;
            for (int i = 0; i < 5000; i++) {
                HashSet<Integer> hashset = new HashSet<>();
                for(int j = 0; j<k; j++){
                int birthday = (int) ((Math.random()) * 365 + 1);
                if (hashset.contains(birthday)) {
                    count++;
                    break;
                }
                    hashset.add(birthday);
                }
            }
            System.out.println((double) count / 5000);
        }
    }
}
