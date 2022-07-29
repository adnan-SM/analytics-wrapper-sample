package bike.rapido.analytics

object AnalyticsManager {

    private val trackerList = listOf(AnalyticTrackers.CLEVERTAP, AnalyticTrackers.FIREBASE, AnalyticTrackers.APPSFLYER)
    private fun sendEventToCleverTap() {
        val formattedData = formatDataForClevertap()
        // RapidoAnalytics.send(Tracker.CleverTap)
    }

    private fun sendEventToFirebase() {
        // RapidoAnalytics.send(Tracker.Firebase)
    }

    private fun sendEventToAppsFlyer() {
        // RapidoAnalytics.send(Tracker.AppsFlyer)
    }

    private fun sendEventToAll(trackers: List<AnalyticTrackers> = trackerList, data: String) {
        if (trackers.isEmpty()) {
            sendEventToCleverTap()
            sendEventToFirebase()
            sendEventToAppsFlyer()
        } else if (trackers.contains(AnalyticTrackers.CLEVERTAP)) {
            sendEventToCleverTap()
        } else if (trackers.contains(AnalyticTrackers.FIREBASE)) {
            sendEventToFirebase()
        } else {
            sendEventToAppsFlyer()
        }
    }

    private fun formatDataForClevertap(): String {
        return "Some formatted data"
    }

    private fun validateData(name: String, pinCode: Int, city: String) {
        // Check for validations & throw exceptions here!
    }

    fun sendSplashScreenEvent(name: String, pinCode: Int, city: String) {
        validateData(name, pinCode, city); // Useful to validate data constraints
        sendEventToAll(data = name);
    }

    fun sendEvent(trackers: List<AnalyticTrackers>, eventName: String, data: String) {
        sendEventToAll(trackers, data)
    }
}

enum class AnalyticTrackers  {
    FIREBASE,
    APPSFLYER,
    CLEVERTAP
}