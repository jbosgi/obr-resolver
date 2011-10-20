/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.felix.resolver.impl;

import java.util.List;
import org.osgi.framework.resource.Capability;
import org.osgi.framework.resource.Requirement;
import org.osgi.framework.resource.Resource;
import org.osgi.framework.resource.Wire;
import org.osgi.framework.resource.Wiring;

class WireImpl implements Wire
{
    private final Wiring m_requirerWiring;
    private final Requirement m_req;
    private final Wiring m_providerWiring;
    private final Capability m_cap;

    public WireImpl(
        Resource requirer, Requirement req,
        Resource provider, Capability cap)
    {
        m_requirerWiring = new WiringImpl(requirer);
        m_req = req;
        m_providerWiring = new WiringImpl(provider);
        m_cap = cap;
    }

    public Wiring getRequirerWiring()
    {
        return m_requirerWiring;
    }

    public Requirement getRequirement()
    {
        return m_req;
    }

    public Wiring getProviderWiring()
    {
        return m_providerWiring;
    }

    public Capability getCapability()
    {
        return m_cap;
    }

    @Override
    public String toString()
    {
        return m_req
            + " -> "
            + "[" + m_providerWiring.getResource() + "]";
    }

    class WiringImpl implements Wiring
    {
        private final Resource m_resource;

        WiringImpl(Resource resource)
        {
            m_resource = resource;
        }

        public List<Capability> getResourceCapabilities(String namespace)
        {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public List<Requirement> getResourceRequirements(String namespace)
        {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public List<Wire> getProvidedResourceWires(String namespace)
        {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public List<Wire> getRequiredResourceWires(String namespace)
        {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public Resource getResource()
        {
            return m_resource;
        }
    }
}