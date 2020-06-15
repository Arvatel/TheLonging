package kitchen.cookingMicroActions

import engine.MicroAction

class CleanTableAfterCooking : MicroAction {
    override fun isInterrupted(): Boolean {
        return true
    }

    override fun getDescription(): String {
        return "CleanTableAfterCooking"
    }
}