package grapple.learn.springboot.springbootinternationalization;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SpringbootInternationalizationApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void contextLoads() throws Exception {
		mockMvc.perform(get("/").locale(Locale.FRANCE))
				.andExpect(content().string("{\"name\":\"Lilei+法语\",\"hello\":\"Helloworld+法语!\"}"));


		mockMvc.perform(get("/").locale(Locale.CHINA))
				.andExpect(content().string("{\"name\":\"李磊\",\"hello\":\"你好!\"}"));

		mockMvc.perform(get("/").locale(Locale.ENGLISH))
				.andExpect(content().string("{\"name\":\"Lilei\",\"hello\":\"Helloworld!\"}"));
	}

}
