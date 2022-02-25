import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * project1main Main Class for the Project
 * @author Taha Baturhan Akbulut
 *
 */
public class project1main {
	public static void main(String[] args) throws IOException  {
		//Declarations for the file operations
		File myInputFile = new File("//Users//tahaakbulut//Downloads//project1//src//input.txt");
		File myOutputFile = new File("//Users//tahaakbulut//Downloads//project1//src//output.txt");
		FileWriter myWriter = new FileWriter(myOutputFile);	
		Scanner sc=new Scanner(myInputFile);
		
		/**
		 * ArrayList for students
		 */
		ArrayList<Student> studentsList = new ArrayList<>();
		/**
		 * ArrayList for houses
		 */
		ArrayList<House> housesList = new ArrayList<>();
		
		//Input readings
		while(sc.hasNextLine()) {
			String myLine=sc.nextLine();
			String[] lineList=myLine.split(" ");
			if(lineList[0].equals("h")) {
				int id=Integer.parseInt(lineList[1]);
				int duration=Integer.parseInt(lineList[2]);
				double rating=Double.parseDouble(lineList[3]);
				House house= new House(id,duration,rating);
				housesList.add(house);
			}
			else if(lineList[0].equals("s")) {
				int id=Integer.parseInt(lineList[1]);
				String name=lineList[2];
				int duration=Integer.parseInt(lineList[3]);
				double rating=Double.parseDouble(lineList[4]);
				Student student = new Student(id,name,duration,rating);
				studentsList.add(student);
			}			
		}
		//calling the ControllerSystem static function
		ControllerSystem.control(studentsList, housesList);

		//writing the students to the file
		for(Student s: studentsList) {
			myWriter.write(s.name + "\n");
		}	
		sc.close();
		myWriter.close();
	}
}
