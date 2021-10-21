/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfg_otomata_30;

import static com.sun.jmx.snmp.ThreadContext.contains;
import com.sun.xml.internal.fastinfoset.util.CharArray;
import com.sun.xml.internal.fastinfoset.util.CharArrayString;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * 181213002 Büşra Balaban
 */

public class CFG_otomata_30 {
    
     public  static String yaz(Object[] a) {
        if (a == null)
            return "null";

        int iMax = a.length - 1;
        if (iMax == -1)
            return "";  

        StringBuilder b = new StringBuilder();
        b.append("");
        for (int i = 0; ; i++) {
            b.append(String.valueOf(a[i]));
            if (i == iMax)
                return b.append("").toString();
            b.append(" ");
        }
    }

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("------------------CFG MENU-------------------");
        System.out.println("1)Enter the alphabet:ör.a,b,X");
        Scanner scanner=new Scanner(System.in);
        String alphabet=scanner.nextLine();
        System.out.println("2)Enter the rules like add '|' and ','and  '-->'  :ex. S-->aa|bX|aaX,X-->ab|b");
        String rules=scanner.nextLine();    
        System.out.println("3)Enter the number of word you would like to see : (press 0 to see every word combination)");
        int numWord=scanner.nextInt();
    
////         if empty exit 
        if(numWord<0|| alphabet.isEmpty()||rules.isEmpty()) {
            System.out.println("The given format is wrong , exiting..");
            System.exit(0);
        }
        
            
        LinkedList<String> tree= new LinkedList<String>();   
         
        

        String [] letters = alphabet.split(",");
//        int upperCase=0;
//        for (int i = 0; i < letters.length; i++) {
//            if (Character.isUpperCase(harfler[i].charAt(i))) upperCase++;
//        }
        
        String rulesString=rules.replaceAll("-", "").replaceAll(">", "");        
        String [] rule = ruleString.split(",");
        
          char[] list= new char[30];
            for(int i=0; i<rule.length; i++){
               list[i]=(rule[i].charAt(0));
            }
                
            

          String[] rulenew= new String[50];
          String[] temp= new String[rulenew.length];
          String[] temp2= new String[rulenew.length];
          String[] temp3= new String[rulenew.length];
          String[] temp4= new String[rulenew.length];
          String[] temp5= new String[rulenew.length];
          
          boolean f0=false,f2=false,f3=false,f4=false,f5=false;
          
          ArrayList<String[]> ruleArray=new ArrayList<>();
          
            for (int i = 0; i < rule.length; i++) {
                rule[i]=kural[i].substring(1);
                rulenew[i]=(java.util.Arrays.toString(rule[i].split("\\|")).replaceAll("[\\[\\](){}]" , "").replaceAll("\\s+","")); 
                
                switch(i){
                    case 0:temp=rulenew[i].split(",");
                        if (rulenew[i].contains(list+"")) {
                            f0=true;
                        }
                        break;
                    case 1:temp2=rulenew[i].split(",");
                        if (rulenew[i].contains(list+"")) f2=true;
                        break;
                    case 2:temp3=rulenew[i].split(",");
                        if (kural2[i].contains(list+"")) f3=true;
                        break;
                    case 3:temp4=rulenew[i].split(",");
                        if (kural2[i].contains(list+""))  f4=true;
                        break;
                    case 4:temp5=rulenew[i].split(",");
                        if (rulenew[i].contains(list+"")) f5=true;
                        break;
                    default:
                }
           
            }
          


           
//           s-->ax|bx,x-->a|b
       
           //adding to tree
           
           for (int i = 0; i < temp.length; i++) {
            tree.add(temp[i]);
//               System.out.println(tree.get(i));
        }
           

           
           
           
           String wordnew,word = null;
           int loop=0;
           while (loop!=500) {
               
               for (int i = 0; i < list.length; i++) {//control x and s
                   if(tree.isEmpty()){
                       System.out.println("empty tree");break;
                   }
                   
                   if(tree.peek().contains(list[1]+"")){//is there an x
                       wordnew=tree.removeFirst();
                         for (int j = 0; j < temp2.length; j++) {//apply x's rules                   
                                   
                               if (f2) {
                                   word=wordnew.replaceFirst(list[1]+"", temp2[j]);
                                   tree.addLast(word);
                                }
                               else{
                                   word=wordnew.replaceFirst(list[1]+"", temp2[j]);
                                   tree.addLast(word);
                               }
//                                   System.outddLast(word);
                          }
                   }
                   else if(tree.peek().contains(list[0]+"")){//is there an x
                       wordnew=tree.removeFirst();
                         for (int j = 0; j < temp.length; j++) {//apply x's rules 
                                   word=wordnew.replaceFirst(list[0]+"", temp[j]);
                                   tree.addLast(word);
//                                   System.out.println(word);
                          }
                   }
                   else if(tree.peek().contains(list[2]+"")){//is there an x
                       word=tree.removeFirst();
                         for (int j = 0; j < temp3.length; j++) {//apply x's rules 
                                   word=wordnew.replaceFirst(list[2]+"", temp3[j]);
                                   tree.addLast(word);
//                                   System.out.println(word);
                          }
                   }
                   else if(tree.peek().contains(list[3]+"")){//is there an x
                       wordnew=tree.removeFirst();
                         for (int j = 0; j < temp4.length; j++) {//apply x's rules
                                   word=wordnew.replaceFirst(list[3]+"", temp4[j]);
                                   tree.addLast(word);
//                                   System.out.println(word);
                          }
                   }
                    else if(tree.peek().contains(list[4]+"")){//is there an x
                       wordnew=tree.removeFirst();
                         for (int j = 0; j < temp4.length; j++) {//apply x's rules
                                   word=wordnew.replaceFirst(list[4]+"", temp5[j]);
                                   tree.addLast(word);
//                                   System.out.println(word);
                          }
                   }
                    
                   else{
                       word=tree.removeFirst();
                       tree.addLast(word);
                   }
                       
               }
               loop++;
               
           }


                LinkedList<String> addition= new LinkedList<String>(); 
                boolean flag=true;
                for (int i = 0; i < tree.size(); i++) {
                    for (int j = 0; j < addition.size(); j++) {
                        if(addition.get(j).equals(tree.get(i)))
                            flag=false;
                    }
                    if(flag)
                        addition.addLast(tree.get(i));
            
                }
                
                
                
                
                
                System.out.println("---------------WORDS--------------");
                if(numWord>addition.size()){
                    System.out.println("please try smaller number than (max="+toplam.size()+")");
                    exit(0);
                }
                if(numWord<=addition.size()&& numword!=0){
                for (int i = 0; i < numword; i++) {     
                   
                  System.out.print((i+1)+")"+addition.get(i)+" ");
                }
                }
                if(numword==0){
                    
                    for (int i = 0; i < addition.size(); i++) {     
                   
                  System.out.print((i+1)+")"+addition.get(i)+" ");
                }
                }
        
            
    }}
   
 

