package com.mysite.sbb;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.Optional;

import java.util.List;
@SpringBootTest
class SbbApplicationTests {
	

	@Autowired
    private QuestionRepository questionRepository;

//    @Test
//    void testJpa() {        
//        Question q1 = new Question();
//        q1.setSubject("sbb�� �����ΰ���?");
//        q1.setContent("sbb�� ���ؼ� �˰� �ͽ��ϴ�.");
//        q1.setCreateDate(LocalDateTime.now());
//        this.questionRepository.save(q1);  // ù��° ���� ����
//
//        Question q2 = new Question();
//        q2.setSubject("��������Ʈ �� �����Դϴ�.");
//        q2.setContent("id�� �ڵ����� �����ǳ���?");
//        q2.setCreateDate(LocalDateTime.now());
//        this.questionRepository.save(q2);  // �ι�° ���� ����
//}
//	@Test
//    void testJpa() {
//        List<Question> all = this.questionRepository.findAll();
//        assertEquals(2, all.size());
//
//        Question q = all.get(0);
//        assertEquals("sbb�� �����ΰ���?", q.getSubject());
//    }
//	@Test
//    void testJpa() {
//        Optional<Question> oq = this.questionRepository.findById(1);
//        if(oq.isPresent()) {
//            Question q = oq.get();
//            assertEquals("sbb�� �����ΰ���?", q.getSubject());
//        }
//	@Test
//    void testJpa() {
//        Question q = this.questionRepository.findBySubject("sbb�� �����ΰ���?");
//        assertEquals(1, q.getId());
//    }
//	@Test
//    void testJpa() {
//        Question q = this.questionRepository.findBySubjectAndContent(
//                "sbb�� �����ΰ���?", "sbb�� ���ؼ� �˰� �ͽ��ϴ�.");
//        assertEquals(1, q.getId());
//    }
//	@Test
//    void testJpa() {
//        List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
//        Question q = qList.get(0);
//        assertEquals("sbb�� �����ΰ���?", q.getSubject());
//    }
	@Test
    void testJpa() {
        Optional<Question> oq = this.questionRepository.findById(1);
        assertTrue(oq.isPresent());
        Question q = oq.get();
        q.setSubject("������ ����");
        this.questionRepository.save(q);
    }
}