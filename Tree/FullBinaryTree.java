// Membuat struktur node dengan data dan dua pointer ke child
class Node {
    int data;
    Node leftChild, rightChild;

    Node(int item) {
      data = item;
      leftChild = rightChild = null;
    }
}

// Membuat class Binary Tree
class FullBinaryTree {
  // Membuat node root
  Node root;

  // Method untuk cek apakah BTree termasuk Full BTree
  boolean isFullBinaryTree(Node node) {

    // 1. Cek apakah tree kosong
    if (node == null)
      return true;

    // 2. Cek node child
    // 3. Jika left child dan right child null, return true
    if (node.leftChild == null && node.rightChild == null)
      return true;

    // 4. Jika tidak, rekursi untuk mengecek masing child dari child dst.
    if ((node.leftChild != null) && (node.rightChild != null))
      return (isFullBinaryTree(node.leftChild) && isFullBinaryTree(node.rightChild));

    // 5. Return false karena tidak memenuhi syarat: 
    //    salah satu mempunyai dua child dan satunya tidak sama sekali
    return false;
  }

  // Main method untuk test
  public static void main(String args[]) {
    // 1. Membuat object BinaryTree
    FullBinaryTree tree = new FullBinaryTree();
    // 2. Menambah node pada BInaryTree
    tree.root = new Node(1);
    tree.root.leftChild = new Node(2);
    tree.root.rightChild = new Node(3);
    tree.root.leftChild.leftChild = new Node(4);
    tree.root.leftChild.rightChild = new Node(5);
    tree.root.rightChild.leftChild = new Node(6);
    tree.root.rightChild.rightChild = new Node(7);

    // 3. Memanggil method untuk mengecek
    if (tree.isFullBinaryTree(tree.root))
      System.out.print("The tree is a full binary tree");
    else
      System.out.print("The tree is not a full binary tree");
  }
}