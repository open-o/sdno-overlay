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

package org.openo.sdno.overlayvpn.model.uuid;

import org.openo.baseservice.remoteservice.exception.ServiceException;

/**
 * Interface of UUID Allocation.<br>
 * <p>
 * </p>
 * 
 * @author
 * @version SDNO 0.5 June 3, 2016
 */
public interface IAllocateUuid {

    /**
     * Interface of Allocate UUID.<br>
     * 
     * @since SDNO 0.5
     */
    void allocateUuid();

    /**
     * Interface of Check UUID.<br>
     * 
     * @throws ServiceException
     * @since SDNO 0.5
     */
    void checkUuid() throws ServiceException;
}
