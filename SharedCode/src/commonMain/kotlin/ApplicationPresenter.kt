package com.jetbrains.handson.mpp.mobile

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

class ApplicationPresenter: ApplicationContract.Presenter() {

    private val dispatchers = AppDispatchersImpl()
    private var view: ApplicationContract.View? = null
    private val job: Job = SupervisorJob()

    override val coroutineContext: CoroutineContext
        get() = dispatchers.main + job

    override fun onViewTaken(view: ApplicationContract.View) {
        this.view = view
        view.setLabel(createApplicationScreenMessage())
    }
    private suspend fun getApiCall(originStation:String,destinationStation:String):String {
        val client = HttpClient()
        {
            install(JsonFeature)
            {
                serializer = KotlinxSerializer()
            }
        }

        val queryURL = "https://mobile-api-dev.lner.co.uk/v1/fares?originStation=$originStation&destinationStation=$destinationStation&viaStation=WFJ&outboundDateTime=2020-07-20T12%3A16%3A27.371%2B00%3A00&numberOfChildren=0&numberOfAdults=1&doSplitTicketing=false"
        val content = client.get<String>(queryURL)
        client.close()
        return content
    }
    override fun getJourneys(originStation:String,destinationStation:String):String
    {
        var result = ""
        var view = this.view
        launch{
            result = getApiCall(originStation,destinationStation)
            val response = Json(JsonConfiguration.Stable)
                    .parse(Response.serializer(),result)
            if (view != null) {
                view.setJourneys(response)
            }
        }
        return ""
    }
}
