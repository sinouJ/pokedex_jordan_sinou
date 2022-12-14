dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        jcenter() // Warning: this repository is going to shut down soon
        maven(url = "https://jitpack.io")
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")

    }

}
rootProject.name = "pokedex"
include(":app")