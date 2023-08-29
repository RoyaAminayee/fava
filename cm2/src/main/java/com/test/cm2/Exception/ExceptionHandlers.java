package com.test.cm2.Exception;

public class ExceptionHandlers {

    public static class EntityNotFoundException extends RuntimeException {
        public EntityNotFoundException(String message) {
            super(message);
        }
    }

    public static class RelatedEntityError extends RuntimeException{
        public RelatedEntityError(String message) {
            super(message);
        }
    }

    public static class DuplicateError extends RuntimeException{
        public DuplicateError(String message) {
            super(message);
        }
    }
}
