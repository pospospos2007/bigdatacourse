package lab.lab3;

import lab.lab1.Pair;

import java.io.IOException;
import java.util.List;

/**
 * Created by Wenqiang on 5/30/18.
 */
public class Q1Main {

    public static void main(String[] args) throws IOException {
        String str1 ="\"cat bat\" mat-pat mum.edu sat.\n" +
               "fat 'rat eat cat' mum_cs mat";
        String str2 = "bat-hat mat pat \"oat\n" +
                "hat rat mum_cs eat oat-pat";
        String str3 = "zat lat-cat pat jat.\n" +
                "hat rat. kat sat wat";
        String[] inputs = {str1,str2,str3};
        WordCount wordCount = new WordCount(3,4);
        System.out.println("Number of Input-Splits: "+inputs.length+"\n" +
                            "Number of Reducers: "+wordCount.getR());
        System.out.println("Mapper 0 Input:\n"+inputs[0]);
        System.out.println("Mapper 1 Input:\n"+inputs[1]);
        System.out.println("Mapper 2 Input:\n"+inputs[2]);

        //mapper
        for(int i=0;i<wordCount.getM();i++){
            System.out.println("Mapper "+i+" Output");
            List<Pair> pairs =wordCount.getMappers().get(i).mapper(inputs[i]);
            wordCount.getMappers().get(i).output(pairs);
        }



//        //reduce input
//        System.out.println("Reducer Input");
//        List<GroupByPair> reduceInput = Reducer.reducerInput(pairs);
//        for(int i=0;i<reduceInput.size();i++){
//            System.out.println(reduceInput.get(i));
//        }
//
//        //reduce output
//        System.out.println("Reducer Output");
//        List<GroupBy> reduceOutput = Reducer.reduceOutput(reduceInput);
//        for(int i=0;i<reduceOutput.size();i++){
//            System.out.println(reduceOutput.get(i));
//        }

    }


}
