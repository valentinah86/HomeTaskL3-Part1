package CustomErrors;

public class ApplicationErrors extends Exception {


    public ApplicationErrors(String message) {
        super(message);
    }

    public ApplicationErrors(String message, Throwable cause) {
        super(message, cause);
    }


}
