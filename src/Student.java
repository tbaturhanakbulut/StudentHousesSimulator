/**
 * Student class for the students at the university.
 * @author Taha Baturhan Akbulut
 *
 */
public class Student implements Comparable<Student> {
	/**
	 * ID of the Student
	 */
	int id;
	/**
	 * Name of the Student
	 */
	String name;
	/**
	 * Remaining number of semesters of the student at the university
	 */
	int duration;
	/**
	 * The student's minimum house rating to live in that house.
	 */
	double rating;
	/**
	 * Constructor of the Student class.
	 * @param id ID of the Student
	 * @param name Name of the Student
	 * @param duration Remaining number of semesters of the student at the university
	 * @param rating The student's minimum house rating to live in that house.
	 */
	public Student(int id, String name, int duration, double rating) {
		this.id=id;
		this.name=name;
		this.duration=duration;
		this.rating=rating;
	}
	/**
	 * Implemented the function for Comparable interface to sort the students by their IDs.
	 */
	@Override
	public int compareTo(Student o) {
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
