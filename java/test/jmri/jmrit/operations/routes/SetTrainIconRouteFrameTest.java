package jmri.jmrit.operations.routes;

import java.awt.GraphicsEnvironment;
import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Paul Bender Copyright (C) 2017	
 */
public class SetTrainIconRouteFrameTest {

    @Test
    @Ignore("needs more setup, causes NPE")
    public void testCTor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        SetTrainIconRouteFrame t = new SetTrainIconRouteFrame("Test");
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

    // private final static Logger log = LoggerFactory.getLogger(SetTrainIconRouteFrameTest.class.getName());

}
