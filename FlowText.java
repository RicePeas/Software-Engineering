import java.util.*;
import java.lang.Math;

public class FlowText {

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int N;
        while(sc.hasNext()){
            N = sc.nextInt();       
            int mn=0;
            ArrayList<Integer> v = new ArrayList<Integer>();
            for(int i=0;i<N;i++){
                String x;
                x = sc.next();
                v.add(x.length());
                mn = Math.max(mn,v.get(v.size()-1));
            }
                
            int ret = 0, retw = -1;
            for(int w = mn; ; w++){
                        
                int[] cur = new int[w],next = new int[w];
                int cs= -1, nline =1;
            
                for(int vi = 0; vi< v.size(); vi++){
                    if(cs+v.get(vi) >=w){
                        //cur.swap(next);
                        cur = next;
                        next = new int[w];
                        cs =-1;
                        nline++;
                    }
                                
                    if(cs > 0 && (cs+1) < w) {
                        next[cs]=Math.max(cur[cs-1]+1,Math.max(cur[cs]+1,cur[cs-1]+1));
                        if(next[cs] > ret) {
                            ret = next[cs];
                            retw = w;
                        }
                    }
                
                    cs += v.get(vi) +1;
                }
            
                if(ret >=nline) break;
            }
       
            System.out.println(""+retw+' '+ret);
        }  
    }
}