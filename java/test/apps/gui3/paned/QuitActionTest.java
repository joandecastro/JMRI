package apps.gui3.paned;

import java.awt.GraphicsEnvironment;
import jmri.util.JUnitUtil;
import jmri.util.swing.JFrameInterface;
import org.junit.After;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Paul Bender Copyright (C) 2017	
 */
public class QuitActionTest {

    @Test
    public void testCTor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        JFrameInterface w = new JFrameInterface(new jmri.util.JmriJFrame("foo"));
        QuitAction t = new QuitAction("test",w);
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

    // private final static Logger log = LoggerFactory.getLogger(QuitActionTest.class.getName());

}
