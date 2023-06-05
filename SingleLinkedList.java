import java.util.*;
class Node
{
    int data;   //instance variable
    Node next;  //instance variable
}

public class SingleLinkedList {
    static Node starter = null;

    //get method to take input from keyboard
    static int get()
    {
        return new Scanner(System.in).nextInt();
    } 

    //count method for counting node
    static int count()
    {
        if(starter == null)
        {
            return 0;
        }
        else
        {
            int count = 0;
            Node temp = starter;
            while(temp != null)
            {
                count++;
                temp = temp.next;
            }
            return count;
        }
       
    }

    //create method for creating node
    void create()
    {
        System.out.println("Enter number of nodes you want to create:");
        int n = get();
        if (n > 0) 
        {
            Node temp = new Node();
            starter = temp;
            System.out.println("Enter the data:");
            temp.data = get();
            for( int i = 1; i < n; i++)
            {
                temp.next = new Node();
                temp = temp.next;
                System.out.println("Enter the data:");
                temp.data = get();
            }
            temp = null;
        } 
        System.out.println("Total number of node is:"+count());
    }

    //Traverse method for retriving data
    void traverse()
    {
        if(starter == null)
        {
            System.out.println("No node is created. Create node first.");
        }
        else
        {
            Node temp = starter;
            while (true) 
            {
                System.out.println("Data is: "+temp.data+"\t");
                if (temp.next == null) 
                {
                    break;
                }
                else
                {
                    temp = temp.next;
                }
            }
            System.out.println("Total number nodes are: "+count());
        }
        
    }

    //insert method for inserting data
	void insert() 
    {
		if(starter == null)	
        {
			System.out.println("No node is created.First u call create method.")	;
		} 
        else 
        {
			System.out.println("Enter the position where u insert a node.");
			int pos = get();
			Node temp ;
			temp = starter;
			if(( pos > 1 ) && (pos <= count()+1 ) ) 
            {
				for(int i = 1 ; i < (pos-1) ; i++) 
                {
					temp = temp.next ;
				}
				Node temp1 ;
				temp1 = temp.next ;
				Node new1 = new Node() ;
				System.out.println("Insert the data.");
				new1.data = get();
				new1.next = temp1 ;
				temp.next = new1	 ;
			}
			else if(pos == 1) 
            {
				Node new1 = new Node() ;
				new1.next = starter;
				starter = new1 ;
				System.out.println("Insert the data.") ;
				new1.data = get();
			} else 
            {
				System.out.println("!!!!!Invalid Position.!!!!!") ;
			}
		}
		System.out.println("Total nodes are : "+count())			;
	}

    //delete method for deleting nodes
	void delete() 
    {
		if(starter == null)	
        {
			System.out.println("No node is created.") ;
		} 
        else 
        {
			System.out.println("Press 1> for deleting the first node.")	;
			System.out.println("Press 2> for deleting the last node.");
			System.out.println("Press 3> for deleting any position.");
			System.out.println("Enter the node position whom u delete.");
			int pos = get() ;
			
			if(pos == 1) 
            {
				Node temp ;
				temp = starter ;
				starter = temp.next;
				temp.next = null;
				temp = null ;
			}
			else if(pos==2) 
            {
				Node temp1,temp2;
				temp1 = starter;
				temp2 = null ;
				while(temp1.next != null) 
                {
					temp2 = temp1 ;
					temp1 = temp1.next ;
				}
				temp1 = null;
				temp2.next = null;
			}
			else if(pos==3) 
            {
				System.out.println("Enter the position whom u delete.")		  ;
				int no = get();
				if(no > count()) 
                {
					System.out.println("!!!!!no Node is avaialable.!!!!");
				}
                else
                {
					Node temp1,temp2;
					temp1 = starter;
					temp2 = null ;
					for(int i = 1 ;i<(no-1);i++) 
                    {
						temp1 = temp1.next ;
					}
					temp2 = temp1.next ;
					temp1.next = temp2.next ;
					temp2 = null ;
					System.out.println("Node is deleted.");
				}
			}
            else
            {
				System.out.println("!!!!!Invalid Choice.!!!!");
			}
		}
				
		System.out.println("Total nodes are : "+count())	;
	}

	public static void main(String args[])	
    {
		SingleLinkedList ll = new SingleLinkedList();
		while(true) 
        {
			System.out.println("**SingleLinkedList Application.**");
			System.out.println("1>Create nodes. ");
			System.out.println("2>Traverse Nodes.");
			System.out.println("3>Insert Nodes.");
			System.out.println("4>Delete Node.");
			System.out.println("5>Quit.");
			System.out.print("Enter your choice:");
			int ch = get();
			switch(ch) 
            {
				case 1: 
					ll.create();
					break;
				case 2:
					ll.traverse();
					break;
				case 3:
					ll.insert();
					break;
				case 4:
					ll.delete();
					break;
				case 5:
				    System.out.println("!!!!!Thank you for using my Application.");
				    System.exit(0);
				
				default:
				    System.out.println("!!!!!Invalid Choice.!!!!!");
				    break;
			}
		}
	}
}
