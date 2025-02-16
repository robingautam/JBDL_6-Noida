package org.example.standalone;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class StandCollection {

    @Value("#{mylist}")
    List<String> list;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "StandCollection{" +
                "list=" + list +
                '}';
    }
}
