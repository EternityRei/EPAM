package com.epam.rd.autotasks;

public class TaskCarousel {
    private final int capacity;
    private int length = 0;
    private Task[] tasks;
    private int execute_pointer;

    public TaskCarousel(int capacity) {
        this.capacity = capacity;
        tasks = new Task[length];
        execute_pointer = -1;
    }

    public boolean addTask(Task task) {
        if(length >= capacity || task.isFinished())
            return false;

        if(task instanceof CountDownTask && ((CountDownTask) task).getValue()==0)
            return false;

        length++;

        if(length == 1){
            tasks = new Task[length];
            tasks[0] = task;
            return true;
        }

        Task[] oldTasks = tasks;
        tasks = new Task[length];

        if (length - 1 >= 0) System.arraycopy(oldTasks, 0, tasks, 0, length - 1);

        tasks[length -1] = task;

        return true;
    }

    public void removeTask(int index){
        if(index < 0 || index >= length)
            return;

        length--;
        Task[] oldTasks = tasks;

        tasks = new Task[length];

        int temp_i = 0;
        for (int i = 0; i < length && temp_i < length +1; temp_i++) {
            if(temp_i == index)
                continue;

            tasks[i] = oldTasks[temp_i];
            i++;
        }
    }

    public boolean execute() {
        if (isEmpty())
            return false;

        execute_pointer++;

        if(execute_pointer >= tasks.length)
            execute_pointer = 0;

        Task currentTask = tasks[execute_pointer];

        if(currentTask != null && !currentTask.isFinished()){
            currentTask.execute();
            if(currentTask.isFinished()){
                removeTask(execute_pointer);
                execute_pointer--;
            }
            return true;
        }else return execute();
    }

    public boolean isFull() {
        return length == capacity;
    }

    public boolean isEmpty() {
        return tasks.length == 0;
    }
}
