package com.natural.test;

import org.junit.Test;
import static  org.junit.Assert.*;
public class HelloWorldTest {
    @Test
    public void testHello(){
        HelloWorld helloWorld = new HelloWorld();
        String result=helloWorld.say();
        assertEquals("11",result);

    }
}
