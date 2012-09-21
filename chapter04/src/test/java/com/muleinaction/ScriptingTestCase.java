
package com.muleinaction;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.mule.api.MuleMessage;
import org.mule.module.client.MuleClient;
import org.mule.tck.junit4.FunctionalTestCase;

public class ScriptingTestCase extends FunctionalTestCase
{

    @Override
    protected String getConfigResources()
    {
        return "byte-array-to-object.xml";
    }

    @Test
    public void testScripting() throws Exception
    {
        MuleClient muleClient = new MuleClient(muleContext);

        Map<String, String> map = new HashMap<String, String>();
        map.put("Iamakey", "Iamavalue");

        MuleMessage result = muleClient.send("vm://byte-array-to-object.in", map, null);

        assertThat(result.getPayload().equals(map), is(true));
    }

}