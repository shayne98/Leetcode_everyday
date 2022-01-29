package leecode;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.swing.plaf.PanelUI;
import java.security.PublicKey;
import java.util.*;

@SuppressWarnings("all")
class Solution {
    public static void main(String[] args) {
        HashMap<Integer,List<Integer>> map= new HashMap<>();
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(1);
        map.put(0,objects);
        map.get(0).add(2);
        System.out.println(map.get(0).size());
    }

}