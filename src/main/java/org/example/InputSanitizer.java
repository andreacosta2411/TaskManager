package org.example;

public final class InputSanitizer {

    private InputSanitizer() {}

    public static Result<Integer> parseInt(String raw, String fieldName) {
        if (raw == null) {
            return Result.fail(fieldName + " mancante.", "raw=null");
        }

        String s = raw.trim();
        if (s.isEmpty()) {
            return Result.fail(fieldName + " vuoto.", "raw is empty");
        }

        try {
            return Result.ok(Integer.parseInt(s));
        } catch (NumberFormatException ex) {
            return Result.fail(fieldName + " non valido. Inserisci un numero.", "NumberFormatException: " + ex.getMessage());
        }
    }

    public static Result<String> nonEmpty(String raw, String fieldName) {
        if (raw == null) {
            return Result.fail(fieldName + " mancante.", "raw=null");
        }
        String s = raw.trim();
        if (s.isEmpty()) {
            return Result.fail(fieldName + " vuoto.", "raw is empty");
        }
        return Result.ok(s);
    }
}
