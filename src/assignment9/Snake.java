package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	
	
	//Snake moves by adding new head and removing tail every time
	//When it eats, you skip removing the tail which makes it grow
	public Snake() {
		//FIXME - set up the segments instance variable
		deltaX = 0;
		deltaY = 0;
		segments = new LinkedList<BodySegment>();
		BodySegment initial = new BodySegment (0.15, 0.5, SEGMENT_SIZE); 
		segments.add(initial);
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
			public void move() {
		    //start from back and reverse so that each additional segment connects to back
		    for (int i = segments.size() - 1; i > 0; i--) {
		        BodySegment currentSegment = segments.get(i);
		        BodySegment previousSegment = segments.get(i - 1);
		        currentSegment.setX(previousSegment.getX());
		        currentSegment.setY(previousSegment.getY());
		    }

		    // move head based on key direction
		    BodySegment head = segments.getFirst();
		    double headx = head.getX() + deltaX;
		    double heady = head.getY() + deltaY;
		    head.setX(headx);
		    head.setY(heady);
		}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		for (BodySegment segment : segments) {
			segment.draw();
		}
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	//Uses boolean to check if snake is close enough to Food f, if true then adds new segment
	public boolean eatFood(Food f) {
		if (f != null) {
			double foodx = f.getX();
			double foody = f.getY();
			double distance = Math.sqrt(Math.pow(segments.getFirst().getX()-foodx, 2)+Math.pow(segments.getFirst().getY()-foody, 2));
			double minDist = SEGMENT_SIZE * 2;
			
			if (distance <= minDist) {
			    double tailx = segments.get(segments.size() - 1).getX() - deltaX;
			    double taily = segments.get(segments.size() - 1).getY() - deltaY;
			    segments.add(new BodySegment(tailx, taily, SEGMENT_SIZE)); // Add new segment
			    return true;
			} else { 
				return false;
			}
		}
		return false;
		}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		double headx = segments.getFirst().getX();
		double heady = segments.getFirst().getY();
		return headx > 0 && headx < 1 && heady > 0 && heady < 1;
		
	}
}
