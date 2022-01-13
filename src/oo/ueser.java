package oo;

import java.util.Scanner;

public class ueser {
    int account_number = 12345;
    int account_banlance = 0;
    String ten;

    Scanner input = new Scanner(System.in);

    void withdraw() {
        System.out.print("Nhap vao so tien can rut > ");
        int withdrawAmount = input.nextInt();
        account_banlance -= withdrawAmount;// thao tac len data
        // account_banlance = account_banlance - withdrawAmount;
    }
    void depoist() {
        // gui tien: deposit
        System.out.print("Nhap vao so tien gui > ");
        int depositAmount = 0;
        depositAmount = input.nextInt();
        account_banlance += depositAmount;// thao tac len data
    }
    void show() {
        System.out.println("ten nguoi dung : "+ten);
        System.out.println("thong tin tai khoan");

        System.out.println("Account number: " + account_number);
        System.out.println("Account balance: " + account_banlance);

    }

    void nhapten(){
        System.out.print("Nhap vao ten nguoi dung: ");
        ten = input.nextLine();
    }


}
