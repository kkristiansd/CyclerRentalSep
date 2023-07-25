package src.server.database.queue;

public class TaskConsumer implements Runnable{
    private BlockingQueue queue;
    private String name;
    public TaskConsumer(BlockingQueue queue, int id){
        this.queue=queue;
        name= "Consumer " + id;
    }

    @Override
    public void run() {
        while (true){
            Task task= queue.retrieve();
            int result = task.b+ task.a;
            System.out.println(name + "calculated result= " + result);
        }

    }
}
