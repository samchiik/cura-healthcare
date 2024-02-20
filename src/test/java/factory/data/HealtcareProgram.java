package factory.data;

public enum HealtcareProgram {
    MEDICARE("Medicare")
    ,MEDICAID("Medicaid")
    ,NONE("None")
    ;

    public final String name;

    HealtcareProgram(String name){
        this.name = name;
    }
}
