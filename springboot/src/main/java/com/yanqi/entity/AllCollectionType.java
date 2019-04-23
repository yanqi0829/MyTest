package com.yanqi.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class AllCollectionType {
    private List<String> list;
    private String[] array;
    private Set<String> set;
    private Map<String, String> map;
    private Properties props;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    @Override
    public String toString() {
        return "AllCollectionType{" +
                "list=" + list +
                ", array=" + Arrays.toString(array) +
                ", set=" + set +
                ", map=" + map +
                ", props=" + props +
                '}';
    }

    public static void main(String[] args) {
        ApplicationContext context= new ClassPathXmlApplicationContext("contxet.xml");
        AllCollectionType allCollectionType= (AllCollectionType) context.getBean("collectionType");
        System.out.println(allCollectionType);

    }
}
