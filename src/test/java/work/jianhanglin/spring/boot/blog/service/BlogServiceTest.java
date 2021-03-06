package work.jianhanglin.spring.boot.blog.service;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import work.jianhanglin.spring.boot.blog.domain.Blog;
import work.jianhanglin.spring.boot.blog.domain.Catalog;
import work.jianhanglin.spring.boot.blog.domain.Comment;
import work.jianhanglin.spring.boot.blog.domain.User;
import work.jianhanglin.spring.boot.blog.domain.Vote;
import work.jianhanglin.spring.boot.blog.repository.BlogRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogServiceTest {

	Pageable pageable = null;

	@Autowired
	private BlogService blogService;

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private CatalogService catalogService;

	@Before
	public void testBefore() {
		pageable = new PageRequest(0, 5);
	}

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
		User user = userService.getUserById(1L);
		Page<Blog> blogs = blogService.listBlogsByTitleVote(user, "Hello", pageable);
		Assert.assertThat(blogs.getTotalElements(), is(2L));
	}

	@Test
	public void testListBlogsByTitleVoteAndSort() {
		User user = userService.getUserById(1L);
		Page<Blog> blogs = blogService.listBlogsByTitleVoteAndSort(user, "Hello", pageable);
		Assert.assertThat(blogs.getTotalElements(), is(2L));
	}

	@Test
	public void testListBlogsByCatalog() {
		Catalog catalog = catalogService.getCatalogById(1L);
		Page<Blog> blogs = blogService.listBlogsByCatalog(catalog, pageable);
		Assert.assertThat(blogs.getTotalElements(), is(5L));
	}

	@Test
	public void testReadingIncrease() {
		Blog blog = blogRepository.findOne(6L);
		int beforeNo = blog.getReadSize();
		blogService.readingIncrease(6L);
		blog = blogRepository.findOne(6L);
		int afterNo = blog.getReadSize();
		Assert.assertThat(afterNo - beforeNo, is(1));
	}

	@Test
	public void testCreateComment() {
		String commentContent = "test";
		Blog originalBlog = blogRepository.findOne(6L);
		User user = userService.getUserById(1L);
		Comment comment = new Comment(user, commentContent);
		originalBlog.addComment(comment);
		Blog returnBlog = blogService.saveBlog(originalBlog);
		Assert.assertThat(returnBlog.getComments().get(0).getContent(), is(commentContent));
	}

	@Test
	public void testRemoveComment() {
		int beforSize = blogService.getBlogById(6L).getCommentSize();
		blogService.removeComment(6L, 5L);
		int afterSize = blogService.getBlogById(6L).getCommentSize();
		Assert.assertThat(beforSize - afterSize, is(1));
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
		/**
		 * 需要Blog实体的votes字段的fetch属性设置成FetchType.EAGER
		 */
		blogService.removeVote(6L, 7L);
		Blog blog = blogService.getBlogById(6L);
		Assert.assertThat(blog.getVoteSize(), is(0));
	}

}
