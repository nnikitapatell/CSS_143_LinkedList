/**
 * Write a description of class LinkedListException here.
 *
 * @author Nikita Patel
 * @version 1
 */
public class LinkedListException extends RuntimeException{
    public LinkedListException(){
        //calls super 
        super("Linked List Exception");
    }

    public LinkedListException(String message){
        // prints message
        super(message);
    }
    
}
