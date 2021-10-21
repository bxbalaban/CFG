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
        System.out.println("1)Alfabeyi giriniz:ör.a,b,X");
        Scanner scanner=new Scanner(System.in);
        String alfabe=scanner.nextLine();
        System.out.println("2)Kuralları Giriniz '|' ve ',' ve '-->' ifadelerini kullanınız :ör. S-->aa|bX|aaX,X-->ab|b");
        String kurallar=scanner.nextLine();    
        System.out.println("3)Görüntülemek istediğiniz kelime sayısını giriniz:(tüm kelimeleri görüntülemek için 0 ı  tuşlayın)");
        int kelime_sayisi=scanner.nextInt();
    
////         if empty exit 
        if(kelime_sayisi<0|| alfabe.isEmpty()||kurallar.isEmpty()) {
            System.out.println("yanlış veya boş giriş yaptınız çıkılıyor.");
            System.exit(0);
        }
        
            
        LinkedList<String> tree= new LinkedList<String>();   
         
        

        String [] harfler = alfabe.split(",");
//        int upperCase=0;
//        for (int i = 0; i < harfler.length; i++) {
//            if (Character.isUpperCase(harfler[i].charAt(i))) upperCase++;
//        }
        
        String kuralString=kurallar.replaceAll("-", "").replaceAll(">", "");        
        String [] kural = kuralString.split(",");
        
          char[] liste= new char[30];
            for(int i=0; i<kural.length; i++){
               liste[i]=(kural[i].charAt(0));
            }
                
            

          String[] kural2= new String[50];
          String[] temp= new String[kural2.length];
          String[] temp2= new String[kural2.length];
          String[] temp3= new String[kural2.length];
          String[] temp4= new String[kural2.length];
          String[] temp5= new String[kural2.length];
          
          boolean f0=false,f2=false,f3=false,f4=false,f5=false;
          
          ArrayList<String[]> kural3=new ArrayList<>();
          
            for (int i = 0; i < kural.length; i++) {
                kural[i]=kural[i].substring(1);
                kural2[i]=(java.util.Arrays.toString(kural[i].split("\\|")).replaceAll("[\\[\\](){}]" , "").replaceAll("\\s+","")); 
                
                switch(i){
                    case 0:temp=kural2[i].split(",");
                        if (kural2[i].contains(liste+"")) {
                            f0=true;
                        }
                        break;
                    case 1:temp2=kural2[i].split(",");
                        if (kural2[i].contains(liste+"")) f2=true;
                        break;
                    case 2:temp3=kural2[i].split(",");
                        if (kural2[i].contains(liste+"")) f3=true;
                        break;
                    case 3:temp4=kural2[i].split(",");
                        if (kural2[i].contains(liste+""))  f4=true;
                        break;
                    case 4:temp5=kural2[i].split(",");
                        if (kural2[i].contains(liste+"")) f5=true;
                        break;
                    default:
                }
           
            }
          


           
//           s-->ax|bx,x-->a|b
       
           //kuyruk ağaç yapısı ilk verilerin eklenmesi
           
           for (int i = 0; i < temp.length; i++) {
            tree.add(temp[i]);
//               System.out.println(tree.get(i));
        }
           

           
           
           
           String yeni,kelime = null;
           int loop=0;
           while (loop!=500) {
               
               for (int i = 0; i < liste.length; i++) {//x ve s leri kontrol etmek için
                   if(tree.isEmpty()){
                       System.out.println("emptyyy");break;
                   }
                   
                   if(tree.peek().contains(liste[1]+"")){//x var mı
                       yeni=tree.removeFirst();
                         for (int j = 0; j < temp2.length; j++) {//x in kuralları kadar dön ve kelimeyi değiştir                             
                                   
                               if (f2) {
                                   kelime=yeni.replaceFirst(liste[1]+"", temp2[j]);
                                   tree.addLast(kelime);
                                }
                               else{
                                   kelime=yeni.replaceFirst(liste[1]+"", temp2[j]);
                                   tree.addLast(kelime);
                               }
//                                   System.outddLast(kelime);
                          }
                   }
                   else if(tree.peek().contains(liste[0]+"")){//x var mı
                       yeni=tree.removeFirst();
                         for (int j = 0; j < temp.length; j++) {//x in kuralları kadar dön ve kelimeyi değiştir
                                   kelime=yeni.replaceFirst(liste[0]+"", temp[j]);
                                   tree.addLast(kelime);
//                                   System.out.println(kelime);
                          }
                   }
                   else if(tree.peek().contains(liste[2]+"")){//x var mı
                       yeni=tree.removeFirst();
                         for (int j = 0; j < temp3.length; j++) {//x in kuralları kadar dön ve kelimeyi değiştir
                                   kelime=yeni.replaceFirst(liste[2]+"", temp3[j]);
                                   tree.addLast(kelime);
//                                   System.out.println(kelime);
                          }
                   }
                   else if(tree.peek().contains(liste[3]+"")){//x var mı
                       yeni=tree.removeFirst();
                         for (int j = 0; j < temp4.length; j++) {//x in kuralları kadar dön ve kelimeyi değiştir
                                   kelime=yeni.replaceFirst(liste[3]+"", temp4[j]);
                                   tree.addLast(kelime);
//                                   System.out.println(kelime);
                          }
                   }
                    else if(tree.peek().contains(liste[4]+"")){//x var mı
                       yeni=tree.removeFirst();
                         for (int j = 0; j < temp4.length; j++) {//x in kuralları kadar dön ve kelimeyi değiştir
                                   kelime=yeni.replaceFirst(liste[4]+"", temp5[j]);
                                   tree.addLast(kelime);
//                                   System.out.println(kelime);
                          }
                   }
                    
                   else{
                       kelime=tree.removeFirst();
                       tree.addLast(kelime);
                   }
                       
               }
               loop++;
               
           }


                LinkedList<String> toplam= new LinkedList<String>(); 
                boolean flag=true;
                for (int i = 0; i < tree.size(); i++) {
                    for (int j = 0; j < toplam.size(); j++) {
                        if(toplam.get(j).equals(tree.get(i)))
                            flag=false;
                    }
                    if(flag)
                        toplam.addLast(tree.get(i));
            
                }
                
                
                
                
                
                System.out.println("---------------KELİMELER--------------");
                if(kelime_sayisi>toplam.size()){
                    System.out.println("girdiğiniz kelime sayısı var olandan fazladır lütfen daha küçük (max="+toplam.size()+") bir numara deneyin");
                    exit(0);
                }
                if(kelime_sayisi<=toplam.size()&& kelime_sayisi!=0){
                for (int i = 0; i < kelime_sayisi; i++) {     
                   
                  System.out.print((i+1)+")"+toplam.get(i)+" ");
                }
                }
                if(kelime_sayisi==0){
                    
                    for (int i = 0; i < toplam.size(); i++) {     
                   
                  System.out.print((i+1)+")"+toplam.get(i)+" ");
                }
                }
        
            
    }}
   
 

