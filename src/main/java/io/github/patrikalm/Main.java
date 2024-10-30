package io.github.patrikalm;



public class Main {
    public static void main(String[] args) {



        Book book1 = new Book("Gläntan", "Maria Gripe");
        Book book2 = new Book("Sagan", "John Tolkien");
        Book book3 = new Book("Agenten", "Jan Guillo");
        Book book4 = new Book("Vem", "Arne Glad");
        Book book5 = new Book("Skalbaggen", "Maria Gripe");

        Person person1 = new Person("Johan", "Augustsson");
        Person person2 = new Person("Trevor", "Roberts");
        Person person3 = new Person("Ludvig", "Modig");


        person1.loanBook(book1);
        System.out.println(person1.getPersonLendingInformation());
        System.out.println(book3.getBookDetailInformation());
        person1.returnBook(book1);
        System.out.println(person1.getPersonLendingInformation());
        person1.loanBook(book2);
        person2.loanBook(book2);
        person3.loanBook(book1);
        person1.returnBook(book2);
        person2.loanBook(book2);



    }
}