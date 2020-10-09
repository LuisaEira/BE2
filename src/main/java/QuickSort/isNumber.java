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
public class isNumber {
    String str;
    int N;
    int b=0;
    boolean flag;
    public isNumber(String st){
        str=st;
    }
    public int isN(String st){
        str=st;
        N = Integer.parseInt(str);
        return N;
    }
    public boolean check(String st){
        str=st;
        try{
            
            N = Integer.parseInt(str);
            
        } catch(NumberFormatException nfe){
            flag = false;
            b = 1;
        }
        if (b==0){
            flag = true;
        }
        return flag;
    }
    
}
