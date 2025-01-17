package jmri.jmrit.display.layoutEditor;

import java.awt.GraphicsEnvironment;
import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test simple functioning of MultiIconEditor
 *
 * @author	Paul Bender Copyright (C) 2016
 */
public class MultiIconEditorTest {

    @Test
    public void testCtor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        MultiIconEditor frame = new MultiIconEditor(4);
        Assert.assertNotNull("exists", frame);
        frame.dispose();
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
    private final static Logger log = LoggerFactory.getLogger(MultiIconEditorTest.class.getName());
}
