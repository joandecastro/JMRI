package jmri.jmrix.openlcb;

import java.util.ArrayList;
import jmri.JmriException;
import jmri.Turnout;
import jmri.jmrix.can.CanSystemConnectionMemo;
import jmri.managers.AbstractTurnoutManager;
import org.openlcb.OlcbInterface;

/**
 * OpenLCB implementation of a TurnoutManager.
 * <p>
 * Turnouts must be manually created.
 *
 * @author Bob Jacobsen Copyright (C) 2008, 2010
  * @since 2.3.1
 */
public class OlcbTurnoutManager extends AbstractTurnoutManager {

    public OlcbTurnoutManager(CanSystemConnectionMemo memo) {
        this.memo = memo;
        prefix = memo.getSystemPrefix();
    }

    CanSystemConnectionMemo memo;

    String prefix = "M";
    // Whether we accumulate partially loaded turnouts in pendingTurnouts.
    private boolean isLoading = false;
    // Turnouts that are being loaded from XML.
    private final ArrayList<OlcbTurnout> pendingTurnouts = new ArrayList<>();

    @Override
    public String getSystemPrefix() {
        return prefix;
    }

    /**
     * Internal method to invoke the factory, after all the logic for returning
     * an existing method has been invoked.
     *
     * @return never null
     */
    @Override
    protected Turnout createNewTurnout(String systemName, String userName) {
        String addr = systemName.substring(getSystemPrefix().length() + 1);
        OlcbTurnout t = new OlcbTurnout(getSystemPrefix(), addr, memo.get(OlcbInterface.class));
        t.setUserName(userName);
        synchronized (pendingTurnouts) {
            if (isLoading) {
                pendingTurnouts.add(t);
            } else {
                t.finishLoad();
            }
        }
        return t;
    }

    /**
     * This function is invoked before an XML load is started. We defer initialization of the
     * newly created turnouts until finishLoad because the feedback type might be changing as we
     * are parsing the XML.
     */
    public void startLoad() {
        synchronized (pendingTurnouts) {
            isLoading = true;
        }
    }

    /**
     * This function is invoked after the XML load is complete and all turnouts are instantiated
     * and their feedback type is read in. We use this hook to finalize the construction of the
     * OpenLCB objects whose instantiation was deferred until the feedback type was known.
     */
    public void finishLoad() {
        synchronized (pendingTurnouts) {
            for (OlcbTurnout t : pendingTurnouts) {
                t.finishLoad();
            }
            pendingTurnouts.clear();
            isLoading = false;
        }
    }

    @Override
    public boolean allowMultipleAdditions(String systemName) {
        return false;
    }

    @Override
    public String createSystemName(String curAddress, String prefix) throws JmriException {
        // don't check for integer; should check for validity here
        try {
            validateSystemNameFormat(curAddress);
        } catch (IllegalArgumentException e) {
            throw new JmriException(e.toString());
        }
        return prefix + typeLetter() + curAddress;
    }

    @Override
    public String getNextValidAddress(String curAddress, String prefix) throws JmriException {
        // always return this (the current) name without change
        try {
            validateSystemNameFormat(curAddress);
        } catch (IllegalArgumentException e) {
            throw new JmriException(e.toString());
        }
        return curAddress;
    }

    void validateSystemNameFormat(String address) throws IllegalArgumentException {
        OlcbAddress a = new OlcbAddress(address);
        OlcbAddress[] v = a.split();
        if (v == null) {
            throw new IllegalArgumentException("Did not find usable system name: " + address + " to a valid Olcb turnout address");
        }
        switch (v.length) {
            case 1:
                if (address.startsWith("+") || address.startsWith("-")) {
                    break;
                }
                throw new IllegalArgumentException("can't make 2nd event from systemname " + address);
            case 2:
                break;
            default:
                throw new IllegalArgumentException("Wrong number of events in address: " + address);
        }
    }

    /**
     * A method that creates an array of systems names to allow bulk creation of
     * turnouts.
     * @param start initial id for a range
     * @param numberToAdd size of the range
     * @param prefix system connection prefix
     * @return array system names for range
     */
    //further work needs to be done on how to format a number of turnouts, therefore this method will only return one entry.
    public String[] formatRangeOfAddresses(String start, int numberToAdd, String prefix) {
        numberToAdd = 1;
        String range[] = new String[numberToAdd];
        for (int x = 0; x < numberToAdd; x++) {
            range[x] = prefix + "T" + start;
        }
        return range;
    }
}


