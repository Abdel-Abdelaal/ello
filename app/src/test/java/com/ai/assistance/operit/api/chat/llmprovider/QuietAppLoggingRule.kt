package com.ai.assistance.operit.api.chat.llmprovider

import com.ai.assistance.operit.util.AppLogger
import org.junit.rules.ExternalResource

/** JVM protocol tests have no Android logger; restore application flags after each test. */
class QuietAppLoggingRule : ExternalResource() {
    private var previousSystemLogging = true
    private var previousFileLogging = true

    override fun before() {
        previousSystemLogging = AppLogger.enableSystemLog
        previousFileLogging = AppLogger.enableFileLogging
        AppLogger.enableSystemLog = false
        AppLogger.enableFileLogging = false
    }

    override fun after() {
        AppLogger.enableSystemLog = previousSystemLogging
        AppLogger.enableFileLogging = previousFileLogging
    }
}
