package com.ai.assistance.operit.api.chat.llmprovider

import com.ai.assistance.operit.data.collects.ApiProviderConfigs
import com.ai.assistance.operit.data.collects.ModelThinkingConfigDefaults
import com.ai.assistance.operit.data.model.ApiProviderType
import org.json.JSONObject
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class XaiProviderReasoningTest {
    @Test
    fun defaultConfigUsesTheOfficialXaiEndpointAndModel() {
        assertEquals(
            "grok-4.6",
            ApiProviderConfigs.getDefaultModelName(ApiProviderType.XAI)
        )
        assertEquals(
            "https://api.x.ai/v1/chat/completions",
            ApiProviderConfigs.getDefaultApiEndpoint(ApiProviderType.XAI)
        )
        assertEquals(
            "https://api.x.ai/v1/models",
            ModelListFetcher.getModelsListUrl(
                "https://api.x.ai/v1/chat/completions",
                ApiProviderType.XAI
            )
        )
    }

    @Test
    fun enabledOptionsMapToXaiEfforts() {
        assertEquals(
            listOf("low", "medium", "high", "xhigh"),
            listOf("low", "medium", "high", "xhigh").map {
                requestEffort(optionId = it)
            }
        )
    }

    @Test
    fun mapperPreservesTheSelectedEffort() {
        assertEquals(
            "high",
            requestEffort(optionId = "high")
        )
    }

    @Test
    fun reasoningEffortUsesTheGrokFamilyRule() {
        // The provider now uses the shared registry rather than a legacy xAI mapper.
        for (model in listOf("grok-4.6", "grok-4.5-latest", "grok-3-mini")) {
            val mapping = ThinkingQualityMappingRegistry.resolve(
                providerTypeId = ApiProviderType.XAI.name,
                modelName = model,
                thinkingConfigurations = ModelThinkingConfigDefaults.forProvider(ApiProviderType.XAI.name),
            )
            assertTrue(model, mapping.control == ThinkingQualityControl.LEVELS)
        }
    }

    private fun requestEffort(optionId: String): String {
        val request = JSONObject().put("model", "grok-4.6")
        ThinkingConfigurationApplier.apply(
            requestJson = request,
            providerTypeId = ApiProviderType.XAI.name,
            modelName = "grok-4.6",
            apiEndpoint = "https://api.x.ai/v1/chat/completions",
            thinkingConfigurations = ModelThinkingConfigDefaults.forProvider(ApiProviderType.XAI.name),
            enableThinking = true,
            optionId = optionId,
        )
        return request.getString("reasoning_effort")
    }
}
