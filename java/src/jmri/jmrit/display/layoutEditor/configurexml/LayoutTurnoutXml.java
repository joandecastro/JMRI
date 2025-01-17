package jmri.jmrit.display.layoutEditor.configurexml;

import java.awt.geom.Point2D;
import jmri.Turnout;
import jmri.configurexml.AbstractXmlAdapter;
import jmri.jmrit.display.layoutEditor.LayoutEditor;
import jmri.jmrit.display.layoutEditor.LayoutTurnout;
import jmri.jmrit.display.layoutEditor.TrackSegment;
import org.jdom2.Attribute;
import org.jdom2.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This module handles configuration for display.LayoutTurnout objects for a
 * LayoutEditor.
 *
 * @author David Duchamp Copyright (c) 2007
 */
public class LayoutTurnoutXml extends AbstractXmlAdapter {

    public LayoutTurnoutXml() {
    }

    /**
     * Default implementation for storing the contents of a LayoutTurnout
     *
     * @param o Object to store, of type LayoutTurnout
     * @return Element containing the complete info
     */
    @Override
    public Element store(Object o) {

        LayoutTurnout p = (LayoutTurnout) o;

        Element element = new Element("layoutturnout");

        // include attributes
        element.setAttribute("ident", p.getName());
        if (!p.getTurnoutName().isEmpty()) {
            element.setAttribute("turnoutname", p.getTurnoutName());
        }
        if (!p.getSecondTurnoutName().isEmpty()) {
            element.setAttribute("secondturnoutname", p.getSecondTurnoutName());
            if (p.getSecondTurnoutInverted()) {
                element.setAttribute("secondturnoutinverted", "true");
            }
        }

        if (!p.getBlockName().isEmpty()) {
            element.setAttribute("blockname", p.getBlockName());
        }
        if (!p.getBlockBName().isEmpty()) {
            element.setAttribute("blockbname", p.getBlockBName());
        }
        if (!p.getBlockCName().isEmpty()) {
            element.setAttribute("blockcname", p.getBlockCName());
        }
        if (!p.getBlockDName().isEmpty()) {
            element.setAttribute("blockdname", p.getBlockDName());
        }
        element.setAttribute("type", "" + p.getTurnoutType());
        if (p.isHidden()) {
            element.setAttribute("hidden", "yes");
        }
        if (p.getConnectA() != null) {
            element.setAttribute("connectaname", ((TrackSegment) p.getConnectA()).getId());
        }
        if (p.getConnectB() != null) {
            element.setAttribute("connectbname", ((TrackSegment) p.getConnectB()).getId());
        }
        if (p.getConnectC() != null) {
            element.setAttribute("connectcname", ((TrackSegment) p.getConnectC()).getId());
        }
        if (p.getConnectD() != null) {
            element.setAttribute("connectdname", ((TrackSegment) p.getConnectD()).getId());
        }
        if (!p.getSignalA1Name().isEmpty()) {
            element.setAttribute("signala1name", p.getSignalA1Name());
        }
        if (!p.getSignalA2Name().isEmpty()) {
            element.setAttribute("signala2name", p.getSignalA2Name());
        }
        if (!p.getSignalA3Name().isEmpty()) {
            element.setAttribute("signala3name", p.getSignalA3Name());
        }
        if (!p.getSignalB1Name().isEmpty()) {
            element.setAttribute("signalb1name", p.getSignalB1Name());
        }
        if (!p.getSignalB2Name().isEmpty()) {
            element.setAttribute("signalb2name", p.getSignalB2Name());
        }
        if (!p.getSignalC1Name().isEmpty()) {
            element.setAttribute("signalc1name", p.getSignalC1Name());
        }
        if (!p.getSignalC2Name().isEmpty()) {
            element.setAttribute("signalc2name", p.getSignalC2Name());
        }
        if (!p.getSignalD1Name().isEmpty()) {
            element.setAttribute("signald1name", p.getSignalD1Name());
        }
        if (!p.getSignalD2Name().isEmpty()) {
            element.setAttribute("signald2name", p.getSignalD2Name());
        }
        if (!p.getLinkedTurnoutName().isEmpty()) {
            element.setAttribute("linkedturnoutname", p.getLinkedTurnoutName());
            element.setAttribute("linktype", "" + p.getLinkType());
        }

        if (!p.getSignalAMastName().isEmpty()) {
            element.addContent(new Element("signalAMast").addContent(p.getSignalAMastName()));
        }

        if (!p.getSignalBMastName().isEmpty()) {
            element.addContent(new Element("signalBMast").addContent(p.getSignalBMastName()));
        }
        if (!p.getSignalCMastName().isEmpty()) {
            element.addContent(new Element("signalCMast").addContent(p.getSignalCMastName()));
        }
        if (!p.getSignalDMastName().isEmpty()) {
            element.addContent(new Element("signalDMast").addContent(p.getSignalDMastName()));
        }

        if (!p.getSensorAName().isEmpty()) {
            element.addContent(new Element("sensorA").addContent(p.getSensorAName()));
        }

        if (!p.getSensorBName().isEmpty()) {
            element.addContent(new Element("sensorB").addContent(p.getSensorBName()));
        }
        if (!p.getSensorCName().isEmpty()) {
            element.addContent(new Element("sensorC").addContent(p.getSensorCName()));
        }
        if (!p.getSensorDName().isEmpty()) {
            element.addContent(new Element("sensorD").addContent(p.getSensorDName()));
        }

        element.setAttribute("continuing", "" + p.getContinuingSense());
        element.setAttribute("disabled", "" + (p.isDisabled() ? "yes" : "no"));
        element.setAttribute("disableWhenOccupied", "" + (p.isDisabledWhenOccupied() ? "yes" : "no"));
        Point2D coords = p.getCoordsCenter();
        element.setAttribute("xcen", "" + coords.getX());
        element.setAttribute("ycen", "" + coords.getY());
        coords = p.getCoordsA();
        element.setAttribute("xa", "" + coords.getX());
        element.setAttribute("ya", "" + coords.getY());
        coords = p.getCoordsB();
        element.setAttribute("xb", "" + coords.getX());
        element.setAttribute("yb", "" + coords.getY());
        coords = p.getCoordsC();
        element.setAttribute("xc", "" + coords.getX());
        element.setAttribute("yc", "" + coords.getY());
        coords = p.getCoordsD();
        element.setAttribute("xd", "" + coords.getX());
        element.setAttribute("yd", "" + coords.getY());
        element.setAttribute("ver", "" + p.getVersion());
        element.setAttribute("class", getClass().getName());
        return element;
    }

    @Override
    public boolean load(Element shared, Element perNode) {
        log.error("Invalid method called");
        return false;
    }

    /**
     * Load, starting with the levelxing element, then all the other data
     *
     * @param element Top level Element to unpack.
     * @param o       LayoutEditor as an Object
     */
    @Override
    public void load(Element element, Object o) {
        // create the objects
        LayoutEditor p = (LayoutEditor) o;

        // get center point
        String name = element.getAttribute("ident").getValue();
        double x = 0.0;
        double y = 0.0;
        int tType = LayoutTurnout.RH_TURNOUT;
        try {
            x = element.getAttribute("xcen").getFloatValue();
            y = element.getAttribute("ycen").getFloatValue();
            tType = element.getAttribute("type").getIntValue();
        } catch (org.jdom2.DataConversionException e) {
            log.error("failed to convert layoutturnout attribute");
        }

        int version = 1;
        try {
            version = element.getAttribute("ver").getIntValue();
        } catch (org.jdom2.DataConversionException e) {
            log.error("failed to convert layoutturnout version attribute");
        } catch (java.lang.NullPointerException e) {
            //can be ignored as panel file may not support method
        }

        // create the new LayoutTurnout
        LayoutTurnout l = new LayoutTurnout(name, tType,
                new Point2D.Double(x, y), 0.0, 1.0, 1.0, p, version);

        // get remaining attributes
        Attribute a = element.getAttribute("blockname");
        if (a != null) {
            l.tBlockName = a.getValue();
        }
        a = element.getAttribute("blockbname");
        if (a != null) {
            l.tBlockBName = a.getValue();
        }
        a = element.getAttribute("blockcname");
        if (a != null) {
            l.tBlockCName = a.getValue();
        }
        a = element.getAttribute("blockdname");
        if (a != null) {
            l.tBlockDName = a.getValue();
        }
        a = element.getAttribute("turnoutname");
        if (a != null) {
            l.tTurnoutName = a.getValue();
        }
        a = element.getAttribute("secondturnoutname");
        if (a != null) {
            l.tSecondTurnoutName = a.getValue();

            boolean invert2nd = false;
            if (element.getAttribute("secondturnoutinverted") != null) {
                if (element.getAttribute("secondturnoutinverted").getValue().equals("true")) {
                    invert2nd = true;
                }
            }
            l.setSecondTurnoutInverted(invert2nd);
        }

        a = element.getAttribute("connectaname");
        if (a != null) {
            l.connectAName = a.getValue();
        }
        a = element.getAttribute("connectbname");
        if (a != null) {
            l.connectBName = a.getValue();
        }
        a = element.getAttribute("connectcname");
        if (a != null) {
            l.connectCName = a.getValue();
        }
        a = element.getAttribute("connectdname");
        if (a != null) {
            l.connectDName = a.getValue();
        }
        a = element.getAttribute("signala1name");
        if (a != null) {
            l.setSignalA1Name(a.getValue());
        }
        a = element.getAttribute("signala2name");
        if (a != null) {
            l.setSignalA2Name(a.getValue());
        }
        a = element.getAttribute("signala3name");
        if (a != null) {
            l.setSignalA3Name(a.getValue());
        }
        a = element.getAttribute("signalb1name");
        if (a != null) {
            l.setSignalB1Name(a.getValue());
        }
        a = element.getAttribute("signalb2name");
        if (a != null) {
            l.setSignalB2Name(a.getValue());
        }
        a = element.getAttribute("signalc1name");
        if (a != null) {
            l.setSignalC1Name(a.getValue());
        }
        a = element.getAttribute("signalc2name");
        if (a != null) {
            l.setSignalC2Name(a.getValue());
        }
        a = element.getAttribute("signald1name");
        if (a != null) {
            l.setSignalD1Name(a.getValue());
        }
        a = element.getAttribute("signald2name");
        if (a != null) {
            l.setSignalD2Name(a.getValue());
        }
        a = element.getAttribute("linkedturnoutname");
        if (a != null) {
            l.linkedTurnoutName = a.getValue();
            try {
                l.linkType = element.getAttribute("linktype").getIntValue();
            } catch (org.jdom2.DataConversionException e) {
                log.error("failed to convert linked layout turnout type");
            }
        }
        a = element.getAttribute("continuing");
        if (a != null) {
            int continuing = Turnout.CLOSED;
            try {
                continuing = element.getAttribute("continuing").getIntValue();
            } catch (org.jdom2.DataConversionException e) {
                log.error("failed to convert continuingsense attribute");
            }
            l.setContinuingSense(continuing);
        }
        boolean value = false;
        if ((a = element.getAttribute("disabled")) != null && a.getValue().equals("yes")) {
            value = true;
        }
        l.setDisabled(value);
        value = false;
        if ((a = element.getAttribute("disableWhenOccupied")) != null && a.getValue().equals("yes")) {
            value = true;
        }
        l.setDisableWhenOccupied(value);
        boolean hide = false;
        if (element.getAttribute("hidden") != null) {
            if (element.getAttribute("hidden").getValue().equals("yes")) {
                hide = true;
            }
        }
        l.setHidden(hide);
        if(version==2){
            try {
                x = element.getAttribute("xa").getFloatValue();
                y = element.getAttribute("ya").getFloatValue();
                l.setCoordsA(new Point2D.Double(x, y));
            } catch (org.jdom2.DataConversionException e) {
                log.error("failed to convert layoutturnout b coords attribute");
            } catch (java.lang.NullPointerException e) {
                //can be ignored as panel file may not support method
            }
        }
        try {
            x = element.getAttribute("xb").getFloatValue();
            y = element.getAttribute("yb").getFloatValue();
        } catch (org.jdom2.DataConversionException e) {
            log.error("failed to convert layoutturnout b coords attribute");
        }
        l.setCoordsB(new Point2D.Double(x, y));
        try {
            x = element.getAttribute("xc").getFloatValue();
            y = element.getAttribute("yc").getFloatValue();
        } catch (org.jdom2.DataConversionException e) {
            log.error("failed to convert layoutturnout c coords attribute");
        }
        l.setCoordsC(new Point2D.Double(x, y));
        if(version==2){
            try {
                x = element.getAttribute("xd").getFloatValue();
                y = element.getAttribute("yd").getFloatValue();
                l.setCoordsD(new Point2D.Double(x, y));
            } catch (org.jdom2.DataConversionException e) {
                log.error("failed to convert layoutturnout c coords attribute");
            } catch (java.lang.NullPointerException e) {
                //can be ignored as panel file may not support method
            }
        }
        if (element.getChild("signalAMast") != null) {
            String mast = element.getChild("signalAMast").getText();
            if (mast != null && !mast.isEmpty()) {
                l.setSignalAMast(mast);
            }
        }

        if (element.getChild("signalBMast") != null) {
            String mast = element.getChild("signalBMast").getText();
            if (mast != null && !mast.isEmpty()) {
                l.setSignalBMast(mast);
            }
        }

        if (element.getChild("signalCMast") != null) {
            String mast = element.getChild("signalCMast").getText();
            if (mast != null && !mast.isEmpty()) {
                l.setSignalCMast(mast);
            }
        }

        if (element.getChild("signalDMast") != null) {
            String mast = element.getChild("signalDMast").getText();
            if (mast != null && !mast.isEmpty()) {
                l.setSignalDMast(mast);
            }
        }

        if (element.getChild("sensorA") != null) {
            String sensor = element.getChild("sensorA").getText();
            if (sensor != null && !sensor.isEmpty()) {
                l.setSensorA(sensor);
            }
        }

        if (element.getChild("sensorB") != null) {
            String sensor = element.getChild("sensorB").getText();
            if (sensor != null && !sensor.isEmpty()) {
                l.setSensorB(sensor);
            }
        }

        if (element.getChild("sensorC") != null) {
            String sensor = element.getChild("sensorC").getText();
            if (sensor != null && !sensor.isEmpty()) {
                l.setSensorC(sensor);
            }
        }

        if (element.getChild("sensorD") != null) {
            String sensor = element.getChild("sensorD").getText();
            if (sensor != null && !sensor.isEmpty()) {
                l.setSensorD(sensor);
            }
        }

        p.turnoutList.add(l);
    }

    private final static Logger log = LoggerFactory.getLogger(LayoutTurnoutXml.class.getName());
}
