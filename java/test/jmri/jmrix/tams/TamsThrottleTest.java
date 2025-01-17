package jmri.jmrix.tams;

import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Paul Bender Copyright (C) 2017	
 */
public class TamsThrottleTest {

    @Test
    public void testCTor() {
        TamsTrafficController tc = new TamsInterfaceScaffold();
        TamsSystemConnectionMemo memo = new TamsSystemConnectionMemo(tc);  
        TamsThrottle t = new TamsThrottle(memo,new jmri.DccLocoAddress(1234,false));
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

    // private final static Logger log = LoggerFactory.getLogger(TamsThrottleTest.class.getName());

}
