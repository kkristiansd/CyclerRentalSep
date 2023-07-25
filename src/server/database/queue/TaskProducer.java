package src.server.database.queue;

import java.util.Random;

public class TaskProducer implements  Runnable{
    private BlockingQueue queue;

    @Override
    public void run(){
        Random rand = new Random();

        while (true){
            int a = rand.nextInt(100);
            int b = rand.nextInt(100);
            Task t = new Task(a,b);
            queue.add(t);
        }
    }
}
