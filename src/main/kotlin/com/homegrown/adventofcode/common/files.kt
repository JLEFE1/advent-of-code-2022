package com.homegrown.adventofcode.common

fun String.readLines() =
    {}::class.java.classLoader.getResourceAsStream(this)?.bufferedReader()?.readLines()
        ?: throw RuntimeException("Could not load file $this as a resource")

fun <T> String.parseWith(parser: (String) -> T): List<T> =
    this.readLines().map(parser)

object Debugging {
    private var debugEnabled = false
    fun <T> T.debug(block: (it: T) -> String) = if(debugEnabled) this.also { println(block(this)) } else this
    fun enable() { debugEnabled = true }
    fun disable() { debugEnabled = false }
    fun <T> withDebugging(block: () -> T) : T {
        enable()
        return block().also { disable() }
    }
}