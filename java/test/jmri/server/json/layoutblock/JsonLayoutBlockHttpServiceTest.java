package jmri.server.json.layoutblock;

import com.fasterxml.jackson.databind.ObjectMapper;
import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Paul Bender Copyright (C) 2017	
 */
public class JsonLayoutBlockHttpServiceTest {

    @Test
    public void testCTor() {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonLayoutBlockHttpService t = new JsonLayoutBlockHttpService(objectMapper);
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

    private final static Logger log = LoggerFactory.getLogger(JsonLayoutBlockHttpServiceTest.class.getName());

}
