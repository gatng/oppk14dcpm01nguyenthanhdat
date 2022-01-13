package Oo;

public class acctestdrive {
    public static void main(String[] args) {
        //Bien tham chieu doi tuong
        acc account;

        account = new acc();

        account.show();
        account.depoist();
        account.show();

        account.withdraw();
        account.show();
    }
}
