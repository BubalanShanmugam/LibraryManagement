package Library;

import java.util.ArrayList;
import java.util.HashMap;

public class LibraryManagementSystem {

    private static ArrayList<User> userlist = new ArrayList<>();
    private static HashMap<Integer, Book> bookmap = new HashMap<>();

    public static ArrayList<User> getUserlist() {
        return userlist;
    }
    public static HashMap<Integer, Book> getBookmap() {
        return bookmap;
    }
}
