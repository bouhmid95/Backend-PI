package tn.esprit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Comment;
import tn.esprit.repository.CommentRepository;

@Service
public class CommentServiceImpl implements ICommentService{

	@Autowired
	CommentRepository commentrepository;
	
	
	@Override
	public Comment addComment(Comment comment) {
		commentrepository.save(comment);
		return comment;
	}

	@Override
	public int deleteComment(int idComment) {
		Comment comment = commentrepository.findById(idComment).orElse(null);
		commentrepository.delete(comment);
		return idComment;
	}

	@Override
	public int updateComment(Comment comment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Comment findComment(int idComment) {
		return commentrepository.findById(idComment).get();	
	}

	@Override
	public List<Comment> listComments() {
		 return (List<Comment>) commentrepository.findAll();
	}

}
