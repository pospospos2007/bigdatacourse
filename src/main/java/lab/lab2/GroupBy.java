package lab.lab2;

/**
 * Created by Wenqiang on 5/29/18.
 */
public class GroupBy {
    private String key;
    private String sum;

    public GroupBy(String key, String sum) {
        this.key = key;
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "< "+key+" , "+sum+" >";
    }
}
