package homework1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Library {
	 private ArrayList<Book> bookList=new ArrayList<Book>();
	    private ArrayList<Admin> adminList=new ArrayList<Admin>();
	    private ArrayList<Student> studentList=new ArrayList<Student>();

	    private int s;

	    public void createBookDB() throws IOException {
	        String inputPath = System.getProperty("user.dir") + "\\Book.txt";
	        BufferedReader br = new BufferedReader(new FileReader(inputPath));
	        String str = null;
	        while ((str = br.readLine()) != null) {
	            Book book = new Book();
	            String res[] = str.split("//");
	            book.setId(Integer.parseInt(res[0]));
	            book.setTitle(res[1]);
	            book.setAuthor(res[2]);
	            bookList.add(book);
	        }
	    }

	    public void createUserDB() throws IOException {
	        String inputPath = System.getProperty("user.dir") + "\\User.txt";
	        BufferedReader br = new BufferedReader(new FileReader(inputPath));
	        String str = null;

	        while ((str = br.readLine()) != null) {
	            String res[] = str.split("//");
	            if (res[2].equals("admin")) {
	                Admin admin = new Admin();
	                admin.setId(Integer.parseInt(res[0]));
	                admin.setName(res[1]);
	                adminList.add(admin);

	            } else if (res[2].equals("student")) {
	                Student student = new Student();
	                student.setId(Integer.parseInt(res[0]));
	                student.setName(res[1]);
	                studentList.add(student);
	            }
	        }
	    }

	    public int searchBook(int id, String title, String author) {
	        Book book;
	        for (int i = 0; i < bookList.size(); i++) {
	            book = bookList.get(i);
	            if (book.getId() == id) {
	                if (book.getTitle().equals(title))
	                    if (book.getAuthor().equals(author)) {
	                        return i;
	                    }
	            }
	        }

	        System.out.println("책을 찾을 수 없습니다.");
	        return -1;

	    }

	    public int login(int id, String name) {
	        boolean check = false;
	        Student sTemp;
	        Admin aTemp;

	        for (int i = 0; i < adminList.size(); i++) {
	            aTemp = adminList.get(i);
	            if (aTemp.getId() == id) {
	                if (aTemp.getName().equals(name)) {
	                    check = true;
	                    return 1;
	                }
	            }
	        }
	        if (check == false) {
	            for (int i = 0; i < studentList.size(); i++) {
	                sTemp = studentList.get(i);
	                if (sTemp.getId() == id) {
	                    if (sTemp.getName().equals(name)) {
	                        s = i;
	                        return 2;
	                    }
	                }
	            }
	        }
	        System.out.println("로그인 실패");
	        return 0;
	    }
	    public void appendBook(int id, String title, String author){
	        Book book=new Book();
	        for(int i=0;i<bookList.size();i++){
	            
	            if(bookList.get(i).getId()==id){
	                System.out.println("이미 있는 ID입니다.");
	                return;
	            }
	        }
	        book.setId(id);
	        book.setTitle(title);
	        book.setAuthor(author);
	        bookList.add(book);
	        System.out.println("정상적으로 추가되었습니다.");
	        return;

	    }

	    public void deleteBook(int id, String title, String author){
	        int remIdx;
	        remIdx=searchBook(id, title, author);
	        if(remIdx!=-1){
	            if(bookList.get(remIdx).getStatus()==0){
	                System.out.println("책이 대여중입니다.");
	            }
	            else if(bookList.get(remIdx).getStatus()==1){
	                bookList.remove(remIdx);
	                System.out.println("정상적으로 삭제되었습니다.");
	            }
	        }

	        return;
	    }

	    public void modifyBook(int id, String title, String author, int adI, String adT, String adA){
	        int remIdx;
	        Book book=new Book();
	        remIdx=searchBook(id, title, author);
	        if(remIdx!=-1){
	            if(bookList.get(remIdx).getStatus()==0){
	                System.out.println("책이 대여중입니다.");
	            }
	            else if(bookList.get(remIdx).getStatus()==1){
	                bookList.remove(remIdx);
	                for(int i=0;i<bookList.size();i++){
	    	            if(bookList.get(i).getId()==adI){
	    	                System.out.println("이미 있는 ID입니다.");
	    	                return;
	    	            }
	    	        }
	                book.setId(adI);
	    	        book.setTitle(adT);
	    	        book.setAuthor(adA);
	    	        bookList.add(book);
	                System.out.println("정상적으로 수정되었습니다.");
	            }
	        }
	        return;
	    }

	    public void borrowBook(int id, String title, String author){
	        int idx;
	        idx=searchBook(id, title, author);
	        Book book=new Book();

	        if(idx!=-1){
	            if(studentList.get(s).getNumb()<3){
	                if(bookList.get(idx).getStatus()==1) {
	                    bookList.get(idx).setStatus(0);
	                    book.setId(id);
	                    book.setTitle(title);
	                    book.setAuthor(author);
	                    studentList.get(s).setBorrowList(book);
	                    studentList.get(s).setNumb(studentList.get(s).getNumb()+1);
	                    System.out.println("정상적으로 대출되었습니다.");
	                }
	                else{
	                    System.out.println("이미 대여된 책입니다.");
	                }
	            }
	            else{
	                System.out.println("최대 대여 가능 권수는 3권입니다.");
	            }
	        }
	        return;

	    }

	    public void returnBook(int id, String title, String author){
	        int idx;
	        idx=searchBook(id, title, author);
	        Book book;
	        
	    
	        if(idx!=-1){
	        	if(studentList.get(s).getBorrowList().size()>0){
		        	for(int i=0;i<studentList.get(s).getBorrowList().size();i++){
		        		book=studentList.get(s).getBorrowList().get(i);
		        		if(book.getId()==id){
		        			if(book.getTitle().equals(title)){
		        				if(book.getAuthor().equals(author)){
		        					bookList.get(idx).setStatus(1);
		        					studentList.get(s).setNumb(studentList.get(s).getNumb()-1);
		        					studentList.get(s).getBorrowList().remove(i);
	 	                            System.out.println("정상적으로 반납되었습니다.");
	 	                            return;
		        				}
		        			}
		        		}
		        	}
		        }
	        	 else{
	         		System.out.println("책을 찾을 수 없습니다.");
	         		return;
	 	        }

	        }
	        
	    }


}
