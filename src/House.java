/**
 * House class for the houses to stay for the students.
 * @author Taha Baturhan Akbulut
 *
 */
public class House implements Comparable<House> {
	/**
	 * ID of the house.
	 */
	int id;
	/**
	 * Remaining semesters to be untenanted.
	 */
	int duration;
	/**
	 * Rating of the house by various criterias like old, new, needs renovation, broken oven, broken shower, new kitchen, new bed etc.
	 */
	double rating;
	/**
	 * Constructor of the House class.
	 * @param id ID of the house.
	 * @param duration Remaining semesters to be untenanted.
	 * @param rating Rating of the house by various criterias like old, new, needs renovation, broken oven, broken shower, new kitchen, new bed etc.
	 */
	public House(int id, int duration, double rating){
		this.id=id;
		this.duration=duration;
		this.rating=rating;		
	}
	/**
	 * Implemented the function for Comparable interface to sort the houses by their IDs.
	 */
	@Override
	public int compareTo(House o) {
		if(o.id>this.id) {
			return -1;
		}
		else if(o.id<this.id) {
			return 1;
		}
		else {
			return 0;
		}
		
	}
	
}
