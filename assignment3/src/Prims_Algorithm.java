/*
 * Authors: Jake O'Malley, Robert Tiller
 * Date: 4/10/2018
 * Overview:
*/ 
public class Prims_Algorithm 
{
    /*Pseudocode:
    algorithm: An undirected, weighted, connected graph G with n vertices and medges
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
    
    
}
