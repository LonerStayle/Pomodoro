package kr.loner.domain.repository

import kr.loner.domain.model.TimeSchedule
import kr.loner.domain.model.TimeScheduleGroup

interface TimeScheduleRepository {

    suspend fun createSchedule(schedule: TimeSchedule)
    suspend fun updateSchedule(schedule: TimeSchedule)
    suspend fun deleteSchedule(id: Long)

    suspend fun getSchedule(id: Long): TimeSchedule
    suspend fun getScheduleGroup(): TimeScheduleGroup


}