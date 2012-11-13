package org.jpos.util;

import org.jpos.iso.ISOException;

/**
 * AssertFailedException
 * @author  <a href="mailto:apr@cs.com.uy">Alejandro P. Revilla</a>
 * @version $Revision$ $Date: 2006-05-01 10:57:55 -0300 (Mon, 01 May 2006) $
 */
public class AssertFailedException extends ISOException {
    public AssertFailedException() {
        super();
    }
    public AssertFailedException (String s) {
        super(s);
    }
    public AssertFailedException (Exception nested) {
        super(nested);
    }
    public AssertFailedException (String s, Exception nested) {
        super(s, nested);
    }
}
