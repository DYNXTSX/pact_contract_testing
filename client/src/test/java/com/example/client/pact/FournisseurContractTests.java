package com.example.client.pact;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import com.example.client.core.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FournisseurContractTests {

    private static final String HOST_NAME = "localhost";
    private static final int PORT = 8088;

    @Autowired
    private ClientService clientService;

    @Rule
    public PactProviderRuleMk2 mockFournisseur = new PactProviderRuleMk2("fournisseur",
            HOST_NAME, PORT, this);

    @Pact(consumer = "client", provider = "fournisseur")
    public RequestResponsePact createPactForGetLastUpdatedTimestamp(PactDslWithProvider builder) {

        PactDslJsonBody body = new PactDslJsonBody()
                .stringType("name", "DANCE MONKEY")
                .stringType("artiste", "TONES AND I")
                .integerType("year", 2019);

        Map<String,String> headers = new HashMap();
        headers.put("Content-Type","application/json");

        return builder
                .given("Get music details")
                .uponReceiving("Get music details for music id")
                .path("/music/17")
                .method(HttpMethod.GET.name())
                .willRespondWith()
                .status(HttpStatus.OK.value())
                .headers(headers)
                .body(body)
                .toPact();
    }

    @Test
    @PactVerification(value = "fournisseur")
    public void testGetItemDetailsFromRetailer() {
        Music music = clientService.getMusicDetail();
        assertEquals(music.getName(), "DANCE MONKEY");
    }

}
