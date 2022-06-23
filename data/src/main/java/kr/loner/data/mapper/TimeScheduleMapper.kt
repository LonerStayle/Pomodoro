package kr.loner.data.mapper

import kr.loner.data.local.model.TimeScheduleDto
import kr.loner.data.local.model.WorkGroupDto
import kr.loner.domain.model.TimeSchedule
import kr.loner.domain.model.WorkGroup

private fun WorkGroupDto.toDomainModel(): WorkGroup = WorkGroup(value, updateDate)
fun TimeScheduleDto.toDomainModel(): TimeSchedule = TimeSchedule(id, works.toDomainModel())