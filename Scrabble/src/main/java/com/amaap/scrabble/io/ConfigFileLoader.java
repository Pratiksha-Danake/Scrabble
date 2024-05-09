package com.amaap.scrabble.io;

import com.amaap.scrabble.domain.model.valueobject.PointAllocator;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class ConfigFileLoader {
    public PointAllocator loadConfigFile(String configFilePath) throws FileNotFoundException {
        Yaml yaml = new Yaml();
        FileInputStream fis = new FileInputStream(configFilePath);
        Map<Integer, List<String>> scores = yaml.load(fis);
        PointAllocator pointAllocator = new PointAllocator(scores);
        return pointAllocator;
    }
}
