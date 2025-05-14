package Library;

public class Book {

    private int bookid;

    public String getAuthor() {
        return author;
    }
    public String getName() {
        return name;
    }

    private String author;
    private String name;
    private int edition;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private int count;

    public  Book(int bookid, String author, String name,int edition,int count){
        this.bookid = bookid;
        this.author = author;
        this.name = name;
        this.edition =  edition;
        this.count = count;
    }
    @Override
    public String toString(){
        return "=====================\nBookID = "+ this.bookid + "\nLibrary.Book Name = " + this.name + "\nLibrary.Book Author = "+ this.author+"\nEdition = "+this.edition+"\nLibrary.Book Count = "+this.count + "\n==========================";
    }

}
