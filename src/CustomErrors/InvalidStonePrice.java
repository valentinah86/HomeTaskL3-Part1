package CustomErrors;

import java.io.IOException;
// catch incorrect price which added by user

public class InvalidStonePrice extends IOException {
    public InvalidStonePrice(String message) {
        super(message);
    }

}
