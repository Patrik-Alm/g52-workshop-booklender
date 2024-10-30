package io.github.patrikalm;

public class Book {

    private String id;
    private String title;
    private String author;
    private String borrower;
    private boolean available;


    public Book(String title, String author) {

        this.title = title;
        this.author = author;
        available = true;
        borrower = null;
    }

    public void setBorrower(Person person) {

        borrower = person.getPersonInformation();
    }

    public void removeBorrower(Book book) {

        borrower = null;
    }

    public void switchAvailable(Book book) {

        //This method just swithces from one state to another.
        //Can be a litte tricky but in this special case it works.

        if (book.available) {

            book.available = false;
        }

            book.available = true;

    }

    public boolean isAvailable() {

        return available;
    }

    public String getBookInformation() {

        return title + " by " + author;
    }

    public String getBookDetailInformation() {

        StringBuilder sb = new StringBuilder();

        sb.append(System.lineSeparator());
        sb.append("This book has the title ");
        sb.append(title + ".");
        sb.append(System.lineSeparator());
        sb.append("The book is written by ");
        sb.append(author + ".");
        sb.append(System.lineSeparator());

        return sb.toString();

    }

}
