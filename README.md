# Customizing Spring Initializer

## Spring Initializerのカスタムインスタンスの立ち上げ方
1.　以下の依存関係を足す  

* build.gradle
```groovy
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation("io.spring.initializr:initializr-web")
	implementation("io.spring.initializr:initializr-generator-spring")
}

dependencyManagement {
	imports {
		mavenBom "io.spring.initializr:initializr-bom:0.8.0.RELEASE"
	}
}
```
## settingの変え方
1. application.ymlにinitializrのnamespaceで記載  

* appliction.yml
```yml
initializr:
  dependencies:
    - name: Web
      content:
        - name: Web
          id: web
          description: webだよ！！！
```


## BuildCustomizerやProjectContributorの使い方
1. Configurationのファイルまでのパスをspring.factoriesに書く  

* spring.factories
```
io.spring.initializr.generator.project.ProjectGenerationConfiguration=\
com.chika.custominitializr.contributer.SampleProjectGenerationConfiguration
```
2. ProjectGenerationContext(@ProjectGenerationConfigurationのアノテーションを付ける）にbean登録する

```java
@ProjectGenerationConfiguration
public class SampleProjectGenerationConfiguration {

    @Bean
    public BannerContributor bannerContributor() {
        return new BannerContributor();
    }

    @Bean
    public BuildCustomizer<MavenBuild> devtoolContributor() {
        return (build) -> build.dependencies().add("devtools", "org.springframework.boot","spring-boot-devtools",                                       DependencyScope.COMPILE);
    }
}
```
* BuildCustomizerを使うことによって、build時のカスタマイズができる。実際にこのカスタマイズしたinitializrでプロジェクトを生成すると、自動でdevtoolsが依存関係に追加される

