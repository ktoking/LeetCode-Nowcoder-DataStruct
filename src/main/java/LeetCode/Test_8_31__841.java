package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 841. 钥匙和房间
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 *
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 *
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 *
 * 你可以自由地在房间之间来回走动。
 *
 * 如果能进入每个房间返回 true，否则返回 false。
 *
 * 示例 1：
 *
 * 输入: [[1],[2],[3],[]]
 * 输出: true
 * 解释:
 * 我们从 0 号房间开始，拿到钥匙 1。
 * 之后我们去 1 号房间，拿到钥匙 2。
 * 然后我们去 2 号房间，拿到钥匙 3。
 * 最后我们去了 3 号房间。
 * 由于我们能够进入每个房间，我们返回 true。
 * 示例 2：
 *
 * 输入：[[1,3],[3,0,1],[2],[0]]
 * 输出：false
 * 解释：我们不能进入 2 号房间。
 * 提示：
 *
 * 1 <= rooms.length <= 1000
 * 0 <= rooms[i].length <= 1000
 * 所有房间中的钥匙数量总计不超过 3000。
 */
public class Test_8_31__841 {

    /**
     * DFS深度优先遍历,访问每一个房间,只要全访问过了就返回true
     */
    boolean[] flag;
    int num;
    public  boolean canVisitAllRooms(List<List<Integer>> rooms) {
        flag=new boolean[rooms.size()];
        num=0;
        dfs(rooms,0);
        return num==rooms.size();
    }
    public  void dfs(List<List<Integer>> rooms,int size){
        flag[size]=true;
        num++;
        for (int i = 0; i < rooms.get(size).size(); i++) {
            if(!flag[rooms.get(size).get(i)]){
                dfs(rooms,rooms.get(size).get(i));
            }
        }
    }

    /**
     * BFS广度优先试试
     * @param rooms
     * @return
     */
    public  boolean canVisitAllRoomsBFS(List<List<Integer>> rooms) {
        int all=0;
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(0);
        boolean[] visit=new boolean[rooms.size()];
        visit[0]=true;
        while (!queue.isEmpty()){
            int poll = queue.poll();
            all++;//只有到达新房间计数器才+1
            for (int room:rooms.get(poll)) {//遍历房间,将没访问过的加入队列,并且设置已访问过
                if(!visit[room]){
                    visit[room]=true;
                    queue.offer(room);
                }
            }
        }
        return rooms.size()==all;
    }



    public boolean canVisitAllRooms1(List<List<Integer>> rooms) {
        if(rooms == null || rooms.size() == 0){
            return true;
        }
        //是否访问过这个房间的标记
        boolean[] flag = new boolean[rooms.size()];
        //从0开始访问房间
        visitRoom(flag,0,rooms);
        //遍历标记判断是否都已访问过
        for(int i = 0;i < flag.length;i++){
            if(!flag[i]){
                return false;
            }
        }
        return true;
    }
    public void visitRoom(boolean[] flag,int i,List<List<Integer>> rooms){
        //如果已访问过，直接返回
        if(flag[i]){
            return;
        }
        //拿到钥匙,并更新标记
        List<Integer> keys = rooms.get(i);
        flag[i] = true;
        //通过钥匙循环遍历房间
        for(int k : keys){
            visitRoom(flag,k,rooms);
        }
    }
}
