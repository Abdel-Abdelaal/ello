package com.ai.assistance.operit.integrations.externalchat

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExternalChatRequest(
    @SerialName("request_id")
    val requestId: String? = null,
    @SerialName("message")
    val message: String? = null,
    @SerialName("group")
    val group: String? = null,
    @SerialName("create_new_chat")
    val createNewChat: Boolean = false,
    @SerialName("chat_id")
    val chatId: String? = null,
    @SerialName("create_if_none")
    val createIfNone: Boolean = true,
    @SerialName("show_floating")
    val showFloating: Boolean = false,
    @SerialName("return_tool_status")
    val returnToolStatus: Boolean = true,
    @SerialName("initial_mode")
    val initialMode: String? = null,
    @SerialName("auto_exit_after_ms")
    val autoExitAfterMs: Long = -1L,
    @SerialName("timeout_ms")
    val timeoutMs: Long = -1L,
    @SerialName("stop_after")
    val stopAfter: Boolean = false
)

@Serializable
data class ExternalChatResult(
    @SerialName("request_id")
    val requestId: String? = null,
    @SerialName("success")
    val success: Boolean,
    @SerialName("chat_id")
    val chatId: String? = null,
    @SerialName("ai_response")
    val aiResponse: String? = null,
    @SerialName("error")
    val error: String? = null
)
