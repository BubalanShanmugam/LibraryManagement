package Library;

import java.util.HashMap;

public class DigitalLibrary extends LibraryManagementSystem {
    private static HashMap<Integer, Ebook> ebookmap =  new HashMap<>();
    public static HashMap<Integer, Ebook> getEbookmap(){
        return ebookmap;
    }


}
