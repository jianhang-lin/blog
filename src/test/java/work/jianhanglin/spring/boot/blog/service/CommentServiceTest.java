package work.jianhanglin.spring.boot.blog.service;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import work.jianhanglin.spring.boot.blog.domain.Comment;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceTest {

	@Autowired
	private CommentService commentService;

	@Test
	public void testGetCommentById() {
		Comment comment = commentService.getCommentById(1L);
		Assert.assertThat(comment.getContent(), is("Hello"));
	}

	@Test
	public void testRemoveComment() {
	}

}
