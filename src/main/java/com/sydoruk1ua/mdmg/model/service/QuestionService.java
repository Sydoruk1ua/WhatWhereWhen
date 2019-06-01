package com.sydoruk1ua.mdmg.model.service;

import com.sydoruk1ua.mdmg.model.entity.Question;

import java.util.List;

public interface QuestionService {

    void create(Question question);

    List<Question> findAll();

    void update(Question question);
}
