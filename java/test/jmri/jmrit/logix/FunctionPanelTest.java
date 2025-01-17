package jmri.jmrit.logix;

import java.awt.GraphicsEnvironment;
import jmri.jmrit.roster.RosterEntry;
import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Paul Bender Copyright (C) 2017	
 */
public class FunctionPanelTest {

    @Test
    public void testCTor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        LearnThrottleFrame ltf = new LearnThrottleFrame(new WarrantFrame(new Warrant("IW0", "AllTestWarrant")));
        RosterEntry re = new RosterEntry("file here");
        FunctionPanel t = new FunctionPanel(re,ltf);
        Assert.assertNotNull("exists",t);
        JUnitUtil.dispose(ltf);
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

    private final static Logger log = LoggerFactory.getLogger(FunctionPanelTest.class.getName());

}
