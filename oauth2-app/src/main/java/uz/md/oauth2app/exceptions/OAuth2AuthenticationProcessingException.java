package uz.md.oauth2app.exceptions;

public class OAuth2AuthenticationProcessingException extends RuntimeException {
    public OAuth2AuthenticationProcessingException(String error) {
        super(error);
    }
}
