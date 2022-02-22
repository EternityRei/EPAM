package com.epam.autotasks.collections;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

class RangedOpsIntegerSet extends AbstractSet<Integer> {

    Set<Integer> set = new TreeSet<>();

    public boolean add(int fromInclusive, int toExclusive) {
        boolean res = false;
        for(int i = fromInclusive; i < toExclusive; i++) {
            if(!set.contains(i)) {
                res = true;
            }
            set.add(i);
        }
        return res;
    }

    public boolean remove(int fromInclusive, int toExclusive) {
        boolean res = false;
        for(int i = toExclusive - 1; i >= fromInclusive; i--){
            if(set.contains(i)) {
                res = true;
            }
            set.remove(i);
        }
        return res;
    }

    @Override
    public boolean add(final Integer integer) {
        return set.add(integer);
    }

    @Override
    public boolean remove(final Object o) {
        return set.remove(o);
    }

    @Override
    public Iterator<Integer> iterator() {
        return set.iterator();
    }

    @Override
    public int size() {
        return set.size();
    }
}
