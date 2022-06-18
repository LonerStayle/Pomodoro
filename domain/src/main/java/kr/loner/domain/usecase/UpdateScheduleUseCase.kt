package kr.loner.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kr.loner.domain.di.IoDispatcher
import kr.loner.domain.model.TimeSchedule
import kr.loner.domain.repository.TimeScheduleRepository
import kr.loner.domain.usecase.base.NonReturnCoroutineUseCase

class UpdateScheduleUseCase(
    private val timeScheduleRepo: TimeScheduleRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : NonReturnCoroutineUseCase<TimeSchedule>(dispatcher) {
    override suspend fun execute(param: TimeSchedule) = timeScheduleRepo.updateSchedule(param)

}