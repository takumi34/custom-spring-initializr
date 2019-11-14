package com.chika.custominitializr.contributer;

import org.springframework.context.annotation.Bean;
import io.spring.initializr.generator.buildsystem.Build;
import io.spring.initializr.generator.buildsystem.DependencyScope;
import io.spring.initializr.generator.buildsystem.gradle.GradleBuild;
import io.spring.initializr.generator.buildsystem.maven.MavenBuild;
import io.spring.initializr.generator.condition.ConditionalOnPackaging;
import io.spring.initializr.generator.packaging.war.WarPackaging;
import io.spring.initializr.generator.project.ProjectGenerationConfiguration;
import io.spring.initializr.generator.spring.build.BuildCustomizer;
import org.springframework.boot.Banner;
import org.springframework.context.annotation.Bean;


@ProjectGenerationConfiguration
public class SampleProjectGenerationConfiguration {

    @Bean
    public BannerContributor bannerContributor() {
        return new BannerContributor();
    }

    @Bean
    public BuildCustomizer<MavenBuild> devtoolContributor() {
        return (build) -> build.dependencies().add("devtools", "org.springframework.boot","spring-boot-devtools", DependencyScope.COMPILE);
    }
}
