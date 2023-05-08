package CAMPUS;
import java.util.*;

public class Campus {
    public static void main(String[] args) {
           Graph graph = new Graph(9, 14); // 9个顶点，14条边

           // 边的添加
//           graph.add_edge(0,1,1);
//           graph.add_edge(0,7,8);
//           graph.add_edge(1,2,8);
//           graph.add_edge(1,7,11);
//           graph.add_edge(2,3,3);
//           graph.add_edge(2,5,4);
//           graph.add_edge(2,8,2);
//           graph.add_edge(3,4,9);
//           graph.add_edge(3,5,1);
//           graph.add_edge(4,5,10);
//           graph.add_edge(5,6,2);
//           graph.add_edge(6,7,1);
//           graph.add_edge(6,8,6);
//           graph.add_edge(7,8,7);
//
//           int source = 0, target = 4;
//           graph.dijkstra(source, target);
//        Graph graph = new Graph(16, 30); // 16个顶点，30条边
//
//        // 边的添加
//        graph.add_edge(0,2,3);
//        graph.add_edge(1,3,1);
//        graph.add_edge(1,4,3);
//        graph.add_edge(1,5,6);
//        graph.add_edge(2,4,8);
//        graph.add_edge(2,5,7);
//        graph.add_edge(2,6,6);
//        graph.add_edge(3,7,6);
//        graph.add_edge(3,8,8);
//        graph.add_edge(4,7,3);
//        graph.add_edge(4,8,5);
//        graph.add_edge(5,8,3);
//        graph.add_edge(5,9,3);
//        graph.add_edge(6,8,8);
//        graph.add_edge(6,9,4);
//        graph.add_edge(7,10,2);
//        graph.add_edge(7,11,2);
//        graph.add_edge(8,11,1);
//        graph.add_edge(8,12,2);
//        graph.add_edge(9,11,3);
//        graph.add_edge(9,12,3);
//        graph.add_edge(10,13,3);
//        graph.add_edge(10,14,5);
//        graph.add_edge(11,13,5);
//        graph.add_edge(11,14,2);
//        graph.add_edge(12,13,6);
//        graph.add_edge(12,14,6);
//        graph.add_edge(13,15,4);
//        graph.add_edge(14,15,3);
//
//
//        // 求解最短路径
//        int source = 0, target = 15;
//        graph.dijkstra(source, target);

    }
}
class ArcNode{
    int adjvec;
    double weight;
    public ArcNode(int adjvec, double weight)
    {
        this.adjvec = adjvec;
        this.weight = weight;
    }
}
class Graph{
    private int vexnum;
    private int arcnum;
    private ArrayList[] arcList;
    public Graph()
    {}
    public Graph(int vexnum, int arcnum)
    {
        this.vexnum = vexnum;
        this.arcnum = arcnum;
        arcList     = new ArrayList[vexnum];
        for(int i = 0; i < vexnum; i ++)
        {
            arcList[i] = new ArrayList<ArcNode>();
        }
    }
    public void add_edge(int start, int end, double weight)
    {
        arcList[start].add(new ArcNode(end, weight));
        arcList[end].add(new ArcNode(start, weight));
    }
    public void dijkstra(int source, int target)
    {
        PriorityQueue<ArcNode> pq = new PriorityQueue<ArcNode>(new ArcNodeComparator());
        int n = this.vexnum;
        double[] dis = new double[vexnum];
        ArrayList<ArrayList<Integer>> pre = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < vexnum; i ++)
        {
            dis[i] = 0x3fffffff;
            pre.add(new ArrayList<Integer>());
        }
        dis[source] = 0;
        pq.offer(new ArcNode(source, 0));
        while(!pq.isEmpty())
        {
            ArcNode cur = pq.poll();
            int node = cur.adjvec;
            double weight = cur.weight;
            for(int i = 0; i < arcList[node].size(); i++){
                ArcNode temp = (ArcNode) arcList[node].get(i);
                int v = temp.adjvec;
                if(temp.weight + weight < dis[v]){
                    dis[v] = temp.weight + weight;
                    pq.offer(new ArcNode(v, dis[v]));
                    pre.get(v).clear();
                    pre.get(v).add(node);
                }
                else if(temp.weight + weight == dis[v]){
                    pre.get(v).add(node);
                }
            }
        }
        ArrayList<Integer> temp_path = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> path = new ArrayList<ArrayList<Integer>>();
        recordShortestPath(pre, target, path, temp_path);
        printAllPath(path, dis, source, target);
        }
    /**

     记录第k条路径
     @param pre 当前节点的前驱结点集合
     @param target 目标节点
     @param path 存储所有路径的集合
     @param temp_path 临时存储当前路径的集合
     */
    public void recordShortestPath(ArrayList<ArrayList<Integer>> pre, int target, ArrayList<ArrayList<Integer>> path, List<Integer> temp_path) {
        temp_path = new ArrayList<>(temp_path);
        List<Integer> now_pre = pre.get(target); // 获取当前节点的前驱结点集合
        temp_path.add(target);
        if(now_pre.isEmpty()) { // 没有前驱结点
            path.add(new ArrayList<>(temp_path));
            return;
        }
// 不为空，那么深搜前驱结点，得到路径
        for(int i = 0; i < now_pre.size(); i++) {
            int target2 = now_pre.get(i); // 集合中的一个点
            recordShortestPath(pre, target2, path, temp_path);
        }
    }
    /**

     打印所有的路径
     @param path 存储所有路径的集合
     @param dis 存储最短路径的距离的集合
     @param source 起始节点
     @param target 目标节点
     */
    public void printAllPath(ArrayList<ArrayList<Integer>> path, double[] dis, int source, int target) {
        System.out.println("The shortest path(es) from node " + source + " to node " + target + " are/is as follows: ");
        int k = path.size(); // 路径的条数
        for(int i = 0; i<k; i++) {
            System.out.print("Path" + i + ": ");
            for(int j = path.get(i).size()-1; j > 0 ; j--) {
                System.out.print(path.get(i).get(j) + " -> ");
            }
            System.out.println(path.get(i).get(0));
        }
        System.out.println("The length of path(es) is " + dis[target]);
    }
}


class ArcNodeComparator implements Comparator<ArcNode> {
    public int compare(ArcNode arc1, ArcNode arc2) {
        if (arc1.weight > arc2.weight)
            return 1;
        else if (arc1.weight < arc2.weight)
            return -1;
        else
            return 0;
    }
}