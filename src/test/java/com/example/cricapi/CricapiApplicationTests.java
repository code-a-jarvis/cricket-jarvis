package com.example.cricapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CricapiApplicationTests {

    @Test
    void contextLoads() {
        MatchController matchController = new MatchController();
        matchController.getMatchResponse("45891");
    }

}
