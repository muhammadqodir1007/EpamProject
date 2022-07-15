package entity;

public class Complain {

    int id,user_id,publisher_id;
    String message;


    public Complain(int id, int user_id, int publisher_id, String message) {
        this.id = id;
        this.user_id = user_id;
        this.publisher_id = publisher_id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Complain() {
    }
}
