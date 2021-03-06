/*
 * Copyright 2019 Red Hat, Inc.
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
package io.quarkus.keycloak;

import org.keycloak.adapters.AdapterDeploymentContext;
import org.keycloak.adapters.KeycloakDeployment;
import org.keycloak.representations.adapters.config.AdapterConfig;

/**
 * An extension to Keycloak default {@code AdapterDeploymentContext} so that any additional requirement on how
 * {@link KeycloakDeployment}
 * instances are resolved.
 *
 * @author <a href="mailto:psilva@redhat.com">Pedro Igor</a>
 */
public class QuarkusDeploymentContext extends AdapterDeploymentContext {

    private KeycloakDeployment defaultDeployment;

    public QuarkusDeploymentContext() {
    }

    public QuarkusDeploymentContext(KeycloakDeployment defaultDeployment) {
        this.defaultDeployment = defaultDeployment;
    }

    void setConfigResolver(QuarkusKeycloakConfigResolver configResolver) {
        super.configResolver = configResolver;
        configResolver.init(defaultDeployment);
    }
}
