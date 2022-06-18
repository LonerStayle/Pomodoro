package kr.loner.data.local.db

import android.content.Context
import androidx.room.*
import com.squareup.moshi.Moshi
import kr.loner.data.local.model.TimeScheduleDto
import kr.loner.data.local.model.WorkGroupDto

@Database(entities = [TimeScheduleDto::class], version = 1)
abstract class TimeScheduleDataBase : RoomDatabase() {
    abstract fun TimeScheduleDao(): TimeScheduleDao

    companion object {
        @Volatile
        private var INSTANCE: TimeScheduleDataBase? = null
        fun getInstance(context: Context) = INSTANCE ?: buildDatabase(context)

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            TimeScheduleDataBase::class.java, "LocalDB"
        ).addTypeConverter(RoomTypeConverters()).fallbackToDestructiveMigration().build()

    }
}

@ProvidedTypeConverter
class RoomTypeConverters {
    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun workGroupToJson(value: WorkGroupDto): String =
        moshi.adapter(WorkGroupDto::class.java).toJson(value)

    @TypeConverter
    fun jsonToWorkGroup(json: String): WorkGroupDto =
        moshi.adapter(WorkGroupDto::class.java).fromJson(json) ?: WorkGroupDto(emptyList(), 0)

}