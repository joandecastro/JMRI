package jmri.jmrit.display.layoutEditor;

import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test simple functioning of LayoutBlockConnectivityTools
 *
 * @author	Paul Bender Copyright (C) 2016
 */
public class LayoutBlockConnectivityToolsTest {

    @Test
    public void testCtor() {
        LayoutBlockConnectivityTools t = new LayoutBlockConnectivityTools();
        Assert.assertNotNull("exists", t);
    }

    // from here down is testing infrastructure
    @Before
    public void setUp() throws Exception {
        JUnitUtil.setUp();
    }

    @After
    public void tearDown() throws Exception {
        JUnitUtil.tearDown();
    }
    private final static Logger log = LoggerFactory.getLogger(LayoutBlockConnectivityToolsTest.class.getName());
}
