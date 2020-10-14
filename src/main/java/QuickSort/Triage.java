/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuickSort;

import java.util.concurrent.locks.Lock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucaa
 */
public class Triage implements Runnable {

    int T[];
    int Long;
    String n;

    public Triage(String nom, int Tp[], int l) {
        T = Tp;
        Long = l;
        n = nom;
    }

    public void trier(int T_aux[], int L) {

        if (L == 1) {

        } else if (L == 2) {
            int aux;
            if (T_aux[0] > T_aux[1]) {
                aux = T_aux[1];
                T_aux[1] = T_aux[0];
                T_aux[0] = aux;
            }
        } else if (L > 2) {
            int[] T1_aux = new int[L - 1];
            int[] T2_aux = new int[L - 1];
            int p;
            int cont;
            int cont2;
            p = T_aux[0];
            cont = 0;
            cont2 = 0;
            for (int j = 1; j <= L - 1; j++) {
                if (p >= T_aux[j]) {
                    T1_aux[cont] = T_aux[j];
                    cont++;
                } else {
                    T2_aux[cont2] = T_aux[j];
                    cont2++;
                }
            }

//            ecrireT(T_aux, L);
            boolean threads_disp = false;

//            synchronized (Main.obj1) {
            Main.lock.lock();
            if (Main.nb_th >= 2) {
                Main.nb_th = Main.nb_th - 2;
                threads_disp = true;
            }
            Main.lock.unlock();
//            }
            if (threads_disp == true) {
                Triage Tri_1 = new Triage(n + "_1", T1_aux, cont);
                Triage Tri_2 = new Triage(n + "_2", T2_aux, cont2);
                Thread th_1 = new Thread(Tri_1);
                Thread th_2 = new Thread(Tri_2);
                th_1.start();
                th_2.start();
                try {
                    th_1.join();
                    th_2.join();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Triage.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                trier(T1_aux, cont);
                trier(T2_aux, cont2);

            }
            T_aux[cont] = p;
            for (int m = 0; m <= cont + cont2; m++) {
                if (m < cont) {
                    T_aux[m] = T1_aux[m];
                } else if (m > cont) {
                    T_aux[m] = T2_aux[m - cont - 1];
                }
            }
        }
    }

//    public int[] isT() {
////        for (int k=0;k<T.length;k++){
////            System.out.println(T[k]);
////        }
//        return T;
//    }
//    public void act_T(int T_aux[],int L) {
//        for (int l = 0; l < L; l++) {
//            T[l] = T_aux[l];
//        }
//    }
    public void ecrireT(int T_aux[], int l) {
        for (int r = 0; r < l; r++) {
            if (r < l - 1) {
                System.out.print(T_aux[r] + " ");
            } else {
                System.out.print(T_aux[r]);
            }
        }
        System.out.print("}");
        System.out.println(" ");
    }

    @Override
    public void run() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        synchronized (Main.obj2) {
        Main.lock2.lock();
        System.out.print(" Thread " + n + " va a trier: {");
        ecrireT(T, Long);
//            System.out.print("}");
//        }
        Main.lock2.unlock();
        trier(T, Long);
//        synchronized (Main.obj2) {
        Main.lock2.lock();
        System.out.print(" Vecteur trie par thread " + n + ": {");
        ecrireT(T, Long);
//            System.out.print("}");
//        }
        Main.lock2.unlock();
    }
}
