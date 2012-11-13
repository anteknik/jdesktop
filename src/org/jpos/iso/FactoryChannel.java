/*
 * Copyright (c) 2004 jPOS.org 
 *
 * See terms of license at http://jpos.org/license.html
 *
 */

package org.jpos.iso;

/**
 * Channels that can use socket factories need to implement this.
 *
 * @author <a href="mailto:alwynschoeman@yahoo.com">Alwyn Schoeman</a>
 * @version $Revision$ $Date: 2004-05-05 11:20:43 -0300 (Wed, 05 May 2004) $
 */

public interface FactoryChannel {
    /**
     * @param sfac a socket factory
     */
    public void setSocketFactory(ISOClientSocketFactory sfac);
}
