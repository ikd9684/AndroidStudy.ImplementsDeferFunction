package app.ikd9684.android.study.implements_defer_function.utils.core

class Deferrer {
    private val actions = mutableListOf<() -> Unit>()

    fun defer(f: () -> Unit) {
        actions.add(f)
    }

    fun done() {
        actions.reverse()
        for (action in actions) {
            action()
        }
    }
}

inline fun <T> withDefers(body: Deferrer.() -> T): T {
    val deferrer = Deferrer()
    val result = deferrer.body()
    deferrer.done()
    return result
}
