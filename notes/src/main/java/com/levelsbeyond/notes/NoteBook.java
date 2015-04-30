package com.levelsbeyond.notes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;

public class NoteBook {
	//TODO: Synchronize
	private Hashtable<Long,Note> noteList;
	private static NoteBook instance = new NoteBook();
	
	private NoteBook() {
		noteList = new Hashtable<Long,Note>();
	}
	
	public static NoteBook getInstance( ) {
	      return instance;
	}
	
	public void addNote(Note newNote) {
		noteList.put(new Long(newNote.getId()), newNote);
	}
	
	public Note getNote(long id) {
		return noteList.get(new Long(id));
	}
	
	public Collection<Note> getAllNotes() {
		return noteList.values();
	}
	
	public ArrayList<Note> find(String keyword)
	{
		//TODO: Refactor
		ArrayList<Note> matches = new ArrayList<Note>();
		for (Enumeration<Note> e = noteList.elements(); e.hasMoreElements();) {
			Note nextNote = e.nextElement();
			if (nextNote.getContent().indexOf(keyword) != -1)
			{
				matches.add(nextNote);
			}
		}
		
		return matches;
	}
	
}
