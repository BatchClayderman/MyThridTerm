package kruskal;


class EData//����ʵ������һ����
{
    char start; //�ߵ�һ�ˣ����㣩
    char end;   //�ߵ���һ�ˣ���һ�����㣩
    int weight; //���루Ȩֵ��

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


public class Kruskal//��³˹�����㷨
{

    private int edgeNum;
    private char[] vertexs; //��������
    private int[][] matrix; //�ڽӾ���
    private static final int INF = Integer.MAX_VALUE;//ʹ�� INF �����������㲻����ͨ
    
    public Kruskal(char[] vertexs,int[][] matrix)//���캯��
    {
        this.vertexs = vertexs;
        this.matrix = matrix;
        
        for (int i = 0; i < vertexs.length; ++i)//ͳ�Ʊߵ����� �ڽӾ������Ͻ�
            for (int j = i + 1; j < vertexs.length; ++j)
                if (this.matrix[i][j] != INF)
                    ++this.edgeNum;
    }

    public void kruskal()
    {
        int index = 0;
        int[] ends = new int[edgeNum];//���ڱ���"������С���������е�ÿ����������С�������е��յ�
        EData[] rets = new EData[edgeNum];//���ѡȡ�ı߼���
        EData[] eData = getEdges();//��ȡ��ͼ�еı�
        sortEdges(eData);//�����еı߰�Ȩֵ��������

        /* ���� edges ���飬������ӵ���С��������ʱ���ж���׼������ı߷��γ��˻�·,���û�У��ͼ��� rets�������ܼ��� */
        for (int i = 0; i < edgeNum; ++i)
        {
            int p1 = getPosition(eData[i].start);//��ȡ���� i ���ߵĵ�һ�����㣨��㣩
            int p2 = getPosition(eData[i].end);//��ȡ���� i ���ߵĵڶ�������
            int m = getEnd(ends,p1);//��ȡ pl ���������������С�������е��յ�
            int n = getEnd(ends,p2);//��ȡ p2 ���������������С�������е��յ�
            
            if (m != n)//�Ƿ񹹳ɻ�·
            {
                ends[m] = n; //����m��"������С������"�е��յ�
                rets[index++] = eData[i];
            }
        }

        for (int i = 0; i < index; ++i)//��ӡ��С������
            System.out.println(rets[i]);
        return;
    }

    /**
     *	��ȡ�±�Ϊi�Ķ�����յ�(),���ں����ж�����������յ��Ƿ���ͬ
     * @param ends ���� ���Ǽ�¼�˸��������Ӧ���յ����ĸ�,ends�������ڱ��������У����γ�
     * @param i ��ʾ����Ķ����Ӧ���±�
     * @return ���صľ����±�Ϊi����������Ӧ���յ���±�
     */
    public int getEnd(int[] ends,int i)
    {
        while (ends[i] != 0)
            i = ends[i];
        return i;
    }
    
    /**
     *	 ��ȡ��������еıߣ�ʵ��������
     * @return
     */
    public EData[] getEdges()
    {
        EData[] edges = new EData[edgeNum];
        int index = 0;//�ߵ��±�
        for (int i = 0; i < this.vertexs.length; ++i)
            for (int j = i+1; j < this.vertexs.length; ++j)
                if (this.matrix[i][j] != INF)//�ҵ�һ����
                {
                    //start = this.vertexs[i]; end = this.vertexs[j]; weight = this.matrix[i][j]
                    edges[index++]=new EData(this.vertexs[i], this.vertexs[j], this.matrix[i][j]);
                }
        return edges;
    }

    /**
     * �Ա߼��Ͻ������򣨰���Ȩֵweight�� ð������
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
     * ��ȡ�����Ӧ���±�
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
        
        int matrix[][]= {//����˹�����㷨���ڽӾ���
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