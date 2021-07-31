package fr.eql.al35.WebSocketsChat.serverRestChat.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.eql.al35.WebSocketsChat.WebSocketsChatApplication;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes= {WebSocketsChatApplication.class})
@AutoConfigureMockMvc
public class ChatRestWsMockTest {

	@Autowired
	private MockMvc mvc;
	private static String RELATIVE_BASE_URL ="";
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	@Test
	public void testGetAllUsers() throws Exception {
		final String uri = RELATIVE_BASE_URL + "/fetchAllUsers";
		mvc.perform(get(uri)
				.accept("application/json")
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(10)) ))
				.andDo(print());
		
	}
	
}
