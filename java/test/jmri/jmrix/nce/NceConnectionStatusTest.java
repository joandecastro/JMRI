package jmri.jmrix.nce;

import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Paul Bender Copyright (C) 2017	
 */
public class NceConnectionStatusTest {

    private NceTrafficControlScaffold tcis = null;

    @Test
    public void testCTor() {
        NceConnectionStatus t = new NceConnectionStatus(tcis);
        Assert.assertNotNull("exists",t);
    }

    // The minimal setup for log4J
    @Before
    public void setUp() {
        JUnitUtil.setUp();
        tcis = new NceTrafficControlScaffold();
    }

    @After
    public void tearDown() {
        JUnitUtil.tearDown();
    }

    // private final static Logger log = LoggerFactory.getLogger(NceConnectionStatusTest.class.getName());

}
