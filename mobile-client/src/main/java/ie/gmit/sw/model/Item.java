package ie.gmit.sw.model;

public class Item {

    private String email;
    private String title;
    private String content;
    private String date;

    public Item() {
    }

    public Item(String email, String title, String content, String date) {
        this.email = email;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

