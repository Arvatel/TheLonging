package kitchen.cookingMicroActions

import engine.MicroAction

class CleanAfterEating : MicroAction {
    override fun isInterrupted(): Boolean {
        return true
    }

    override fun getDescription(): String {
        return "CleanAfterEating"
    }

}