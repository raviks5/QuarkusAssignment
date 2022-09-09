package com.ibm;

import com.ibm.model.Book;
import com.ibm.service.LibraryService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/books")
public class LibraryResource {

    @Inject
    LibraryService libraryService;


    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBooks() {

        return libraryService.getAllBooks();
    }

    @GET
    @Path("/filterbooks")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBooks(@QueryParam("category") String category, @QueryParam("language") String language) {

        return libraryService.getFilteredBooks(category, language);
    }

    @GET
    @Path("/isbn/{isbn}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBookByIsbn(@PathParam("isbn") String isbn) {
        Book book = libraryService.getBookByIsbn(isbn);
        return Response
                .status(Response.Status.OK)
                .entity(book)
                .build();

    }

    @GET
    @Path("/author/{author}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBookByAuthor(@PathParam("author") String author) {
        List<Book> bookBySameAuthor = libraryService.getBookByAuthor(author);

        return Response
                .status(Response.Status.OK)
                .entity(bookBySameAuthor)
                .build();
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveBook(Book book) {
        libraryService.addBook(book);
        return Response
                .status(Response.Status.CREATED)
                .entity(book)
                .build();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBook(Book book) {
        libraryService.updateBook(book);
        return Response
                .status(Response.Status.OK)
                .entity(book)
                .build();
    }

    @DELETE
    @Path("/delete/{isbn}")
    public Response deleteBook(@PathParam("isbn") String isbn) {
        libraryService.deleteBook(isbn);
        return Response
                .status(Response.Status.GONE)
                .build();
    }
}
