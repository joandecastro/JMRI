package jmri.jmrit.automat;

import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Paul Bender Copyright (C) 2017	
 */
public class JythonAutomatonActionTest {

    @Test
    public void testCTor() {
        JythonAutomatonAction t = new JythonAutomatonAction("Test",
              new javax.swing.JPanel());
        Assert.assertNotNull("exists",t);
    }

    // The minimal setup for log4J
    @Before
    public void setUp() {
        JUnitUtil.setUp();
    }

    @After
    public void tearDown() {
        JUnitUtil.tearDown();
    }

    // private final static Logger log = LoggerFactory.getLogger(JythonAutomatonActionTest.class.getName());

}
