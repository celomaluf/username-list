package br.com.unl.model.dto;

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;

import br.com.unl.model.entity.Result;

/**
 * @author Marcelo Maluf Teixeira
 *
 */
public class UNLDTO {

	private static Set<String> usernames = new TreeSet<String>();
	private static Set<String> restrictedWords = initialRestrictedWords(); 
	
	public static Result addUsername(String username) {		
		Result result = new Result();
		result.setValidRestrictedWord(checkRestrictedWords(username));
		if ( !result.isValidRestrictedWord() ) {
			return result;
		}

		result.setValidUsername(checkDuplicates(username));		
		if ( !result.isValidUsername()) {
			result.setPossibleUsernames(createPossibleUsernames(username));
			return result;
		}
		usernames.add(username);
		return result;
	}
	
	private static boolean checkDuplicates(String username) {
		for ( String un : usernames) {
			if ( un.equalsIgnoreCase(username ) ) {
				return false;
			}
		}
		return true;
	}

	private static Set<String> createPossibleUsernames(String username) {
		Set<String> possibleUsernames = new TreeSet<String>();
		for ( int x = 0; x < 14; x ++) {
			String possibleUsername = username + ThreadLocalRandom.current().nextInt(1, 9999);
			if ( checkDuplicates(possibleUsername)) {
				possibleUsernames.add(possibleUsername);
				continue;
			}
			x--;
		}
		return possibleUsernames;
	}
	/* ********************************************
	 ************ DICTIONARY OF WORDS *************
	 **********************************************/
	
	private static Set<String>  initialRestrictedWords() {
		Set<String> _restrictedWords = new TreeSet<String>();
		_restrictedWords.add("cannabis");
		_restrictedWords.add("crack");
		_restrictedWords.add("damn");
		_restrictedWords.add("abuse");
		_restrictedWords.add("drunk");
		_restrictedWords.add("grass");
		_restrictedWords.add("shit");
		_restrictedWords.add("fuck");
		_restrictedWords.add("cocain");
		_restrictedWords.add("drugdealer");
		return _restrictedWords;
	}
	
	private static boolean checkRestrictedWords(String username) {
		for (String restrictedWord : restrictedWords) {
			boolean containsRestrictedWord = Pattern.compile(Pattern.quote(restrictedWord), Pattern.CASE_INSENSITIVE).matcher(username).find(); 
			if ( containsRestrictedWord) {
				return false;
			}
		}
		return true;
	}

	public static Set<String> addRestrictedWord(String restrictedWord) {
		for (String rw : restrictedWords) {
			if (rw.equalsIgnoreCase(restrictedWord)) {
				return restrictedWords;
			}
		}
		restrictedWords.add(restrictedWord);
		return restrictedWords;
	}
	
	public static Set<String>  getRestrictedWords() {
		return restrictedWords;
	}
}