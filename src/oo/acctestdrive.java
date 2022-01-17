package oo;

public class AccTestDrive {
    public static void main(String[] args) {
        //Bien tham chieu doi tuong
        Acc account;

        account = new Acc();

        account.show();
        account.depoist();
        account.show();

        account.withdraw();
        account.show();
    }
}
