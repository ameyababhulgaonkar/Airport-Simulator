
public class Node {

	int countspace = 0;
	int index;
	boolean state = true;
	
	Node next1 = null;
	Node next2 = null;
	
	float duration;
	
	public Node()
	{
		this.duration = 0;
		this.index = 0;
	}
	public Node(int i,float t)
	{
		this.duration = t;
		this.index = i;
	}
	
	public boolean isvacant()
	{
		if(this != null)
		{
			return this.state;
		}
		else
		{
			System.out.println("isvacant : empty node");
			return false;
		}
		
		
	}
	
	public boolean isterminal()
	{
		if(this.next1 == null && this.next2 == null )
		{
			return true;
		}
		else
			return false;
	}
	
	 public void link(Node n1 )
	 {
		 if(this.next1 != null)
			 this.next1 = n1;
		 else if(this.next2 != null)
		 {
			 this.next2 = n1 ;
		 }
		 else
		 {
			 System.out.println("Link : node already linked ");
		 }
	 }
//	 public void show_network()
//	 {
//		if(this != null)
//		{
//			System.out.println(this.index+"-> "+ countspace++);
//			this.next1.show_network();
//			
//		}
//	 }
	 
	 public void show_index()
	 {
		 if(this != null)
		 {
			 System.out.println(index);
		 }
		 else
			 System.out.println("Show index : Empty node");
	 }
	 
	 public Node goto_next_node()
	 {
		 Node nextnode = this;
		 if(this != null)
		 {
			 if(this.isterminal())
			 {
				 System.out.println( " goto next node : terminal node");
				 return nextnode;
			 }
			 else
			 {
				  if (this.next1.isvacant())
						return this.next1;
				 else if (this.next1.isvacant())
						return this.next2;
				else 
				{
							System.out.println("You have to wait");
							return this;
					}
			 }
		 }
		 else
		 {
			 System.out.println("Goto next node :: Empty Node ");
			 return nextnode;
		 }
	 }
	 
	 public void occupy()
	 {
		 this.state = false;
	 }
	 public void reset()
	 {
		 this.state = true;
	 }
	public void print(char x, int n)
	{
		for(int i=0;i<n;i++)
		{
			System.out.print(x);
		}
	}
	
	
	
}
