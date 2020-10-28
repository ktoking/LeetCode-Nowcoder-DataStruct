package LeetCode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 *  
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 *  
 *
 * 示例:
 *
 * LRUCache cache = new LRUCache( 2 /* 缓存容量 */
//        *
//        *cache.put(1,1);
//        *cache.put(2,2);
//        *cache.get(1);       // 返回  1
//        *cache.put(3,3);    // 该操作会使得密钥 2 作废
//        *cache.get(2);       // 返回 -1 (未找到)
//        *cache.put(4,4);    // 该操作会使得密钥 1 作废
//        *cache.get(1);       // 返回 -1 (未找到)
//        *cache.get(3);       // 返回  3
//        *cache.get(4);       // 返回  4
//        *
//        *来源：力扣（LeetCode）
//        *链接：https://leetcode-cn.com/problems/lru-cache
//        *著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


/**
 * 继承LinkedHashMap实现,将构造方法实现成按访问顺序(true),(false)为按插入顺序即为FIFO
 */
class LRUCache extends LinkedHashMap<Integer,Integer> {
    int capacity;


    public LRUCache(int capacity) {
        super(capacity,075f,true);
        this.capacity=capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key,-1); //这里找不到就返回-1
    }

    public void put(int key, int value) {
        super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){ //重写removeEldestEntry方法,当达到条件,就返回ture ,返回true就删除最近最少使用的Entery结点
        return super.size()>capacity;
    }
}



/**
 * 双向链表与hashmap结合
 *
 * 对于get操作,判断是否插已插入
 *   已插入的话,我们通过hash查到当前结点,更新value,并放到链表最头
 *   对于没插入的结点,那我们通过头插法插入链表最前,然后再判断当前容量是否大于设置容量,大于的话删除最尾结点
 *
 * 对于put操作,判断key是否存在
 *   已存在的话,我们利用hash找到,并放到表头,返回该结点的值
 *   不存在的话返回-1即可
 */
class DoubleList{  //双向链表
    int key;
    int value;
    DoubleList pre;
    DoubleList next;

    public DoubleList(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public DoubleList() {
    }
}
class LRUCache1 {

    int size; //当前容量
    int capacity; //最大容量
    DoubleList head; //头指针
    DoubleList tail; //尾指针
    Map<Integer,DoubleList> map=new HashMap<>(); //hash快速查找

    public LRUCache1(int capacity) {
       size=0;
       this.capacity=capacity;
       head=new DoubleList();
       tail=new DoubleList();
       head.next=tail;
       tail.pre=head;
    }

    /**
     * 查找该结点
     * @param key
     * @return
     */
    public int get(int key) {
        DoubleList findVal = map.get(key);
        if(findVal!=null){
            moveToHead(findVal);
            return findVal.value;
        }else return -1;
    }

    /**
     * 新增结点
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        DoubleList findVal = map.get(key); //查询是否存在该key
        if(findVal==null){ //不存在
            DoubleList doubleList = new DoubleList(key, value); //新建这个结点
            map.put(key,doubleList); //扔到map中去
            addToHead(doubleList); //放到链表头部
            size++; //自增容量
            if(size>capacity) { //若当前容量大于最大容量
                DoubleList removeTail = removeTail(); //找到最后一个结点,删除
                map.remove(removeTail.key); //在map中删除该key
                size--;
            }
        }else { //若该结点存在
            findVal.value=value; //更新这个结点的值
            moveToHead(findVal); //删除并移动到链表头部
        }
    }

    /**
     * 包含两个操作
     *   1.在链表中删除该结点
     *   2.将该结点加到链表头部
     * @param doubleList
     */
    private void moveToHead(DoubleList doubleList){
        removeNode(doubleList);
        addToHead(doubleList);
    }

    /**
     * 在链表中删除该结点
     * @param doubleList
     */
    private void removeNode(DoubleList doubleList){
       doubleList.pre.next=doubleList.next;
       doubleList.next.pre=doubleList.pre;
    }

    /**
     * 将该结点头插到链表中
     * @param node
     */
    private void addToHead(DoubleList node){
//        node.pre = head;
//        node.next = head.next;
//        head.next.pre = node;
//        head.next = node;

        node.next=head.next;
        node.pre=head;
        head.next.pre=node;
        head.next=node;

    }

    /**
     * 移除队尾元素
     * @return 返回被删除的结点(为了删除map中的值,所以此处返回结点)
     */
    private DoubleList removeTail() {
        DoubleList temp=tail.pre;
        removeNode(temp);
        return temp;
    }


}
public class Test_5_25__146 {


    public static void main(String[] args) {
        LRUCache lruCache=new LRUCache(5);

    }

}

class LRUCache2{
    int size; //当前容量
    int capacity; //最大容量
    DoubleList head; //头指针
    DoubleList tail; //尾指针
    Map<Integer,DoubleList> map=new HashMap<>(); //hash快速查找

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        size=0;
        head=new DoubleList();
        tail=new DoubleList();
        head.next=tail;
        tail.pre=head;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }else {
            DoubleList doubleList = map.get(key);
            removeToHead(doubleList);
            return doubleList.value;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            DoubleList doubleList = map.get(key);
            doubleList.value=value;
            removeToHead(doubleList);
        }else {
            //若不存在,先加入hashmap里面
            DoubleList doubleList=new DoubleList(key,value);
            map.put(key,doubleList);
            //然后判断容量大小
            if(size++>capacity){
                DoubleList doubleList1 = removeTail();
                map.remove(doubleList1);
                size--;
            }
            size++;
            addToHead(doubleList);
        }
    }

    public void deleteNode(DoubleList node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }
    public void addToHead(DoubleList node){
        node.next=head.next;
        head.next=node;
        head.next.next.pre=head.next;
        head.next.pre=head;
    }
    public void removeToHead(DoubleList node){
        deleteNode(node);
        addToHead(node);
    }
    public DoubleList removeTail(){
        DoubleList node=tail.pre;
        deleteNode(node);
        return node;
    }



}


