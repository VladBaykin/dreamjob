package dream.servlet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import dream.store.MemStore;
import dream.store.PsqlStore;
import dream.store.Store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(PsqlStore.class)

public class PostServletTest {

    @Test
    public void whenAddPostThenStoreIt() throws IOException, ServletException {
        PowerMockito.mockStatic(PsqlStore.class);
        Store store = MemStore.instOf();
        Mockito.when(PsqlStore.instOf()).thenReturn(store);

        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("id")).thenReturn("0");
        when(req.getParameter("name")).thenReturn("Name Surname");
        new PostServlet().doPost(req, resp);

        assertEquals("Name Surname", store.findAllPosts().iterator().next().getName());
    }


}