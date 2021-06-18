/**
 * Write a description of class Queue here.
 *
 * @author Nikita Patel
 * @version 1
 */
public class Queue extends List{
    /**
     * Queue Constructor
     *
     */
    public Queue(){
        //call super constructor
        super();
    }

    /**
     * Method enqueue
     *
     * @param next A parameter
     */
    public void enqueue(Object next){
        //call super insert
        super.append(next);
    }

    /**
     * Method dequeue
     *
     * @return The return value
     */
    public Object dequeue(){
        //call super remove
        return super.remove(0);
    }

    /**
     * Method insert
     *
     * @param next A parameter
     */
    public void insert(Object next){
        enqueue(next);
    }

    /**
     * Method remove
     *
     * @param num A parameter
     * @return The return value
     */
    public Object remove(int num){
        return dequeue();
    }

    /**
     * Method main
     *
     * @param args A parameter
     */
    public static void main(String[] args){
        Queue empty = new Queue();
        Queue one = new Queue();
        Queue multiple = new Queue();

        one.append(50);
        multiple.enqueue(10);
        multiple.enqueue(20);
        multiple.enqueue(30);
        multiple.enqueue(40);

        System.out.println("Empty: " + empty.toString());
        System.out.println("One: " + one);
        System.out.println("Multiple: " + multiple.toString());

        multiple.insert(400,1);
        System.out.println("One (insert): " + one.toString());
        System.out.println("Multiple (insert): " + multiple.toString());

        one.delete(0);
        System.out.println("One(delete): " + one);

        while(multiple.isEmpty() == false){
            System.out.println("Dequeued: " + multiple.dequeue());
        }
    }
}