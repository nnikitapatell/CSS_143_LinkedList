
/**
 * Write a description of class Stack here.
 *
 * @author Nikita Patel
 * @version 1
 */
public class Stack extends List{
    /**
     * Stack Constructor
     *
     */
    public Stack(){
        //call super constructor
        super();
    }
    
    /**
     * Method push
     *
     * @param next A parameter
     */
    public void push(Object next) {
        //call insert from List class
        super.insert(next,size());
    }

    /**
     * Method pop
     *
     * @return The return value
     */
    public Object pop(){
        //call remove and size from list class
        return super.remove(super.size()-1);
    }

    /**
     * Method main
     *
     * @param args A parameter
     */
    public static void main(String[] args){
        Stack empty = new Stack(); //create a stack called empty
        Stack one = new Stack(); //create a stack called one
        Stack multiple = new Stack(); //create a stack called multiple
        System.out.println("Empty: " + empty.toString()); //print empty stack
      
        one.push("Y"); //push Y onto the the stack called one
        System.out.println("One: " + one.toString()); //print th estack called one
        
        multiple.push("N"); //push N
        multiple.push("a"); //push a
        multiple.push("p"); //push p
        System.out.println("Multiple: " + multiple.toString());  //preint the stack

        System.out.println(one.toString()); //print the stack called one
        
        //while the stack muliple is not empty
        while(multiple.isEmpty() == false){
            //print each data popped
            System.out.println("Popped data: " + multiple.pop());
        }        
    }
}
