package com.apavlidi.consumer2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import java.util.HashMap;
import java.util.Map;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

public class ClientControllerTest {

  @Rule
  public PactProviderRuleMk2 mockProvider
      = new PactProviderRuleMk2("test_provider", "localhost", 8080, this);

  @Pact(consumer = "consumer2")
  public RequestResponsePact createPactContract(PactDslWithProvider builder) {
    Map<String, String> headers = Map.of("Content-Type", "application/json");

    PactDslJsonBody body = new PactDslJsonBody()
        .stringType("name", "perfectMusic2")
        .stringType("artiste", "A2")
        .numberType("year", 2002);

    return builder
        .given("music exists")
          .uponReceiving("get a single post request")
          .path("/music/2")
          .method("GET")
        .willRespondWith()
          .status(200)
          .headers(headers)
          .body(body)
        .toPact();
  }

  @Test
  @PactVerification("test_provider")
  public void givenGet_whenSendRequest_shouldReturn200WithProperHeaderAndBody() {
    ResponseEntity<String> response = new ClientController().consume2();

    assertThat(response.getStatusCode().value()).isEqualTo(200);
    assertThat(response.getHeaders().get("Content-Type").contains("application/json")).isTrue();
    assertThat(response.getBody()).contains("name", "perfectMusic2", "artiste", "A2", "year", "2002");
  }

}
