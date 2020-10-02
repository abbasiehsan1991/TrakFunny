package esi.app.trakfunny.domain.mapper


interface BaseMapper<in T, out R> {

    fun map(input: T): R

}