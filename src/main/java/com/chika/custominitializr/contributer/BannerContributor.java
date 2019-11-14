package com.chika.custominitializr.contributer;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import io.spring.initializr.generator.project.contributor.ProjectContributor;

public class BannerContributor implements ProjectContributor {
    public void contribute(Path projectRoot) throws IOException {
        Path bannerDirectory = projectRoot
                .resolve("src/main/resources");
        Files.createDirectories(bannerDirectory);
        Path file =Files.createFile(bannerDirectory.resolve("banner.txt"));
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(file))) {
            writer.println(
                    "   _____   _       _   _            \n" +
                            "  / ____| | |     (_) | |           \n" +
                            " | |      | |__    _  | | __   __ _ \n" +
                            " | |      | '_ \\  | | | |/ /  / _` |\n" +
                            " | |____  | | | | | | |   <  | (_| |\n" +
                            "  \\_____| |_| |_| |_| |_|\\_\\  \\__,_|\n"
            );
        }
    }
}
