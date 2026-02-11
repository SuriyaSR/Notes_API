package com.example.notesmanager.notes;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "notes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Note {

	@Id
	private String id;

	private String title;

	private String content;

	@CreatedDate
	private Instant createdAt;

	@LastModifiedDate
	private Instant lastModified;

}
