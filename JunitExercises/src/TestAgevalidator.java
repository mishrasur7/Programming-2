import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestAgevalidator {

	@Test
	void testMinorValidate() {
		assertEquals("minor", AgeValidator.validate(13));;
	}
	
	@Test
	void testAdultValidate() {
		assertEquals("adult", AgeValidator.validate(90));;
	}
	
	@Test
	void testInvalidValidate() {
		assertEquals("invalid age", AgeValidator.validate(133));;
	}
}
