package lab.lab1;

/**
 * Created by Wenqiang on 5/28/18.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        try {

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

            List<Pair> pairs = Mapper.mapper(str.toString());
            Mapper.sort(pairs);
            Mapper.output(pairs);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}