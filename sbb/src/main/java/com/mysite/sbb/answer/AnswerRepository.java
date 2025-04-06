package com.mysite.sbb.answer;

import org.springframework.data.jpa.repository.JpaRepository;

// public - 엔티티가 세팅한 디비를 씨알유디 할 인터페이스
public interface AnswerRepository extends JpaRepository<Answer, Integer> {

}
