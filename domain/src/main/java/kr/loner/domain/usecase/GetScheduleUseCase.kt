package kr.loner.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kr.loner.domain.di.IoDispatcher
import kr.loner.domain.model.Id
import kr.loner.domain.model.TimeSchedule
import kr.loner.domain.repository.TimeScheduleRepository
import kr.loner.domain.usecase.base.CoroutineUseCase


class GetScheduleUseCase(
    private val timeScheduleRepo: TimeScheduleRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : CoroutineUseCase<Id, TimeSchedule>(dispatcher) {
    override suspend fun execute(param: Id): TimeSchedule =
        timeScheduleRepo.getSchedule(param.id)


}