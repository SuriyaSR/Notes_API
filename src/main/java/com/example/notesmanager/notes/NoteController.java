package com.example.notesmanager.notes;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.notesmanager.dto.NoteRequestDTO;
import com.example.notesmanager.dto.NoteResponseDTO;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class NoteController {

	private final NoteService noteService;
	
	@GetMapping("/")
	public String home() {
	    return "Notes API is running!";
	}

	@Operation(summary = "Create a new note")
	@PostMapping("/note")
	public ResponseEntity<NoteResponseDTO> saveNote(@Valid @RequestBody NoteRequestDTO dto) {
//		return ResponseEntity.ok(noteService.createNote(dto));
		NoteResponseDTO created = noteService.createNote(dto);
		URI location = URI.create("/api/v1/note/" + created.getId());

		return ResponseEntity
		        .created(location)
	            .body(created);
	}

	@GetMapping("/note/{noteId}")
	public ResponseEntity<NoteResponseDTO> getNote(@PathVariable String noteId) {
		return ResponseEntity.ok(noteService.getNoteById(noteId));
	}

	@GetMapping("/notes")
	public ResponseEntity<List<NoteResponseDTO>> getAllNotes() {
		return ResponseEntity.ok(noteService.getAllNotes());
	}

	@DeleteMapping("/note/{noteId}")
	public ResponseEntity<Void> deleteNote(@PathVariable String noteId) {
		noteService.deleteNote(noteId);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/note/{noteId}")
	public ResponseEntity<NoteResponseDTO> updateNote(@PathVariable String noteId,
			@Valid @RequestBody NoteRequestDTO dto) {
		return ResponseEntity.ok(noteService.updateNote(noteId, dto));
	}
}
