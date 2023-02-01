//Bellmanford 

import java.util.*;
import java.io.*;
public class Bellmanford
{
        private int nv;
        public static final int MAX=999;
        private int distance[];
        
        
        public Bellmanford(int nv)
        {
                this.nv=nv;
                distance=new int[nv+1];
        }
        
        
        
        public static void main(String args[]) throws Exception
        {
                int nv=0;
                int source=0;
                System.out.println("Enter the number of vertices");
                Scanner sc=new Scanner(System.in);
                nv=sc.nextInt();
                System.out.println("Enter the adjacency matix");
                int admatrix[][]=new int[nv+1][nv+1];
                for(int sn=1;sn<=nv;sn++)
                        for(int dn=1;dn<=nv;dn++)
                        {
                                admatrix[sn][dn]=sc.nextInt();
                                if(sn==dn)
                                {
                                        admatrix[sn][dn]=0;
                                        continue;
                                }
                                if(admatrix[sn][dn]==0)
                                        admatrix[sn][dn]=MAX;
                         }
                 System.out.println("Enter the source vertex\n");
                 source=sc.nextInt();
                 Bellmanford bf=new Bellmanford(nv);
                 bf.shortestPath(source,admatrix);
                 sc.close();
           }
           
           public void shortestPath(int source,int admatrix[][])
           {
                int flag=0;
                for(int node=1;node<=nv;node++)
                        distance[node]=MAX;
                        
                distance[source]=0;
                
                
                for(int node=1;node<=nv;node++)
                        for(int sn=1;sn<=nv;sn++)
                                 for(int dn=1;dn<=nv;dn++)
                                        if(admatrix[sn][dn]!=MAX)
                                                if(distance[dn]>(distance[sn]+admatrix[sn][dn]))
                                                        distance[dn]=distance[sn]+admatrix[sn][dn];
                 
                 
                 for(int sn=1;sn<=nv;sn++)
                         for(int dn=1;dn<=nv;dn++)
                                  if(admatrix[sn][dn]!=MAX)
                                         if(distance[dn]>(distance[sn]+admatrix[sn][dn]))
                                         {
                                                  System.out.println("It is a negative edge cycle");
                                                  System.exit(0);
                                         }
                 for(int vertex=1;vertex<=nv;vertex++)
                                System.out.println("Distance from source "+source+" to "+vertex+" is: "+distance[vertex]);
                             
                 
           }
}    
                 
                 
               
                 
                                 
               
