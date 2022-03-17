package BaiGiuaKy;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class Giadichdat extends GiaoDich {
    private String loaiDat;
    private int choiceDat;

    public String getLoaiDat() {
        return loaiDat;
    }

    public void setLoaiDat(String loaiDat) {
        this.loaiDat = loaiDat;
    }

    
    public Giadichdat() {
    }

    public Giadichdat(int maGiaoDich, Date ngayGiaoDich, double donGia, double dienTich, String loaiDat) {


        super(maGiaoDich, ngayGiaoDich, donGia, dienTich);
        this.loaiDat = loaiDat;
    }
    Scanner sc = new Scanner(System.in);
    
    @Override
    public void nhap() throws ParseException {
        
        super.nhap();
        System.out.println("Nhap loai dat: ");
        System.out.println("Loai A");
        System.out.println("Loai B");
        System.out.println("Loai C");
        System.out.print(" chon: ");
        choiceDat = sc.nextInt();

        switch (choiceDat) {
            case 1:
                this.loaiDat = "loai A";
                break;
            case 2:
                this.loaiDat = "loai B";
                break;
            case 3:
                this.loaiDat = "loai C";
                break;
            default:
                break;
        }
    }
    
    @Override
    void tinhThanhTien() {
        if(choiceDat == 1){
            this.thanhTien = this.dienTich*this.donGia*1.5;
        }else{
            this.thanhTien = this.dienTich*this.donGia;
        }
    }
    @Override
    public String toString() {
     
        return super.toString()+"Loai dat: "+this.loaiDat+"hanh tien: "+this.thanhTien;
    }

 


}
