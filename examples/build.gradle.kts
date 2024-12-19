plugins {
    id("java")
}

dependencies {
    implementation(project(":"))
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}
