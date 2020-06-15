package kitchen.cookingMicroActions

import engine.MicroAction

class OpenFrige : MicroAction {
    override fun isInterrupted(): Boolean {
        return false
    }

    override fun getDescription(): String {
        return "OpenFrige: Открыть холодльник"
    }
}