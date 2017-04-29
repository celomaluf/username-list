package br.com.unl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.unl.model.dto.UNLDTO;
import br.com.unl.model.entity.Result;

public class UNLTest {
	
	private static final int POSSIBLE_USERNAMES_SIZE = 14;
	
	@Test
	public void assertDuplicateUsernameTest() {
		Result result = UNLDTO.addUsername("john");
		assertTrue("Username successfully registered", result.isValidUsername());
		
		Result result2 = UNLDTO.addUsername("john");		
		assertFalse("Duplicated Username", result2.isValidUsername());
		
		Result result3 = UNLDTO.addUsername("john123");
		assertTrue("Username successfully registered", result3.isValidUsername());
		
		Result result4 = UNLDTO.addUsername("john123");		
		assertFalse("Duplicated Username", result4.isValidUsername());
		
	}
	
	
	@Test
	public void assertIfUsernameContainsRestrictedWord() {
		Result result = UNLDTO.addUsername("marcelo");
		assertTrue("Username doesn't contain any restricted words", result.isValidRestrictedWord());
		
		Result result2 = UNLDTO.addUsername("drunkjohn");
		assertFalse("Username contains restricted words", result2.isValidRestrictedWord());
	}
	
	@Test
	public void assertPossibleUsernamesWhenDuplicated () {
		Result result = UNLDTO.addUsername("pelé");
		assertTrue("Username successfully registered", result.isValidUsername());
		
		Result result2 = UNLDTO.addUsername("pelé");		
		assertTrue("The possible list of suggested usernames should have 14 options", result2.getPossibleUsernames().size() == POSSIBLE_USERNAMES_SIZE);
	}
}