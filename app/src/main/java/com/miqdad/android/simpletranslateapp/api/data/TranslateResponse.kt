package com.miqdad.android.simpletranslateapp.api.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TranslateResponse(

	@field:SerializedName("TranslateResponse")
	val translateResponse: List<TranslateResponseItem?>? = null
) : Parcelable

@Parcelize
data class TranslateResponseItem(

	@field:SerializedName("license")
	val license: License? = null,

	@field:SerializedName("phonetic")
	val phonetic: String? = null,

	@field:SerializedName("phonetics")
	val phonetics: List<PhoneticsItem?>? = null,

	@field:SerializedName("word")
	val word: String? = null,

	@field:SerializedName("meanings")
	val meanings: List<MeaningsItem?>? = null,

	@field:SerializedName("sourceUrls")
	val sourceUrls: List<String?>? = null
) : Parcelable

@Parcelize
data class PhoneticsItem(

	@field:SerializedName("sourceUrl")
	val sourceUrl: String? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("audio")
	val audio: String? = null,

	@field:SerializedName("license")
	val license: License? = null
) : Parcelable

@Parcelize
data class DefinitionsItem(


	@field:SerializedName("definition")
	val definition: String? = null,

	@field:SerializedName("example")
	val example: String? = null
) : Parcelable

@Parcelize
data class License(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
) : Parcelable

@Parcelize
data class MeaningsItem(

	@field:SerializedName("synonyms")
	val synonyms: List<String?>? = null,

	@field:SerializedName("partOfSpeech")
	val partOfSpeech: String? = null,


	@field:SerializedName("definitions")
	val definitions: List<DefinitionsItem?>? = null
) : Parcelable
