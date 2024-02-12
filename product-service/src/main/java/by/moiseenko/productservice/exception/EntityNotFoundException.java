package by.moiseenko.productservice.exception;

/*
    @author Ilya Moiseenko on 12.02.24
*/
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String message) {
        super(message);
    }
}
