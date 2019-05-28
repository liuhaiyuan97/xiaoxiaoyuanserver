package com.project.dao;

import com.project.entity.Question;

public interface QuestionMapper {
	public Question selectQuestionByQid(int id);
}
