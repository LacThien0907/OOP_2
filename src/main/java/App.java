import entities.PhanSo;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
//        PhanSo ps1 = new PhanSo();
//        ps1.input();

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap a/b: ");
        String strPs1 = sc.nextLine();
        PhanSo ps1 = PhanSo.fromString(strPs1);
        ps1.print();

        // HAM KIEM TRA PHAN SO TOI GIAN
        if (ps1.isReducible() == true) {
            System.out.println("Phan so chua toi gian");
        } else {
            System.out.println("Phan so da toi gian");
        }

        // HAM KIEM TRA PHAN SO AM DUONG
        if (ps1.isPositive() == true) {
            System.out.println("Phan so duong");
        } else {
            System.out.println("Phan so am");
        }

        // HAMF RUT GON
        ps1.reduce();
        ps1.print();

        // TAO PHAN SO THU 2
        PhanSo ps2 = PhanSo.fromString("4/8");

        //GOI HAM SO SANH 2 PHAN SO
        if (ps1.compareTo(ps2) == 1) {
            System.out.println("PS1 > PS2");
        } else if (ps1.compareTo(ps2) == -1) {
            System.out.println("PS1 < PS2");
        } else {
            System.out.println("PS1 = PS2");
        }

        ps1.plus(ps2);
        System.out.println(ps1);
    }
}

