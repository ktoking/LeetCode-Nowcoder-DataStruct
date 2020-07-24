package LeetCode;

public class Test_7_24__1025 {
    /**
     * 如果N是奇数，因为奇数的所有因数都是奇数，因此 N 进行一次 N-x 的操作结果一定是偶数，所以如果 a 拿到了一个奇数，那么轮到 b 的时候，b拿到的肯定是偶数，这个时候 b 只要进行 -1， 还给 a 一个奇数，那么这样子b就会一直拿到偶数，到最后b一定会拿到最小偶数2，a就输了。
     *
     * 所以如果游戏开始时Alice拿到N为奇数，那么她必输，也就是false。如果拿到N为偶数，她只用 -1，让bob 拿到奇数，最后bob必输，结果就是true。
     * @param N
     * @return
     */
    public boolean divisorGame(int N) {
       return N%2==0;}
}
