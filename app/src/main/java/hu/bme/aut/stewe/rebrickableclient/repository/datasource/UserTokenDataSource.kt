package hu.bme.aut.stewe.rebrickableclient.repository.datasource


interface UserTokenDataSource {
    suspend fun getUserToken(): String?

    suspend fun saveUserToken(token: String)

    suspend fun deleteUserToken()
}