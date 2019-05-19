package xyz.aizuchi.comicrack;

/**
 * <p>Java class for YesNo.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="YesNo">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unknown"/>
 *     &lt;enumeration value="No"/>
 *     &lt;enumeration value="Yes"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
public enum YesNo {

    UNKNOWN("Unknown"),
    NO("No"),
    YES("Yes");
    private final String value;

    YesNo(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static YesNo fromValue(String v) {
        for (YesNo c: YesNo.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
