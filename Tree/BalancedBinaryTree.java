// Membuat struktur node dengan data dan dua pointer ke child
class Node {
  int data;
  Node left, right;

  Node(int d) {
    data = d;
    left = right = null;
  }
}

// Class untuk mengitung height dan mudah dimanipulasi karena nantinya dibuat object
class Height {
  int height = 0;
}

// Membuat class BinaryTree
class BalancedBinaryTree {
  // Membuat root node
  Node root;

  // Method untuk mengecek keseimbangan height pada node
  boolean checkHeightBalance(Node root, Height height) {

    // 1. Jika kosong, height = 0, return true
    if (root == null) {
      height.height = 0;
      return true;
    }

    // 2. Membuat object untuk ketinggian sisi kiri dan kanan
    Height leftHeighteight = new Height(), rightHeighteight = new Height();

    // 3. Membuat variabel l untuk menyimpan kembalian rekursi dari node child kiri
    boolean l = checkHeightBalance(root.left, leftHeighteight);
    // 4. Membuat variabel r untuk menyimpan kembalian rekursi dari node child kanan
    boolean r = checkHeightBalance(root.right, rightHeighteight);
    // 5. Membuat variabel untuk menyimpan tinggi sisi kiri dan sisi kanan dengan mengambilnya dari object langkah 2
    int leftHeight = leftHeighteight.height, rightHeight = rightHeighteight.height;

    // 6. Mengisi variabel height dengan leftHeight(jika lebih besar dari rightHeight) dan sebaliknya ditambah 1
    height.height = (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;

    // 7. Jika perbedaan tinggi sisi kanan dan kiri lebih dari 1, return false
    if ((leftHeight - rightHeight >= 2) || (rightHeight - leftHeight >= 2))
      return false;
    // 8. Jika tidak, return l && r yang kita buat dan isi pada langkah 3 dan 4
    else
      return l && r;
  }

  public static void main(String args[]) {
    Height height = new Height();

    BalancedBinaryTree tree = new BalancedBinaryTree();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);

    if (tree.checkHeightBalance(tree.root, height))
      System.out.println("The tree is balanced");
    else
      System.out.println("The tree is not balanced");
  }
}