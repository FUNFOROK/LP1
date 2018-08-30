/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//author-: Saurabh Koshtwar
//rollno-: 421069
//Batch-: BE-A
//Year-: 2018-2019
//Best First Search


package ai;
import java.util.*;
import java.sql.Time;
class node{
    public int heu;
    public Scanner s=new Scanner(System.in);
    public int no;
    public int arr[];
    public int temp;
    public int n;
    
    node()
    {
        System.out.println("Default constructor called for node");
    }
    node(int x,int no)
    {
        this.heu=this.getheu();
        arr=new int[x];
        this.n=x;
        this.no=no;
    }
    int getheu()
    {
        System.out.println("Enter Heuristic value for this node");
        temp=s.nextInt();
        return temp;
    }
    void display()
    {
        for(int i=0;i<n;i++)
           System.out.print(" "+arr[i]);
        System.out.println("");
    }
    void acceptArr()
    {
        System.out.println("Enter array elements");
        System.out.println("1 for present and 0 for absent");
        for(int i=0;i<n;i++)
         this.arr[i]=s.nextInt();
    }
    int showheu()
    {
    return this.heu;
    }
    int showno()
    {
    return this.no;
    }
}

public class AI {
    public static Scanner s=new Scanner(System.in);
    public static void main(String[] args) {
       System.out.println("Best First Search");
       long stime=System.nanoTime();
        Vector<node> v=new Vector<node>();
         
        System.out.println("Enter total number of nodes");
        int n=s.nextInt();
        node obj[]=new node[n];
        for(int i=0;i<n;i++)
        {
            obj[i]=new node(n,i);
            obj[i].acceptArr();
        }
        //starting algorithm Best first Search
  
        {  
            String path=new String("Path is");
            int start=0;
            int goal=(n-1);
            System.out.println("Starting from node 0 and goal node as "+(n-1));
            while(start!=goal)
            {
                for(int i=0;i<n;i++)
                {
                    if(obj[start].arr[i]==1)
                            v.add(obj[i]);
                }
                
               //sorting vector according to heu values
               if(!v.isEmpty())      
                 Collections.sort(v,new Comparator(){
                        @Override
                        public int compare(Object o1, Object o2) {
                            return(new Integer(((node)o1).showheu()).compareTo(new Integer(((node)o2).showheu())));
                        }
                });
              
               //showing v
//               for(int i=0;i<v.size();i++)
//                   System.out.print(v.get(i).showno()+"\t");
//              
               
              
              start=v.get(0).showno();
              path+="\t"+start;
              v.remove(0);
              
            }
            System.out.println(path);
        }
        long etime=System.nanoTime();
        long totaltime=etime-stime;
        System.out.println("Total time needed to run the program-:"+totaltime);
    }
    
}
