/*
 * Copyright 2016 Huawei Technologies Co., Ltd.
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

package org.openo.sdno.overlayvpnservice.site2dc.mocoserver;

import org.openo.sdno.testframework.moco.MocoHttpServer;

/**
 * SbiAdapterSuccessServer class for success test cases. <br>
 * 
 * @author
 * @version SDNO 0.5 June 16, 2016
 */
public class MockVxlanSbiSuccessServer extends MocoHttpServer {

    private static final String CREATE_VXLAN_FILE =
            "src/integration-test/resources/site2dc/moco/vxlan/createvxlan.json";

    private static final String DELETE_VXLAN_FILE =
            "src/integration-test/resources/site2dc/moco/vxlan/deletevxlan.json";

    private static final String UPDATE_VXLAN_FILE =
            "src/integration-test/resources/site2dc/moco/vxlan/updatevxlan.json";

    private static final String DEPLOY_VXLAN_FILE =
            "src/integration-test/resources/site2dc/moco/vxlan/deployvxlan.json";

    private static final String QUERY_VXLAN_FILE = "src/integration-test/resources/site2dc/moco/vxlan/queryvxlan.json";

    public MockVxlanSbiSuccessServer() {
        super(12309);
    }

    @Override
    public void addRequestResponsePairs() {

        this.addRequestResponsePair(CREATE_VXLAN_FILE);

        this.addRequestResponsePair(DELETE_VXLAN_FILE);

        this.addRequestResponsePair(UPDATE_VXLAN_FILE);

        this.addRequestResponsePair(DEPLOY_VXLAN_FILE);

        this.addRequestResponsePair(QUERY_VXLAN_FILE);
    }

}
