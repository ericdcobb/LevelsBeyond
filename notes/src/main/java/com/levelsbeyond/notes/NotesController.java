package com.levelsbeyond.notes;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotesController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/api/notes", method = RequestMethod.POST)
    public Note addNote(@RequestBody String input) {
    	Note newNote = new Note(counter.incrementAndGet(), input);
    	NoteBook.getInstance().addNote(newNote);
    	return newNote;
    }

    @RequestMapping(value = "/api/notes/{id}", method = RequestMethod.GET)
    public Note getNote(@PathVariable long id) {
        return NoteBook.getInstance().getNote(id);
    }
    
    @RequestMapping(value = "/api/notes", method = RequestMethod.GET)
    public Collection<Note> getAllNotes(@RequestParam(value="query", defaultValue="") String keyword) {
        
    	if(keyword.isEmpty())
    	{
    		return NoteBook.getInstance().getAllNotes();
    	}
    	
    	return NoteBook.getInstance().find(keyword);
    	
    }
}
