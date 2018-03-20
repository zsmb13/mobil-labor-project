package hu.bme.aut.stewe.rebrickableclient.ui.sets

import hu.bme.aut.stewe.rebrickableclient.injector
import hu.bme.aut.stewe.rebrickableclient.network.swagger.api.UsersApi
import hu.bme.aut.stewe.rebrickableclient.ui.TaskPresenter
import javax.inject.Inject


class SetsPresenter(
        @Inject
        var usersApi: UsersApi
) : TaskPresenter<SetsScreen>() {
    init {
        injector.inject(this)
    }

    fun getSets(setListId:String){
        // TODO get data from service or DB
        // TODO screen?.showSets()
    }
}