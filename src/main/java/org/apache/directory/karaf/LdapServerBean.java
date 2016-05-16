/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apache.directory.karaf;

import org.apache.directory.server.core.api.InstanceLayout;

/**
 * Starts an ApacheDS LDAP server.
 */
public class LdapServerBean {

    /**
     * LDAP port.
     */
    private int port = 10389;

    private ApacheDsService apacheDsService;
    private final InstanceLayout instanceLayout;

    public LdapServerBean(InstanceLayout instanceLayout) throws Exception {
        apacheDsService = new ApacheDsService();
        this.instanceLayout = instanceLayout;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void startServer() throws Exception {
        apacheDsService.start(instanceLayout);

    }

    public void stopServer() throws Exception {
        apacheDsService.stop();
    }

}
