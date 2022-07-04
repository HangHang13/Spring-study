package com.mysite.sbb.answer;
import java.time.LocalDateTime;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToOne;

import com.mysite.sbb.question.Question;


@Getter
@Setter
@Entity
public class Answer {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;

	 @Column(columnDefinition = "TEXT")
	 private String content;

	 private LocalDateTime createDate;
	 
	 @ManyToOne
	 private Question question;
}
