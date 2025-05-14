package Library;

import java.util.Scanner;

public class LibraryManagementSystemActions {

    public static void start(Scanner sc){
        LibraryManagementSystem.getBookmap().put(1,new Book(1,"author","java",1,1));
        LibraryManagementSystem.getUserlist().add(new Admin(1,1));
        LibraryManagementSystem.getUserlist().add(new Student(2,2));

        x:while(true){
            System.out.println("==================\n1.Library.Admin Login \n2.Library.Student Login \n 3.exit");
            System.out.println("Enter enter your choice : ");
            int choice = Integer.parseInt(sc.nextLine());

            switch(choice){
                case 1:
                    Admin admin = AdminActions.adminlogin(sc);
                    if(admin !=null) {
                        LibraryManagementSystemActions.adminOperations(sc);
                    }
                    break;
                case 2:
                    Student student = StudentActions.studntlogin(sc);
                    if(student!=null){
                        LibraryManagementSystemActions.useroperation(sc,student);
                    }
                    break ;
                case 3:
                    System.out.println("Exiting !");
                    break x;
            }
        }
    }

    private static void useroperation(Scanner sc, Student student) {
        x:while(true) {
            System.out.println("==================\n1.Borrow \n2.Return \n3.Download \n4.View Borrowed Books\n5.exit");
            System.out.println("Enter enter your choice : ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice){
                case 1:
                    StudentActions.borrowbook(sc,student);
                    break ;
                case 2:
                    StudentActions.retrnbook(sc);
                    break ;
                case 3:
                    StudentActions.downloadbooks(sc);
                    break ;
                case 4:
                    StudentActions.viewborrowedbooks(student);
                    break ;
                case 5:
                    System.out.println("Exiting the Library.Student!");
                    break x;
            }
        }
    }

    private static void adminOperations(Scanner sc) {
        x:while(true) {
            System.out.println(" 1.add book \n 2.remove book \n 3.distribute book \n 4.view book \n 5.search book " + "\n 6.add user \n 7. deleteuser \n 8.viewusers" + "\n 9.exit");
            System.out.println("Enter enter your choice : ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    AdminActions.addbook(sc);
                    break;
                case 2:
                    AdminActions.removebook(sc);
                    break;
                case 3:
                    AdminActions.distributebook(sc);
                    break;
                case 4:
                    AdminActions.viewbooks();
                    break;
                case 5:
                        System.out.println("Search by ?\n1.id \n2.name \n3.author");
                        int ch = Integer.parseInt(sc.nextLine());
                        if (ch == 1) {
                            System.out.println("Enter the id :");
                            int bkid = Integer.parseInt(sc.nextLine());
                            AdminActions.search(bkid,sc);
                        } else if (ch == 2) {
                            AdminActions.search(sc);
                        } else if (ch == 3) {
                            System.out.println("Enter the author :");
                            String bkauthor = sc.nextLine();
                            AdminActions.search(bkauthor,sc);
                        }
                    break;
                case 6:
                    AdminActions.adduser(sc);
                    break ;
                case 7:
                    AdminActions.deleteuser(sc);
                    break;
                case 8:
                    AdminActions.viewusers();
                    break ;
                case 9:
                    System.out.println("Exiting the admin !");
                    break x;
            }
        }
    }
}
