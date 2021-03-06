
package bagliliste;


public class Bliste {
   Node head = null;
    public Bliste(int data)
    {
      head = new Node();
      head.data = data;
      head.next = null;
    }
    
    void printList(){
       Node temp = head;
       if (temp == null)
           throw new myException("Liste boştur.....");
       else
       {
            while(temp!=null)
            {
                long t = System.nanoTime() - temp.time;
                for (int i = 0; i < 1000000; i++) {
                    
                }
                System.out.print(temp.data + "=>");
                
                
                temp = temp.next;
            }
       }
        System.out.println("null");
       
    }
    
   public void addElementLast(int data)
     {
           Node newNode = new Node();
           newNode.data = data;
           newNode.next = null;       
           Node temp = head;
           while(temp.next != null)
           {
              temp = temp.next;
           }
           temp.next = newNode; 
           
     }
   public void removeEvenNodes(){
       Node temp = head;       
       if (temp == null){
           throw new myException("liste boş...");
       }
       else{
           while(temp.next != null){
               if (temp.data % 2 == 0){
                   temp = temp.next;
                   head = temp;
               }
               else if (temp.next.data % 2 == 0 ){
                   if (temp.next.next == null){
                       temp.next = null;
                   }else{
                       temp.next = temp.next.next;
                   }                    
                       
               }
               else{
                   temp = temp.next;
               }              
           }          
       }
   }
   public void addElementFront(int data)
    {
           Node newNode = new Node();
           newNode.data = data;
           newNode.time = System.nanoTime();
           newNode.next = head;
           head = newNode;  
            
           
    }
   void insertAfter(int data, int position){
        if( position < 0 )
            throw new myException("Position cannot be negative");
        
        if(head == null)
            throw new myException("LinkedList is empty");
        
        Node n = new Node();
        n.data = data;
        Node temp = head;
        int i = 0;
        while( position > i  && temp != null){
            temp = temp.next;
            i++;
        }
        if(temp == null)
            throw new myException("Position greater than list size");
            
        n.next = temp.next;
        temp.next = n;        
    }
   int sum(){
        int sum = 0;
        Node temp = head;
        while( temp != null){
            sum += temp.data;
            temp = temp.next;
        }
        return sum;
    }
   int count(){
        int size = 0;
        Node temp = head;
        while( temp != null){
            size++;
            temp = temp.next;
        }
        return size;
    }
   
   
}
class myException extends RuntimeException{

    public myException(String str) {
        super(str);
    }
  
}