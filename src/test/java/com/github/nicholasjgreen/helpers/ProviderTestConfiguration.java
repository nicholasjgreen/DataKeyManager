package com.github.nicholasjgreen.helpers;

import com.github.nicholasjgreen.provider.CurrentKeyIdProvider;
import com.github.nicholasjgreen.provider.DataKeyDecryptionProvider;
import com.github.nicholasjgreen.provider.DataKeyGeneratorProvider;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("Test")
public class ProviderTestConfiguration {
    @Bean
    public CurrentKeyIdProvider currentKeyIdProvider() {
        return Mockito.mock(CurrentKeyIdProvider.class);
    }

    @Bean
    public DataKeyDecryptionProvider dataKeyDecryptionProvider() {
        return Mockito.mock(DataKeyDecryptionProvider.class);
    }

    @Bean
    public DataKeyGeneratorProvider dataKeyGeneratorProvider() {
        return Mockito.mock(DataKeyGeneratorProvider.class);
    }
}
