package data.database.room.converter

import androidx.room.TypeConverter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ListStringConverters {


    //---------------------------------------------------------------------------------------------- fromString
    @TypeConverter
    fun fromString(value: String?): List<String?>? {
        value?.let {
            return Json.decodeFromString<List<String?>?>(value)
        } ?: run {
            return Json.decodeFromString<List<String?>?>("")
        }
    }
    //---------------------------------------------------------------------------------------------- fromString


    //---------------------------------------------------------------------------------------------- fromList
    @TypeConverter
    fun fromList(list: List<String?>?): String {
        return Json.encodeToString(list)
    }
    //---------------------------------------------------------------------------------------------- fromList
}