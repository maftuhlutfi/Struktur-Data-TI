// Membuat struktur node dengan data dan dua pointer ke child
class Node {
  int data;
  Node left, right;

  Node(int item) {
    data = item;
    left = right = null;
  }
}

// Membuat class BinaryTree
class CompleteBinaryTree {
  // Membuat root node
  Node root;

  // Method untuk menghitung jumlah node
  int countNumNodes(Node root) {
    // 1. Jika null, return 0
    if (root == null)
      return (0);
    // 2. Jika tidak rekursi ke left dan right child dan tambah dengan 1 (node ini sendiri)
    return (1 + countNumNodes(root.left) + countNumNodes(root.right));
  }

  // Method untuk cek apakah complete binary tree
  boolean checkComplete(Node root, int index, int numberNodes) {
    // 1. Jika null. return true
    if (root == null)
      return true;

    // 2. Jika index melebihi jumlah node, return false
    if (index >= numberNodes)
      return false;

    // 3. Rekursi dan bandingkan kembalian left dan right child
    //    Sesuai hubungan index array dan letak elemen dalam tree yaitu:
    //    Jika index elemen apa pun dalam array, maka 2i + 1 akan menjadi left childnya dan 2i + 2 right childnya
    return (checkComplete(root.left, 2 * index + 1, numberNodes)
        && checkComplete(root.right, 2 * index + 2, numberNodes));
  }

  // Main method untuk test
  public static void main(String args[]) {
    // 1. Membuat object Binary Tree
    CompleteBinaryTree tree = new CompleteBinaryTree();

    // 2. Menambahkan beberapa node
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.right = new Node(5);
    tree.root.left.left = new Node(4);
    tree.root.right.left = new Node(6);

    // 3. Membuat variable untuk menyimpan jumlah node
    int node_count = tree.countNumNodes(tree.root);
    // 4. Membuat variable untuk index dan diisi 0 (root)
    int index = 0;

    // 5. Cek apakah complete binary tree
    if (tree.checkComplete(tree.root, index, node_count))
      System.out.println("The tree is a complete binary tree");
    else
      System.out.println("The tree is not a complete binary tree");
  }
}