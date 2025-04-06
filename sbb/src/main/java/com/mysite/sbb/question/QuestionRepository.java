package com.mysite.sbb.question;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


// public - 엔티티가 세팅한 디비를 씨알유디 할 인터페이스 
// Question -
// Question -
// List -
// Page -
// Page - findAll - 콜받으면 페이지어블 클래스를 사용해서 페이지 자료형 타입 오브젝을 리턴
// @Query - 
// Page - 
public interface QuestionRepository extends JpaRepository<Question, Integer> {
	Question findBySubject(String subject);

	Question findBySubjectAndContent(String subject, String content);

	List<Question> findBySubjectLike(String subject);

	// Question findBySubject(String subject);
	// Question findBySubjectAndContent(String subject, String content);
	// List<Question> findBySubjectLike(String subject);
	Page<Question> findAll(Pageable pageable);

	Page<Question> findAll(Specification<Question> spec, Pageable pageable);
	
	@Query("select "
            + "distinct q "
            + "from Question q " 
            + "left outer join SiteUser u1 on q.author=u1 "
            + "left outer join Answer a on a.question=q "
            + "left outer join SiteUser u2 on a.author=u2 "
            + "where "
            + "   q.subject like %:kw% "
            + "   or q.content like %:kw% "
            + "   or u1.username like %:kw% "
            + "   or a.content like %:kw% "
            + "   or u2.username like %:kw% ")
    Page<Question> findAllByKeyword(@Param("kw") String kw, Pageable pageable);
}
