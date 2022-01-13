package non_strctured;

import java.util.Scanner;

public class bank {
    public static void main(String[] args) {
        int accnumber = 122;
        int accbanlace = 0;
        Scanner input;
        input = new Scanner(System.in);

        System.out.println("nhap tien :");
        int deposiamount =0;
        deposiamount = input.nextInt();
        accbanlace +=deposiamount;

        System.out.println("rut tien :");
        int withdrawamount =0;
        withdrawamount = input.nextInt();
        accbanlace -=deposiamount;
        System.out.println("tai khoan :");
        System.out.println("accnumber : "+accnumber);
        System.out.println("accbanlace : "+accbanlace);




         

    }
}
