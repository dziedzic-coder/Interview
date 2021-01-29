package com.dziedzic.interview.task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphTest {

    Graph cut;

    @BeforeEach
    void setUp() {
        cut = new Graph();
    }

    @Test
    void shouldReturn_1_whenGraphOfTwoVertices() {
        //given
        int expectedResult = 1;
        int firstVertex = 1;
        int secondVertex = 2;
        cut.addEdge(firstVertex, secondVertex);
        //when
        int count = cut.findNumberOfGraphs();
        //then
        assertEquals(expectedResult, count);
    }

    @Test
    void shouldReturn_0_whenGraphOfNoVertices() {
        //given
        int expectedResult = 0;
        //when
        int count = cut.findNumberOfGraphs();
        //then
        assertEquals(expectedResult, count);
    }

}
