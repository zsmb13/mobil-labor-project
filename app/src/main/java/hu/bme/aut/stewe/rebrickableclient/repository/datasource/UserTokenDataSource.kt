package hu.bme.aut.stewe.rebrickableclient.repository.datasource


interface UserTokenDataSource {
    fun getUserToken(): String?

    fun saveUserToken(token: String)

    fun deleteUserToken()
}