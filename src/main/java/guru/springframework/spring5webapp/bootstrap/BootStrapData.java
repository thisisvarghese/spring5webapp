package guru.springframework.spring5webapp.bootstrap;

//import guru.springframework.spring5webapp.domain.Address;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Evans","Eric");
        Book ddd=new Book("Domain Driven Desing","3123213");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod","Johnson");
        Book noEJB =  new Book("J2EE without EJB","23231213");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);


        //  Address vcaddres=new Address("245 Maarten Lutherweg","Amsterdam","Noord-Holland","1185AM");
        Publisher vcpublisher=new Publisher("VC publisher","Maarten Lutherweg","Amstelveen","Noord","1185AM");

        ddd.setPublisher(vcpublisher);
        vcpublisher.getBooks().add(ddd);
        publisherRepository.save(vcpublisher);
        noEJB.setPublisher(vcpublisher);
        vcpublisher.getBooks().add(noEJB);
        bookRepository.save(noEJB);
        publisherRepository.save(vcpublisher);









        System.out.println("Started in Bootstrap");
        System.out.println("Number Of Books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());

        System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println("Publisher vxpublisher number of books: " + vcpublisher.getBooks().size());




    }








}
