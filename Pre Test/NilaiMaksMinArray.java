/*
Nama  : Muchamad Lutfi Maftuh
NIM   : 19537141023
Prodi : Teknologi Informasi
*/

import java.util.*;

public class NilaiMaksMinArray {
    static Scanner input = new Scanner(System.in);
    static float[] arrayNilai = new float[0];
    
	public static void main(String[] args) {
		System.out.println("## Program NilaiMaksMin ##");
		mainMenu();
	}
	
	public static void mainMenu() {
	    System.out.println("\n=========");
	    System.out.println("MAIN MENU");
	    System.out.println("=========");
	    System.out.println("1. Input Nilai");
	    System.out.println("2. Lihat Nilai");
	    System.out.println("3. Cari Nilai Tertinggi");
	    System.out.println("4. Cari Nilai Terendah");
	    System.out.println("5. Keluar");
	    System.out.print("Silahkan pilih menu: ");
	    int userChoice = input.nextInt();
	    switch (userChoice) {
	        case 1: inputNilai(); break;
	        case 2: lihatNilai(); break;
	        case 3: cariMax(); break;
	        case 4: cariMin(); break;
	        case 5: System.exit(1);
	    }
	}
	
	public static void inputNilai() {
	    String confirm = "";
	    System.out.println("\n1. Input Nilai");
	    do {
	        System.out.print("Masukkan nilai: ");
	        float nilai = input.nextFloat();
	        arrayNilai = addNilai(nilai);
	        System.out.println(Arrays.toString(arrayNilai));
	        System.out.print("Lanjut input nilai (y/n)? ");
	        confirm = input.next();
	    } while (confirm.equalsIgnoreCase("y"));
	    mainMenu();
	}
	
	public static float[] addNilai(float nilai) {
	    int n = arrayNilai.length;
	    float[] newArrayNilai = new float[n + 1];
	    
	    for (int i = 0;i < n;i++) {
	        newArrayNilai[i] = arrayNilai[i];
	    }
	    
	    newArrayNilai[n] = nilai;
	    return newArrayNilai;
	}
	
	public static void lihatNilai() {
	    System.out.println("\n2. Lihat Nilai");
	    int n = arrayNilai.length;
	    if (n > 0) {
	        for (int i = 0;i < n;i++) {
	            System.out.println(arrayNilai[i]);
	        }
	    } else {
	        System.out.println("Maaf, tidak ada nilai yang dapat ditampilkan");
	    }
	    mainMenu();
	}
	
	public static void cariMax() {
	    System.out.println("\n3. Cari Nilai Tertinggi");
	    Arrays.sort(arrayNilai);
	    int n = arrayNilai.length;
	    if (n > 0) {
	        String confirm = "";
	        do {
    	        System.out.print("Masukkan peringkat: ");
    	        int peringkat = input.nextInt() - 1;
    	        if (peringkat >= 0 && peringkat < n) {
    	            System.out.println(arrayNilai[n - 1 - peringkat]);
    	        } else {
    	            System.out.println("Maaf, peringkat tidak valid.");
    	        }
    	        System.out.print("Lanjut cari nilai tertinggi (y/n)? ");
    	        confirm = input.next();
    	    } while (confirm.equalsIgnoreCase("y"));
	    } else {
	        System.out.println("Maaf, tidak ada nilai yang dapat ditampilkan");
	    }
	    mainMenu();
	}
	
	public static void cariMin() {
	    System.out.println("\n4. Cari Nilai Terendah");
	    Arrays.sort(arrayNilai);
	    int n = arrayNilai.length;
	    if (n > 0) {
	        String confirm = "";
	        do {
    	        System.out.print("Masukkan peringkat: ");
    	        int peringkat = input.nextInt() - 1;
    	        if (peringkat >= 0 && peringkat < n) {
    	            System.out.println(arrayNilai[peringkat]);
    	        } else {
    	            System.out.println("Maaf, peringkat tidak valid.");
    	        }
    	        System.out.print("Lanjut cari nilai terendah (y/n)? ");
    	        confirm = input.next();
    	    } while (confirm.equalsIgnoreCase("y"));
	    } else {
	        System.out.println("Maaf, tidak ada nilai yang dapat ditampilkan");
	    }
	    mainMenu();
	}
}
