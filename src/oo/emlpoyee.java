package oo;

import java.util.Scanner;

public class Emlpoyee {
    String ten;
    int luong=0;
    Scanner input = new Scanner(System.in);

    void nhapten(){
        System.out.print("Nhap vao ten nhan vien: ");
        ten = input.nextLine();
         

    }
    void nhapluong(){
        System.out.print("Nhap vao  luong vien: ");
        int depositAmount = input.nextInt();
        luong +=depositAmount;
    }
}
