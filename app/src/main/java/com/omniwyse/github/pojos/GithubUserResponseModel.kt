package com.omniwyse.github.pojos

import com.google.gson.annotations.SerializedName

data class GithubUserResponseModel(
    @SerializedName("total_count") var totalCount: Long,
    @SerializedName("incomplete_results") var incompleteResults: Boolean,
    @SerializedName("items") var items: List<GitHubUser>
)