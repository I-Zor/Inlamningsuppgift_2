import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DateUtilTest {

    DateUtil du = new DateUtil();

    @Test
    public void isDurationShorterThanYear(){
        String date = "2020-10-15";
        String dateOfAnnualFee = "2019-11-16";
        LocalDate l = LocalDate.parse(date);
        assertEquals(du.isDurationShorterThanYear(dateOfAnnualFee), true );
    }


}
