public class GenericDoublyLinkedList<E> {
	// Membuat node head
	Node head;
	// Menambahkan variable size
	int size = 0;

	// Constructor generic doubly linked list
	GenericDoublyLinkedList() {
		head = null;
	}

	GenericDoublyLinkedList(E data) {
		head = new Node(data);
		size = 1;
	}

	class Node {
		E data; // variabel untuk menyimpan data bertipe generic E
		Node prev; // variabel untuk menyimpan alamat node sebelumnya
		Node next; // variabel untuk menyimpan alamat node setelahnya

		// Constructor dengan parameter d bertipe generic E
		Node(E d) {
			data = d; // variabel data pada node diisi dengan d
			next = null; // next diisi dengan null
			prev = null; // prev diisi dengan null
		}
	}

	public void displayList() {
		// 1. Cek apakah list kosong
		if (isEmpty()) {
			System.out.println("This list is empty.");
			return;
		}

		// 2. Jika tidak kosong, tampilkan semua detail linked list
		System.out.println("====================");
		System.out.println("Prev\tData\tNext");
		System.out.println("====================");
		for (Node n = head;n != null;n = n.next) {
		 	System.out.println((n.prev != null ? n.prev.data : "∅") + "\t\t" + n.data + "\t\t" + (n.next != null ? n.next.data : "∅"));
		}

		System.out.println("");
	}

	public boolean isEmpty() {
		// 1. Kembalikan nilai apakah head == null
		return head == null;
	}

	public void addFirst(E data) {
		// 1. Buat node baru
		Node newNode = new Node(data);
		// 2. Isi next pada node baru dengan head
		newNode.next = head;
		// 3. Isi prev pada head dengan node baru
		head.prev = newNode;
		// 4. Head diisi dengan node baru
		head = newNode;

		// 5. Size ditambah satu
		size++;
	}

	public void addLast(E data) {
		// 1. Membuat node baru dengan data
		Node newNode = new Node(data);
		// 2. Mencari node terakhir
		Node lastNode = head;
		while(lastNode.next != null) {
			// 3. lastNode diisikan node selanjutnya
			lastNode = lastNode.next;
		}
		// 4. Next pada node terakhir diisi node baru
		lastNode.next = newNode;
		// 5. Prev pada node baru diisi node terakhir
		newNode.prev = lastNode;

		size++;
	}

	public void addBefore(E data, E newData) {
		// 1. Misal data yang dicari head, panggil addFirst return
		if (head.data == data) {
			addFirst(newData);
			return;
		}

		// 2. Buat node baru dengan data yang akan ditambahkan
		Node newNode = new Node(newData);

		// 3. Cari node yang datanya sama dengan data
		Node theNode = head;
		while(theNode != null) {
			// 4. Jika data dari theNode == data yang dicari, break
			if (theNode.data == data) {
				break;
			}
			// 5. Jika tidak, isi theNode dengan node setelahnya
			theNode = theNode.next;
		}

		// 6. Isi prev pada node baru dengan node sebelum theNode
		newNode.prev = theNode.prev;
		// 7. Isi next pada node baru dengan node setelah theNode
		newNode.next = theNode;
		// 8. Isi next pada node sebelum theNode dengan node baru
		theNode.prev.next = newNode;
		// 9. Isi prev pada theNode dengan node baru
		theNode.prev = newNode;

		size++;
	}

	public void addAfter(E data, E newData) {
		// 1. Cari node yang datanya sama dengan data
		Node theNode = head;
		while(theNode != null) {
			// 2. Jika data dari theNode == data yang dicari, break
			if (theNode.data == data) {
				break;
			}
			// 3. Jika tidak, isi theNode dengan node setelahnya
			theNode = theNode.next;
		}

		// 4. Cek apakah theNode adalah data terakhir, jika ya panggil addLast, return
		if (theNode.next == null) {
			addLast(newData);
			return;
		}

		// 5. Membuat node baru dengan data
		Node newNode = new Node(newData);
		// 6. Isi prev pada node baru dengan theNode
		newNode.prev = theNode;
		// 7. Isi next pada node baru dengan node setelah theNode
		newNode.next = theNode.next;
		// 8. Isi prev pada node setelah theNode dengan node baru
		theNode.next.prev = newNode;
		// 9. Isi next pada theNode dengan node baru
		theNode.next = newNode;

		size++;
	}

	public void removeFirst() {
		// 1. Isi head dengan node setelah head
		head = head.next;
		// 2. Isi prev pada head dengan null
		head.prev = null;

		size--;
	}

	public void removeLast() {
		// 1. Mencari node terakhir
		Node lastNode = head;
		while(lastNode.next != null) {
			lastNode = lastNode.next;
		}
		// 2. Isi next pada node sebelum node terakhir dengan null
		lastNode.prev.next = null;

		size--;
	}

	public void remove(E data) {
		// 1. Cari node yang datanya sama dengan data 
		Node theNode = head;
		while(theNode != null) {
			if (theNode.data == data) {
				break;
			}
			theNode = theNode.next;
		}

		// 2. Jika theNode adalah node pertama (head), panggil removeFirst()
		if (theNode.prev == null) {
			removeFirst();
			return;
		} 

		// 3. Jika theNode adalah node terakhir, panggil removeLast()
		if (theNode.next == null) {
			removeLast();
			return;
		}

		// 4. Membuat object prevNode untuk menyimpan alamat node sebelum theNode 
		Node prevNode = theNode.prev;
		// 5. Membuat object nextNode untuk menyimpan alamat node setelah theNode 
		Node nextNode = theNode.next;
		// 6. Isi next pada prevNode dengan nextNode
		prevNode.next = nextNode;
		// 7. Isi prev pada nextNode dengan prevNode
		nextNode.prev = prevNode;

		size--;
	}

	public void removeAll() {
		// 1. Isi head dengan null
		head = null;
		size = 0;
	}

	public Node getNode(int position) {
		int count = -1;
		Node theNode = head;
		while(theNode != null){
			count++;
			if (count == position) {
				break;
			}
			theNode = theNode.next;
		}
		return count != -1 ? theNode : null;
	}

	public void insertBeforeNode(Node n, E newData) {
		// 1. Misal node yang dicari adalah head, panggil addFirst
		if (head == n) {
			addFirst(newData);
			return;
		}

		// 2. Buat node baru dengan data yang akan ditambahkan
		Node newNode = new Node(newData);

		// 3. Cari node yang sama dengan Node n
		Node theNode = head;
		while(theNode != null) {
			// 4. Jika theNode == Node n, break
			if (theNode == n) {
				break;
			}
			// 5. Jika tidak, isi theNode dengan node setelahnya
			theNode = theNode.next;
		}

		// 6. Isi prev pada node baru dengan node sebelum theNode
		newNode.prev = theNode.prev;
		// 7. Isi next pada node baru dengan node setelah theNode
		newNode.next = theNode;
		// 8. Isi next pada node sebelum theNode dengan node baru
		theNode.prev.next = newNode;
		// 9. Isi prev pada theNode dengan node baru
		theNode.prev = newNode;

		size++;
	}

	public void insertAfterNode(Node n, E newData) {
		// 1. Cari node yang sama dengan Node n
		Node theNode = head;
		while(theNode != null) {
			// 2. Jika theNode == Node n, break
			if (theNode == n) {
				break;
			}
			// 3. Jika tidak, isi theNode dengan node setelahnya
			theNode = theNode.next;
		}

		// 4. Cek apakah theNode adalah node terakhir, jika ya panggil addLast, return
		if (theNode.next == null) {
			addLast(newData);
			return;
		}

		// 5. Membuat node baru dengan data
		Node newNode = new Node(newData);
		// 6. Isi prev pada node baru dengan theNode
		newNode.prev = theNode;
		// 7. Isi next pada node baru dengan node setelah theNode
		newNode.next = theNode.next;
		// 8. Isi prev pada node setelah theNode dengan node baru
		theNode.next.prev = newNode;
		// 9. Isi next pada theNode dengan node baru
		theNode.next = newNode;

		size++;
	}

	public void removeNodeInPos(int position) {
		// 1. Buat variabel count untuk mengidentifikasi urutan
		int count = 0;

		// 2. Mencari node di posisi yang diinginkan
		Node theNode = head;
		while(theNode != null) {
			// 3. Jika count == position, break
			if (count == position) {
				break;
			}
			theNode = theNode.next;
			count++;
		}

		// 4. Panggil remove dengan argument data dari theNode
		remove(theNode.data);

		size--;
	}

	public void removeAllExceptHead() {
		// 1. Isi next pada head dengan null
		head.next = null;
		size = 1;
	}

	public void removeAllBefore(Node n) {
		// 1. Buat variabel untuk menghitung jumlah node sebelum node yang dicari
		int count = 0;

		// 2. Mencari node yang dimaksud
		Node theNode = head;
		while(theNode != null) {
			count++;
			if (theNode == n) {
				break;
			}
			theNode = theNode.next;
		}

		// 3. Isi prev pada theNode dengan null
		theNode.prev = null;
		// 4. Isi head dengan theNode
		head = theNode;
		// 5. Size = size - count
		size -= count;
	}

	public void removeAllAfter(Node n) {
		// 1. Buat variabel untuk menghitung jumlah node sampai node yang dicari
		int count = 0;

		// 2. Cari node yang dimaksud
		Node theNode = head;
		while(theNode != null) {
			count++;
			if (theNode == n) {
				break;
			}
			theNode = theNode.next;
		}
		// 3. Isi next pada theNode dengan null
		theNode.next = null;
		// 4. Isi size dengan count
		size = count;
	}

	public void removeAllExcept(Node n) {
		// 1. Cari node yang dimaksud
		Node theNode = head;
		while(theNode != null) {
			if (theNode == n) {
				break;
			}
			theNode = theNode.next;
		}

		// 2. Isi next pada theNode dengan null
		theNode.next = null;
		// 3. Isi prev pada theNode dengan null
		theNode.prev = null;
		// 4. Isi head dengan theNode
		head = theNode;
		// 5. Size tinggal satu
		size = 1;
	}

	public int searchTotalMatch(E data) {
		// 1. Buat variabel count untuk menghitung total data yang sama
		int count = 0;
		// 2. Mencari node dengan data yang sama
		Node theNode = head;
		while(theNode != null) {
			// 3. Jika data dari theNode == data, count++
			if (theNode.data == data) {
				count++;
			}
			theNode = theNode.next;
		}
		return count;
	}

	public int getSize() {
		return size;
	}

	public static void main(String[] args) {
	 	GenericDoublyLinkedList<Integer> gDLL = new GenericDoublyLinkedList<>(12);

	 	gDLL.addFirst(5);
	 	gDLL.addLast(12);
	 	gDLL.addLast(12);
	 	/*gDLL.addBefore(5 , 10);
	 	gDLL.addAfter(32, 15);
	 	//gDLL.displayList();
	 	gDLL.removeFirst();
	 	gDLL.removeLast();*/
	 	//gDLL.remove(5);
	 	//gDLL.removeAll();
	 	//gDLL.insertAfterNode(gDLL.getNode(1), 15);
	 	/*gDLL.removeAllExcept(gDLL.getNode(3));
	 	gDLL.displayList();*/
	 	//System.out.println("Size: " + gDLL.size);

	 	/*GenericDoublyLinkedList<Character> gDLL1 = new GenericDoublyLinkedList<>('A');
	 	gDLL1.insertAfterNode(gDLL1.head, 'C');
	 	gDLL1.insertBeforeNode(gDLL1.head, '0');
	 	gDLL1.insertAfterNode(gDLL1.head.next, 'B');
	 	//gDLL1.addLast('A');
	 	//gDLL1.removeNodeInPos(1);
	 	//gDLL1.removeAllExceptHead();
	 	//gDLL1.removeAllBefore(gDLL1.head.next.next);
	 	//gDLL1.removeAllAfter(gDLL1.head.next);
	 	//gDLL1.removeAllExcept(gDLL1.head.next);
	 	gDLL1.displayList();
	 	System.out.println(gDLL.size);
	 	System.out.println(gDLL1.size);
	 	//System.out.println("Total match of 'A': " + gDLL1.searchTotalMatch('A'));*/
	} 
}