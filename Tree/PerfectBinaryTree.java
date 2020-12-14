// Membuat class Perfect BTree
class PerfectBinaryTree {

  // Membuat static class untuk struktur node dengan key dan dua pointer ke child
  static class Node {
    int key;
    Node left, right;
  }

  // Method untuk menghitung depth dari node
  static int depth(Node node) {
    // 1. Membuat variabel untuk menyimpan depth
    int d = 0;
    // 2. Menghitung depth dengan menjelajahi node ke kiri
    while (node != null) {
      d++;
      node = node.left;
    }
    // 3. Mengembalikan nilai depth
    return d;
  }

  // Method untuk mengecek apakah perfect btree
  static boolean is_perfect(Node root, int d, int level) {

    // 1. Cek apakah tree kosong
    if (root == null)
      return true;

    // 2. Jika left dan right child kosong
    //    return perbandingan depth dan level + 1
    if (root.left == null && root.right == null)
      return (d == level + 1);

    // 3. Jika left dan right child salah satunya kosong
    //    return false
    if (root.left == null || root.right == null)
      return false;

    // 4. Jika left dan right child tidak kosong
    //    return rekursi left child dan right child
    return is_perfect(root.left, d, level + 1) && is_perfect(root.right, d, level + 1);
  }

  // Wrapper function
  // Untuk memulai rekursi dengan root, depth 1, level 0
  static boolean is_Perfect(Node root) {
    int d = depth(root);
    return is_perfect(root, d, 0);
  }

  // Method static untuk membuat node baru
  static Node newNode(int k) {
    Node node = new Node();
    node.key = k;
    node.right = null;
    node.left = null;
    return node;
  }

  // Main method untuk test
  public static void main(String args[]) {
    // 1. Membuat node root
    Node root = null;
    // 2. Menambahkan beberapa node
    root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);

    // 3. Cek apakah perfect binary tree
    if (is_Perfect(root) == true)
      System.out.println("The tree is a perfect binary tree");
    else
      System.out.println("The tree is not a perfect binary tree");
  }
}