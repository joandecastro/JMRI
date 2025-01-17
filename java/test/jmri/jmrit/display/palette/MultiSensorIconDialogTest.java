package jmri.jmrit.display.palette;

import java.awt.GraphicsEnvironment;
import jmri.jmrit.catalog.NamedIcon;
import jmri.jmrit.display.Editor;
import jmri.jmrit.display.EditorScaffold;
import jmri.jmrit.picker.PickListModel;
import jmri.util.JUnitUtil;
import jmri.util.JmriJFrame;
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
public class MultiSensorIconDialogTest {

    @Test
    public void testCTor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        PickListModel tableModel = PickListModel.turnoutPickModelInstance(); // N11N
        JmriJFrame jf = new JmriJFrame("Indicator TO Icon Dialog Test");
        Editor editor = new EditorScaffold();
        MultiSensorItemPanel mip = new MultiSensorItemPanel(jf,"IS01","",tableModel,editor);
        MultiSensorIconDialog t = new MultiSensorIconDialog("MultiSensor","MultiSensor",mip,null);
        Assert.assertNotNull("exists",t);
        JUnitUtil.dispose(jf);
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

    private final static Logger log = LoggerFactory.getLogger(MultiSensorIconDialogTest.class.getName());

}
