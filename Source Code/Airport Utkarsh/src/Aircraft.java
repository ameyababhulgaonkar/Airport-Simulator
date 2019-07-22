
public class Aircraft {
	public int ID;
	public float minwaittime = 0;
	//static int freedplane;
	Node position;
	public float standtime = 0;
	public float waittime = 0;
	
	public Aircraft()
	{
		this.ID = 0001;
	}
	
	public int freedplane = 0;
	
	public Aircraft(int ID , Node position)
	{
		this.ID = ID;
		this.position = position;
		position.occupy();
	}
	
	public void goto_next_position()
	{
		Node temp = this.position;
		this.position = this.position.goto_next_node();
		temp.reset();
		this.position.occupy();
	}
	

    public void show_position() 
    {
    
    	System.out.println("Plane : "+ ID + " Current Position :" );
    	 this.position.show_index();
    	 System.out.println();
    }
 
    public void check_availability(float time)
    {
    	if (this.position.isterminal()) {
    		free();
    	}
    	else
    	{
    		if ((this.position.goto_next_node() != this.position) && time >= minwaittime) {
    			goto_next_position();
    			minwaittime = time + position.duration;
    		}
    		else
    			wait(time);
    	}
    }

    public void show_all(Aircraft arr[], int numberofplane) {
    	int i = 0;
    	while (i< numberofplane) {
    		arr[i].show_position();
    		i++;
    	}
    }

   public  void goto_all(Aircraft arr[],  int numberofplanes) {
    	int i = 0;
    	while (i<numberofplanes) {
    		arr[i].goto_next_position();
    		i++;
    	}
    }

   public void update_all(Aircraft arr[], int numberofplane, float time) {
    	int i = 0;
    	while (i< numberofplane) {
    		arr[i].check_availability(time);
    		i=i+1;
    	}
    };

   public void free() {
    	position.reset();
    	freedplane++;
    	System.out.println("Plane Freed");
    }

    public void wait(float time) {
    	if (time >= minwaittime)
    		waittime++;
    	else{
    		System.out.println("\n standing at ");
    		position.show_index();
    	}

    }
	
	
}
