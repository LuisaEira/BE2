/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuickSort;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JOptionPane;

/**
 *
 * @author lucaa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
//    public static Object obj1 = new Object();
//    public static Object obj2 = new Object();
    public static Lock lock = new ReentrantLock();
    public static Lock lock2 = new ReentrantLock();
    public static int nb_th;

    public static void main(String[] args) {
        // TODO code application logic here
        String N;
        int n;
        int c;
        int i;
        int f = 0;
        int flag;
        nb_th = Integer.parseInt(JOptionPane.showInputDialog("Nombre de Threads a utiliser comme limite"));
        nb_th--;
        N = JOptionPane.showInputDialog("Nombre d'élements du tableau");
        isNumber num = new isNumber(N);
        if (num.check(N) == true) {
            n = num.isN(N);
            int[] T = new int[n];
            flag=JOptionPane.showConfirmDialog(null,"Est ce que tu veux créer le vecteur manuelement?","Random Vector",JOptionPane.YES_NO_OPTION);
            
            for (i = 0; i <= n - 1; i++) {
                if (flag==0){
                c = Integer.parseInt(JOptionPane.showInputDialog(String.format("Élement %d du tableau", i + 1)));
                }else{
                    c = (int) (Math.random()*100+1);
                }
                T[i] = c;
                if (i > 0 && f == 0) {
                    if (T[i - 1] > T[i]) {
                        f = 1;
                    }
                }
            }
            if (n == 1) {

            } else if (n == 2) {
                int aux;
                if (T[0] > T[1]) {

                    aux = T[1];
                    T[1] = T[0];
                    T[0] = aux;
                }
            } else if (f == 1 && n > 2) {
                Triage tri = new Triage("1",T, n);
                Thread th = new Thread(tri);
                th.start();
            }
        }

    }
}
