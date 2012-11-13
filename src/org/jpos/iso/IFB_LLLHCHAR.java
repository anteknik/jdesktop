/*
 * Copyright (c) 2004 jPOS.org 
 *
 * See terms of license at http://jpos.org/license.html
 *
 */

package org.jpos.iso;

/**
 * ISOFieldPackager Binary Hex LLLCHAR
 *
 * @author apr@cs.com.uy
 * @version $Id: IFB_LLLHCHAR.java 2436 2007-03-23 17:40:57Z apr $
 * @see ISOComponent
 */
public class IFB_LLLHCHAR extends ISOStringFieldPackager {
    public IFB_LLLHCHAR() {
        super(NullPadder.INSTANCE, AsciiInterpreter.INSTANCE, BinaryPrefixer.BB);
    }
    /**
     * @param len - field len
     * @param description symbolic descrption
     */
    public IFB_LLLHCHAR(int len, String description) {
        super(len, description, NullPadder.INSTANCE, AsciiInterpreter.INSTANCE, BinaryPrefixer.BB);
        checkLength(len, 65535);
    }

    public void setLength(int len)
    {
        checkLength(len, 65535);
        super.setLength(len);
    }
}

