package BUFFcode.WrittenTest.XieCheng;

import java.util.*;
import java.util.stream.Collectors;

class WorkflowNode {
    String nodeId;
    int timeoutMillis;
    List<WorkflowNode> nextNodes;
    boolean initialised;

    public static WorkflowNode load(String value) {
        // Create head node;
        Map<String, WorkflowNode> map = new HashMap<>();
        WorkflowNode head = new WorkflowNode("HEAD", 0, null);
        map.put(head.nodeId, head);

        for (String nodeValue : value.split("\\|")) {
            String[] properties = nodeValue.split("\\`");
            WorkflowNode node = map.get(properties[0]);

            node.timeoutMillis = Integer.parseInt(properties[1]);
            node.initialised = true;

            // Check next nodes
            if (properties[2].equals("END")) {
                continue;
            }
            node.nextNodes = Arrays.stream(properties[2].split(","))
                    .map(p -> new WorkflowNode(p, 0, null))
                    .collect(Collectors.toList());
            node.nextNodes.forEach(p -> map.put(p.nodeId, p));

            map.put(node.nodeId, node);
        }

        return head;
    }

    public WorkflowNode(String nodeId, int timeoutMillis, List<WorkflowNode> nextNodes) {
        this.nodeId = nodeId;
        this.timeoutMillis = timeoutMillis;
        this.nextNodes = nextNodes;
    }
}

public class Main1
{
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext())
        {
            WorkflowNode node = WorkflowNode.load(cin.next());
            System.out.println(get(node));
        }
    }

    public static int get(WorkflowNode node){
        if(node==null) return 0;
        int max=0;
        int cur=0;
        if(node.nextNodes==null) return node.timeoutMillis;
        for (int i = 0; i < node.nextNodes.size(); i++) {
            if(node.nextNodes.get(i).timeoutMillis>max){
                max=node.nextNodes.get(i).timeoutMillis;
                cur=i;
            }
        }
        return node.timeoutMillis+max+get(node.nextNodes.get(cur));
    }
}