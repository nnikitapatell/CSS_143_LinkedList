
/**
 * Write a description of class List here.
 *
 * @author Nikita Patel
 * @version 1
 */
public class List extends LinkedListException{
    /**
     * Implement Node as an inner class
     */
    public class Node {
        //public Object
        public Object data = null;
        //the start of the linked list
        public Node link = null;

        /**
         * Constructor for objects of class List
         */
        public Node(){
            //data is set to null
            this.data = null;
            //link is set ot null
            this.link = null;
        }

        /**
         * Node Constructor
         *
         * @param newItem A parameter
         * @param headNext A parameter
         */
        public Node(Object newData, Node nextLink){
            //data is set to newData
            this.data = newData;
            //link is set to nextLink
            this.link = nextLink;
        }

        /**
         * Method setItem
         *
         * @param newData A parameter
         */
        public void setData(Object newData){
            //item is set to input newItem
            this.data = newData;
        }

        /**
         * Method getData
         *
         * @return The return value
         */
        public Object getData(){
            //return data
            return this.data;
        }

        /**
         * Method setLink
         *
         * @param newLink A parameter
         */
        public void setLink(Node newLink){
            //link is set to input newLink
            this.link = newLink;
        }

        /**
         * Method getLink
         *
         * @return The return value
         */
        public Node getLink(){
            //return link
            return link;
        }
    }

    /**
     * List Class 
     */
    //create a private Node called head
    //this is the Node that is the start of the linked list

    private Node head = null;
    /**
     * Constructor for objects of class List
     */
    public List(){
        //set head node to null
        this.head = null;
    }

    /**
     * Method insert- Make a new node that holds the Object “next”, and insert this at 
     * the position specified by index
     *
     * @param next A parameter
     * @param index A parameter
     */
    public void insert(Object next, int index) {
        //a new node that holds the Object “next”
        Node position = new Node(next, null);

        //if we are adding to an empty list 
        //check if head is null
        if(this.head == null){
            //head is set to position
            this.head = position;
            //return
            return;
        }

        //if adding to a single element list 
        //check if head is not equal to null and if index is equal to 0
        if(head != null && index == 0){
            //set the link of the node position to head
            position.link = this.head;
            //set head to the node positon
            this.head = position;
            //return
            return;
        }

        //current node is set to head
        Node currentNode = this.head;
        //previous node is set to null
        Node previousNode = null;
        //int i is set to 0
        int i = 0;

        //while i is less than index
        while(i < index){
            //previos is set to current
            previousNode = currentNode;
            //current is set to current link
            currentNode = currentNode.link;
            if(currentNode == null){
                //break
                break;
            }
            //increment i
            i++;
        }

        //head link is set to postiion
        previousNode.link = position;
        //previous current is set to head
        previousNode.link.link = currentNode;
        //currentNode is null
        currentNode = null;
    }

    /**
     * Method remove
     * Find and delete the node at the position specified by index
     *
     * @param index A parameter
     * @return The return value
     */
    public Object remove(int index){
        //Deleting on an empty list
        //check if the head is null
        if(this.head == null){
            //throws an Linked List Exception
            throw new LinkedListException("List empty!");
        }

        //Deleting on a single element list (head only)
        //check if index is equal to 0
        if(size()== 1 || index == 0){
            //element is set to head's data 
            Object element = this.head.data;
            //head is set to head's link
            this.head = this.head.link;
            //return element
            return element;
        }
        //otherwise
        else{
            //check if index is less than 0 or index is greater than or equal to size
            if(index < 0 || index >= size()){
                throw new LinkedListException("Invalid index! Valid index is: [0 - " + (size() - 1) + "].");
            }
            //current node is set to head
            Node current = this.head;
            //iterate through loop
            for(int i = 0; i < index - 1; i++){
                //current is set to the current's link
                current = current.link;
            }
            //element is set to current link's data
            Object element = current.link.data;
            //current link is set to the current's link's link
            current.link = current.link.link;
            //return element
            return element;
        }
    }

    /**
     * Method append
     * Adds newData to the end of the list.
     *
     * @param next A parameter
     */
    public void append(Object next){
        //last node created
        Node last = new Node(next, null);
        //curent node is set to head
        Node current = head;
        //check if head is equal to null
        if(head == null){
            //head is set to last node
            this.head = last;
            //return
            return;
        }
        //while current link is not null
        while(current.link != null){
            //current is set to current's link
            current = current.link;
        }
        //current link is set to last
        current.link = last;
    }

    /**
     * Method delete- this method is the same as remove but has no return value.
     *
     * @param index A parameter
     */
    public void delete(int index){
        //check if index is 0
        if(index == 0){
            //head is set to head.getLink
            this.head = head.getLink(); 
        }
        //postion is set to head 
        Node position = this.head;
        //index is set to index minus 1
        index = index - 1;
        // i is set to 1
        int i = 1;

        //while the position is not equal to null
        while(position != null){
            //check if i is set to index
            if (i == index){
                //temporary node is set to position getLink
                Node temporaryNode = position.getLink();
                //temporary nod is set to temporary node getLInk
                temporaryNode = temporaryNode.getLink();
                //position setLink of temporary node
                position.setLink(temporaryNode);
                //break
                break;
            }
            //position is set to position.getLink
            position = position.getLink();
            //increment i
            i++;
        }
    }

    /**
     * Method size
     * A standard accessor
     *
     * @return The return value
     */
    public int size(){
        //count is set 0
        int count = 0; 
        //check if it is empty
        if(isEmpty()){
            //return count
            return count;
        }
        //create new node and set to head
        Node position = this.head;
        //while position is not null
        while(position != null){
            //increment count
            count++;
            //position is set to link
            position = position.link;
        }
        //return count
        return count;
    }

    /**
     * Method toString
     *
     * @return The return value
     */
    public String toString(){
        //check if head is null
        if(this.head == null){
            //return []
            return "[]";
        }
        //otherwise
        else{
            //result string
            String result = "[";
            //current node is set to head link
            Node current = this.head;
            //while current is not null
            while(current != null){
                //
                result += " " + current.data;
                current = current.link;
            }
            result += " ]";
            return result;
        }
    }

    /**
     * Method isEmpty
     * Returns true if empty, false otherwise
     *
     * @return The return value
     */
    public boolean isEmpty(){
        //checks if head is empty
        if(this.head == null){
            //retrun true if it is empty
            return true;
        }
        else{
            //returns false if it is not empty
            return false;
        }
    }

    /**
     * Method indexOf
     * A sequential search that returns the index if found or -1 if not found
     *
     * @param target A parameter
     * @return The return value
     */
    public int indexOf(Object target){
        if(head == null){
            throw new LinkedListException("List empty!");
        }
        //index is set to 0
        int index = 0;
        //current node is set to head
        Node current = this.head;
        //while current is not null
        while(current != null){
            //check if current is not null
            if(current.data.equals(target)){
                //retrun the index
                return index;
            }
            //increment index
            index++;
            //current is set to current link
            current = current.link;
        }
        //return -1
        return -1;
    }

    /**
     * Method equals
     * this should check if one list is a deep copy of the other
     *
     * @param other A parameter
     * @return The return value
     */
    public boolean equals(Object other){
        //create object
        List otherList = (List) other;
        //check if other is null
        if (other == null){
            //return false
            return false;
        } 
        //otherwise check if getClass is not equal to other getClass
        else if(getClass() != other.getClass()){
            //return false
            return false;
        }
        //otherwise
        else{
            //check if size is not the same size at otherList
            if (size() != otherList.size()){
                //return false
                return false;
            }
            //return true
            //return true;
        }
        //temp1 set otherList to head
        Node temp1 = otherList.head;
        //temp2 is set to head
        Node temp2 = this.head;
        //while temp1 is not null
        while(temp1 != null){
            //check is temp1 is not 
            if(!temp1.data.equals(temp2.data)){
                //return false
                return false;
            }
            //temp1 is set to temp1 link
            temp1 = temp1.link;
            //temp2 is set to temp2 link
            temp2 = temp2.link;
        }
        //return true
        return true;
    }

    /**
     * Method main
     *
     * @param args A parameter
     */
    public static void main(String[] args) {
        List empty = new List();
        List one = new List();
        List multiple = new List();

        one.append(5);
        multiple.append(10);
        multiple.append(20);
        multiple.append(30);
        multiple.append(40);

        System.out.println("Empty List:" + empty); // ( note the implicit call to toString()! )
        System.out.println("One List:"+ one);
        System.out.println("Multiple List:"+ multiple);  

        
        System.out.println("Empty List(append):" + empty);

        one.delete(0); //delete index 0
        multiple.delete(0); 
        System.out.println("One (delete):"+one);
        System.out.println("Multiple (delete):" + multiple);

        one.insert(600, 0); //insert 600 onto the list called one
        multiple.insert(400, 2); //ionsert 400 onto the the 2 index of the list called multiple
        System.out.println("One (insert):" + one); //print the list after inserting 
        System.out.println("One(size): " + one.size());   //print the list size 
        System.out.println("Multiple(insert):"+ multiple);  //print the list after inserting 
        System.out.println("Multiple(size): " + multiple.size());  //print the list size 
 
        multiple.remove(0);
        System.out.println("Multiple(remove):"+ multiple);

        //print index of 0
        System.out.println("Multiple(indexOf):"+ multiple.indexOf(0));
        //print index of 30
        System.out.println("Multiple(indexOf):"+ multiple.indexOf(30));
        
        

        //create an instance of List class
        List temp1 = new List();
        temp1.append(2); //append 2
        temp1.append(1); //append 1
        temp1.append(1); //append 1
        temp1.append(1); //append 1
        System.out.println("Temp1:"+ temp1.toString()); //print list called temp1
        
        //create an instance of List class
        List temp2 = new List();
        temp2.append(1); //append 1
        temp2.append(1); //append 1
        temp2.append(1); //append 1
        temp2.append(1); //append 1
        System.out.println("Temp2:"+ temp2.toString()); //print list called temp2
        
        //create an instance of List class
        List temp3 = new List();
        temp3.append(1); //append 1
        temp3.append(1); //append 1
        temp3.append(1); //append 1
        temp3.append(1); //append 1
        System.out.println("Temp3:"+ temp3.toString()); //print list called temp3
        
        //check if temp1 equals temp2
        System.out.println("Temp(equals):"+ temp1.equals(temp2));
        //check if temp2 equals temp1
        System.out.println("Temp(equals):"+ temp2.equals(temp3));
        
    }
}

