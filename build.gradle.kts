import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.10"
    jacoco
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0"
}

group = "de.platickarma"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("io.kotest:kotest-runner-junit5:5.5.5")
    testImplementation("io.kotest:kotest-assertions-core:5.5.5")
    implementation("fr.inria.gforge.spoon:spoon-core:10.2.0-beta-16")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

val excludeFromCoverageList = listOf(
    "**/*DefaultVisitor.class",
)

tasks.withType<JacocoCoverageVerification> {
    classDirectories.setFrom(
        sourceSets.main.get().output.asFileTree.matching {
            exclude(excludeFromCoverageList)
        },
    )
    violationRules {
        rule {
            limit {
                counter = "LINE"
                minimum = "0.84".toBigDecimal()
            }
            limit {
                counter = "BRANCH"
                minimum = "0.88".toBigDecimal()
            }
            limit {
                counter = "COMPLEXITY"
                minimum = "0.79".toBigDecimal()
            }
        }
    }
}

tasks.check {
    dependsOn(tasks.jacocoTestCoverageVerification)
}

tasks.jacocoTestReport {
    classDirectories.setFrom(
        sourceSets.main.get().output.asFileTree.matching {
            exclude(excludeFromCoverageList)
        },
    )
    reports {
        xml.required.set(false)
        csv.required.set(false)
        html.outputLocation.set(layout.buildDirectory.dir("reports/jacoco"))
    }
}
