package com.lingenliu.util;

import org.junit.Assert;
import org.junit.Test;


public class TestJsonReader {


    @Test
    public void test(){
        String mode = JsonReader.sharedInstance().stringForKey("mode");
        Assert.assertTrue(mode.equals("textview"));
    }
}
