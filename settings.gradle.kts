include(":plugin:api")

val buildPlugin = System.getenv("BUILD_PLUGIN")
when {
    buildPlugin.isNullOrBlank() -> {
        include(":plugin:hysteria2")
    }
    buildPlugin == "none" -> {
    }
    else -> {
        include(":plugin:$buildPlugin")
    }
}

include(":app")

rootProject.name = "husi"
