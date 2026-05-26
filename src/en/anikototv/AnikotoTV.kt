package eu.kanade.tachiyomi.animeextension.en.anikototv

import eu.kanade.tachiyomi.animesource.model.AnimeFilterList
import eu.kanade.tachiyomi.animesource.model.SAnime
import eu.kanade.tachiyomi.animesource.model.SEpisode
import eu.kanade.tachiyomi.animesource.model.Video
import eu.kanade.tachiyomi.animesource.online.ParsedAnimeHttpSource
import eu.kanade.tachiyomi.network.GET
import eu.kanade.tachiyomi.util.asJsoup
import okhttp3.Request
import okhttp3.Response
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

/**
 * Custom Anikoto extension for Aniyomi.
 * 
 * Package must match exactly what you put in index.json "packageName".
 * 
 * When building the .apk, the final package in the manifest must match.
 * Update versionCode / versionName in the repo index on every release.
 */
class AnikotoTV : ParsedAnimeHttpSource() {

    override val name = "Anikoto"
    override val baseUrl = "https://anikototv.to"
    override val lang = "en"
    override val supportsLatest = true

    // IMPORTANT: When you build the APK, the packageName in index.json
    // must exactly match "eu.kanade.tachiyomi.animeextension.en.anikototv"
    // and the final APK must be signed consistently.

    override fun popularAnimeRequest(page: Int): Request =
        GET("$baseUrl/home")

    override fun popularAnimeSelector() = "div.anime-item"

    override fun popularAnimeFromElement(element: Element): SAnime = SAnime.create().apply {
        setUrlWithoutDomain(element.selectFirst("a")!!.attr("href"))
        thumbnail_url = element.selectFirst("img")?.attr("src")
        title = element.selectFirst(".anime-title")?.text() ?: ""
    }

    override fun popularAnimeNextPageSelector() = null

    override fun latestUpdatesRequest(page: Int): Request = popularAnimeRequest(page)
    override fun latestUpdatesSelector() = popularAnimeSelector()
    override fun latestUpdatesFromElement(element: Element) = popularAnimeFromElement(element)
    override fun latestUpdatesNextPageSelector() = null

    override fun searchAnimeRequest(page: Int, query: String, filters: AnimeFilterList): Request =
        GET("$baseUrl/search?q=$query")

    override fun searchAnimeSelector() = popularAnimeSelector()
    override fun searchAnimeFromElement(element: Element) = popularAnimeFromElement(element)
    override fun searchAnimeNextPageSelector() = null

    override fun animeDetailsParse(document: Document): SAnime = SAnime.create().apply {
        title = document.selectFirst("h1")?.text() ?: ""
        description = document.selectFirst(".synopsis")?.text()
        thumbnail_url = document.selectFirst("img.cover")?.attr("src")
    }

    override fun episodeListParse(response: Response): List<SEpisode> {
        val document = response.asJsoup()
        return document.select("div.episode-item a").mapIndexed { index, element ->
            SEpisode.create().apply {
                name = element.text()
                url = element.attr("href")
                episode_number = (index + 1).toFloat()
            }
        }.reversed()
    }

    override fun videoListParse(response: Response): List<Video> {
        val document = response.asJsoup()
        return document.select("source").mapNotNull { source ->
            val videoUrl = source.attr("src")
            if (videoUrl.isNotEmpty()) {
                Video(videoUrl, "Default", videoUrl)
            } else null
        }
    }

    override fun getFilterList() = AnimeFilterList()
}
