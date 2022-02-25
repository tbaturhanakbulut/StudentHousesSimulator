import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/**
 * ControllerSystem class which controls the main operations of the Datalonya
 * @author Taha Baturhan Akbulut
 *
 */
public class ControllerSystem {
	
	/**
	 * Control function to make matching operations until all the students graduate.
	 * @param studentsList
	 * @param housesList
	 */
	public static void control(ArrayList<Student> studentsList, ArrayList<House> housesList) {
		//Sorting the lists by the elements' IDs
		Collections.sort(studentsList);
		Collections.sort(housesList);
		//check if all the durations of studets are zero. 
		boolean check=true;
				
		//Temp ArrayList for the rented houses
		ArrayList<House> tempHouses= new ArrayList<House>();
		for(int i = 0; i< housesList.size();i++) {
			if(housesList.get(i).duration>0) {
				tempHouses.add(housesList.get(i));
				housesList.remove(housesList.get(i));
				i--;
						
			}
		}
		//Main operations for matching the empty houses with the students who have more semesters to study.
		while(!(housesList.isEmpty() && tempHouses.isEmpty()) && !studentsList.isEmpty()&&check) {
			check=false;			
			for(Iterator<Student> iter= studentsList.iterator(); iter.hasNext();) {
				Student s=iter.next();
				for(House h:housesList) {
					if(s.duration>0 && h.duration==0) {
						if(h.rating>=s.rating) {
							h.duration=s.duration;	
							iter.remove();
							break;
						}
					}
				}
			}
			for(Student s: studentsList) {
				if(s.duration>0) 
					s.duration-=1;
				if(s.duration==0) {
					continue;	
				}
				check=true;		
			}
			//Operations between the tempHouses list and main housesList to put the rented houses into tempHouses.
			for(int i = 0; i< housesList.size();i++) {
				if(housesList.get(i).duration>0) {
					tempHouses.add(housesList.get(i));
					housesList.remove(housesList.get(i));
					i--;
					
				}
			}
			//Operations between the tempHouses list and main housesList to put the free houses into housesList.
			for(int i = 0; i< tempHouses.size();i++) {
				tempHouses.get(i).duration-=1;
				if(tempHouses.get(i).duration==0) {
					housesList.add(tempHouses.get(i));
					tempHouses.remove(tempHouses.get(i));
					i--;
				}
			}			
			Collections.sort(housesList);
		}	
	}
	
	
}
