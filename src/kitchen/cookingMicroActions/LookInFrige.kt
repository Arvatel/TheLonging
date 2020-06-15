package kitchen.cookingMicroActions

import engine.MicroAction

class LookInFrige : MicroAction {
    override fun isInterrupted(): Boolean {
        return true
    }

    override fun getDescription(): String {
        return "LookInFrige"
    }
}