package homework1;

public class Book {
	private int id;
    private int status; //ºô¸®¸é 1
    private String title;
    private String author;

    public Book(){
    	id=0;
    	status=1;
    	title=null;
    	author=null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
