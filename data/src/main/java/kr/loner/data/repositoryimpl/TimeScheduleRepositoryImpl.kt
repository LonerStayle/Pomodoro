package kr.loner.data.repositoryimpl

import kr.loner.data.local.db.TimeScheduleDao
import kr.loner.domain.model.TimeSchedule
import kr.loner.domain.model.TimeScheduleGroup
import kr.loner.domain.repository.TimeScheduleRepository

class TimeScheduleRepositoryImpl(private val timeScheduleDao: TimeScheduleDao) :
    TimeScheduleRepository {
    override suspend fun createSchedule(schedule: TimeSchedule) =
        timeScheduleDao.createSchedule(schedule)


    override suspend fun updateSchedule(schedule: TimeSchedule) =
        timeScheduleDao.updateSchedule(schedule)

    override suspend fun deleteSchedule(id: Long) = timeScheduleDao.deleteSchedule(id)

    override suspend fun getSchedule(id: Long): TimeSchedule = timeScheduleDao.getSchedule(id)

    override suspend fun getScheduleGroup(): TimeScheduleGroup =
        TimeScheduleGroup(timeScheduleDao.getScheduleGroup())
}