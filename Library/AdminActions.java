package Library;

import java.util.Scanner;

public class AdminActions {
    public static Admin adminlogin(Scanner sc){
        System.out.println("Enter id: ");
        int id = Integer.parseInt(sc.nextLine());
        boolean login = false;
        for( var i : LibraryManagementSystem.getUserlist()) {
            if (i instanceof Admin) {
                if (i.getId() == id) {
                    System.out.println("Enter pass: ");
                    int pass = Integer.parseInt(sc.nextLine());
                    login = true;
                    if (i.getPass() == pass) {
                        System.out.println("Admin entered succesfully !");
                        return (Admin) i;
                    }
                }
            }
        }
        if(!login){
            System.out.println("NO admin found !");
        }
        return null;
    }

    public static void addbook(Scanner sc) {
        System.out.println("Enter how many books to add :");
        int nomofbooks = Integer.parseInt(sc.nextLine());
        for(int i=1;i<=nomofbooks;i++) {
            System.out.println("Enter bookid for book "+i+":");
            int bookid = Integer.parseInt(sc.nextLine());
            System.out.println("Enter bookname: ");
            String bookname = sc.nextLine();
            System.out.println("Enter author: ");
            String bookauthor = sc.nextLine();
            System.out.println("Enter edition: ");
            int edition = Integer.parseInt(sc.nextLine());
            System.out.println("Enter count: ");
            int count = Integer.parseInt(sc.nextLine());

            System.out.println("Where to add ? \n1.Library. \n2.Digital Library. \n.3.Both");
            int choice = Integer.parseInt(sc.nextLine());
            if(choice==1) {
                LibraryManagementSystem.getBookmap().put(bookid, new Book(bookid, bookname, bookauthor, edition, count));
                System.out.println("Library.Book Added in Library");
            }
            else if(choice==2){
                DigitalLibrary.getEbookmap().put(bookid, new Ebook(bookid, bookname, bookauthor, edition));
                System.out.println("Library.Book added to Digital Library.");
            }
            else if(choice==3){
                LibraryManagementSystem.getBookmap().put(bookid, new Book(bookid, bookname, bookauthor, edition, count));
                DigitalLibrary.getEbookmap().put(bookid, new Ebook(bookid, bookname, bookauthor, edition));
                System.out.println("Library.Book Added in both libraries");
            }
            else{
                System.out.println("This Library.Book doesn't added.....Please enter a valid Library choice.");
            }
        }
    }

    public static void removebook(Scanner sc) {
        System.out.println("Enter the book id to remove :");
        int bookid = Integer.parseInt(sc.nextLine());

        System.out.println("remove in Digital Library ? (Y/N)");
        String whichlib = sc.nextLine();
        if(whichlib.equalsIgnoreCase("n")) {
            if (LibraryManagementSystem.getBookmap().containsKey(bookid)) {
                        LibraryManagementSystem.getBookmap().remove(bookid);
                        System.out.println("Library.Book was successfully removed !");
            } else{
                System.out.println("No books found !");
            }
        }

        else {
            if(DigitalLibrary.getEbookmap().containsKey(bookid)){
                        DigitalLibrary.getEbookmap().remove(bookid);
                        System.out.println("Library.Book was removed successfully !");
            } else {
                System.out.println("No ebooks found !");
            }
        }
    }

    public static void distributebook(Scanner sc) {
        System.out.println("Enter id: ");
        int bookid = Integer.parseInt(sc.nextLine());
        System.out.println("Enter no of books to distribute: ");
        int noofbooks = Integer.parseInt(sc.nextLine());


        if(LibraryManagementSystem.getBookmap().containsKey(bookid)){
            for(var i : LibraryManagementSystem.getBookmap().keySet()){
                if(i == bookid && LibraryManagementSystem.getBookmap().get(i).getCount()>=noofbooks){
                    LibraryManagementSystem.getBookmap().get(i).setCount(LibraryManagementSystem.getBookmap().get(i).getCount()-noofbooks);
                    System.out.println("After distributing the books :");
                    if(LibraryManagementSystem.getBookmap().get(i).getCount() <=0){
                        System.out.println("This book was not available now!");
                    }else {
                        System.out.println(LibraryManagementSystem.getBookmap().get(i));
                    }
                }
                else{
                    System.out.println("Exceeding the no. of available books ");
                }
            }
        }
        else{
            System.out.println("No books available as entered bookid");
        }

    }

    public static void viewbooks() {
        System.out.println("Books in Library");
        if(!LibraryManagementSystem.getBookmap().isEmpty()) {
            for (var i : LibraryManagementSystem.getBookmap().entrySet()) {
                System.out.println(i);
            }
        }
        else{
            System.out.println("No books available !");
        }

        System.out.println("Books in Library.DigitalLibrary");
        if(!DigitalLibrary.getEbookmap().isEmpty()) {
            for (var i : DigitalLibrary.getEbookmap().entrySet()) {
                System.out.println(i);
            }
        }
        else{
            System.out.println("No Ebooks available !");
        }
    }


    public static void search( int id,Scanner sc ) {
        System.out.println("Do you want to search the book in digital library ? (Y/N)");
        String choice = sc.nextLine();
        if(choice.equalsIgnoreCase("y")) {
            if (!DigitalLibrary.getEbookmap().isEmpty()) {
                for (var i : DigitalLibrary.getEbookmap().keySet()) {
                    if (i == id) {
                        System.out.println("Results using book id ");
                        System.out.println(DigitalLibrary.getEbookmap().get(i));
                    }
                }
            } else {
                System.out.println("No books available !");
            }
        }
        else if(choice.equalsIgnoreCase("n")) {
            if (!LibraryManagementSystem.getBookmap().isEmpty()) {
                for (var i : LibraryManagementSystem.getBookmap().keySet()) {
                    if (i == id) {
                        System.out.println("Results using book id ");
                        System.out.println(LibraryManagementSystem.getBookmap().get(i));
                    }
                }
            } else {
                System.out.println("No books available !");
            }
        }
    }


    public static void search(Scanner sc) {
        System.out.println("Do you want to add the book in digital library ? (Y/N)");
        String choice = sc.nextLine();
        if(choice.equalsIgnoreCase("y")) {
            System.out.println("Enter the name :");
            String bkname = sc.nextLine();
            if (!DigitalLibrary.getEbookmap().isEmpty()) {
                System.out.println("Results using book book name ");
                for (var i : DigitalLibrary.getEbookmap().keySet()) {
                    if (DigitalLibrary.getEbookmap().get(i).getName().equals(bkname)) {

                        System.out.println(DigitalLibrary.getEbookmap().get(i));
                    }
                }
            } else {
                System.out.println("No books available !");
            }
        }
        else {
            System.out.println("Enter the name :");
            String bkname = sc.nextLine();
            if (!LibraryManagementSystem.getBookmap().isEmpty()) {
                System.out.println("Results using book book name ");
                for (var i : LibraryManagementSystem.getBookmap().keySet()) {
                    if (LibraryManagementSystem.getBookmap().get(i).getName().equals(bkname)) {

                        System.out.println(LibraryManagementSystem.getBookmap().get(i));
                    }
                }
            }
            else {
                System.out.println("No books available !");
            }
        }
    }


    public static void search( String author,Scanner sc) {
        System.out.println("Do you want to add the book in digital library ? (Y/N)");
        String choice = sc.nextLine();
        if(choice.equalsIgnoreCase("y")) {
            if (!DigitalLibrary.getEbookmap().isEmpty()) {
                for (var i : DigitalLibrary.getEbookmap().keySet()) {
                    System.out.println("Results using book author ");
                    if (DigitalLibrary.getEbookmap().get(i).getAuthor().equals(author)) {

                        System.out.println(DigitalLibrary.getEbookmap().get(i));
                    }
                }
            } else {
                System.out.println("No books available !");
            }
        }
        else {
            if (!LibraryManagementSystem.getBookmap().isEmpty()) {
                for (var i : LibraryManagementSystem.getBookmap().keySet()) {
                    System.out.println("Results using book author ");
                    if (LibraryManagementSystem.getBookmap().get(i).getAuthor().equals(author)) {

                        System.out.println(LibraryManagementSystem.getBookmap().get(i));
                    }
                }
            } else {
                System.out.println("No books available !");
            }
        }
    }



    public static void adduser(Scanner sc){
        System.out.println("Enter your id :");
        int id = Integer.parseInt(sc.nextLine());
        boolean exist = false;
        for(var i : LibraryManagementSystem.getUserlist()){
            if(i instanceof Student){
                if(i.getId() == id){
                    System.out.println("Library.Student is already exist !");
                    exist = true;
                    break;
                }
            }
        }
        if(! exist)
        {
            System.out.println("Enter your pass :");
            int pass = Integer.parseInt(sc.nextLine());
            LibraryManagementSystem.getUserlist().add(new Student(id,pass));
        }

    }

    public static void deleteuser(Scanner sc ) {
        System.out.println("Enter your id :");
        int id = Integer.parseInt(sc.nextLine());

        if (LibraryManagementSystem.getUserlist().isEmpty()) {
            System.out.println("There is no user found(empty)");
            return;
        }
        for (var i : LibraryManagementSystem.getUserlist()) {
            if (i instanceof Student) {
                if (i.getId() == id) {
                    LibraryManagementSystem.getUserlist().remove(i);
                    break;
                }
            }
        }
    }

    public static void viewusers() {
        for( var i : LibraryManagementSystem.getUserlist()){
            if(i instanceof Student)
            {
                System.out.println(i);
            }
        }
    }


}
