package Task_1;

import java.time.LocalDate;

public class Friend {
	private String nickName; 
	private String name; 
	private String birthDate; 
	
	public Friend(String nickName, String name, String birthDate) {
		this.nickName = nickName; 
		this.name = name; 
		this.birthDate = birthDate; 
	}
	
	public String getNickName() {
		return nickName; 
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName; 
	}
	
	public String getName() {
		return name; 
	}
	
	public void setName(String name) {
		this.name = name; 
	}

	public String getBirthDate() {
		return birthDate; 
	}
	
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate; 
	}
	
	public String toString() {
		return nickName + ":" + name + ", born " + birthDate ; 
	}
}

