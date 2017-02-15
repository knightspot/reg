package group.artifact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
        FileFetcher fetcher = (FileFetcher) context.getBean("fileFetcherBean");
        Replace replace = (Replace) context.getBean("replaceBean");
        fetcher.print();
        String ut = fetcher.fetch();
        while (ut!=null){
        	System.out.println(ut + "->" + replace.replace(ut));
        	ut = fetcher.fetch();
        }
    }
}
