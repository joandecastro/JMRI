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
public class NceThrottleManagerTest {

    private NceTrafficControlScaffold tcis = null;
    private NceSystemConnectionMemo memo = null;

    @Test
    public void testCTor() {
        NceThrottleManager t = new NceThrottleManager(memo);
        Assert.assertNotNull("exists",t);
    }

    // The minimal setup for log4J
    @Before
    public void setUp() {
        JUnitUtil.setUp();
        tcis = new NceTrafficControlScaffold();
        memo = new NceSystemConnectionMemo();
        memo.setNceTrafficController(tcis);
    }

    @After
    public void tearDown() {
        JUnitUtil.tearDown();
    }

    // private final static Logger log = LoggerFactory.getLogger(NceThrottleManagerTest.class.getName());

}
