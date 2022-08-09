package com.learn;

import static org.junit.Assert.assertTrue;

import java.util.stream.IntStream;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }


    @Test
    public void a2zdigitValue(){

        IntStream.range(0, 26)
        .forEach(el -> {
            System.out.println(Character.toChars( el + 'a'));
        });
    }
}
