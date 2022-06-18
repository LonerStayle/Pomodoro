package kr.loner.domain.usecase.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class NonParamCoroutineUseCase<R>(private val coroutineDispatcher: CoroutineDispatcher):UseCase {
    suspend operator fun invoke(): Result<R> = try {
        withContext(coroutineDispatcher) {
            execute().let {
                Result.success(it)
            }
        }
    } catch (e: Exception) {
        Result.failure(e)
    }

    protected abstract suspend fun execute(): R
}
