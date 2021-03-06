package milktea.json.parser;

import milktea.json.JSON;
import milktea.json.JSONException;

import java.nio.CharBuffer;

public interface Parser {

    static boolean skipWhitespaces(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            char c = buffer.get();
            if (!JSON.isWhitespace(c)) {
                buffer.position(buffer.position() - 1);
                return true;
            }
        }
        return false;
    }

    static RuntimeException newException(String message) {
        return new JSONException(message);
    }

}
