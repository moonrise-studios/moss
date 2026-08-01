package gg.moonrise.moss.velocity;

import com.velocitypowered.api.proxy.ProxyServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Proxy;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MossVelocityTest {

    private static final AtomicInteger LOAD_CALLS = new AtomicInteger();

    @BeforeEach
    void resetLoadCalls() {
        LOAD_CALLS.set(0);
        closeContext();
    }

    @AfterEach
    void cleanUpContext() {
        closeContext();
    }

    @Test
    void defersContextLoadingUntilProxyInitialization() {
        TestPlugin plugin = new TestPlugin(proxyServer());

        assertEquals(0, LOAD_CALLS.get());

        plugin.onProxyInitialization(null);

        assertEquals(1, LOAD_CALLS.get());
        assertNotNull(MossVelocity.CONTEXT);
    }

    private static ProxyServer proxyServer() {
        return (ProxyServer) Proxy.newProxyInstance(
                ProxyServer.class.getClassLoader(),
                new Class<?>[]{ProxyServer.class},
                (proxy, method, args) -> null
        );
    }

    private static void closeContext() {
        AnnotationConfigApplicationContext context = MossVelocity.CONTEXT;
        if (context != null) {
            context.close();
            MossVelocity.CONTEXT = null;
        }
    }

    private static final class TestPlugin extends MossVelocity {

        private TestPlugin(ProxyServer server) {
            super(server);
        }

        @Override
        public void loadInitialComponents(AnnotationConfigApplicationContext context) {
            LOAD_CALLS.incrementAndGet();
            super.loadInitialComponents(context);
        }

        @Override
        public String basePackage() {
            return "gg.moonrise.moss.velocity.test.empty";
        }
    }
}
