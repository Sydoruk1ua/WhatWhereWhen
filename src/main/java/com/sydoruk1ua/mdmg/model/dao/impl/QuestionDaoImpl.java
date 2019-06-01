package com.sydoruk1ua.mdmg.model.dao.impl;

import com.sydoruk1ua.mdmg.model.dao.QuestionDao;
import com.sydoruk1ua.mdmg.model.entity.Question;
import com.sydoruk1ua.mdmg.model.entity.QuestionType;
import com.sydoruk1ua.mdmg.util.Connector;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QuestionDaoImpl implements QuestionDao {
    private static final String FIND_ALL_QUESTIONS = "SELECT q.id, q.type_id, q.question_en, q.question_ru," +
            " q.prompt_en, q.prompt_ru, qt.type AS type_name " +
            "FROM questions AS q JOIN question_types AS qt ON q.type_id = qt.id;";

    private static final Logger LOGGER = Logger.getLogger(QuestionDaoImpl.class);

    @Override
    public void create(Question entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Question> findById(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Question> findAll() {
        List<Question> listOfAllQuestions = new ArrayList<>();
        try (PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(FIND_ALL_QUESTIONS);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                do {
                    listOfAllQuestions.add(getQuestion(resultSet));
                } while (resultSet.next());
            } else {
                LOGGER.warn("Result Set is empty!");
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }

        return listOfAllQuestions;
    }

    private Question getQuestion(ResultSet resultSet) throws SQLException {
        Integer questionTypeId = resultSet.getInt("type_id");
        String questionTypeName = resultSet.getString("type_name");
        QuestionType questionType = new QuestionType(questionTypeId, questionTypeName);
        return Question.builder()
                .withId(resultSet.getInt("id"))
                .withQuestionType(questionType)
                .withQuestionEn(resultSet.getString("question_en"))
                .withQuestionRu(resultSet.getString("question_ru"))
                .withPromptEn(resultSet.getString("prompt_en"))
                .withQuestionRu(resultSet.getString("prompt_ru"))
                .build();
    }

    @Override
    public void update(Question entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException();
    }
}
