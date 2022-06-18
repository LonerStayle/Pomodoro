package kr.loner.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TimeScheduleDto(
    @PrimaryKey
    val id: Long,
    val title: String,
    val works: WorkGroupDto
)