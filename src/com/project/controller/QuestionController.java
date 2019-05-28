package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.project.entity.Question;
import com.project.service.QuestionService;

@Controller
@RequestMapping(value="question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;

	@RequestMapping(value="selectQuestionByQid",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String selectQuestionByQid(@RequestParam("id") int id) {
		Question question=questionService.selectQuestionByQid(id);
		if(question!=null) {
			Gson gson=new Gson();
			String str=gson.toJson(question);
			return str;
		}else {
			return null;
		}
	}
}
