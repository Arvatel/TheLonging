package kitchen.cookingMicroActions

import engine.MicroAction

class CutFood : MicroAction {
    override fun isInterrupted(): Boolean {
        return true
    }

    override fun getDescription(): String {
        return "CutFood: "
    }

}