rootProject.name = "BlueMap"

// setup workspace
val releaseNotesFile = file("release.md")
if (!releaseNotesFile.exists()) releaseNotesFile.createNewFile();

// implementations
includeBuild("implementations/cli")

includeBuild("implementations/fabric-1.15.2")
includeBuild("implementations/fabric-1.16.2")
includeBuild("implementations/fabric-1.17")
includeBuild("implementations/fabric-1.18")
includeBuild("implementations/fabric-1.19.4")
includeBuild("implementations/fabric-1.20")

includeBuild("implementations/forge-1.17.1")
includeBuild("implementations/forge-1.18.1")
includeBuild("implementations/forge-1.19.2")
includeBuild("implementations/forge-1.19.4")
includeBuild("implementations/forge-1.20")

includeBuild("implementations/neoforge-1.20.2")

includeBuild("implementations/spigot")
includeBuild("implementations/paper")

includeBuild("implementations/sponge")
