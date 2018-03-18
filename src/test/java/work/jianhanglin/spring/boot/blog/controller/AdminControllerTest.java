package work.jianhanglin.spring.boot.blog.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AdminControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testListUsers() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/admins").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isFound()).andDo(MockMvcResultHandlers.print()).andReturn();
	}

}
