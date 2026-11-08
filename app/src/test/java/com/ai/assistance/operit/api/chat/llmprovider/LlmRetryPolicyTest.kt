package com.ai.assistance.operit.api.chat.llmprovider

import org.junit.Assert.assertEquals
import org.junit.Test

class LlmRetryPolicyTest {
    @Test
    fun delaysDoubleFromOneToSixteenSeconds() {
        assertEquals(1000L, LlmRetryPolicy.nextDelayMs(1))
        assertEquals(2000L, LlmRetryPolicy.nextDelayMs(2))
        assertEquals(4000L, LlmRetryPolicy.nextDelayMs(3))
        assertEquals(8000L, LlmRetryPolicy.nextDelayMs(4))
        assertEquals(16000L, LlmRetryPolicy.nextDelayMs(5))
    }

    @Test
    fun zeroAndNegativeAttemptsBehaveLikeFirstAttempt() {
        assertEquals(1000L, LlmRetryPolicy.nextDelayMs(0))
        assertEquals(1000L, LlmRetryPolicy.nextDelayMs(-1))
        assertEquals(1000L, LlmRetryPolicy.nextDelayMs(Int.MIN_VALUE))
    }

    @Test
    fun largeAttemptsStayCappedAtSixteenSeconds() {
        assertEquals(16000L, LlmRetryPolicy.nextDelayMs(6))
        assertEquals(16000L, LlmRetryPolicy.nextDelayMs(50))
        assertEquals(16000L, LlmRetryPolicy.nextDelayMs(Int.MAX_VALUE))
    }
}
