package tn.esprit.services;

import java.util.List;

import tn.esprit.entities.Comment;


public interface ICommentService {
	
	public Comment addComment(Comment comment);

	public int deleteComment(int idComment);

	public int updateComment(Comment comment);

	public Comment findComment(int idComment);
		
	public List<Comment> listComments();


}
