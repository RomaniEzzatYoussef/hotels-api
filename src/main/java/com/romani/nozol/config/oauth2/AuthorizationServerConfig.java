package com.romani.nozol.config.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import javax.sql.DataSource;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    DataSource dataSource;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Autowired
//    private TokenStore tokenStore;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.checkTokenAccess("isAuthenticated()");
//        security.allowFormAuthenticationForClients().checkTokenAccess("permitAll()");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager).approvalStoreDisabled();
//        endpoints.tokenStore(tokenStore).authenticationManager(authenticationManager).approvalStoreDisabled();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource);
//        clients
//                .inMemory()
//                .withClient("my-trusted-client")
//                .authorizedGrantTypes("client_credentials", "password")
//                .authorities("ROLE_CLIENT","ROLE_TRUSTED_CLIENT")
//                .scopes("read","write","trust")
//                .resourceIds("oauth2-resource")
//                .accessTokenValiditySeconds(5000)
//                .secret(passwordEncoder.encode("secret"));
    }



}

