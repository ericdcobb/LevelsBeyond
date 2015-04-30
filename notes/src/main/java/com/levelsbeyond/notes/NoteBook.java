package com.levelsbeyond.notes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class to collect and manage notes
 * @author Jason Harris
 *
 */
public class NoteBook {
	//TODO: Synchronize
	private Hashtable<Long,Note> noteList;
	private static NoteBook instance = new NoteBook();
	
	private NoteBook() {
		noteList = new Hashtable<Long,Note>();
	}
	
	/**
	 * Returns a singleton instance of NoteBook
	 * @return
	 */
	public static NoteBook getInstance( ) {
	      return instance;
	}
	
	/**
	 * This class adds a new Note to the collection. Duplicate Ids and 
	 * content are allowed. However, if an Id exists, the new Notes content will
	 * overwrite the existing content
	 * @param newNote The note to be added to the note book
	 */
	public void addNote(Note newNote) {
		noteList.put(new Long(newNote.getId()), newNote);
	}
	
	/**
	 * @param id the Note to be retrieved
	 * @return The Note with the given Id. If no Note exists with that Id, null is returned
	 */
	public Note getNote(long id) {
		return noteList.get(new Long(id));
	}
	
	/**
	 * @return All Notes in storage 
	 */
	public Collection<Note> getAllNotes() {
		return noteList.values();
	}
	
	/**
	 * Searches all stored Notes and returns those containing at least one. 
	 * instance of keyword
	 * @param keyword search term
	 * @return Notes containing at least one instance of keyword. If there are no
	 * matches an empty ArrayList is returned
	 */
	public ArrayList<Note> find(String keyword)
	{
		//TODO: Refactor
		ArrayList<Note> matches = new ArrayList<Note>();
		
		String patternString = "\\b(" + keyword + ")\\b";
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher;
		
		for (Enumeration<Note> e = noteList.elements(); e.hasMoreElements();) {
			Note nextNote = e.nextElement();
			
			matcher = pattern.matcher(nextNote.getContent());
			
			if (matcher.find())
			{
				matches.add(nextNote);
			}
		}
		
		return matches;
	}
	
}
