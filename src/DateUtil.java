import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

public class DateUtil {

    public LocalDate getLocalDate(String time){
        return LocalDate.parse(time);
    }

    public boolean isDurationShorterThanYear(String dateOfAnnualFee){
        LocalDate d = getLocalDate(dateOfAnnualFee);
        LocalDate l = LocalDate.now();
   /*     d.plusYears(1);
       if (d.isAfter(l))
            return true;
        else
            return false;*/
        Period duration = Period.between(d, l);
          return duration.getYears() == 0 || duration.getYears() == 1 &&
                duration.getMonths() == 0 && duration.getDays() == 0;
    }
}
