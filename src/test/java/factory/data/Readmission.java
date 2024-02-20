package factory.data;

public enum Readmission {
    YES(true, "Yes")
    ,NO(false, "No")
    ;

    public final boolean apply;
    public final String text;

    Readmission(boolean apply, String text){
        this.apply = apply;
        this.text = text;
    }
}
