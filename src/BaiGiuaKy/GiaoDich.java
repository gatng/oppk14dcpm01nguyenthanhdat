package BaiGiuaKy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public abstract class GiaoDich {
    
    protected int maGiaoDich;
    protected Date ngayGiaoDich;
    protected double donGia;
    protected double dienTich;
    protected double thanhTien;

    protected int getMaGiaoDich() {
        return maGiaoDich;
    }
    protected void setMaGiaoDich(int maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }
    protected Date getNgayGiaoDich() {
        return ngayGiaoDich;
    }
    protected void setNgayGiaoDich(Date ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }
    protected double getDonGia() {
        return donGia;
    }
    protected void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    protected double getDienTich() {
        return dienTich;
    }
    protected void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }
    protected double getThanhTien() {
        return thanhTien;
    }

    

    abstract void tinhThanhTien();

    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy");
    protected void nhap() throws ParseException{
        System.out.print("Nhap ma giao dich: ");
        setMaGiaoDich(sc.nextInt());
        sc.nextLine();
        System.out.print("Nhap ngay giao dich: ");
        setNgayGiaoDich(sdf.parse(sc.nextLine()));
        System.out.print("Nhap don gia: ");
        setDonGia(sc.nextDouble());
        System.out.print("Nhap dien tich: ");
        setDienTich(sc.nextDouble());
    }
    protected GiaoDich() {
    }
    protected GiaoDich(int maGiaoDich, Date ngayGiaoDich, double donGia, double dienTich) {
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
        this.donGia = donGia;
        this.dienTich = dienTich;
    }
    
     
    @Override
    public String toString() {
         
        return "Ma giao dich: "+this.maGiaoDich+"Ngay giao dich: "+sdf.format(this.ngayGiaoDich)+"Don gia: "+this.donGia+"Dien tich: "+this.dienTich;
    }
}
