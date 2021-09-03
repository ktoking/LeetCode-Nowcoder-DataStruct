package Utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ParseJsonToObject {

    @Data
    public static class User{
        String empcode;
        String imid;
        String email;
    }

    public static void main(String[] args) throws IOException {
        String path="D:\\Users\\kaiyiwang\\IdeaProjects\\LeetCode-Nowcoder-DataStruct\\src\\main\\java\\Utils\\userList";
        BufferedReader reader = new BufferedReader(new FileReader(path));//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/java/java-read-file-to-string.html
        StringBuilder stringBuilder = new StringBuilder();//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/java/java-read-file-to-string.html
        String line = null;
        String ls = System.getProperty("line.separator");
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        reader.close();

        String content = stringBuilder.toString();

        List<User> users = JSONArray.parseArray(content, User.class);

        String collect = users.stream().map(e -> e.getEmpcode()).collect(Collectors.joining(","));
        System.out.println(collect);
    }
}
