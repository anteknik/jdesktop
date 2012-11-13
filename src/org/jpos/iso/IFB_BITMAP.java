/*
 * Copyright (c) 2000 jPOS.org.  All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution,
 *    if any, must include the following acknowledgment:
 *    "This product includes software developed by the jPOS project 
 *    (http://www.jpos.org/)". Alternately, this acknowledgment may 
 *    appear in the software itself, if and wherever such third-party 
 *    acknowledgments normally appear.
 *
 * 4. The names "jPOS" and "jPOS.org" must not be used to endorse 
 *    or promote products derived from this software without prior 
 *    written permission. For written permission, please contact 
 *    license@jpos.org.
 *
 * 5. Products derived from this software may not be called "jPOS",
 *    nor may "jPOS" appear in their name, without prior written
 *    permission of the jPOS project.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.  
 * IN NO EVENT SHALL THE JPOS PROJECT OR ITS CONTRIBUTORS BE LIABLE FOR 
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL 
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS 
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) 
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, 
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING 
 * IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
 * POSSIBILITY OF SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the jPOS Project.  For more
 * information please see <http://www.jpos.org/>.
 */

package org.jpos.iso;

import java.io.IOException;
import java.io.InputStream;
import java.util.BitSet;

/**
 * ISOFieldPackager Binary Bitmap
 *
 * @author apr@cs.com.uy
 * @version $Id: IFB_BITMAP.java 2371 2006-09-19 12:03:52Z apr $
 * @see ISOComponent
 * @see ISOBitMapPackager
 */
public class IFB_BITMAP extends ISOBitMapPackager {
    public IFB_BITMAP() {
        super();
    }
    /**
     * @param len - field len
     * @param description symbolic descrption
     */
    public IFB_BITMAP(int len, String description) {
        super(len, description);
    }
    /**
     * @param c - a component
     * @return packed component
     * @exception ISOException
     */
    public byte[] pack (ISOComponent c) throws ISOException {
        return ISOUtil.bitSet2byte ((BitSet) c.getValue());
    }
    /**
     * @param c - the Component to unpack
     * @param b - binary image
     * @param offset - starting offset within the binary image
     * @return consumed bytes
     * @exception ISOException
     */
    public int unpack (ISOComponent c, byte[] b, int offset)
        throws ISOException
    {
        int len;
        BitSet bmap = ISOUtil.byte2BitSet (b, offset, getLength() << 3);
        c.setValue(bmap);
        len = bmap.get(1) ? 128 : 64;
        if (getLength() > 16 && bmap.get(65))
            len = 192;
        return (Math.min (getLength(), len >> 3));
    }
    public void unpack (ISOComponent c, InputStream in) 
        throws IOException, ISOException
    {
        BitSet bmap = ISOUtil.byte2BitSet (new BitSet (64), readBytes (in, 8), 0);
        if (getLength() > 8 && bmap.get (1)) {
            ISOUtil.byte2BitSet (bmap, readBytes (in, 8), 64); 
        }
        if (getLength() > 16 && bmap.get (65)) {
            ISOUtil.byte2BitSet (bmap, readBytes (in, 8), 128); 
        }
        c.setValue(bmap);
    }
    public int getMaxPackedLength() {
        return getLength() >> 3;
    }
}
