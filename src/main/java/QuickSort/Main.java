/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuickSort;

import java.util.concurrent.locks.Lock;
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
        int f=0;
        boolean do_it;
        int nb_th = 6;
        Lock l = null;
        N = JOptionPane.showInputDialog("Nombre d'élements du tableau");
        isNumber num = new isNumber(N);
        if (num.check(N)==true){
            n=num.isN(N);
            System.out.println(n);
            int[] T = new int[n];
            for(i=0;i<=n-1;i++){
                c = Integer.parseInt(JOptionPane.showInputDialog(String.format("Élement %d du tableau",i+1)));
                T[i]=c;
                if(i>0&&f==0){
                    if(T[i-1]>T[i]){
                        f=1;
                    }
                }
            }
            System.out.println(T[1]);
            if(f==1){
               new Triage(T);
               do_it = false;
               l.lock();
                       if (nb_th>0){
                           nb_th--;
                           do_it = true;
                           creerThread th1 = new creerThread();
                           th1.start();
                       }
               l.unlock();
               
               if (do_it == true){
//                   th1.join(); 
               }
            }
        }
        
    }
    
}
