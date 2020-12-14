import java.util.*; 

class HashTable { 
  public static void main(String args[]) {
    // Membuat object HashTable
    Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>(); 

    // Menambahkan 4 elemen baru dengan method put(key, value)
    ht.put(123, 432); 
    ht.put(12, 2345);
    ht.put(15, 5643); 
    ht.put(3, 321);

    // Mencetak hash table
    System.out.println("Isi hash table: " + ht);

    // Method put juga bisa digunakan untuk update
    ht.put(123, 222);

    // Menghapus elemen dengan method remove(key)
    ht.remove(12);

    System.out.println("Setelah menghapus element dengan key 12: " + ht);

    // Mengambil value dengan key tertentu menggunakan method get(key)
    System.out.println("Value pada key 123: " + ht.get(123));

    // Melihat size hash table
    System.out.println("Size hash table: " + ht.size());
  } 
}