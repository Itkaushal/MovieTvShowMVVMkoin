pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()

    }

    

}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }

    /*dependencies {
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.40.5")
        classpath ("org.jetbrains.kotlin:kotlin-serialization:2.0.0")
    }*/

}

rootProject.name = "MovieAndShowsApp"
include(":app")
