package kr.loner.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kr.loner.domain.di.IoDispatcher
import kr.loner.domain.model.TimeScheduleGroup
import kr.loner.domain.repository.TimeScheduleRepository
import kr.loner.domain.usecase.base.NonParamCoroutineUseCase


class GetScheduleGroupUseCase(
    private val timeScheduleRepo: TimeScheduleRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : NonParamCoroutineUseCase<TimeScheduleGroup>(dispatcher) {
    override suspend fun execute(): TimeScheduleGroup = timeScheduleRepo.getScheduleGroup()

}