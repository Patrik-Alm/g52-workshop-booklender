package io.github.patrikalm;


import java.lang.reflect.Array;
import java.util.Arrays;

public class Person {

    private static int sequencer;
    private int id = 1000;
    private String firstName;
    private String lastName;
    private String name;
    private Book[] lendedBooks = new Book[0];


    public Person(String firstName, String lastName) {

        this.id = getNextId();
        this.firstName = firstName;
        this.lastName = lastName;


    }

    public String getPersonInformation() {

        return firstName + " " + lastName;
    }


    private int getNextId() {

        return id + sequencer++;

    }

    public void loanBook(Book book) {

        if (book.isAvailable()) {

            Book[] localLendedBooks = new Book[lendedBooks.length + 1];
            lendedBooks = Arrays.copyOf(lendedBooks, localLendedBooks.length);
            lendedBooks[lendedBooks.length - 1] = book;


            book.setBorrower(this);

            book.switchAvailable();

            System.out.println("You have now lent the book.");

        } else {

            System.out.println("The book is not available");
        }

    }

    public void returnBook(Book book) {

        //take book away from array

        int counter = 0;

        if (lendedBooks.length > 1) {

            Book[] localLendedBooks = new Book[lendedBooks.length - 1];

            for (int i = 0;
                 i < lendedBooks.length;
                 i++) {

                if (book == lendedBooks[i]) {

                    for (int j = 0;
                         j < lendedBooks.length;
                         j++) {

                        if (book == lendedBooks[j]) {

                            continue;

                        } else {
                            localLendedBooks[counter] = lendedBooks[j];
                            ++counter;
                        }
                    }
                }
            }
            lendedBooks = Arrays.copyOf(localLendedBooks, localLendedBooks.length);
        } else {

            lendedBooks = new Book[0];
        }


        book.removeBorrower(book);
        book.switchAvailable();

        System.out.println("You have now returned the book.");

    }

    public String getPersonLendingInformation() {

        StringBuilder sb = new StringBuilder();

        sb.append(System.lineSeparator());
        sb.append(firstName);
        sb.append(" ");
        sb.append(lastName);
        sb.append(" ");
        sb.append("has borrowed ");
        if (lendedBooks.length == 0) {
            sb.append("no books.");
            return sb.toString();
        }

        sb.append(lendedBooks.length);
        sb.append(" books");
        sb.append(System.lineSeparator());

        sb.append("Following books are lended: ");

        for (int i = 0; ;i++) {
            sb.append(lendedBooks[i].getBookInformation());
            if (i == lendedBooks.length-1) {
                return sb.append(".").toString();
            }
            sb.append(", ");
        }

    }


}
