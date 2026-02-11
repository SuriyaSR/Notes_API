package com.example.notesmanager.mapper;
import com.example.notesmanager.dto.NoteRequestDTO;
import com.example.notesmanager.dto.NoteResponseDTO;
import com.example.notesmanager.notes.Note;

public class NoteMapper {

    public static Note toEntity(NoteRequestDTO dto) {
        Note note = new Note();
        note.setTitle(dto.getTitle());
        note.setContent(dto.getContent());
        return note;
    }

    public static NoteResponseDTO toResponse(Note note) {
        return new NoteResponseDTO(
                note.getId(),
                note.getTitle(),
                note.getContent(),
                note.getLastModified());
    }
}

