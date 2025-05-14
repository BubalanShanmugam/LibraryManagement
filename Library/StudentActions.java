package Library;

import java.util.Scanner;

public class StudentActions {

    public static void retrnbook(Scanner sc) {
        System.out.println("Enter id: ");
        int bookid = Integer.parseInt(sc.nextLine());

        if (LibraryManagementSystem.getBookmap().containsKey(bookid)) {
            for (var i : LibraryManagementSystem.getBookmap().keySet()) {
                if (i == bookid) {
                    int n = LibraryManagementSystem.getBookmap().get(i).getCount();
                    LibraryManagementSystem.getBookmap().get(i).setCount(n + 1);

                }
            }
        }
    }

    public static void borrowbook(Scanner sc,Student student){
        System.out.println("Enter the book id to borrow:");
        int bookid = Integer.parseInt(sc.nextLine());


        if(LibraryManagementSystem.getBookmap().containsKey(bookid)){
            LibraryManagementSystem.getBookmap().get(bookid).setCount(LibraryManagementSystem.getBookmap().get(bookid).getCount()-1);
            student.getBorrowedbook().add(LibraryManagementSystem.getBookmap().get(bookid).getName());
            System.out.println("Books borrowed successfully !");
        }
        else{
            System.out.println("No books available as this bookid");
        }
    }

    public static void downloadbooks(Scanner sc) {
        System.out.println("Enter book id to download:(only Ebooks)");
        int id = Integer.parseInt(sc.nextLine());
        if (DigitalLibrary.getEbookmap().containsKey(id)) {
            System.out.println("Do you want to download ?(Y/N)");
            String s = sc.nextLine();

            if (s.equalsIgnoreCase("Y")) {
                System.out.println("Library.Book was Downloaded Successfully !");
            } else {
                System.out.println("Download cancelled !");
            }
        }
    }

    public static Student studntlogin(Scanner sc) {
        System.out.println("Enter id: ");
        int id = Integer.parseInt(sc.nextLine());
        boolean login = true;
        for (var i : LibraryManagementSystem.getUserlist()) {
            if (i instanceof Student) {
                if (i.getId() == id) {
                    System.out.println("Enter pass: ");
                    int pass = Integer.parseInt(sc.nextLine());
                    login = false;
                    if (i.getPass() == pass) {
                        System.out.println("Library.Student entered succesfully !");
                        return (Student) i;
                    }
                }
            }
        }
        if (!login) {
            System.out.println("No student found !");
        }
        return null;
    }

    public static void viewborrowedbooks(Student student) {
        for (var i : student.getBorrowedbook()) {
            System.out.println(i);
        }
    }
}


