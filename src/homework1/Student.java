package homework1;
import java.util.*;

public class Student {
	private int id;
    private String name;
    private ArrayList<Book> borrowList=new ArrayList<Book>();
    private int numb;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumb() {
        return numb;
    }

    public void setNumb(int numb) {
        this.numb = numb;
    }

    public ArrayList<Book> getBorrowList() {
        return borrowList;
    }

    public void setBorrowList(Book book) {
        borrowList.add(book);
    }

}
