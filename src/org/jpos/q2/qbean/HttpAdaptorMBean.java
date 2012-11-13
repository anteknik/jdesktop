/*
 * Copyright (c) 2004 jPOS.org 
 *
 * See terms of license at http://jpos.org/license.html
 *
 */
package org.jpos.q2.qbean;

import org.jpos.q2.QBeanSupportMBean;

/**
 * @author <a href="mailto:taherkordy@dpi2.dpi.net.ir">Alireza Taherkordi</a>
 * @version $Revision$ $Date: 2004-04-10 14:26:11 -0300 (Sat, 10 Apr 2004) $
 */
public interface HttpAdaptorMBean
        extends mx4j.tools.adaptor.http.HttpAdaptorMBean,QBeanSupportMBean
{
    public void setUser (String user);
    public String getUser ();
    public void setPassword (String password);
    public void init ();
    public void start ();
    public void stop ();
    public void destroy ();
}
