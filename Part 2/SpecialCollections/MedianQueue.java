package com.efimchick.ifmo.collections;


import java.util.*;

class MedianQueue extends AbstractQueue<Integer> {

    AbstractQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    AbstractQueue<Integer> right = new PriorityQueue<>();
    AbstractQueue<Integer> queue = new PriorityQueue<>();

    public void fullQueue(){
        queue.addAll(left);
        queue.addAll(right);
    }

    @Override
    public Iterator<Integer> iterator() {
        fullQueue();
        return queue.iterator();
    }

    @Override
    public int size() {
        return left.size() + right.size();
    }

    @Override
    public boolean offer(Integer value) {
        if(left.size() == 0 || value < left.peek()){
            left.add(value);
            balance();
            return true;
        }
        right.add(value);
        balance();
        return true;
    }

    @Override
    public Integer poll() {
        if(left.size() == 0) {
            return null;
        }
        int val = left.remove();
        balance();
        return val;
    }

    @Override
    public Integer peek() {
        if(left.size() == 0) {
            return null;
        }
        return left.element();
    }

    public void balance(){
        if(left.size() - right.size() > 1){
            right.add(left.remove());
        } else if (right.size() > left.size()){
            left.add(right.remove());
        }
    }
}
