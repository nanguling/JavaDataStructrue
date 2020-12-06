import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.*;

public class TestDemo {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("悟能","猪八戒");
        map.put("齐天大圣","孙悟空");
        System.out.println(map);
        map.put("齐天大圣","孙悟空2");
        System.out.println(map);
        System.out.println(map.get("悟能"));
        System.out.println(map.getOrDefault("玄奘","唐僧"));
        map.put("玄奘","唐三藏");
        System.out.println(map.getOrDefault("玄奘","唐僧"));

        Set<Map.Entry<String,String>> entrySet = map.entrySet();
        for (Map.Entry<String,String> entry:entrySet) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        /*map.put(null,null);
        System.out.println(map);*/
    }

    public static void main1(String[] args) {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        System.out.println(collection);
        System.out.println(collection.isEmpty());
        System.out.println(collection.remove(2));
        System.out.println(collection);

        Collection<Integer> collection1 = new LinkedList<>();


    }
}
