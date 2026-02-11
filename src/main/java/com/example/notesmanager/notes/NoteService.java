package com.example.notesmanager.notes;

import java.util.List;

import com.example.notesmanager.dto.NoteRequestDTO;
import com.example.notesmanager.dto.NoteResponseDTO;

public interface NoteService {
	
	NoteResponseDTO createNote(NoteRequestDTO note);
	
	List<NoteResponseDTO> getAllNotes();
	
	NoteResponseDTO getNoteById(String id);
	
	NoteResponseDTO updateNote(String id, NoteRequestDTO dto);
	
	Boolean deleteNote(String id);
}
