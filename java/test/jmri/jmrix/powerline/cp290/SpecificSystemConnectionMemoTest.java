package jmri.jmrix.powerline.cp290;

import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for SpecificSystemConnectionMemo class.
 *
 * @author Paul Bender Copyright (C) 2016
 **/

public class SpecificSystemConnectionMemoTest {

   @Test
   public void ConstructorTest(){
      Assert.assertNotNull("SpecificSystemConnectionMemo constructor",new SpecificSystemConnectionMemo());
   }

   @Before
   public void setUp() {
        JUnitUtil.setUp();

        jmri.util.JUnitUtil.initDefaultUserMessagePreferences();
   }

   @After
   public void tearDown(){
        JUnitUtil.tearDown();
   }

}
