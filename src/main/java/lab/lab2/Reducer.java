package lab.lab2;

import lab.lab1.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wenqiang on 5/29/18.
 */
public class Reducer {



    public static List<GroupByPair> reducerInput(List<Pair> pairs){

        List<GroupByPair>  list = new ArrayList<GroupByPair>();
        for(int i=0;i<pairs.size();i++){
            List<String> values = new ArrayList<String>();
            values.add(pairs.get(i).getValue());
            for(int j=i+1;j<pairs.size();j++){
                if(pairs.get(j).getName().equals(pairs.get(i).getName())){
                    values.add(pairs.get(j).getValue());
                    i++;
                }else{
                    i=j-1;
                    break;
                }
            }

            GroupByPair pair = new GroupByPair(pairs.get(i).getName(),values);
            list.add(pair);
        }

        return list;

    }

    public static List<GroupBy> reduceOutput(List<GroupByPair> pairs){

        List<GroupBy> list = new ArrayList<GroupBy>();
        for(int i=0;i<pairs.size();i++){
            List<String> values =pairs.get(i).getValues();
            Integer sum = 0;
            for(int j=0;j<values.size();j++){
                sum+=Integer.valueOf(values.get(j));
            }
            GroupBy pair = new GroupBy(pairs.get(i).getKey(),String.valueOf(sum));
            list.add(pair);
        }
        return list;

    }

}
