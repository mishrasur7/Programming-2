
public class AgeValidator {
	
	public static String validate(int age) {
		String outPut; 
		if(age >= 0 && age <= 17) {
			outPut = "minor"; 
		} else if(age >= 18 && age <= 120) {
			outPut = "adult"; 
		} else {
			outPut = "invalid age"; 
		}
		return outPut; 
	}

}
