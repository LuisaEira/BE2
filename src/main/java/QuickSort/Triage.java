/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuickSort;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucaa
 */
public class Triage implements Runnable {

    int T[];
//    int cont;
//    int cont2;
//    int p;
    boolean do_it;
    int Long;
    String nom;

    public Triage(String n ,int Tp[], int l) {
        T = Tp;
//        p = T[0];
        Long = l;
        nom=n;
    }

    public void trier(int T_aux[], int L) {

//        ord = 0;
//        ord2 = 0;
//        l = dr - ga + 1;
//        System.out.println(ga + " " + dr);
        if (L == 1) {

        } else if (L == 2) {
//            System.out.println("Entra dr=2");
            int aux;
            if (T_aux[0] > T_aux[1]) {
                aux = T_aux[1];
//                System.out.println("El aux: " + aux);
                T_aux[1] = T_aux[0];
                T_aux[0] = aux;
//                for (int r = 0; r < T_aux.length; r++) {
//                    System.out.print(T_aux[r] + " ");
//                }
//                System.out.println("");
//                T1_aux = null;
//                T2_aux = null;
            }
        } else if (L > 2) {
//            System.out.println("Entra dr>2");
            int[] T1_aux = new int[L - 1];
            int[] T2_aux = new int[L - 1];
            int p;
            int cont;
            int cont2;
            p = T_aux[0];
            cont = 0;
            cont2 = 0;
            for (int j = 1; j <= L - 1; j++) {
//                System.out.println(p);
                if (p >= T_aux[j]) {
                    T1_aux[cont] = T_aux[j];
//                    System.out.println("Componente del vector T1 (" + cont + "): " + T1_aux[cont]);
//                    cont++;
//                    if (cont > 0) {// && ord == 0) {
//                        if (T1_aux[cont - 1] > T1_aux[cont]) {
//                            System.out.println("Entra una vez");
////                            ord = 1;
//                        }
//                    }
                    cont++;
                } else {
                    T2_aux[cont2] = T_aux[j];
//                    System.out.println("Componente del vector T2 (" + cont2 + "): " + T2_aux[cont2]);
//                    cont2++;
//                    if (cont2 > 0) {// && ord2 == 0) {
//                        if (T2_aux[cont2 - 1] > T2_aux[cont2]) {
//                            System.out.println("Entra dos vez");
////                            ord2 = 1;
//                        }
//                    }
                    cont2++;
                }
            }

            ecrireT(T_aux, L);
//        act_T(T_aux);
//        System.out.println(T[l]);
//        if (ord2 == 1) {
////            System.out.println("Entra_ord2");
//            Thread th1 = new Thread();
//            th1.start();
//        }
//        if (ord2 == 1 || ga_v[0] != -1) {
//            System.out.println("Entra_ord2");
//            System.out.println(isVect());
//            gauche = ga;
            boolean avec_threads = false;

            synchronized (Main.verrou) {
                if (Main.num_threads < Main.Limit_Threads - 1) {
                    Main.num_threads = Main.num_threads + 2;
                    avec_threads = true;
                }

            }
            if (avec_threads == true) {
                Triage Tri_1 = new Triage(nom + "_1",T1_aux, cont);
                Triage Tri_2 = new Triage(nom + "_2",T2_aux, cont2);
                Thread th1 = new Thread(Tri_1);
                Thread th2 = new Thread(Tri_2);
                th1.start();
                th2.start();
                try {
                    th1.join();
                    th2.join();
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
                }else if(m>cont){
                    T_aux[m] = T2_aux[m-cont-1];
                }
            }
//            act_T(T_aux,L);
        }
    }

    public int[] isT() {
//        for (int k=0;k<T.length;k++){
//            System.out.println(T[k]);
//        }
        return T;
    }

    public void act_T(int T_aux[],int L) {
        for (int l = 0; l < L; l++) {
//            System.out.print("Entra a pasar T_aux");
            T[l] = T_aux[l];
//            System.out.println(T[l]);
        }
    }
    
    public void ecrireT(int T_aux[],int l) {
        for (int r = 0; r < l; r++) {
                System.out.print(T_aux[r] + " ");
            }
        System.out.println("");
    }

    @Override
    public void run() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        synchronized (Main.verrou_ecran) {
            System.out.print(" Thread " + nom + "va a trier: ");
            ecrireT(T, Long);
        }
        trier(T, Long);
        synchronized (Main.verrou_ecran) {
            System.out.print(" Vecteur trié: ");
            ecrireT(T, Long);
        }
    }
}
