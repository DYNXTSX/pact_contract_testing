package com.awesome.testing.wiremock;

import com.awesome.testing.dto.information.Information;
import com.awesome.testing.dto.information.TimedInformation;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.Instant;

import static com.awesome.testing.controller.RootController.RONALDO;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RootControllerTest extends AbstractWiremock {

    private static final String PORTUGAL = "Portugal";

    @Before
    public void prepareBackendResponse() throws JsonProcessingException {
        Information ronaldo = new Information(ID, RONALDO, PORTUGAL, SALARY);
        String jsonBody = objectMapper.writeValueAsString(ronaldo);

        stubFor(get(urlEqualTo("/information?name=" + RONALDO))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(jsonBody)));
    }

    @Test
    public void shouldCorrectlyRespond() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(ID))
                .andExpect(jsonPath("$.name").value(RONALDO))
                .andExpect(jsonPath("$.nationality").value(PORTUGAL))
                .andExpect(jsonPath("$.salary").value(SALARY))
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();

        TimedInformation timedInformation = objectMapper.readValue(contentAsString, TimedInformation.class);
        assertThat(timedInformation.getTimestamp()).isBefore(Instant.now());
    }

}
