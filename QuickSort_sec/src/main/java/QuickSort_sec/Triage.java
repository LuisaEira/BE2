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
    int l;
    int[] ga_v = new int[20];
    int[] dr_v = new int[20];
    int pos;
    boolean f;

    public Triage(int Tp[], int nb_ths, boolean flag) {
        T = Tp;
        p = T[0];
        nb_th = nb_ths;
        pos = 0;
        ga_v[0] = -1;
        dr_v[0] = -1;
        f = flag;
    }

    public void trier(int T_aux[], int ga, int dr) {
        System.out.println(f);
        if (f == true) {
            System.out.println("Entra bandera");
            enlVect();
            f = false;
        }
        int[] T1_aux = new int[T_aux.length];
        int[] T2_aux = new int[T_aux.length];
        System.out.println(ga);
        System.out.println(dr);
        p = T_aux[ga];
        cont = 0;
        cont2 = 0;
        ord = 0;
        ord2 = 0;
        l = dr - ga + 1;
        System.out.println(ga + " " + dr);
        if (l == 1) {
            System.out.println("Entra dr=1");
            T1_aux = null;
            T2_aux = null;
        } else if (l == 2) {
            System.out.println("Entra dr=2");
            int aux;
            if (T_aux[ga] > T_aux[ga + 1]) {
                aux = T_aux[ga + 1];
                System.out.println("El aux: " + aux);
                T_aux[ga + 1] = T_aux[ga];
                T_aux[ga] = aux;
                for (int r = 0; r < T_aux.length; r++) {
                    System.out.print(T_aux[r] + " ");
                }
                System.out.println("");
                T1_aux = null;
                T2_aux = null;
            }
        } else if (l > 2) {
            System.out.println("Entra dr>2");
            for (int j = ga + 1; j <= dr; j++) {
                System.out.println(p);
                if (p >= T_aux[j]) {
                    T1_aux[cont] = T_aux[j];
                    System.out.println("Componente del vector T1 (" + cont + "): " + T1_aux[cont]);
//                    cont++;
                    if (cont > 0 && ord == 0) {
                        if (T1_aux[cont - 1] > T1_aux[cont]) {
                            System.out.println("Entra una vez");
                            ord = 1;
                        }
                    }
                    cont++;
                } else {
                    T2_aux[cont2] = T_aux[j];
                    System.out.println("Componente del vector T2 (" + cont2 + "): " + T2_aux[cont2]);
//                    cont2++;
                    if (cont2 > 0 && ord2 == 0) {
                        if (T2_aux[cont2 - 1] > T2_aux[cont2]) {
                            System.out.println("Entra dos vez");
                            ord2 = 1;
                        }
                    }
                    cont2++;
                }
            }

        }
        int length_T1 = cont;
        int length_T2 = cont2;
        int[] T1 = new int[length_T1];
        int[] T2 = new int[length_T2];
        if (T1_aux != null) {
            System.out.println("Entra a ord1");
            for (int r = 0; r < T1.length; r++) {
                T1[r] = T1_aux[r];
                System.out.print(T1[r] + " ");
            }
            System.out.println("");
        }
//        else{
//            for (int r = 0; r < T_aux.length; r++) {
//                T1[r] = T_aux[r];
//                System.out.println(T1[r]);
//            }
//        }
        if (T2_aux != null) {
            System.out.println("Entra a ord2");
            for (int r = 0; r < T2.length; r++) {
                T2[r] = T2_aux[r];
                System.out.print(T2[r] + " ");
            }
            System.out.println("");
        }
//        int p_pos=T1_aux.length;
//        System.out.println(p_pos);
//        System.out.println(p);
//        System.out.println(T_aux[p_pos]);

        if (T1_aux != null) {
            System.out.println("Entra a ord1_2");
            T_aux[ga + T1.length] = p;
            for (int m = 0; m < T1.length; m++) {
                T_aux[ga + m] = T1[m];
            }
        }
        if (T2_aux != null) {
            System.out.println("Entra a ord2_2");
            for (int m = 0; m < (T2.length); m++) {
                T_aux[ga + m + T1.length + 1] = T2[m];
            }
        }
        for (int r = 0; r < T_aux.length; r++) {
            System.out.print(T_aux[r] + " ");
        }
        System.out.println("");
        act_T(T_aux);

//        actVect(ga + T1.length + 1, ga + T1.length + T2.length);
//        System.out.println(ga_v[0]);
        if (T2_aux != null&&ord2==1) {
            int sum = ga + T1.length + 1;
            int sum2 = ga + T1.length + T2.length;
            System.out.println(sum + " " + sum2);
            System.out.println(pos);
            actVect(sum, sum2);
            for (int w = 0; w < pos; w++) {
                System.out.println("Las componentes del vector ga y dr son: " + ga_v[w] + " " + dr_v[w]);
            }
//            System.out.println(ga_v[0] + " " + dr_v[0]);
        }
        if (ord == 1) {
            System.out.println("Entra_ord1");

            
            trier(T_aux, ga, ga + T1.length - 1);
        }
//        else{
//            enlVect();
//        }

        if (ord2 == 1 || ga_v[0] != -1) {
            System.out.println("Entra_ord2");
            System.out.println(isVect());
            if (isVect() == -1) {
                System.out.println("Entra en trier 1");
                trier(T_aux, ga + T1.length + 1, ga + T1.length + T2.length);
            } else {
                while (ga_v[0] != -1) {
                    f = true;
                    System.out.println("Entra en trier 2");
                    trier(T_aux, ga_v[0], dr_v[0]);

                }
            }
        }
//        for (int l = 0; l < T_aux.length; l++) {
//            System.out.print("Entra a pasar T_aux");
//            T[l] = T_aux[l];
//            System.out.println(T[l]);
//        }
    }

    public int[] isT() {
//        for (int k=0;k<T.length;k++){
//            System.out.println(T[k]);
//        }
        return T;
    }

    public void actVect(int gau, int dro) {
        ga_v[pos] = gau;
        dr_v[pos] = dro;
        pos++;
    }

    public void enlVect() {
        if (pos > 1) {
            for (int u = 0; u < pos - 1; u++) {
                ga_v[u] = ga_v[u + 1];
                dr_v[u] = dr_v[u + 1];
            }
        } else if (pos <= 1) {
            ga_v[0] = -1;
            dr_v[0] = -1;
        }
        if (pos >= 1) {
            pos--;
        }
    }

    public int isVect() {
        return ga_v[0];
    }

    public void act_T(int T_aux[]) {
        for (int l = 0; l < T_aux.length; l++) {
//            System.out.print("Entra a pasar T_aux");
            T[l] = T_aux[l];
//            System.out.println(T[l]);
        }
    }
}
