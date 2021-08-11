package BUFFcode.WrittenTest.WeiMeng;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        String[] str={"1.20.1","1.10.1","1.3.0","1.2.2","1.1.3","1.1.2.10","1.1.2.2","1.1.1"};
        sortMethod(str);
    }
    public static String[] sortMethod (String[] stringArray) {
        // write code here
        Arrays.sort(stringArray,(o1, o2) ->{
            String[] split = o1.split(".");
            String[] split1 = o2.split(".");
            for (int i = 0; i < Math.min(split.length, split1.length); i++) {
                if(Integer.parseInt(split[i])>Integer.parseInt(split1[i])) return -1;
                else if(Integer.parseInt(split[i])<Integer.parseInt(split1[i])) return 1;
                else continue;
            }
            return split.length>split1.length?-1:1;
        });
        for (String s : stringArray) {
            System.out.println(s);
        }
        return null;
    }
}
