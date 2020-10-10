/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuickSort_sec;

/**
 *
 * @author lucaa
 */
public class Triage {
    
    
    int T[];
    int cont;
    int cont2;
    int p;
    boolean do_it;
    int nb_th;
    int ord;
    int ord2;

    public Triage(int Tp[], int nb_ths) {
        T = Tp;
        p = T[0];
        nb_th = nb_ths;

    }

    public void trier(int T_aux[],int ga,int dr) {
        
        int[] T1_aux= new int[T_aux.length];
        int[] T2_aux= new int[T_aux.length];
        p=T[0];
        cont=0;
        cont2=0;
        ord=0;
        ord2=0;
        if (dr == 1) {
        } else if (dr == 2) {
            int aux;
            if (T_aux[ga] > T_aux[ga+1]) {
                aux = T_aux[ga+1];
                T_aux[ga+1] = T_aux[ga];
                T_aux[ga] = aux;
            }
        } else if (dr > 2) {
            for (int j = ga+1; j <= dr - 1; j++) {
                if (p < T_aux[j]) {
                    T1_aux[cont] = T_aux[j];
                    cont++;
                    if (j > 0 && ord == 0) {
                        if (T1_aux[cont - 1] > T1_aux[cont]) {
                            ord = 1;
                        }
                    }
                } else {
                    T2_aux[cont2] = T_aux[j];
                    cont2++;
                    if (j > 0 && ord2 == 0) {
                        if (T2_aux[cont2 - 1] > T2_aux[cont2]) {
                            ord2 = 1;
                        }
                    }
                }
            }
            
            
        }
        int length_T1=cont;
        int length_T2=cont2;
        int[] T1 = new int[length_T1];
        int[] T2 = new int[length_T2];
        for (int r=0;r<T1.length;r++){
            T1[r]=T1_aux[r];
//            System.out.println(T1.length);
        }
        for (int r=0;r<T2.length;r++){
            T2[r]=T2_aux[r];
//            System.out.println(T2.length);
        }
//        int p_pos=T1_aux.length;
//        System.out.println(p_pos);
//        System.out.println(p);
//        System.out.println(T_aux[p_pos]);
        T_aux[T1.length]=p;
        for (int m=0;m<T1.length;m++){
            T_aux[m]=T1[m];
        }
        for (int m=0;m<(T2.length);m++){
            T_aux[m+T1.length+1]=T2[m];
        }
        if (ord == 1) {
//            System.out.println("Entra_ord1");
            trier(T_aux,0,T1.length-1);
        }
        if (ord2 == 1) {
//            System.out.println("Entra_ord2");
            trier(T_aux,T1.length+1,T1.length+T2.length);
        }
        for (int l=0;l<T_aux.length;l++){
            T[l]=T_aux[l];
//            System.out.println(T[l]);
        }
    }
    public int[] isT(){
//        for (int k=0;k<T.length;k++){
//            System.out.println(T[k]);
//        }
        return T;
    }
}

