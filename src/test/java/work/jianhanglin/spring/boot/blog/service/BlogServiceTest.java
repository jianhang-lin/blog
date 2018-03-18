package work.jianhanglin.spring.boot.blog.service;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import work.jianhanglin.spring.boot.blog.domain.Blog;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogServiceTest {

	@Autowired
	private BlogService blogService;

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
		// fail("Not yet implemented");
	}

	@Test
	public void testRemoveVote() {
		// fail("Not yet implemented");
	}

}
