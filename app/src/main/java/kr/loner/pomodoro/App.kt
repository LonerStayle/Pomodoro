package kr.loner.pomodoro

import android.app.Application
import kotlinx.coroutines.CoroutineDispatcher
import kr.loner.domain.usecase.base.UseCase
import kr.loner.service_locator.KeyUseCase
import kr.loner.service_locator.ServiceLocator

class App : Application() {
    inline fun <reified R : UseCase> getUseCase(
        key: KeyUseCase,
        dispatcher: CoroutineDispatcher
    ): R = ServiceLocator.providerUseCase(key, this, dispatcher) as R

}