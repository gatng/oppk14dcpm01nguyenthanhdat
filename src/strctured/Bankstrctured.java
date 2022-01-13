package strctured;

import java.util.Scanner;

public class Bankstrctured {
    static int accnumber = 122;
    static int accbanlace = 0;
    static Scanner input;

    public static void main(String[] args) {
        input = new Scanner(System.in);
         show();
         rut();
         show();
         nhap();
         show();
    }
    static void show(){
        System.out.println("tai khoan :");
        System.out.println("accnumber : "+accnumber);
        System.out.println("accbanlace : "+accbanlace);
    }
    static void rut(){
        System.out.println("rut tien :");
        int withdrawamount =0;
        withdrawamount = input.nextInt();
        accbanlace -=withdrawamount;
    }
    static void nhap(){
        System.out.println("nhap tien :");
        int deposiamount =0;
        deposiamount = input.nextInt();
        accbanlace +=deposiamount;

    }
}
    


    

 
   
   
    







     
