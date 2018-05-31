package lab.lab4;

import lab.lab1.Pair;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Wenqiang on 5/31/18.
 */
public class Mapper {

    public static List<Pair> mapper(String str){

        List<Pair> pairs  = new ArrayList<Pair>();
        String[] list = str.toString().replace("\n"," ").replace(",","") .split(" ");
        HashMap<String, String> map = new HashMap<String, String>();
        for(int i=0;i<list.length;i++){
            if(!list[i].isEmpty()&&!hasDigit(list[i])&&!list[i].contains("_")&&!list[i].substring(0,list[i].length()-1).contains(".")){
                if(list[i].contains("-")){
                    String[] temp = list[i].split("-");
                    int j=0;
                    while(j<temp.length){
                        if(map.containsKey(temp[j].replace("\"","").replace("'","").toLowerCase().replace(".",""))){
                            int origin = Integer.valueOf(map.get(temp[j].replace("\"","").replace("'","").toLowerCase().replace(".","")));
                            map.put(temp[j].replace("\"","").replace("'","").toLowerCase().replace(".",""),
                                    origin+1+""
                            );
                        }else{
                            map.put(temp[j].replace("\"","").replace("'","").toLowerCase().replace(".",""),"1");
                        }
                        j++;
                    }
                }else{
                    if(map.containsKey(list[i].replace("\"","").replace("'","").toLowerCase().replace(".",""))){
                        int origin = Integer.valueOf(map.get(list[i].replace("\"","").replace("'","").toLowerCase().replace(".","")));
                        map.put(list[i].replace("\"","").replace("'","").toLowerCase().replace(".",""),
                                origin+1+""
                        );
                    }else{
                        map.put(list[i].replace("\"","").replace("'","").toLowerCase().replace(".",""),"1");
                    }
                }

            }

        }
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Pair pair = new Pair(entry.getKey().toString(),entry.getValue().toString());
            pairs.add(pair);
        }

        return pairs;

    }
    public static void sort(List<Pair> pairs){
        Collections.sort(pairs,new PairComparator());
    }

    public static void output(List<Pair> pairs){
        for(int i=0;i<pairs.size();i++){
            System.out.println(pairs.get(i).toString());
        }
    }
    static class PairComparator implements Comparator

    {

        @Override
        public int compare(Object o1, Object o2) {
            Pair p1 = (Pair) o1;
            Pair p2 = (Pair) o2;
            return p1.getName().compareTo(p2.getName());
        }
    }

    static boolean hasDigit(String content) {
        boolean flag = false;
        Pattern p = Pattern.compile(".*\\d+.*");
        Matcher m = p.matcher(content);
        if (m.matches())
            flag = true;
        return flag;
    }
}
