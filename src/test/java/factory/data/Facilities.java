package factory.data;

public enum Facilities {
    TOKYO("Tokyo CURA Healthcare Center")
    , HONGKONG("Hongkong CURA Healthcare Center")
    , SEOUL("Seoul CURA Healthcare Center")
    ;

    public final String name;

    Facilities(String name){ this.name = name; }
}
