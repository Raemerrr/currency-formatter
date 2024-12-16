import com.vanniktech.maven.publish.SonatypeHost

plugins {
    id("java")
    id("com.vanniktech.maven.publish") version "0.28.0"
    id("signing")
}

rootProject.description = "A simple library to format currency amounts"

signing {
    useInMemoryPgpKeys(
            System.getenv("GPG_PRIVATE_KEY"),
            System.getenv("GPG_PASSPHRASE")
    )
    sign(publishing.publications)
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
}

tasks.test {
    useJUnitPlatform()
}

mavenPublishing {
    coordinates(
            groupId = "io.github.raemerrr",
            artifactId = "currency-formatter",
            version = System.getenv("VERSION")
    )

    pom {
        name.set(project.rootProject.name)
        description.set(project.description)
        inceptionYear.set("2024")
        url.set("https://github.com/Raemerrr/currency-formatter")

        licenses {
            license {
                name.set("MIT License")
                url.set("https://github.com/Raemerrr/currency-formatter/blob/main/LICENSE")
                distribution.set("repo")
            }
        }

        developers {
            developer {
                id.set("Raemerrr")
                name.set("Raemin Kang")
                email.set("foals18@gmail.com")
            }
        }

        scm {
            connection.set("scm:git:git://github.com/Raemerrr/currency-formatter.git")
            developerConnection.set("scm:git:ssh://git@github.com:Raemerrr/currency-formatter.git")
            url.set("https://github.com/Raemerrr/currency-formatter")
        }
    }

    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
}
