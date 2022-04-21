package k14dcpm02;

 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class QuanLyDanhSachHangHoa{
    private List<HangHoa> list = new ArrayList<>();
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static Scanner so = new Scanner(System.in);
    public static Scanner chu = new Scanner(System.in);
////////////////////////////////////////////////////
    public static void resetSo(){
        so= new Scanner(System.in);
    }
    public void duLieuCoSan() throws ParseException  
    {
        list.add(new HangThucPham("Thịt ", "001", 10, 25.000, simpleDateFormat.parse("3/7/2020"), simpleDateFormat.parse("5/5/2022"), "Big C"));

        list.add(new HangThucPham("Cá ", "002", 20, 20.000, simpleDateFormat.parse("16/4/2020"), simpleDateFormat.parse("8/4/2022"), "Big C"));

        list.add(new HangThucPham("rau", "003", 20, 5.000,  simpleDateFormat.parse("1/5/2020"), simpleDateFormat.parse("12/8/2022"), "Big C"));
        
        list.add(new HangThucPham("Củ", "004", 50, 6.000, simpleDateFormat.parse("25/3/2022"),  simpleDateFormat.parse("30/3/2022"), "Big C"));
        
        list.add(new HangDienMay("Điện thoại", "005", 70, 500.000, 12, 15.000));
        
        list.add(new HangDienMay("laptop", "006", 120, 600.000, 32, 99.000));
        
        list.add(new HangDienMay("Tivi", "007", 150, 4000.000, 32, 70.000));

        list.add(new HangSanhSu("Bình", "008", 300, 50.000, "Gốm xa nhà", simpleDateFormat.parse("9/9/2022")));
        
        list.add(new HangSanhSu("Ly", "009", 200, 25.000, "Gốm gần nhà", simpleDateFormat.parse("27/3/2022")));
        
        list.add(new HangSanhSu("Tô", "010", 200, 20.000, "Gốm tại nhà", simpleDateFormat.parse("4/7/2022")));
        
        list.add(new HangSanhSu("chén", "011", 300, 15.000, "Gốm bay nhà", simpleDateFormat.parse("1/1/2022")));
    }
///////////////////////////////////////////////////////////////////////////
    public HangHoa nhapHangHoaKhongCoMa(String maHang)
    {
        HangHoa hangHoa = null;
        try {
            String tenHang=null;/////////////////
            do{
                System.out.print("Tên hàng: ");
                tenHang = chu.nextLine();
                if(tenHang.equalsIgnoreCase("")){
                    System.out.println("Tên hàng không được để rỗng");
                }
            }while(tenHang.equalsIgnoreCase(""));
            int soLuongTonKho=0;///////////////////////////
            do{
                System.out.print("Số lượng tồn: ");
                soLuongTonKho = so.nextInt();
                if(soLuongTonKho<0){
                    System.out.println("Số lượng tồn kho phải >=0");
                }
            }while(soLuongTonKho<0);
            double donGia=0.0;////////////////////////////////////
            do{
                System.out.print("Đơn giá: ");
                donGia = so.nextDouble();
                if(donGia<=0){
                    System.out.println("Đơn giá phải > 0");
                }
            }while(donGia<=0);
            int number=0;///////////////////////////////
            do{
                System.out.print("Loại hàng: 1 (Thực phẩm) | 2 (Điện máy) | 3 (Sành sứ) : ");
                number = so.nextInt();
                if(number!=1 && number!=2 && number!=3){
                    System.out.println("Thông tin nhập không phù hợp, vui lòng thử lại");
                }
            }while(number!=1 && number!=2 && number!=3);
            if(number==1)//////////////////////////////////////
            {
                Date ngaySX=null;
                Date ngayHetHan=null;
                do{
                    System.out.print("Ngày sản xuất (dd/mm/yyyy): ");
                    ngaySX = simpleDateFormat.parse(chu.nextLine());
                    System.out.print("Ngày hết hạn (dd/mm/yyyy): ");
                    ngayHetHan = simpleDateFormat.parse(chu.nextLine());
                    if(ngayHetHan.before(ngaySX)){
                        System.out.println("Ngày hết hạn phải sau ngày hoặc là ngày sản xuất");
                    }
                }while(ngayHetHan.before(ngaySX));
                System.out.print("Nhà cung cấp: ");
                String nhaCungCap = chu.nextLine();
                hangHoa = new HangThucPham(tenHang, maHang, soLuongTonKho, donGia, ngaySX, ngayHetHan, nhaCungCap);
            }
            else if(number==2)////////////////////////////////////////////
            {
                int tGBaoHanh;
                do{
                    System.out.print("Thời gian bảo hành (tháng): ");
                    tGBaoHanh = so.nextInt();
                    if(tGBaoHanh<0){
                        System.out.println("Thời gian bảo hành phải >=0");
                    }
                }while(tGBaoHanh<0);
                double congSuatKW;
                do{
                    System.out.print("Công suất(KW): ");
                    congSuatKW = so.nextDouble();
                    if(congSuatKW<=0){
                        System.out.println("Công suất phải >0");
                    }
                }while(congSuatKW<=0);
                hangHoa = new HangDienMay(tenHang, maHang, soLuongTonKho, donGia, tGBaoHanh, congSuatKW);
            }
            else
            {
                System.out.print("Nhà sản xuất: ");
                String nhaSanXuat = chu.nextLine();
                System.out.print("Ngày nhập kho (dd/mm/yyyy): ");
                Date ngayNhapKho = simpleDateFormat.parse(chu.nextLine());
                hangHoa = new HangSanhSu(tenHang, maHang, soLuongTonKho, donGia, nhaSanXuat, ngayNhapKho);
            
            }
        } catch (Exception e) {
            resetSo();
            System.out.println("Chương trình bị lỗi do bạn nhập chữ vào chỗ cần nhập số hoặc nhập sai định dạng ngày, vui lòng thử lại");
            e.printStackTrace();
        }
        return hangHoa;
    }
    public void them(HangHoa hangHoa)
    {
        if(hangHoa!=null){
            this.list.add(hangHoa);
            
        }
    }
    public boolean kiemTraMaHangTrung(String maHang){
        boolean kt = false;
        for (HangHoa hangHoa : list) {
            if( hangHoa.getMaHang().equals(maHang)){
                kt=true;
            }
        }
        return kt;
    }
//////////////////////////////////////////////////////////////////////////////
    public void xuat()
    {
        for(HangHoa hangHoa : list)
        {
            System.out.println(hangHoa);
            System.out.println();
        }
    }
    public void xuatHangThucPham(){
        for (HangHoa hangHoa : list) {
            if(hangHoa instanceof HangThucPham){
                System.out.println(hangHoa);
                System.out.println();
            }
        }
    }
    public void xuatHangDienMay(){
        for (HangHoa hangHoa : list) {
            if(hangHoa instanceof HangDienMay){
                System.out.println(hangHoa);
                System.out.println();
            }
        }
    }
    public void xuatHangSanhSu(){
        for (HangHoa hangHoa : list) {
            if(hangHoa instanceof HangSanhSu){
                System.out.println(hangHoa);
                System.out.println();
            }
        }
    }
///////////////////////////////////////////////////////////////////////////////
    public HangHoa timHangTheoMa(String maHang)
    {
        HangHoa hangHoa = null;
        for(HangHoa hangHoa2 : list)
        {
            if(hangHoa2.getMaHang().toString().equalsIgnoreCase(maHang))
            {
                hangHoa = hangHoa2;
            }
        }
        if(hangHoa==null){
            System.out.println("Không tìm thấy");
        }
        return hangHoa;
    }
    public void traVeKetQua(HangHoa hangHoa)
    {
        if(hangHoa!=null){
            System.out.println(hangHoa);
        }
    }
    public List<HangHoa> timHangHoaTheoTen(String tenHang){
        List<HangHoa> list1= new ArrayList<>();
        for (HangHoa hangHoa : list) {
            if(hangHoa.getTenHang().equalsIgnoreCase(tenHang)){
                list1.add(hangHoa);
            }
        }
        return list1;
    }
    public List<HangHoa> timHangHoaTheoKhoangGia(double donGia1, double donGia2){
        List<HangHoa> list1= new ArrayList<>();
        for (HangHoa hangHoa : list) {
            if(hangHoa.getDonGia()>=donGia1 && hangHoa.getDonGia()<=donGia2){
                list1.add(hangHoa);
            }
        }
        return list1;
    }
    public void xuatKetqua(List<HangHoa> list1){
        if(list1.isEmpty()){
            System.out.println("Không tìm thấy");
        }
        else{
            for (HangHoa hangHoa : list1) {
                System.out.println(hangHoa);
                System.out.println();
            }
        }
    }
/////////////////////////////////////////////////////////////////////
    public void xoa(HangHoa hangHoa)
    {
        if(hangHoa!=null){
            this.list.remove(hangHoa);
            System.out.println("Đã xóa");
            
        }
    }
    public String nhapMaHangHoa(){
        String maHang=null;//////////////////
        boolean kiemTraMa=true;
        do{
            try {
                System.out.print("Mã hàng: ");
                maHang = chu.nextLine();
                kiemTraMa=kiemTraMaHangTrung(maHang);
                if(maHang.equalsIgnoreCase("")){
                System.out.println("Mã hàng không được để rỗng");
                }
                else if(kiemTraMa==true){
                    System.out.println("Mã hàng này đã tồn tại, hãy nhập mã hàng khác");
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }while(maHang.equalsIgnoreCase("") || kiemTraMa==true);
        return maHang;
    }
    public int timViTriHangHoa(HangHoa hangHoa)
    {
        int viTri = -1;
        viTri = this.list.indexOf(hangHoa);
        return viTri;
    }
    public void suaHangHoa(String maHang)
    {
        int viTri= timViTriHangHoa(timHangTheoMa(maHang));
        if(viTri == -1)
        {
            System.out.println(" Không tìm thấy ");
        }
        else
        {
            HangHoa hangHoa = nhapHangHoaKhongCoMa(maHang);
            if(hangHoa!=null){
                this.list.set(viTri, hangHoa);
                System.out.println("Đã sửa");
                
            }
        }
    }
/////////////////////////////////////////////////////////////////////////////
    public void sapXepTangDanTheoGia(){// danh sách
        Comparator<HangHoa> comp = new Comparator<HangHoa>(){
            public int compare(HangHoa o1, HangHoa o2) {
                return Double.compare(o1.getDonGia(), o2.getDonGia());
            }
        };
        Collections.sort(list, comp);
        System.out.println("Đã sắp xếp");
    }
    public void sapXepGiamDanTheoGia(){
        sapXepTangDanTheoGia();
        Collections.reverse(list);
    }
    public void sapXepGiamDanTheoSoLuongTon(){
        sapXepTangDanTheoSoLuongTon();
        Collections.reverse(list);
    }
    public void sapXepTangDanTheoSoLuongTon(){
        Comparator<HangHoa> comp = new Comparator<HangHoa>(){
            public int compare(HangHoa o1, HangHoa o2) {
                return Double.compare(o1.getSoLuongTon(), o2.getSoLuongTon());
            }
        };
        Collections.sort(list, comp);
        System.out.println("Đã sắp xếp");
    }
/////////////////////////////////////////////////////////////////////////
 
 
    public void thongKe(){
        int matHangThucPham=0;
        int matHangDienMay=0;
        int matHangSanhSu=0;
        double giaTriHangThucPham=0;
        double giaTriHangDienMay=0;
        double giaTriHangSanhSu=0;
        int tonHangThucPham=0;
        int tonHangDienMay=0;
        int tonHangSanhSu=0;
        int danhGiaHangThucPham=0;
        int danhGiaHangDienMay=0;
        int danhGiaHangSanhSu=0;
        for(HangHoa hangHoa : list)
        {
            if(hangHoa instanceof HangDienMay)
            {
                matHangDienMay += 1;
                giaTriHangDienMay += hangHoa.getDonGia()*hangHoa.getSoLuongTon()*1.1;
                tonHangDienMay += hangHoa.getSoLuongTon();
                if(!hangHoa.getDanhGia().equalsIgnoreCase("không có")){
                    danhGiaHangDienMay +=1;
                }
            }
            else if(hangHoa instanceof HangSanhSu)
            {
                matHangSanhSu += 1;
                giaTriHangSanhSu += hangHoa.getDonGia()*hangHoa.getSoLuongTon()*1.1;
                tonHangSanhSu += hangHoa.getSoLuongTon();
                if(!hangHoa.getDanhGia().equalsIgnoreCase("không có")){
                    danhGiaHangSanhSu +=1;
                }
            }
            else{
                matHangThucPham += 1;
                giaTriHangThucPham += hangHoa.getDonGia()*hangHoa.getSoLuongTon()*1.05;
                tonHangThucPham += hangHoa.getSoLuongTon();
                if(!hangHoa.getDanhGia().equalsIgnoreCase("không có")){
                    danhGiaHangThucPham +=1;
                }
            }
        }
        System.out.println("==== Mặt hàng thực phẩm ====");
        System.out.println("Tổng số lượng mặt hàng: "+matHangThucPham);
        System.out.println("Tổng giá trị: "+giaTriHangThucPham);
        System.out.println("Tổng số lượng hàng tồn: "+tonHangThucPham);
        System.out.println("Tổng số lượng hàng đánh giá khó bán: "+danhGiaHangThucPham);
        System.out.println("==== Mặt hàng điện máy ====");
        System.out.println("Tổng số lượng mặt hàng: "+matHangDienMay);
        System.out.println("Tổng giá trị: "+giaTriHangDienMay);
        System.out.println("Tổng số lượng hàng tồn: "+tonHangDienMay);
        System.out.println("Tổng số lượng hàng đánh giá bán được: "+danhGiaHangDienMay);
        System.out.println("==== Mặt hàng sành sứ ====");
        System.out.println("Tổng số lượng mặt hàng: "+matHangSanhSu);
        System.out.println("Tổng giá trị: "+giaTriHangSanhSu);
        System.out.println("Tổng số lượng hàng tồn: "+tonHangSanhSu);
        System.out.println("Tổng số lượng hàng đánh giá bán chậm: "+danhGiaHangSanhSu);
    }
}
