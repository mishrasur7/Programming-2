package Task_1;

import java.util.HashMap;
import java.util.Map;

public class ObjectsCourseMapProgram {

	public static void main(String[] args) {
		Course course1 = new Course("swd1tf001", "Orientation to Software Engineering", 5);
		Course course2 = new Course("swd4tf033", "Programming 2", 5);
		Course course3 = new Course("swd4tf032", "Programming 1", 5);

		Map<String, Course> courseMap = new HashMap<String, Course>();
		courseMap.put(course1.getCourseCode(), course1);
		courseMap.put(course2.getCourseCode(), course2);
		courseMap.put(course3.getCourseCode(), course3);
		
		for(Course courses : courseMap.values()) {
			System.out.println(courses);
		}
		
		System.out.println("---");
		
		Course course = courseMap.get("swd4tf033");
		
		System.out.println(course);

	}

}
