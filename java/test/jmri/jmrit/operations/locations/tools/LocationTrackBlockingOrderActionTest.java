package jmri.jmrit.operations.locations.tools;

import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Paul Bender Copyright (C) 2017	
 */
public class LocationTrackBlockingOrderActionTest {

    @Test
    public void testCTor() {
        LocationTrackBlockingOrderAction t = new LocationTrackBlockingOrderAction();
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

    // private final static Logger log = LoggerFactory.getLogger(LocationTrackBlockingOrderActionTest.class.getName());

}
