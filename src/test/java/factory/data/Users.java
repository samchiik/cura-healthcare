package factory.data;

import lombok.Getter;

public enum Users {
    JOHN_DOE("John Doe", "ThisIsNotAPassword")
    , EMPTY(null, null)
    , WRONG("Not Doe", "NotAPassword")
    ;
    public final String username;
    public final String password;


    Users(String username, String password){
        this.username = username;
        this.password = password;
    }
}
