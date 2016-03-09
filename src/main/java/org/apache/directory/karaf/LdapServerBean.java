/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apache.directory.karaf;

import org.apache.directory.server.core.DefaultDirectoryService;
import org.apache.directory.server.core.api.DirectoryService;
import org.apache.directory.server.ldap.LdapServer;
import org.apache.directory.server.protocol.shared.transport.TcpTransport;

/**
 * Starts an ApacheDS LDAP server.
 */
public class LdapServerBean {

    /**
     * LDAP port.
     */
    private int port = 10389;

    private DirectoryService directoryService;
    private org.apache.directory.server.ldap.LdapServer ldapServer;
    private TcpTransport ldapTransport;

    public LdapServerBean() throws Exception {
        directoryService = new DefaultDirectoryService();
        ldapServer = new LdapServer();
        ldapServer.setDirectoryService(directoryService);
    }

    public void setPort(int port) {
        this.port = port;
        if (ldapTransport != null) {
            ldapTransport.setPort(port);
        }
    }

    public void startServer() throws Exception {
        ldapTransport = new TcpTransport(port);
        ldapServer.setTransports(ldapTransport);

        directoryService.startup();
        ldapServer.start();
    }

    public void stopServer() throws Exception {
        ldapServer.stop();
        directoryService.shutdown();
    }

}
