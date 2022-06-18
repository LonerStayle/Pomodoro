package kr.loner.domain.usecase.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class NonReturnCoroutineUseCase<in P>(private val dispatcher: CoroutineDispatcher) {
    suspend operator fun invoke(param: P) {
        withContext(dispatcher) {
            execute(param)
        }
    }

    protected abstract suspend fun execute(param: P)
}