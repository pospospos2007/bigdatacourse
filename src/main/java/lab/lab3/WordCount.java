package lab.lab3;

import lab.lab1.Mapper;
import lab.lab2.Reducer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wenqiang on 5/30/18.
 */
public class WordCount {

    private int r ;
    private int m;
    private List<Mapper> mappers;
    private List<Reducer> reducers;

    public int getPartition(String key){
        return (int) key.hashCode() % r;
    }

    public WordCount(int m, int r) {
        this.r = r;
        this.m = m;
        mappers = new ArrayList<Mapper>();
        reducers = new ArrayList<Reducer>();
        for (int i = 0; i <m;i++){
            Mapper mapper = new Mapper();
            mappers.add(mapper);
        }
        for (int j = 0; j <r ; j++) {
            Reducer reducer = new Reducer();
            reducers.add(reducer);
        }
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public List<Mapper> getMappers() {
        return mappers;
    }

    public void setMappers(List<Mapper> mappers) {
        this.mappers = mappers;
    }

    public List<Reducer> getReducers() {
        return reducers;
    }

    public void setReducers(List<Reducer> reducers) {
        this.reducers = reducers;
    }
}
