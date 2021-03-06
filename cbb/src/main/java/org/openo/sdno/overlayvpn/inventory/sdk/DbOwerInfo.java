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

package org.openo.sdno.overlayvpn.inventory.sdk;

/**
 * Database owner Info Class.<br>
 * 
 * @author
 * @version SDNO 0.5 May 26, 2016
 */
public class DbOwerInfo {

    /**
     * database owner
     */
    private static String dbOwer;

    /**
     * database bucket name
     */
    private static String bucketName;

    private DbOwerInfo() {

    }

    /**
     * Initialize DB Owner.<br>
     * 
     * @param ower database owner
     * @param dbName bucket name
     * @since SDNO 0.5
     */
    public static void init(String ower, String dbName) {
        dbOwer = ower;
        bucketName = dbName;
    }

    /**
     * Get dbOwer attribute.<br>
     * 
     * @return dbOwer attribute
     * @since SDNO 0.5
     */
    public static String getOwerInfo() {
        return dbOwer;
    }

    /**
     * Get bucketName attribute.<br>
     * 
     * @return bucketName attribute
     * @since SDNO 0.5
     */
    public static String getBucketName() {
        return bucketName;
    }
}
