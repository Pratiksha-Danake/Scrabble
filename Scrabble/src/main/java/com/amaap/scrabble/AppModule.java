package com.amaap.scrabble;

import com.amaap.scrabble.domain.model.valueobject.PointAllocator;
import com.amaap.scrabble.io.ConfigFileLoader;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provides;

import java.io.FileNotFoundException;

public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
    }

    @Provides
    public PointAllocator provideScores() throws FileNotFoundException {
        Injector injector = Guice.createInjector(new AppModule());
        ConfigFileLoader configFileLoader = injector.getInstance(ConfigFileLoader.class);
        String configFilePath = "E:\\Scrabble\\Scrabble\\src\\main\\java\\resources\\config.yaml";
        return configFileLoader.loadConfigFile(configFilePath);
    }
}
