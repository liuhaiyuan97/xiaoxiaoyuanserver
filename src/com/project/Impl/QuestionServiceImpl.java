package com.project.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.QuestionMapper;
import com.project.entity.Question;
import com.project.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionMapper questionMapper;
	
	@Override
	public Question selectQuestionByQid(int id) {
		return questionMapper.selectQuestionByQid(id);
	}

}
