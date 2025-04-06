package com.mysite.sbb.answer;

import java.time.LocalDateTime;
import java.util.Set;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.user.SiteUser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

// @Getter - 게터 자동생성
// @Setter - 세터 자동생성 - 엔티티는 세터 사용안함 - 여기선 레슨용으로 사용
// @Entity - 엔티티 선언
// public - 칠드런
// @Id - pk 지정
// @GeneratedValue - 데이터 넘버 알아서 1씩 증가
// private -

// ? @Column - 텍스트 제한없음
// private - 

// private - 데이터 생성 시간

// @ManyToOne - 앤서는 많고 퀘스천은 하나 - 페어런츠와 칠드런 연결
// private - 퀘스천 엔티티 참조

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

	@ManyToOne
	private SiteUser author;

	private LocalDateTime modifyDate;
	
	@ManyToMany
    Set<SiteUser> voter;
}
