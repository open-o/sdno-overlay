/*
 * Copyright 2017 Huawei Technologies Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openo.sdno.overlayvpn.servicemodel.enums;

/**
 * The topology type.<br>
 * 
 * @author
 * @version SDNO 0.5 Jan 24, 2017
 */
public enum Topology {
    POINT_TO_POINT("point_to_point"), FULL_MESH("full_mesh"), HUB_SPOKER("hub_spoker");

    private String topology;

    private Topology(String topology) {
        this.setTopology(topology);
    }

    public String getTopology() {
        return topology;
    }

    public void setTopology(String topology) {
        this.topology = topology;
    }

    /**
     * Get Topology by type name.<br>
     * 
     * @param type The type name
     * @return The Topology object
     * @since SDNO 0.5
     */
    public static Topology getTopology(String type) {
        for(Topology topology : Topology.values()) {
            if(topology.name().equalsIgnoreCase(type) || topology.getTopology().equalsIgnoreCase(type)) {
                return topology;
            }
        }
        return null;
    }
}