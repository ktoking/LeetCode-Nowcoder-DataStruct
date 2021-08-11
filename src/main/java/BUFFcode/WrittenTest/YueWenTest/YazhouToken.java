package BUFFcode.WrittenTest.YueWenTest;

import com.sun.xml.internal.bind.v2.runtime.output.Encoded;

import sun.security.provider.MD5;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

public class YazhouToken {
    public static void main(String[] args) {

    }

    public static String createToken(ArrayList<String> querys) throws UnsupportedEncodingException {
        StringBuilder sb=new StringBuilder();
        for (String query : querys) {
            String encode = URLEncoder.encode(query, "utf-8");
            String[] split = encode.split("\"");
            String[] split1 = split[1].split("=");
            sb.append(split1[0]+"&"+split1[1]);
        }
        return null;
    }
}
