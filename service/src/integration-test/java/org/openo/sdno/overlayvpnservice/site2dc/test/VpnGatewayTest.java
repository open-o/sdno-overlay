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

package org.openo.sdno.overlayvpnservice.site2dc.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openo.baseservice.remoteservice.exception.ServiceException;
import org.openo.sdno.exception.HttpCode;
import org.openo.sdno.overlayvpnservice.site2dc.msbmanager.MsbRegisterManager;
import org.openo.sdno.testframework.checker.IChecker;
import org.openo.sdno.testframework.http.model.HttpModelUtils;
import org.openo.sdno.testframework.http.model.HttpRequest;
import org.openo.sdno.testframework.http.model.HttpResponse;
import org.openo.sdno.testframework.http.model.HttpRquestResponse;
import org.openo.sdno.testframework.replace.PathReplace;
import org.openo.sdno.testframework.testmanager.TestManager;

public class VpnGatewayTest extends TestManager {

    private static final String CREATE_VPN_FILE = "src/integration-test/resources/site2dc/testcase/vpn/createvpn.json";

    private static final String DELETE_VPN_FILE = "src/integration-test/resources/site2dc/testcase/vpn/deletevpn.json";

    private static final String CREATE_VPNGATEWAY_FILE =
            "src/integration-test/resources/site2dc/testcase/vpngateway/createvpngateway.json";

    private static final String CREATE_VPNGATEWAY_REGION_FILE =
            "src/integration-test/resources/site2dc/testcase/vpngateway/createvpngatewayregion.json";

    private static final String DELETE_VPNGATEWAY_FILE =
            "src/integration-test/resources/site2dc/testcase/vpngateway/deletevpngateway.json";

    private static final String UPDATE_VPNGATEWAY_FILE =
            "src/integration-test/resources/site2dc/testcase/vpngateway/updatevpngateway.json";

    private static final String QUERY_VPNGATEWAY_FILE =
            "src/integration-test/resources/site2dc/testcase/vpngateway/queryvpngateway.json";

    private static final String BATCH_QUERY_VPNGATEWAY_FILE =
            "src/integration-test/resources/site2dc/testcase/vpngateway/batchqueryvpngateway.json";

    @BeforeClass
    public static void setup() throws ServiceException {
        MsbRegisterManager.registerMsb();
    }

    @AfterClass
    public static void tearDown() throws ServiceException {
        MsbRegisterManager.unRegisterMsb();
    }

    @Test
    public void testOperateVpnGateway() throws ServiceException {
        HttpRquestResponse httpCreateVpnObject = HttpModelUtils.praseHttpRquestResponseFromFile(CREATE_VPN_FILE);
        HttpRequest createVpnRequest = httpCreateVpnObject.getRequest();
        execTestCase(createVpnRequest, new SuccessChecker());

        HttpRquestResponse httpCreateObject = HttpModelUtils.praseHttpRquestResponseFromFile(CREATE_VPNGATEWAY_FILE);
        HttpRequest createRequest = httpCreateObject.getRequest();
        execTestCase(createRequest, new SuccessChecker());

        execTestCase(createRequest, new FailedChecker());

        createRequest.setData(null);
        execTestCase(createRequest, new FailedChecker());

        HttpRquestResponse updateHttpObject = HttpModelUtils.praseHttpRquestResponseFromFile(UPDATE_VPNGATEWAY_FILE);
        HttpRequest updateReq = updateHttpObject.getRequest();
        updateReq.setUri(PathReplace.replaceUuid("uuid", updateReq.getUri(), "test_uuid"));
        execTestCase(updateReq, new SuccessChecker());

        updateReq.setData(null);
        execTestCase(updateReq, new FailedChecker());

        HttpRquestResponse updateUnexistHttpObject =
                HttpModelUtils.praseHttpRquestResponseFromFile(UPDATE_VPNGATEWAY_FILE);
        HttpRequest updateUnexistReq = updateUnexistHttpObject.getRequest();
        updateUnexistReq.setUri(PathReplace.replaceUuid("uuid", updateUnexistReq.getUri(), "unexist"));
        execTestCase(updateUnexistReq, new FailedChecker());

        HttpRquestResponse queryHttpObject = HttpModelUtils.praseHttpRquestResponseFromFile(QUERY_VPNGATEWAY_FILE);
        HttpRequest queryReq = queryHttpObject.getRequest();
        queryReq.setUri(PathReplace.replaceUuid("uuid", queryReq.getUri(), "test_uuid"));
        execTestCase(queryReq, new SuccessChecker());

        HttpRquestResponse batchQueryHttpObject =
                HttpModelUtils.praseHttpRquestResponseFromFile(BATCH_QUERY_VPNGATEWAY_FILE);
        HttpRequest batchQueryReq = batchQueryHttpObject.getRequest();
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("name", "test_name");
        batchQueryReq.setQueries(paramMap);
        execTestCase(batchQueryReq, new SuccessChecker());

        HttpRquestResponse deleteHttpObject = HttpModelUtils.praseHttpRquestResponseFromFile(DELETE_VPNGATEWAY_FILE);
        HttpRequest deleteReq = deleteHttpObject.getRequest();
        deleteReq.setUri(PathReplace.replaceUuid("uuid", deleteReq.getUri(), "test_uuid"));
        execTestCase(deleteReq, new SuccessChecker());

        HttpRquestResponse deleteVpnHttpObject = HttpModelUtils.praseHttpRquestResponseFromFile(DELETE_VPN_FILE);
        HttpRequest deleteVpnReq = deleteVpnHttpObject.getRequest();
        deleteVpnReq.setUri(PathReplace.replaceUuid("uuid", deleteVpnReq.getUri(), "test_uuid"));
        execTestCase(deleteVpnReq, new SuccessChecker());

    }

    @Test
    public void testCreateVpnGatewayRegion() throws ServiceException {
        HttpRquestResponse httpCreateVpnObject = HttpModelUtils.praseHttpRquestResponseFromFile(CREATE_VPN_FILE);
        HttpRequest createVpnRequest = httpCreateVpnObject.getRequest();
        execTestCase(createVpnRequest, new SuccessChecker());

        HttpRquestResponse httpCreateObject =
                HttpModelUtils.praseHttpRquestResponseFromFile(CREATE_VPNGATEWAY_REGION_FILE);
        HttpRequest createRequest = httpCreateObject.getRequest();
        execTestCase(createRequest, new SuccessChecker());

        HttpRquestResponse deleteHttpObject = HttpModelUtils.praseHttpRquestResponseFromFile(DELETE_VPNGATEWAY_FILE);
        HttpRequest deleteReq = deleteHttpObject.getRequest();
        deleteReq.setUri(PathReplace.replaceUuid("uuid", deleteReq.getUri(), "test_uuid"));
        execTestCase(deleteReq, new SuccessChecker());

        HttpRquestResponse deleteVpnHttpObject = HttpModelUtils.praseHttpRquestResponseFromFile(DELETE_VPN_FILE);
        HttpRequest deleteVpnReq = deleteVpnHttpObject.getRequest();
        deleteVpnReq.setUri(PathReplace.replaceUuid("uuid", deleteVpnReq.getUri(), "test_uuid"));
        execTestCase(deleteVpnReq, new SuccessChecker());
    }

    @Test
    public void testDeleteVpnGatewaySuccess() throws ServiceException {
        HttpRquestResponse deleteHttpObject = HttpModelUtils.praseHttpRquestResponseFromFile(DELETE_VPNGATEWAY_FILE);
        HttpRequest deleteReq = deleteHttpObject.getRequest();
        deleteReq.setUri(PathReplace.replaceUuid("uuid", deleteReq.getUri(), "unexist"));
        execTestCase(deleteReq, new SuccessChecker());
    }

    private class SuccessChecker implements IChecker {

        @Override
        public boolean check(HttpResponse response) {
            if(HttpCode.isSucess(response.getStatus())) {
                return true;
            }

            return false;
        }
    }

    private class FailedChecker implements IChecker {

        @Override
        public boolean check(HttpResponse response) {
            if(!HttpCode.isSucess(response.getStatus())) {
                return true;
            }

            return false;
        }
    }
}
