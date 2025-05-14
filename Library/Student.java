package Library;

import java.util.ArrayList;

public class Student extends User {
    public ArrayList<String> getBorrowedbook() {
        return borrowedbook;
    }

    private ArrayList<String> borrowedbook ;

        public Student(int id, int pass){
            super(id,pass);
            borrowedbook = new ArrayList<>();
        }
    }
