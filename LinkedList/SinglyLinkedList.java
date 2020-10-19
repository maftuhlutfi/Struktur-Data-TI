/*
================================
Nama    : Muchamad Lutfi Maftuh
NIM     : 19537141023
Prodi   : Teknologi Informasi
Matkul	: Struktur Data
Materi	: Linked List
================================

Praktik membuat Single Linked List yang menyimpan data bertipe integer
*/

class SinglyLinkedList {
	// head dari linked list
	Node head;

	// static class node dari linked list
	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	// method untuk menampilkan node dalam linked list
	public void displayList() {
		Node n = head;

		while(n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}

		System.out.println("");
	}

	// method untuk mengecek apakah linked list kosong
	public boolean isEmpty() {
		// linked list kosong = true apabila head = null
		if (head == null) {
			return true;
		} else {
			return false;
		}
	}

	// method untuk menambah node di bagian awal linked list
	public void addFirst(int data) {
		// 1. Buat node baru untuk menyimpan data yang akan ditambahkan
		Node newNode = new Node(data);
		// 2. Isi variabel next pada node baru dengan head
		newNode.next = head;
		// 3. Isi node head dengan node baru
		head = newNode;
	}

	// method untuk menambah node di bagian akhir linked list
	public void addLast(int data) {
		// 1. Buat node baru untuk menyimpan data yang akan ditambahkan
		Node newNode = new Node(data);
		// 2. Jika head masih null, isi head dengan node baru (RETURN)
		if (head == null) {
			head = newNode;
			return;
		}
		// 3. Cari node terakhir dengan while loop dan isikan ke variabel lastNode
		Node lastNode = head;
		while(lastNode.next != null) {
			lastNode = lastNode.next;
		}
		// 4. Isi variabel next pada last node dengan node baru
		lastNode.next = newNode;
	}

	// method untuk menambah node di posisi sebelum node dengan data pada parameter
	public void addBefore(int data, int dataBaru) {
		// 1. Buat node baru untuk menyimpan dataBaru yang akan ditambahkan 
		Node newNode = new Node(dataBaru);
		// 2. Jika node dengan data pada parameter adalah head maka panggil addFirst()
		if (head.data == data) {
			addFirst(dataBaru);
		}
		// 3. Cari node sebelum node dengan data pada parameter
		Node prevNode = head;
		while(prevNode != null) {
			if (prevNode.next.data == data) {
				break;
			}
			prevNode = prevNode.next;
		}
		// 4. Isi variabel next pada node baru dengan variabel next pada node sebelum node dengan data pada parameter
		newNode.next = prevNode.next;
		// 5. Isi variabel next pada node sebelum node dengan data pada parameter dengan node baru
		prevNode.next = newNode;
	}

	// method untuk menambah node di posisi setelah node dengan data pada parameter
	public void addAfter(int data, int dataBaru) {
		// 1. Buat node baru untuk menyimpan dataBaru yang akan ditambahkan
		Node newNode = new Node(dataBaru);
		// 2. Cari node dengan data pada parameter
		Node prevNode = head;
		while(prevNode != null) {
			if (prevNode.data == data) {
				break;
			}
			prevNode = prevNode.next;
		}
		// 3. Isi variabel next pada node baru dengan variabel next pada node dengan data pada parameter
		newNode.next = prevNode.next;
		// 4. Isi variabel next pada node dengan data pada parameter dengan node baru
		prevNode.next = newNode;
	}

	// method untuk menghapus data pertama pada linked list
	public void removeFirst() {
		// 1. Isi node head dengan node setelahnya
		head = head.next;
	}

	// method untuk menghapus data terakhir pada linked list
	public void removeLast() {
		// 1. Cari node sebelum node terakhir
		Node nodeBeforeLast = head;
		while(nodeBeforeLast.next.next != null) {
			nodeBeforeLast = nodeBeforeLast.next;
		}
		// 2. Isi variabel next pada node sebelum node terakhir dengan null
		nodeBeforeLast.next = null;
	}

	// method untuk menghapus node dengan data yang diinginkan
	public void remove(int data) {
		// 1. Jika data pada node head = data parameter, panggil removeFirst()
		if (head.data == data) {
			removeFirst();
			return;
		}
		// 2. Cari node sebelum node yang akan dihapus
		Node prevNode = head;
		while(prevNode.next != null) {
			if (prevNode.next.data == data) {
				break;
			}
			prevNode = prevNode.next;
		}
		// 3. Isi variabel next pada node sebelum node yang akan dihapus dengan node setelah node yang akan dihapus
		prevNode.next = prevNode.next.next;
	}

	// method untuk menghapus semua node
	public void removeAll() {
		// 1. Isi node head dengan null
		head = null;
	}

	public static void main(String[] args) {
		// Membuat object SinglyLinkedList
		SinglyLinkedList sLL = new SinglyLinkedList();

		// Cek method isEmpty()
		System.out.println("Cek method isEmpty: " + sLL.isEmpty());

		// Memasukkan beberapa data ke sLL
		sLL.head = new Node(80);
		System.out.println("sLL.head.data: " + sLL.head.data + " | sLL.head.next:" + sLL.head.next);

		Node n2 = new Node(65);
		System.out.println("n2.data: " + n2.data + " | n2.next:" + n2.next);

		Node n3 = new Node(90);
		System.out.println("n3.data: " + n3.data + " | n3.next:" + n3.next);

		Node n4 = new Node(70);
		System.out.println("n4.data: " + n4.data + " | n4.next:" + n4.next);

		sLL.head.next = n2;
		System.out.println("sLL.head.data: " + sLL.head.data + " | sLL.head.next:" + sLL.head.next);

		n2.next = n3;
		System.out.println("n2.data: " + n2.data + " | n2.next:" + n2.next);

		n3.next = n4;
		System.out.println("n3.data: " + n3.data + " | n3.next:" + n3.next);

		System.out.println("n4.data: " + n4.data + " | n4.next:" + n4.next);
		// Selesai memasukkan beberapo data ke sLL
		// Tampilkan isi linked list
		System.out.println("Cek method isEmpty: " + sLL.isEmpty());
		sLL.displayList();

		// Cek method addFirst
		sLL.addFirst(70);
		System.out.print("\nCek method addFirst(70): ");
		sLL.displayList();

		// Cek method addLast
		sLL.addLast(80);
		System.out.print("Cek method addLast(80): ");
		sLL.displayList();

		// Cek method addBefore
		sLL.addBefore(65, 30);
		System.out.print("Cek method addBefore(65, 30): ");
		sLL.displayList();

		// Cek method addAfter
		sLL.addAfter(30, 35);
		System.out.print("Cek method addAfter(30, 35): ");
		sLL.displayList();

		// Cek method removeFirst
		sLL.removeFirst();
		System.out.print("Cek method removeFirst: ");
		sLL.displayList();

		// Cek method removeLast
		sLL.removeLast();
		System.out.print("Cek method removeLast: ");
		sLL.displayList();

		// Cek method remove
		sLL.remove(30);
		System.out.print("Cek method remove(30): ");
		sLL.displayList();

		// Cek method removeAll
		sLL.removeAll();
		System.out.println("Cek method removeAll, isEmpty: " + sLL.isEmpty());
	}
}

/*
=========
HASIL RUN
=========
Cek method isEmpty: true
sLL.head.data: 80 | sLL.head.next:null
n2.data: 65 | n2.next:null
n3.data: 90 | n3.next:null
n4.data: 70 | n4.next:null
sLL.head.data: 80 | sLL.head.next:SinglyLinkedList$Node@53d8d10a
n2.data: 65 | n2.next:SinglyLinkedList$Node@e9e54c2
n3.data: 90 | n3.next:SinglyLinkedList$Node@65ab7765
n4.data: 70 | n4.next:null
Cek method isEmpty: false
80 65 90 70 

Cek method addFirst(70): 70 80 65 90 70 
Cek method addLast(80): 70 80 65 90 70 80 
Cek method addBefore(65, 30): 70 80 30 65 90 70 80 
Cek method addAfter(30, 35): 70 80 30 35 65 90 70 80 
Cek method removeFirst: 80 30 35 65 90 70 80 
Cek method removeLast: 80 30 35 65 90 70 
Cek method remove(30): 80 35 65 90 70 
Cek method removeAll, isEmpty: true
*/