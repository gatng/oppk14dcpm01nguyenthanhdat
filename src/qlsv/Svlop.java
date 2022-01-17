package qlsv;

import java.util.Scanner;

public class Svlop {
    String ten;
    int masinhvien=0;
    Scanner input = new Scanner(System.in);
    
    void nhapten(){
        System.out.print("Nhap vao ten nhan vien: ");
        ten = input.nextLine();
    }

    void nhapmasosinhvien(){
        System.out.print("Nhap mssv : ");
        int mssv = input.nextInt();
         
    }
    void showsv(){
        System.out.println("thong tin sv");
        System.out.println("ten sv: " + ten);
        System.out.println("mssv: " + masinhvien);
    }



}
