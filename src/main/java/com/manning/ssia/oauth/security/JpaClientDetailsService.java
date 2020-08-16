package com.manning.ssia.oauth.security;

import com.manning.ssia.oauth.jpa.Client;
import com.manning.ssia.oauth.jpa.ClientRepository;
import com.manning.ssia.oauth.jpa.User;
import com.manning.ssia.oauth.jpa.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class JpaClientDetailsService implements ClientDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientDetails loadClientByClientId(String clientName) throws ClientRegistrationException {
        log.info("looking up client {}",clientName);
        Client client = clientRepository.findByName(clientName);
        if (client == null) {
            log.error ("did not find client {}",clientName);
            throw new ClientRegistrationException(clientName);
        }
        CustomClientDetails clientDetails= new CustomClientDetails(client);
        log.info("found clientDetails {}",clientDetails);
        return clientDetails;
    }
}
