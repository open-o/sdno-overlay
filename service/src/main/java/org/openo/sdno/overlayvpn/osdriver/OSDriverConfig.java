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

package org.openo.sdno.overlayvpn.osdriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * OsDriver Configuration Operation Class.<br>
 * 
 * @author
 * @version SDNO 0.5 August 9, 2016
 */
public class OSDriverConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(OSDriverConfig.class);

    private static final String OS_DRIVER_CONFIG = "etc/osdriver.properties";

    private Properties properties = new Properties();

    /**
     * Constructor.<br>
     * 
     * @since SDNO 0.5
     */
    public OSDriverConfig() {
        loadProperties();
    }

    /**
     * Get VIM Name.<br>
     * 
     * @return VIM Name
     * @since SDNO 0.5
     */
    public String getVimName() {
        return properties.getProperty("vim_name");
    }

    private void loadProperties() {
        try {
            FileInputStream fin = new FileInputStream(OS_DRIVER_CONFIG);
            properties.load(fin);
        } catch(IOException e) {
            LOGGER.error("Load Property File failed!", e);
        }
    }
}
