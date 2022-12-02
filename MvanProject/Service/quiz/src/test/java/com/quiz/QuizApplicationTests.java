package com.quiz;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import net.minidev.json.JSONObject;

@SpringBootTest
@AutoConfigureMockMvc
class QuizApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getPatata() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/patata").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello World PATATA!")));
	}

	@Test
	public void getPreguntas() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/preguntas").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		}

	@Test
	public void deletePreguntas() throws Exception {
		mvc.perform(MockMvcRequestBuilders
			.delete("/{id}", 683)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
			}
	@Test
	public void postPreguntas() throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", 683);
		jsonObject.put("pregunta", "Cuantos corazones tienes un pulpo");
		jsonObject.put("todas_respuestas", "a) 6, b) 2, c) 3, d) 5");
		jsonObject.put("respuesta", "##################");
		jsonObject.put("respuesta_letra", "d");

		String json = jsonObject.toJSONString();
		mvc.perform(MockMvcRequestBuilders.post("/")
		.contentType(MediaType.APPLICATION_JSON).content(json))
        .andExpect(status().isOk());
	}

	@Test
	public void putPreguntas() throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", 683);
		jsonObject.put("pregunta", "Cuantos corazones tienes un pulpo");
		jsonObject.put("todas_respuestas", "a) 6, b) 2, c) 3, d) 5");
		jsonObject.put("respuesta", "##################");
		jsonObject.put("respuesta_letra", "c");

		String json = jsonObject.toJSONString();
		mvc.perform(MockMvcRequestBuilders.put("/")
		.contentType(MediaType.APPLICATION_JSON).content(json))
        .andExpect(status().isOk());
	}

	@Test
	public void findByPregunta() throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", 683);
		jsonObject.put("pregunta", "Cuantos corazones tienes un pulpo");
		jsonObject.put("todas_respuestas", "a) 6, b) 2, c) 3, d) 5");
		jsonObject.put("respuesta", "##################");
		jsonObject.put("respuesta_letra", "c");

		String json = jsonObject.toJSONString();
		mvc.perform(MockMvcRequestBuilders.get("/cuant")
		.contentType(MediaType.APPLICATION_JSON).content(json))
        .andExpect(status().isOk());
	}
}
