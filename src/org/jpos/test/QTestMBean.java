package org.jpos.test;
import org.jdom.Element;
public interface QTestMBean extends org.jpos.q2.QBeanSupportMBean {
public Element getPersist ();
public void setTickInterval(long tickInterval) ;
public long getTickInterval() ;
}