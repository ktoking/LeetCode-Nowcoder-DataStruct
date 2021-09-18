package DesignPattern.BuliderPattern;

import lombok.val;

public class PeopleInfo {

    private String name;
    private String gender;
    private String area;
    private String nation;

    public PeopleInfo(Builder builder) {
        this.name = builder.name;
        this.gender = builder.gender;
        this.area = builder.area;
        this.nation = builder.nation;
    }

    public static PeopleInfo.Builder builder(){
        return new PeopleInfo.Builder();
    }

    public static final class Builder {
        private  String name;
        private  String gender;
        private  String area;
        private  String nation;

        public Builder() {
        }

        public PeopleInfo build(){
            return new PeopleInfo(this);
        }

        public  Builder name(String val){
            name=val;
            return this;
        }
        public  Builder gender(String val){
            gender=val;
            return this;
        }
        public  Builder area(String val){
            area=val;
            return this;
        }
        public  Builder nation(String val){
            nation=val;
            return this;
        }
    }

    public static void main(String[] args) {
        PeopleInfo peopleInfo=new PeopleInfo.Builder().name("aa").build();
    }

}
