plugins {
    kotlin("jvm") version "2.2.10"
    kotlin("plugin.spring") version "2.2.10"
    `maven-publish` // Для публикации библиотеки
    java

}

group = "ru.calc"
version = "1.0.7"

//java {
//    toolchain {
//        languageVersion.set(JavaLanguageVersion.of(17))
//    }
//}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom:2.2.10"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
//    implementation("org.slf4j:slf4j-api:2.0.7")
//    implementation("org.springframework:spring-core:6.0.11")
//    implementation("org.springframework:spring-context:6.0.11")
//
//    testImplementation("org.springframework.boot:spring-boot-starter-test")
//    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
//    testImplementation("org.slf4j:slf4j-simple:2.0.7")
//    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict", "-Xannotation-default-target=param-property")
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            // Попробуйте использовать задачу jar, которую мы настроили
            artifact(tasks.jar)
            // Или альтернативно: from(components["java"])
        }
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}