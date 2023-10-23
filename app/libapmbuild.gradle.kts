// ./gradlew clean build generateRelease
apply plugin: 'maven'

def groupId = project.PUBLISH_GROUP_ID
        def artifactId = project.PUBLISH_ARTIFACT_ID
        def version = project.PUBLISH_VERSION

        def localReleaseDest = "${buildDir}/release/${version}"



uploadArchives {
    repositories.mavenDeployer {
        pom.groupId = groupId
        pom.artifactId = artifactId
        pom.version = version
        // Add other pom properties here if you want (developer details / licenses)
        repository(url: "file://${localReleaseDest}")
    }
}


artifacts {
    archives androidSourcesJar
            archives androidJavadocsJar
}


tasks.findByPath(":libsdk:androidJavadocs").enabled = false