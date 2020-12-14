// Membuat program untuk operasi BST
class BinarySearchTree {
  // Membuat struktur node dengan key dan pointer ke dua child.
  class Node {
    int key;
    Node left, right;

    public Node(int item) {
      key = item;
      left = right = null;
    }
  }

  // Membuat node root
  Node root;

  // Constructor tanpa parameter, root set ke null
  BinarySearchTree() {
    root = null;
  }

  // method insert wrapper
  void insert(int key) {
    root = insertKey(root, key);
  }

  // method insert node baru
  Node insertKey(Node root, int key) {
    // 1. Jika null, buat node baru
    if (root == null) {
      root = new Node(key);
      return root;
    }

    // 2. Jika key data baru lebih kecil dari data root, traverse ke kiri
    if (key < root.key)
      root.left = insertKey(root.left, key);
    // 3. Jika lebih besar, traverse ke kanan
    else if (key > root.key)
      root.right = insertKey(root.right, key);

    // 4. Return root
    return root;
  }

  // method inorder wrapper
  void inorder() {
    inorderRec(root);
  }

  // method inorder traversal
  void inorderRec(Node root) {
    if (root != null) {
      inorderRec(root.left);
      System.out.print(root.key + " -> ");
      inorderRec(root.right);
    }
  }

  // method delete key wrapper
  void deleteKey(int key) {
    root = deleteRec(root, key);
  }

  // method delete node
  Node deleteRec(Node root, int key) {
    // 1. Jika null, return root 
    if (root == null)
      return root;

    // 2. Temukan node yang akan dihapus
    //    Jika key < root.key traverse ke kiri
    //    Jika key > root.key traverse ke kanan
    //    Jika sudah ketemu (else) lakukan pengecekan case
    if (key < root.key)
      root.left = deleteRec(root.left, key);
    else if (key > root.key)
      root.right = deleteRec(root.right, key);
    else {
      // 3. Jika node tidak mempunyai child atau mempunyai satu node (Case I dan II)
      if (root.left == null)
        return root.right;
      else if (root.right == null)
        return root.left;

      // 4. Jika node mempunyai dua child (Case III)
      //    ganti node dengan inorder successor
      root.key = minValue(root.right);
      //    hapus inorder successor
      root.right = deleteRec(root.right, root.key);
    }

    return root;
  }

  // method untuk mencari inorder successor
  int minValue(Node root) {
    // 1. Buat variabel untuk menyimpan key
    int minv = root.key;
    // 2. Traverse ke kiri sampai menemukan inorder successor
    while (root.left != null) {
      minv = root.left.key;
      root = root.left;
    }
    // 3. Return inorder successor
    return minv;
  }

  // main method untuk test
  public static void main(String[] args) {
    // 1. Membuat object BST
    BinarySearchTree tree = new BinarySearchTree();
    // 2. Tambahkan beberapa node
    tree.insert(8);
    tree.insert(3);
    tree.insert(1);
    tree.insert(6);
    tree.insert(7);
    tree.insert(10);
    tree.insert(14);
    tree.insert(4);
    // 3. Cek data dengan inorder traversal
    System.out.print("Inorder traversal: ");
    tree.inorder();
    // 4. Cek delete node dengan key 10
    System.out.println("\n\nAfter deleting 10");
    tree.deleteKey(10);
    System.out.print("Inorder traversal: ");
    tree.inorder();
  }
}