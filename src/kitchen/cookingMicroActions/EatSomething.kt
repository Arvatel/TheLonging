package kitchen.cookingMicroActions

import engine.MicroAction

class EatSomething : MicroAction {
    override fun isInterrupted(): Boolean {
        return true
    }

    override fun getDescription(): String {
        return "EatSomething: eating"
    }
}