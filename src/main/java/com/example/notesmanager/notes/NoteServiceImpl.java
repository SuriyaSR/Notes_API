package com.example.notesmanager.notes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.notesmanager.dto.NoteRequestDTO;
import com.example.notesmanager.dto.NoteResponseDTO;
import com.example.notesmanager.exception.NoteNotFoundException;
import com.example.notesmanager.mapper.NoteMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

	private final NoteRepository noteRepository;

	@Override
	public NoteResponseDTO createNote(NoteRequestDTO dto) {
		Note note = NoteMapper.toEntity(dto);
		Note saved = noteRepository.save(note);

		return NoteMapper.toResponse(saved);
	}

	@Override
	public List<NoteResponseDTO> getAllNotes() {
		return noteRepository.findAll().stream().map(NoteMapper::toResponse).toList();
	}

	@Override
	public NoteResponseDTO getNoteById(String id) {
		Note note = noteRepository.findById(id).orElseThrow(() -> new NoteNotFoundException("Note not found"));

		return NoteMapper.toResponse(note);
	}

	@Override
	public NoteResponseDTO updateNote(String id, NoteRequestDTO dto) {
		Note note = noteRepository.findById(id).orElseThrow(() -> new NoteNotFoundException("Note not found"));

		if (dto.getTitle() != null) {
			note.setTitle(dto.getTitle().trim());
		}

		if (dto.getContent() != null) {
			note.setContent(dto.getContent().trim());
		}

		return NoteMapper.toResponse(noteRepository.save(note));
	}

	@Override
	public Boolean deleteNote(String id) {
		if (!noteRepository.existsById(id)) {
			throw new NoteNotFoundException("Note not found with id: " + id);
		}

		noteRepository.deleteById(id);
		return true;
	}
}
