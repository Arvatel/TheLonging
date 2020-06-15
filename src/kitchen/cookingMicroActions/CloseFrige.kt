package kitchen.cookingMicroActions

import engine.MicroAction

class CloseFrige : MicroAction {
    override fun isInterrupted(): Boolean {
        return false
    }

    override fun getDescription(): String {
        return "CloseFrige: Закрыть холодильник"
    }
}