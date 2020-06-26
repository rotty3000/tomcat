/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.tomcat.util.ant;

import java.io.PrintWriter;
import java.net.Socket;

public class Shutdown {

    public void execute() throws Exception {
        Socket socket = new Socket("localhost", 8005);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("SHUTDOWN");
        socket.close();
        Thread.sleep(1000);
    }

}
