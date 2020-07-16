package com.jetbrains.handson.mpp.mobile

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

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
        val queryURL = "https://mobile-api-dev.lner.co.uk/v1/fares?originStation=".plus(originStation).plus("&destinationStation=").plus(destinationStation).plus("&viaStation=WFJ&outboundDateTime=2020-07-20T12%3A16%3A27.371%2B00%3A00&numberOfChildren=2&numberOfAdults=2&doSplitTicketing=false")
        val content = client.get<String>(queryURL)
        client.close()
        return content
    }
    override fun getJourneys(originStation:String,destinationStation:String):String
    {
        var result = ""
        launch{
            result = getApiCall(originStation,destinationStation)
        }
        return result
    }
}
