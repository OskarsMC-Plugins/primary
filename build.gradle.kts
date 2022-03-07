plugins {
    java
    `maven-publish`
}

group = "com.oskarmc"
version = "1.0.0-SNAPSHOT"

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group as String?
            artifactId = project.name
            version = project.version as String?

            from(components["java"])
        }
    }
    repositories {
        maven {
            val releasesRepoUrl = uri("https://repository.oskarsmc.com/releases")
            val snapshotsRepoUrl = uri("https://repository.oskarsmc.com/snapshots")
            url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
            credentials {
                username = System.getenv("MAVEN_USERNAME")
                password = System.getenv("MAVEN_SECRET")
            }
        }
    }
}

java {
    withJavadocJar()
    withSourcesJar()
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    testRuntimeOnly("net.kyori:adventure-text-serializer-gson:4.9.3")

    implementation("net.kyori:adventure-api:4.10.1")
    implementation("net.kyori:adventure-text-serializer-plain:4.9.3")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}