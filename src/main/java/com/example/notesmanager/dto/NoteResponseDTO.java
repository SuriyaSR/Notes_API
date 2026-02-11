package com.example.notesmanager.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NoteResponseDTO {

	private String id;
	private String title;
	private String content;
	private Instant lastModified;

}
