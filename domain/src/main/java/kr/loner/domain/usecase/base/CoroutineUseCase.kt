package kr.loner.domain.usecase.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class CoroutineUseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher):UseCase {
    suspend operator fun invoke(param: P): Result<R> = try {
        withContext(coroutineDispatcher) {
            execute(param).let {
                Result.success(it)
            }
        }
    } catch (e: Exception) {
        Result.failure(e)
    }

    protected abstract suspend fun execute(param: P): R
}