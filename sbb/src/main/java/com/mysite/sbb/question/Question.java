package com.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.user.SiteUser;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

// @Getter - 게터 자동생성
// @Setter - 세터 자동생성 - 엔티티는 세터 사용안함 - 여기선 레슨용으로 사용
// @Entity - 엔티티 선언 
// public - 페어런츠
// @Id - pk 지정 - 중복되면 안되는 기본키
// @GeneratedValue - 데이터 생성될때 넘버 알아서 1씩 증가
// private -

// @Column - 텍스트 200으로 제한
// private - 

// ? @Column - 텍스트 제한없음
// private

// private - 데이터 생성 시간

// @OneToMany - 퀘스천은 하나고 앤서는 많음 - 페어런츠와 칠드런 연결 - 칠드런과 연결하기 위해 맵드바이에 페어런트가 누군지 전달 - 페어런트가 삭제 되면 이 칠드런의 다수의 데이터를 모두 한방에 삭제
// private - 페어런트가 칠드런을 사용해야 하므로 칠드런을 엔티티 속성으로 추가 - 칠드런이 다수이므로 오브젝트를 리스트 자료형으로 세입

@Getter
@Setter
@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 200)
	private String subject;

	@Column(columnDefinition = "TEXT")
	private String content;

	private LocalDateTime createDate;

	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
	private List<Answer> answerList;

	@ManyToOne
	private SiteUser author;

	private LocalDateTime modifyDate;
	
	@ManyToMany
    Set<SiteUser> voter;
}
