import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

public class DateUtil {

    public LocalDate getLocalDate(String time){
        return LocalDate.parse(time);
    }

    public boolean isDurationShorterThanYear(String dateOfAnnualFee, LocalDate l){
        LocalDate d = getLocalDate(dateOfAnnualFee);
        l = LocalDate.now();
        int duration = Period.between(d, l).getDays();
        if (duration <= 365)
            return true;
        else
            return false;

    }


}
