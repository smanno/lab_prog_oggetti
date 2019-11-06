package api_OperatoreTelefonico;

import lombok.*;
import java.time.Duration;

@Getter @Setter
public class CallData {
    @Getter @Setter private String number;
    @Getter @Setter
    private Duration duration;
    @Getter @Setter
    private Boolean isReceived;

    /**
     * Builds a new CallData
     *
     * @param number     REQUIRE valid number
     * @param duration   REQUIRE not negative
     * @param isReceived true for incoming call
     */
    public CallData(String number, Duration duration, Boolean isReceived) {
        if (isValidPhoneNumber(number)) {
            this.number = number;
            this.duration = duration;
            this.isReceived = isReceived;
        } else {
            throw new InvalidCallDataParameter("Invalid Number");
        }
    }

    private boolean isValidPhoneNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    /**
     * returns TRUE is the call is received
     * @return whether the call is received or not
     */
    public Boolean isReceived() {
        return isReceived;
    }
}