package hu.bme.aut.stewe.rebrickableclient.repository


interface DataSource<T> {
    fun addItem(item: T)
    fun addItems(items: List<T>)
    fun updateItem(item: T)
    fun updateItems(item: List<T>)
    fun removeItem(item: T)
    fun removeAll()
}