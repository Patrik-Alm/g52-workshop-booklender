package io.github.patrikalm;


import com.sun.source.tree.ContinueTree;

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

            //adding the lended book using new local array and Arrays.copyOf to make space in the array
            /*if (lendedBooks == null) {
                Book[] localLendedBooks = new Book[1];
                localLendedBooks [0] = book;
            }
            else {*/
                Book[] localLendedBooks = new Book[lendedBooks.length + 1];
                lendedBooks = Arrays.copyOf(lendedBooks, localLendedBooks.length);
                lendedBooks[lendedBooks.length - 1] = book;


            book.setBorrower(this);

            book.switchAvailable(book);

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
        }
        else {

            lendedBooks = new Book[0];
        }


        book.removeBorrower(book);
        book.switchAvailable(book);

    }

    public String getPersonLendingInformation() {

        StringBuilder sb = new StringBuilder();

        sb.append(System.lineSeparator());
        sb.append(firstName);
        sb.append(" ");
        sb.append(lastName);
        sb.append(" ");
        sb.append("has borrowed ");
        sb.append(lendedBooks.length);
        sb.append(" books");
        sb.append(System.lineSeparator());

        if (lendedBooks.length != 0) {
            StringBuilder sc = new StringBuilder();
            sc.append("Following books are lended: ");
            sc.append(Arrays.toString(lendedBooks));
            sb= sb.append(sc);
        }
        
        return sb.toString();

    }


}
