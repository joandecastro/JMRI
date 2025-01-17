package jmri.jmrix.qsi.swing;

import jmri.jmrix.qsi.QsiSystemConnectionMemo;
import jmri.jmrix.qsi.QsiTrafficControlScaffold;
import jmri.jmrix.qsi.QsiTrafficController;
import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Paul Bender Copyright (C) 2017	
 */
public class QsiComponentFactoryTest {

    @Test
    public void testCTor() {
        QsiTrafficController tc = new QsiTrafficControlScaffold();
        QsiSystemConnectionMemo memo = new QsiSystemConnectionMemo(tc);
        QsiComponentFactory t = new QsiComponentFactory(memo);
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

    // private final static Logger log = LoggerFactory.getLogger(QsiComponentFactoryTest.class.getName());

}
