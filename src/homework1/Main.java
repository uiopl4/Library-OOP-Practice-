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
			System.out.println("1. 로그인");
			System.out.println("2. 프로그램 종료");
			choice = scan.nextInt();

			if (choice == 1) {
				System.out.println("ID: ");
				id = scan.nextInt();
				System.out.println("NAME: ");
				name = scan.next();
				l = library.login(id, name);
				if (l == 1) {
					while (true) {
						System.out.println("메뉴를 선택해 주세요.");
						System.out.println("1. 도서 추가");
						System.out.println("2. 도서 제거");
						System.out.println("3. 도서 수정");
						System.out.println("4. 로그아웃");
						System.out.println("5. 프로그램 종료");
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
							System.out.println("수정하려는 도서의 정보를 입력해주세요.");
							System.out.println("book id: ");
							id = scan.nextInt();
							System.out.println("book title: ");
							title = scan.next();
							System.out.println("book author: ");
							author = scan.next();
							System.out.println("수정하려는 도서의 새로운 정보를 입력해주세요.");
							System.out.println("book id: ");
							adjustI = scan.nextInt();
							System.out.println("book title: ");
							adjustT = scan.next();
							System.out.println("book author: ");
							adjustA = scan.next();
							library.modifyBook(id, title, author, adjustI, adjustT, adjustA);

						} else if (choice == 4) {
							System.out.println("정상적으로 로그아웃 되었습니다.");
							break;
						} else if (choice == 5) {
							return;
						} else {

						}
					}

				} else if (l == 2) {
					while (true) {
						System.out.println("메뉴를 선택해 주세요.");
						System.out.println("1. 도서 대출");
						System.out.println("2. 도서 반납");
						System.out.println("3. 로그아웃");
						System.out.println("4. 프로그램 종료");
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
