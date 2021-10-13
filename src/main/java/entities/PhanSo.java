package entities;

import java.util.Scanner;

public class PhanSo {
    private int tuSo, mauSo;

    public PhanSo() {
    }

    public PhanSo(int tuSo, int mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }

    @Override
    public String toString() {
        return String.format("%d/%d\n", this.tuSo,this.mauSo);
    }

    public void print() {
        System.out.format("%d/%d\n", this.tuSo, this.mauSo);
    }

    private static int gcd(int a, int b) {
        if (a == b) {
            return a;
        }
        if (a > b) {
            return gcd(a - b, b);
        }
        return gcd(a, b - a);
    }

    public boolean isReducible() {
        int gcd = gcd(Math.abs(this.tuSo), Math.abs(this.mauSo));

        if (gcd == 1) {
            return false;
        }
        return true;
    }

    public void reduce() {
        int gcd = gcd(Math.abs(this.tuSo), Math.abs(this.mauSo));

        this.tuSo /= gcd;
        this.mauSo /= gcd;
    }

    public boolean isPositive() {
        if (this.tuSo * this.mauSo >= 0) {
            return true;
        }
        return false;
    }


    public static PhanSo fromString(String str) {
        String[] parts = str.split("/");

        PhanSo ps = new PhanSo();
        ps.tuSo = Integer.parseInt(parts[0]);
        ps.mauSo = Integer.parseInt(parts[1]);
        return ps;
    }

    public int compareTo(PhanSo anotherPhanSo) {
        long tmp1 = this.tuSo*anotherPhanSo.mauSo;
        long tmp2 = this.mauSo * anotherPhanSo.tuSo;

        if (tmp1 > tmp2){
            return 1;
        }else if (tmp1 < tmp2){
            return -1;
        }
        return 0;
    }

    public void plus (PhanSo anotherPhanSo){
        int tmp_ts = this.tuSo*anotherPhanSo.mauSo + this.mauSo * anotherPhanSo.tuSo;
        int tmp_ms = this.mauSo*anotherPhanSo.mauSo;
        this.tuSo = tmp_ts;
        this.mauSo = tmp_ms;
        this.reduce();

    }



}




