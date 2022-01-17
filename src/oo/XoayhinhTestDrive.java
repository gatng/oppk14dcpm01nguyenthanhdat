package oo;

public class XoayhinhTestDrive {
    public static void main(String[] args) {
        Hinhtamgiac htg;

        htg = new Hinhtamgiac();
        htg.show();
        htg.rotateHTG();
        htg.playaudio();

        Hinhtron ht;

        ht = new Hinhtron();
        ht.show();
        ht.rotateHT();
        ht.playaudio();

        Hinhvuong hv;
        
        hv =new Hinhvuong();
        hv.show();
        hv.rotateHV();
        hv.playaudio();
    }
}
