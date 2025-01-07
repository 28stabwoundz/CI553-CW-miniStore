package clients.customer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import clients.customer.NameToNumber;

import org.junit.jupiter.api.Test;

class NameToNumberTest{

	@Test
	void testValidNameToNumber() {
		NameToNumber nameToNumber = new NameToNumber();
		
		assertEquals("0001", nameToNumber.getNumberFromName(nameToNumber, "TV"), "TV should return 0001.");
        assertEquals("0005", nameToNumber.getNumberFromName(nameToNumber, "Camera"), "Camera should return 0005.");
        assertEquals("0007", nameToNumber.getNumberFromName(nameToNumber, "USB"), "USB should return 0007.");
		
		
		
	}
	
	
	@Test
	void testInvalidNameToNumber() {
		NameToNumber nameToNumber = new NameToNumber();
		
		assertNull(nameToNumber.getNumberFromName(nameToNumber, ""), "An empty name should return invalid.");
		
	}

}
