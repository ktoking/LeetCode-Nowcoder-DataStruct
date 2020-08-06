package DataStructure.HashMapDemo;

import java.util.LinkedList;
/**
 * node结点，记录k v
 */
class NodeDemo{
    private Object key;
    private Object value;

    public NodeDemo(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}

/**
 * 手写一个hashmap，实现最简单的put与get操作
 * 首先创建一个LinkedList数组，数组里面每一个元素都是一个list 默认数组大小1024
 * put操作： 首先根据key获取index下标值，具体做法是取key的hash值与数组大小-1
 *            然后判断当前index下是否有list，没有就创建一个list添加进去，有就遍历这个list，查到相同的key就覆盖value，然后返回，查到最后要是还没有就添加到list的最后
 * get操作： 首先也是根据key的hash值取index，具体做法与put一样，拿到index去判断当前index下的数组是否有值，没有就直接返回null
 *           存在list就遍历list，查到相同的key就直接返回value，查到最后也没有就返回null
 */
public class HashMapDemo {

    public static final int LENGTH=1024;

    LinkedList[] arr=new LinkedList[LENGTH];

    public void put(Object key,Object value){
        int index=key.hashCode()&(LENGTH-1);
        NodeDemo nodeDemo=new NodeDemo(key,value);
        if(arr[index]==null){
            LinkedList linkedList=new LinkedList();
            linkedList.add(nodeDemo);
            arr[index]=linkedList ;
        }else {
            for (int i = 0; i < arr[index].size(); i++) {
                NodeDemo find= (NodeDemo) arr[index].get(i);
                if(find.getKey().equals(nodeDemo.getKey())){
                    find.setValue(nodeDemo.getValue());
                    return;
                }
            }
            arr[index].add(nodeDemo); //找到最后还没有就插到最后
        }
    }

    public Object get(Object key){
        int index=key.hashCode()&(LENGTH-1);//找到下标
        if(arr[index]==null)return null;
        for (int i = 0; i < arr[index].size(); i++) {
            NodeDemo o = (NodeDemo) arr[index].get(i);
            if(o.getKey().equals(key))return o.getValue();
        }
        return null;
    }

    public static void main(String[] args) {
        HashMapDemo hashMapDemo=new HashMapDemo();
        hashMapDemo.put(1,"aaa1");
        hashMapDemo.put(2,"aaa2");
        hashMapDemo.put(3,"aaa3");
        hashMapDemo.put(4,"ddd4");
        hashMapDemo.put(4,"ddd5");
        System.out.println(hashMapDemo.get(4));
        System.out.println(hashMapDemo.get(3));
        System.out.println(hashMapDemo.get(2));
        System.out.println(hashMapDemo.get(1));
        System.out.println(hashMapDemo.get(10));
    }
}
