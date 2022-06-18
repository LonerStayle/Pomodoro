package kr.loner.service_locator

import android.content.Context
import kotlinx.coroutines.CoroutineDispatcher
import kr.loner.data.local.db.TimeScheduleDataBase
import kr.loner.data.repositoryimpl.TimeScheduleRepositoryImpl
import kr.loner.domain.repository.TimeScheduleRepository
import kr.loner.domain.usecase.*
import kr.loner.domain.usecase.base.UseCase

object ServiceLocator {
    private var database: TimeScheduleDataBase? = null
    private var timeScheduleRepository: TimeScheduleRepository? = null
    private val useCaseGroup = hashMapOf<KeyUseCase, UseCase>()


    private fun createTimeScheduleDataBase(context: Context): TimeScheduleDataBase {
        val buildDb = TimeScheduleDataBase.getInstance(context)
        database = buildDb
        return buildDb
    }

    private fun createTimeScheduleRepository(context: Context): TimeScheduleRepository {
        val db = database ?: createTimeScheduleDataBase(context)
        val buildRepo = TimeScheduleRepositoryImpl(db.timeScheduleDao())
        timeScheduleRepository = TimeScheduleRepositoryImpl(db.timeScheduleDao())
        return buildRepo
    }

    private fun createUseCase(
        context: Context,
        key: KeyUseCase,
        dispatcher: CoroutineDispatcher
    ): UseCase {
        val timeRepo = timeScheduleRepository ?: createTimeScheduleRepository(context)
        val useCase = when (key) {
            KeyUseCase.CREATE_SCHEDULE_USE_CASE -> CreateScheduleUseCase(timeRepo, dispatcher)
            KeyUseCase.DELETE_SCHEDULE_USE_CASE -> DeleteScheduleUseCase(timeRepo, dispatcher)
            KeyUseCase.GET_SCHEDULE_GROUP_USE_CASE -> GetScheduleUseCase(timeRepo, dispatcher)
            KeyUseCase.GET_SCHEDULE_USE_CASE -> GetScheduleGroupUseCase(timeRepo, dispatcher)
            KeyUseCase.UP_DATE_SCHEDULE_USE_CASE -> UpdateScheduleUseCase(timeRepo, dispatcher)
        }
        useCaseGroup[key] = useCase
        return useCase
    }

    fun getUseCase(key: KeyUseCase, context: Context, dispatcher: CoroutineDispatcher): UseCase {
        return useCaseGroup[key] ?: createUseCase(context, key, dispatcher)
    }


    enum class KeyUseCase {
        CREATE_SCHEDULE_USE_CASE,
        DELETE_SCHEDULE_USE_CASE,
        GET_SCHEDULE_GROUP_USE_CASE,
        GET_SCHEDULE_USE_CASE,
        UP_DATE_SCHEDULE_USE_CASE,
    }

}