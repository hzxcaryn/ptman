package seedu.ptman.model.employee;

import static java.util.Objects.requireNonNull;
import static seedu.ptman.commons.util.AppUtil.checkArgument;

/**
 * Represents a Employee's ptman in PTMan.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String MESSAGE_ADDRESS_CONSTRAINTS =
            "Employee addresses can take any values, and it should not be blank";

    /*
     * The first character of the ptman must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String ADDRESS_VALIDATION_REGEX = "[^\\s].*";

    public final String value;

    /**
     * Constructs an {@code Address}.
     *
     * @param address A valid ptman.
     */
    public Address(String address) {
        requireNonNull(address);
        checkArgument(isValidAddress(address), MESSAGE_ADDRESS_CONSTRAINTS);
        this.value = address;
    }

    /**
     * Returns true if a given string is a valid employee email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
