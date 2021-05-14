package com.project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.entity.Question;
import com.project.interfaces.IQuestionDAO;
import com.project.utils.DbConnect;

public class QuestionDOO implements IQuestionDAO {

	@Override
	public int getquestionidoflastRow() {
		// TODO Auto-generated method stub\
		String sql = "select * from questions";
		int questionid = 0;
		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.last();
			questionid = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return questionid;
	}

	@Override
	public boolean insertQuestion(Question question) {
		
		String sql = "insert into questions(Title,Description,Votes,Modifiedat,categoryid,userid,imagelink,reliability) values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
//			ps.setInt(1, question.getquestionId());
			ps.setString(1, question.getTitle());
			ps.setString(2, question.getDescription());
			ps.setInt(3, question.getVotes());
			ps.setString(4, question.getModifiedAt());
			ps.setInt(5, question.getCategoryID());
			ps.setInt(6, question.getUserId());
			ps.setString(7, question.getImageLink());
			ps.setInt(8, question.getReliability());
			
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public List<Question> getAllQuestion() {
		String sql = "select questionid,title,description,votes, modifiedat,categoryid,userid,imagelink,reliability from questions order by modifiedat DESC";
		
		List<Question> list;
		list = new ArrayList<Question>(); 
		try (
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
				)
				{	while(rs.next()) {
				
				Question question = new Question(); 
				question.setquestionId(rs.getInt(1)); 
				question.setTitle(rs.getString(2));
				question.setDescription(rs.getString(3)); 
				question.setVotes(rs.getInt(4));
				question.setModifiedAt(rs.getString(5));
				question.setCategoryID(rs.getInt(6));
				question.setUserId(rs.getInt(7));
				question.setImageLink(rs.getString(8));
				question.setReliability(rs.getInt(9));
				
				list.add(question); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list; 
	}

	@Override
	public Question getquestionfromquestionId(int questionidsearch) {
		// TODO Auto-generated method stub
		String sql = "select * from questions where questionid=" + questionidsearch;
		Question question = new Question();
		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				question.setquestionId(rs.getInt(1));
				question.setTitle(rs.getString(2));
				question.setDescription(rs.getString(3));
				question.setVotes(rs.getInt(4));
				question.setModifiedAt(rs.getString(5));
				question.setCategoryID(rs.getInt(6));
				question.setUserId(rs.getInt(7));
				question.setImageLink(rs.getString(8));
				question.setReliability(rs.getInt(9));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return question;
	}

	@Override
	public List<Question> getallquestionsfromuserId(int useridsearch) {
		// TODO Auto-generated method stub
		String sql = "select * from questions where userid=" + useridsearch + " order by modifiedat DESC";
		List<Question> list ;
		list = new ArrayList<Question>();
		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Question question = new Question();
				question.setquestionId(rs.getInt(1));
				question.setTitle(rs.getString(2));
				question.setDescription(rs.getString(3));
				question.setVotes(rs.getInt(4));
				question.setModifiedAt(rs.getString(5));
				question.setCategoryID(rs.getInt(6));
				question.setUserId(rs.getInt(7));
				question.setImageLink(rs.getString(8));
				question.setReliability(rs.getInt(9));
				list.add(question);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public List<Question> getallquestionsfromuseridbyvotesASC(int useridsearchasc) {
		// TODO Auto-generated method stub
		String sql = "select * from questions where userid=? order by votes ASC, modifiedat DESC";
		List<Question> list;
		list = new ArrayList<Question>();
		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, useridsearchasc);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Question question = new Question();
				question.setquestionId(rs.getInt(1));
				question.setTitle(rs.getString(2));
				question.setDescription(rs.getString(3));
				question.setVotes(rs.getInt(4));
				question.setModifiedAt(rs.getString(5));
				question.setCategoryID(rs.getInt(6));
				question.setUserId(rs.getInt(7));
				question.setImageLink(rs.getString(8));
				question.setReliability(rs.getInt(9));
				list.add(question);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}


	@Override
	public List<Question> getallquestionsfromuseridbyvotesDEC(int useridsearchdec) {
		// TODO Auto-generated method stub
		String sql = "select * from questions where userid=? order by votes DESC, modifiedat DESC";
		List<Question> list;
		list = new ArrayList<Question>();
		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, useridsearchdec);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Question question = new Question();
				question.setquestionId(rs.getInt(1));
				question.setTitle(rs.getString(2));
				question.setDescription(rs.getString(3));
				question.setVotes(rs.getInt(4));
				question.setModifiedAt(rs.getString(5));
				question.setCategoryID(rs.getInt(6));
				question.setUserId(rs.getInt(7));
				question.setImageLink(rs.getString(8));
				question.setReliability(rs.getInt(9));
				list.add(question);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public List<Question> getallquestionsfromcategoryId(int categoryidsearch) {
		// TODO Auto-generated method stub
		String sql = "select * from questions where categoryid=" + categoryidsearch + " order by modifiedat DESC";
		List<Question> list;
		list = new ArrayList<Question>();
		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Question question = new Question();
				question.setquestionId(rs.getInt(1));
				question.setTitle(rs.getString(2));
				question.setDescription(rs.getString(3));
				question.setVotes(rs.getInt(4));
				question.setModifiedAt(rs.getString(5));
				question.setCategoryID(rs.getInt(6));
				question.setUserId(rs.getInt(7));
				question.setImageLink(rs.getString(8));
				question.setReliability(rs.getInt(9));
				list.add(question);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<Question> getallquestionsfromcategoryidorderbyvotesASC(int categoryidsearchasc) {
		// TODO Auto-generated method stub
		String sql = "select * from questions where categoryid=? order by votes ASC, modifiedat DESC";
		List<Question> list;
		list = new ArrayList<Question>();
		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, categoryidsearchasc);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Question question = new Question();
				question.setquestionId(rs.getInt(1));
				question.setTitle(rs.getString(2));
				question.setDescription(rs.getString(3));
				question.setVotes(rs.getInt(4));
				question.setModifiedAt(rs.getString(5));
				question.setCategoryID(rs.getInt(6));
				question.setUserId(rs.getInt(7));
				question.setImageLink(rs.getString(8));
				question.setReliability(rs.getInt(9));
				list.add(question);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Question> getallquestionsfromcategoryidorderbyvotesDEC(int categoryidsearchdec) {
		// TODO Auto-generated method stub
		String sql = "select * from questions where categoryid=? order by votes DESC , modifiedat DESC";
		List<Question> list;
		list = new ArrayList<Question>();
		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, categoryidsearchdec);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Question question = new Question();
				question.setquestionId(rs.getInt(1));
				question.setTitle(rs.getString(2));
				question.setDescription(rs.getString(3));
				question.setVotes(rs.getInt(4));
				question.setModifiedAt(rs.getString(5));
				question.setCategoryID(rs.getInt(6));
				question.setUserId(rs.getInt(7));
				question.setImageLink(rs.getString(8));
				question.setReliability(rs.getInt(9));
				list.add(question);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Question> getallquestionsfromcategoryidorderbyreputationASC(int categoryidsearchascr) {
		// TODO Auto-generated method stub
		String sql = "SELECT questions.* FROM reps.questions, reps.sampleuser WHERE questions.categoryid=? and questions.userid = sampleuser.userid order by reputation ASC, modifiedat desc";
		List<Question> list;
		list = new ArrayList<Question>();
		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, categoryidsearchascr);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Question question = new Question();
				question.setquestionId(rs.getInt(1));
				question.setTitle(rs.getString(2));
				question.setDescription(rs.getString(3));
				question.setVotes(rs.getInt(4));
				question.setModifiedAt(rs.getString(5));
				question.setCategoryID(rs.getInt(6));
				question.setUserId(rs.getInt(7));
				question.setImageLink(rs.getString(8));
				question.setReliability(rs.getInt(9));
				list.add(question);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Question> getallquestionsfromcategoryidorderbyreputationDEC(int categoryidsearchdecr) {
		// TODO Auto-generated method stub
		String sql = "SELECT questions.* FROM reps.questions, reps.sampleuser WHERE questions.categoryid=? and questions.userid = sampleuser.userid order by reputation DESC, modifiedat desc";
		List<Question> list;
		list = new ArrayList<Question>();
		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, categoryidsearchdecr);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Question question = new Question();
				question.setquestionId(rs.getInt(1));
				question.setTitle(rs.getString(2));
				question.setDescription(rs.getString(3));
				question.setVotes(rs.getInt(4));
				question.setModifiedAt(rs.getString(5));
				question.setCategoryID(rs.getInt(6));
				question.setUserId(rs.getInt(7));
				question.setImageLink(rs.getString(8));
				question.setReliability(rs.getInt(9));
				list.add(question);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean deletequestionsfromquestionid(int questioniddel) {
		// TODO Auto-generated method stub
		String sql = "Delete from questions where questionid=?";
		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, questioniddel);

			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updatequestionfromquestionid(Question question, int questionid) {
		// TODO Auto-generated method stub
		String sql = "UPDATE questions SET title = ?, description = ?, modifiedat=?, categoryid=?, imagelink=? WHERE questionid=?";
		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setString(1, question.getTitle());
			ps.setString(2, question.getDescription());
			ps.setString(3, question.getModifiedAt());
			ps.setInt(4, question.getCategoryID());
			ps.setString(5, question.getImageLink());
			ps.setInt(6, questionid);

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}



}
