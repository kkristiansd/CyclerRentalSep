package src.server.database.queue;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
    private Queue<Task> queue;
    private int capacity;

    public BlockingQueue(int cap){
        queue = new LinkedList<>();
        capacity = cap;
    }

    public synchronized void add(Task task){
        while (queue.size() >= capacity){
            try {
                wait();
            }catch (InterruptedException e){
             e.printStackTrace();
            }
        }
        queue.add(task);
        notifyAll();
    }

    public Task retrieve (){
        while (queue.isEmpty()){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        Task task = queue.poll();
        notifyAll();
        return task;
    }
}
