package chenyunlong.zhangli.anthentication;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class MyAuthentication extends AbstractAuthenticationToken {
    public MyAuthentication(Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
    }

    @Override
    public Object getCredentials() {
        return getCredentials();
    }

    @Override
    public Object getPrincipal() {
        return getCredentials();
    }
}
