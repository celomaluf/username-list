package br.com.unl.model.entity;

import java.util.Set;
import java.util.TreeSet;

public class Result {

	private Set<String> possibleUsernames = new TreeSet<String>();
	private Set<String> restrictedWords = new TreeSet<String>();
	private boolean validUsername;
	private boolean validRestrictedWord;

	public Result() {
		this.setValidRestrictedWord(true);
		this.setValidUsername(true);
	}

	public Set<String> getPossibleUsernames() {
		return possibleUsernames;
	}

	public void setPossibleUsernames(Set<String> possibleUsernames) {
		this.possibleUsernames = possibleUsernames;
	}
	
	public Set<String> getRestrictedWords() {
		return restrictedWords;
	}
	
	public void setRestrictedWords(Set<String>restrictedWords) {
		this.restrictedWords = restrictedWords;
	}

	@Override
	public String toString() {
		return  "Result{" +
				"	possibleUsernames= " + this.possibleUsernames + 
				"  ,restrictedWords= " + this.restrictedWords +  
				"}";
	}

	public boolean isValidUsername() {
		return validUsername;
	}

	public void setValidUsername(boolean validUsername) {
		this.validUsername = validUsername;
	}

	public boolean isValidRestrictedWord() {
		return validRestrictedWord;
	}

	public void setValidRestrictedWord(boolean validRestrictedWord) {
		this.validRestrictedWord = validRestrictedWord;
	}
}