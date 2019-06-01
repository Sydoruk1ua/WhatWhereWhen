package com.sydoruk1ua.mdmg.model.entity;

import java.util.Objects;

public class Answer {
    private final Integer id;
    private final Question question;
    private final String answerEn;
    private final String answerRu;
    private final Boolean isCorrect;

    private Answer(Builder builder) {
        this.id = builder.id;
        this.question = builder.question;
        this.answerEn = builder.answerEn;
        this.answerRu = builder.answerRu;
        this.isCorrect = builder.isCorrect;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Answer answer = (Answer) o;
        return Objects.equals(id, answer.id) &&
                Objects.equals(question, answer.question) &&
                Objects.equals(answerEn, answer.answerEn) &&
                Objects.equals(answerRu, answer.answerRu) &&
                Objects.equals(isCorrect, answer.isCorrect);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, answerEn, answerRu, isCorrect);
    }

    public static class Builder {
        private Integer id;
        private Question question;
        private String answerEn;
        private String answerRu;
        private Boolean isCorrect;

        private Builder() {

        }

        public Answer build() {
            return new Answer(this);
        }

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withQuestion(Question question) {
            this.question = question;
            return this;
        }

        public Builder withAnswerEn(String answerEn) {
            this.answerEn = answerEn;
            return this;
        }

        public Builder withAnswerRu(String answerRu) {
            this.answerRu = answerRu;
            return this;
        }

        public Builder withIsCorrect(Boolean isCorrect) {
            this.isCorrect = isCorrect;
            return this;
        }
    }
}
