package plot;


public class Plot{
	// attributes
	private int x;
	private int y;
	private int width;
	private int depth;
	
	// constructors
	public Plot() {
		this.x=0;
		this.y=0;
		this.width=1;
		this.depth=1;
	}
	
	 public Plot(int x, int y, int width, int depth) {
	        this.x = x;
	        this.y = y;
	        this.width = width;
	        this.depth = depth;
	    }
	 // copy constructor
	 public Plot(Plot otherPlot) {
	        this(otherPlot.x, otherPlot.y, otherPlot.width, otherPlot.depth);
	    }
	 
	 // getter and setter method
	 public int getX() { return x; }
	    public int getY() { return y; }
	    public int getWidth() { return width; }
	    public int getDepth() { return depth; }

	    public void setX(int x) { this.x = x; }
	    public void setY(int y) { this.y = y; }
	    public void setWidth(int width) { this.width = width; }
	    public void setDepth(int depth) { this.depth = depth; }
	    
	    //// Determines if current plot overlaps another
	    public boolean overlaps(Plot other) {
	        if (other == null) return false;

	        boolean noOverlap =
	            other.x + other.width <= this.x ||
	            other.x >= this.x + this.width ||
	            other.y + other.depth <= this.y ||
	            other.y >= this.y + this.depth;

	        return !noOverlap;
	    }
	    
	    // determines if current plot contains another
	    public boolean encompasses(Plot other) {
	        if (other == null) return false;

	        return (other.x >= this.x &&
	                other.y >= this.y &&
	                other.x + other.width <= this.x + this.width &&
	                other.y + other.depth <= this.y + this.depth);
	    }

	    //toString method to represent a Plot instance
	    @Override
	    public String toString() {
	        return x + "," + y + "," + width + "," + depth;
	    }
	}

