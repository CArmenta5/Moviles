package mx.itesm.activity_14;

public class UserModel {
    private int id;
    private String name;
    private String hobby;


    //contructors
    public UserModel(int id, String name, String hobby){
        this.id = id;
        this.name = name;
        this.hobby = hobby;

    }
    public UserModel(){

    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }

    //toString is necesary for printing the contes of a class object

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}