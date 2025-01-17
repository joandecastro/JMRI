package jmri.jmrix.dcc4pc.swing.monitor;

import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test simple functioning of Dcc4PcMonPane
 *
 * @author	Paul Bender Copyright (C) 2016
 */
public class Dcc4PcMonPaneTest extends jmri.jmrix.AbstractMonPaneTestBase {

    @Test
    public void testMemoCtor() {
        Assert.assertNotNull("exists", pane);
    }

    @Override
    @Before
    public void setUp() {
        JUnitUtil.setUp();
        pane = new Dcc4PcMonPane();
    }

    @Override
    @After
    public void tearDown() {        JUnitUtil.tearDown();    }
}
