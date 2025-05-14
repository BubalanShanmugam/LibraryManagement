package Library;

public class User {

    public int getId() {
        return id;
    }

    public int getPass() {
        return pass;
    }

    int id;
    int pass;

    User(int id, int pass)
    {
        this.id=id;
        this.pass=pass;
    }


    @Override

    public String toString(){
        return "Id :" + this.id + "\nPass :" + this.pass ;
    }
}
