package JUC;

import java.util.UUID;

public class newPassword extends  PasswordGenerator {
    public String generate(){
        String generate = super.generate();
        String news= generate.substring(0,8);
        return news;
    }

}
