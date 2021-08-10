package com.cognizant.membermicroservice.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * This class test the FileNotFoundException class
 * 
 *
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class RecordNotFoundExceptionTest {

	@Mock
	private RecordNotFoundException fileNotFoundException;

	@Test
	public void testOneArgConstructor() {
		RecordNotFoundException exception = new RecordNotFoundException("File Not Found.");
		assertEquals("File Not Found.", exception.getMessage());
	}

	@Test
	public void testNoArgConstructor() {
		RecordNotFoundException exception = new RecordNotFoundException();
		assertEquals(null, exception.getMessage());
	}
}
