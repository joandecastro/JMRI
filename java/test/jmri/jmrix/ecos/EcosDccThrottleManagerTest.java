package jmri.jmrix.ecos;

import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Paul Bender Copyright (C) 2017	
 */
public class EcosDccThrottleManagerTest {

    @Test
    public void testCTor() {
        EcosTrafficController tc = new EcosInterfaceScaffold();
        EcosDccThrottleManager t = new EcosDccThrottleManager(new jmri.jmrix.ecos.EcosSystemConnectionMemo(tc));
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

    // private final static Logger log = LoggerFactory.getLogger(EcosDccThrottleManagerTest.class.getName());

}
