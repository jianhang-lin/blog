package work.jianhanglin.spring.boot.blog.service;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import work.jianhanglin.spring.boot.blog.domain.Blog;
import work.jianhanglin.spring.boot.blog.domain.User;
import work.jianhanglin.spring.boot.blog.domain.Vote;
import work.jianhanglin.spring.boot.blog.repository.BlogRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogServiceTest {

	@Autowired
	private BlogService blogService;

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private UserService userService;

	@Test
	public void testSaveBlog() {
		Blog blog = blogService.saveBlog(new Blog("标题", "简介", "内容"));
		Assert.assertThat(blog.getTitle(), is("标题"));
	}

	@Test(expected = Exception.class)
	public void testRemoveBlog() {
		blogService.removeBlog(3L);
		Blog blog = blogService.getBlogById(3L);
		Assert.assertThat(blog.getTitle(), is("testRemove"));
	}

	@Test
	public void testGetBlogById() {
		Blog blog = blogService.getBlogById(1L);
		Assert.assertThat(blog.getTitle(), is("Hello World!"));
	}

	@Test
	public void testListBlogsByTitleVote() {
		// fail("Not yet implemented");
	}

	@Test
	public void testListBlogsByTitleVoteAndSort() {
		// fail("Not yet implemented");
	}

	@Test
	public void testListBlogsByCatalog() {
		// fail("Not yet implemented");
	}

	@Test
	public void testReadingIncrease() {
		// fail("Not yet implemented");
	}

	@Test
	public void testCreateComment() {
		// fail("Not yet implemented");
	}

	@Test
	public void testRemoveComment() {
		// fail("Not yet implemented");
	}

	@Test
	public void testCreateVote() {
		/**
		 * 需要Blog实体的votes字段的fetch属性设置成FetchType.EAGER
		 */
		Blog originalBlog = blogRepository.findOne(6L);
		User user = userService.getUserById(1L);
		Vote vote = new Vote(user);
		boolean isExist = originalBlog.addVote(vote);
		if (isExist) {
			throw new IllegalArgumentException("该用户已经点过赞了");
		}
		Blog returnBlog = blogService.saveBlog(originalBlog);
		Assert.assertThat(returnBlog.getVoteSize(), is(1));
	}

	@Test
	public void testRemoveVote() {
		// fail("Not yet implemented");
	}

}
