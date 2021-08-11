package JUC;


import java.util.UUID;

public class PasswordGenerator{




    public String generate(){

        String s= UUID.randomUUID().toString().substring(0,16);
        return s;

    }


}