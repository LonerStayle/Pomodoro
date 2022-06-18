package kr.loner.data.local.db

import androidx.room.*
import kr.loner.domain.model.TimeSchedule

@Dao
interface TimeScheduleDao {

    @Insert
    suspend fun createSchedule(schedule: TimeSchedule)

    @Update
    suspend fun updateSchedule(schedule: TimeSchedule)

    @Delete
    suspend fun deleteSchedule(id: Long)

    @Query("SELECT * FROM TimeScheduleDto WHERE id = :id")
    suspend fun getSchedule(id: Long): TimeSchedule

    @Query("SELECT * FROM TimeScheduleDto")
    suspend fun getScheduleGroup(): List<TimeSchedule>
}