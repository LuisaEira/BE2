/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuickSort;

/**
 *
 * @author lucaa
 */
public class Triage {
    int T1[];
    int T2[];
    int T[];
    int cont=0;
    int cont2=0;
    int p;
    int f=0;
    int f2=0;
    public Triage(int Tp[]){
        T=Tp;
        p=T[0];
        trier();
    }
    public void trier(){
        for(int j=1;j<=T.length-1;j++){
            if(p<T[j]){
                T1[cont]=T[j];
                cont++;
                if(j>0&&f==0){
                    if(T1[cont-1]>T1[cont]){
                        f=1;
                    }
                }
            }
            else{
                T2[cont2]=T[j];
                cont2++;
                if(j>0&&f2==0){
                    if(T2[cont2-1]>T2[cont2]){
                        f2=1;
                    }
                }
            }
        }
        if (f==1){
            new Triage(T1);
        }
        if (f2==1){
        }
    }
    public int[] isT1(){
        return T1;
    }
    public int[] isT2(){
        return T2;
    }
    public int isPivot(){
        return p;
    }
}
