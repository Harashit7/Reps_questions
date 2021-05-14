package com.project.client;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.project.dao.QuestionDOO;
import com.project.entity.Question;
import com.project.interfaces.IQuestionDAO;

public class App {
	public static void main(String[] args) {
		
		Question question = new Question(); 
		IQuestionDAO dao = new QuestionDOO();

//		int questionid = dao.getquestionidoflastRow();
//		questionid = questionid + 1;

		// question.setquestionId(questionid);

		question.setTitle("hello there bhai aur sab bhadiya   ");
		question.setDescription(
				"dont simply sit work out to burn calories and eat healthy and nice and beautiful aur kaisa hai");
		question.setVotes(4);
		
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);
		question.setModifiedAt(currentTime);

		question.setCategoryID(6);
		question.setImageLink("https://google.com/workout-2.jpeg");
		question.setUserId(6);
		question.setReliability(10);


		
		                                                                                         // insert sql script fired
//		System.out.println(dao.insertQuestion(question) ? "Inserted" : "Not Inserted");
		
		System.out.println("hello there --- ");

		                                                                                         // get all questions script fired
//		for (Question q : dao.getAllQuestion()) {
//			System.out.println(q);
//		}
		
		System.out.println("hello there --- ");

		                                                                                          // get question from question id fired
		int questionidsearch = 3;
//		Question questionfromquestionid = dao.getquestionfromquestionId(questionidsearch);
//		System.out.println(questionfromquestionid);
		
		System.out.println("hello there --- ");

		                                                                                          // get all questions from user id script fired
//		int useridsearch = 6;
//		for (Question q : dao.getallquestionsfromuserId(useridsearch)) {
//			System.out.println(q);
//		}
		
		System.out.println("hello there --- ");

//		                                                                                         // get all questions from user id script ascending order fired(votes)
		int useridsearchasc = 6;
		for (Question q : dao.getallquestionsfromuseridbyvotesASC(useridsearchasc)) {
			System.out.println(q);
		}

		System.out.println("hello there --- ");

		                                                                                        // get all questions from user id script descending order fired(votes)
		int useridsearchdec = 6;
		for (Question q : dao.getallquestionsfromuseridbyvotesDEC(useridsearchdec)) {
			System.out.println(q);
		}

		System.out.println("hello there --- ");
		                                                                                         // get all questions from category id fired
//		int categoryidsearch = 6;
//		for (Question q : dao.getallquestionsfromcategoryId(categoryidsearch)) {
//			System.out.println(q);
//		}

		System.out.println("hello there --- ");

		                                                                                           // get all questions from category id ascending fired(votes)
//		int categoryidsearchasc = 5;
//		for (Question q : dao.getallquestionsfromcategoryidorderbyvotesASC(categoryidsearchasc)) {
//			System.out.println(q);
//		}

		System.out.println("hello there -----------");

		                                                                                             // get all questions from categoryid descending order fired(votes)
//		int categoryidsearchdec = 5;
//		for (Question q : dao.getallquestionsfromcategoryidorderbyvotesDEC(categoryidsearchdec)) {
//			System.out.println(q);
//		}

		System.out.println("hello there -----------");

		                                                                                              // get all questions from categoryid ascending order fired(reliability)
//		int categoryidsearchascr = 5;
//		for (Question q : dao.getallquestionsfromcategoryidorderbyreputationASC(categoryidsearchascr)) {
//			System.out.println(q);
//		}

		System.out.println("hello there -----------");

		                                                                                               // get all questions from categoryid descending order fired(reliability)
//		int categoryidsearchdecr = 5;
//		for (Question q : dao.getallquestionsfromcategoryidorderbyreputationDEC(categoryidsearchdecr)) {
//			System.out.println(q);
//		}
//		
		System.out.println("hello there -----------");
		
		                                                                                                //delete question fired 
//		int questioniddel = 18 ;
//		System.out.println(dao.deletequestionsfromuserid(questioniddel) ? "Deleted" : "Not Deleted");
		
		System.out.println("hello there -----------");
		
		int questionidupdate = 19;
		Question question1 = new Question();
		question1.setTitle("hello there brother ");
		question1.setDescription("dont simply sit work out to burn calories and eat healthy hai ekdum");
		Date dt1 = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime1 = sdf1.format(dt);
		question1.setModifiedAt(currentTime1);
		question1.setCategoryID(2);
		question1.setImageLink("Link-2");
		System.out.println(dao.updatequestionfromquestionid(question1, questionidupdate) ? "Updated" : "Not Updated");
		
		System.out.println("hello there --- ");


	}
	
}
