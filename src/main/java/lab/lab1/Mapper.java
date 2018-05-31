package lab.lab1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Wenqiang on 5/30/18.
 */
public class Mapper {

    public static List<Pair> mapper(String str){

        List<Pair> pairs  = new ArrayList<Pair>();
        String[] list = str.toString().replace("\n"," ").replace(",","") .split(" ");
        for(int i=0;i<list.length;i++){
            if(!list[i].isEmpty()&&!hasDigit(list[i])&&!list[i].contains("_")&&!list[i].substring(0,list[i].length()-1).contains(".")){
                if(list[i].contains("-")){
                    String[] temp = list[i].split("-");
                    int j=0;
                    while(j<temp.length){
                        Pair pair = new Pair(temp[j].replace("\"","").replace("'","").toLowerCase().replace(".",""),"1");
                        pairs.add(pair);
                        j++;
                    }
                }else{
                    Pair pair = new Pair(list[i].replace("\"","").replace("'","").toLowerCase().replace(".",""),"1");
                    pairs.add(pair);
                }

            }

        }
//        Collections.sort(pairs,new PairComparator());
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
