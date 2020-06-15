package hallway.microActions

import engine.MicroAction

class PutPackage : MicroAction {
    override fun isInterrupted(): Boolean {
        return false
    }

    override fun getDescription(): String {
        return "PutPackage: "
    }
}