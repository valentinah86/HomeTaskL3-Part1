package CustomErrors;

import java.io.IOException;
// catch incorrect count of stones in necklace
public class IncorrectCountOfStones extends IOException {
    public IncorrectCountOfStones (String message) {
        super(message);
    }
}
