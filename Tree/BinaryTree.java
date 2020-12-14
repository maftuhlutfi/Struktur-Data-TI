// Tree traversal

// Membuat Class Node untuk menyimpan data node
// 1. Mendefinisikan class Node
class Node {
  // 2. Variabel item untuk menyimpan data
  int item;
  // 3. Object Node untuk menyimpan node sebelah kiri dan kanan
  Node left, right;

  // 4. Constructor Node dengan parameter key
  public Node(int key) {
    // 5. Mengisi variabel item dengan data key
    item = key;
    // 6. Mengisi node kanan dan kiri dengan null
    left = right = null;
  }
}

// Membuat class Binary Tree
// 1. Mendefinisikan class
class BinaryTree {
  // 2. Membuat object Node root
  Node root;

  // 3. Constructor tanpa parameter -> root diisi null
  BinaryTree() {
  root = null;
  }

  // 4. Method postorder traversal
  void postorder(Node node) {
    // a. Jika node kosong, return
    if (node == null)
      return;

    // b. Traverse ke kiri (akan terjadi recursion sampai ke node daun paling kiri)
    postorder(node.left);
    // c. Traverse ke kanan
    postorder(node.right);
    // d. Traverse ke root (print data pada root)
    System.out.print(node.item + "->");
  }

  // 5. Method inorder traversal
  void inorder(Node node) {
    // a. Jika node kosong, return
    if (node == null)
      return;

    // b. Traverse ke kiri (akan terjadi recursion sampai ke node daun paling kiri)
    inorder(node.left);
    // c. Traverse ke root (print data pada root)
    System.out.print(node.item + "->");
    // d. Traverse ke kanan
    inorder(node.right);
  }

  void preorder(Node node) {
    // a. Jika node kosong, return
    if (node == null)
      return;

    // b. Traverse ke root (print data pada root)
    System.out.print(node.item + "->");
    // c. Traverse ke kiri (akan terjadi recursion sampai ke node daun paling kiri)
    preorder(node.left);
    // d. Traverse ke kanan
    preorder(node.right);
  }

  // Main method untuk test
  public static void main(String[] args) {
    // 1. Membuat object BinaryTree
    BinaryTree tree = new BinaryTree();
    // 2. Menambah node pada BInaryTree
    tree.root = new Node(1);
    tree.root.left = new Node(12);
    tree.root.right = new Node(9);
    tree.root.left.left = new Node(5);
    tree.root.left.right = new Node(6);

    // 3. Test inorder traversal
    System.out.println("Inorder traversal");
    tree.inorder(tree.root);

    // 4. Test preorder traversal
    System.out.println("\nPreorder traversal ");
    tree.preorder(tree.root);

    // 5. Test postorder traversal
    System.out.println("\nPostorder traversal");
    tree.postorder(tree.root);
  }
}