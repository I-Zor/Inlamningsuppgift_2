
public class Person {

    protected String name;
    protected String pn;
    protected String dateOfAnnualFee;

    public Person(){}
    public Person(String name, String pn){
        this.name = name;
        this.pn = pn;
    }

    public Person (String pn, String name, String dateOfAnnualFee){
        this.name = name;
        this.pn = pn;
        this.dateOfAnnualFee = dateOfAnnualFee;
    }
}