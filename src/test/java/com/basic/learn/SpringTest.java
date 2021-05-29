package com.basic.learn;


import org.junit.Test;


public class SpringTest {


    @Test
    public void testStateNew() {
        Thread thread = new Thread(() -> {});
        System.out.println(thread.getState()); // 输出 NEW
    }
}
