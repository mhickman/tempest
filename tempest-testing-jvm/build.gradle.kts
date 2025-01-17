plugins {
    kotlin("jvm")
    `java-library`
}

dependencies {
    api(project(":tempest-testing"))
    implementation(project(":tempest-testing-internal"))
    implementation(Dependencies.awsDynamodbLocal)
    implementation(Dependencies.kotlinStdLib)

    if (org.apache.tools.ant.taskdefs.condition.Os.isArch("aarch64")) {
        implementation("io.github.ganadist.sqlite4java:libsqlite4java-osx-aarch64:1.0.392")
    }

    testImplementation(Dependencies.assertj)
    testImplementation(Dependencies.junitApi)
    testImplementation(Dependencies.junitEngine)
}

apply(from = "$rootDir/gradle-mvn-publish.gradle")
