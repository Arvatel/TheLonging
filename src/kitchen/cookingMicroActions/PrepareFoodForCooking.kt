package kitchen.cookingMicroActions

import engine.MicroAction

class PrepareFoodForCooking : MicroAction {
    override fun isInterrupted(): Boolean {
        return false
    }

    override fun getDescription(): String {
        return "PrepareFoodForCooking: положить продукты на стол"
    }
}