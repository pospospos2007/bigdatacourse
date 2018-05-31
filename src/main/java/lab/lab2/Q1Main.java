package lab.lab2;

import lab.lab1.Mapper;
import lab.lab1.Pair;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Wenqiang on 5/29/18.
 */
public class Q1Main {

    public static void main(String[] args) throws Exception {

        String pathname = "/Users/mac/Documents/Big data/testDataForW1D1.txt";
        File filename = new File(pathname);
        InputStreamReader reader = new InputStreamReader(
                new FileInputStream(filename));
        BufferedReader br = new BufferedReader(reader);
        StringBuilder str = new StringBuilder();
        String line = "";
        while (line != null) {
            line = br.readLine();
            str.append(line);
        }
        System.out.println(str.toString());

        //mapper
        List<Pair> pairs = Mapper.mapper(str.toString());

        //reduce input
        System.out.println("Reducer Input");
        List<GroupByPair> reduceInput = Reducer.reducerInput(pairs);
        for(int i=0;i<reduceInput.size();i++){
            System.out.println(reduceInput.get(i));
        }

        //reduce output
        System.out.println("Reducer Output");
        List<GroupBy> reduceOutput = Reducer.reduceOutput(reduceInput);
        for(int i=0;i<reduceOutput.size();i++){
            System.out.println(reduceOutput.get(i));
        }
    }



}
