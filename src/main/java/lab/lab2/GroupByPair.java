package lab.lab2;

import java.util.List;

/**
 * Created by Wenqiang on 5/29/18.
 */
public class GroupByPair {

    private String key;

    private List<String> values;

    public GroupByPair(String key,List<String> values) {
        this.values = values;
        this.key = key;
    }

    @Override
    public String toString() {
        return "< "+key+" , "+values.toString()+" >";
    }

    public String getKey() {
        return key;
    }

    public List<String> getValues() {
        return values;
    }
}
