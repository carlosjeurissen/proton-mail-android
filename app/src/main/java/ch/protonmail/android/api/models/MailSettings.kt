/*
 * Copyright (c) 2020 Proton Technologies AG
 * 
 * This file is part of ProtonMail.
 * 
 * ProtonMail is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * ProtonMail is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with ProtonMail. If not, see https://www.gnu.org/licenses/.
 */
package ch.protonmail.android.api.models

import android.content.SharedPreferences
import android.text.TextUtils
import ch.protonmail.android.api.models.enumerations.PackageType
import ch.protonmail.android.core.ProtonMailApplication
import com.google.gson.annotations.SerializedName
import java.io.Serializable

// region constants
private const val FIELD_DISPLAY_NAME = "DisplayName"
private const val FIELD_SIGNATURE = "Signature"
private const val FIELD_THEME = "Theme"
private const val FIELD_AUTO_SAVE_CONTACTS = "AutoSaveContacts"
private const val FIELD_AUTO_WILDCARD_SEARCH = "AutoWildcardSearch"
private const val FIELD_SHOW_IMAGES = "ShowImages" // 0 for none, 1 for remote, 2 for embedded, 3 for remote and embedded
private const val FIELD_SHOW_MOVED = "ShowMoved"
private const val FIELD_SWIPE_LEFT = "SwipeLeft"
private const val FIELD_SWIPE_RIGHT = "SwipeRight"
private const val FIELD_ALSO_ARCHIVE = "AlsoArchive"
private const val FIELD_PM_SIGNATURE = "PMSignature"
private const val FIELD_RIGHT_TO_LEFT = "RightToLeft"
private const val FIELD_ATTACH_PUBLIC_KEY = "AttachPublicKey"
private const val FIELD_SIGN = "Sign"
private const val FIELD_PGP_SCHEME = "PGPScheme"
private const val FIELD_PROMPT_PIN = "PromptPin"
private const val FIELD_AUTOCRYPT = "Autocrypt"
private const val FIELD_NUM_MESSAGE_PER_PAGE = "NumMessagePerPage"
private const val FIELD_DRAFT_MIME_TYPE = "DraftMIMEType"
private const val FIELD_RECEIVE_MIME_TYPE = "ReceiveMIMEType"
private const val FIELD_SHOW_MIME_TYPE = "ShowMIMEType"

private const val PREF_DISPLAY_NAME = "mail_settings_DisplayName"
private const val PREF_SIGNATURE = "mail_settings_Signature"
private const val PREF_THEME = "mail_settings_Theme"
private const val PREF_AUTO_SAVE_CONTACTS = "mail_settings_AutoSaveContacts"
private const val PREF_AUTO_WILDCARD_SEARCH = "mail_settings_AutoWildcardSearch"
private const val PREF_SHOW_IMAGES = "mail_settings_ShowImages" // 0 for none, 1 for remote, 2 for embedded, 3 for remote and embedded
private const val PREF_SHOW_MOVED = "mail_settings_ShowMoved"
private const val PREF_SWIPE_LEFT = "mail_settings_SwipeLeft"
private const val PREF_SWIPE_RIGHT = "mail_settings_SwipeRight"
private const val PREF_ALSO_ARCHIVE = "mail_settings_AlsoArchive"
private const val PREF_PM_SIGNATURE = "mail_settings_PMSignature"
private const val PREF_RIGHT_TO_LEFT = "mail_settings_RightToLeft"
private const val PREF_ATTACH_PUBLIC_KEY = "mail_settings_AttachPublicKey"
private const val PREF_SIGN = "mail_settings_Sign"
private const val PREF_PGP_SCHEME = "mail_settings_PGPScheme"
private const val PREF_PROMPT_PIN = "mail_settings_PromptPin"
private const val PREF_AUTOCRYPT = "mail_settings_Autocrypt"
private const val PREF_NUM_MESSAGE_PER_PAGE = "mail_settings_NumMessagePerPage"
private const val PREF_DRAFT_MIME_TYPE = "mail_settings_DraftMIMEType"
private const val PREF_RECEIVE_MIME_TYPE = "mail_settings_ReceiveMIMEType"
private const val PREF_SHOW_MIME_TYPE = "mail_settings_ShowMIMEType"
// endregion

/**
 * Created by dino on 2/4/18.
 */

class MailSettings : Serializable {

    @SerializedName(FIELD_DISPLAY_NAME)
    private val displayName: String? = null
    @SerializedName(FIELD_SIGNATURE)
    private val signature: String? = null
    @SerializedName(FIELD_THEME)
    private val theme: String? = null
    @SerializedName(FIELD_AUTO_SAVE_CONTACTS)
    var autoSaveContacts: Int = 0
    @SerializedName(FIELD_AUTO_WILDCARD_SEARCH)
    private val autoWildcardSearch: Int = 0
    /**
     * Auto showing remote and embedded images.
     * @return 0 for none, 1 for remote, 2 for embedded, 3 for remote and embedded
     */
    @SerializedName(FIELD_SHOW_IMAGES)
    var showImages: Int = 0 // 0 for none, 1 for remote, 2 for embedded, 3 for remote and embedded
    @SerializedName(FIELD_SHOW_MOVED)
    private val showMoved: Int = 0
    @SerializedName(FIELD_SWIPE_RIGHT)
    private var swipeRight: Int = 0
    @SerializedName(FIELD_SWIPE_LEFT)
    private var swipeLeft: Int = 0
    @SerializedName(FIELD_ALSO_ARCHIVE)
    private val alsoArchive: Int = 0
    @SerializedName(FIELD_PM_SIGNATURE)
    private val pmSignature: Int = 0
    @SerializedName(FIELD_RIGHT_TO_LEFT)
    private val rightToLeft: Int = 0
    @SerializedName(FIELD_ATTACH_PUBLIC_KEY)
    private var attachPublicKey: Int = 0
    @SerializedName(FIELD_SIGN)
    var sign: Int = 0
    @SerializedName(FIELD_PGP_SCHEME)
    var pgpScheme: Int = 0
    @SerializedName(FIELD_PROMPT_PIN)
    private val promptPin: Int = 0
    @SerializedName(FIELD_AUTOCRYPT)
    private val autocrypt: Int = 0
    @SerializedName(FIELD_NUM_MESSAGE_PER_PAGE)
    private val numMessagePerPage: Int = 0
    @SerializedName(FIELD_DRAFT_MIME_TYPE)
    private val draftMIMEType: String? = null
    @SerializedName(FIELD_RECEIVE_MIME_TYPE)
    private val receiveMIMEType: String? = null
    @SerializedName(FIELD_SHOW_MIME_TYPE)
    private val showMIMEType: String? = null

    @Transient
    var username: String? = null

    var leftSwipeAction: Int
        get() = if (swipeLeft in 0..4) swipeLeft else 0
        set(swipeAction) {
            swipeLeft = swipeAction
        }

    var rightSwipeAction: Int
        get() = if (swipeRight in 0..4) swipeRight else 0
        set(swipeAction) {
            swipeRight = swipeAction
        }

    val defaultSign: Boolean
        get() = sign != 0

    fun getPGPScheme(): PackageType? {
        return PackageType.fromInteger(pgpScheme)
    }

    fun getAttachPublicKey(): Boolean {
        return attachPublicKey != 0
    }

    fun setAttachPublicKey(attachPublicKey: Int) {
        this.attachPublicKey = attachPublicKey
    }

    fun save() {
        val pref: SharedPreferences = ProtonMailApplication.getApplication().getSecureSharedPreferences(this.username)

        pref.edit()
                .putString(PREF_DISPLAY_NAME, displayName)
                .putString(PREF_SIGNATURE, signature)
                .putString(PREF_THEME, theme)
                .putInt(PREF_AUTO_SAVE_CONTACTS, autoSaveContacts)
                .putInt(PREF_AUTO_WILDCARD_SEARCH, autoWildcardSearch)
                .putInt(PREF_SHOW_IMAGES, showImages)
                .putInt(PREF_SHOW_MOVED, showMoved)
                .putInt(PREF_SWIPE_RIGHT, swipeRight)
                .putInt(PREF_SWIPE_LEFT, swipeLeft)
                .putInt(PREF_ALSO_ARCHIVE, alsoArchive)
                .putInt(PREF_PM_SIGNATURE, pmSignature)
                .putInt(PREF_RIGHT_TO_LEFT, rightToLeft)
                .putInt(PREF_ATTACH_PUBLIC_KEY, attachPublicKey)
                .putInt(PREF_SIGN, sign)
                .putInt(PREF_PGP_SCHEME, pgpScheme)
                .putInt(PREF_PROMPT_PIN, promptPin)
                .putInt(PREF_AUTOCRYPT, autocrypt)
                .putInt(PREF_NUM_MESSAGE_PER_PAGE, numMessagePerPage)
                .putString(PREF_DRAFT_MIME_TYPE, draftMIMEType)
                .putString(PREF_RECEIVE_MIME_TYPE, receiveMIMEType)
                .putString(PREF_SHOW_MIME_TYPE, showMIMEType)
                .apply()
    }

    companion object {

        fun load(username: String): MailSettings {
            val prefs: SharedPreferences = ProtonMailApplication.getApplication().getSecureSharedPreferences(username)
            val mailSettings = MailSettings()
            mailSettings.showImages = prefs.getInt(PREF_SHOW_IMAGES, 0)
            mailSettings.autoSaveContacts = prefs.getInt(PREF_AUTO_SAVE_CONTACTS, 0)
            mailSettings.leftSwipeAction = prefs.getInt(PREF_SWIPE_LEFT, 0)
            mailSettings.swipeLeft = mailSettings.leftSwipeAction
            mailSettings.rightSwipeAction = prefs.getInt(PREF_SWIPE_RIGHT, 0)
            mailSettings.swipeRight = mailSettings.rightSwipeAction
            mailSettings.setAttachPublicKey(prefs.getInt(PREF_ATTACH_PUBLIC_KEY, 0))
            mailSettings.pgpScheme = prefs.getInt(PREF_PGP_SCHEME, 1)
            mailSettings.sign = prefs.getInt(PREF_SIGN, 0)
            if (!TextUtils.isEmpty(username)) {
                mailSettings.username = username
            }

            return mailSettings
        }
    }
}
