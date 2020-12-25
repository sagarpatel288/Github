package com.omniwyse.github.pojos


import android.annotation.SuppressLint
import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
@Keep
data class user(
    @SerializedName("avatar_url")
    var avatarUrl: String? = null, // https://avatars0.githubusercontent.com/u/1?v=4
    @SerializedName("bio")
    var bio: Any? = null, // null
    @SerializedName("blog")
    var blog: String? = null, // http://tom.preston-werner.com
    @SerializedName("company")
    var company: String? = null, // @chatterbugapp, @redwoodjs, @preston-werner-ventures 
    @SerializedName("created_at")
    var createdAt: String? = null, // 2007-10-20T05:24:19Z
    @SerializedName("email")
    var email: Any? = null, // null
    @SerializedName("events_url")
    var eventsUrl: String? = null, // https://api.github.com/users/mojombo/events{/privacy}
    @SerializedName("followers")
    var followers: Int? = null, // 22267
    @SerializedName("followers_url")
    var followersUrl: String? = null, // https://api.github.com/users/mojombo/followers
    @SerializedName("following")
    var following: Int? = null, // 11
    @SerializedName("following_url")
    var followingUrl: String? = null, // https://api.github.com/users/mojombo/following{/other_user}
    @SerializedName("gists_url")
    var gistsUrl: String? = null, // https://api.github.com/users/mojombo/gists{/gist_id}
    @SerializedName("gravatar_id")
    var gravatarId: String? = null,
    @SerializedName("hireable")
    var hireable: Any? = null, // null
    @SerializedName("html_url")
    var htmlUrl: String? = null, // https://github.com/mojombo
    @SerializedName("id")
    var id: Int? = null, // 1
    @SerializedName("location")
    var location: String? = null, // San Francisco
    @SerializedName("login")
    var login: String? = null, // mojombo
    @SerializedName("name")
    var name: String? = null, // Tom Preston-Werner
    @SerializedName("node_id")
    var nodeId: String? = null, // MDQ6VXNlcjE=
    @SerializedName("organizations_url")
    var organizationsUrl: String? = null, // https://api.github.com/users/mojombo/orgs
    @SerializedName("public_gists")
    var publicGists: Int? = null, // 62
    @SerializedName("public_repos")
    var publicRepos: Int? = null, // 62
    @SerializedName("received_events_url")
    var receivedEventsUrl: String? = null, // https://api.github.com/users/mojombo/received_events
    @SerializedName("repos_url")
    var reposUrl: String? = null, // https://api.github.com/users/mojombo/repos
    @SerializedName("site_admin")
    var siteAdmin: Boolean? = null, // false
    @SerializedName("starred_url")
    var starredUrl: String? = null, // https://api.github.com/users/mojombo/starred{/owner}{/repo}
    @SerializedName("subscriptions_url")
    var subscriptionsUrl: String? = null, // https://api.github.com/users/mojombo/subscriptions
    @SerializedName("twitter_username")
    var twitterUsername: String? = null, // mojombo
    @SerializedName("type")
    var type: String? = null, // User
    @SerializedName("updated_at")
    var updatedAt: String? = null, // 2020-11-14T01:39:55Z
    @SerializedName("url")
    var url: String? = null // https://api.github.com/users/mojombo
) : Parcelable