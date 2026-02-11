package com.example.notesmanager.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NoteRequestDTO {

	@NotBlank(message = "Title is required")
	private String title;

	@NotBlank(message = "Content is required")
	private String content;

}
