package com.digimind.filmservice;

import com.digimind.filmservice.repository.FilmRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MariaDBContainer;

@SpringBootTest
@AutoConfigureMockMvc
class FilmServiceApplicationTests {

	static MariaDBContainer mariaDBContainer = new MariaDBContainer("10.6");
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private FilmRepository filmRepository;

	static {
		mariaDBContainer.start();
	}

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dymDynamicPropertyRegistry) {
		//dymDynamicPropertyRegistry.add("spring.data.mongodb.uri", mariaDBContainer::getReplicaSetUrl);
	}


}
