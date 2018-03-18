package work.jianhanglin.spring.boot.blog.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import work.jianhanglin.spring.boot.blog.domain.Comment;
import work.jianhanglin.spring.boot.blog.repository.CommentRepository;
import work.jianhanglin.spring.boot.blog.service.CommentService;

/**
 * Comment 服务.
 * 
 * @author linjianhang
 *
 */
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Override
	@Transactional
	public void removeComment(Long id) {
		commentRepository.delete(id);
	}

	@Override
	public Comment getCommentById(Long id) {
		return commentRepository.findOne(id);
	}

}
