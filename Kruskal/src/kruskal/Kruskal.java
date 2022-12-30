package kruskal;


class EData//该类实例代表一条边
{
    char start; //边的一端（顶点）
    char end;   //边的另一端（另一个顶点）
    int weight; //距离（权值）

    public EData(char start, char end, int weight)
    {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString()
    {
        return "EData[<" + start + "," + end + ">," + "weight:" + weight + "]";
    }
}


public class Kruskal//克鲁斯卡尔算法
{

    private int edgeNum;
    private char[] vertexs; //顶点数组
    private int[][] matrix; //邻接矩阵
    private static final int INF = Integer.MAX_VALUE;//使用 INF 代表两个顶点不能连通
    
    public Kruskal(char[] vertexs,int[][] matrix)//构造函数
    {
        this.vertexs = vertexs;
        this.matrix = matrix;
        
        for (int i = 0; i < vertexs.length; ++i)//统计边的条数 邻接矩阵右上角
            for (int j = i + 1; j < vertexs.length; ++j)
                if (this.matrix[i][j] != INF)
                    ++this.edgeNum;
    }

    public void kruskal()
    {
        int index = 0;
        int[] ends = new int[edgeNum];//用于保存"已有最小生成树”中的每个顶点在最小生成树中的终点
        EData[] rets = new EData[edgeNum];//存放选取的边集合
        EData[] eData = getEdges();//获取到图中的边
        sortEdges(eData);//将所有的边按权值进行排序

        /* 遍历 edges 数组，将边添加到最小生成树中时，判断是准备加入的边否形成了回路,如果没有，就加入 rets，否则不能加入 */
        for (int i = 0; i < edgeNum; ++i)
        {
            int p1 = getPosition(eData[i].start);//获取到第 i 条边的第一个顶点（起点）
            int p2 = getPosition(eData[i].end);//获取到第 i 条边的第二个顶点
            int m = getEnd(ends,p1);//获取 pl 这个顶点在已有最小生成树中的终点
            int n = getEnd(ends,p2);//获取 p2 这个顶点在已有最小生成树中的终点
            
            if (m != n)//是否构成回路
            {
                ends[m] = n; //设置m在"已有最小生成树"中的终点
                rets[index++] = eData[i];
            }
        }

        for (int i = 0; i < index; ++i)//打印最小生成树
            System.out.println(rets[i]);
        return;
    }

    /**
     *	获取下标为i的顶点的终点(),用于后面判断两个顶点的终点是否相同
     * @param ends 数组 就是记录了各个顶点对应的终点是哪个,ends数组是在遍历过程中，逐步形成
     * @param i 表示传入的顶点对应的下标
     * @return 返回的就是下标为i的这个顶点对应的终点的下标
     */
    public int getEnd(int[] ends,int i)
    {
        while (ends[i] != 0)
            i = ends[i];
        return i;
    }
    
    /**
     *	 获取顶点间所有的边（实例）集合
     * @return
     */
    public EData[] getEdges()
    {
        EData[] edges = new EData[edgeNum];
        int index = 0;//边的下标
        for (int i = 0; i < this.vertexs.length; ++i)
            for (int j = i+1; j < this.vertexs.length; ++j)
                if (this.matrix[i][j] != INF)//找到一条边
                {
                    //start = this.vertexs[i]; end = this.vertexs[j]; weight = this.matrix[i][j]
                    edges[index++]=new EData(this.vertexs[i], this.vertexs[j], this.matrix[i][j]);
                }
        return edges;
    }

    /**
     * 对边集合进行排序（按照权值weight） 冒泡排序
     * @param edges
     */
    public void sortEdges(EData[] edges)
    {
        for (int i = 0; i < edges.length - 1; ++i)
            for (int j = 0; j < edges.length - i - 1; ++j)
                if (edges[j].weight > edges[j + 1].weight)
                {
                    EData tempEdge = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = tempEdge;
                }
        return;
    }

    /**
     * 获取顶点对应的下标
     * @param vertex
     * @return
     */
    public int getPosition(char vertex){
        for (int i = 0; i < this.vertexs.length; i++) {
            if (this.vertexs[i]==vertex){
                return i;
            }
        }

        return -1;
    }
    
    public static void main(String[] args)
    {
        char[] vertexs= {'A','B','C', 'D', 'E','F','G'};
        
        int matrix[][]= {//克魯斯卡尔算法的邻接矩阵
                      /*A*/ /*B*//*C*/ /*D*/ /*E*/ /*F*//*G*/
                /*A*/ { 0,   12,  INF,  INF,  INF,  16,  14},
                /*B*/ { 12,  0,   10,   INF,  INF,  7,   INF},
                /*C*/ { INF, 10,  0,    3,    5,    6,   INF},
                /*D*/ { INF, INF, 3,    0,    4,    INF, INF},
                /*E*/ { INF, INF, 5,    4,    0,    2,   8},
                /*F*/ { 16,  7,   6,    INF,  2,    0,   9},
                /*G*/ { 14,  INF, INF,  INF,  8,    9,   0}
        };

        Kruskal kruskal = new Kruskal(vertexs, matrix);
        kruskal.kruskal();
        System.exit(0);
    }
}