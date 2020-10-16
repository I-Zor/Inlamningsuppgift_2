
public class Person {

    protected String name;
    protected String pn;
    protected String dateOfAnnualFee;

    public Person(){}
    public Person(String pn, String name){
        this.name = name;
        this.pn = pn;
    }

    public Person (String pn, String name, String dateOfAnnualFee){
        this.name = name;
        this.pn = pn;
        this.dateOfAnnualFee = dateOfAnnualFee;
    }

    public String getName() {
        return name;
    }

    public String getPn() {
        return pn;
    }

    public String getDateOfAnnualFee() {
        return dateOfAnnualFee;
    }
}
