import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {
    private Map<String,TreeMap<Integer,String>> map;

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key,new TreeMap<>());
        }
        map.get(key).put(timestamp,value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer,String> treeMap = map.get(key);
        if(treeMap==null) {
            return "";
        }
        Integer floor = treeMap.floorKey(timestamp);  // returns the greatest key which is less than or equal to the given val
        if(floor==null) {
            return "";
        }
        return treeMap.get(floor);
    }

    

    public static void main(String[] args) {
        TimeMap t=new TimeMap();
        t.set("foo","high",10);
        t.set("foo","low",20);
        t.get("foo",25);
    }
}

//https://leetcode.com/problems/time-based-key-value-store/description/


//optimised soln  O(log(L))
/*
 * 
 * 
    public String get(String key, int timestamp) {
        final String EMPTY_RESPONSE = "";
        if (!timeMap.containsKey(key))
            return EMPTY_RESPONSE;

        Node returnValue = binarySearch(timeMap.get(key), timestamp);
        return returnValue == null ? EMPTY_RESPONSE : returnValue.value;
    }

   
    
    private Node binarySearch(final List<Node> nodes, int timeStamp) {

        if (nodes.isEmpty())
            return null;


        int low = 0, high = nodes.size() - 1;
        Node returnValue = null;

        while (low <= high) {

            int mid = (high + low) >> 1;

            final Node current = nodes.get(mid);

            if (current.timeStamp == timeStamp)
                return returnValue = nodes.get(mid);

            else if (current.timeStamp > timeStamp)
                high = mid - 1;
            else {
                returnValue = current;
                low = mid + 1;
            }
        }

        return returnValue;
    }
 */
