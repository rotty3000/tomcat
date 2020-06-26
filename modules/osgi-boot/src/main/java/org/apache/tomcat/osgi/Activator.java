/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.tomcat.osgi;

import java.net.URLStreamHandlerFactory;
import java.util.Hashtable;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import org.apache.catalina.startup.Catalina;
import org.apache.catalina.webresources.TomcatURLStreamHandlerFactory;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.osgi.annotation.bundle.Header;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;

/**
 * @author Raymond Augé
 */
@Header(name = Constants.BUNDLE_ACTIVATOR, value = "${@class}")
public class Activator implements BundleActivator {

    private static final String WAR_PROTOCOL = "war";
    private static final String CLASSPATH_PROTOCOL = "classpath";

    private static final Log log = LogFactory.getLog(Catalina.class);
    private static final AtomicReference<Catalina> catalinaReference = new AtomicReference<>();

    private ServiceRegistration<URLStreamHandlerFactory> registration;

    @SuppressWarnings({ "unchecked", "serial", "rawtypes" })
    public void start(BundleContext context) throws Exception {
        TomcatURLStreamHandlerFactory.disable();

        registration = context.registerService(
            URLStreamHandlerFactory.class,
            TomcatURLStreamHandlerFactory.getInstance(),
            new Hashtable() {{put("url.handler.protocol", new String[] {WAR_PROTOCOL, CLASSPATH_PROTOCOL});}});

        String[] args = Optional.ofNullable(
            System.getProperty("launcher.arguments")
        ).map(
            arg -> arg.split("\\s*,\\s*")
        ).orElseGet(() -> new String[] {"start"});

        ClassLoader parentClassLoader = Catalina.class.getClassLoader();
        Thread thread = Thread.currentThread();
        ClassLoader original = thread.getContextClassLoader();
        try {
            thread.setContextClassLoader(parentClassLoader);

            Catalina catalina = new Catalina();
            catalina.setParentClassLoader(parentClassLoader);
            catalina.load(args);
            catalina.start();

            catalinaReference.set(catalina);
        }
        catch (Throwable t) {
            log.error("Error during Tomcat startup", t);
        }
        finally {
            thread.setContextClassLoader(original);
        }
    }

    public void stop(BundleContext context) throws Exception {
        Catalina catalina = catalinaReference.getAndSet(null);
        if (catalina != null) {
            try {
                catalina.stop();
            }
            catch (Throwable t) {
                log.error("Error during Tomcat shutdown", t);
            }
        }
        if (registration != null) {
            registration.unregister();
        }
    }

}
