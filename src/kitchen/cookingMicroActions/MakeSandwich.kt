package kitchen.cookingMicroActions

import engine.MicroAction

class MakeSandwich : MicroAction {
    override fun isInterrupted(): Boolean {
        return false
    }

    override fun getDescription(): String {
        return "MakeSandwich: "
    }
}