package work.jianhanglin.spring.boot.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import work.jianhanglin.spring.boot.blog.domain.Comment;


/**
 * Comment 仓库.
 * @author linjianhang
 *
 */
public interface CommentRepository extends JpaRepository<Comment, Long>{
 
}
