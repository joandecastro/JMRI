package jmri.implementation;

import jmri.ProgListener;
import jmri.Programmer;
import jmri.progdebugger.ProgDebugger;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test the ResettingOffsetHighCvProgrammerFacade class.
 *
 * @author	Bob Jacobsen Copyright 2013, 2014
 * 
 */
public class ResettingOffsetHighCvProgrammerFacadeTest extends TestCase {

    int readValue = -2;
    boolean replied = false;

    public void testWriteReadDirect() throws jmri.ProgrammerException, InterruptedException {

        ProgDebugger dp = new ProgDebugger();
        dp.setTestReadLimit(256);
        dp.setTestWriteLimit(256);

        Programmer p = new ResettingOffsetHighCvProgrammerFacade(dp, "256", "7", "10", "100", "200");
        ProgListener l = new ProgListener() {
            @Override
            public void programmingOpReply(int value, int status) {
                log.debug("callback value=" + value + " status=" + status);
                replied = true;
                readValue = value;
            }
        };
        p.writeCV("4", 12, l);
        waitReply();
        Assert.assertEquals("target written", 12, dp.getCvVal(4));
        Assert.assertTrue("index not written", !dp.hasBeenWritten(7));

        p.readCV(4, l);
        waitReply();
        Assert.assertEquals("read back", 12, readValue);
    }

    public void testWriteReadDirectHighCV() throws jmri.ProgrammerException, InterruptedException {

        ProgDebugger dp = new ProgDebugger();
        dp.setTestReadLimit(1024);
        dp.setTestWriteLimit(1024);

        Programmer p = new ResettingOffsetHighCvProgrammerFacade(dp, "256", "7", "10", "100", "200");
        ProgListener l = new ProgListener() {
            @Override
            public void programmingOpReply(int value, int status) {
                log.debug("callback value=" + value + " status=" + status);
                replied = true;
                readValue = value;
            }
        };
        p.writeCV("258", 12, l);
        waitReply();
        Assert.assertEquals("target written", 12, dp.getCvVal(258));
        Assert.assertTrue("index not written", !dp.hasBeenWritten(7));

        p.readCV("258", l);
        waitReply();
        Assert.assertEquals("read back", 12, readValue);
    }

    public void testWriteReadIndexed() throws jmri.ProgrammerException, InterruptedException {

        ProgDebugger dp = new ProgDebugger();
        dp.setTestReadLimit(256);
        dp.setTestWriteLimit(256);
        Programmer p = new ResettingOffsetHighCvProgrammerFacade(dp, "256", "7", "10", "100", "200");
        ProgListener l = new ProgListener() {
            @Override
            public void programmingOpReply(int value, int status) {
                log.debug("callback value=" + value + " status=" + status);
                replied = true;
                readValue = value;
            }
        };

        p.writeCV("258", 12, l);
        waitReply();
        Assert.assertTrue("target not written", !dp.hasBeenWritten(258));
        Assert.assertEquals("index written", 0, dp.getCvVal(7)); // wrote 220, then wrote back
        Assert.assertEquals("value written", 12, dp.getCvVal(58));
        Assert.assertEquals("did 3 operations", 3, dp.nOperations);
    }

    public void testCvLimit() {
        ProgDebugger dp = new ProgDebugger();
        dp.setTestReadLimit(256);
        dp.setTestWriteLimit(256);
        Programmer p = new ResettingOffsetHighCvProgrammerFacade(dp, "256", "7", "10", "100", "200");
        Assert.assertTrue("CV limit read OK", p.getCanRead("1024"));
        Assert.assertTrue("CV limit write OK", p.getCanWrite("1024"));
        Assert.assertTrue("CV limit read fail", !p.getCanRead("1025"));
        Assert.assertTrue("CV limit write fail", !p.getCanWrite("1025"));
    }

    // from here down is testing infrastructure
    synchronized void waitReply() throws InterruptedException {
        while (!replied) {
            wait(200);
        }
        replied = false;
    }

    // from here down is testing infrastructure
    public ResettingOffsetHighCvProgrammerFacadeTest(String s) {
        super(s);
    }

    // Main entry point
    static public void main(String[] args) {
        String[] testCaseName = {ResettingOffsetHighCvProgrammerFacadeTest.class.getName()};
        junit.textui.TestRunner.main(testCaseName);
    }

    // test suite from all defined tests
    public static Test suite() {
        apps.tests.AllTest.initLogging();
        TestSuite suite = new TestSuite(ResettingOffsetHighCvProgrammerFacadeTest.class);
        return suite;
    }

    private final static Logger log = LoggerFactory.getLogger(ResettingOffsetHighCvProgrammerFacadeTest.class.getName());

}
