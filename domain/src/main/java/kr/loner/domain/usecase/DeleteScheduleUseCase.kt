package kr.loner.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kr.loner.domain.di.IoDispatcher
import kr.loner.domain.repository.TimeScheduleRepository
import kr.loner.domain.usecase.base.NonReturnCoroutineUseCase

class DeleteScheduleUseCase(
    private val timeScheduleRepo: TimeScheduleRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : NonReturnCoroutineUseCase<Long>(dispatcher) {
    override suspend fun execute(param: Long) {
        timeScheduleRepo.deleteSchedule(param)
    }
}