package com.project.interfaces;

import java.util.List;

import com.project.entity.Question;

// contracts 
public interface IQuestionDAO {
	
	public boolean insertQuestion(Question question); 
	public List<Question> getAllQuestion(); 
	
	public int getquestionidoflastRow();
	public Question getquestionfromquestionId(int questionidsearch);
	
	public List<Question> getallquestionsfromuserId(int useridsearch);
	public List<Question> getallquestionsfromuseridbyvotesASC(int useridsearchasc);
	public List<Question> getallquestionsfromuseridbyvotesDEC(int useridsearchdec);
//	public List<Question> getallquestionsfromuseridorderbyreputationASC(int useridsearchasc);  //sort by reputation asc
//	public List<Question> getallquestionsfromuseridorderbyreputationDEC(int useridsearchdec);  //sort by reputation des
	
	public List<Question> getallquestionsfromcategoryId(int categoryidsearch); // sort  by time 
	public List<Question> getallquestionsfromcategoryidorderbyvotesASC(int categoryidsearchasc);  //sort  by votes ascending
	public List<Question> getallquestionsfromcategoryidorderbyvotesDEC(int categoryidsearchdec);  //sort by votes desc
	public List<Question> getallquestionsfromcategoryidorderbyreputationASC(int categoryidsearchasc);  //sort by reputation asc
	public List<Question> getallquestionsfromcategoryidorderbyreputationDEC(int categoryidsearchdec);  //sort by reputation desc4
	
	public boolean deletequestionsfromquestionid(int questioniddel);
	public boolean updatequestionfromquestionid(Question question, int questionid);

}
