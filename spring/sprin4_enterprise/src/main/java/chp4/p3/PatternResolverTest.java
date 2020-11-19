package chp4.p3;

import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class PatternResolverTest {
    @Test
    public void getResources() throws Exception {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        // 加载所有类包(以及子孙包)下的以.xml为后缀的资源
        Resource resources[] = resolver.getResources("classpath*:com/smart/**/*.xml");
        assertNotNull(resources);
        for (Resource resource:resources) {
            System.out.println(resource.getDescription());

        }
    }

}
