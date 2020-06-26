/*
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License.  You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.apache.tomcat.container;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.catalina.startup.LoggingBaseTest;
import org.junit.Ignore;
import org.junit.Test;

public class TestStandardContainer extends LoggingBaseTest {

    @Test
    public void testExamples() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples");
    }

    @Test
    public void testExamplesServlets() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/servlets/");
    }

    @Test
    public void testExamplesServletsServletHelloWorldExample() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/servlets/servlet/HelloWorldExample");
    }

    @Test
    public void testExamplesServletsServletRequestInfoExample() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/servlets/servlet/RequestInfoExample");
    }

    @Test
    public void testExamplesServletsServletRequestHeaderExample() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/servlets/servlet/RequestHeaderExample");
    }

    @Test
    public void testExamplesServletsServletRequestParamExample() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/servlets/servlet/RequestParamExample");
    }

    @Test
    public void testExamplesServletsServletCookieExample() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/servlets/servlet/CookieExample");
    }

    @Test
    public void testExamplesServletsServletSessionExample() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/servlets/servlet/SessionExample");
    }

    @Test
    public void testExamplesAsyncAsync0() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/async/async0");
    }

    @Test
    public void testExamplesAsyncAsync1() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/async/async1");
    }

    @Test
    public void testExamplesAsyncAsync2() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/async/async2");
    }

    @Test
    public void testExamplesAsyncAsync3() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/async/async3");
    }

    @Ignore("TODO Work on timing")
    @Test
    public void testExamplesAsyncStockticker() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/async/stockticker");
    }

    @Test
    public void testExamplesServletsNonblockingBytecounterHtml() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/servlets/nonblocking/bytecounter.html");
    }

    @Test
    public void testExamplesServletsNonblockingNumberwriter() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/servlets/nonblocking/numberwriter");
    }

    @Test
    public void testExamplesServletsServerpushSimpleimage() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/servlets/serverpush/simpleimage");
    }

    @Test
    public void testExamplesServletsTrailersResponse() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/servlets/trailers/response");
    }

    @Test
    public void testExamplesJsp() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/");
    }

    @Test
    public void testExamplesJspJsp2ElBasicArithmeticJsp() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/jsp2/el/basic-arithmetic.jsp");
    }

    @Test
    public void testExamplesJspJsp2ElBasicComparisonsJsp() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/jsp2/el/basic-comparisons.jsp");
    }

    @Test
    public void testExamplesJspJsp2ElImplicitObjectsJspFooBar() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/jsp2/el/implicit-objects.jsp?foo=bar");
    }

    @Test
    public void testExamplesJspJsp2ElFunctionsJspFooJSP20() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/jsp2/el/functions.jsp?foo=JSP+2.0");
    }

    @Test
    public void testExamplesJspJsp2ElCompositeJsp() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/jsp2/el/composite.jsp");
    }

    @Test
    public void testExamplesJspJsp2SimpletagHelloJsp() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/jsp2/simpletag/hello.jsp");
    }

    @Test
    public void testExamplesJspJsp2SimpletagRepeatJsp() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/jsp2/simpletag/repeat.jsp");
    }

    @Test
    public void testExamplesJspJsp2SimpletagBookJsp() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/jsp2/simpletag/book.jsp");
    }

    @Test
    public void testExamplesJspJsp2TagfilesHelloJsp() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/jsp2/tagfiles/hello.jsp");
    }

    @Test
    public void testExamplesJspJsp2TagfilesPanelJsp() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/jsp2/tagfiles/panel.jsp");
    }

    @Test
    public void testExamplesJspJsp2TagfilesProductsJsp() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/jsp2/tagfiles/products.jsp");
    }

    @Test
    public void testExamplesJspJsp2JspxBasicJspx() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/jsp2/jspx/basic.jspx");
    }

    @Test
    public void testExamplesJspJsp2JspxSvgexampleHtml() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/jsp2/jspx/svgexample.html");
    }

    @Test
    public void testExamplesJspJsp2JspattributeJspattributeJsp() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/jsp2/jspattribute/jspattribute.jsp");
    }

    @Test
    public void testExamplesJspJsp2JspattributeShuffleJsp() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/jsp2/jspattribute/shuffle.jsp");
    }

    @Test
    public void testExamplesJspJsp2MiscDynamicattrsJsp() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/jsp2/misc/dynamicattrs.jsp");
    }

    @Test
    public void testExamplesJspJsp2MiscConfigJsp() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/jsp2/misc/config.jsp");
    }

    @Test
    public void testExamplesJspNumNumguessJsp() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/num/numguess.jsp");
    }

    @Test
    public void testExamplesJspDatesDateJsp() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/dates/date.jsp");
    }

    @Test
    public void testExamplesJspSnpSnoopJsp() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/snp/snoop.jsp");
    }

    @Test
    public void testExamplesJspErrorErrorHtml() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/error/error.html");
    }

    @Test
    public void testExamplesJspSessionsCartsHtml() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/sessions/carts.html");
    }

    @Test
    public void testExamplesJspCheckboxCheckHtml() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/checkbox/check.html");
    }

    @Test
    public void testExamplesJspColorsColorsHtml() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/colors/colors.html");
    }

    @Test
    public void testExamplesJspCalLoginHtml() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/cal/login.html");
    }

    @Test
    public void testExamplesJspIncludeIncludeJsp() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/include/include.jsp");
    }

    @Test
    public void testExamplesJspForwardForwardJsp() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/forward/forward.jsp");
    }

    @Test
    public void testExamplesJspPluginPluginJsp() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/plugin/plugin.jsp");
    }

    @Test
    public void testExamplesJspJsptoservJsptoservletJsp() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/jsptoserv/jsptoservlet.jsp");
    }

    @Test
    public void testExamplesJspSimpletagFooJsp() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/simpletag/foo.jsp");
    }

    @Test
    public void testExamplesJspXmlXmlJsp() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/xml/xml.jsp");
    }

    @Test
    public void testExamplesJspTagpluginIfJsp() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/tagplugin/if.jsp");
    }

    @Test
    public void testExamplesJspTagpluginForeachJsp() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/tagplugin/foreach.jsp");
    }

    @Test
    public void testExamplesJspTagpluginChooseJsp() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/tagplugin/choose.jsp");
    }

    @Test
    public void testExamplesJspSecurityProtectedIndexJsp() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/jsp/security/protected/index.jsp");
    }

    @Test
    public void testExamplesWebsocketIndexXhtml() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/websocket/index.xhtml");
    }

    @Test
    public void testExamplesWebsocketEchoXhtml() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/websocket/echo.xhtml");
    }

    @Test
    public void testExamplesWebsocketChatXhtml() throws Exception {
        assertResponseCode(200, "http://localhost:8080/examples/websocket/chat.xhtml");
    }

    public void assertResponseCode(int code, String url) throws Exception {
        Response response = request(url);
        assertEquals(code, response.responseCode);
    }

    public Response request(String urlString) throws IOException {
        return request(urlString, Collections.emptyMap());
    }

    public Response request(String urlString, Map<String, List<String>> headers) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();

        connection.setConnectTimeout(60000);
        connection.setReadTimeout(60000);

        Optional.ofNullable(headers).orElseGet(Collections::emptyMap).forEach((k ,v) -> {
            for(String entryValue : v) {
                connection.setRequestProperty(k, entryValue);
            }
        });

        int responseCode = connection.getResponseCode();

        InputStream stream;

        if (responseCode >= 400) {
            stream = connection.getErrorStream();
        }
        else {
            stream = connection.getInputStream();
        }

        try {
            String responseBody = drain(stream);

            return new Response(responseCode, responseBody, connection.getHeaderFields());
        }
        finally {
            stream.close();
        }
    }

    private String drain(InputStream stream) throws IOException {
        byte[] bytes = new byte[100];
        StringBuilder buffer = new StringBuilder(500);
        int length;
        while ((length = stream.read(bytes)) != -1) {
            String chunk = new String(bytes, 0, length);
            buffer.append(chunk);
        }
        return buffer.toString();
    }

    class Response {
        int responseCode;
        String responseBody;
        Map<String, List<String>> headers;
        public Response(int responseCode, String responseBody, Map<String, List<String>> headers) {
            this.responseCode = responseCode;
            this.responseBody = responseBody;
            this.headers = headers;
        }
    }

}
