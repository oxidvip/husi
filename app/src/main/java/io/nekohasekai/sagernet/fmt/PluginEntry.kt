package io.nekohasekai.sagernet.fmt

import io.nekohasekai.sagernet.R
import io.nekohasekai.sagernet.SagerNet

enum class PluginEntry(
    val pluginId: String,
    val displayName: String,
    val packageName: String, // for f-droid page
    val downloadSource: DownloadSource = DownloadSource()
) {
    Hysteria(
        "hysteria-plugin",
        SagerNet.application.getString(R.string.action_hysteria),
        "moe.matsuri.exe.hysteria",
        DownloadSource(
            fdroid = false,
            downloadLink = "https://github.com/MatsuriDayo/plugins/releases?q=Hysteria"
        ),
    ),
    Hysteria2(
        "hysteria2-plugin",
        SagerNet.application.getString(R.string.action_hysteria)+"2",
        "fr.husi.plugin.hysteria2",
        DownloadSource(
            fdroid = false,
            downloadLink = "https://github.com/oxidvip/husi/releases?q=Hysteria2",
        ),
    )
    ;

    data class DownloadSource(
        val fdroid: Boolean = true,
        val downloadLink: String = "https://github.com/oxidvip/husi/releases",
    )

    companion object {

        fun find(name: String): PluginEntry? {
            for (pluginEntry in enumValues<PluginEntry>()) {
                if (name == pluginEntry.pluginId) {
                    return pluginEntry
                }
            }
            return null
        }

    }

}
