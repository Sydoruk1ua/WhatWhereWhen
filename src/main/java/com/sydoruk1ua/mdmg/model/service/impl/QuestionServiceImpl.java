package com.sydoruk1ua.mdmg.model.service.impl;

import com.sydoruk1ua.mdmg.model.dao.QuestionDao;
import com.sydoruk1ua.mdmg.model.entity.Question;
import com.sydoruk1ua.mdmg.model.service.QuestionService;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {
    private QuestionDao questionDao;

    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public void create(Question question) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Question> findAll() {
        return questionDao.findAll();
    }

    @Override
    public void update(Question question) {
        throw new UnsupportedOperationException();
    }
}
