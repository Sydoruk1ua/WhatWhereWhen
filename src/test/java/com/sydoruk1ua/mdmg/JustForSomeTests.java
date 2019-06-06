package com.sydoruk1ua.mdmg;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class JustForSomeTests {
    private static final String PASSWORD_REGEX = "^(?=.*?[A-ZА-Я])(?=.*?[a-zа-я])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{6,45}$";
    private static final String PASSWORD_REGEX1 = "^(?=.*\\d).{6,45}$";
    private static final String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"" +
            "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])" +
            "*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4]" +
            "[0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-" +
            "\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])";
    private static final String LAST_NAME_REGEX = "[а-яА-ЯёЁa-zA-Z`-]{1,45}+";


    @Test
    public void testRegex() {
        String email = "alex_test@ukr.net_f649db64bf5927c632ad11b417c51e72";
        String password = "f649db64bf5927c632ad11b417c51e72";

        assertEquals(password, DigestUtils.md2Hex("user1pass"));
        assertFalse("1023568".matches(PASSWORD_REGEX));
        assertTrue("nataliya.trachpasS1!".matches(PASSWORD_REGEX));
        assertTrue("nataliyatra chpasS1!".matches(PASSWORD_REGEX));
        assertFalse("nataliyatra chpas".matches(PASSWORD_REGEX));
        assertTrue("natalyatra chpaS1.&".matches(PASSWORD_REGEX));
        assertTrue("natalyatraК chpaS1.&".matches(PASSWORD_REGEX));
        assertTrue("natalyatraпё chpaS1.&".matches(PASSWORD_REGEX));
        assertTrue("user1@gmail.com".matches(EMAIL_REGEX));
        assertTrue("user1@gmail.comdfsssssssssssssssssssssssssssssssssssssssssssssssssssssssss".matches(EMAIL_REGEX));
        assertFalse("1@g".matches(EMAIL_REGEX));
        assertFalse("user1@gmail.com".matches(LAST_NAME_REGEX));
        assertFalse("user1gmail com".matches(LAST_NAME_REGEX));
        assertFalse("user1gmailcom".matches(LAST_NAME_REGEX));
        assertTrue("usergmailcom".matches(LAST_NAME_REGEX));
    }

/*    @Test
    public void testCreateAnswers() {
        AnswerDao answerDao = new AnswerDaoImpl();
        List<Answer> answers = new ArrayList<>();
        answers.add(Answer.builder()
                .withQuestionId(1)
                .withAnswerEn("testEn1")
                .withAnswerRu("русскийВопрос1")
                .withIsCorrect("no")
                .build());
        answers.add(Answer.builder()
                .withQuestionId(1)
                .withAnswerEn("testEn2")
                .withAnswerRu("русскийВопрос2")
                .withIsCorrect("no")
                .build());
        answers.add(Answer.builder()
                .withQuestionId(1)
                .withAnswerEn("testEn3")
                .withAnswerRu("русскийВопрос3")
                .withIsCorrect("yes")
                .build());
        answers.add(Answer.builder()
                .withQuestionId(1)
                .withAnswerEn("testEn4")
                .withAnswerRu("русскийВопрос4")
                .withIsCorrect("no")
                .build());
        assertTrue(answerDao.create(answers));
    }*/
}