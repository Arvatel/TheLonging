package hallway.microActions

import engine.MicroAction

class ReceivePackage : MicroAction {
    override fun isInterrupted(): Boolean {
        return false
    }

    override fun getDescription(): String {
        return "ReceivePackage: "
    }
}