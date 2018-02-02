package homework1;

import java.io.IOException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		int choice = 0;
		int l = 0;
		int id = 0, adjustI = 0;
		String name = null;
		String title = null, adjustT = null;
		String author, adjustA;
		Library library = new Library();
		Scanner scan = new Scanner(System.in);
		library.createBookDB();
		library.createUserDB();

		while (true) {
			System.out.println("1. �α���");
			System.out.println("2. ���α׷� ����");
			choice = scan.nextInt();

			if (choice == 1) {
				System.out.println("ID: ");
				id = scan.nextInt();
				System.out.println("NAME: ");
				name = scan.next();
				l = library.login(id, name);
				if (l == 1) {
					while (true) {
						System.out.println("�޴��� ������ �ּ���.");
						System.out.println("1. ���� �߰�");
						System.out.println("2. ���� ����");
						System.out.println("3. ���� ����");
						System.out.println("4. �α׾ƿ�");
						System.out.println("5. ���α׷� ����");
						choice = scan.nextInt();
						if (choice == 1) {
							System.out.println("book id: ");
							id = scan.nextInt();
							System.out.println("book title: ");
							title = scan.next();
							System.out.println("book author: ");
							author = scan.next();
							library.appendBook(id, title, author);

						} else if (choice == 2) {
							System.out.println("book id: ");
							id = scan.nextInt();
							System.out.println("book title: ");
							title = scan.next();
							System.out.println("book author: ");
							author = scan.next();
							library.deleteBook(id, title, author);
						} else if (choice == 3) {
							System.out.println("�����Ϸ��� ������ ������ �Է����ּ���.");
							System.out.println("book id: ");
							id = scan.nextInt();
							System.out.println("book title: ");
							title = scan.next();
							System.out.println("book author: ");
							author = scan.next();
							System.out.println("�����Ϸ��� ������ ���ο� ������ �Է����ּ���.");
							System.out.println("book id: ");
							adjustI = scan.nextInt();
							System.out.println("book title: ");
							adjustT = scan.next();
							System.out.println("book author: ");
							adjustA = scan.next();
							library.modifyBook(id, title, author, adjustI, adjustT, adjustA);

						} else if (choice == 4) {
							System.out.println("���������� �α׾ƿ� �Ǿ����ϴ�.");
							break;
						} else if (choice == 5) {
							return;
						} else {

						}
					}

				} else if (l == 2) {
					while (true) {
						System.out.println("�޴��� ������ �ּ���.");
						System.out.println("1. ���� ����");
						System.out.println("2. ���� �ݳ�");
						System.out.println("3. �α׾ƿ�");
						System.out.println("4. ���α׷� ����");
						choice = scan.nextInt();
						if (choice == 1) {
							System.out.println("book id: ");
							id = scan.nextInt();
							System.out.println("book title: ");
							title = scan.next();
							System.out.println("book author: ");
							author = scan.next();
							library.borrowBook(id, title, author);
						}

						if (choice == 2) {
							System.out.println("book id: ");
							id = scan.nextInt();
							System.out.println("book title: ");
							title = scan.next();
							System.out.println("book author: ");
							author = scan.next();
							library.returnBook(id, title, author);
						} else if (choice == 3) {
							break;

						} else if (choice == 4) {
							return;
						} else {

						}
					}
				}
			} else if (choice == 2) {
				return;
			}
		}
	}

}
