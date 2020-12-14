// Membuat class HashTable
class HashTable {
    // Array untuk menyimpan data (key, value)
    HashNode[] hashArray;
    // Variabel untuk menyimpan kapasitas hash table
    int capacity;
    
    // Class untuk menyimpan key dan value
    class HashNode {
      int key;
      String value;
  
      HashNode(int k, String v) {
        key = k;
        value = v;
      }
    }
    
    // Constructor dengan parameter untuk men-set kapasitas
    HashTable(int n) {
        hashArray = new HashNode[n];
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

    public int linearProbing(int k, int i) {
        return (hashFunction(k) + i) % getPrime(capacity);
    }

    public int quadraticProbing(int k, int i) {
        int c1 = 1;
        int c2 = 1;
        return (hashFunction(k) + c1 * i + c2 * i * i) % getPrime(capacity);
    }

    public int doubleHashing(int k, int i) {
        return (hashFunction(k) + i * hashFunction(k)) % getPrime(capacity);
    }

    // Method untuk menambah data
    public void insertData(int key, String value) {
        // Membuat hash node baru untuk menyimpan key dan value
        HashNode newNode = new HashNode(key, value);

        // Mencari index dengan h(k)
        int index = hashFunction(key);

        // Melakukan linear probing jika index sudah terisi
        int i = 0;
        while (hashArray[index] != null) {
            index = doubleHashing(key, i);
            i++;
        }

        // Memasukkan data ke array (hash table)
        hashArray[index] = newNode;
    }

    // Method untuk menghapus data
    public void removeData(int key) {
        // Mencari index
        int index = hashFunction(key);
        // Set elemen pada index ke null
        hashArray[index] = null;
    }

    // @Override toString untuk print isi hash table
    public String toString() {
        String s = "{ ";
        // for (HashNode hashNode : hashArray) {
        //     if (hashNode != null) {
        //         s += hashNode.key + "=" + hashNode.value + ", ";
        //     }
        // }
        for (int i = 0; i < hashArray.length; i++) {
            if (hashArray[i] != null) {
                s += "[" + i + "] " + hashArray[i].key + "=" + hashArray[i].value + ", ";
            }
        }
        s += " }";
        return s;
    }
  }

public class MyHashTable {
    public static void main(String[] args) {
        // Membuat object hash table dengan kapasitas 10
        HashTable ht = new HashTable(10);
        // Menambahkan data
        ht.insertData(119, "apple");
        ht.insertData(202, "mango");
        ht.insertData(213, "banana");
        ht.insertData(654, "guava");
        System.out.println(ht);
    }
}
