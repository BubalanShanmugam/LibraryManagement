package Library;

public class Ebook{
    private int bookid;
    private String author;
    private String name;
    private int edition;
    public  Ebook(int bookid, String author, String name,int edition){
        this.bookid = bookid;
        this.author = author;
        this.name = name;
        this.edition =  edition;
    }
    @Override
    public String toString(){
        return "=====================\nBookID = "+ this.bookid + "\nLibrary.Book Name = " + this.name + "\nLibrary.Book Author = "+ this.author+"\nEdition = "+this.edition+ "\n==========================";
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }
}
