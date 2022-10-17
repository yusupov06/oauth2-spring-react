package uz.md.oauth2app.exceptions;

/**
 * Me: muhammadqodir
 * Project: oaut2-spring-react/IntelliJ IDEA
 * Date:Mon 17/10/22 22:43
 */
public class BadRequestException extends RuntimeException {
    public BadRequestException(String error) {
        super(error);
    }
}
