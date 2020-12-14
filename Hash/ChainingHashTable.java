import java.util.*;

public class ChainingHashTable {
    LinkedList<HashNode>[] hashArray;
    int capacity;
    
    // Class untuk menyimpan key dan value
    class HashNode {
        int key;
        String value;
    
        HashNode(int k, String v) {
          key = k;
          value = v;
        }

        public String toString() {
            return key + "=" + value;
        }
    }
    
    // Constructor dengan parameter untuk men-set kapasitas
    ChainingHashTable(int n) {
        hashArray = new LinkedList[n];
        capacity = n;
    }

    // Method untuk cek apakah bilangan prima
    public boolean checkPrime(int n) {
        if(n == 0 || n == 1)
            return false;
        
        for (int i = 2; i < n / 2; i++) {
            if(n % i == 0)
                return false;
        }
        return true;
    }

    // Method untuk mencari bilangan prima setelah n
    public int getPrime(int n) {
        if (n % 2 == 0)
            n += 1;
        
        while(!checkPrime(n)) {
            n += 2;
        }

        return n;
    }

    // Method h(k) untuk index
    public int hashFunction(int key) {
        // Mencari bilangan prima setelah capacity (untuk meminimalisir collision)
        int mod = getPrime(capacity);
        // Mereturn key % mod untuk index
        return key % mod;
    }

    // Method untuk menambah data
    public void insertData(int key, String value) {
        // Membuat hash node baru untuk menyimpan key dan value
        HashNode newNode = new HashNode(key, value);

        // Mencari index dengan h(k)
        int index = hashFunction(key);

        // Memasukkan data ke array (hash table)
        if(hashArray[index] == null) {
            hashArray[index] = new LinkedList<>();
            hashArray[index].add(newNode);
        } else {
            hashArray[index].add(newNode);
        }
    }

    // @Override toString untuk print isi hash table
    public String toString() {
        String s = "";
        for (int i = 0; i < hashArray.length; i++) {
            s += "[" + i + "] " + hashArray[i] + "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        ChainingHashTable cht = new ChainingHashTable(10);
        // Menambahkan data
        cht.insertData(119, "apple");
        cht.insertData(202, "mango");
        cht.insertData(213, "banana");
        cht.insertData(654, "guava");
        System.out.println(cht);
    }
}
