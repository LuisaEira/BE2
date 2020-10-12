/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuickSort_sec;

import javax.swing.JOptionPane;

/**
 *
 * @author lucaa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String N;
        int n;
        int c;
        int i;
        int f = 0;

        int nb_th = 6;

        N = JOptionPane.showInputDialog("Nombre d'élements du tableau");
        isNumber num = new isNumber(N);
        if (num.check(N) == true) {
            n = num.isN(N);
//            System.out.println(n);
            int[] T = new int[n];
            for (i = 0; i <= n - 1; i++) {
                c = Integer.parseInt(JOptionPane.showInputDialog(String.format("Élement %d du tableau", i + 1)));
                T[i] = c;
                if (i > 0 && f == 0) {
                    if (T[i - 1] > T[i]) {
                        f = 1;
                    }
                }
            }
//            System.out.println(T[1]);
            if (n == 1) {

            } else if (n == 2) {
                int aux;
                if (T[0] > T[1]) {

                    aux = T[1];
                    T[1] = T[0];
                    T[0] = aux;
                }
            } else if (f == 1 && n > 2) {
//                System.out.println("Entra");
                for (int k = 0; k < T.length; k++) {
                    System.out.print(T[k]+" ");
                }
                System.out.println("");
                System.out.println("Entra primero");
                Triage tri = new Triage(T, nb_th);
//                tri.isT();
                tri.trier(T, 0, T.length);
                T = tri.isT();
            }
            for (int k = 0; k < T.length; k++) {
                System.out.print(T[k]+" ");
            }
            System.out.println(" ");
        }

    }
}