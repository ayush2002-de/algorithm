import java.util.HashMap;
//it take o(low*high*n) time and o(low*high) space
public class ambigousMeasurement{
    public boolean isPossibleMeasurement(int [][]cups,int low,int high){
        HashMap<String,Boolean>cache=new HashMap<>();
        return checkIsPossible(cups,low,high,cache);
    }
    public boolean checkIsPossible(int [][]cups,int low,int high,HashMap<String,Boolean>cache){
        String key=low+":"+high;
        if(cache.containsKey(key))return cache.get(key);

         boolean canMeasure=false;
         for(int []cup:cups){
            if(low>=cup[0] && high<=cup[1])canMeasure=true;
            canMeasure=canMeasure||checkIsPossible(cups, low-cup[0], high-cup[1], cache);
            if(canMeasure)break;
         }
         cache.put(key,canMeasure);
         return canMeasure;
    }
}