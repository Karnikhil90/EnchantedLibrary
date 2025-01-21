package inventory;

import java.util.Map;

public class Book {
    private String title, author, id, price;
    private int quantity;

    public Book(String title, String author, String price, String id, int quantity) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.id = id;
        this.quantity = quantity;
    }

    public Book(Map<String, String> book) {
        this.title = book.getOrDefault("title", null);
        this.author = book.getOrDefault("author", null);
        this.price = book.getOrDefault("price", null);
        this.id = book.getOrDefault("id", null);
        this.quantity = Integer.parseInt(book.getOrDefault("quantity", "0"));
    }

    public Map<String, String> toMap() {
        return Map.of("title", title, "author", author, "price", price, "id", id);
    }

    public String toString() {
        return toMap().toString();
    }

    public String getAuthor() {
        return author;
    }

    public String getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
