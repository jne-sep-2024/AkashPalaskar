package com.microservice.RatingService;

import com.microservice.RatingService.dto.RatingDto;
import com.microservice.RatingService.service.RatingService;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.configuration.IMockitoConfiguration;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class RatingServiceApplicationTests {

    @Mock
    private RatingService ratingServiceMock;

    List<String> todos = Arrays.asList("AWS", "DevOps", "Azure","Kafka");

    @Test
    void contextLoads() {
        System.out.println("contextLoads");

        Assertions.assertEquals(2, 2);
    }

    @Test
    void todoSize() {
        System.out.println("todoSize");

        Assertions.assertEquals(4, todos.size());
    }

    @Test
    void todosContainsAWS() {
        System.out.println("todosContainsAWS");

        Assertions.assertTrue(todos.contains("AWS"));
    }

    @Test
    void todosContainsKafka() {
        System.out.println("todosContainsKafka");

        Assertions.assertTrue(todos.contains("Kafka"));
    }
    @Test
    void getAllRating() {
        List<RatingDto> ratingDtos = List.of(new RatingDto(1, 2, 3, "good hotel")
                , new RatingDto(4, 5, 6, "nice Hotel"));
        Mockito.when(ratingServiceMock.ratingList()).thenReturn(ratingDtos);
        Assertions.assertEquals(ratingDtos, ratingServiceMock.ratingList());
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("beforeEach");
    }

    @AfterEach
    void AfterEach() {
        System.out.println("AfterEach");
    }
    @AfterAll
    static void AfterAll() {
        System.out.println("AfterAll");
    }
    @BeforeAll
    static void BeforeAll() {
        System.out.println("BeforeAll");
    }

}
