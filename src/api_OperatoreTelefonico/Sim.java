package api_OperatoreTelefonico;

import lombok.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.time.Duration;

@Setter @Getter
class Sim {
    @NonNull private String number;
    @NonNull private Integer puk;
    private Double residual;
    private List<CallData> calls;
    private Date lastRechargeDate;
    @NonNull private Person owner;
    private Promotions activePromo;
    private Boolean isOriginal;

    // ECCEZIONE

    /**
     * Build a new SIM
     *
     * @param owner  the owner of the SIM. REQUIRE not null
     * @param number the new phone number
     * @param puk    the new puk
     */
    Sim(Person owner, String number, Integer puk) {
        this.owner = owner;
        this.number = number;
        this.puk = puk;
        this.lastRechargeDate = new Date();
        this.isOriginal = true;
    }

    /**
     * Build a ported SIM
     *
     * @param owner  the owner of the SIM. REQUIRE not null
     * @param oldSim the old sim data
     * @param puk    the new puk
     */
    Sim(Person owner, Sim oldSim, String number, Integer puk) {
        this.owner = owner;
        this.number = number;
        this.puk = puk;
        this.residual = oldSim.getResidual();
        this.lastRechargeDate = new Date();
        this.isOriginal = false;
    }

    /**
     * Add a new data of a previous call to the list
     *
     * @param data data of previous call. REQUIRE not null
     */
    void addCallData(CallData data) {
        calls.add(data);
    }

    /**
     * Do a recharge to the actual SIM
     *
     * @param amount the amount of the recharge REQUIRE not negative
     */
    void recharge(Double amount) {
        residual += amount;
    }

    /**
     * The SIM is active is last recharge was made during the last year
     *
     * @return true or false whether the sim is active or not
     */
    boolean isActive() {
        Date today = new Date();
        Calendar thisYear = Calendar.getInstance();
        thisYear.setTime(today);
        thisYear.add(Calendar.DAY_OF_YEAR, -1);
        Date oneYearAgo = thisYear.getTime();
        return ((this.lastRechargeDate).after(oneYearAgo));
    }

    /**
     * Returns whether the SIM is new or ported
     *
     * @return true if original, false if ported
     */
    boolean isOriginal() {
        return this.getIsOriginal();
    }

    // ECCEZIONE
    /**
     * Sets the new promo for the sim
     *
     * @param promo one of the 3 valid promo REQUIRE not null
     * @return true if a promo is actives
     */
    boolean activatePromo(Promotions promo) {
        this.setActivePromo(promo);
        this.residual -= promo.getCost();
        return this.getActivePromo() != null;
    }

    /**
     * Sets the active promo to null
     */
    void deactivatePromo() {
        this.setActivePromo(null);
    }

    /**
     * @return
     */
    List<CallData> getAllCalls() {
        return this.getCalls();
    }

    /**
     * Returns the list of calls for a specific number
     *
     * @param number REQUIRE valid number
     * @return a list of CallData
     */
    List<CallData> getCallsFrom(String number) {
        List<CallData> result = null;

        for (CallData data : calls) {
            if (number.equals(data.getNumber())) {
                result.add(data);
            }
        }

        return result;
    }

    /**
     * Return the total amount of minutes of all calls
     *
     * @return the minutes of all calls
     */
    Duration getMinutesAmount() {
        Duration result = Duration.ZERO;

        for (CallData data : calls) {
            result = result.plus(data.getDuration());
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Number: ").append(number);
        builder.append("Owner: ").append(owner.toString());
        builder.append("Number of Calls: ").append(getNumberOfCalls());
        builder.append(isOriginal ? "Original" : "Not Original");
        builder.append(isActive() ? "Active" : "Not Active");

        return builder.toString();
    }

    private int getNumberOfCalls() {
        int callsSent = 0;
        for (CallData data : calls) {
            if (!data.isReceived()) {
                callsSent++;
            }
        }
        return callsSent;
    }
}
