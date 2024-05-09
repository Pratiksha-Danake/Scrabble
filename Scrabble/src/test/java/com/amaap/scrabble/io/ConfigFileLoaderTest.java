package com.amaap.scrabble.io;

import com.amaap.scrabble.AppModule;
import com.amaap.scrabble.domain.model.valueobject.PointAllocator;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfigFileLoaderTest {
    ConfigFileLoader configFileLoader;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new AppModule());
        configFileLoader = injector.getInstance(ConfigFileLoader.class);
    }

    @Test
    void shouldBeAbleToLoadConfigDataFromFile() throws FileNotFoundException {
        // arrange
        String configFilePath = "E:\\Scrabble\\Scrabble\\src\\main\\java\\resources\\config.yaml";
        PointAllocator expected = configFileLoader.loadConfigFile(configFilePath);

        // act
        PointAllocator actual = configFileLoader.loadConfigFile(configFilePath);

        // assert
        assertEquals(expected, actual);
    }
}
