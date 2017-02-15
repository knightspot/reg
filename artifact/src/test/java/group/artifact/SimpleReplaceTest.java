package group.artifact;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;


import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class,loader=AnnotationConfigContextLoader.class)
public class SimpleReplaceTest 
    extends TestCase
{
	@Autowired
	private Replace simpleReplace;
	
	@Test
	public void testSimpleReplace() {
		assertEquals("class group.artifact.SimpleReplace",this.simpleReplace.getClass().toString());
	}
	
	@Test
	public void testReplace(){
		// Livet är en fest ring +4689078 för tips 
		// Livet är en fest ring [xxxxxx] för tips
		simpleReplace.setFrom("\\+[0-9]{7}");
		simpleReplace.setTo("[xxxxxx]");
		assertEquals(simpleReplace.replace("Livet är en fest ring +4689078 för tips"),"Livet är en fest ring [xxxxxx] för tips");
		
	}
}
