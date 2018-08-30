/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//Author:Onkar Kulkarni
//Rollno:421071
//LP1:AIR
//Astar Algorithm





package ai;
import java.util.*;
import java.util.Vector;

class mynode extends node
{
    public int tillnow;//distance which will be updated by parent 
    
    mynode(){}
    mynode(int a,int b){
       super(a,b);
    }
    int calc_fn()
    {
        return tillnow+this.heu;
    }
}



public class Astar {
    public static Scanner s=new Scanner(System.in);
    public static void main(String args[]){
    System.out.println("A* algorithm");
        Vector<mynode> v=new Vector<mynode>();
         System.out.println("Enter total number of nodes");
        int n=s.nextInt();
        mynode obj[]=new mynode[n];
        for(int i=0;i<n;i++)
        {
            obj[i]=new mynode(n,i);
            obj[i].acceptArr();
        }
        
        //starting algorithm
        {
            int start=0;
            int goal=n-1;
            String path=new String();
            while(start!=goal)
            {
                for(int i=0;i<n;i++){
                    if(obj[start].arr[i]!=-99){
                        v.add(obj[i]);
                        obj[i].tillnow=obj[start].tillnow+obj[start].arr[i];//editing till now values
                    }
            }
                
                 //sorting vector according to f(n)=g(n)+h(n)
               if(!v.isEmpty())      
                 Collections.sort(v,new Comparator(){
                        @Override
                        public int compare(Object o1, Object o2) {
                            return(new Integer(((mynode)o1).calc_fn()).compareTo(new Integer(((mynode)o2).calc_fn())));
                        }
                });
          //   showing v
               for(int i=0;i<v.size();i++)
                   System.out.print(v.get(i).showno()+"\t");
                   
               
               
               start=v.get(0).showno();
               path+="\t"+start;
               v.remove(0);
               
            }
        System.out.println(path);
    }
        
        
       
    
    
    }
}
