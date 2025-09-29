package ssms.space.broox;

import bis.space.broox.core.CoreBootstrap;
import com.google.inject.Module;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class SSMSCoreBootstrap extends CoreBootstrap {
    @Override
    protected Module getAppModule() {
        return new SSMSModule();
    }
}
