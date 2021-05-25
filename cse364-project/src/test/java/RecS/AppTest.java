package RecS;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration
@AutoConfigureMockMvc
public class AppTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testUserController() throws Exception {

        String args = "{\"gender\": \"F\", \"age\": \"25\", \"occupation\": \"Grad student\", \"genres\": \"Action|War\"}";

        this.mockMvc.perform(get("/users/recommendations").contentType(MediaType.APPLICATION_JSON).content(args)).andExpect(status().isOk());
    }



}
