package org.zerock.domain;

import java.text.DateFormat;
import java.util.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {
	private String todo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dueDate;
}
