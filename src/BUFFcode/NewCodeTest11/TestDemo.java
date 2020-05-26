package BUFFcode.NewCodeTest11;

import java.util.Objects;

public class TestDemo {

    private Integer id;
    private String name;

    public TestDemo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        TestDemo t1=new TestDemo(0,"kaka");
        TestDemo t2=new TestDemo(0,"kaka");
        System.out.println(t1.equals(t2));
    }
}
