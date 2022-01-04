package pl.tostrowski.SpringForumApp.exception;

public class PostNotFoundException extends RuntimeException{
    public PostNotFoundException(long id) {
        super("Could not find post: " + id);
    }
}
