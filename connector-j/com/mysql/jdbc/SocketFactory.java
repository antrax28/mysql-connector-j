/*
   Copyright (C) 2002 MySQL AB
   
      This program is free software; you can redistribute it and/or modify
      it under the terms of the GNU General Public License as published by
      the Free Software Foundation; either version 2 of the License, or
      (at your option) any later version.
   
      This program is distributed in the hope that it will be useful,
      but WITHOUT ANY WARRANTY; without even the implied warranty of
      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
      GNU General Public License for more details.
   
      You should have received a copy of the GNU General Public License
      along with this program; if not, write to the Free Software
      Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
      
 */
package com.mysql.jdbc;

import java.io.IOException;

import java.net.Socket;
import java.net.SocketException;

import java.util.Properties;


/**
 * DOCUMENT ME!
 * 
 * @author Owner To change this generated comment edit the template variable
 *         "typecomment": Window>Preferences>Java>Templates. To enable and
 *         disable the creation of type comments go to
 *         Window>Preferences>Java>Code Generation.
 */
public interface SocketFactory
{

    //~ Methods ...............................................................

    /**
     * Creates a new socket using the given properties.  Properties are parsed
     * by the driver from the URL.  All properties other than sensitive ones
     * (user and password) are passed to this method.  The driver will
     * instantiate the socket factory with the class name given in the
     * property &quot;socketFactory&quot;, where the standard is
     * <code>com.mysql.jdbc.StandardSocketFactory</code>  Implementing classes
     * are responsible for handling synchronization of this method (if
     * needed).
     * @param props DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     * @throws SocketException DOCUMENT ME!
     * @throws IOException DOCUMENT ME!
     */
    public Socket connect(String host, Properties props)
                        throws SocketException, IOException;
                        
    /**
     * Called by the driver before issuing the MySQL protocol handshake.
     * Should return the socket instance that should be used during
     * the handshake.
     */
    public Socket beforeHandshake() throws SocketException, IOException;
    
    /**
     * Called by the driver after issuing the MySQL protocol handshake and
     * reading the results of the handshake.
     */
    public Socket afterHandshake() throws SocketException, IOException;

    //~ Inner classes .........................................................

  
}