package BaiGiuaKy;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ListGiaoDich {
    private GiaoDich[] gD = new GiaoDich[100];
    private int countGD,tongNha=0,tongDat=0;
    private double tongTienDat =0,tBTienDat;

    public ListGiaoDich(){
        countGD =0;
 
    }

    public void nhapDS(int temp) throws ParseException{
        if(countGD>100){
            System.out.println("Danh sach qua tai!!!");
        }else{
            if(temp == 1){
                gD[countGD] = new Giadichdat();
                Giadichdat gDDat = new Giadichdat();
                gDDat.nhap();
                gDDat.tinhThanhTien();
                gD[countGD] = gDDat;
                tongTienDat += gDDat.getThanhTien();
                tongDat++;
            }else{
                gD[countGD] = new GiaoDichNha();
                GiaoDichNha gDNha = new GiaoDichNha();
                gDNha.nhap();
                gDNha.tinhThanhTien();
                gD[countGD] = gDNha;
                tongNha++;
            }
            countGD++;
        }
    }
    public void inDS() {
        for (int i = 0; i < countGD; i++) {

            System.out.println(gD[i].toString());
        }
    }
    public void tongSLTungLoai() {
        System.out.println("Tong so luong giao dich nha: "+tongNha);
        System.out.println("Tong so luong giao dich dat: "+tongDat);
    }


    public void tBThanhTienGDDat() {


        tBTienDat = tongTienDat/tongDat;
        System.out.println("Trung binh thanh tien giao dich dat: "+tBTienDat);
    }
    SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy");
    public void inGiaoDichTheoThang()throws ParseException {
        
        for (int i = 0; i < countGD; i++) {
            if(gD[i].getNgayGiaoDich().compareTo(sdf.parse("01/09/2013"))>0 && gD[i].ngayGiaoDich.compareTo(sdf.parse("31/09/2013"))<0){
                System.out.println(gD[i].toString());
            }
        }
    }
}
