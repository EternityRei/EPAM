package com.efimchick.ifmo.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class PairStringList extends ArrayList<String> {

    ArrayList<String> list = new ArrayList<>();

    @Override
    public String get(int index) {
        return list.get(index);
    }

    @Override
    public String set(int index, String element) {
        String val = list.set(index, element);
        if(index == 0) {
            list.set(index, element);
            list.set(++index, element);
        }
        if(index % 2 == 0){
            list.set(index, element);
            list.set(++index, element);
        }
        if(index % 3 == 0){
            list.set(index, element);
            list.set(--index, element);
        }

        return val;
    }

    @Override
    public boolean add(String s) {
        list.add(s);
        list.add(s);
        return true;
    }

    @Override
    public void add(int index, String element) {
        if(index == 0){
            list.add(index, element);
            list.add(++index, element);
            return;
        }
        if(index % 2 == 0){
            list.add(index, element);
            list.add(++index, element);
            return;
        }
        list.add(index + 1, element);
        list.add(index + 2, element);
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        return list.addAll(pairs((Collection<String>) c));
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        if(index % 2 != 0){
            list.addAll(++index, pairs((Collection<String>) c));
            return true;
        }
        list.addAll(index, pairs((Collection<String>) c));
        return true;
    }

    @Override
    public String remove(int index) {
        String val = list.get(index);
        list.remove(list.get(index));
        list.remove(list.get(--index));
        return val;
    }

    @Override
    public boolean remove(Object o) {
        if(list.contains(o)){
            list.remove(o);
            list.remove(o);
            return true;
        }
        return false;
    }

    @Override
    public Iterator<String> iterator() {
        return list.iterator();
    }
    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void clear() {
        list.clear();
    }

    public ArrayList<String> pairs(Collection<String> c) {
        ArrayList<String> arrayList = new ArrayList<>();
        for(String s: c) {
            arrayList.add(s);
            arrayList.add(s);
        }
        return arrayList;
    }
}
