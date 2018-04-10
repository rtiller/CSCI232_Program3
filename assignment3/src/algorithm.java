/*
 * Authors: Jake O'Malley, Robert Tiller
 * Date: 4/10/2018
 * Overview:
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class algorithm
{
    public int size = 0;
    public String[] label;//for our label array
    public int[][] matrix;//for our matrix array
    public int minEdge = 0;
    
    

    public algorithm()//runs every time the algorithm is created in the driver. Reads out .txt file and generates a 2D array for us to work with in our algorithms
    {
        String line;
                Path file;
                file = FileSystems.getDefault().getPath("src", "matrix.txt");
                
                try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)){
                    //
                    //Creating a String array for Labes and counting how many we have
                    //
                    line = null;
                    line = reader.readLine();
                    String[] labelArray = line.split(",");//scans the first line of our TXT document for our label array and size of matrix
                        /*Origional print testing buffered reader
                        for(int i = 0; i < labelArray.length; i++){
                            System.out.println(labelArray[i]); 
                        }*/
                    size = labelArray.length;//keeping track of label array size so that we can create arrays for label and the matrix
                    label = new String[size];// creating new string of the labelArray size in order to create our global label array
                    label = labelArray;//assigning labelArray (generated by the buffered reader) to our global label array
                    
                    //
                    //Creating a Int array for matrix from the rest of the .txt document
                    //
                    
                    int itr = 0;
                    matrix  = new int[size][size];
                        
                    while ((line = reader.readLine()) != null){
                        String[] array = line.split(",");
                        
                        for(int k = 0; k < size; k++)
                        {
                            matrix[itr][k] = (Integer.parseInt(array[k]));
                        }
                        itr++;
                    }
                }catch (IOException x){
            System.err.format("IOException: %s%n", x);
        }
        
        printMatrix(matrix);
    }
    
    public void printMinEdge(int x)
    {
        System.out.print("Printing Min Edge Value: ");  
        // For reverse of natural order i.e. largest to smallest
        // If you want the natural order don't use the Collections.reverseOrder() comparator
        Queue<Integer> queue = new PriorityQueue<Integer>(size);
        for(int j = 0; j <= size-1; j++)
        {
            queue.addAll(Arrays.asList(matrix[x][j]));
        }
        int test = queue.remove();
        System.out.print("\nMin edge value is ");
        System.out.println(test);
        System.out.println();
    }
   /* 
    public void prim(){
        Queue<Integer> queue = new PriorityQueue<Integer>(size);
        s
    }
    
    public int[][] kruskal(int[][] m, String[] l, int size){
        int[][] graph = new int[size][size];
        String[] label = new String[size];
        Queue<Integer> queue = new PriorityQueue<Integer>(size);
        
        graph = m;
        label = l;
        
        for(int i = 0; i < size; i++){
            define cluster C(v) = {v};
        }
        
        while(T? < n-1 edges){
            (c,v) = queue.remove();
            
            if(C(u) != C(v)){
                add edge to T;
                merge C(u) and C() into one cluster;                     
            }
        }
        return(T);
    }
    */
    public void floydWarshall(){
        int[][] d = new int[size][size];
        int i, j, k;
        
        for(i = 0; i < size; i++){
            for(j = 0; j < size; j++){
                d[i][j] = matrix[i][j];
            }
        }
        
        for(i = 0; i < size; i++){
            for(j = 0; j < size; j++){
                for(k = 0; k < size; k++){
                    if(d[j][k] > d[j][i] + d[i][k]){
                        d[j][k] = d[j][i] + d[i][k];
                        printMatrix(d);
                    }
                }
            }
        } 
    }
    
    public void printMatrix(int[][] matrix){
        int i,j;
       
       for(i=0; i < size; i++){
           
           System.out.print("  " + label[i]);
       }
       System.out.println();
       for(i = 0; i < size; i++)
        {
            System.out.print(label[i] + " ");
            for(j = 0; j < size; j++)
            {
                if(matrix[i][j] == 999){
                    System.out.print("I ");
                }
                else{
                    System.out.print(matrix[i][j] + " ");
                }
            }                
            System.out.println();
        } 
        System.out.println();
    }
}
/*
--------------------------------------------------------------------------------------- 
                           Prims_Algorithm
---------------------------------------------------------------------------------------     
  
public class Prims_Algorithm 
{
    Pseudocode:
    algorithm: An undirected, weighted, connected graph G with n vertices and m edges
    output: A minimum spanning tree T for G
    
    pick any vertex s of G
    D[s] = 0
    for each vertex v!= s do
        D[v] = 'infinity'
    initialize T = 'null'?
    initialize a priority queue Q with an entry (D[v],v) for each vertex v
    For each vertex v, maintain connect(v) as the edge achieving D[v](if any)
    while Q is not empty do
        Let u be the value of the entry returned by Q.removeMin()
        connect vertex u to T using edge connect(e)
        for each edge e' = (u,v) such that v is in Q do
    {check if edge (u,v) better connects v to T}
            if w(u,v) < D[v] then
                D[v] = w(u,v)
                connect(v) = e'
                change the key of vertex v in Q to D[v]
    return the tree T
    */
    /*
    int vertex;
    public Prims_Algorithm()//runs every time the algorithm is created in the driver. Reads out .txt file and generates a 2D array for us to work with in our algorithms
    {
        vertex = 0;
        while(matrix[i] != matrix[vertex])
        {
            
        }
    }
*/
 
  

