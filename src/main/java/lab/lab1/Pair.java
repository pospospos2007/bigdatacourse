package lab.lab1;

/**
 * Created by Wenqiang on 5/28/18.
 */
public class Pair {

    private String name;

    private String value;

    public Pair(String name, String value){
        this.name=name;
        this.value=value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "<" + name + " , " +value+" > ";
    }
}
