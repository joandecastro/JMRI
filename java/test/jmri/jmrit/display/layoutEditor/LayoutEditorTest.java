package jmri.jmrit.display.layoutEditor;

import java.awt.GraphicsEnvironment;
import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

/**
 * Test simple functioning of LayoutEditor
 *
 * @author Paul Bender Copyright (C) 2016
 */
public class LayoutEditorTest {

    private LayoutEditor le = null;

    @Test
    public void testStringCtor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        le = new LayoutEditor("Test Layout");
        Assert.assertNotNull("exists", le);
    }

    @Test
    public void testDefaultCtor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        LayoutEditor e = new LayoutEditor(); // create layout editor
        Assert.assertNotNull("exists", e);
        JUnitUtil.dispose(e);
    }

    @Test
    public void testGetFinder() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        LayoutEditorFindItems f = le.getFinder();
        Assert.assertNotNull("exists", f);
    }

    @Test
    public void testSetSize() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        le.setSize(100, 100);
        java.awt.Dimension d = le.getSize();

        // the java.awt.Dimension stores the values as floating point
        // numbers, but setSize expects integer parameters.
        Assert.assertEquals("Width Set", 100.0, d.getWidth(), 0.0);
        Assert.assertEquals("Height Set", 100.0, d.getHeight(), 0.0);
    }

    @Test
    public void testGetSetZoom() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        Assert.assertEquals("Zoom Get", 1.0, le.getZoom(), 0.0);
        // note: Layout Editor won't allow zooms below 0.25
        Assert.assertEquals("Zoom Set", 0.25, le.setZoom(0.1), 0.0);
        // note: Layout Editor won't allow zooms above 6.0.
        Assert.assertEquals("Zoom Set", 6.0, le.setZoom(10.0), 0.0);
        Assert.assertEquals("Zoom Set", 3.33, le.setZoom(3.33), 0.0);
        Assert.assertEquals("Zoom Get", 3.33, le.getZoom(), 0.0);
    }

    @Test
    public void testGetOpenDispatcherOnLoad() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // defaults to false.
        Assert.assertFalse("getOpenDispatcherOnLoad", le.getOpenDispatcherOnLoad());
    }

    @Test
    public void testSetOpenDispatcherOnLoad() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // defaults to false, so set to true.
        le.setOpenDispatcherOnLoad(true);
        Assert.assertTrue("setOpenDispatcherOnLoad after set", le.getOpenDispatcherOnLoad());
    }

    @Test
    public void testIsDirty() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // defaults to false.
        Assert.assertFalse("isDirty", le.isDirty());
    }

    @Test
    public void testSetDirty() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // defaults to false, setDirty() sets it to true.
        le.setDirty();
        Assert.assertTrue("isDirty after set", le.isDirty());
    }

    @Test
    public void testSetDirtyWithParameter() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // defaults to false, so set it to true.
        le.setDirty(true);
        Assert.assertTrue("isDirty after set", le.isDirty());
    }

    @Test
    public void testResetDirty() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // defaults to false, so set it to true.
        le.setDirty(true);
        // then call resetDirty, which sets it back to false.
        le.resetDirty();
        Assert.assertFalse("isDirty after reset", le.isDirty());
    }

    @Test
    public void testIsAnimating() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // default to true
        Assert.assertTrue("isAnimating", le.isAnimating());
    }

    @Test
    public void testSetTurnoutAnimating() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // default to true, so set to false.
        le.setTurnoutAnimation(false);
        Assert.assertFalse("isAnimating after set", le.isAnimating());
    }

    @Test
    public void testGetLayoutWidth() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // defaults to 0
        Assert.assertEquals("layout width", 0, le.getLayoutWidth());
    }

    @Test
    public void testGetLayoutHeight() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // defaults to 0
        Assert.assertEquals("layout height", 0, le.getLayoutHeight());
    }

    @Test
    public void testGetWindowWidth() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // defaults to 0
        Assert.assertEquals("window width", 0, le.getWindowWidth());
    }

    @Test
    public void testGetWindowHeight() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // defaults to 0
        Assert.assertEquals("window height", 0, le.getWindowHeight());
    }

    @Test
    public void testGetUpperLeftX() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // defaults to 0
        Assert.assertEquals("upper left X", 0, le.getUpperLeftX());
    }

    @Test
    public void testGetUpperLeftY() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // defaults to 0
        Assert.assertEquals("upper left Y", 0, le.getUpperLeftY());
    }

    @Test
    public void testSetLayoutDimensions() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // set the panel dimensions to known values
        le.setLayoutDimensions(100, 100, 100, 100, 100, 100);
        Assert.assertEquals("layout width after set", 100, le.getLayoutWidth());
        Assert.assertEquals("layout height after set", 100, le.getLayoutHeight());
        Assert.assertEquals("window width after set", 100, le.getWindowWidth());
        Assert.assertEquals("window height after set", 100, le.getWindowHeight());
        Assert.assertEquals("upper left X after set", 100, le.getUpperLeftX());
        Assert.assertEquals("upper left Y after set", 100, le.getUpperLeftX());
    }

    @Test
    public void testSetGrideSize() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        Assert.assertEquals("grid size after set", 100, le.setGridSize(100));
    }

    @Test
    public void testGetGrideSize() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // defaults to 10.
        Assert.assertEquals("grid size", 10, le.getGridSize());
    }

    @Test
    public void testGetMainlineTrackWidth() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // defaults to 4.
        Assert.assertEquals("mainline track width", 4, le.getMainlineTrackWidth());
    }

    @Test
    public void testSetMainlineTrackWidth() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // set to known value
        le.setMainlineTrackWidth(10);
        Assert.assertEquals("mainline track width after set", 10, le.getMainlineTrackWidth());
    }

    @Test
    public void testGetSidelineTrackWidth() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // defaults to 2.
        Assert.assertEquals("side track width", 2, le.getSideTrackWidth());
    }

    @Test
    public void testSetSideTrackWidth() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // set to known value
        le.setSideTrackWidth(10);
        Assert.assertEquals("Side track width after set", 10, le.getSideTrackWidth());
    }

    @Test
    public void testGetXScale() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // defaults to 1.
        Assert.assertEquals("XScale", 1.0, le.getXScale(), 0.0);
    }

    @Test
    public void testSetXScale() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // set to known value
        le.setXScale(2.0);
        Assert.assertEquals("XScale after set ", 2.0, le.getXScale(), 0.0);
    }

    @Test
    public void testGetYScale() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // defaults to 1.
        Assert.assertEquals("YScale", 1.0, le.getYScale(), 0.0);
    }

    @Test
    public void testSetYScale() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // set to known value
        le.setYScale(2.0);
        Assert.assertEquals("YScale after set ", 2.0, le.getYScale(), 0.0);
    }

    @Test
    public void testGetDefaultTrackColor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        Assert.assertEquals("Default Track Color", "black", le.getDefaultTrackColor());
    }

    @Test
    public void testSetDefaultTrackColor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        le.setDefaultTrackColor("pink");
        Assert.assertEquals("Default Track Color after Set", "pink", le.getDefaultTrackColor());
    }

    @Test
    public void testGetDefaultOccupiedTrackColor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        Assert.assertEquals("Default Occupied Track Color", "red", le.getDefaultOccupiedTrackColor());
    }

    @Test
    public void testSetDefaultOccupiedTrackColor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        le.setDefaultOccupiedTrackColor("pink");
        Assert.assertEquals("Default Occupied Track Color after Set", "pink", le.getDefaultOccupiedTrackColor());
    }

    @Test
    public void testGetDefaultAlternativeTrackColor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        Assert.assertEquals("Default Alternative Track Color", "white", le.getDefaultAlternativeTrackColor());
    }

    @Test
    public void testSetDefaultAlternativeTrackColor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        le.setDefaultAlternativeTrackColor("pink");
        Assert.assertEquals("Default Alternative Track Color after Set", "pink", le.getDefaultAlternativeTrackColor());
    }

    @Test
    public void testGetDefaultTextColor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        Assert.assertEquals("Default Text Color", "black", le.getDefaultTextColor());
    }

    @Test
    public void testSetDefaultTextColor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        le.setDefaultTextColor("pink");
        Assert.assertEquals("Default Text Color after Set", "pink", le.getDefaultTextColor());
    }

    @Test
    public void testGetTurnoutCircleColor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        Assert.assertEquals("Turnout Circle Color", "black", le.getTurnoutCircleColor());
    }

    @Test
    public void testSetTurnoutCircleColor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        le.setTurnoutCircleColor("pink");
        Assert.assertEquals("Turnout Circle after Set", "pink", le.getTurnoutCircleColor());
    }

    @Test
    public void testGetTurnoutCircleSize() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // defaults to 4.
        Assert.assertEquals("turnout circle size", 4, le.getTurnoutCircleSize());
    }

    @Test
    public void testSetTurnoutCircleSize() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        le.setTurnoutCircleSize(11);
        Assert.assertEquals("turnout circle size after set", 11, le.getTurnoutCircleSize());
    }

    @Test
    public void testGetTurnoutDrawUnselectedLeg() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // default to true
        Assert.assertTrue("getTurnoutDrawUnselectedLeg", le.getTurnoutDrawUnselectedLeg());
    }

    @Test
    public void testSetTurnoutDrawUnselectedLeg() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // default to true, so set to false.
        le.setTurnoutDrawUnselectedLeg(false);
        Assert.assertFalse("getTurnoutDrawUnselectedLeg after set", le.getTurnoutDrawUnselectedLeg());
    }

    @Test
    public void testGetLayoutName() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        le = new LayoutEditor(); // we do this here to test the default name
        // default is "My Layout"
        Assert.assertEquals("getLayoutName", "My Layout", le.getLayoutName());
    }

    @Test
    public void testSetLayoutName() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // the test layout editor setUp created is named this
        Assert.assertEquals("getLayoutName", "Test Layout", le.getLayoutName());
        // set to a known (different) value
        le.setLayoutName("foo");
        Assert.assertEquals("getLayoutName after set", "foo", le.getLayoutName());
    }

    @Test
    public void testGetShowHelpBar() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // default to true
        Assert.assertTrue("getShowHelpBar", le.getShowHelpBar());
    }

    @Test
    public void testSetShowHelpBar() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // default to true, so set to false.
        le.setShowHelpBar(false);
        Assert.assertFalse("getShowHelpBar after set", le.getShowHelpBar());
    }

    @Test
    public void testGetDrawGrid() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // default to true
        Assert.assertTrue("getDrawGrid", le.getDrawGrid());
    }

    @Test
    public void testSetDrawGrid() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // default to false, so set to true.
        le.setDrawGrid(true);
        Assert.assertTrue("getDrawGrid after set", le.getDrawGrid());
    }

    @Test
    public void testGetSnapOnAdd() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // default to false
        Assert.assertFalse("getSnapOnAdd", le.getSnapOnAdd());
    }

    @Test
    public void testSetSnapOnAdd() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // default to false, so set to true.
        le.setSnapOnAdd(true);
        Assert.assertTrue("getSnapOnAdd after set", le.getSnapOnAdd());
    }

    @Test
    public void testGetSnapOnMove() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // default to false
        Assert.assertFalse("getSnapOnMove", le.getSnapOnMove());
    }

    @Test
    public void testSetSnapOnMove() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // default to false, so set to true.
        le.setSnapOnMove(true);
        Assert.assertTrue("getSnapOnMove after set", le.getSnapOnMove());
    }

    @Test
    public void testGetAntialiasingOn() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // default to false
        Assert.assertFalse("getAntialiasingOn", le.getAntialiasingOn());
    }

    @Test
    public void testSetAntialiasingOn() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // default to false, so set to true.
        le.setAntialiasingOn(true);
        Assert.assertTrue("getAntialiasingOn after set", le.getAntialiasingOn());
    }

    @Test
    public void testGetTurnoutCircles() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // default to false
        Assert.assertFalse("getTurnoutCircles", le.getTurnoutCircles());
    }

    @Test
    public void testSetTurnoutCircles() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // default to false, so set to true.
        le.setTurnoutCircles(true);
        Assert.assertTrue("getSetTurnoutCircles after set", le.getTurnoutCircles());
    }

    @Test
    public void testGetTooltipsNotEdit() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // default to false
        Assert.assertFalse("getTooltipsNotEdit", le.getTooltipsNotEdit());
    }

    @Test
    public void testSetTooltipsNotEdit() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // default to false, so set to true.
        le.setTooltipsNotEdit(true);
        Assert.assertTrue("getTooltipsNotEdit after set", le.getTooltipsNotEdit());
    }

    @Test
    public void testGetTooltipsInEdit() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // default to true
        Assert.assertTrue("getTooltipsInEdit", le.getTooltipsInEdit());
    }

    @Test
    public void testSetTooltipsInEdit() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // default to true, so set to false.
        le.setTooltipsInEdit(false);
        Assert.assertFalse("getTooltipsInEdit after set", le.getTooltipsInEdit());
    }

    @Test
    public void testGetAutoBlockAssignment() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // default to false
        Assert.assertFalse("getAutoBlockAssignment", le.getAutoBlockAssignment());
    }

    @Test
    public void testSetAutoBlockAssignment() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // default to false, so set to true.
        le.setAutoBlockAssignment(true);
        Assert.assertTrue("getAutoBlockAssignment after set", le.getAutoBlockAssignment());
    }

    @Test
    public void testGetTurnoutBX() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // defaults to 20.
        Assert.assertEquals("getTurnoutBX", 20.0, le.getTurnoutBX(), 0.0);
    }

    @Test
    public void testSetTurnoutBX() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // set to known value
        le.setTurnoutBX(2.0);
        Assert.assertEquals("getTurnoutBX after set ", 2.0, le.getTurnoutBX(), 0.0);
    }

    @Test
    public void testGetTurnoutCX() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // defaults to 20.
        Assert.assertEquals("getTurnoutCX", 20.0, le.getTurnoutCX(), 0.0);
    }

    @Test
    public void testSetTurnoutCX() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // set to known value
        le.setTurnoutCX(2.0);
        Assert.assertEquals("getTurnoutCX after set ", 2.0, le.getTurnoutCX(), 0.0);
    }

    @Test
    public void testGetTurnoutWid() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // defaults to 10.
        Assert.assertEquals("getTurnoutWid", 10.0, le.getTurnoutWid(), 0.0);
    }

    @Test
    public void testSetTurnoutWid() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // set to known value
        le.setTurnoutWid(2.0);
        Assert.assertEquals("getTurnoutWid after set ", 2.0, le.getTurnoutWid(), 0.0);
    }

    @Test
    public void testGetXOverLong() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // defaults to 30.
        Assert.assertEquals("getXOverLong", 30.0, le.getXOverLong(), 0.0);
    }

    @Test
    public void testSetXOverLong() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // set to known value
        le.setXOverLong(2.0);
        Assert.assertEquals("getXOverLong after set ", 2.0, le.getXOverLong(), 0.0);
    }

    @Test
    public void testGetXOverHWid() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // defaults to 10.
        Assert.assertEquals("getXOverHWid", 10.0, le.getXOverHWid(), 0.0);
    }

    @Test
    public void testSetXOverHWid() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // set to known value
        le.setXOverHWid(2.0);
        Assert.assertEquals("getXOverWid after set ", 2.0, le.getXOverHWid(), 0.0);
    }

    @Test
    public void testGetXOverShort() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // defaults to 10.
        Assert.assertEquals("getXOverShort", 10.0, le.getXOverShort(), 0.0);
    }

    @Test
    public void testSetXOverShort() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // set to known value
        le.setXOverShort(2.0);
        Assert.assertEquals("getXOverShort after set ", 2.0, le.getXOverShort(), 0.0);
    }

    @Test
    public void testResetTurnoutSizes() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // set all dimensions to known value
        le.setTurnoutBX(2.0);
        le.setTurnoutCX(2.0);
        le.setTurnoutWid(2.0);
        le.setXOverLong(2.0);
        le.setXOverHWid(2.0);
        le.setXOverShort(2.0);

        // reset - uses reflection to get a private method.
        java.lang.reflect.Method resetTurnoutSize = null;
        try {
            resetTurnoutSize = le.getClass().getDeclaredMethod("resetTurnoutSize");
        } catch (java.lang.NoSuchMethodException nsm) {
            Assert.fail("Could not find method resetTurnoutSize in LayoutEditor class.");
        }
        // override the default permissions.
        Assert.assertNotNull(resetTurnoutSize);
        resetTurnoutSize.setAccessible(true);
        try {
            resetTurnoutSize.invoke(le);
        } catch (java.lang.IllegalAccessException iae) {
            Assert.fail("Could not access method resetTurnoutSize in LayoutEditor class.");
        } catch (java.lang.reflect.InvocationTargetException ite) {
            Throwable cause = ite.getCause();
            Assert.fail("resetTurnoutSize execution failed reason: " + cause.getMessage());
        }

        // then check for the default values.
        Assert.assertEquals("getTurnoutBX", 20.0, le.getTurnoutBX(), 0.0);
        Assert.assertEquals("getTurnoutCX", 20.0, le.getTurnoutBX(), 0.0);
        Assert.assertEquals("getTurnoutWid", 20.0, le.getTurnoutBX(), 0.0);
        Assert.assertEquals("getXOverLong", 30.0, le.getXOverLong(), 0.0);
        Assert.assertEquals("getXOverHWid", 30.0, le.getXOverLong(), 0.0);
        Assert.assertEquals("getXOverShort", 30.0, le.getXOverLong(), 0.0);
        // and reset also sets the dirty bit.
        Assert.assertTrue("isDirty after resetTurnoutSize", le.isDirty());
    }

    @Test
    public void testGetDirectTurnoutControl() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // default to false
        Assert.assertFalse("getDirectTurnoutControl", le.getDirectTurnoutControl());
    }

    @Test
    public void testSetDirectTurnoutControl() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // default to false, so set to true.
        le.setDirectTurnoutControl(true);
        Assert.assertTrue("getDirectTurnoutControl after set", le.getDirectTurnoutControl());
    }

    // from here down is testing infrastructure
    @Before
    public void setUp() throws Exception {
        JUnitUtil.setUp();
        if(!GraphicsEnvironment.isHeadless()){
           le = new LayoutEditor("Test Layout");
        }
    }

    @After
    public void tearDown() throws Exception {
        if (le != null) {
            JUnitUtil.dispose(le);
            le = null;
        }
        JUnitUtil.tearDown();
    }
}
